package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.DefaultDecoderFactory;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.codec.IMediaCodec;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.report.AverageTimeReporter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AudioDecoder
  implements IDecoder
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final int MAX_WAIT_TIME = 1000;
  private static final String SCENE = "tav-audio-decoder";
  private static final long WAIT_TRANSIENT_MS = 2L;
  private static final ArrayList<String> nameList;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private CMSampleState currentSampleState;
  private CMTime currentStartTime;
  private AudioInfo decodeAudioInfo;
  private ByteBuffer decodeBuffer;
  private IMediaCodec decoder;
  private final Object decoderCreateLock;
  private IDecoderFactory decoderFactory;
  private CMTime duration;
  private AssetExtractor extractor;
  private boolean extractorDone;
  private boolean isReleased;
  private int lastOutputBufferIndex;
  private long mLastVideoQueueTime;
  private long mTimeOffset;
  private MediaFormat mediaFormat;
  private AudioInfo outputAudioInfo;
  private ByteBuffer outputBuffer;
  private CMTime pFrameTime;
  private ArrayList<PendingFrame> pendingFrames;
  private boolean started;
  private CMTimeRange timeRange;
  public int trackIndex;
  
  static
  {
    AppMethodBeat.i(216362);
    nameList = new ArrayList();
    AppMethodBeat.o(216362);
  }
  
  public AudioDecoder(String paramString)
  {
    this(paramString, null);
  }
  
  public AudioDecoder(String arg1, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(216170);
    this.TAG = ("AudioDecoder@" + Integer.toHexString(hashCode()));
    this.duration = CMTime.CMTimeZero;
    this.started = false;
    this.pendingFrames = new ArrayList();
    this.trackIndex = -1;
    this.isReleased = false;
    this.currentSampleState = new CMSampleState(CMTime.CMTimeZero);
    this.decodeAudioInfo = new AudioInfo();
    this.outputAudioInfo = null;
    this.decodeBuffer = null;
    this.outputBuffer = null;
    this.decoderCreateLock = new Object();
    this.pFrameTime = new CMTime(20L, 600);
    this.lastOutputBufferIndex = -1;
    this.currentStartTime = CMTime.CMTimeInvalid;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.extractorDone = false;
    this.mTimeOffset = 0L;
    this.mLastVideoQueueTime = 0L;
    if (paramIDecoderFactory != null) {}
    for (this.decoderFactory = paramIDecoderFactory;; this.decoderFactory = new DefaultDecoderFactory())
    {
      this.extractor = new AssetExtractor();
      this.extractor.setDataSource(???);
      while (this.extractor.getSampleTrackIndex() != -1) {
        this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
      }
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "audio/");
    if (this.trackIndex == -1)
    {
      this.decodeBuffer = null;
      AppMethodBeat.o(216170);
      return;
    }
    this.extractor.selectTrack(this.trackIndex);
    this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
    this.duration = new CMTime((float)this.extractor.getAudioDuration() * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
    if (this.mediaFormat.containsKey("frame-rate")) {
      this.pFrameTime = new CMTime(600 / this.mediaFormat.getInteger("frame-rate"), 600);
    }
    paramIDecoderFactory = this.mediaFormat.getString("mime");
    synchronized (this.decoderCreateLock)
    {
      this.decoder = this.decoderFactory.createAudioDecoder(paramIDecoderFactory, "tav-audio-decoder");
      this.decoder.setDataSource(this.extractor.getSourcePath());
      nameList.add(this.decoder.toString());
      if (decoderConfigure(this.mediaFormat))
      {
        start();
        this.decodeAudioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
        this.decodeAudioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
        ??? = new AudioInfo();
        ???.channelCount = 1;
        ???.sampleRate = 44100;
        ???.pcmEncoding = 2;
        AppMethodBeat.o(216170);
        return;
      }
      paramIDecoderFactory = new IllegalStateException("decoderConfigure failed!");
      AppMethodBeat.o(216170);
      throw paramIDecoderFactory;
    }
  }
  
  private void clearDecoder()
  {
    AppMethodBeat.i(216194);
    Logger.v(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.decoder.flush();
      this.pendingFrames.clear();
      this.currentSampleState = new CMSampleState();
      AppMethodBeat.o(216194);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "clearDecoder", localException);
      }
    }
  }
  
  private boolean decoderConfigure(MediaFormat paramMediaFormat)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216188);
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.decoder.configure(paramMediaFormat, null, null, 0);
          AppMethodBeat.o(216188);
          bool = true;
          return bool;
        }
        int i = 0;
        i += 1;
        try
        {
          Logger.d(this.TAG, "createdDecoder---time---".concat(String.valueOf(i)));
          if (i > 10)
          {
            AppMethodBeat.o(216188);
            bool = false;
            continue;
          }
          this.decoder.configure(paramMediaFormat, null, null, 0);
          AppMethodBeat.o(216188);
          bool = true;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "decoderConfigure", localException);
          if (!(localException instanceof MediaCodec.CodecException)) {
            continue;
          }
        }
        if ((!((MediaCodec.CodecException)localException).isTransient()) && (!((MediaCodec.CodecException)localException).isRecoverable()))
        {
          this.decoder.release();
          AppMethodBeat.o(216188);
          throw localException;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private int dequeueInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 376
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 255	com/tencent/tav/decoder/AudioDecoder:decoder	Lcom/tencent/tav/codec/IMediaCodec;
    //   12: ldc2_w 377
    //   15: invokeinterface 381 3 0
    //   20: istore_1
    //   21: ldc_w 376
    //   24: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   36: ldc_w 382
    //   39: aload_2
    //   40: invokestatic 336	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 21
    //   48: if_icmplt +116 -> 164
    //   51: aload_2
    //   52: instanceof 362
    //   55: ifeq +109 -> 164
    //   58: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   61: bipush 23
    //   63: if_icmplt +65 -> 128
    //   66: aload_0
    //   67: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   70: new 92	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 384
    //   77: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_2
    //   81: checkcast 362	android/media/MediaCodec$CodecException
    //   84: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   87: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   90: ldc_w 389
    //   93: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_2
    //   97: checkcast 362	android/media/MediaCodec$CodecException
    //   100: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   103: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc_w 391
    //   109: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_2
    //   113: checkcast 362	android/media/MediaCodec$CodecException
    //   116: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   119: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 399	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_2
    //   129: checkcast 362	android/media/MediaCodec$CodecException
    //   132: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   135: ifeq +29 -> 164
    //   138: aload_0
    //   139: ldc2_w 23
    //   142: invokespecial 403	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   145: aload_0
    //   146: invokespecial 405	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   149: istore_1
    //   150: ldc_w 376
    //   153: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: goto -129 -> 27
    //   159: astore_2
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    //   164: ldc_w 376
    //   167: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_2
    //   171: athrow
    //   172: astore_2
    //   173: goto -141 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	AudioDecoder
    //   20	130	1	i	int
    //   31	98	2	localException	Exception
    //   159	12	2	localObject	Object
    //   172	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	21	31	java/lang/Exception
    //   2	8	159	finally
    //   8	21	159	finally
    //   21	27	159	finally
    //   32	128	159	finally
    //   128	156	159	finally
    //   164	172	159	finally
    //   8	21	172	java/lang/Error
  }
  
  private int dequeueOutputBuffer()
  {
    try
    {
      AppMethodBeat.i(216245);
      for (;;)
      {
        try
        {
          i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
          AppMethodBeat.o(216245);
          return i;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "dequeueOutputBuffer", localException);
          if (Build.VERSION.SDK_INT < 21) {
            break;
          }
        }
        if (!(localException instanceof MediaCodec.CodecException)) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(2L);
        int i = dequeueOutputBuffer();
        AppMethodBeat.o(216245);
      }
      AppMethodBeat.o(216245);
    }
    finally {}
    throw localObject;
  }
  
  private CMSampleState doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    long l1 = -2L;
    boolean bool = false;
    Object localObject;
    int i;
    label162:
    long l2;
    int j;
    label341:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216312);
        Logger.v(this.TAG, "doReadSample - " + this.extractor.getSourcePath());
        paramCMTime = CMSampleState.fromError(-2L);
        if ((!this.started) || (this.trackIndex == -1))
        {
          paramCMTime = this.TAG;
          localObject = new StringBuilder("doReadSample:[failed] !started || trackIndex == -1 ");
          if (!this.started)
          {
            paramBoolean = true;
            localObject = ((StringBuilder)localObject).append(paramBoolean).append(" - ");
            paramBoolean = bool;
            if (this.trackIndex == -1) {
              paramBoolean = true;
            }
            Logger.e(paramCMTime, paramBoolean);
            paramCMTime = CMSampleState.fromError(-100L);
            AppMethodBeat.o(216312);
            return paramCMTime;
          }
          paramBoolean = false;
          continue;
        }
        releaseOutputBuffer();
        i = 0;
        if (this.pendingFrames.size() <= 0)
        {
          paramBoolean = this.extractorDone;
          localObject = paramCMTime;
          l2 = l1;
          if (paramBoolean) {
            break label659;
          }
        }
        try
        {
          if (!this.extractorDone) {
            readFromExtractor();
          }
          j = dequeueOutputBuffer();
          if (j != -2) {
            break;
          }
          localObject = this.decoder.getOutputFormat();
          if (!((MediaFormat)localObject).containsKey("pcm-encoding")) {
            break label341;
          }
          this.decodeAudioInfo.pcmEncoding = ((MediaFormat)localObject).getInteger("pcm-encoding");
          if (!((MediaFormat)localObject).containsKey("sample-rate")) {
            continue;
          }
          this.decodeAudioInfo.sampleRate = ((MediaFormat)localObject).getInteger("sample-rate");
        }
        catch (Exception paramCMTime)
        {
          Logger.e(this.TAG, "doReadSample: error", paramCMTime);
          if (Build.VERSION.SDK_INT < 21) {
            break label939;
          }
        }
        if ((!(paramCMTime instanceof MediaCodec.CodecException)) || (!retryOnReadSampleError((MediaCodec.CodecException)paramCMTime))) {
          break label939;
        }
        paramCMTime = CMSampleState.fromError(-3L, "catch exception, retry", paramCMTime);
        AppMethodBeat.o(216312);
        continue;
        this.decodeAudioInfo.pcmEncoding = 2;
      }
      finally {}
    }
    if ((j >= 0) && (this.pendingFrames.size() > 0))
    {
      if (this.bufferInfo.flags == 4)
      {
        if (this.bufferInfo.size > 0)
        {
          this.pendingFrames.remove(0);
          this.lastOutputBufferIndex = j;
          paramCMTime = getOutputBuffer(j);
          if (paramCMTime == null) {
            break label477;
          }
          paramCMTime.position(this.bufferInfo.offset);
          paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
        }
        for (this.decodeBuffer = paramCMTime;; this.decodeBuffer = null)
        {
          Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          paramCMTime = CMSampleState.fromError(-1L);
          AppMethodBeat.o(216312);
          break;
          label477:
          releaseOutputBuffer(j, false);
        }
      }
      paramCMTime = (PendingFrame)this.pendingFrames.remove(0);
      l1 = this.bufferInfo.presentationTimeUs - paramCMTime.timeOffset;
      localObject = new CMSampleState(new CMTime(l1, 1000000));
      if ((this.pendingFrames.size() == 0) && (this.extractorDone) && (paramCMTime.seekStartTime.getTimeUs() + 1000L >= this.duration.getTimeUs())) {
        localObject = new CMSampleState(this.duration);
      }
    }
    label659:
    label936:
    label939:
    label959:
    label971:
    for (;;)
    {
      if (this.bufferInfo.size > 0)
      {
        this.lastOutputBufferIndex = j;
        paramCMTime = getOutputBuffer(j);
        if (paramCMTime != null)
        {
          paramCMTime.position(this.bufferInfo.offset);
          paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
          this.decodeBuffer = paramCMTime;
        }
      }
      for (l2 = l1;; l2 = l1)
      {
        Logger.v(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + l2 + "  " + localObject);
        if ((!this.extractorDone) || (l2 >= 0L)) {
          break label959;
        }
        paramCMTime = CMSampleState.fromError(-1L);
        AppMethodBeat.o(216312);
        break;
        if (paramCMTime.seekStartTime.getTimeUs() <= l1) {
          break label971;
        }
        releaseOutputBuffer(j, false);
        paramCMTime = CMSampleState.fromError(-2L);
        break label162;
        releaseOutputBuffer(j, false);
        Logger.e(this.TAG, "doReadSample:[error] " + this.bufferInfo.size + " byteBuffer==null");
        paramCMTime = CMSampleState.fromError(-3L);
        AppMethodBeat.o(216312);
        break;
        releaseOutputBuffer(j, false);
        paramCMTime = CMSampleState.fromError(-2L);
        break label162;
        if (j >= 0)
        {
          if (this.bufferInfo.flags == 4)
          {
            Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
            paramCMTime = CMSampleState.fromError(-1L);
            AppMethodBeat.o(216312);
            break;
          }
          releaseOutputBuffer(j, false);
          paramCMTime = CMSampleState.fromError(-2L);
        }
        i += 1;
        if (i <= 1000) {
          break label936;
        }
        localObject = CMSampleState.fromError(-4L);
        Logger.e(this.TAG, "doReadSample: [timeout] ");
      }
      break label162;
      paramCMTime = CMSampleState.fromError(-3L, "catch exception", paramCMTime);
      AppMethodBeat.o(216312);
      break;
      AppMethodBeat.o(216312);
      paramCMTime = (CMTime)localObject;
      break;
    }
  }
  
  /* Error */
  private ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 525
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 255	com/tencent/tav/decoder/AudioDecoder:decoder	Lcom/tencent/tav/codec/IMediaCodec;
    //   12: iload_1
    //   13: invokeinterface 527 2 0
    //   18: astore_2
    //   19: ldc_w 525
    //   22: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   34: ldc_w 528
    //   37: aload_2
    //   38: invokestatic 336	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 21
    //   46: if_icmplt +117 -> 163
    //   49: aload_2
    //   50: instanceof 362
    //   53: ifeq +110 -> 163
    //   56: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 23
    //   61: if_icmplt +65 -> 126
    //   64: aload_0
    //   65: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   68: new 92	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 384
    //   75: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: checkcast 362	android/media/MediaCodec$CodecException
    //   82: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   85: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: ldc_w 389
    //   91: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: checkcast 362	android/media/MediaCodec$CodecException
    //   98: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   101: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 391
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: checkcast 362	android/media/MediaCodec$CodecException
    //   114: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   117: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 399	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_2
    //   127: checkcast 362	android/media/MediaCodec$CodecException
    //   130: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   133: ifeq +30 -> 163
    //   136: aload_0
    //   137: ldc2_w 23
    //   140: invokespecial 403	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   143: aload_0
    //   144: iload_1
    //   145: invokespecial 529	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   148: astore_2
    //   149: ldc_w 525
    //   152: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: goto -130 -> 25
    //   158: astore_2
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: ldc_w 525
    //   166: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: goto -142 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	AudioDecoder
    //   0	175	1	paramInt	int
    //   18	10	2	localByteBuffer1	ByteBuffer
    //   29	98	2	localException	Exception
    //   148	1	2	localByteBuffer2	ByteBuffer
    //   158	12	2	localObject	Object
    //   171	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	19	29	java/lang/Exception
    //   2	8	158	finally
    //   8	19	158	finally
    //   19	25	158	finally
    //   30	126	158	finally
    //   126	155	158	finally
    //   163	171	158	finally
    //   8	19	171	java/lang/Error
  }
  
  /* Error */
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 530
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 255	com/tencent/tav/decoder/AudioDecoder:decoder	Lcom/tencent/tav/codec/IMediaCodec;
    //   12: iload_1
    //   13: invokeinterface 531 2 0
    //   18: astore_2
    //   19: ldc_w 530
    //   22: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   34: ldc_w 532
    //   37: aload_2
    //   38: invokestatic 336	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 21
    //   46: if_icmplt +117 -> 163
    //   49: aload_2
    //   50: instanceof 362
    //   53: ifeq +110 -> 163
    //   56: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 23
    //   61: if_icmplt +65 -> 126
    //   64: aload_0
    //   65: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   68: new 92	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 384
    //   75: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: checkcast 362	android/media/MediaCodec$CodecException
    //   82: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   85: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: ldc_w 389
    //   91: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: checkcast 362	android/media/MediaCodec$CodecException
    //   98: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   101: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 391
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: checkcast 362	android/media/MediaCodec$CodecException
    //   114: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   117: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 399	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_2
    //   127: checkcast 362	android/media/MediaCodec$CodecException
    //   130: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   133: ifeq +30 -> 163
    //   136: aload_0
    //   137: ldc2_w 23
    //   140: invokespecial 403	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   143: aload_0
    //   144: iload_1
    //   145: invokespecial 465	com/tencent/tav/decoder/AudioDecoder:getOutputBuffer	(I)Ljava/nio/ByteBuffer;
    //   148: astore_2
    //   149: ldc_w 530
    //   152: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: goto -130 -> 25
    //   158: astore_2
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: ldc_w 530
    //   166: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: goto -142 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	AudioDecoder
    //   0	175	1	paramInt	int
    //   18	10	2	localByteBuffer1	ByteBuffer
    //   29	98	2	localException	Exception
    //   148	1	2	localByteBuffer2	ByteBuffer
    //   158	12	2	localObject	Object
    //   171	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	19	29	java/lang/Exception
    //   2	8	158	finally
    //   8	19	158	finally
    //   19	25	158	finally
    //   30	126	158	finally
    //   126	155	158	finally
    //   163	171	158	finally
    //   8	19	171	java/lang/Error
  }
  
  /* Error */
  private void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 535
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 255	com/tencent/tav/decoder/AudioDecoder:decoder	Lcom/tencent/tav/codec/IMediaCodec;
    //   12: iload_1
    //   13: iload_2
    //   14: iload_3
    //   15: lload 4
    //   17: iload 6
    //   19: invokeinterface 537 7 0
    //   24: ldc_w 535
    //   27: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore 7
    //   35: aload_0
    //   36: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   39: ldc_w 538
    //   42: aload 7
    //   44: invokestatic 336	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   50: bipush 21
    //   52: if_icmplt +113 -> 165
    //   55: aload 7
    //   57: instanceof 362
    //   60: ifeq +105 -> 165
    //   63: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   66: bipush 23
    //   68: if_icmplt +68 -> 136
    //   71: aload_0
    //   72: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   75: new 92	java/lang/StringBuilder
    //   78: dup
    //   79: ldc_w 384
    //   82: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 7
    //   87: checkcast 362	android/media/MediaCodec$CodecException
    //   90: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   93: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc_w 389
    //   99: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 7
    //   104: checkcast 362	android/media/MediaCodec$CodecException
    //   107: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   110: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc_w 391
    //   116: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 7
    //   121: checkcast 362	android/media/MediaCodec$CodecException
    //   124: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   127: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 399	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 7
    //   138: checkcast 362	android/media/MediaCodec$CodecException
    //   141: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   144: ifeq +21 -> 165
    //   147: aload_0
    //   148: ldc2_w 23
    //   151: invokespecial 403	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   154: aload_0
    //   155: iload_1
    //   156: iload_2
    //   157: iload_3
    //   158: lload 4
    //   160: iload 6
    //   162: invokespecial 539	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   165: ldc_w 535
    //   168: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload 7
    //   173: athrow
    //   174: astore 7
    //   176: aload_0
    //   177: monitorexit
    //   178: aload 7
    //   180: athrow
    //   181: astore 7
    //   183: goto -148 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	AudioDecoder
    //   0	186	1	paramInt1	int
    //   0	186	2	paramInt2	int
    //   0	186	3	paramInt3	int
    //   0	186	4	paramLong	long
    //   0	186	6	paramInt4	int
    //   33	139	7	localException	Exception
    //   174	5	7	localObject	Object
    //   181	1	7	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	24	33	java/lang/Exception
    //   2	8	174	finally
    //   8	24	174	finally
    //   24	30	174	finally
    //   35	136	174	finally
    //   136	165	174	finally
    //   165	174	174	finally
    //   8	24	181	java/lang/Error
  }
  
  /* Error */
  private void readFromExtractor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 540
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   12: invokevirtual 543	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: aload_0
    //   18: getfield 545	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   21: invokevirtual 550	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   24: lcmp
    //   25: ifge +22 -> 47
    //   28: aload_0
    //   29: getfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   32: invokevirtual 189	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   35: iconst_m1
    //   36: if_icmpeq +11 -> 47
    //   39: lload_3
    //   40: ldc2_w 482
    //   43: lcmp
    //   44: ifne +35 -> 79
    //   47: aload_0
    //   48: invokespecial 405	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   51: istore_1
    //   52: iload_1
    //   53: iflt +17 -> 70
    //   56: aload_0
    //   57: iload_1
    //   58: iconst_0
    //   59: iconst_0
    //   60: lconst_0
    //   61: iconst_4
    //   62: invokespecial 539	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 172	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   70: ldc_w 540
    //   73: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: invokespecial 405	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   83: istore_1
    //   84: iload_1
    //   85: iflt +151 -> 236
    //   88: aload_0
    //   89: iload_1
    //   90: invokespecial 529	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   93: astore 5
    //   95: aload_0
    //   96: getfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   99: aload 5
    //   101: iconst_0
    //   102: invokevirtual 554	com/tencent/tav/extractor/AssetExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   105: istore_2
    //   106: iload_2
    //   107: iflt +121 -> 228
    //   110: aload_0
    //   111: lload_3
    //   112: aload_0
    //   113: getfield 545	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   116: invokevirtual 557	com/tencent/tav/coremedia/CMTimeRange:getStartUs	()J
    //   119: lsub
    //   120: aload_0
    //   121: getfield 174	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   124: ladd
    //   125: putfield 176	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   128: aload_0
    //   129: iload_1
    //   130: iconst_0
    //   131: iload_2
    //   132: aload_0
    //   133: getfield 176	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   136: iconst_0
    //   137: invokespecial 539	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   140: new 10	com/tencent/tav/decoder/AudioDecoder$PendingFrame
    //   143: dup
    //   144: invokespecial 558	com/tencent/tav/decoder/AudioDecoder$PendingFrame:<init>	()V
    //   147: astore 5
    //   149: aload 5
    //   151: aload_0
    //   152: getfield 174	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   155: putfield 492	com/tencent/tav/decoder/AudioDecoder$PendingFrame:timeOffset	J
    //   158: aload 5
    //   160: new 118	com/tencent/tav/coremedia/CMTime
    //   163: dup
    //   164: lload_3
    //   165: l2f
    //   166: fconst_1
    //   167: fmul
    //   168: getstatic 222	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   171: lconst_1
    //   172: invokevirtual 226	java/util/concurrent/TimeUnit:toMicros	(J)J
    //   175: l2f
    //   176: fdiv
    //   177: invokespecial 229	com/tencent/tav/coremedia/CMTime:<init>	(F)V
    //   180: putfield 561	com/tencent/tav/decoder/AudioDecoder$PendingFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   183: aload 5
    //   185: aload_0
    //   186: getfield 165	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   189: aload_0
    //   190: getfield 545	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   193: invokevirtual 565	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   196: invokevirtual 569	com/tencent/tav/coremedia/CMTime:sub	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   199: putfield 496	com/tencent/tav/decoder/AudioDecoder$PendingFrame:seekStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   202: aload_0
    //   203: getfield 127	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   206: invokevirtual 324	java/util/ArrayList:size	()I
    //   209: ifne +9 -> 218
    //   212: aload 5
    //   214: iconst_1
    //   215: putfield 572	com/tencent/tav/decoder/AudioDecoder$PendingFrame:isFirst	Z
    //   218: aload_0
    //   219: getfield 127	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   222: aload 5
    //   224: invokevirtual 266	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   227: pop
    //   228: aload_0
    //   229: getfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   232: invokevirtual 575	com/tencent/tav/extractor/AssetExtractor:advance	()Z
    //   235: pop
    //   236: ldc_w 540
    //   239: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: goto -166 -> 76
    //   245: astore 5
    //   247: aload_0
    //   248: monitorexit
    //   249: aload 5
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	AudioDecoder
    //   51	79	1	i	int
    //   105	27	2	j	int
    //   15	150	3	l	long
    //   93	130	5	localObject1	Object
    //   245	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	39	245	finally
    //   47	52	245	finally
    //   56	70	245	finally
    //   70	76	245	finally
    //   79	84	245	finally
    //   88	106	245	finally
    //   110	218	245	finally
    //   218	228	245	finally
    //   228	236	245	finally
    //   236	242	245	finally
  }
  
  /* Error */
  private void releaseOutputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 576
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 160	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   12: istore_1
    //   13: iload_1
    //   14: iconst_m1
    //   15: if_icmpeq +17 -> 32
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 160	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   23: iconst_0
    //   24: invokespecial 486	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 160	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 147	com/tencent/tav/decoder/AudioDecoder:decodeBuffer	Ljava/nio/ByteBuffer;
    //   37: ldc_w 576
    //   40: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   51: ldc_w 577
    //   54: aload_2
    //   55: invokestatic 336	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: goto -31 -> 27
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	AudioDecoder
    //   12	4	1	i	int
    //   46	9	2	localException	Exception
    //   61	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	27	46	java/lang/Exception
    //   2	13	61	finally
    //   18	27	61	finally
    //   27	32	61	finally
    //   32	43	61	finally
    //   47	58	61	finally
  }
  
  /* Error */
  private void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 578
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 255	com/tencent/tav/decoder/AudioDecoder:decoder	Lcom/tencent/tav/codec/IMediaCodec;
    //   12: iload_1
    //   13: iload_2
    //   14: invokeinterface 579 3 0
    //   19: ldc_w 578
    //   22: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   33: ldc_w 577
    //   36: aload_3
    //   37: invokestatic 336	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 21
    //   45: if_icmplt +103 -> 148
    //   48: aload_3
    //   49: instanceof 362
    //   52: ifeq +96 -> 148
    //   55: getstatic 342	android/os/Build$VERSION:SDK_INT	I
    //   58: bipush 23
    //   60: if_icmplt +65 -> 125
    //   63: aload_0
    //   64: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   67: new 92	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 384
    //   74: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_3
    //   78: checkcast 362	android/media/MediaCodec$CodecException
    //   81: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   84: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   87: ldc_w 389
    //   90: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: checkcast 362	android/media/MediaCodec$CodecException
    //   97: invokevirtual 369	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   100: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: ldc_w 391
    //   106: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: checkcast 362	android/media/MediaCodec$CodecException
    //   113: invokevirtual 394	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   116: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 399	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_3
    //   126: checkcast 362	android/media/MediaCodec$CodecException
    //   129: invokevirtual 366	android/media/MediaCodec$CodecException:isTransient	()Z
    //   132: ifeq +16 -> 148
    //   135: aload_0
    //   136: ldc2_w 23
    //   139: invokespecial 403	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   142: aload_0
    //   143: iload_1
    //   144: iload_2
    //   145: invokespecial 486	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   148: ldc_w 578
    //   151: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_3
    //   155: athrow
    //   156: astore_3
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    //   161: astore_3
    //   162: goto -133 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	AudioDecoder
    //   0	165	1	paramInt	int
    //   0	165	2	paramBoolean	boolean
    //   28	127	3	localException	Exception
    //   156	4	3	localObject	Object
    //   161	1	3	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	19	28	java/lang/Exception
    //   2	8	156	finally
    //   8	19	156	finally
    //   19	25	156	finally
    //   29	125	156	finally
    //   125	148	156	finally
    //   148	156	156	finally
    //   8	19	161	java/lang/Error
  }
  
  private void reset()
  {
    try
    {
      AppMethodBeat.i(216179);
      if (this.isReleased) {
        AppMethodBeat.o(216179);
      }
      for (;;)
      {
        return;
        Logger.d(this.TAG, "reset() called");
        try
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label99;
          }
          this.decoder.reset();
          decoderConfigure(this.mediaFormat);
          start();
          AppMethodBeat.o(216179);
        }
        catch (Exception localException1)
        {
          Logger.e(this.TAG, "reset: ", localException1);
          AppMethodBeat.o(216179);
        }
        continue;
        try
        {
          this.decoder.stop();
          this.decoder.release();
          nameList.remove(this.decoder.toString());
          String str = this.mediaFormat.getString("mime");
          this.decoder = this.decoderFactory.createAudioDecoder(str, "tav-audio-decoder");
          this.decoder.setDataSource(this.extractor.getSourcePath());
          nameList.add(this.decoder.toString());
          decoderConfigure(this.mediaFormat);
          start();
          AppMethodBeat.o(216179);
        }
        catch (Exception localException2)
        {
          break label108;
        }
      }
    }
    finally {}
  }
  
  private boolean retryOnReadSampleError(MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(216319);
    if (paramCodecException.isRecoverable())
    {
      releaseOutputBuffer();
      reset();
      this.lastOutputBufferIndex = -1;
      this.pendingFrames.clear();
      l1 = this.currentStartTime.getTimeUs();
      l2 = this.timeRange.getStartUs();
      this.extractor.seekTo(l1 - l2, 0);
      this.extractorDone = false;
    }
    while (paramCodecException.isTransient())
    {
      long l1;
      long l2;
      AppMethodBeat.o(216319);
      return false;
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    AppMethodBeat.o(216319);
    return true;
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(216211);
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      AppMethodBeat.o(216211);
      return;
    }
    finally {}
  }
  
  private void start()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(216235);
        try
        {
          this.decoder.start();
          AppMethodBeat.o(216235);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(this.TAG, "start", localException);
          if (Build.VERSION.SDK_INT < 21) {
            break;
          }
        }
        if (!(localException instanceof MediaCodec.CodecException)) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(2L);
          start();
          AppMethodBeat.o(216235);
          continue;
        }
        if (!((MediaCodec.CodecException)localObject).isRecoverable()) {
          break;
        }
      }
      finally {}
      reset();
      AppMethodBeat.o(216235);
    }
    release();
    AppMethodBeat.o(216235);
    throw localObject;
  }
  
  private void waitTime(long paramLong)
  {
    try
    {
      AppMethodBeat.i(216221);
      try
      {
        wait(paramLong);
        AppMethodBeat.o(216221);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Logger.e(this.TAG, "waitTime", localInterruptedException);
          AppMethodBeat.o(216221);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(216460);
    super.finalize();
    release(false);
    AppMethodBeat.o(216460);
  }
  
  public AudioInfo getAudioInfo()
  {
    if (this.outputAudioInfo != null) {
      return this.outputAudioInfo;
    }
    return this.decodeAudioInfo;
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    return null;
  }
  
  public String getSourcePath()
  {
    AppMethodBeat.i(216368);
    if (this.extractor == null)
    {
      AppMethodBeat.o(216368);
      return null;
    }
    String str = this.extractor.getSourcePath();
    AppMethodBeat.o(216368);
    return str;
  }
  
  /* Error */
  public boolean hasTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 129	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
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
    //   0	28	0	this	AudioDecoder
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public boolean isStarted()
  {
    return this.started;
  }
  
  public CMTime nextFrameTime()
  {
    AppMethodBeat.i(216412);
    if (this.pendingFrames.size() > 0) {}
    for (CMTime localCMTime = ((PendingFrame)this.pendingFrames.get(0)).frameTime;; localCMTime = CMTime.CMTimeInvalid)
    {
      Iterator localIterator = this.pendingFrames.iterator();
      while (localIterator.hasNext()) {
        localCMTime = CMTime.min(((PendingFrame)localIterator.next()).frameTime, localCMTime);
      }
    }
    AppMethodBeat.o(216412);
    return localCMTime;
  }
  
  /* Error */
  public ByteBuffer outputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	com/tencent/tav/decoder/AudioDecoder:decodeBuffer	Ljava/nio/ByteBuffer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 149	com/tencent/tav/decoder/AudioDecoder:outputBuffer	Ljava/nio/ByteBuffer;
    //   21: ifnonnull +11 -> 32
    //   24: aload_0
    //   25: getfield 147	com/tencent/tav/decoder/AudioDecoder:decodeBuffer	Ljava/nio/ByteBuffer;
    //   28: astore_1
    //   29: goto -16 -> 13
    //   32: aload_0
    //   33: getfield 149	com/tencent/tav/decoder/AudioDecoder:outputBuffer	Ljava/nio/ByteBuffer;
    //   36: astore_1
    //   37: goto -24 -> 13
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	AudioDecoder
    //   6	31	1	localByteBuffer	ByteBuffer
    //   40	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   17	29	40	finally
    //   32	37	40	finally
  }
  
  public CMSampleState readSample()
  {
    try
    {
      AppMethodBeat.i(216419);
      CMSampleState localCMSampleState = readSample(CMTime.CMTimeInvalid);
      AppMethodBeat.o(216419);
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
    try
    {
      AppMethodBeat.i(216428);
      Logger.v(this.TAG, "readSample: " + paramCMTime + "  -  " + this.extractor.getSampleTime());
      this.currentSampleState = doReadSample(paramCMTime, false);
      CMSampleState localCMSampleState = this.currentSampleState;
      if ((this.currentSampleState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentSampleState.getTime().smallThan(this.duration))) {
        clearDecoder();
      }
      Logger.v(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentSampleState);
      AppMethodBeat.o(216428);
      return localCMSampleState;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(216437);
      release(true);
      AppMethodBeat.o(216437);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 681
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 131	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 681
    //   18: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 683
    //   31: iload_1
    //   32: invokestatic 686	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   35: invokevirtual 356	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokestatic 359	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 689	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 125	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 131	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   67: aload_0
    //   68: getfield 151	com/tencent/tav/decoder/AudioDecoder:decoderCreateLock	Ljava/lang/Object;
    //   71: astore_2
    //   72: aload_2
    //   73: monitorenter
    //   74: aload_0
    //   75: getfield 255	com/tencent/tav/decoder/AudioDecoder:decoder	Lcom/tencent/tav/codec/IMediaCodec;
    //   78: ifnull +14 -> 92
    //   81: new 8	com/tencent/tav/decoder/AudioDecoder$1
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 691	com/tencent/tav/decoder/AudioDecoder$1:<init>	(Lcom/tencent/tav/decoder/AudioDecoder;)V
    //   89: invokevirtual 692	com/tencent/tav/decoder/AudioDecoder$1:start	()V
    //   92: aload_2
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   98: ldc_w 694
    //   101: iload_1
    //   102: invokestatic 686	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   105: invokevirtual 356	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokestatic 359	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc_w 681
    //   114: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: goto -96 -> 21
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_2
    //   127: monitorexit
    //   128: ldc_w 681
    //   131: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_3
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	AudioDecoder
    //   0	136	1	paramBoolean	boolean
    //   120	7	2	localObject2	Object
    //   125	10	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	120	finally
    //   24	41	120	finally
    //   45	57	120	finally
    //   57	74	120	finally
    //   94	117	120	finally
    //   126	136	120	finally
    //   74	92	125	finally
    //   92	94	125	finally
  }
  
  /* Error */
  public void seekTo(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 695
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   12: new 92	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 697
    //   19: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: ldc_w 699
    //   29: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: ldc_w 508
    //   39: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 165	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   46: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc_w 508
    //   52: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 138	com/tencent/tav/decoder/AudioDecoder:currentSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   59: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 321	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 125	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   72: ifeq +11 -> 83
    //   75: aload_0
    //   76: getfield 129	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   79: iconst_m1
    //   80: if_icmpne +58 -> 138
    //   83: aload_0
    //   84: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   87: new 92	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 701
    //   94: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 125	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   101: invokevirtual 387	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 703
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 129	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   114: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 705
    //   120: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 399	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: ldc_w 695
    //   132: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: aload_1
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 499	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   144: lconst_0
    //   145: lcmp
    //   146: ifge +7 -> 153
    //   149: getstatic 121	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   152: astore_2
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 545	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   158: invokevirtual 565	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   161: aload_2
    //   162: invokevirtual 707	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   165: putfield 165	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 172	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 165	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   178: invokevirtual 499	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   181: invokespecial 709	com/tencent/tav/decoder/AudioDecoder:seekExtractorTo	(J)V
    //   184: aload_0
    //   185: getfield 116	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   188: new 92	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 711
    //   195: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 165	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   202: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: ldc_w 508
    //   208: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_0
    //   212: getfield 183	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   215: invokevirtual 543	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   218: invokevirtual 506	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 321	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 695
    //   230: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: goto -98 -> 135
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	AudioDecoder
    //   0	241	1	paramCMTime	CMTime
    //   139	23	2	localCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	83	236	finally
    //   83	135	236	finally
    //   140	153	236	finally
    //   153	233	236	finally
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(216386);
      start(paramCMTimeRange, CMTime.CMTimeZero);
      AppMethodBeat.o(216386);
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
        AppMethodBeat.i(216394);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          AppMethodBeat.o(216394);
          return;
        }
        clearDecoder();
        if (paramCMTimeRange == null)
        {
          this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
          this.extractorDone = false;
          this.started = true;
          if (paramCMTime.getTimeUs() >= 0L) {
            seekTo(paramCMTime);
          }
          AppMethodBeat.o(216394);
        }
        else
        {
          this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
        }
      }
      finally {}
    }
  }
  
  static class PendingFrame
  {
    public CMTime frameTime = CMTime.CMTimeZero;
    public boolean isFirst = false;
    public CMTime seekStartTime = CMTime.CMTimeZero;
    public long timeOffset = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */