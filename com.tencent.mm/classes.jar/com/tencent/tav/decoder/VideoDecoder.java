package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.DefaultDecoderFactory;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.codec.IMediaCodec;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMPerformance;
import com.tencent.tav.coremedia.CMPerformance.CMPerformanceStage;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.report.AverageTimeReporter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VideoDecoder
  implements IVideoDecoder
{
  private static final int MAX_WAIT_TIME = 1000;
  public final String TAG;
  private List<Long> allFrameTime;
  private MediaCodec.BufferInfo bufferInfo;
  private VideoCropInfo cropInfo;
  private CMSampleState currentDecoderState;
  private CMSampleState currentStartState;
  private final AverageTimeReporter decodeReporter;
  private IDecoderFactory decoderFactory;
  private CMTime duration;
  private AssetExtractor extractor;
  private boolean extractorDone;
  private long frameDurationUs;
  boolean isReleased;
  boolean lastFrameValid;
  private int lastOutputBufferIndex;
  private long mLastVideoQueueTime;
  private long mTimeOffset;
  private IMediaCodec mediaCodecWrapper;
  private MediaFormat mediaFormat;
  private AssetExtractor mirrorExtractor;
  private ByteBuffer outputBuffer;
  private Surface outputSurface;
  private CMTime pFrameTime;
  private ArrayList<PendingFrame> pendingFrames;
  private long preReadCost;
  private CMTime preReadTime;
  private boolean readSampleFinish;
  private boolean started;
  private CMTimeRange timeRange;
  private int trackIndex;
  private VideoTexture videoTexture;
  
  public VideoDecoder(String paramString)
  {
    this(paramString, null, null, null);
  }
  
  public VideoDecoder(String paramString, Surface paramSurface, VideoTexture paramVideoTexture, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(216018);
    this.TAG = ("VideoDecoder@" + Integer.toHexString(hashCode()));
    this.frameDurationUs = 33333L;
    this.duration = CMTime.CMTimeZero;
    this.pFrameTime = new CMTime(20L, 600);
    this.trackIndex = -1;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.outputBuffer = null;
    this.currentDecoderState = new CMSampleState();
    this.preReadTime = CMTime.CMTimeInvalid;
    this.pendingFrames = new ArrayList();
    this.allFrameTime = new ArrayList();
    this.isReleased = false;
    this.started = false;
    this.lastFrameValid = false;
    this.lastOutputBufferIndex = -1;
    this.preReadCost = 0L;
    this.decodeReporter = new AverageTimeReporter();
    this.mTimeOffset = 10000000L;
    this.mLastVideoQueueTime = 0L;
    this.currentStartState = new CMSampleState();
    this.extractorDone = false;
    this.readSampleFinish = false;
    Logger.d(this.TAG, "create VideoDecoder start");
    if (paramIDecoderFactory != null) {}
    long l;
    for (this.decoderFactory = paramIDecoderFactory;; this.decoderFactory = new DefaultDecoderFactory())
    {
      if (paramSurface != null) {
        this.outputSurface = paramSurface;
      }
      if (paramVideoTexture != null) {
        this.videoTexture = paramVideoTexture;
      }
      l = System.currentTimeMillis();
      if (initExtractor(paramString)) {
        break;
      }
      AppMethodBeat.o(216018);
      return;
    }
    createMirrorExtractor();
    this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
    this.duration = new CMTime((float)this.extractor.getDuration() * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
    if (this.mediaFormat.containsKey("frame-rate"))
    {
      int i = this.mediaFormat.getInteger("frame-rate");
      this.pFrameTime = new CMTime(600 / i, 600);
      this.frameDurationUs = (1000000 / i);
    }
    paramVideoTexture = this.mediaFormat.getString("mime");
    this.mediaCodecWrapper = this.decoderFactory.createVideoDecoder(paramVideoTexture);
    this.mediaCodecWrapper.setDataSource(paramString);
    this.mediaCodecWrapper.configure(this.mediaFormat, paramSurface, null, 0);
    this.mediaCodecWrapper.bindSurfaceTexture(this.videoTexture.surfaceTexture());
    this.mediaCodecWrapper.start();
    Logger.d(this.TAG, "create VideoDecoder end " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(216018);
  }
  
  private void clearDecoder()
  {
    AppMethodBeat.i(216168);
    Logger.d(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.mediaCodecWrapper.flush();
      this.pendingFrames.clear();
      this.currentDecoderState = new CMSampleState();
      AppMethodBeat.o(216168);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "flushDecoder", localException);
      }
    }
  }
  
  private void createMirrorExtractor()
  {
    AppMethodBeat.i(216035);
    new Thread()
    {
      public void run()
      {
        AppMethodBeat.i(216091);
        long l2;
        try
        {
          l2 = SystemClock.currentThreadTimeMillis();
          AssetExtractor localAssetExtractor = new AssetExtractor();
          localAssetExtractor.setDataSource(VideoDecoder.this.extractor.getSourcePath());
          while (localAssetExtractor.getSampleTrackIndex() != -1) {
            localAssetExtractor.unselectTrack(localAssetExtractor.getSampleTrackIndex());
          }
          localException.selectTrack(DecoderUtils.getFirstTrackIndex(localException, "video/"));
        }
        catch (Exception localException)
        {
          Logger.e(VideoDecoder.this.TAG, "createMirrorExtractor", localException);
          AppMethodBeat.o(216091);
          return;
        }
        if (VideoDecoder.this.timeRange == null) {}
        ArrayList localArrayList;
        for (long l1 = 0L;; l1 = VideoDecoder.this.timeRange.getStartUs())
        {
          localException.seekTo(l1, 0);
          localArrayList = new ArrayList();
          while (localException.getSampleTime() != -1L)
          {
            localArrayList.add(Long.valueOf(localException.getSampleTime()));
            localException.advance();
          }
        }
        VideoDecoder.this.allFrameTime.addAll(localArrayList);
        VideoDecoder.access$302(VideoDecoder.this, localException);
        Logger.d(VideoDecoder.this.TAG, "Decoder: MirrorExtractor Init " + (SystemClock.currentThreadTimeMillis() - l2));
        AppMethodBeat.o(216091);
      }
    }.start();
    AppMethodBeat.o(216035);
  }
  
  private void doReadFrames(SampleTime paramSampleTime, CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(216128);
    long l = System.currentTimeMillis();
    Logger.v(this.TAG, "doReadFrames() called with: sampleTime = [" + paramSampleTime + "], targetTime = [" + paramCMTime + "], justCache = [" + paramBoolean + "]");
    if ((this.pendingFrames.size() == 0) && (this.extractorDone)) {
      Logger.i(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
    }
    int i = 0;
    label786:
    label1211:
    label1366:
    label1372:
    label1401:
    for (;;)
    {
      int n;
      Object localObject;
      if ((this.pendingFrames.size() > 0) || (!this.extractorDone))
      {
        if (!this.extractorDone) {
          paramSampleTime.sampleState.performance = readFromExtractor();
        }
        this.bufferInfo.set(0, 0, 0L, 0);
        n = this.mediaCodecWrapper.dequeueOutputBuffer(this.bufferInfo, 1000L);
        Trace.endSection();
        Logger.v(this.TAG, "doReadFrames outputBufferIndex:" + n + ", presentationTimeUs:" + this.bufferInfo.presentationTimeUs);
        if ((this.bufferInfo.flags & 0x4) != 0)
        {
          if ((this.bufferInfo.size > 0) && (n >= 0) && (this.pendingFrames.size() > 0))
          {
            this.pendingFrames.remove(0);
            this.mediaCodecWrapper.releaseOutputBuffer(n, true);
          }
          Logger.i(this.TAG, "doReadFrames:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-1L));
          AppMethodBeat.o(216128);
          return;
        }
        if (n == -2)
        {
          localObject = this.mediaCodecWrapper.getOutputFormat();
          this.cropInfo = new VideoCropInfo();
          if ((((MediaFormat)localObject).containsKey("width")) && (((MediaFormat)localObject).containsKey("height")))
          {
            this.cropInfo.width = ((MediaFormat)localObject).getInteger("width");
            this.cropInfo.height = ((MediaFormat)localObject).getInteger("height");
          }
          if ((((MediaFormat)localObject).containsKey("crop-left")) && (((MediaFormat)localObject).containsKey("crop-right")) && (((MediaFormat)localObject).containsKey("crop-top")) && (((MediaFormat)localObject).containsKey("crop-bottom")))
          {
            this.cropInfo.cropLeft = ((MediaFormat)localObject).getInteger("crop-left");
            this.cropInfo.cropTop = ((MediaFormat)localObject).getInteger("crop-top");
            this.cropInfo.cropRight = (((MediaFormat)localObject).getInteger("crop-right") + 1);
            this.cropInfo.cropBottom = (((MediaFormat)localObject).getInteger("crop-bottom") + 1);
          }
          Logger.i(this.TAG, String.format("newFormat size:[%d,%d], crop:[%d,%d,%d,%d], newFormat:%s", new Object[] { Integer.valueOf(this.cropInfo.width), Integer.valueOf(this.cropInfo.height), Integer.valueOf(this.cropInfo.cropLeft), Integer.valueOf(this.cropInfo.cropTop), Integer.valueOf(this.cropInfo.cropRight), Integer.valueOf(this.cropInfo.cropBottom), localObject }));
          if (this.videoTexture != null) {
            this.videoTexture.setCropInfo(this.cropInfo);
          }
        }
        if ((n >= 0) && (this.pendingFrames.size() > 0)) {
          break label786;
        }
        if (n >= 0)
        {
          Logger.w(this.TAG, "doReadFrames:[failed] pendingFrames.size() == " + this.pendingFrames.size());
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
        }
        i += 1;
        if (i <= 1000) {
          break label1401;
        }
        Logger.e(this.TAG, "doReadFrames: [timeout] ");
        SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-4L));
      }
      for (;;)
      {
        if ((this.extractorDone) && (paramSampleTime.timeUs < 0L) && (!paramBoolean))
        {
          Logger.i(this.TAG, "doReadFrames: extractorDone && sampleTime.timeUs < 0, sampleTime = ".concat(String.valueOf(paramSampleTime)));
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-1L));
        }
        Logger.i(this.TAG, "readFrameCost " + (System.currentTimeMillis() - l));
        AppMethodBeat.o(216128);
        return;
        if (this.bufferInfo.size <= 0)
        {
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          Logger.e(this.TAG, "doReadFrames:[failed] bufferInfo.size == " + this.bufferInfo.size);
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
          break;
        }
        localObject = (PendingFrame)this.pendingFrames.remove(0);
        SampleTime.access$602(paramSampleTime, this.bufferInfo.presentationTimeUs - ((PendingFrame)localObject).timeOffset);
        SampleTime.access$502(paramSampleTime, new CMSampleState(new CMTime((float)paramSampleTime.timeUs * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L))).inherit(paramSampleTime.sampleState));
        if ((this.pendingFrames.isEmpty()) && (this.extractorDone)) {}
        for (int j = 1;; j = 0)
        {
          if ((j != 0) || (((PendingFrame)localObject).seekStartTime.getTimeUs() <= paramSampleTime.timeUs + this.frameDurationUs / 2L)) {
            break label1017;
          }
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          Logger.v(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
          break;
        }
        label1017:
        if ((this.outputSurface == null) || (paramBoolean))
        {
          this.lastOutputBufferIndex = n;
          paramCMTime = this.mediaCodecWrapper.getOutputBuffer(n);
          if (paramCMTime != null)
          {
            paramCMTime.position(this.bufferInfo.offset);
            paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
            this.outputBuffer = paramCMTime;
            SampleTime.access$900(paramSampleTime);
          }
          else
          {
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            Logger.e(this.TAG, "doReadFrames:[error] " + this.bufferInfo.size + " byteBuffer==null");
            SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-3L));
            AppMethodBeat.o(216128);
          }
        }
        else
        {
          if (j != 0) {
            SampleTime.access$502(paramSampleTime, new CMSampleState(this.duration));
          }
          int k;
          if (paramCMTime.getTimeUs() - paramSampleTime.sampleState.getTime().getTimeUs() <= this.frameDurationUs / 2L)
          {
            k = 1;
            if (paramCMTime.getTimeUs() < this.duration.getTimeUs()) {
              break label1366;
            }
          }
          for (int m = 1;; m = 0)
          {
            if ((k != 0) || (m != 0) || (j != 0)) {
              break label1372;
            }
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            Logger.v(this.TAG, "doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == " + (paramCMTime.getTimeUs() - paramSampleTime.sampleState.getTime().getTimeUs()) + " targetTime = " + paramCMTime + "  duration = " + this.duration + " pendingFrames.size() = " + this.pendingFrames.size() + " extractorDone = " + this.extractorDone);
            SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
            break;
            k = 0;
            break label1211;
          }
          this.mediaCodecWrapper.releaseOutputBuffer(n, true);
          paramSampleTime.sampleState.performance.markEnd();
          SampleTime.access$900(paramSampleTime);
        }
      }
    }
  }
  
  private CMSampleState doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216099);
        if ((paramCMTime.bigThan(this.timeRange.getDuration())) && (!paramBoolean))
        {
          Logger.i(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + paramCMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache istrue");
          paramCMTime = CMSampleState.fromError(-1L);
          AppMethodBeat.o(216099);
          return paramCMTime;
        }
        if ((this.extractorDone) && (this.pendingFrames.size() == 0) && (this.timeRange.containsTime(paramCMTime)) && (!this.readSampleFinish)) {
          Logger.w(this.TAG, "error state , and will go correct it ! ");
        }
        this.preReadTime = CMTime.CMTimeInvalid;
        if ((this.started) && (this.trackIndex != -1)) {
          break label246;
        }
        paramCMTime = this.TAG;
        localObject = new StringBuilder("doReadSample:[unStart]  !started || trackIndex == -1 ");
        if (!this.started)
        {
          paramBoolean = true;
          localObject = ((StringBuilder)localObject).append(paramBoolean).append(" - ");
          if (this.trackIndex != -1) {
            break label241;
          }
          paramBoolean = bool;
          Logger.e(paramCMTime, paramBoolean);
          paramCMTime = CMSampleState.fromError(-100L);
          AppMethodBeat.o(216099);
          continue;
        }
        paramBoolean = false;
      }
      finally {}
      continue;
      label241:
      paramBoolean = false;
      continue;
      label246:
      releaseOutputBuffer();
      Object localObject = new SampleTime(null);
      SampleTime.access$502((SampleTime)localObject, CMSampleState.fromError(-2L));
      SampleTime.access$602((SampleTime)localObject, -2L);
      try
      {
        long l1 = System.currentTimeMillis();
        doReadFrames((SampleTime)localObject, paramCMTime, paramBoolean);
        long l2 = System.currentTimeMillis();
        this.decodeReporter.add(l2 - l1);
        Logger.v(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + ((SampleTime)localObject).timeUs + "  " + ((SampleTime)localObject).sampleState);
        paramCMTime = ((SampleTime)localObject).sampleState;
        AppMethodBeat.o(216099);
      }
      catch (Exception paramCMTime)
      {
        paramCMTime = onReadFramesException(paramCMTime);
        AppMethodBeat.o(216099);
      }
    }
  }
  
  private boolean hasPreReadAndFirstFrameSeek(CMTime paramCMTime)
  {
    AppMethodBeat.i(216056);
    if ((paramCMTime == CMTime.CMTimeZero) && (this.preReadTime != CMTime.CMTimeInvalid) && (this.lastOutputBufferIndex != -1) && (!this.currentDecoderState.isInvalid()))
    {
      AppMethodBeat.o(216056);
      return true;
    }
    AppMethodBeat.o(216056);
    return false;
  }
  
  private boolean initExtractor(String paramString)
  {
    AppMethodBeat.i(216028);
    this.extractor = new AssetExtractor();
    this.extractor.setDataSource(paramString);
    while (this.extractor.getSampleTrackIndex() != -1) {
      this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "video/");
    if (this.trackIndex == -1)
    {
      this.outputSurface = null;
      this.outputBuffer = null;
      AppMethodBeat.o(216028);
      return false;
    }
    this.extractor.selectTrack(this.trackIndex);
    AppMethodBeat.o(216028);
    return true;
  }
  
  private boolean moreCloseCurrentThenSeek(CMTime paramCMTime)
  {
    AppMethodBeat.i(216044);
    if (this.mirrorExtractor != null)
    {
      long l1 = this.currentDecoderState.getTime().getTimeUs();
      this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 2);
      if (this.mirrorExtractor.getSampleTime() > paramCMTime.getTimeUs()) {
        this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 0);
      }
      long l2 = this.mirrorExtractor.getSampleTime();
      if ((l2 <= l1) && (this.currentDecoderState.getTime().getTimeUs() >= l2) && (this.currentDecoderState.getTime().getTimeUs() < paramCMTime.getTimeUs() + this.pFrameTime.getTimeUs()) && (l1 <= paramCMTime.getTimeUs()))
      {
        AppMethodBeat.o(216044);
        return true;
      }
      AppMethodBeat.o(216044);
      return false;
    }
    AppMethodBeat.o(216044);
    return false;
  }
  
  private CMSampleState onReadFramesException(Exception paramException)
  {
    AppMethodBeat.i(216137);
    Logger.e(this.TAG, "onReadFramesException: ", paramException);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramException = CMSampleState.fromError(-3L);
      AppMethodBeat.o(216137);
      return paramException;
    }
    if (!(paramException instanceof MediaCodec.CodecException))
    {
      paramException = CMSampleState.fromError(-3L);
      AppMethodBeat.o(216137);
      return paramException;
    }
    if (((MediaCodec.CodecException)paramException).isRecoverable())
    {
      releaseOutputBuffer();
      this.mediaCodecWrapper.reset();
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartState.getTime().getTimeUs();
      long l2 = this.timeRange.getStartUs();
      this.extractor.seekTo(l1 - l2, 0);
      this.extractorDone = false;
      paramException = CMSampleState.fromError(-3L);
      AppMethodBeat.o(216137);
      return paramException;
    }
    if (((MediaCodec.CodecException)paramException).isTransient()) {
      Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    paramException = CMSampleState.fromError(-3L);
    AppMethodBeat.o(216137);
    return paramException;
  }
  
  private void preReadSample()
  {
    try
    {
      AppMethodBeat.i(216085);
      this.lastFrameValid = false;
      this.currentDecoderState = doReadSample(CMTime.CMTimeInvalid, true);
      if (!this.currentDecoderState.getTime().smallThan(CMTime.CMTimeZero)) {
        this.currentDecoderState = this.currentStartState;
      }
      this.preReadTime = this.currentDecoderState.getTime();
      Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
      AppMethodBeat.o(216085);
      return;
    }
    finally {}
  }
  
  /* Error */
  private CMPerformance readFromExtractor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 699
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 216	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   12: invokevirtual 659	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   15: lstore_2
    //   16: aload_0
    //   17: getfield 110	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   20: new 86	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 701
    //   27: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: lload_2
    //   31: invokevirtual 293	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: ldc_w 703
    //   37: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 299	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   44: invokevirtual 706	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   47: invokevirtual 293	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: ldc_w 708
    //   53: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 216	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   60: invokevirtual 637	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   63: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 359	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: lload_2
    //   73: aload_0
    //   74: getfield 299	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   77: invokevirtual 706	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   80: lcmp
    //   81: ifge +22 -> 103
    //   84: aload_0
    //   85: getfield 216	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   88: invokevirtual 637	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   91: iconst_m1
    //   92: if_icmpeq +11 -> 103
    //   95: lload_2
    //   96: ldc2_w 415
    //   99: lcmp
    //   100: ifne +94 -> 194
    //   103: new 578	com/tencent/tav/coremedia/CMPerformance
    //   106: dup
    //   107: invokespecial 709	com/tencent/tav/coremedia/CMPerformance:<init>	()V
    //   110: astore 4
    //   112: lload_2
    //   113: aload_0
    //   114: getfield 299	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   117: invokevirtual 706	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   120: lcmp
    //   121: iflt +9 -> 130
    //   124: aload_0
    //   125: invokespecial 712	com/tencent/tav/decoder/VideoDecoder:readSampleData	()Lcom/tencent/tav/coremedia/CMPerformance;
    //   128: astore 4
    //   130: aload_0
    //   131: getfield 266	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/codec/IMediaCodec;
    //   134: ldc2_w 380
    //   137: invokeinterface 716 3 0
    //   142: istore_1
    //   143: iload_1
    //   144: iflt +39 -> 183
    //   147: aload_0
    //   148: getfield 110	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   151: ldc_w 718
    //   154: lload_2
    //   155: invokestatic 721	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   158: invokevirtual 502	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 359	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_0
    //   165: getfield 266	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/codec/IMediaCodec;
    //   168: iload_1
    //   169: iconst_0
    //   170: iconst_0
    //   171: lconst_0
    //   172: iconst_4
    //   173: invokeinterface 725 7 0
    //   178: aload_0
    //   179: iconst_1
    //   180: putfield 179	com/tencent/tav/decoder/VideoDecoder:extractorDone	Z
    //   183: ldc_w 699
    //   186: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_0
    //   190: monitorexit
    //   191: aload 4
    //   193: areturn
    //   194: aload_0
    //   195: invokespecial 712	com/tencent/tav/decoder/VideoDecoder:readSampleData	()Lcom/tencent/tav/coremedia/CMPerformance;
    //   198: astore 4
    //   200: ldc_w 699
    //   203: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: goto -17 -> 189
    //   209: astore 4
    //   211: aload_0
    //   212: monitorexit
    //   213: aload 4
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	VideoDecoder
    //   142	27	1	i	int
    //   15	140	2	l	long
    //   110	89	4	localCMPerformance	CMPerformance
    //   209	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	95	209	finally
    //   103	112	209	finally
    //   112	130	209	finally
    //   130	143	209	finally
    //   147	183	209	finally
    //   183	189	209	finally
    //   194	206	209	finally
  }
  
  private CMPerformance readSampleData()
  {
    AppMethodBeat.i(216159);
    long l = this.extractor.getSampleTime();
    Object localObject2 = new CMPerformance(CMPerformance.CMPerformanceStage.DECODE_WAIT);
    ((CMPerformance)localObject2).markStart();
    Trace.beginSection("decode-wait");
    int i = this.mediaCodecWrapper.dequeueInputBuffer(1000L);
    Trace.endSection();
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      ((CMPerformance)localObject2).markEnd();
      localObject1 = new CMPerformance(CMPerformance.CMPerformanceStage.EXTRACTOR);
      ((CMPerformance)localObject1).addPreNode((CMPerformance)localObject2);
      ((CMPerformance)localObject1).markStart();
      localObject2 = this.mediaCodecWrapper.getInputBuffer(i);
      int j = this.extractor.readSampleData((ByteBuffer)localObject2, 0);
      ((CMPerformance)localObject1).markEnd();
      if (j < 0) {
        break label272;
      }
      this.mLastVideoQueueTime = (l - this.timeRange.getStartUs() + this.mTimeOffset);
      Logger.v(this.TAG, "doReadFrames readSampleData queueInputBuffer sampleTime:".concat(String.valueOf(l)));
      this.mediaCodecWrapper.queueInputBuffer(i, 0, j, this.mLastVideoQueueTime, 0);
      Trace.beginSection("decode");
      localObject2 = new CMPerformance(CMPerformance.CMPerformanceStage.DECODE);
      ((CMPerformance)localObject2).preNodes.add(localObject1);
      ((CMPerformance)localObject2).markStart();
      localObject1 = new PendingFrame(null);
      PendingFrame.access$702((PendingFrame)localObject1, this.mTimeOffset);
      PendingFrame.access$802((PendingFrame)localObject1, this.currentStartState.getTime());
      this.pendingFrames.add(localObject1);
      localObject1 = localObject2;
    }
    label272:
    for (;;)
    {
      this.extractor.advance();
      AppMethodBeat.o(216159);
      return localObject1;
    }
  }
  
  private CMSampleState renderCacheBuffer()
  {
    AppMethodBeat.i(216075);
    Logger.v(this.TAG, "renderCacheBuffer: cache hit - " + this.currentDecoderState);
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if (this.currentDecoderState.getTime().bigThan(this.timeRange.getEnd()))
      {
        this.currentDecoderState = CMSampleState.fromError(-1L);
        this.pendingFrames.clear();
        this.extractorDone = true;
      }
      this.currentDecoderState.performance.stage = CMPerformance.CMPerformanceStage.DECODE_CACHE;
      CMSampleState localCMSampleState1 = this.currentDecoderState;
      AppMethodBeat.o(216075);
      return localCMSampleState1;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "renderCacheBuffer: ", localException);
      CMSampleState localCMSampleState2 = CMSampleState.fromError(-2L);
      AppMethodBeat.o(216075);
      return localCMSampleState2;
    }
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(216066);
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      AppMethodBeat.o(216066);
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(216376);
    super.finalize();
    release(false);
    AppMethodBeat.o(216376);
  }
  
  public VideoCropInfo getCropInfo()
  {
    return this.cropInfo;
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    return this.decodeReporter;
  }
  
  public long getPreReadCost()
  {
    return this.preReadCost;
  }
  
  public String getSourcePath()
  {
    AppMethodBeat.i(216329);
    if (this.extractor == null)
    {
      AppMethodBeat.o(216329);
      return null;
    }
    String str = this.extractor.getSourcePath();
    AppMethodBeat.o(216329);
    return str;
  }
  
  public TextureInfo getTextureInfo()
  {
    return null;
  }
  
  /* Error */
  public boolean hasTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/tencent/tav/decoder/VideoDecoder:trackIndex	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_m1
    //   9: if_icmpeq +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VideoDecoder
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public void init(String paramString, CGSize paramCGSize, IDecoderTrack.SurfaceCreator paramSurfaceCreator) {}
  
  public boolean isLastFrameValid()
  {
    return this.lastFrameValid;
  }
  
  public boolean isStarted()
  {
    return this.started;
  }
  
  public CMTime nextFrameTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(216289);
    long l1 = paramCMTime.getTimeUs();
    paramCMTime = this.allFrameTime.iterator();
    while (paramCMTime.hasNext())
    {
      long l2 = ((Long)paramCMTime.next()).longValue();
      if (l1 < l2)
      {
        paramCMTime = new CMTime((float)l2 / 1000.0F / 1000.0F);
        AppMethodBeat.o(216289);
        return paramCMTime;
      }
    }
    paramCMTime = this.currentDecoderState.getTime().add(this.pFrameTime);
    AppMethodBeat.o(216289);
    return paramCMTime;
  }
  
  public ByteBuffer outputBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this.outputBuffer;
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Surface outputSurface()
  {
    try
    {
      Surface localSurface = this.outputSurface;
      return localSurface;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMSampleState readSample()
  {
    try
    {
      AppMethodBeat.i(216261);
      CMSampleState localCMSampleState = readSample(CMTime.CMTimeInvalid);
      AppMethodBeat.o(216261);
      return localCMSampleState;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMSampleState readSample(CMTime paramCMTime)
  {
    int k = 0;
    for (;;)
    {
      CMSampleState localCMSampleState;
      try
      {
        AppMethodBeat.i(216273);
        Logger.v(this.TAG, "readSample: " + paramCMTime + ", currentDecoderTime = " + this.currentDecoderState + ",  extractor.getSampleTime() = " + this.extractor.getSampleTime() + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
        this.lastFrameValid = false;
        int i;
        if ((outputSurface() != null) && (this.lastOutputBufferIndex != -1))
        {
          i = 1;
          if (!this.currentDecoderState.getTime().smallThan(paramCMTime)) {
            break label413;
          }
          j = k;
          if (this.extractorDone)
          {
            j = k;
            if (this.pendingFrames.isEmpty()) {
              break label413;
            }
          }
          if ((i != 0) && (j != 0))
          {
            paramCMTime = renderCacheBuffer();
            AppMethodBeat.o(216273);
            return paramCMTime;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localCMSampleState = doReadSample(paramCMTime, false);
        if ((!this.currentDecoderState.isInvalid()) && (localCMSampleState.getTime().bigThan(this.timeRange.getDuration())))
        {
          this.currentDecoderState = CMSampleState.fromError(-1L);
          this.pendingFrames.clear();
          this.extractorDone = true;
          Logger.v(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentDecoderState);
          this.readSampleFinish = true;
          paramCMTime = this.currentDecoderState;
          AppMethodBeat.o(216273);
          continue;
        }
        this.currentDecoderState = localCMSampleState;
      }
      finally {}
      if ((this.currentDecoderState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentDecoderState.getTime().smallThan(this.duration))) {
        clearDecoder();
      }
      Logger.v(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + paramCMTime + "  -  " + this.currentDecoderState);
      AppMethodBeat.o(216273);
      paramCMTime = localCMSampleState;
      continue;
      label413:
      int j = 1;
    }
  }
  
  public void release() {}
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 882
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 156	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 882
    //   18: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 110	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 884
    //   31: iload_1
    //   32: invokestatic 887	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   35: invokevirtual 502	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokestatic 363	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 216	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 890	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 216	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: getfield 307	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 307	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   68: invokevirtual 890	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 307	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 158	com/tencent/tav/decoder/VideoDecoder:started	Z
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 156	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   86: aload_0
    //   87: getfield 266	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/codec/IMediaCodec;
    //   90: ifnull +12 -> 102
    //   93: aload_0
    //   94: getfield 266	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/codec/IMediaCodec;
    //   97: invokeinterface 892 1 0
    //   102: aload_0
    //   103: getfield 110	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   106: ldc_w 894
    //   109: iload_1
    //   110: invokestatic 887	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   113: invokevirtual 502	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 363	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 110	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   123: new 86	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 896
    //   130: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 169	com/tencent/tav/decoder/VideoDecoder:decodeReporter	Lcom/tencent/tav/report/AverageTimeReporter;
    //   137: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 363	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc_w 882
    //   149: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: goto -131 -> 21
    //   155: astore_2
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	VideoDecoder
    //   0	160	1	paramBoolean	boolean
    //   155	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	155	finally
    //   24	41	155	finally
    //   45	57	155	finally
    //   57	76	155	finally
    //   76	102	155	finally
    //   102	152	155	finally
  }
  
  void releaseOutputBuffer()
  {
    AppMethodBeat.i(216351);
    if (this.lastOutputBufferIndex != -1) {}
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
      this.outputBuffer = null;
      AppMethodBeat.o(216351);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "releaseOutputBuffer", localException);
      }
    }
  }
  
  public void seekTo(CMTime paramCMTime)
  {
    try
    {
      AppMethodBeat.i(216240);
      seekTo(paramCMTime, true);
      AppMethodBeat.o(216240);
      return;
    }
    finally
    {
      paramCMTime = finally;
      throw paramCMTime;
    }
  }
  
  public void seekTo(CMTime paramCMTime, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216251);
        Logger.v(this.TAG, "seekTo: " + paramCMTime + "  - " + this + "  " + this.currentStartState + "  " + this.currentDecoderState);
        if ((!this.started) || (this.trackIndex == -1))
        {
          Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
          AppMethodBeat.o(216251);
          return;
        }
        CMTime localCMTime = paramCMTime;
        if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
          localCMTime = CMTime.CMTimeZero;
        }
        paramCMTime = this.timeRange.getStart().add(localCMTime);
        if (((paramBoolean) && (moreCloseCurrentThenSeek(localCMTime))) || (localCMTime.equalsTo(this.currentDecoderState.getTime())) || (hasPreReadAndFirstFrameSeek(localCMTime)))
        {
          AppMethodBeat.o(216251);
          continue;
        }
        this.currentStartState = new CMSampleState(localCMTime);
      }
      finally {}
      seekExtractorTo(paramCMTime.getTimeUs());
      this.extractorDone = false;
      Logger.v(this.TAG, "seekTo: finish - " + this.currentStartState + "  " + this.extractor.getSampleTime());
      AppMethodBeat.o(216251);
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(216219);
      start(paramCMTimeRange, CMTime.CMTimeZero);
      AppMethodBeat.o(216219);
      return;
    }
    finally
    {
      paramCMTimeRange = finally;
      throw paramCMTimeRange;
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216232);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          AppMethodBeat.o(216232);
          return;
        }
        clearDecoder();
        if (paramCMTimeRange == null)
        {
          this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
          this.extractorDone = false;
          this.started = true;
          if (paramCMTime.getTimeUs() >= 0L)
          {
            long l = System.currentTimeMillis();
            seekTo(paramCMTime, false);
            preReadSample();
            this.preReadCost = (System.currentTimeMillis() - l);
          }
          AppMethodBeat.o(216232);
        }
        else
        {
          this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
        }
      }
      finally {}
    }
  }
  
  public void switchFrame() {}
  
  static class PendingFrame
  {
    private CMTime seekStartTime = CMTime.CMTimeZero;
    private long timeOffset = 0L;
  }
  
  class SampleTime
  {
    private CMSampleState sampleState;
    private long timeUs;
    
    private SampleTime() {}
    
    private void fixCMTime()
    {
      AppMethodBeat.i(216008);
      if (!this.sampleState.getTime().smallThan(CMTime.CMTimeZero))
      {
        AppMethodBeat.o(216008);
        return;
      }
      this.sampleState = new CMSampleState(CMTime.fromUs(VideoDecoder.this.frameDurationUs));
      AppMethodBeat.o(216008);
    }
    
    public String toString()
    {
      AppMethodBeat.i(216055);
      String str = "SampleTime{sampleState=" + this.sampleState + ", timeUs=" + this.timeUs + '}';
      AppMethodBeat.o(216055);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */