package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class AudioDecoder
  implements IDecoder
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final int MAX_WAIT_TIME = 1000;
  private static final long WAIT_TRANSIENT_MS = 2L;
  private static final ArrayList<String> nameList;
  private final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  private CMSampleState currentSampleState;
  private CMTime currentStartTime;
  private AudioInfo decodeAudioInfo;
  private ByteBuffer decodeBuffer;
  private MediaCodec decoder;
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
    AppMethodBeat.i(218107);
    nameList = new ArrayList();
    AppMethodBeat.o(218107);
  }
  
  public AudioDecoder(String paramString)
  {
    AppMethodBeat.i(218080);
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
    this.pFrameTime = new CMTime(20L, 600);
    this.lastOutputBufferIndex = -1;
    this.currentStartTime = CMTime.CMTimeInvalid;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.extractorDone = false;
    this.mTimeOffset = 0L;
    this.mLastVideoQueueTime = 0L;
    this.extractor = new AssetExtractor();
    this.extractor.setDataSource(paramString);
    while (this.extractor.getSampleTrackIndex() != -1) {
      this.extractor.unselectTrack(this.extractor.getSampleTrackIndex());
    }
    this.trackIndex = DecoderUtils.getFirstTrackIndex(this.extractor, "audio/");
    if (this.trackIndex == -1)
    {
      this.decodeBuffer = null;
      AppMethodBeat.o(218080);
      return;
    }
    this.extractor.selectTrack(this.trackIndex);
    this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
    this.duration = new CMTime((float)this.extractor.getAudioDuration() * 1.0F / (float)TimeUnit.SECONDS.toMicros(1L));
    if (this.mediaFormat.containsKey("frame-rate")) {
      this.pFrameTime = new CMTime(600 / this.mediaFormat.getInteger("frame-rate"), 600);
    }
    this.decoder = MediaCodec.createDecoderByType(this.mediaFormat.getString("mime"));
    nameList.add(this.decoder.toString());
    if (decoderConfigure(this.mediaFormat))
    {
      start();
      this.decodeAudioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
      this.decodeAudioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
      paramString = new AudioInfo();
      paramString.channelCount = 1;
      paramString.sampleRate = 44100;
      paramString.pcmEncoding = 2;
      AppMethodBeat.o(218080);
      return;
    }
    paramString = new IllegalStateException("decoderConfigure failed!");
    AppMethodBeat.o(218080);
    throw paramString;
  }
  
  private void clearDecoder()
  {
    AppMethodBeat.i(218085);
    Logger.v(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.decoder.flush();
      this.pendingFrames.clear();
      this.currentSampleState = new CMSampleState();
      AppMethodBeat.o(218085);
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
        AppMethodBeat.i(218082);
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.decoder.configure(paramMediaFormat, null, null, 0);
          AppMethodBeat.o(218082);
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
            AppMethodBeat.o(218082);
            bool = false;
            continue;
          }
          this.decoder.configure(paramMediaFormat, null, null, 0);
          AppMethodBeat.o(218082);
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
          AppMethodBeat.o(218082);
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
    //   2: ldc_w 353
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 238	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: ldc2_w 354
    //   15: invokevirtual 358	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   18: istore_1
    //   19: ldc_w 353
    //   22: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   34: ldc_w 359
    //   37: aload_2
    //   38: invokestatic 313	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 21
    //   46: if_icmplt +116 -> 162
    //   49: aload_2
    //   50: instanceof 339
    //   53: ifeq +109 -> 162
    //   56: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 23
    //   61: if_icmplt +65 -> 126
    //   64: aload_0
    //   65: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   68: new 82	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 361
    //   75: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: checkcast 339	android/media/MediaCodec$CodecException
    //   82: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   85: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: ldc_w 366
    //   91: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: checkcast 339	android/media/MediaCodec$CodecException
    //   98: invokevirtual 346	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   101: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 368
    //   107: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: checkcast 339	android/media/MediaCodec$CodecException
    //   114: invokevirtual 371	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   117: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 376	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_2
    //   127: checkcast 339	android/media/MediaCodec$CodecException
    //   130: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   133: ifeq +29 -> 162
    //   136: aload_0
    //   137: ldc2_w 19
    //   140: invokespecial 380	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   143: aload_0
    //   144: invokespecial 382	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   147: istore_1
    //   148: ldc_w 353
    //   151: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: goto -129 -> 25
    //   157: astore_2
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: ldc_w 353
    //   165: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_2
    //   169: athrow
    //   170: astore_2
    //   171: goto -141 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	AudioDecoder
    //   18	130	1	i	int
    //   29	98	2	localException	Exception
    //   157	12	2	localObject	Object
    //   170	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	19	29	java/lang/Exception
    //   2	8	157	finally
    //   8	19	157	finally
    //   19	25	157	finally
    //   30	126	157	finally
    //   126	154	157	finally
    //   162	170	157	finally
    //   8	19	170	java/lang/Error
  }
  
  private int dequeueOutputBuffer()
  {
    try
    {
      AppMethodBeat.i(218092);
      for (;;)
      {
        try
        {
          i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
          AppMethodBeat.o(218092);
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
        AppMethodBeat.o(218092);
      }
      AppMethodBeat.o(218092);
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
    label337:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(218100);
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
            AppMethodBeat.o(218100);
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
            break label655;
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
            break label337;
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
            break label935;
          }
        }
        if ((!(paramCMTime instanceof MediaCodec.CodecException)) || (!retryOnReadSampleError((MediaCodec.CodecException)paramCMTime))) {
          break label935;
        }
        paramCMTime = CMSampleState.fromError(-3L, "catch exception, retry", paramCMTime);
        AppMethodBeat.o(218100);
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
            break label473;
          }
          paramCMTime.position(this.bufferInfo.offset);
          paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
        }
        for (this.decodeBuffer = paramCMTime;; this.decodeBuffer = null)
        {
          Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          paramCMTime = CMSampleState.fromError(-1L);
          AppMethodBeat.o(218100);
          break;
          label473:
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
    label655:
    label932:
    label935:
    label955:
    label967:
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
          break label955;
        }
        paramCMTime = CMSampleState.fromError(-1L);
        AppMethodBeat.o(218100);
        break;
        if (paramCMTime.seekStartTime.getTimeUs() <= l1) {
          break label967;
        }
        releaseOutputBuffer(j, false);
        paramCMTime = CMSampleState.fromError(-2L);
        break label162;
        releaseOutputBuffer(j, false);
        Logger.e(this.TAG, "doReadSample:[error] " + this.bufferInfo.size + " byteBuffer==null");
        paramCMTime = CMSampleState.fromError(-3L);
        AppMethodBeat.o(218100);
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
            AppMethodBeat.o(218100);
            break;
          }
          releaseOutputBuffer(j, false);
          paramCMTime = CMSampleState.fromError(-2L);
        }
        i += 1;
        if (i <= 1000) {
          break label932;
        }
        localObject = CMSampleState.fromError(-4L);
        Logger.e(this.TAG, "doReadSample: [timeout] ");
      }
      break label162;
      paramCMTime = CMSampleState.fromError(-3L, "catch exception", paramCMTime);
      AppMethodBeat.o(218100);
      break;
      AppMethodBeat.o(218100);
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
    //   2: ldc_w 503
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 238	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: invokestatic 506	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   16: astore_2
    //   17: ldc_w 503
    //   20: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   32: ldc_w 507
    //   35: aload_2
    //   36: invokestatic 313	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   42: bipush 21
    //   44: if_icmplt +117 -> 161
    //   47: aload_2
    //   48: instanceof 339
    //   51: ifeq +110 -> 161
    //   54: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 23
    //   59: if_icmplt +65 -> 124
    //   62: aload_0
    //   63: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   66: new 82	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 361
    //   73: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: checkcast 339	android/media/MediaCodec$CodecException
    //   80: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   83: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   86: ldc_w 366
    //   89: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: checkcast 339	android/media/MediaCodec$CodecException
    //   96: invokevirtual 346	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   99: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: ldc_w 368
    //   105: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: checkcast 339	android/media/MediaCodec$CodecException
    //   112: invokevirtual 371	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   115: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 376	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: checkcast 339	android/media/MediaCodec$CodecException
    //   128: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   131: ifeq +30 -> 161
    //   134: aload_0
    //   135: ldc2_w 19
    //   138: invokespecial 380	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   141: aload_0
    //   142: iload_1
    //   143: invokespecial 509	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   146: astore_2
    //   147: ldc_w 503
    //   150: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: goto -130 -> 23
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: ldc_w 503
    //   164: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_2
    //   168: athrow
    //   169: astore_2
    //   170: goto -142 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	AudioDecoder
    //   0	173	1	paramInt	int
    //   16	10	2	localByteBuffer1	ByteBuffer
    //   27	98	2	localException	Exception
    //   146	1	2	localByteBuffer2	ByteBuffer
    //   156	12	2	localObject	Object
    //   169	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	17	27	java/lang/Exception
    //   2	8	156	finally
    //   8	17	156	finally
    //   17	23	156	finally
    //   28	124	156	finally
    //   124	153	156	finally
    //   161	169	156	finally
    //   8	17	169	java/lang/Error
  }
  
  /* Error */
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 510
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 238	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: invokestatic 512	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   16: astore_2
    //   17: ldc_w 510
    //   20: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   32: ldc_w 513
    //   35: aload_2
    //   36: invokestatic 313	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   42: bipush 21
    //   44: if_icmplt +117 -> 161
    //   47: aload_2
    //   48: instanceof 339
    //   51: ifeq +110 -> 161
    //   54: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 23
    //   59: if_icmplt +65 -> 124
    //   62: aload_0
    //   63: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   66: new 82	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 361
    //   73: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: checkcast 339	android/media/MediaCodec$CodecException
    //   80: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   83: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   86: ldc_w 366
    //   89: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: checkcast 339	android/media/MediaCodec$CodecException
    //   96: invokevirtual 346	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   99: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: ldc_w 368
    //   105: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: checkcast 339	android/media/MediaCodec$CodecException
    //   112: invokevirtual 371	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   115: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 376	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: checkcast 339	android/media/MediaCodec$CodecException
    //   128: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   131: ifeq +30 -> 161
    //   134: aload_0
    //   135: ldc2_w 19
    //   138: invokespecial 380	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   141: aload_0
    //   142: iload_1
    //   143: invokespecial 443	com/tencent/tav/decoder/AudioDecoder:getOutputBuffer	(I)Ljava/nio/ByteBuffer;
    //   146: astore_2
    //   147: ldc_w 510
    //   150: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: goto -130 -> 23
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: ldc_w 510
    //   164: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_2
    //   168: athrow
    //   169: astore_2
    //   170: goto -142 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	AudioDecoder
    //   0	173	1	paramInt	int
    //   16	10	2	localByteBuffer1	ByteBuffer
    //   27	98	2	localException	Exception
    //   146	1	2	localByteBuffer2	ByteBuffer
    //   156	12	2	localObject	Object
    //   169	1	2	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	17	27	java/lang/Exception
    //   2	8	156	finally
    //   8	17	156	finally
    //   17	23	156	finally
    //   28	124	156	finally
    //   124	153	156	finally
    //   161	169	156	finally
    //   8	17	169	java/lang/Error
  }
  
  /* Error */
  private void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 516
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 238	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: iload_2
    //   14: iload_3
    //   15: lload 4
    //   17: iload 6
    //   19: invokevirtual 518	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   22: ldc_w 516
    //   25: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore 7
    //   33: aload_0
    //   34: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   37: ldc_w 519
    //   40: aload 7
    //   42: invokestatic 313	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   45: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 21
    //   50: if_icmplt +113 -> 163
    //   53: aload 7
    //   55: instanceof 339
    //   58: ifeq +105 -> 163
    //   61: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   64: bipush 23
    //   66: if_icmplt +68 -> 134
    //   69: aload_0
    //   70: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   73: new 82	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 361
    //   80: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload 7
    //   85: checkcast 339	android/media/MediaCodec$CodecException
    //   88: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   91: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: ldc_w 366
    //   97: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 7
    //   102: checkcast 339	android/media/MediaCodec$CodecException
    //   105: invokevirtual 346	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   108: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   111: ldc_w 368
    //   114: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 7
    //   119: checkcast 339	android/media/MediaCodec$CodecException
    //   122: invokevirtual 371	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   125: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 376	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload 7
    //   136: checkcast 339	android/media/MediaCodec$CodecException
    //   139: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   142: ifeq +21 -> 163
    //   145: aload_0
    //   146: ldc2_w 19
    //   149: invokespecial 380	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   152: aload_0
    //   153: iload_1
    //   154: iload_2
    //   155: iload_3
    //   156: lload 4
    //   158: iload 6
    //   160: invokespecial 520	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   163: ldc_w 516
    //   166: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload 7
    //   171: athrow
    //   172: astore 7
    //   174: aload_0
    //   175: monitorexit
    //   176: aload 7
    //   178: athrow
    //   179: astore 7
    //   181: goto -148 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AudioDecoder
    //   0	184	1	paramInt1	int
    //   0	184	2	paramInt2	int
    //   0	184	3	paramInt3	int
    //   0	184	4	paramLong	long
    //   0	184	6	paramInt4	int
    //   31	139	7	localException	Exception
    //   172	5	7	localObject	Object
    //   179	1	7	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	22	31	java/lang/Exception
    //   2	8	172	finally
    //   8	22	172	finally
    //   22	28	172	finally
    //   33	134	172	finally
    //   134	163	172	finally
    //   163	172	172	finally
    //   8	22	179	java/lang/Error
  }
  
  /* Error */
  private void readFromExtractor()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 521
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   12: invokevirtual 524	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: aload_0
    //   18: getfield 526	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   21: invokevirtual 531	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   24: lcmp
    //   25: ifge +22 -> 47
    //   28: aload_0
    //   29: getfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   32: invokevirtual 175	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   35: iconst_m1
    //   36: if_icmpeq +11 -> 47
    //   39: lload_3
    //   40: ldc2_w 460
    //   43: lcmp
    //   44: ifne +35 -> 79
    //   47: aload_0
    //   48: invokespecial 382	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   51: istore_1
    //   52: iload_1
    //   53: iflt +17 -> 70
    //   56: aload_0
    //   57: iload_1
    //   58: iconst_0
    //   59: iconst_0
    //   60: lconst_0
    //   61: iconst_4
    //   62: invokespecial 520	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 160	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   70: ldc_w 521
    //   73: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: invokespecial 382	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   83: istore_1
    //   84: iload_1
    //   85: iflt +151 -> 236
    //   88: aload_0
    //   89: iload_1
    //   90: invokespecial 509	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   93: astore 5
    //   95: aload_0
    //   96: getfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   99: aload 5
    //   101: iconst_0
    //   102: invokevirtual 535	com/tencent/tav/extractor/AssetExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   105: istore_2
    //   106: iload_2
    //   107: iflt +121 -> 228
    //   110: aload_0
    //   111: lload_3
    //   112: aload_0
    //   113: getfield 526	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   116: invokevirtual 538	com/tencent/tav/coremedia/CMTimeRange:getStartUs	()J
    //   119: lsub
    //   120: aload_0
    //   121: getfield 162	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   124: ladd
    //   125: putfield 164	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   128: aload_0
    //   129: iload_1
    //   130: iconst_0
    //   131: iload_2
    //   132: aload_0
    //   133: getfield 164	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   136: iconst_0
    //   137: invokespecial 520	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   140: new 10	com/tencent/tav/decoder/AudioDecoder$PendingFrame
    //   143: dup
    //   144: invokespecial 539	com/tencent/tav/decoder/AudioDecoder$PendingFrame:<init>	()V
    //   147: astore 5
    //   149: aload 5
    //   151: aload_0
    //   152: getfield 162	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   155: putfield 470	com/tencent/tav/decoder/AudioDecoder$PendingFrame:timeOffset	J
    //   158: aload 5
    //   160: new 108	com/tencent/tav/coremedia/CMTime
    //   163: dup
    //   164: lload_3
    //   165: l2f
    //   166: fconst_1
    //   167: fmul
    //   168: getstatic 205	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   171: lconst_1
    //   172: invokevirtual 209	java/util/concurrent/TimeUnit:toMicros	(J)J
    //   175: l2f
    //   176: fdiv
    //   177: invokespecial 212	com/tencent/tav/coremedia/CMTime:<init>	(F)V
    //   180: putfield 542	com/tencent/tav/decoder/AudioDecoder$PendingFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   183: aload 5
    //   185: aload_0
    //   186: getfield 153	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   189: aload_0
    //   190: getfield 526	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   193: invokevirtual 546	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   196: invokevirtual 550	com/tencent/tav/coremedia/CMTime:sub	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   199: putfield 474	com/tencent/tav/decoder/AudioDecoder$PendingFrame:seekStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   202: aload_0
    //   203: getfield 117	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   206: invokevirtual 301	java/util/ArrayList:size	()I
    //   209: ifne +9 -> 218
    //   212: aload 5
    //   214: iconst_1
    //   215: putfield 553	com/tencent/tav/decoder/AudioDecoder$PendingFrame:isFirst	Z
    //   218: aload_0
    //   219: getfield 117	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   222: aload 5
    //   224: invokevirtual 243	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   227: pop
    //   228: aload_0
    //   229: getfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   232: invokevirtual 556	com/tencent/tav/extractor/AssetExtractor:advance	()Z
    //   235: pop
    //   236: ldc_w 521
    //   239: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 557
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 148	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   12: istore_1
    //   13: iload_1
    //   14: iconst_m1
    //   15: if_icmpeq +17 -> 32
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 148	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   23: iconst_0
    //   24: invokespecial 464	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 148	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 137	com/tencent/tav/decoder/AudioDecoder:decodeBuffer	Ljava/nio/ByteBuffer;
    //   37: ldc_w 557
    //   40: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   51: ldc_w 558
    //   54: aload_2
    //   55: invokestatic 313	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   2: ldc_w 559
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 238	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: iload_2
    //   14: invokevirtual 560	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   17: ldc_w 559
    //   20: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   31: ldc_w 558
    //   34: aload_3
    //   35: invokestatic 313	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   38: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   41: bipush 21
    //   43: if_icmplt +103 -> 146
    //   46: aload_3
    //   47: instanceof 339
    //   50: ifeq +96 -> 146
    //   53: getstatic 319	android/os/Build$VERSION:SDK_INT	I
    //   56: bipush 23
    //   58: if_icmplt +65 -> 123
    //   61: aload_0
    //   62: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   65: new 82	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 361
    //   72: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_3
    //   76: checkcast 339	android/media/MediaCodec$CodecException
    //   79: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   82: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 366
    //   88: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_3
    //   92: checkcast 339	android/media/MediaCodec$CodecException
    //   95: invokevirtual 346	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   98: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: ldc_w 368
    //   104: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: checkcast 339	android/media/MediaCodec$CodecException
    //   111: invokevirtual 371	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   114: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 376	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_3
    //   124: checkcast 339	android/media/MediaCodec$CodecException
    //   127: invokevirtual 343	android/media/MediaCodec$CodecException:isTransient	()Z
    //   130: ifeq +16 -> 146
    //   133: aload_0
    //   134: ldc2_w 19
    //   137: invokespecial 380	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   140: aload_0
    //   141: iload_1
    //   142: iload_2
    //   143: invokespecial 464	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   146: ldc_w 559
    //   149: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_3
    //   153: athrow
    //   154: astore_3
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_3
    //   158: athrow
    //   159: astore_3
    //   160: goto -133 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	AudioDecoder
    //   0	163	1	paramInt	int
    //   0	163	2	paramBoolean	boolean
    //   26	127	3	localException	Exception
    //   154	4	3	localObject	Object
    //   159	1	3	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   8	17	26	java/lang/Exception
    //   2	8	154	finally
    //   8	17	154	finally
    //   17	23	154	finally
    //   27	123	154	finally
    //   123	146	154	finally
    //   146	154	154	finally
    //   8	17	159	java/lang/Error
  }
  
  private void reset()
  {
    try
    {
      AppMethodBeat.i(218081);
      if (this.isReleased) {
        AppMethodBeat.o(218081);
      }
      for (;;)
      {
        return;
        Logger.d(this.TAG, "reset() called");
        try
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label97;
          }
          this.decoder.reset();
          decoderConfigure(this.mediaFormat);
          start();
          AppMethodBeat.o(218081);
        }
        catch (Exception localException1)
        {
          Logger.e(this.TAG, "reset: ", localException1);
          AppMethodBeat.o(218081);
        }
        continue;
        try
        {
          this.decoder.stop();
          this.decoder.release();
          nameList.remove(this.decoder.toString());
          this.decoder = MediaCodec.createDecoderByType(this.mediaFormat.getString("mime"));
          nameList.add(this.decoder.toString());
          decoderConfigure(this.mediaFormat);
          start();
          AppMethodBeat.o(218081);
        }
        catch (Exception localException2)
        {
          break label104;
        }
      }
    }
    finally {}
  }
  
  private boolean retryOnReadSampleError(MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(218101);
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
      AppMethodBeat.o(218101);
      return false;
    }
    Logger.e(this.TAG, "doReadSample:[error] retry failed");
    AppMethodBeat.o(218101);
    return true;
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(218089);
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      AppMethodBeat.o(218089);
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
        AppMethodBeat.i(218091);
        try
        {
          this.decoder.start();
          AppMethodBeat.o(218091);
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
          AppMethodBeat.o(218091);
          continue;
        }
        if (!((MediaCodec.CodecException)localObject).isRecoverable()) {
          break;
        }
      }
      finally {}
      reset();
      AppMethodBeat.o(218091);
    }
    release();
    AppMethodBeat.o(218091);
    throw localObject;
  }
  
  private void waitTime(long paramLong)
  {
    try
    {
      AppMethodBeat.i(218090);
      try
      {
        wait(paramLong);
        AppMethodBeat.o(218090);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Logger.e(this.TAG, "waitTime", localInterruptedException);
          AppMethodBeat.o(218090);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(218105);
    super.finalize();
    release(false);
    AppMethodBeat.o(218105);
  }
  
  public AudioInfo getAudioInfo()
  {
    if (this.outputAudioInfo != null) {
      return this.outputAudioInfo;
    }
    return this.decodeAudioInfo;
  }
  
  public String getSourcePath()
  {
    AppMethodBeat.i(218079);
    if (this.extractor == null)
    {
      AppMethodBeat.o(218079);
      return null;
    }
    String str = this.extractor.getSourcePath();
    AppMethodBeat.o(218079);
    return str;
  }
  
  /* Error */
  public boolean hasTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
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
    AppMethodBeat.i(218087);
    if (this.pendingFrames.size() > 0) {}
    for (CMTime localCMTime = ((PendingFrame)this.pendingFrames.get(0)).frameTime;; localCMTime = CMTime.CMTimeInvalid)
    {
      Iterator localIterator = this.pendingFrames.iterator();
      while (localIterator.hasNext()) {
        localCMTime = CMTime.min(((PendingFrame)localIterator.next()).frameTime, localCMTime);
      }
    }
    AppMethodBeat.o(218087);
    return localCMTime;
  }
  
  /* Error */
  public ByteBuffer outputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 137	com/tencent/tav/decoder/AudioDecoder:decodeBuffer	Ljava/nio/ByteBuffer;
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
    //   18: getfield 139	com/tencent/tav/decoder/AudioDecoder:outputBuffer	Ljava/nio/ByteBuffer;
    //   21: ifnonnull +11 -> 32
    //   24: aload_0
    //   25: getfield 137	com/tencent/tav/decoder/AudioDecoder:decodeBuffer	Ljava/nio/ByteBuffer;
    //   28: astore_1
    //   29: goto -16 -> 13
    //   32: aload_0
    //   33: getfield 139	com/tencent/tav/decoder/AudioDecoder:outputBuffer	Ljava/nio/ByteBuffer;
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
      AppMethodBeat.i(218098);
      CMSampleState localCMSampleState = readSample(CMTime.CMTimeInvalid);
      AppMethodBeat.o(218098);
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
      AppMethodBeat.i(218099);
      Logger.v(this.TAG, "readSample: " + paramCMTime + "  -  " + this.extractor.getSampleTime());
      this.currentSampleState = doReadSample(paramCMTime, false);
      CMSampleState localCMSampleState = this.currentSampleState;
      if ((this.currentSampleState.stateMatchingTo(new long[] { -1L, -4L })) || (!this.currentSampleState.getTime().smallThan(this.duration))) {
        clearDecoder();
      }
      Logger.v(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentSampleState);
      AppMethodBeat.o(218099);
      return localCMSampleState;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(218103);
      release(true);
      AppMethodBeat.o(218103);
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
    //   2: ldc_w 660
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 121	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 660
    //   18: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 662
    //   31: iload_1
    //   32: invokestatic 665	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   35: invokevirtual 333	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokestatic 336	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 668	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 115	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 121	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   67: aload_0
    //   68: getfield 238	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   71: ifnull +14 -> 85
    //   74: new 8	com/tencent/tav/decoder/AudioDecoder$1
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 670	com/tencent/tav/decoder/AudioDecoder$1:<init>	(Lcom/tencent/tav/decoder/AudioDecoder;)V
    //   82: invokevirtual 671	com/tencent/tav/decoder/AudioDecoder$1:start	()V
    //   85: aload_0
    //   86: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   89: ldc_w 673
    //   92: iload_1
    //   93: invokestatic 665	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   96: invokevirtual 333	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokestatic 336	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: ldc_w 660
    //   105: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: goto -87 -> 21
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	AudioDecoder
    //   0	116	1	paramBoolean	boolean
    //   111	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	111	finally
    //   24	41	111	finally
    //   45	57	111	finally
    //   57	85	111	finally
    //   85	108	111	finally
  }
  
  /* Error */
  public void seekTo(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 674
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   12: new 82	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 676
    //   19: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: ldc_w 678
    //   29: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: ldc_w 486
    //   39: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 153	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   46: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc_w 486
    //   52: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 128	com/tencent/tav/decoder/AudioDecoder:currentSampleState	Lcom/tencent/tav/coremedia/CMSampleState;
    //   59: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 298	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 115	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   72: ifeq +11 -> 83
    //   75: aload_0
    //   76: getfield 119	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   79: iconst_m1
    //   80: if_icmpne +58 -> 138
    //   83: aload_0
    //   84: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   87: new 82	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 680
    //   94: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 115	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   101: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 682
    //   107: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 119	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   114: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 684
    //   120: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 376	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: ldc_w 674
    //   132: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: aload_1
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 477	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   144: lconst_0
    //   145: lcmp
    //   146: ifge +7 -> 153
    //   149: getstatic 111	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   152: astore_2
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 526	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   158: invokevirtual 546	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   161: aload_2
    //   162: invokevirtual 686	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   165: putfield 153	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 160	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 153	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   178: invokevirtual 477	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   181: invokespecial 688	com/tencent/tav/decoder/AudioDecoder:seekExtractorTo	(J)V
    //   184: aload_0
    //   185: getfield 106	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   188: new 82	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 690
    //   195: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 153	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   202: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: ldc_w 486
    //   208: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_0
    //   212: getfield 169	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   215: invokevirtual 524	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   218: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 298	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 674
    //   230: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(218083);
      start(paramCMTimeRange, CMTime.CMTimeZero);
      AppMethodBeat.o(218083);
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
        AppMethodBeat.i(218084);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          AppMethodBeat.o(218084);
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
          AppMethodBeat.o(218084);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */