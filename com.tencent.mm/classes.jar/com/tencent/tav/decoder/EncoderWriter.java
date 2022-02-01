package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.MediaCodecAnalyse;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.report.AverageTimeReporter;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EncoderWriter
{
  public static final int OUTPUT_AUDIO_AAC_PROFILE = 2;
  public static final int OUTPUT_AUDIO_BIT_RATE = 128000;
  public static final int OUTPUT_AUDIO_CHANNEL_COUNT = 1;
  public static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
  public static final int OUTPUT_AUDIO_SAMPLE_RATE_HZ = 44100;
  public static final int OUTPUT_VIDEO_BIT_RATE = 8000000;
  public static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
  public static final int OUTPUT_VIDEO_FRAME_RATE = 30;
  public static final int OUTPUT_VIDEO_IFRAME_INTERVAL = 1;
  public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private final String SCENE;
  private final String TAG;
  private Surface _inputSurface;
  private volatile MediaFormat audioEncodeFormat;
  private AssetWriterAudioEncoder audioEncoder;
  private final Lock audioEncoderLock;
  private boolean audioEncoderStarted;
  private boolean enOfAudioInputStream;
  private boolean enOfVideoInputStream;
  private ExportConfig encodeOption;
  private final AverageTimeReporter encodeReporter;
  private boolean hasAudioTrack;
  private boolean hasVideoTrack;
  private ReadWriteLock lock;
  private IMediaMuxer muxer;
  private volatile boolean muxerStarted;
  private volatile int outputAudioTrack;
  private String outputPath;
  private volatile int outputVideoTrack;
  private boolean released;
  private volatile MediaFormat videoEncodeFormat;
  private AssetWriterVideoEncoder videoEncoder;
  private final Lock videoEncoderLock;
  private boolean videoEncoderStarted;
  
  public EncoderWriter(String paramString)
  {
    this(paramString, null);
  }
  
  public EncoderWriter(String paramString, IEncoderFactory paramIEncoderFactory)
  {
    AppMethodBeat.i(216000);
    this.TAG = ("EncoderWriter" + hashCode());
    this.SCENE = "tav-encoder-writer";
    this.encodeReporter = new AverageTimeReporter();
    this.hasVideoTrack = false;
    this.hasAudioTrack = false;
    this.enOfVideoInputStream = false;
    this.enOfAudioInputStream = false;
    this.videoEncoderLock = new ReentrantLock();
    this.audioEncoderLock = new ReentrantLock();
    this.lock = new ReentrantReadWriteLock();
    this._inputSurface = null;
    this.videoEncodeFormat = null;
    this.audioEncodeFormat = null;
    this.outputVideoTrack = -1;
    this.outputAudioTrack = -1;
    this.muxerStarted = false;
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    this.released = false;
    this.outputPath = paramString;
    this.muxer = MediaMuxerFactory.createMediaMuxer(paramString, 0);
    paramString = paramIEncoderFactory;
    if (paramIEncoderFactory == null) {
      paramString = new DefaultEncoderFactory();
    }
    this.audioEncoder = paramString.getAudioEncoder();
    this.audioEncoder.setMediaMuxer(this.muxer);
    this.videoEncoder = paramString.getVideoEncoder();
    this.videoEncoder.setMediaMuxer(this.muxer);
    AppMethodBeat.o(216000);
  }
  
  private void checkStartMuxer()
  {
    AppMethodBeat.i(216080);
    if (unStarted())
    {
      Logger.i(this.TAG, "checkStartMuxer");
      try
      {
        if (unStarted())
        {
          if (this.hasVideoTrack) {
            this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
          }
          if (this.hasAudioTrack) {
            this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
          }
          this.muxer.start();
          this.muxerStarted = true;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(216080);
      }
    }
    AppMethodBeat.o(216080);
  }
  
  private int dequeueInputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse)
  {
    AppMethodBeat.i(216134);
    try
    {
      int i = paramMediaCodecAnalyse.dequeueInputBuffer(1000L);
      AppMethodBeat.o(216134);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "dequeueInputBuffer e = ", localException);
        if ((21 > Build.VERSION.SDK_INT) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216134);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private int dequeueOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(216127);
    try
    {
      int i = paramMediaCodecAnalyse.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(216127);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "dequeueOutputBuffer e = ", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216127);
      throw localException;
    }
  }
  
  private void drainAudioEncoder(boolean paramBoolean, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(216101);
    if (paramBoolean) {}
    for (boolean bool1 = this.hasAudioTrack;; bool1 = false)
    {
      boolean bool2;
      long l;
      if (!this.hasAudioTrack)
      {
        bool2 = true;
        l = System.currentTimeMillis();
        label30:
        if ((bool2) || (!this.hasAudioTrack)) {
          break label122;
        }
        if (!bool1) {
          break label136;
        }
        signalEndOfAudioStream();
        bool1 = false;
      }
      label136:
      for (;;)
      {
        boolean bool3 = bool2;
        if (!bool2)
        {
          bool3 = writeAudioFrame(paramBoolean);
          if (System.currentTimeMillis() - l > 2000L)
          {
            if (!paramBoolean) {}
            for (bool2 = true;; bool2 = false)
            {
              this.hasAudioTrack = bool2;
              Logger.e(this.TAG, "drainEncoder: 音频写入处理时间超时，提前结束写入");
              bool2 = true;
              break label30;
              bool2 = false;
              break;
            }
            label122:
            AppMethodBeat.o(216101);
            return;
          }
        }
        bool2 = bool3;
        break label30;
      }
    }
  }
  
  private void drainVideoEncoder(boolean paramBoolean, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(216090);
    int i;
    boolean bool1;
    label36:
    long l;
    if ((paramBoolean) && (this.hasVideoTrack)) {
      if (this._inputSurface == null)
      {
        i = 1;
        if (this.hasVideoTrack) {
          break label131;
        }
        bool1 = true;
        l = System.currentTimeMillis();
        label41:
        if ((bool1) || (!this.hasVideoTrack)) {
          break label143;
        }
        if (i == 0) {
          break label157;
        }
        signalEndOfVideoStream();
        i = 0;
      }
    }
    label131:
    label143:
    label157:
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = writeVideoFrame(paramCMSampleBuffer, paramBoolean);
        if (System.currentTimeMillis() - l > 2000L)
        {
          if (!paramBoolean) {}
          for (bool1 = true;; bool1 = false)
          {
            this.hasVideoTrack = bool1;
            Logger.e(this.TAG, "drainEncoder: 视频写入处理时间超时，提前结束写入");
            bool1 = true;
            break label41;
            signalEndOfVideoStream();
            i = 0;
            break;
            bool1 = false;
            break label36;
          }
          AppMethodBeat.o(216090);
          return;
        }
      }
      bool1 = bool2;
      break label41;
    }
  }
  
  private void fixAudioFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216034);
    fixStringKey(paramMediaFormat, "mime", "audio/mp4a-latm");
    fixIntegerKey(paramMediaFormat, "sample-rate", 44100);
    fixIntegerKey(paramMediaFormat, "channel-count", 1);
    fixIntegerKey(paramMediaFormat, "bitrate", 128000);
    fixIntegerKey(paramMediaFormat, "aac-profile", 2);
    Logger.d(this.TAG, "fixAudioFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(216034);
  }
  
  private void fixIntegerKey(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(216041);
    if ((!paramMediaFormat.containsKey(paramString)) || (paramMediaFormat.getInteger(paramString) <= 0))
    {
      Logger.w(this.TAG, "fixIntegerKey: 缺少关键配置：" + paramString + ", 使用默认值：" + paramInt);
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(216041);
  }
  
  private void fixStringKey(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    AppMethodBeat.i(216053);
    if ((!paramMediaFormat.containsKey(paramString1)) || (TextUtils.isEmpty(paramMediaFormat.getString(paramString1))))
    {
      Logger.w(this.TAG, "fixStringKey: 缺少关键配置：" + paramString1 + ", 使用默认值：" + paramString2);
      paramMediaFormat.setString(paramString1, paramString2);
    }
    AppMethodBeat.o(216053);
  }
  
  private void fixVideoFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216026);
    paramMediaFormat.setInteger("color-format", 2130708361);
    fixStringKey(paramMediaFormat, "mime", "video/avc");
    fixIntegerKey(paramMediaFormat, "bitrate", 8000000);
    fixIntegerKey(paramMediaFormat, "frame-rate", 30);
    fixIntegerKey(paramMediaFormat, "i-frame-interval", 1);
    Logger.d(this.TAG, "fixVideoFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(216026);
  }
  
  private ByteBuffer getInputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt)
  {
    AppMethodBeat.i(216141);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodecAnalyse, paramInt);
      AppMethodBeat.o(216141);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "getInputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216141);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt)
  {
    AppMethodBeat.i(216148);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodecAnalyse, paramInt);
      AppMethodBeat.o(216148);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "getOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216148);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private void prepareAudioEncoder(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(216019);
    Logger.d(this.TAG, "AssetWriter prepareAudioEncoder ".concat(String.valueOf(this)));
    MediaFormat localMediaFormat = paramExportConfig.getAudioFormat();
    fixAudioFormat(localMediaFormat);
    Logger.i(this.TAG, "prepareAudioEncoder, input mediaFormat:" + localMediaFormat + ", isAudioEncodeNeedCodecSpecificData:" + paramExportConfig.isAudioEncodeNeedCodecSpecificData());
    if (paramExportConfig.isAudioEncodeNeedCodecSpecificData())
    {
      int i = localMediaFormat.getInteger("aac-profile");
      int j = localMediaFormat.getInteger("sample-rate");
      int k = localMediaFormat.getInteger("channel-count");
      Logger.i(this.TAG, "try set adts csd-0 data, profile:" + i + ", sampleRate:" + j + ", " + k);
      localMediaFormat.setByteBuffer("csd-0", ADTSUtils.getADTSCodecSpecificData(i, j, k));
    }
    this.audioEncoder.prepare(paramExportConfig, localMediaFormat);
    AppMethodBeat.o(216019);
  }
  
  private void prepareVideoEncoder(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(216012);
    MediaFormat localMediaFormat = paramExportConfig.getVideoFormat();
    fixVideoFormat(localMediaFormat);
    this.videoEncoder.prepare(paramExportConfig, localMediaFormat);
    AppMethodBeat.o(216012);
  }
  
  private void queueInputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(216165);
    try
    {
      paramMediaCodecAnalyse.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(216165);
      return;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodecAnalyse, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      AppMethodBeat.o(216165);
      throw localException;
    }
    catch (Error localError)
    {
      label27:
      break label27;
    }
  }
  
  /* Error */
  private boolean release()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc_w 469
    //   7: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 154	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   15: aload_0
    //   16: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   19: ldc_w 471
    //   22: aload_0
    //   23: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 413	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   36: invokeinterface 475 1 0
    //   41: aload_0
    //   42: getfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   45: invokeinterface 475 1 0
    //   50: aload_0
    //   51: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   54: ldc_w 477
    //   57: aload_0
    //   58: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 413	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokestatic 338	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +26 -> 99
    //   76: aload_0
    //   77: getfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   80: invokeinterface 480 1 0
    //   85: aload_0
    //   86: getfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   89: invokeinterface 482 1 0
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   99: aload_0
    //   100: getfield 175	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;
    //   103: astore_3
    //   104: aload_3
    //   105: ifnull +26 -> 131
    //   108: aload_0
    //   109: getfield 175	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;
    //   112: invokeinterface 483 1 0
    //   117: aload_0
    //   118: getfield 175	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;
    //   121: invokeinterface 484 1 0
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 175	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;
    //   131: aload_0
    //   132: getfield 164	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   135: ifnull +36 -> 171
    //   138: iload_2
    //   139: istore_1
    //   140: aload_0
    //   141: getfield 148	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   144: ifeq +18 -> 162
    //   147: aload_0
    //   148: iconst_0
    //   149: putfield 148	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   152: aload_0
    //   153: getfield 164	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   156: invokeinterface 486 1 0
    //   161: istore_1
    //   162: aload_0
    //   163: getfield 164	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   166: invokeinterface 487 1 0
    //   171: aload_0
    //   172: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   175: invokeinterface 490 1 0
    //   180: aload_0
    //   181: getfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   184: invokeinterface 490 1 0
    //   189: aload_0
    //   190: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   193: new 89	java/lang/StringBuilder
    //   196: dup
    //   197: ldc_w 492
    //   200: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   203: aload_0
    //   204: getfield 116	com/tencent/tav/decoder/EncoderWriter:encodeReporter	Lcom/tencent/tav/report/AverageTimeReporter;
    //   207: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: ldc_w 469
    //   219: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iload_1
    //   223: ireturn
    //   224: astore_3
    //   225: aload_0
    //   226: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   229: ldc_w 494
    //   232: aload_3
    //   233: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   236: goto -151 -> 85
    //   239: astore_3
    //   240: aload_0
    //   241: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   244: invokeinterface 490 1 0
    //   249: aload_0
    //   250: getfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   253: invokeinterface 490 1 0
    //   258: ldc_w 469
    //   261: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_3
    //   265: athrow
    //   266: astore_3
    //   267: aload_0
    //   268: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   271: ldc_w 496
    //   274: aload_3
    //   275: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto -184 -> 94
    //   281: astore_3
    //   282: aload_0
    //   283: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   286: ldc_w 498
    //   289: aload_3
    //   290: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -176 -> 117
    //   296: astore_3
    //   297: aload_0
    //   298: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   301: ldc_w 500
    //   304: aload_3
    //   305: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: goto -182 -> 126
    //   311: astore_3
    //   312: aload_0
    //   313: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   316: ldc_w 502
    //   319: aload_3
    //   320: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: iload_2
    //   324: istore_1
    //   325: goto -163 -> 162
    //   328: astore_3
    //   329: aload_0
    //   330: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   333: ldc_w 504
    //   336: aload_3
    //   337: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: goto -169 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	EncoderWriter
    //   1	324	1	bool1	boolean
    //   3	321	2	bool2	boolean
    //   71	34	3	localObject1	Object
    //   224	9	3	localException1	Exception
    //   239	26	3	localObject2	Object
    //   266	9	3	localException2	Exception
    //   281	9	3	localException3	Exception
    //   296	9	3	localException4	Exception
    //   311	9	3	localException5	Exception
    //   328	9	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   76	85	224	java/lang/Exception
    //   32	72	239	finally
    //   76	85	239	finally
    //   85	94	239	finally
    //   94	99	239	finally
    //   99	104	239	finally
    //   108	117	239	finally
    //   117	126	239	finally
    //   126	131	239	finally
    //   131	138	239	finally
    //   140	152	239	finally
    //   152	162	239	finally
    //   162	171	239	finally
    //   225	236	239	finally
    //   267	278	239	finally
    //   282	293	239	finally
    //   297	308	239	finally
    //   312	323	239	finally
    //   329	340	239	finally
    //   85	94	266	java/lang/Exception
    //   108	117	281	java/lang/Exception
    //   117	126	296	java/lang/Exception
    //   152	162	311	java/lang/Exception
    //   162	171	328	java/lang/Exception
  }
  
  private void releaseOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216156);
    try
    {
      paramMediaCodecAnalyse.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(216156);
      return;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          releaseOutputBuffer(paramMediaCodecAnalyse, paramInt, paramBoolean);
        }
      }
      AppMethodBeat.o(216156);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private void signalEndOfAudioStream()
  {
    AppMethodBeat.i(216071);
    try
    {
      boolean bool = this.enOfAudioInputStream;
      if (bool)
      {
        AppMethodBeat.o(216071);
        return;
      }
      Logger.d(this.TAG, "signalEndOfAudioStream: ");
      this.enOfAudioInputStream = this.audioEncoder.endWriteAudioSample();
      AppMethodBeat.o(216071);
      return;
    }
    finally
    {
      Logger.e(this.TAG, "signalEndOfAudioStream failed", localThrowable);
      AppMethodBeat.o(216071);
    }
  }
  
  private void signalEndOfVideoStream()
  {
    AppMethodBeat.i(216061);
    Logger.d(this.TAG, "signalEndOfVideoStream: ");
    if ((this._inputSurface == null) || (this.enOfVideoInputStream))
    {
      AppMethodBeat.o(216061);
      return;
    }
    try
    {
      this.videoEncoder.signalEndOfInputStream();
      this.enOfVideoInputStream = true;
      AppMethodBeat.o(216061);
      return;
    }
    finally
    {
      Logger.e(this.TAG, "signalEndOfVideoStream failed", localThrowable);
      AppMethodBeat.o(216061);
    }
  }
  
  private boolean unStarted()
  {
    return (!this.muxerStarted) && ((!this.hasVideoTrack) || (this.videoEncodeFormat != null)) && ((!this.hasAudioTrack) || (this.audioEncodeFormat != null));
  }
  
  private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo paramBufferInfo)
  {
    return (paramBufferInfo.size > 0) && ((paramBufferInfo.flags & 0x4) == 0);
  }
  
  private void waitTime(long paramLong)
  {
    AppMethodBeat.i(216174);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(216174);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(216174);
    }
  }
  
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(216187);
    System.currentTimeMillis();
    try
    {
      this.audioEncoderLock.lock();
      paramBoolean = this.audioEncoder.writeAudioFrame(paramBoolean);
      this.audioEncodeFormat = this.audioEncoder.getEncodeFormat();
      if (this.audioEncoder.isEncodeToEndOfStream()) {
        this.hasAudioTrack = false;
      }
      return paramBoolean;
    }
    finally
    {
      this.audioEncoderLock.unlock();
      AppMethodBeat.o(216187);
    }
  }
  
  private boolean writeVideoFrame(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(216118);
    try
    {
      this.videoEncoderLock.lock();
      paramBoolean = this.videoEncoder.writeVideoSample(paramCMSampleBuffer, paramBoolean);
      this.videoEncodeFormat = this.videoEncoder.getEncodeFormat();
      if (this.videoEncoder.isEncodeToEndOfStream()) {
        this.hasVideoTrack = false;
      }
      this.videoEncoderLock.unlock();
      AppMethodBeat.o(216118);
      return paramBoolean;
    }
    finally
    {
      try
      {
        paramCMSampleBuffer = new ExportRuntimeException(-121, paramCMSampleBuffer);
        AppMethodBeat.o(216118);
        throw paramCMSampleBuffer;
      }
      finally
      {
        this.videoEncoderLock.unlock();
        AppMethodBeat.o(216118);
      }
    }
  }
  
  public boolean audioTrackWritable()
  {
    boolean bool2 = true;
    if ((this.hasAudioTrack) && ((this.muxerStarted) || (this.audioEncodeFormat == null))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.hasAudioTrack)
        {
          bool1 = bool2;
          if (!this.muxerStarted)
          {
            if (this.audioEncodeFormat == null) {
              bool1 = bool2;
            }
          }
          else {
            return bool1;
          }
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public Surface createInputSurface()
  {
    try
    {
      AppMethodBeat.i(216205);
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      AppMethodBeat.o(216205);
      return localSurface;
    }
    finally {}
  }
  
  public void endWriteAudioSample()
  {
    AppMethodBeat.i(216334);
    Logger.d(this.TAG, "endWriteAudioSample:".concat(String.valueOf(this)));
    try
    {
      this.audioEncoderLock.lock();
      if (!this.released)
      {
        boolean bool = this.enOfAudioInputStream;
        if (!bool) {}
      }
      else
      {
        return;
      }
      Logger.d(this.TAG, "endWriteAudioSample: ");
      this.enOfAudioInputStream = this.audioEncoder.endWriteAudioSample();
      drainAudioEncoder(false, null);
      return;
    }
    finally
    {
      this.audioEncoderLock.unlock();
      AppMethodBeat.o(216334);
    }
  }
  
  /* Error */
  public void endWriteVideoSample(CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: ldc_w 580
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   10: ldc_w 582
    //   13: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 154	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   20: ifeq +10 -> 30
    //   23: ldc_w 580
    //   26: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_0
    //   31: getfield 138	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   34: ifnull +10 -> 44
    //   37: aload_0
    //   38: getfield 122	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 580
    //   47: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: aload_0
    //   52: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 475 1 0
    //   60: aload_0
    //   61: getfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   64: invokeinterface 527 1 0
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 122	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   74: aload_0
    //   75: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   78: invokeinterface 490 1 0
    //   83: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   86: lstore_3
    //   87: iconst_0
    //   88: istore_2
    //   89: aload_0
    //   90: getfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   93: invokeinterface 559 1 0
    //   98: ifne +72 -> 170
    //   101: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   104: lload_3
    //   105: lsub
    //   106: ldc2_w 583
    //   109: lcmp
    //   110: ifge +60 -> 170
    //   113: iload_2
    //   114: iconst_1
    //   115: iadd
    //   116: istore_2
    //   117: aload_0
    //   118: iconst_0
    //   119: aload_1
    //   120: invokespecial 586	com/tencent/tav/decoder/EncoderWriter:drainVideoEncoder	(ZLcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   123: goto -34 -> 89
    //   126: astore 5
    //   128: aload_0
    //   129: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   132: ldc_w 588
    //   135: aload 5
    //   137: invokestatic 234	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   144: invokeinterface 490 1 0
    //   149: goto -66 -> 83
    //   152: astore_1
    //   153: aload_0
    //   154: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   157: invokeinterface 490 1 0
    //   162: ldc_w 580
    //   165: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: athrow
    //   170: aload_0
    //   171: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   174: ldc_w 590
    //   177: iconst_2
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: iload_2
    //   184: invokestatic 595	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   193: lload_3
    //   194: lsub
    //   195: invokestatic 600	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: aastore
    //   199: invokestatic 603	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: ldc_w 580
    //   205: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	EncoderWriter
    //   0	209	1	paramCMSampleBuffer	CMSampleBuffer
    //   88	96	2	i	int
    //   86	108	3	l	long
    //   126	10	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   51	74	126	finally
    //   128	140	152	finally
  }
  
  public long getAudioPresentationTimeUs()
  {
    AppMethodBeat.i(216231);
    long l = this.audioEncoder.getEncodePresentationTimeUs();
    AppMethodBeat.o(216231);
    return l;
  }
  
  public IMediaMuxer getMuxer()
  {
    return this.muxer;
  }
  
  public int getOutHeight()
  {
    AppMethodBeat.i(216222);
    int i = (int)this.videoEncoder.getEncodeSize().height;
    AppMethodBeat.o(216222);
    return i;
  }
  
  public int getOutWidth()
  {
    AppMethodBeat.i(216215);
    int i = (int)this.videoEncoder.getEncodeSize().width;
    AppMethodBeat.o(216215);
    return i;
  }
  
  public AverageTimeReporter getPerformance()
  {
    return this.encodeReporter;
  }
  
  public long getVideoPresentationTimeUs()
  {
    AppMethodBeat.i(216239);
    if (this.videoEncoder == null)
    {
      AppMethodBeat.o(216239);
      return -1L;
    }
    long l = this.videoEncoder.getEncodePresentationTimeUs();
    AppMethodBeat.o(216239);
    return l;
  }
  
  public boolean isVideoEncodeNeedVideoRenderOutputTexture()
  {
    AppMethodBeat.i(216288);
    boolean bool = this.videoEncoder.isNeedVideoOutputTexture();
    AppMethodBeat.o(216288);
    return bool;
  }
  
  public void prepareParallelSegmentInfo(int paramInt, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(216265);
    this.muxer.prepareParallelSegmentInfo(paramInt, paramCMTimeRange1, paramCMTimeRange2);
    AppMethodBeat.o(216265);
  }
  
  public void processVideoTexture(TextureInfo paramTextureInfo, CMTime paramCMTime)
  {
    AppMethodBeat.i(216301);
    this.videoEncoder.processVideoTexture(paramTextureInfo, paramCMTime);
    AppMethodBeat.o(216301);
  }
  
  public void reset()
  {
    AppMethodBeat.i(216358);
    this.muxerStarted = false;
    this.hasVideoTrack = true;
    this._inputSurface = null;
    this.enOfVideoInputStream = false;
    this.muxer = MediaMuxerFactory.createMediaMuxer(this.outputPath, 0);
    this.muxer.setExportConfig(this.encodeOption);
    this.videoEncoder.reset();
    this.videoEncoder.setMediaMuxer(this.muxer);
    AppMethodBeat.o(216358);
  }
  
  public void setEncodeOption(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(216257);
    if ((paramExportConfig.getOutputWidth() <= 0) || (paramExportConfig.getOutputHeight() <= 0))
    {
      paramExportConfig = new IllegalArgumentException("width and height must > 0");
      AppMethodBeat.o(216257);
      throw paramExportConfig;
    }
    this.encodeOption = paramExportConfig.clone();
    this.muxer.setExportConfig(paramExportConfig);
    AppMethodBeat.o(216257);
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(216321);
    this.videoEncoder.setVideoSampleRenderContext(paramRenderContext);
    AppMethodBeat.o(216321);
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 680
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 475 1 0
    //   17: aload_0
    //   18: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   21: ldc_w 682
    //   24: aload_0
    //   25: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 413	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 338	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 651	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   39: invokespecial 684	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 120	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   47: aload_0
    //   48: getfield 175	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;
    //   51: invokeinterface 686 1 0
    //   56: pop
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 152	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   62: aload_0
    //   63: getfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   66: invokeinterface 490 1 0
    //   71: ldc_w 680
    //   74: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 131	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   85: invokeinterface 490 1 0
    //   90: ldc_w 680
    //   93: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: athrow
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	EncoderWriter
    //   80	17	1	localObject1	Object
    //   98	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	62	80	finally
    //   2	8	98	finally
    //   62	77	98	finally
    //   81	98	98	finally
  }
  
  /* Error */
  public void startVideoEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 688
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 475 1 0
    //   17: aload_0
    //   18: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   21: ldc_w 690
    //   24: aload_0
    //   25: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 413	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 338	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 651	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   39: invokespecial 692	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 118	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   47: aload_0
    //   48: invokevirtual 693	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   51: pop
    //   52: aload_0
    //   53: getfield 187	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   56: invokeinterface 694 1 0
    //   61: pop
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 150	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   67: aload_0
    //   68: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   71: invokeinterface 490 1 0
    //   76: ldc_w 688
    //   79: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_1
    //   86: aload_0
    //   87: getfield 129	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   90: invokeinterface 490 1 0
    //   95: ldc_w 688
    //   98: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	EncoderWriter
    //   85	17	1	localObject1	Object
    //   103	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	67	85	finally
    //   2	8	103	finally
    //   67	82	103	finally
    //   86	103	103	finally
  }
  
  public boolean stop()
  {
    AppMethodBeat.i(216355);
    Logger.i(this.TAG, "AssetWriter stop ".concat(String.valueOf(this)));
    if (this.released)
    {
      AppMethodBeat.o(216355);
      return false;
    }
    if ((!this.videoEncoderStarted) && (!this.audioEncoderStarted))
    {
      AppMethodBeat.o(216355);
      return false;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainVideoEncoder(true, null);
    drainAudioEncoder(true, null);
    boolean bool = release();
    AppMethodBeat.o(216355);
    return bool;
  }
  
  public boolean videoTrackWritable()
  {
    boolean bool2 = true;
    if ((this.hasVideoTrack) && ((this.muxerStarted) || (this.videoEncodeFormat == null))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.hasVideoTrack)
        {
          bool1 = bool2;
          if (!this.muxerStarted)
          {
            if (this.videoEncodeFormat == null) {
              bool1 = bool2;
            }
          }
          else {
            return bool1;
          }
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public void writeAudioSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(216348);
    Logger.i(this.TAG, "writeAudioSample: " + paramLong + "  " + paramByteBuffer.limit());
    long l2 = System.currentTimeMillis();
    if (paramByteBuffer != null) {}
    try
    {
      boolean bool = this.released;
      if (bool)
      {
        Logger.i(this.TAG, "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
        AppMethodBeat.o(216348);
        return;
      }
      int k = paramByteBuffer.limit();
      int m = paramByteBuffer.position();
      int i = paramByteBuffer.position();
      long l1 = 0L;
      for (;;)
      {
        if (i < k) {
          try
          {
            this.audioEncoderLock.lock();
            l1 += this.audioEncoder.writeAudioSample(paramLong + l1, paramByteBuffer);
            int j = paramByteBuffer.position();
            if (j == i) {
              Logger.w(this.TAG, "write audio sample not forward");
            }
            paramByteBuffer.limit(k);
            this.audioEncoderLock.unlock();
            drainAudioEncoder(false, null);
            checkStartMuxer();
            i = j;
          }
          finally
          {
            this.audioEncoderLock.unlock();
            AppMethodBeat.o(216348);
          }
        }
      }
      return;
    }
    finally
    {
      try
      {
        paramByteBuffer = new ExportRuntimeException(-122, paramByteBuffer);
        AppMethodBeat.o(216348);
        throw paramByteBuffer;
      }
      finally
      {
        Logger.i(this.TAG, "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
        AppMethodBeat.o(216348);
      }
      paramByteBuffer.position(m);
      paramByteBuffer.limit(k);
      Logger.i(this.TAG, "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
      AppMethodBeat.o(216348);
    }
  }
  
  /* Error */
  public void writeVideoSample(CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: ldc_w 733
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   9: lstore_2
    //   10: aload_0
    //   11: getfield 138	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnonnull +38 -> 56
    //   21: aload_0
    //   22: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   25: new 89	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 735
    //   32: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   38: lload_2
    //   39: lsub
    //   40: invokevirtual 708	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: ldc_w 733
    //   52: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   59: lstore 4
    //   61: aload_0
    //   62: iconst_0
    //   63: aload_1
    //   64: invokespecial 586	com/tencent/tav/decoder/EncoderWriter:drainVideoEncoder	(ZLcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   67: aload_0
    //   68: invokespecial 730	com/tencent/tav/decoder/EncoderWriter:checkStartMuxer	()V
    //   71: aload_0
    //   72: getfield 116	com/tencent/tav/decoder/EncoderWriter:encodeReporter	Lcom/tencent/tav/report/AverageTimeReporter;
    //   75: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   78: lload 4
    //   80: lsub
    //   81: invokevirtual 738	com/tencent/tav/report/AverageTimeReporter:add	(J)V
    //   84: aload_1
    //   85: invokevirtual 744	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   88: invokevirtual 749	com/tencent/tav/coremedia/CMSampleState:isInvalid	()Z
    //   91: ifne +52 -> 143
    //   94: aload_0
    //   95: getfield 164	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   98: iconst_1
    //   99: aload_1
    //   100: invokevirtual 753	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   103: invokeinterface 757 3 0
    //   108: aload_0
    //   109: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   112: new 89	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 735
    //   119: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   125: lload_2
    //   126: lsub
    //   127: invokevirtual 708	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: ldc_w 733
    //   139: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: aload_0
    //   144: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   147: ldc_w 759
    //   150: invokestatic 264	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto -45 -> 108
    //   156: astore_1
    //   157: aload_0
    //   158: getfield 107	com/tencent/tav/decoder/EncoderWriter:TAG	Ljava/lang/String;
    //   161: new 89	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 735
    //   168: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   174: lload_2
    //   175: lsub
    //   176: invokevirtual 708	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   179: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 205	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: ldc_w 733
    //   188: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	EncoderWriter
    //   0	193	1	paramCMSampleBuffer	CMSampleBuffer
    //   9	166	2	l1	long
    //   59	20	4	l2	long
    //   14	3	6	localSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   10	16	156	finally
    //   56	108	156	finally
    //   143	153	156	finally
  }
  
  @Deprecated
  public static final class OutputConfig
  {
    public int AUDIO_AAC_PROFILE = 2;
    public int AUDIO_BIT_RATE = 128000;
    public int AUDIO_CHANNEL_COUNT = 1;
    public String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public int AUDIO_SAMPLE_RATE_HZ = 44100;
    public boolean HIGH_PROFILE = false;
    public int VIDEO_BIT_RATE = 8000000;
    public int VIDEO_FRAME_RATE = 30;
    public int VIDEO_IFRAME_INTERVAL = 1;
    public int VIDEO_TARGET_HEIGHT = 0;
    public int VIDEO_TARGET_WIDTH = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */