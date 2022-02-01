package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
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
  private CMSampleState currentDecoderState;
  private CMSampleState currentStartState;
  private final AverageTimeReporter decodeReporter;
  private CMTime duration;
  private AssetExtractor extractor;
  private boolean extractorDone;
  private long frameDurationUs;
  boolean isReleased;
  boolean lastFrameValid;
  private int lastOutputBufferIndex;
  private long mLastVideoQueueTime;
  private long mTimeOffset;
  private final MediaCodecWrapper mediaCodecWrapper;
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
  
  public VideoDecoder(String paramString)
  {
    this(paramString, null);
  }
  
  public VideoDecoder(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(191332);
    this.TAG = ("VideoDecoder@" + Integer.toHexString(hashCode()));
    this.frameDurationUs = 33333L;
    this.duration = CMTime.CMTimeZero;
    this.pFrameTime = new CMTime(20L, 600);
    this.trackIndex = -1;
    this.mediaCodecWrapper = new MediaCodecWrapper(this);
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
    if (paramSurface != null) {
      this.outputSurface = paramSurface;
    }
    long l = System.currentTimeMillis();
    if (!initExtractor(paramString))
    {
      AppMethodBeat.o(191332);
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
    if (this.mediaCodecWrapper.decoderConfigure(this.mediaFormat, paramSurface))
    {
      this.mediaCodecWrapper.startDecoder(paramSurface, this.mediaFormat);
      Logger.d(this.TAG, "create VideoDecoder end " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(191332);
      return;
    }
    paramString = new IllegalStateException("decoderConfigure failed!");
    AppMethodBeat.o(191332);
    throw paramString;
  }
  
  private void clearDecoder()
  {
    AppMethodBeat.i(191421);
    Logger.d(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.mediaCodecWrapper.flushDecoder();
      this.pendingFrames.clear();
      this.currentDecoderState = new CMSampleState();
      AppMethodBeat.o(191421);
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
    AppMethodBeat.i(191339);
    new Thread()
    {
      public void run()
      {
        AppMethodBeat.i(191285);
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
          AppMethodBeat.o(191285);
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
        AppMethodBeat.o(191285);
      }
    }.start();
    AppMethodBeat.o(191339);
  }
  
  private void doReadFrames(SampleTime paramSampleTime, CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(191401);
    Logger.v(this.TAG, "doReadFrames() called with: sampleTime = [" + paramSampleTime + "], targetTime = [" + paramCMTime + "], justCache = [" + paramBoolean + "]");
    if ((this.pendingFrames.size() == 0) && (this.extractorDone)) {
      Logger.i(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
    }
    int i = 0;
    label424:
    label834:
    label987:
    label993:
    label1010:
    for (;;)
    {
      int n;
      if ((this.pendingFrames.size() > 0) || (!this.extractorDone))
      {
        if (!this.extractorDone) {
          readFromExtractor();
        }
        this.bufferInfo.set(0, 0, 0L, 0);
        n = this.mediaCodecWrapper.dequeueOutputBuffer(this.bufferInfo);
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
          AppMethodBeat.o(191401);
          return;
        }
        if ((n >= 0) && (this.pendingFrames.size() > 0)) {
          break label424;
        }
        if (n >= 0)
        {
          Logger.w(this.TAG, "doReadFrames:[failed] pendingFrames.size() == " + this.pendingFrames.size());
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
        }
        i += 1;
        if (i <= 1000) {
          break label1010;
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
        AppMethodBeat.o(191401);
        return;
        if (this.bufferInfo.size <= 0)
        {
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          Logger.e(this.TAG, "doReadFrames:[failed] bufferInfo.size == " + this.bufferInfo.size);
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
          break;
        }
        PendingFrame localPendingFrame = (PendingFrame)this.pendingFrames.remove(0);
        SampleTime.access$602(paramSampleTime, this.bufferInfo.presentationTimeUs - localPendingFrame.timeOffset);
        SampleTime.access$502(paramSampleTime, new CMSampleState(new CMTime((float)paramSampleTime.timeUs * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L))));
        if ((this.pendingFrames.isEmpty()) && (this.extractorDone)) {}
        for (int j = 1;; j = 0)
        {
          if ((j != 0) || (localPendingFrame.seekStartTime.getTimeUs() <= paramSampleTime.timeUs + this.frameDurationUs / 2L)) {
            break label644;
          }
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          Logger.v(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
          SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
          break;
        }
        if ((this.outputSurface == null) || (paramBoolean))
        {
          this.lastOutputBufferIndex = n;
          paramCMTime = this.mediaCodecWrapper.getOnputBuffer(n);
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
            AppMethodBeat.o(191401);
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
              break label987;
            }
          }
          for (int m = 1;; m = 0)
          {
            if ((k != 0) || (m != 0) || (j != 0)) {
              break label993;
            }
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            Logger.v(this.TAG, "doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == " + (paramCMTime.getTimeUs() - paramSampleTime.sampleState.getTime().getTimeUs()) + " targetTime = " + paramCMTime + "  duration = " + this.duration + " pendingFrames.size() = " + this.pendingFrames.size() + " extractorDone = " + this.extractorDone);
            SampleTime.access$502(paramSampleTime, CMSampleState.fromError(-2L));
            break;
            k = 0;
            break label834;
          }
          this.mediaCodecWrapper.releaseOutputBuffer(n, true);
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
        AppMethodBeat.i(191393);
        if ((paramCMTime.bigThan(this.timeRange.getDuration())) && (!paramBoolean))
        {
          Logger.i(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + paramCMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache istrue");
          paramCMTime = CMSampleState.fromError(-1L);
          AppMethodBeat.o(191393);
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
          AppMethodBeat.o(191393);
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
        AppMethodBeat.o(191393);
      }
      catch (Exception paramCMTime)
      {
        paramCMTime = onReadFramesException(paramCMTime);
        AppMethodBeat.o(191393);
      }
    }
  }
  
  private boolean hasPreReadAndFirstFrameSeek(CMTime paramCMTime)
  {
    AppMethodBeat.i(191364);
    if ((paramCMTime == CMTime.CMTimeZero) && (this.preReadTime != CMTime.CMTimeInvalid) && (this.lastOutputBufferIndex != -1) && (!this.currentDecoderState.isInvalid()))
    {
      AppMethodBeat.o(191364);
      return true;
    }
    AppMethodBeat.o(191364);
    return false;
  }
  
  private boolean initExtractor(String paramString)
  {
    AppMethodBeat.i(191335);
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
      AppMethodBeat.o(191335);
      return false;
    }
    this.extractor.selectTrack(this.trackIndex);
    AppMethodBeat.o(191335);
    return true;
  }
  
  private boolean moreCloseCurrentThenSeek(CMTime paramCMTime)
  {
    AppMethodBeat.i(191362);
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
        AppMethodBeat.o(191362);
        return true;
      }
      AppMethodBeat.o(191362);
      return false;
    }
    AppMethodBeat.o(191362);
    return false;
  }
  
  private CMSampleState onReadFramesException(Exception paramException)
  {
    AppMethodBeat.i(191404);
    Logger.e(this.TAG, "onReadFramesException: ", paramException);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramException = CMSampleState.fromError(-3L);
      AppMethodBeat.o(191404);
      return paramException;
    }
    if (!(paramException instanceof MediaCodec.CodecException))
    {
      paramException = CMSampleState.fromError(-3L);
      AppMethodBeat.o(191404);
      return paramException;
    }
    if (((MediaCodec.CodecException)paramException).isRecoverable())
    {
      releaseOutputBuffer();
      this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartState.getTime().getTimeUs();
      long l2 = this.timeRange.getStartUs();
      this.extractor.seekTo(l1 - l2, 0);
      this.extractorDone = false;
      paramException = CMSampleState.fromError(-3L);
      AppMethodBeat.o(191404);
      return paramException;
    }
    if (((MediaCodec.CodecException)paramException).isTransient()) {
      Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    paramException = CMSampleState.fromError(-3L);
    AppMethodBeat.o(191404);
    return paramException;
  }
  
  private void preReadSample()
  {
    try
    {
      AppMethodBeat.i(191384);
      this.lastFrameValid = false;
      this.currentDecoderState = doReadSample(CMTime.CMTimeInvalid, true);
      if (!this.currentDecoderState.getTime().smallThan(CMTime.CMTimeZero)) {
        this.currentDecoderState = this.currentStartState;
      }
      this.preReadTime = this.currentDecoderState.getTime();
      Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
      AppMethodBeat.o(191384);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void readFromExtractor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 599
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 210	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   12: invokevirtual 559	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   15: lstore_2
    //   16: aload_0
    //   17: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   20: new 80	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 601
    //   27: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: lload_2
    //   31: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: ldc_w 603
    //   37: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 270	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   44: invokevirtual 606	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   47: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: ldc_w 608
    //   53: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 210	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   60: invokevirtual 537	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   63: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 329	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: lload_2
    //   73: aload_0
    //   74: getfield 270	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   77: invokevirtual 606	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   80: lcmp
    //   81: ifge +22 -> 103
    //   84: aload_0
    //   85: getfield 210	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   88: invokevirtual 537	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   91: iconst_m1
    //   92: if_icmpeq +11 -> 103
    //   95: lload_2
    //   96: ldc2_w 369
    //   99: lcmp
    //   100: ifne +74 -> 174
    //   103: lload_2
    //   104: aload_0
    //   105: getfield 270	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   108: invokevirtual 606	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   111: lcmp
    //   112: iflt +7 -> 119
    //   115: aload_0
    //   116: invokespecial 611	com/tencent/tav/decoder/VideoDecoder:readSampleData	()V
    //   119: aload_0
    //   120: getfield 131	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   123: invokevirtual 614	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   126: istore_1
    //   127: iload_1
    //   128: iflt +37 -> 165
    //   131: aload_0
    //   132: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   135: ldc_w 616
    //   138: lload_2
    //   139: invokestatic 619	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   142: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokestatic 329	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: getfield 131	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   152: iload_1
    //   153: iconst_0
    //   154: iconst_0
    //   155: lconst_0
    //   156: iconst_4
    //   157: invokevirtual 623	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   160: aload_0
    //   161: iconst_1
    //   162: putfield 180	com/tencent/tav/decoder/VideoDecoder:extractorDone	Z
    //   165: ldc_w 599
    //   168: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_0
    //   172: monitorexit
    //   173: return
    //   174: aload_0
    //   175: invokespecial 611	com/tencent/tav/decoder/VideoDecoder:readSampleData	()V
    //   178: ldc_w 599
    //   181: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: goto -13 -> 171
    //   187: astore 4
    //   189: aload_0
    //   190: monitorexit
    //   191: aload 4
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	VideoDecoder
    //   126	27	1	i	int
    //   15	124	2	l	long
    //   187	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	95	187	finally
    //   103	119	187	finally
    //   119	127	187	finally
    //   131	165	187	finally
    //   165	171	187	finally
    //   174	184	187	finally
  }
  
  private void readSampleData()
  {
    AppMethodBeat.i(191407);
    long l = this.extractor.getSampleTime();
    int i = this.mediaCodecWrapper.dequeueInputBuffer();
    if (i >= 0)
    {
      Object localObject = this.mediaCodecWrapper.getInputBuffer(i);
      int j = this.extractor.readSampleData((ByteBuffer)localObject, 0);
      if (j >= 0)
      {
        this.mLastVideoQueueTime = (l - this.timeRange.getStartUs() + this.mTimeOffset);
        Logger.v(this.TAG, "doReadFrames readSampleData queueInputBuffer sampleTime:".concat(String.valueOf(l)));
        this.mediaCodecWrapper.queueInputBuffer(i, 0, j, this.mLastVideoQueueTime, 0);
        localObject = new PendingFrame(null);
        PendingFrame.access$702((PendingFrame)localObject, this.mTimeOffset);
        PendingFrame.access$802((PendingFrame)localObject, this.currentStartState.getTime());
        this.pendingFrames.add(localObject);
      }
      this.extractor.advance();
    }
    AppMethodBeat.o(191407);
  }
  
  private CMSampleState renderCacheBuffer()
  {
    AppMethodBeat.i(191380);
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
      CMSampleState localCMSampleState1 = this.currentDecoderState;
      AppMethodBeat.o(191380);
      return localCMSampleState1;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "renderCacheBuffer: ", localException);
      CMSampleState localCMSampleState2 = CMSampleState.fromError(-2L);
      AppMethodBeat.o(191380);
      return localCMSampleState2;
    }
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(191366);
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      AppMethodBeat.o(191366);
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(191426);
    super.finalize();
    release(false);
    AppMethodBeat.o(191426);
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
    AppMethodBeat.i(191415);
    if (this.extractor == null)
    {
      AppMethodBeat.o(191415);
      return null;
    }
    String str = this.extractor.getSourcePath();
    AppMethodBeat.o(191415);
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
    //   3: getfield 124	com/tencent/tav/decoder/VideoDecoder:trackIndex	I
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
    AppMethodBeat.i(191410);
    long l1 = paramCMTime.getTimeUs();
    paramCMTime = this.allFrameTime.iterator();
    while (paramCMTime.hasNext())
    {
      long l2 = ((Long)paramCMTime.next()).longValue();
      if (l1 < l2)
      {
        paramCMTime = new CMTime((float)l2 / 1000.0F / 1000.0F);
        AppMethodBeat.o(191410);
        return paramCMTime;
      }
    }
    paramCMTime = this.currentDecoderState.getTime().add(this.pFrameTime);
    AppMethodBeat.o(191410);
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
      AppMethodBeat.i(191369);
      CMSampleState localCMSampleState = readSample(CMTime.CMTimeInvalid);
      AppMethodBeat.o(191369);
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
        AppMethodBeat.i(191377);
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
            AppMethodBeat.o(191377);
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
          AppMethodBeat.o(191377);
          continue;
        }
        this.currentDecoderState = localCMSampleState;
      }
      finally {}
      if ((this.currentDecoderState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentDecoderState.getTime().smallThan(this.duration))) {
        clearDecoder();
      }
      Logger.v(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + paramCMTime + "  -  " + this.currentDecoderState);
      AppMethodBeat.o(191377);
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
    //   2: ldc_w 740
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 740
    //   18: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 742
    //   31: iload_1
    //   32: invokestatic 745	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   35: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokestatic 333	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 210	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 748	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 210	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: getfield 278	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 278	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   68: invokevirtual 748	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 278	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 159	com/tencent/tav/decoder/VideoDecoder:started	Z
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 157	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   86: aload_0
    //   87: getfield 131	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   90: invokevirtual 750	com/tencent/tav/decoder/MediaCodecWrapper:release	()V
    //   93: aload_0
    //   94: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   97: ldc_w 752
    //   100: iload_1
    //   101: invokestatic 745	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   104: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 333	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   114: new 80	java/lang/StringBuilder
    //   117: dup
    //   118: ldc_w 754
    //   121: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 170	com/tencent/tav/decoder/VideoDecoder:decodeReporter	Lcom/tencent/tav/report/AverageTimeReporter;
    //   128: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 333	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc_w 740
    //   140: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: goto -122 -> 21
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	VideoDecoder
    //   0	151	1	paramBoolean	boolean
    //   146	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	146	finally
    //   24	41	146	finally
    //   45	57	146	finally
    //   57	76	146	finally
    //   76	143	146	finally
  }
  
  void releaseOutputBuffer()
  {
    AppMethodBeat.i(191422);
    if (this.lastOutputBufferIndex != -1) {}
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
      this.outputBuffer = null;
      AppMethodBeat.o(191422);
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
      AppMethodBeat.i(191354);
      seekTo(paramCMTime, true);
      AppMethodBeat.o(191354);
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
        AppMethodBeat.i(191359);
        Logger.v(this.TAG, "seekTo: " + paramCMTime + "  - " + this + "  " + this.currentStartState + "  " + this.currentDecoderState);
        if ((!this.started) || (this.trackIndex == -1))
        {
          Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
          AppMethodBeat.o(191359);
          return;
        }
        CMTime localCMTime = paramCMTime;
        if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
          localCMTime = CMTime.CMTimeZero;
        }
        paramCMTime = this.timeRange.getStart().add(localCMTime);
        if (((paramBoolean) && (moreCloseCurrentThenSeek(localCMTime))) || (localCMTime.equalsTo(this.currentDecoderState.getTime())) || (hasPreReadAndFirstFrameSeek(localCMTime)))
        {
          AppMethodBeat.o(191359);
          continue;
        }
        this.currentStartState = new CMSampleState(localCMTime);
      }
      finally {}
      seekExtractorTo(paramCMTime.getTimeUs());
      this.extractorDone = false;
      Logger.v(this.TAG, "seekTo: finish - " + this.currentStartState + "  " + this.extractor.getSampleTime());
      AppMethodBeat.o(191359);
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(191344);
      start(paramCMTimeRange, CMTime.CMTimeZero);
      AppMethodBeat.o(191344);
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
        AppMethodBeat.i(191352);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          AppMethodBeat.o(191352);
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
          AppMethodBeat.o(191352);
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
      AppMethodBeat.i(191297);
      if (!this.sampleState.getTime().smallThan(CMTime.CMTimeZero))
      {
        AppMethodBeat.o(191297);
        return;
      }
      this.sampleState = new CMSampleState(CMTime.fromUs(VideoDecoder.this.frameDurationUs));
      AppMethodBeat.o(191297);
    }
    
    public String toString()
    {
      AppMethodBeat.i(191301);
      String str = "SampleTime{sampleState=" + this.sampleState + ", timeUs=" + this.timeUs + '}';
      AppMethodBeat.o(191301);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */