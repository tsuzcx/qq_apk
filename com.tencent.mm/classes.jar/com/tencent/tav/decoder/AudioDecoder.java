package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static boolean LOG_VERBOSE = false;
  private static final int MAX_RETRY_COUNT = 10;
  private static final int MAX_WAIT_TIME = 1000;
  private static final long WAIT_TRANSIENT_MS = 2L;
  private static final ArrayList<String> nameList;
  private final String TAG;
  private AudioInfo _audioInfo;
  private ByteBuffer _outputBuffer;
  private MediaCodec.BufferInfo bufferInfo;
  private CMTime currentDecoderTime;
  private CMTime currentStartTime;
  private MediaCodec decoder;
  private CMTime duration;
  private AssetExtractor extractor;
  private boolean extractorDone;
  private boolean isReleased;
  private int lastOutputBufferIndex;
  private long mLastVideoQueueTime;
  private long mTimeOffset;
  private MediaFormat mediaFormat;
  private CMTime pFrameTime;
  private ArrayList<PendingFrame> pendingFrames;
  private boolean started;
  private CMTimeRange timeRange;
  public int trackIndex;
  
  static
  {
    AppMethodBeat.i(201677);
    LOG_VERBOSE = false;
    nameList = new ArrayList();
    AppMethodBeat.o(201677);
  }
  
  public AudioDecoder(String paramString)
  {
    AppMethodBeat.i(201651);
    this.TAG = ("AudioDecoder@" + Integer.toHexString(hashCode()));
    this.duration = CMTime.CMTimeZero;
    this.started = false;
    this.pendingFrames = new ArrayList();
    this.trackIndex = -1;
    this.isReleased = false;
    this.currentDecoderTime = CMTime.CMTimeZero;
    this.pFrameTime = new CMTime(20L, 600);
    this._audioInfo = new AudioInfo();
    this._outputBuffer = null;
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
      this._outputBuffer = null;
      AppMethodBeat.o(201651);
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
      this._audioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
      this._audioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
      AppMethodBeat.o(201651);
      return;
    }
    paramString = new IllegalStateException("decoderConfigure failed!");
    AppMethodBeat.o(201651);
    throw paramString;
  }
  
  private void clearDecoder()
  {
    AppMethodBeat.i(201656);
    Logger.d(this.TAG, "clearDecoder " + getSourcePath());
    releaseOutputBuffer();
    if ((this.pendingFrames.size() != 0) || (this.extractorDone)) {}
    try
    {
      this.decoder.flush();
      this.pendingFrames.clear();
      this.currentDecoderTime = CMTime.CMTimeInvalid;
      AppMethodBeat.o(201656);
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
        AppMethodBeat.i(201653);
        boolean bool;
        if (Build.VERSION.SDK_INT < 21)
        {
          this.decoder.configure(paramMediaFormat, null, null, 0);
          AppMethodBeat.o(201653);
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
            AppMethodBeat.o(201653);
            bool = false;
            continue;
          }
          this.decoder.configure(paramMediaFormat, null, null, 0);
          AppMethodBeat.o(201653);
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
          AppMethodBeat.o(201653);
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
    //   2: ldc_w 337
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 230	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: ldc2_w 338
    //   15: invokevirtual 342	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   18: istore_1
    //   19: ldc_w 337
    //   22: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   34: ldc_w 343
    //   37: aload_2
    //   38: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   41: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 21
    //   46: if_icmplt +116 -> 162
    //   49: aload_2
    //   50: instanceof 323
    //   53: ifeq +109 -> 162
    //   56: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   59: bipush 23
    //   61: if_icmplt +65 -> 126
    //   64: aload_0
    //   65: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   68: new 83	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 345
    //   75: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: checkcast 323	android/media/MediaCodec$CodecException
    //   82: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   85: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: ldc_w 350
    //   91: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: checkcast 323	android/media/MediaCodec$CodecException
    //   98: invokevirtual 330	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   101: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 352
    //   107: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: checkcast 323	android/media/MediaCodec$CodecException
    //   114: invokevirtual 355	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   117: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_2
    //   127: checkcast 323	android/media/MediaCodec$CodecException
    //   130: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   133: ifeq +29 -> 162
    //   136: aload_0
    //   137: ldc2_w 22
    //   140: invokespecial 364	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   143: aload_0
    //   144: invokespecial 366	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   147: istore_1
    //   148: ldc_w 337
    //   151: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: goto -129 -> 25
    //   157: astore_2
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: ldc_w 337
    //   165: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(201663);
      for (;;)
      {
        try
        {
          i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
          AppMethodBeat.o(201663);
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
        AppMethodBeat.o(201663);
      }
      AppMethodBeat.o(201663);
    }
    finally {}
    throw localObject;
  }
  
  private CMTime doReadSample(CMTime paramCMTime, boolean paramBoolean)
  {
    boolean bool = false;
    long l1;
    Object localObject;
    int i;
    label165:
    long l2;
    int j;
    label388:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(201671);
        if (LOG_VERBOSE) {
          Logger.d(this.TAG, "doReadSample - " + this.extractor.getSourcePath());
        }
        paramCMTime = SAMPLE_TIME_FAILED;
        l1 = SAMPLE_TIME_FAILED.value;
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
            Logger.d(paramCMTime, paramBoolean);
            paramCMTime = SAMPLE_TIME_UNSTART;
            AppMethodBeat.o(201671);
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
            break label689;
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
            break label388;
          }
          this._audioInfo.pcmEncoding = ((MediaFormat)localObject).getInteger("pcm-encoding");
          if (!((MediaFormat)localObject).containsKey("sample-rate")) {
            continue;
          }
          this._audioInfo.sampleRate = ((MediaFormat)localObject).getInteger("sample-rate");
        }
        catch (Exception paramCMTime)
        {
          Logger.e(this.TAG, "doReadSample", paramCMTime);
          if ((Build.VERSION.SDK_INT >= 21) && ((paramCMTime instanceof MediaCodec.CodecException)))
          {
            if (!((MediaCodec.CodecException)paramCMTime).isRecoverable()) {
              break label958;
            }
            releaseOutputBuffer();
            reset();
            this.lastOutputBufferIndex = -1;
            this.pendingFrames.clear();
            l1 = this.currentStartTime.getTimeUs();
            l2 = this.timeRange.getStartUs();
            this.extractor.seekTo(l1 - l2, 0);
            this.extractorDone = false;
          }
        }
        label370:
        paramCMTime = SAMPLE_TIME_ERROR;
        AppMethodBeat.o(201671);
        continue;
        this._audioInfo.pcmEncoding = 2;
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
          paramCMTime = getOnputBuffer(j);
          if (paramCMTime == null) {
            break label521;
          }
          paramCMTime.position(this.bufferInfo.offset);
          paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
        }
        for (this._outputBuffer = paramCMTime;; this._outputBuffer = null)
        {
          Logger.e(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
          paramCMTime = SAMPLE_TIME_FINISH;
          AppMethodBeat.o(201671);
          break;
          label521:
          releaseOutputBuffer(j, false);
        }
      }
      paramCMTime = (PendingFrame)this.pendingFrames.remove(0);
      l1 = this.bufferInfo.presentationTimeUs - paramCMTime.timeOffset;
      localObject = new CMTime(l1, 1000000);
      if ((this.pendingFrames.size() == 0) && (this.extractorDone) && (paramCMTime.seekStartTime.getTimeUs() + 1000L >= this.duration.getTimeUs())) {
        localObject = this.duration;
      }
    }
    label689:
    label955:
    label958:
    label991:
    label1003:
    for (;;)
    {
      if (this.bufferInfo.size > 0)
      {
        this.lastOutputBufferIndex = j;
        paramCMTime = getOnputBuffer(j);
        if (paramCMTime != null)
        {
          paramCMTime.position(this.bufferInfo.offset);
          paramCMTime.limit(this.bufferInfo.offset + this.bufferInfo.size);
          this._outputBuffer = paramCMTime;
        }
      }
      for (l2 = l1;; l2 = l1)
      {
        if (LOG_VERBOSE) {
          Logger.i(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + l2 + "  " + localObject, new Object[0]);
        }
        if ((!this.extractorDone) || (l2 >= 0L)) {
          break label991;
        }
        paramCMTime = SAMPLE_TIME_FINISH;
        AppMethodBeat.o(201671);
        break;
        if (paramCMTime.seekStartTime.getTimeUs() <= l1) {
          break label1003;
        }
        releaseOutputBuffer(j, false);
        paramCMTime = SAMPLE_TIME_FAILED;
        break label165;
        releaseOutputBuffer(j, false);
        Logger.e(this.TAG, "doReadSample:[error] " + this.bufferInfo.size + " byteBuffer==null");
        paramCMTime = SAMPLE_TIME_ERROR;
        AppMethodBeat.o(201671);
        break;
        releaseOutputBuffer(j, false);
        paramCMTime = SAMPLE_TIME_FAILED;
        break label165;
        if (j >= 0)
        {
          if (this.bufferInfo.flags == 4)
          {
            Logger.e(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
            paramCMTime = SAMPLE_TIME_FINISH;
            AppMethodBeat.o(201671);
            break;
          }
          releaseOutputBuffer(j, false);
          paramCMTime = SAMPLE_TIME_FAILED;
        }
        i += 1;
        if (i <= 1000) {
          break label955;
        }
        localObject = SAMPLE_TIME_TIMEOUT;
        Logger.e(this.TAG, "doReadSample: [timeout] ");
      }
      break label165;
      if (((MediaCodec.CodecException)paramCMTime).isTransient()) {
        break label370;
      }
      Logger.e(this.TAG, "doReadSample:[error] retry failed");
      paramCMTime = SAMPLE_TIME_ERROR;
      AppMethodBeat.o(201671);
      break;
      AppMethodBeat.o(201671);
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
    //   2: ldc_w 498
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 230	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: invokestatic 501	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   16: astore_2
    //   17: ldc_w 498
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   32: ldc_w 502
    //   35: aload_2
    //   36: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   42: bipush 21
    //   44: if_icmplt +117 -> 161
    //   47: aload_2
    //   48: instanceof 323
    //   51: ifeq +110 -> 161
    //   54: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 23
    //   59: if_icmplt +65 -> 124
    //   62: aload_0
    //   63: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   66: new 83	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 345
    //   73: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: checkcast 323	android/media/MediaCodec$CodecException
    //   80: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   83: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   86: ldc_w 350
    //   89: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: checkcast 323	android/media/MediaCodec$CodecException
    //   96: invokevirtual 330	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   99: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: ldc_w 352
    //   105: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: checkcast 323	android/media/MediaCodec$CodecException
    //   112: invokevirtual 355	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   115: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: checkcast 323	android/media/MediaCodec$CodecException
    //   128: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   131: ifeq +30 -> 161
    //   134: aload_0
    //   135: ldc2_w 22
    //   138: invokespecial 364	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   141: aload_0
    //   142: iload_1
    //   143: invokespecial 504	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   146: astore_2
    //   147: ldc_w 498
    //   150: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: goto -130 -> 23
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: ldc_w 498
    //   164: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  private ByteBuffer getOnputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 505
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 230	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: invokestatic 508	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   16: astore_2
    //   17: ldc_w 505
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   32: ldc_w 509
    //   35: aload_2
    //   36: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   42: bipush 21
    //   44: if_icmplt +117 -> 161
    //   47: aload_2
    //   48: instanceof 323
    //   51: ifeq +110 -> 161
    //   54: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 23
    //   59: if_icmplt +65 -> 124
    //   62: aload_0
    //   63: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   66: new 83	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 345
    //   73: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: checkcast 323	android/media/MediaCodec$CodecException
    //   80: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   83: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   86: ldc_w 350
    //   89: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: checkcast 323	android/media/MediaCodec$CodecException
    //   96: invokevirtual 330	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   99: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: ldc_w 352
    //   105: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: checkcast 323	android/media/MediaCodec$CodecException
    //   112: invokevirtual 355	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   115: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: checkcast 323	android/media/MediaCodec$CodecException
    //   128: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   131: ifeq +30 -> 161
    //   134: aload_0
    //   135: ldc2_w 22
    //   138: invokespecial 364	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   141: aload_0
    //   142: iload_1
    //   143: invokespecial 438	com/tencent/tav/decoder/AudioDecoder:getOnputBuffer	(I)Ljava/nio/ByteBuffer;
    //   146: astore_2
    //   147: ldc_w 505
    //   150: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: goto -130 -> 23
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: ldc_w 505
    //   164: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 512
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 230	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: iload_2
    //   14: iload_3
    //   15: lload 4
    //   17: iload 6
    //   19: invokevirtual 514	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   22: ldc_w 512
    //   25: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore 7
    //   33: aload_0
    //   34: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   37: ldc_w 515
    //   40: aload 7
    //   42: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   45: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 21
    //   50: if_icmplt +113 -> 163
    //   53: aload 7
    //   55: instanceof 323
    //   58: ifeq +105 -> 163
    //   61: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   64: bipush 23
    //   66: if_icmplt +68 -> 134
    //   69: aload_0
    //   70: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   73: new 83	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 345
    //   80: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload 7
    //   85: checkcast 323	android/media/MediaCodec$CodecException
    //   88: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   91: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: ldc_w 350
    //   97: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 7
    //   102: checkcast 323	android/media/MediaCodec$CodecException
    //   105: invokevirtual 330	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   108: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   111: ldc_w 352
    //   114: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 7
    //   119: checkcast 323	android/media/MediaCodec$CodecException
    //   122: invokevirtual 355	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   125: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload 7
    //   136: checkcast 323	android/media/MediaCodec$CodecException
    //   139: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   142: ifeq +21 -> 163
    //   145: aload_0
    //   146: ldc2_w 22
    //   149: invokespecial 364	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   152: aload_0
    //   153: iload_1
    //   154: iload_2
    //   155: iload_3
    //   156: lload 4
    //   158: iload 6
    //   160: invokespecial 516	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   163: ldc_w 512
    //   166: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 517
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   12: invokevirtual 520	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: aload_0
    //   18: getfield 414	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   21: invokevirtual 523	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   24: lcmp
    //   25: ifge +22 -> 47
    //   28: aload_0
    //   29: getfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   32: invokevirtual 167	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndex	()I
    //   35: iconst_m1
    //   36: if_icmpeq +11 -> 47
    //   39: lload_3
    //   40: ldc2_w 524
    //   43: lcmp
    //   44: ifne +35 -> 79
    //   47: aload_0
    //   48: invokespecial 366	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   51: istore_1
    //   52: iload_1
    //   53: iflt +17 -> 70
    //   56: aload_0
    //   57: iload_1
    //   58: iconst_0
    //   59: iconst_0
    //   60: lconst_0
    //   61: iconst_4
    //   62: invokespecial 516	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 152	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   70: ldc_w 517
    //   73: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: invokespecial 366	com/tencent/tav/decoder/AudioDecoder:dequeueInputBuffer	()I
    //   83: istore_1
    //   84: iload_1
    //   85: iflt +152 -> 237
    //   88: aload_0
    //   89: iload_1
    //   90: invokespecial 504	com/tencent/tav/decoder/AudioDecoder:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   93: astore 5
    //   95: aload_0
    //   96: getfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   99: aload 5
    //   101: iconst_0
    //   102: invokevirtual 529	com/tencent/tav/extractor/AssetExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   105: istore_2
    //   106: iload_2
    //   107: iflt +122 -> 229
    //   110: aload_0
    //   111: lload_3
    //   112: aload_0
    //   113: getfield 414	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   116: invokevirtual 419	com/tencent/tav/coremedia/CMTimeRange:getStartUs	()J
    //   119: lsub
    //   120: aload_0
    //   121: getfield 154	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   124: ladd
    //   125: putfield 156	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   128: aload_0
    //   129: iload_1
    //   130: iconst_0
    //   131: iload_2
    //   132: aload_0
    //   133: getfield 156	com/tencent/tav/decoder/AudioDecoder:mLastVideoQueueTime	J
    //   136: iconst_0
    //   137: invokespecial 516	com/tencent/tav/decoder/AudioDecoder:queueInputBuffer	(IIIJI)V
    //   140: new 10	com/tencent/tav/decoder/AudioDecoder$PendingFrame
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 531	com/tencent/tav/decoder/AudioDecoder$PendingFrame:<init>	(Lcom/tencent/tav/decoder/AudioDecoder;)V
    //   148: astore 5
    //   150: aload 5
    //   152: aload_0
    //   153: getfield 154	com/tencent/tav/decoder/AudioDecoder:mTimeOffset	J
    //   156: putfield 464	com/tencent/tav/decoder/AudioDecoder$PendingFrame:timeOffset	J
    //   159: aload 5
    //   161: new 109	com/tencent/tav/coremedia/CMTime
    //   164: dup
    //   165: lload_3
    //   166: l2f
    //   167: fconst_1
    //   168: fmul
    //   169: getstatic 197	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   172: lconst_1
    //   173: invokevirtual 201	java/util/concurrent/TimeUnit:toMicros	(J)J
    //   176: l2f
    //   177: fdiv
    //   178: invokespecial 204	com/tencent/tav/coremedia/CMTime:<init>	(F)V
    //   181: putfield 534	com/tencent/tav/decoder/AudioDecoder$PendingFrame:frameTime	Lcom/tencent/tav/coremedia/CMTime;
    //   184: aload 5
    //   186: aload_0
    //   187: getfield 145	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   190: aload_0
    //   191: getfield 414	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   194: invokevirtual 538	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   197: invokevirtual 542	com/tencent/tav/coremedia/CMTime:sub	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   200: putfield 468	com/tencent/tav/decoder/AudioDecoder$PendingFrame:seekStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   203: aload_0
    //   204: getfield 118	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   207: invokevirtual 289	java/util/ArrayList:size	()I
    //   210: ifne +9 -> 219
    //   213: aload 5
    //   215: iconst_1
    //   216: putfield 545	com/tencent/tav/decoder/AudioDecoder$PendingFrame:isFirst	Z
    //   219: aload_0
    //   220: getfield 118	com/tencent/tav/decoder/AudioDecoder:pendingFrames	Ljava/util/ArrayList;
    //   223: aload 5
    //   225: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: aload_0
    //   230: getfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   233: invokevirtual 548	com/tencent/tav/extractor/AssetExtractor:advance	()Z
    //   236: pop
    //   237: ldc_w 517
    //   240: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: goto -167 -> 76
    //   246: astore 5
    //   248: aload_0
    //   249: monitorexit
    //   250: aload 5
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	AudioDecoder
    //   51	79	1	i	int
    //   105	27	2	j	int
    //   15	151	3	l	long
    //   93	131	5	localObject1	Object
    //   246	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	39	246	finally
    //   47	52	246	finally
    //   56	70	246	finally
    //   70	76	246	finally
    //   79	84	246	finally
    //   88	106	246	finally
    //   110	219	246	finally
    //   219	229	246	finally
    //   229	237	246	finally
    //   237	243	246	finally
  }
  
  /* Error */
  private void releaseOutputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 549
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 140	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   12: istore_1
    //   13: iload_1
    //   14: iconst_m1
    //   15: if_icmpeq +17 -> 32
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 140	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   23: iconst_0
    //   24: invokespecial 458	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 140	com/tencent/tav/decoder/AudioDecoder:lastOutputBufferIndex	I
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 138	com/tencent/tav/decoder/AudioDecoder:_outputBuffer	Ljava/nio/ByteBuffer;
    //   37: ldc_w 549
    //   40: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   51: ldc_w 550
    //   54: aload_2
    //   55: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   2: ldc_w 551
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 230	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   12: iload_1
    //   13: iload_2
    //   14: invokevirtual 552	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   17: ldc_w 551
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   31: ldc_w 550
    //   34: aload_3
    //   35: invokestatic 300	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   38: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   41: bipush 21
    //   43: if_icmplt +103 -> 146
    //   46: aload_3
    //   47: instanceof 323
    //   50: ifeq +96 -> 146
    //   53: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   56: bipush 23
    //   58: if_icmplt +65 -> 123
    //   61: aload_0
    //   62: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   65: new 83	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 345
    //   72: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_3
    //   76: checkcast 323	android/media/MediaCodec$CodecException
    //   79: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   82: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 350
    //   88: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_3
    //   92: checkcast 323	android/media/MediaCodec$CodecException
    //   95: invokevirtual 330	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   98: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: ldc_w 352
    //   104: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: checkcast 323	android/media/MediaCodec$CodecException
    //   111: invokevirtual 355	android/media/MediaCodec$CodecException:getErrorCode	()I
    //   114: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_3
    //   124: checkcast 323	android/media/MediaCodec$CodecException
    //   127: invokevirtual 327	android/media/MediaCodec$CodecException:isTransient	()Z
    //   130: ifeq +16 -> 146
    //   133: aload_0
    //   134: ldc2_w 22
    //   137: invokespecial 364	com/tencent/tav/decoder/AudioDecoder:waitTime	(J)V
    //   140: aload_0
    //   141: iload_1
    //   142: iload_2
    //   143: invokespecial 458	com/tencent/tav/decoder/AudioDecoder:releaseOutputBuffer	(IZ)V
    //   146: ldc_w 551
    //   149: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(201652);
      if (this.isReleased) {
        AppMethodBeat.o(201652);
      }
      for (;;)
      {
        return;
        Logger.d(this.TAG, "reset - ");
        try
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label97;
          }
          this.decoder.reset();
          decoderConfigure(this.mediaFormat);
          start();
          AppMethodBeat.o(201652);
        }
        catch (Exception localException1)
        {
          Logger.e(this.TAG, "reset", localException1);
          AppMethodBeat.o(201652);
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
          AppMethodBeat.o(201652);
        }
        catch (Exception localException2)
        {
          break label104;
        }
      }
    }
    finally {}
  }
  
  private void seekExtractorTo(long paramLong)
  {
    try
    {
      AppMethodBeat.i(201660);
      this.extractor.seekTo(paramLong, 2);
      if (this.extractor.getSampleTime() > paramLong) {
        this.extractor.seekTo(paramLong, 0);
      }
      clearDecoder();
      this.mTimeOffset = (this.mLastVideoQueueTime + 10000000L);
      AppMethodBeat.o(201660);
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
        AppMethodBeat.i(201662);
        try
        {
          this.decoder.start();
          AppMethodBeat.o(201662);
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
          AppMethodBeat.o(201662);
          continue;
        }
        if (!((MediaCodec.CodecException)localObject).isRecoverable()) {
          break;
        }
      }
      finally {}
      reset();
      AppMethodBeat.o(201662);
    }
    release();
    AppMethodBeat.o(201662);
    throw localObject;
  }
  
  private void waitTime(long paramLong)
  {
    try
    {
      AppMethodBeat.i(201661);
      try
      {
        wait(paramLong);
        AppMethodBeat.o(201661);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Logger.e(this.TAG, "waitTime", localInterruptedException);
          AppMethodBeat.o(201661);
        }
      }
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(201675);
    super.finalize();
    release(false);
    AppMethodBeat.o(201675);
  }
  
  public AudioInfo getAudioInfo()
  {
    return this._audioInfo;
  }
  
  public String getSourcePath()
  {
    AppMethodBeat.i(201650);
    if (this.extractor == null)
    {
      AppMethodBeat.o(201650);
      return null;
    }
    String str = this.extractor.getSourcePath();
    AppMethodBeat.o(201650);
    return str;
  }
  
  /* Error */
  public boolean hasTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 120	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
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
    AppMethodBeat.i(201658);
    if (this.pendingFrames.size() > 0) {}
    for (CMTime localCMTime = ((PendingFrame)this.pendingFrames.get(0)).frameTime;; localCMTime = CMTime.CMTimeInvalid)
    {
      Iterator localIterator = this.pendingFrames.iterator();
      while (localIterator.hasNext()) {
        localCMTime = CMTime.min(((PendingFrame)localIterator.next()).frameTime, localCMTime);
      }
    }
    AppMethodBeat.o(201658);
    return localCMTime;
  }
  
  public ByteBuffer outputBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this._outputBuffer;
      return localByteBuffer;
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
      AppMethodBeat.i(201669);
      CMTime localCMTime = readSample(CMTime.CMTimeInvalid);
      AppMethodBeat.o(201669);
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
    try
    {
      AppMethodBeat.i(201670);
      if (LOG_VERBOSE) {
        Logger.d(this.TAG, "readSample: " + paramCMTime + "  -  " + this.extractor.getSampleTime());
      }
      this.currentDecoderTime = doReadSample(paramCMTime, false);
      CMTime localCMTime = this.currentDecoderTime;
      if ((this.currentDecoderTime == SAMPLE_TIME_FINISH) || (this.currentDecoderTime == SAMPLE_TIME_TIMEOUT) || (!this.currentDecoderTime.smallThan(this.duration))) {
        clearDecoder();
      }
      if (LOG_VERBOSE) {
        Logger.i(this.TAG, "readSample: finish " + paramCMTime + "  -  " + this.currentDecoderTime, new Object[0]);
      }
      AppMethodBeat.o(201670);
      return localCMTime;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(201673);
      release(true);
      AppMethodBeat.o(201673);
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
    //   2: ldc_w 634
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 122	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 634
    //   18: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   28: ldc_w 636
    //   31: iload_1
    //   32: invokestatic 639	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   35: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: ifeq +15 -> 57
    //   45: aload_0
    //   46: getfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   49: invokevirtual 642	com/tencent/tav/extractor/AssetExtractor:dispose	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 116	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 122	com/tencent/tav/decoder/AudioDecoder:isReleased	Z
    //   67: aload_0
    //   68: getfield 230	com/tencent/tav/decoder/AudioDecoder:decoder	Landroid/media/MediaCodec;
    //   71: ifnull +14 -> 85
    //   74: new 8	com/tencent/tav/decoder/AudioDecoder$1
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 643	com/tencent/tav/decoder/AudioDecoder$1:<init>	(Lcom/tencent/tav/decoder/AudioDecoder;)V
    //   82: invokevirtual 644	com/tencent/tav/decoder/AudioDecoder$1:start	()V
    //   85: aload_0
    //   86: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   89: ldc_w 646
    //   92: iload_1
    //   93: invokestatic 639	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   96: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: ldc_w 634
    //   105: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 648
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 67	com/tencent/tav/decoder/AudioDecoder:LOG_VERBOSE	Z
    //   11: ifeq +63 -> 74
    //   14: aload_0
    //   15: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   18: new 83	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 650
    //   25: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: ldc_w 652
    //   35: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc_w 477
    //   45: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 145	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   52: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: ldc_w 477
    //   58: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 124	com/tencent/tav/decoder/AudioDecoder:currentDecoderTime	Lcom/tencent/tav/coremedia/CMTime;
    //   65: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 286	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 116	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   78: ifeq +11 -> 89
    //   81: aload_0
    //   82: getfield 120	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   85: iconst_m1
    //   86: if_icmpne +58 -> 144
    //   89: aload_0
    //   90: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   93: new 83	java/lang/StringBuilder
    //   96: dup
    //   97: ldc_w 654
    //   100: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 116	com/tencent/tav/decoder/AudioDecoder:started	Z
    //   107: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: ldc_w 656
    //   113: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 120	com/tencent/tav/decoder/AudioDecoder:trackIndex	I
    //   120: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc_w 658
    //   126: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 360	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: ldc_w 648
    //   138: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: aload_1
    //   145: astore_2
    //   146: aload_1
    //   147: invokevirtual 412	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   150: lconst_0
    //   151: lcmp
    //   152: ifge +7 -> 159
    //   155: getstatic 112	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   158: astore_2
    //   159: aload_0
    //   160: aload_0
    //   161: getfield 414	com/tencent/tav/decoder/AudioDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   164: invokevirtual 538	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   167: aload_2
    //   168: invokevirtual 660	com/tencent/tav/coremedia/CMTime:add	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMTime;
    //   171: putfield 145	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 152	com/tencent/tav/decoder/AudioDecoder:extractorDone	Z
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 145	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   184: invokevirtual 412	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   187: invokespecial 662	com/tencent/tav/decoder/AudioDecoder:seekExtractorTo	(J)V
    //   190: getstatic 67	com/tencent/tav/decoder/AudioDecoder:LOG_VERBOSE	Z
    //   193: ifeq +46 -> 239
    //   196: aload_0
    //   197: getfield 107	com/tencent/tav/decoder/AudioDecoder:TAG	Ljava/lang/String;
    //   200: new 83	java/lang/StringBuilder
    //   203: dup
    //   204: ldc_w 664
    //   207: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload_0
    //   211: getfield 145	com/tencent/tav/decoder/AudioDecoder:currentStartTime	Lcom/tencent/tav/coremedia/CMTime;
    //   214: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: ldc_w 477
    //   220: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 161	com/tencent/tav/decoder/AudioDecoder:extractor	Lcom/tencent/tav/extractor/AssetExtractor;
    //   227: invokevirtual 520	com/tencent/tav/extractor/AssetExtractor:getSampleTime	()J
    //   230: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 286	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: ldc_w 648
    //   242: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: goto -104 -> 141
    //   248: astore_1
    //   249: aload_0
    //   250: monitorexit
    //   251: aload_1
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	AudioDecoder
    //   0	253	1	paramCMTime	CMTime
    //   145	23	2	localCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	74	248	finally
    //   74	89	248	finally
    //   89	141	248	finally
    //   146	159	248	finally
    //   159	239	248	finally
    //   239	245	248	finally
  }
  
  public void start(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(201654);
      start(paramCMTimeRange, CMTime.CMTimeZero);
      AppMethodBeat.o(201654);
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
        AppMethodBeat.i(201655);
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + paramCMTimeRange + "] [start " + paramCMTime + "]");
        if (this.trackIndex == -1)
        {
          Logger.e(this.TAG, "start: trackIndex == -1");
          AppMethodBeat.o(201655);
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
          AppMethodBeat.o(201655);
        }
        else
        {
          this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
        }
      }
      finally {}
    }
  }
  
  class PendingFrame
  {
    public CMTime frameTime = CMTime.CMTimeZero;
    public boolean isFirst = false;
    public CMTime seekStartTime = CMTime.CMTimeZero;
    public long timeOffset = 0L;
    
    public PendingFrame() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */