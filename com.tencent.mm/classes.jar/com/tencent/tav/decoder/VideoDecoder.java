package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VideoDecoder
  implements IVideoDecoder
{
  public static boolean LOG_VERBOSE = false;
  private static final int MAX_WAIT_TIME = 1000;
  public final String TAG;
  private List<Long> allFrameTime;
  private MediaCodec.BufferInfo bufferInfo;
  private CMTime currentDecoderTime;
  private CMTime currentStartTime;
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
  private CMTime preReadTime;
  private boolean started;
  private CMTimeRange timeRange;
  private int trackIndex;
  
  public VideoDecoder(String paramString)
  {
    this(paramString, null);
  }
  
  public VideoDecoder(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(197922);
    this.TAG = ("VideoDecoder@" + Integer.toHexString(hashCode()));
    this.frameDurationUs = 33333L;
    this.duration = CMTime.CMTimeZero;
    this.pFrameTime = new CMTime(20L, 600);
    this.trackIndex = -1;
    this.mediaCodecWrapper = new MediaCodecWrapper(this);
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.outputBuffer = null;
    this.currentDecoderTime = CMTime.CMTimeInvalid;
    this.preReadTime = CMTime.CMTimeInvalid;
    this.pendingFrames = new ArrayList();
    this.allFrameTime = new ArrayList();
    this.isReleased = false;
    this.started = false;
    this.lastFrameValid = false;
    this.lastOutputBufferIndex = -1;
    this.mTimeOffset = 10000000L;
    this.mLastVideoQueueTime = 0L;
    this.currentStartTime = CMTime.CMTimeInvalid;
    this.extractorDone = false;
    Logger.i(this.TAG, "create VideoDecoder start", new Object[0]);
    if (paramSurface != null) {
      this.outputSurface = paramSurface;
    }
    long l = System.currentTimeMillis();
    if (!initExtractor(paramString))
    {
      AppMethodBeat.o(197922);
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
      Logger.i(this.TAG, "create VideoDecoder end " + (System.currentTimeMillis() - l), new Object[0]);
      AppMethodBeat.o(197922);
      return;
    }
    paramString = new IllegalStateException("decoderConfigure failed!");
    AppMethodBeat.o(197922);
    throw paramString;
  }
  
  private void clearDecoder()
  {
    AppMethodBeat.i(197942);
    Logger.i(this.TAG, "clearDecoder " + getSourcePath(), new Object[0]);
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.mediaCodecWrapper.flushDecoder();
      this.pendingFrames.clear();
      this.currentDecoderTime = CMTime.CMTimeInvalid;
      AppMethodBeat.o(197942);
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
    AppMethodBeat.i(197924);
    new Thread()
    {
      public void run()
      {
        AppMethodBeat.i(197918);
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
          AppMethodBeat.o(197918);
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
        Logger.i(VideoDecoder.this.TAG, "Decoder: MirrorExtractor Init " + (SystemClock.currentThreadTimeMillis() - l2), new Object[0]);
        AppMethodBeat.o(197918);
      }
    }.start();
    AppMethodBeat.o(197924);
  }
  
  private void doReadFrames(SampleTime paramSampleTime, CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(197936);
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "doReadFrames() called with: sampleTime = [" + paramSampleTime + "], targetTime = [" + paramCMTime + "], justCache = [" + paramBoolean + "]");
    }
    if ((this.pendingFrames.size() == 0) && (this.extractorDone)) {
      Logger.e(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
    }
    int i = 0;
    label909:
    label915:
    label932:
    for (;;)
    {
      int n;
      if ((this.pendingFrames.size() > 0) || (!this.extractorDone))
      {
        if (!this.extractorDone) {
          readFromExtractor();
        }
        n = this.mediaCodecWrapper.dequeueOutputBuffer(this.bufferInfo);
        if ((this.bufferInfo.flags & 0x4) != 0)
        {
          if ((this.bufferInfo.size > 0) && (n >= 0) && (this.pendingFrames.size() > 0))
          {
            this.pendingFrames.remove(0);
            this.mediaCodecWrapper.releaseOutputBuffer(n, true);
          }
          Logger.e(this.TAG, "doReadFrames:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FINISH);
          AppMethodBeat.o(197936);
          return;
        }
        if ((n >= 0) && (this.pendingFrames.size() > 0)) {
          break label366;
        }
        if (n >= 0)
        {
          Logger.e(this.TAG, "doReadFrames:[failed] pendingFrames.size() == " + this.pendingFrames.size());
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
        }
        i += 1;
        if (i <= 1000) {
          break label932;
        }
        Logger.e(this.TAG, "doReadFrames: [timeout] ");
        SampleTime.access$502(paramSampleTime, SAMPLE_TIME_TIMEOUT);
      }
      for (;;)
      {
        if ((this.extractorDone) && (paramSampleTime.timeUs < 0L) && (!paramBoolean))
        {
          Logger.e(this.TAG, "doReadFrames: extractorDone && sampleTime.timeUs < 0, sampleTime = ".concat(String.valueOf(paramSampleTime)));
          SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FINISH);
        }
        AppMethodBeat.o(197936);
        return;
        label366:
        if (this.bufferInfo.size <= 0)
        {
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          Logger.e(this.TAG, "doReadFrames:[failed] bufferInfo.size == " + this.bufferInfo.size);
          SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
          break;
        }
        PendingFrame localPendingFrame = (PendingFrame)this.pendingFrames.remove(0);
        SampleTime.access$602(paramSampleTime, this.bufferInfo.presentationTimeUs - localPendingFrame.timeOffset);
        SampleTime.access$502(paramSampleTime, new CMTime((float)paramSampleTime.timeUs * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L)));
        if ((this.pendingFrames.isEmpty()) && (this.extractorDone)) {}
        for (int j = 1;; j = 0)
        {
          if ((j != 0) || (localPendingFrame.seekStartTime.getTimeUs() <= paramSampleTime.timeUs + this.frameDurationUs / 2L)) {
            break label579;
          }
          this.mediaCodecWrapper.releaseOutputBuffer(n, false);
          if (LOG_VERBOSE) {
            Logger.e(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
          }
          SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
          break;
        }
        label579:
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
            SampleTime.access$502(paramSampleTime, SAMPLE_TIME_ERROR);
            AppMethodBeat.o(197936);
          }
        }
        else
        {
          if (j != 0) {
            SampleTime.access$502(paramSampleTime, this.duration);
          }
          int k;
          if (paramCMTime.getTimeUs() - paramSampleTime.cmTime.getTimeUs() <= this.frameDurationUs / 2L)
          {
            k = 1;
            label756:
            if (paramCMTime.getTimeUs() < this.duration.getTimeUs()) {
              break label909;
            }
          }
          for (int m = 1;; m = 0)
          {
            if ((k != 0) || (m != 0) || (j != 0)) {
              break label915;
            }
            this.mediaCodecWrapper.releaseOutputBuffer(n, false);
            if (LOG_VERBOSE) {
              Logger.e(this.TAG, "doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == " + (paramCMTime.getTimeUs() - paramSampleTime.cmTime.getTimeUs()) + " targetTime = " + paramCMTime + "  duration = " + this.duration + " pendingFrames.size() = " + this.pendingFrames.size() + " extractorDone = " + this.extractorDone);
            }
            SampleTime.access$502(paramSampleTime, SAMPLE_TIME_FAILED);
            break;
            k = 0;
            break label756;
          }
          this.mediaCodecWrapper.releaseOutputBuffer(n, true);
          SampleTime.access$900(paramSampleTime);
        }
      }
    }
  }
  
  private CMTime doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(197935);
        if ((paramCMTime.bigThan(this.timeRange.getDuration())) && (!paramBoolean))
        {
          Logger.e(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + paramCMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache istrue");
          paramCMTime = SAMPLE_TIME_FINISH;
          AppMethodBeat.o(197935);
          return paramCMTime;
        }
        if ((this.extractorDone) && (this.pendingFrames.size() == 0) && (this.timeRange.containsTime(paramCMTime)))
        {
          Logger.e(this.TAG, "error state , and will go correct it ! ");
          seekTo(paramCMTime);
        }
        this.preReadTime = CMTime.CMTimeInvalid;
        if ((this.started) && (this.trackIndex != -1)) {
          break label238;
        }
        paramCMTime = this.TAG;
        localObject = new StringBuilder("doReadSample:[unStart]  !started || trackIndex == -1 ");
        if (!this.started)
        {
          paramBoolean = true;
          localObject = ((StringBuilder)localObject).append(paramBoolean).append(" - ");
          if (this.trackIndex != -1) {
            break label233;
          }
          paramBoolean = bool;
          Logger.e(paramCMTime, paramBoolean);
          paramCMTime = SAMPLE_TIME_UNSTART;
          AppMethodBeat.o(197935);
          continue;
        }
        paramBoolean = false;
      }
      finally {}
      continue;
      label233:
      paramBoolean = false;
      continue;
      label238:
      releaseOutputBuffer();
      Object localObject = new SampleTime(null);
      SampleTime.access$502((SampleTime)localObject, SAMPLE_TIME_FAILED);
      SampleTime.access$602((SampleTime)localObject, SAMPLE_TIME_FAILED.value);
      try
      {
        doReadFrames((SampleTime)localObject, paramCMTime, paramBoolean);
        if (LOG_VERBOSE) {
          Logger.i(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + ((SampleTime)localObject).timeUs + "  " + ((SampleTime)localObject).cmTime, new Object[0]);
        }
        paramCMTime = ((SampleTime)localObject).cmTime;
        AppMethodBeat.o(197935);
      }
      catch (Exception paramCMTime)
      {
        paramCMTime = onReadFramesException(paramCMTime);
        AppMethodBeat.o(197935);
      }
    }
  }
  
  private boolean hasPreReadAndFirstFrameSeek(CMTime paramCMTime)
  {
    return (paramCMTime == CMTime.CMTimeZero) && (this.preReadTime != CMTime.CMTimeInvalid) && (this.lastOutputBufferIndex != -1) && (this.currentDecoderTime != CMTime.CMTimeInvalid);
  }
  
  private boolean initExtractor(String paramString)
  {
    AppMethodBeat.i(197923);
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
      AppMethodBeat.o(197923);
      return false;
    }
    this.extractor.selectTrack(this.trackIndex);
    AppMethodBeat.o(197923);
    return true;
  }
  
  private boolean moreCloseCurrentThenSeek(CMTime paramCMTime)
  {
    AppMethodBeat.i(197929);
    if (this.mirrorExtractor != null)
    {
      long l1 = this.extractor.getSampleTime();
      this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 2);
      if (this.mirrorExtractor.getSampleTime() > paramCMTime.getTimeUs()) {
        this.mirrorExtractor.seekTo(paramCMTime.getTimeUs(), 0);
      }
      long l2 = this.mirrorExtractor.getSampleTime();
      if ((l2 <= l1) && (this.currentDecoderTime.getTimeUs() >= l2) && (this.currentDecoderTime.getTimeUs() < paramCMTime.getTimeUs() + this.pFrameTime.getTimeUs()) && (l1 <= paramCMTime.getTimeUs()))
      {
        AppMethodBeat.o(197929);
        return true;
      }
      AppMethodBeat.o(197929);
      return false;
    }
    AppMethodBeat.o(197929);
    return false;
  }
  
  private CMTime onReadFramesException(Exception paramException)
  {
    AppMethodBeat.i(197937);
    Logger.e(this.TAG, "onReadFramesException: ", paramException);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramException = SAMPLE_TIME_ERROR;
      AppMethodBeat.o(197937);
      return paramException;
    }
    if (!(paramException instanceof MediaCodec.CodecException))
    {
      paramException = SAMPLE_TIME_ERROR;
      AppMethodBeat.o(197937);
      return paramException;
    }
    if (((MediaCodec.CodecException)paramException).isRecoverable())
    {
      releaseOutputBuffer();
      this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      long l1 = this.currentStartTime.getTimeUs();
      long l2 = this.timeRange.getStartUs();
      this.extractor.seekTo(l1 - l2, 0);
      this.extractorDone = false;
      paramException = SAMPLE_TIME_ERROR;
      AppMethodBeat.o(197937);
      return paramException;
    }
    if (((MediaCodec.CodecException)paramException).isTransient()) {
      Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    paramException = SAMPLE_TIME_ERROR;
    AppMethodBeat.o(197937);
    return paramException;
  }
  
  private void preReadSample()
  {
    try
    {
      AppMethodBeat.i(197934);
      this.lastFrameValid = false;
      this.currentDecoderTime = doReadSample(CMTime.CMTimeInvalid, true);
      if ((CMTime.CMTimeInvalid.smallThan(CMTime.CMTimeZero)) && (!this.currentDecoderTime.smallThan(CMTime.CMTimeZero))) {
        this.currentDecoderTime = this.currentStartTime;
      }
      this.preReadTime = this.currentDecoderTime;
      Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex, new Object[0]);
      AppMethodBeat.o(197934);
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
    //   2: ldc_w 567
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 197	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   12: invokevirtual 525	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   15: lstore_2
    //   16: lload_2
    //   17: aload_0
    //   18: getfield 257	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   21: invokevirtual 570	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   24: lcmp
    //   25: ifge +22 -> 47
    //   28: aload_0
    //   29: getfield 197	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   32: invokevirtual 506	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   35: iconst_m1
    //   36: if_icmpeq +11 -> 47
    //   39: lload_2
    //   40: ldc2_w 571
    //   43: lcmp
    //   44: ifne +57 -> 101
    //   47: lload_2
    //   48: aload_0
    //   49: getfield 257	com/tencent/tav/decoder/VideoDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   52: invokevirtual 570	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   55: lcmp
    //   56: iflt +7 -> 63
    //   59: aload_0
    //   60: invokespecial 575	com/tencent/tav/decoder/VideoDecoder:readSampleData	()V
    //   63: aload_0
    //   64: getfield 131	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   67: invokevirtual 578	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   70: istore_1
    //   71: iload_1
    //   72: iflt +20 -> 92
    //   75: aload_0
    //   76: getfield 131	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   79: iload_1
    //   80: iconst_0
    //   81: iconst_0
    //   82: lconst_0
    //   83: iconst_4
    //   84: invokevirtual 582	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   87: aload_0
    //   88: iconst_1
    //   89: putfield 170	com/tencent/tav/decoder/VideoDecoder:extractorDone	Z
    //   92: ldc_w 567
    //   95: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aload_0
    //   102: invokespecial 575	com/tencent/tav/decoder/VideoDecoder:readSampleData	()V
    //   105: ldc_w 567
    //   108: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -13 -> 98
    //   114: astore 4
    //   116: aload_0
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	VideoDecoder
    //   70	10	1	i	int
    //   15	33	2	l	long
    //   114	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	39	114	finally
    //   47	63	114	finally
    //   63	71	114	finally
    //   75	92	114	finally
    //   92	98	114	finally
    //   101	111	114	finally
  }
  
  private void readSampleData()
  {
    AppMethodBeat.i(197939);
    long l = this.extractor.getSampleTime();
    int i = this.mediaCodecWrapper.dequeueInputBuffer();
    if (i >= 0)
    {
      Object localObject = this.mediaCodecWrapper.getInputBuffer(i);
      int j = this.extractor.readSampleData((ByteBuffer)localObject, 0);
      if (j >= 0)
      {
        this.mLastVideoQueueTime = (l - this.timeRange.getStartUs() + this.mTimeOffset);
        this.mediaCodecWrapper.queueInputBuffer(i, 0, j, this.mLastVideoQueueTime, 0);
        localObject = new PendingFrame(null);
        PendingFrame.access$702((PendingFrame)localObject, this.mTimeOffset);
        PendingFrame.access$802((PendingFrame)localObject, this.currentStartTime);
        this.pendingFrames.add(localObject);
      }
      this.extractor.advance();
    }
    AppMethodBeat.o(197939);
  }
  
  private CMTime renderCacheBuffer()
  {
    AppMethodBeat.i(197933);
    if (LOG_VERBOSE) {
      Logger.e(this.TAG, "renderCacheBuffer: cache hit - " + this.currentDecoderTime);
    }
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if (this.currentDecoderTime.bigThan(this.timeRange.getEnd()))
      {
        this.currentDecoderTime = SAMPLE_TIME_FINISH;
        this.pendingFrames.clear();
        this.extractorDone = true;
      }
      CMTime localCMTime1 = this.currentDecoderTime;
      AppMethodBeat.o(197933);
      return localCMTime1;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, localException);
      CMTime localCMTime2 = SAMPLE_TIME_FAILED;
      AppMethodBeat.o(197933);
      return localCMTime2;
    }
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(197930);
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      AppMethodBeat.o(197930);
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(197945);
    super.finalize();
    release(false);
    AppMethodBeat.o(197945);
  }
  
  public String getSourcePath()
  {
    AppMethodBeat.i(197941);
    if (this.extractor == null)
    {
      AppMethodBeat.o(197941);
      return null;
    }
    String str = this.extractor.getSourcePath();
    AppMethodBeat.o(197941);
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
    AppMethodBeat.i(197940);
    long l1 = paramCMTime.getTimeUs();
    paramCMTime = this.allFrameTime.iterator();
    while (paramCMTime.hasNext())
    {
      long l2 = ((Long)paramCMTime.next()).longValue();
      if (l1 < l2)
      {
        paramCMTime = new CMTime((float)l2 / 1000.0F / 1000.0F);
        AppMethodBeat.o(197940);
        return paramCMTime;
      }
    }
    paramCMTime = this.currentDecoderTime.add(this.pFrameTime);
    AppMethodBeat.o(197940);
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
  
  public CMTime readSample()
  {
    try
    {
      AppMethodBeat.i(197931);
      CMTime localCMTime = readSample(CMTime.CMTimeInvalid);
      AppMethodBeat.o(197931);
      return localCMTime;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime readSample(CMTime paramCMTime)
  {
    int k = 0;
    for (;;)
    {
      CMTime localCMTime;
      try
      {
        AppMethodBeat.i(197932);
        if (LOG_VERBOSE) {
          Logger.d(this.TAG, "readSample: " + paramCMTime + ", currentDecoderTime = " + this.currentDecoderTime + ",  extractor.getSampleTime() = " + this.extractor.getSampleTime() + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
        }
        this.lastFrameValid = false;
        int i;
        if ((outputSurface() != null) && (this.lastOutputBufferIndex != -1))
        {
          i = 1;
          if (!this.currentDecoderTime.smallThan(paramCMTime)) {
            break label417;
          }
          j = k;
          if (this.extractorDone)
          {
            j = k;
            if (this.pendingFrames.isEmpty()) {
              break label417;
            }
          }
          if ((i != 0) && (j != 0))
          {
            paramCMTime = renderCacheBuffer();
            AppMethodBeat.o(197932);
            return paramCMTime;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localCMTime = doReadSample(paramCMTime, false);
        if ((this.currentDecoderTime != CMTime.CMTimeInvalid) && (localCMTime.bigThan(this.timeRange.getDuration())))
        {
          this.currentDecoderTime = SAMPLE_TIME_FINISH;
          this.pendingFrames.clear();
          this.extractorDone = true;
          if (LOG_VERBOSE) {
            Logger.i(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentDecoderTime, new Object[0]);
          }
          paramCMTime = this.currentDecoderTime;
          AppMethodBeat.o(197932);
          continue;
        }
        this.currentDecoderTime = localCMTime;
      }
      finally {}
      if ((this.currentDecoderTime == SAMPLE_TIME_FINISH) || (this.currentDecoderTime == SAMPLE_TIME_TIMEOUT) || (!this.currentDecoderTime.smallThan(this.duration))) {
        clearDecoder();
      }
      if (LOG_VERBOSE) {
        Logger.i(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + paramCMTime + "  -  " + this.currentDecoderTime, new Object[0]);
      }
      AppMethodBeat.o(197932);
      paramCMTime = localCMTime;
      continue;
      label417:
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
    //   2: ldc_w 691
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 154	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 691
    //   18: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 693
    //   31: iload_1
    //   32: invokestatic 696	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   35: invokevirtual 378	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokestatic 321	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 197	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 699	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 197	com/tencent/tav/decoder/VideoDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: getfield 265	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 265	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   68: invokevirtual 699	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 265	com/tencent/tav/decoder/VideoDecoder:mirrorExtractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 156	com/tencent/tav/decoder/VideoDecoder:started	Z
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 154	com/tencent/tav/decoder/VideoDecoder:isReleased	Z
    //   86: aload_0
    //   87: getfield 131	com/tencent/tav/decoder/VideoDecoder:mediaCodecWrapper	Lcom/tencent/tav/decoder/MediaCodecWrapper;
    //   90: invokevirtual 701	com/tencent/tav/decoder/MediaCodecWrapper:release	()V
    //   93: aload_0
    //   94: getfield 104	com/tencent/tav/decoder/VideoDecoder:TAG	Ljava/lang/String;
    //   97: ldc_w 703
    //   100: iload_1
    //   101: invokestatic 696	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   104: invokevirtual 378	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 321	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc_w 691
    //   113: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -95 -> 21
    //   119: astore_2
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_2
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	VideoDecoder
    //   0	124	1	paramBoolean	boolean
    //   119	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	119	finally
    //   24	41	119	finally
    //   45	57	119	finally
    //   57	76	119	finally
    //   76	116	119	finally
  }
  
  void releaseOutputBuffer()
  {
    AppMethodBeat.i(197943);
    if (this.lastOutputBufferIndex != -1) {}
    try
    {
      this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
      this.outputBuffer = null;
      AppMethodBeat.o(197943);
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
      AppMethodBeat.i(197927);
      seekTo(paramCMTime, true);
      AppMethodBeat.o(197927);
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
        AppMethodBeat.i(197928);
        Logger.i(this.TAG, "seekTo: " + paramCMTime + "  - " + this + "  " + this.currentStartTime + "  " + this.currentDecoderTime, new Object[0]);
        if ((!this.started) || (this.trackIndex == -1))
        {
          Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
          AppMethodBeat.o(197928);
          return;
        }
        CMTime localCMTime = paramCMTime;
        if (paramCMTime.smallThan(CMTime.CMTimeZero)) {
          localCMTime = CMTime.CMTimeZero;
        }
        paramCMTime = this.timeRange.getStart().add(localCMTime);
        if (((paramBoolean) && (moreCloseCurrentThenSeek(localCMTime))) || (localCMTime.equalsTo(this.currentDecoderTime)) || (hasPreReadAndFirstFrameSeek(localCMTime)))
        {
          AppMethodBeat.o(197928);
          continue;
        }
        this.currentStartTime = localCMTime;
      }
      finally {}
      seekExtractorTo(paramCMTime.getTimeUs());
      this.extractorDone = false;
      Logger.i(this.TAG, "seekTo: finish - " + this.currentStartTime + "  " + this.extractor.getSampleTime(), new Object[0]);
      AppMethodBeat.o(197928);
    }
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(197925);
      start(paramCMTimeRange, CMTime.CMTimeZero);
      AppMethodBeat.o(197925);
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
        AppMethodBeat.i(197926);
        Logger.i(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]", new Object[0]);
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          AppMethodBeat.o(197926);
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
            seekTo(paramCMTime, false);
            preReadSample();
          }
          AppMethodBeat.o(197926);
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
    private CMTime cmTime;
    private long timeUs;
    
    private SampleTime() {}
    
    private void fixCMTime()
    {
      AppMethodBeat.i(197919);
      if (!this.cmTime.smallThan(CMTime.CMTimeZero))
      {
        AppMethodBeat.o(197919);
        return;
      }
      this.cmTime = CMTime.fromUs(VideoDecoder.this.frameDurationUs);
      AppMethodBeat.o(197919);
    }
    
    public String toString()
    {
      AppMethodBeat.i(197920);
      String str = "SampleTime{cmTime=" + this.cmTime + ", timeUs=" + this.timeUs + '}';
      AppMethodBeat.o(197920);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */