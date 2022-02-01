package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
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
  private static final String TAG = "EncoderWriter";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private Surface _inputSurface;
  private volatile MediaCodec.BufferInfo audioBufferInfo;
  private volatile MediaFormat audioEncodeFormat;
  private MediaCodec audioEncoder;
  private Lock audioEncoderLock;
  private boolean audioEncoderStarted;
  private long audioPresentationTimeUs;
  private boolean enOfAudioInputStream;
  private boolean enOfVideoInputStream;
  private ExportConfig encodeOption;
  private boolean hasAudioTrack;
  private boolean hasVideoTrack;
  private ReadWriteLock lock;
  private IMediaMuxer muxer;
  private volatile boolean muxerStarted;
  private int outHeight;
  private int outWidth;
  private volatile int outputAudioTrack;
  private volatile int outputVideoTrack;
  private boolean released;
  private volatile MediaCodec.BufferInfo videoBufferInfo;
  private volatile MediaFormat videoEncodeFormat;
  private MediaCodec videoEncoder;
  private Lock videoEncoderLock;
  private boolean videoEncoderStarted;
  private long videoPresentationTimeUs;
  
  public EncoderWriter(String paramString)
  {
    AppMethodBeat.i(218189);
    this.hasVideoTrack = false;
    this.hasAudioTrack = false;
    this.enOfVideoInputStream = false;
    this.enOfAudioInputStream = false;
    this.videoEncoderLock = new ReentrantLock();
    this.audioEncoderLock = new ReentrantLock();
    this.lock = new ReentrantReadWriteLock();
    this._inputSurface = null;
    this.videoBufferInfo = new MediaCodec.BufferInfo();
    this.audioBufferInfo = new MediaCodec.BufferInfo();
    this.videoEncodeFormat = null;
    this.audioEncodeFormat = null;
    this.outputVideoTrack = -1;
    this.outputAudioTrack = -1;
    this.muxerStarted = false;
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    this.released = false;
    this.muxer = MediaMuxerFactory.createMediaMuxer(paramString, 0);
    AppMethodBeat.o(218189);
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(218210);
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      AppMethodBeat.o(218210);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("EncoderWriter", "dequeueInputBuffer e = ", localException);
        if ((21 > Build.VERSION.SDK_INT) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("EncoderWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(218210);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private int dequeueOutputBuffer(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(218209);
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(218209);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("EncoderWriter", "dequeueOutputBuffer e = ", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("EncoderWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(218209);
      throw localException;
    }
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(218207);
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    boolean bool1;
    label50:
    boolean bool3;
    label60:
    long l;
    boolean bool4;
    if (paramBoolean)
    {
      i = j;
      if (this.hasVideoTrack)
      {
        if (this._inputSurface == null) {
          i = 1;
        }
      }
      else {
        bool2 = this.hasAudioTrack;
      }
    }
    else
    {
      if (this.hasVideoTrack) {
        break label319;
      }
      bool1 = true;
      if (this.hasAudioTrack) {
        break label325;
      }
      bool3 = true;
      l = System.currentTimeMillis();
      bool4 = bool1;
      bool1 = bool3;
      label73:
      if (((bool4) || (!this.hasVideoTrack)) && ((bool1) || (!this.hasAudioTrack))) {
        break label355;
      }
      j = i;
      if (i != 0)
      {
        signalEndOfVideoStream();
        j = 0;
      }
      bool3 = bool4;
      if (!bool4)
      {
        bool3 = writeVideoFrame(paramBoolean);
        if (System.currentTimeMillis() - l <= 2000L) {
          break label376;
        }
        if (paramBoolean) {
          break label331;
        }
        bool3 = true;
        label145:
        this.hasVideoTrack = bool3;
        Logger.e("EncoderWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
        bool3 = true;
      }
    }
    label205:
    label337:
    label355:
    label361:
    label376:
    for (;;)
    {
      if (bool2)
      {
        signalEndOfAudioStream();
        bool2 = false;
      }
      for (;;)
      {
        if (!bool1)
        {
          bool1 = writeAudioFrame(paramBoolean);
          if (System.currentTimeMillis() - l > 2000L)
          {
            if (paramBoolean) {
              break label337;
            }
            bool1 = true;
            this.hasAudioTrack = bool1;
            Logger.e("EncoderWriter", "drainEncoder: 音频写入处理时间超时，提前结束写入");
            bool1 = true;
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (!unStarted()) {
              break label361;
            }
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
              bool4 = bool3;
              i = j;
              break;
            }
            finally
            {
              AppMethodBeat.o(218207);
            }
          }
          signalEndOfVideoStream();
          i = j;
          break;
          bool1 = false;
          break label50;
          bool3 = false;
          break label60;
          bool3 = false;
          break label145;
          bool1 = false;
          break label205;
          AppMethodBeat.o(218207);
          return;
          bool4 = bool3;
          i = j;
          break label73;
        }
      }
    }
  }
  
  private void fixAudioFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218197);
    fixStringKey(paramMediaFormat, "mime", "audio/mp4a-latm");
    fixIntegerKey(paramMediaFormat, "sample-rate", 44100);
    fixIntegerKey(paramMediaFormat, "channel-count", 1);
    fixIntegerKey(paramMediaFormat, "bitrate", 128000);
    fixIntegerKey(paramMediaFormat, "aac-profile", 2);
    Logger.d("EncoderWriter", "fixAudioFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(218197);
  }
  
  private void fixIntegerKey(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(218198);
    if ((!paramMediaFormat.containsKey(paramString)) || (paramMediaFormat.getInteger(paramString) <= 0))
    {
      Logger.w("EncoderWriter", "fixIntegerKey: 缺少关键配置：" + paramString + ", 使用默认值：" + paramInt);
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(218198);
  }
  
  private void fixStringKey(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    AppMethodBeat.i(218199);
    if ((!paramMediaFormat.containsKey(paramString1)) || (TextUtils.isEmpty(paramMediaFormat.getString(paramString1))))
    {
      Logger.w("EncoderWriter", "fixStringKey: 缺少关键配置：" + paramString1 + ", 使用默认值：" + paramString2);
      paramMediaFormat.setString(paramString1, paramString2);
    }
    AppMethodBeat.o(218199);
  }
  
  private void fixVideoFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218196);
    paramMediaFormat.setInteger("color-format", 2130708361);
    fixStringKey(paramMediaFormat, "mime", "video/avc");
    fixIntegerKey(paramMediaFormat, "bitrate", 8000000);
    fixIntegerKey(paramMediaFormat, "frame-rate", 30);
    fixIntegerKey(paramMediaFormat, "i-frame-interval", 1);
    Logger.d("EncoderWriter", "fixVideoFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(218196);
  }
  
  private ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(218211);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(218211);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("EncoderWriter", "getInputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("EncoderWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(218211);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(218212);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(218212);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("EncoderWriter", "getOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("EncoderWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(218212);
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
    AppMethodBeat.i(218195);
    Logger.d("EncoderWriter", "AssetWriter prepareAudioEncoder ".concat(String.valueOf(this)));
    MediaFormat localMediaFormat = paramExportConfig.getAudioFormat();
    fixAudioFormat(localMediaFormat);
    Logger.i("EncoderWriter", "prepareAudioEncoder, input mediaFormat:" + localMediaFormat + ", isAudioEncodeNeedCodecSpecificData:" + paramExportConfig.isAudioEncodeNeedCodecSpecificData());
    if (paramExportConfig.isAudioEncodeNeedCodecSpecificData())
    {
      int i = localMediaFormat.getInteger("aac-profile");
      int j = localMediaFormat.getInteger("sample-rate");
      int k = localMediaFormat.getInteger("channel-count");
      Logger.i("EncoderWriter", "try set adts csd-0 data, profile:" + i + ", sampleRate:" + j + ", " + k);
      localMediaFormat.setByteBuffer("csd-0", ADTSUtils.getADTSCodecSpecificData(i, j, k));
    }
    try
    {
      Logger.i("EncoderWriter", "prepareAudioEncoder: format = ".concat(String.valueOf(localMediaFormat)));
      this.audioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
      this.audioEncoder.configure(localMediaFormat, null, null, 1);
      AppMethodBeat.o(218195);
      return;
    }
    catch (Exception paramExportConfig)
    {
      paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-104, paramExportConfig, localMediaFormat.toString()));
      AppMethodBeat.o(218195);
      throw paramExportConfig;
    }
  }
  
  private void prepareVideoEncoder(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(218194);
    CGSize localCGSize = CodecHelper.correctSupportSize(paramExportConfig.getOutputSize(), "video/avc");
    this.outHeight = ((int)localCGSize.height);
    this.outWidth = ((int)localCGSize.width);
    paramExportConfig = paramExportConfig.getVideoFormat();
    fixVideoFormat(paramExportConfig);
    try
    {
      Logger.i("EncoderWriter", "prepareVideoEncoder: format = ".concat(String.valueOf(paramExportConfig)));
      this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
      this.videoEncoder.configure(paramExportConfig, null, null, 1);
      AppMethodBeat.o(218194);
      return;
    }
    catch (Exception localException1)
    {
      Logger.e("EncoderWriter", "prepareVideoEncoder: 失败，准备重试。format = ".concat(String.valueOf(paramExportConfig)), localException1);
      paramExportConfig.setInteger("profile", 0);
      paramExportConfig.setInteger("level", 0);
      try
      {
        this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
        this.videoEncoder.configure(paramExportConfig, null, null, 1);
        AppMethodBeat.o(218194);
        return;
      }
      catch (Exception localException2)
      {
        Logger.e("EncoderWriter", "prepareVideoEncoder: retry 失败 format = ".concat(String.valueOf(paramExportConfig)), localException2);
        paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-103, localException2, paramExportConfig.toString()));
        AppMethodBeat.o(218194);
        throw paramExportConfig;
      }
    }
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(218214);
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(218214);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("EncoderWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      AppMethodBeat.o(218214);
      throw localException;
    }
    catch (Error localError)
    {
      label27:
      break label27;
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: ldc_w 480
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 132	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   11: new 175	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 482
    //   18: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_0
    //   27: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   30: invokeinterface 488 1 0
    //   35: invokeinterface 492 1 0
    //   40: ldc 33
    //   42: ldc_w 494
    //   45: aload_0
    //   46: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic 294	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 461	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +22 -> 83
    //   64: aload_0
    //   65: getfield 461	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   68: invokevirtual 497	android/media/MediaCodec:stop	()V
    //   71: aload_0
    //   72: getfield 461	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   75: invokevirtual 499	android/media/MediaCodec:release	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 461	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   83: aload_0
    //   84: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +22 -> 111
    //   92: aload_0
    //   93: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   96: invokevirtual 497	android/media/MediaCodec:stop	()V
    //   99: aload_0
    //   100: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   103: invokevirtual 499	android/media/MediaCodec:release	()V
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   111: aload_0
    //   112: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   115: ifnull +38 -> 153
    //   118: aload_0
    //   119: getfield 126	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   122: ifeq +17 -> 139
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 126	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   130: aload_0
    //   131: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   134: invokeinterface 500 1 0
    //   139: aload_0
    //   140: getfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   143: invokeinterface 501 1 0
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 140	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   153: aload_0
    //   154: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   157: invokeinterface 488 1 0
    //   162: invokeinterface 504 1 0
    //   167: ldc_w 480
    //   170: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: astore_1
    //   175: ldc 33
    //   177: ldc_w 506
    //   180: aload_1
    //   181: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -113 -> 71
    //   187: astore_1
    //   188: aload_0
    //   189: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   192: invokeinterface 488 1 0
    //   197: invokeinterface 504 1 0
    //   202: ldc_w 480
    //   205: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: ldc 33
    //   213: ldc_w 508
    //   216: aload_1
    //   217: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -142 -> 78
    //   223: astore_1
    //   224: ldc 33
    //   226: ldc_w 510
    //   229: aload_1
    //   230: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -134 -> 99
    //   236: astore_1
    //   237: ldc 33
    //   239: ldc_w 512
    //   242: aload_1
    //   243: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: goto -140 -> 106
    //   249: astore_1
    //   250: ldc 33
    //   252: ldc_w 514
    //   255: aload_1
    //   256: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   259: goto -120 -> 139
    //   262: astore_1
    //   263: ldc 33
    //   265: ldc_w 516
    //   268: aload_1
    //   269: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: goto -124 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	EncoderWriter
    //   59	30	1	localMediaCodec	MediaCodec
    //   174	7	1	localException1	Exception
    //   187	22	1	localObject	Object
    //   210	7	1	localException2	Exception
    //   223	7	1	localException3	Exception
    //   236	7	1	localException4	Exception
    //   249	7	1	localException5	Exception
    //   262	7	1	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   64	71	174	java/lang/Exception
    //   26	60	187	finally
    //   64	71	187	finally
    //   71	78	187	finally
    //   78	83	187	finally
    //   83	88	187	finally
    //   92	99	187	finally
    //   99	106	187	finally
    //   106	111	187	finally
    //   111	130	187	finally
    //   130	139	187	finally
    //   139	148	187	finally
    //   148	153	187	finally
    //   175	184	187	finally
    //   211	220	187	finally
    //   224	233	187	finally
    //   237	246	187	finally
    //   250	259	187	finally
    //   263	272	187	finally
    //   71	78	210	java/lang/Exception
    //   92	99	223	java/lang/Exception
    //   99	106	236	java/lang/Exception
    //   130	139	249	java/lang/Exception
    //   139	148	262	java/lang/Exception
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(218213);
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(218213);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("EncoderWriter", "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("EncoderWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          releaseOutputBuffer(paramMediaCodec, paramInt, paramBoolean);
        }
      }
      AppMethodBeat.o(218213);
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
    AppMethodBeat.i(218204);
    try
    {
      boolean bool = this.enOfAudioInputStream;
      if (bool)
      {
        AppMethodBeat.o(218204);
        return;
      }
      Logger.d("EncoderWriter", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        this.enOfAudioInputStream = true;
      }
      AppMethodBeat.o(218204);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfAudioStream failed", localThrowable);
      AppMethodBeat.o(218204);
    }
  }
  
  private void signalEndOfVideoStream()
  {
    AppMethodBeat.i(218202);
    Logger.d("EncoderWriter", "signalEndOfVideoStream: ");
    if ((this._inputSurface == null) || (this.enOfVideoInputStream))
    {
      AppMethodBeat.o(218202);
      return;
    }
    try
    {
      this.videoEncoder.signalEndOfInputStream();
      this.enOfVideoInputStream = true;
      AppMethodBeat.o(218202);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfVideoStream failed", localThrowable);
      AppMethodBeat.o(218202);
    }
  }
  
  private boolean unStarted()
  {
    return (!this.muxerStarted) && ((!this.hasVideoTrack) || (this.videoEncodeFormat != null)) && ((!this.hasAudioTrack) || (this.audioEncodeFormat != null));
  }
  
  private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo paramBufferInfo)
  {
    return paramBufferInfo.size > 0;
  }
  
  private void waitTime(long paramLong)
  {
    AppMethodBeat.i(218215);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(218215);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(218215);
    }
  }
  
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(218216);
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        this.audioEncoderLock.lock();
        if ((!this.muxerStarted) && (this.audioEncodeFormat != null)) {
          break label382;
        }
        i = dequeueOutputBuffer(this.audioEncoder, this.audioBufferInfo);
        if (i == -1)
        {
          bool1 = bool2;
          if (!paramBoolean) {
            bool1 = true;
          }
          return bool1;
        }
        if (i == -2)
        {
          this.audioEncodeFormat = this.audioEncoder.getOutputFormat();
          bool1 = bool2;
          continue;
        }
        bool1 = bool2;
      }
      finally
      {
        this.audioEncoderLock.unlock();
        AppMethodBeat.o(218216);
      }
      if (i >= 0)
      {
        ByteBuffer localByteBuffer = getOutputBuffer(this.audioEncoder, i);
        if ((this.audioBufferInfo.flags & 0x2) != 0) {
          this.audioBufferInfo.size = 0;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          localByteBuffer.position(this.audioBufferInfo.offset);
          localByteBuffer.limit(this.audioBufferInfo.offset + this.audioBufferInfo.size);
        }
        if (validAndCorrectBufferInfo(this.audioBufferInfo))
        {
          paramBoolean = this.muxerStarted;
          if (!paramBoolean) {}
        }
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          localBufferInfo.set(this.audioBufferInfo.offset, this.audioBufferInfo.size, this.audioBufferInfo.presentationTimeUs, this.audioBufferInfo.flags);
          this.muxer.writeSampleData(this.outputAudioTrack, localByteBuffer, localBufferInfo);
          Logger.v("EncoderWriter", "writeAudioFrame:  " + this.audioBufferInfo.presentationTimeUs);
          this.audioPresentationTimeUs = this.audioBufferInfo.presentationTimeUs;
          releaseOutputBuffer(this.audioEncoder, i, false);
          bool1 = bool2;
          if ((this.audioBufferInfo.flags & 0x4) == 0) {
            continue;
          }
          Logger.i("EncoderWriter", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
          this.audioPresentationTimeUs = -1L;
          this.hasAudioTrack = false;
          bool1 = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e("EncoderWriter", "writeAudioFrame: ", localException);
          }
        }
        label382:
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
      }
    }
  }
  
  private boolean writeVideoFrame(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(218208);
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        this.videoEncoderLock.lock();
        if ((!this.muxerStarted) && (this.videoEncodeFormat != null)) {
          break label348;
        }
        i = dequeueOutputBuffer(this.videoEncoder, this.videoBufferInfo);
        if (i == -1)
        {
          bool1 = bool2;
          if (!paramBoolean) {
            bool1 = true;
          }
          return bool1;
        }
        if (i == -2)
        {
          this.videoEncodeFormat = this.videoEncoder.getOutputFormat();
          bool1 = bool2;
          continue;
        }
        ExportRuntimeException localExportRuntimeException;
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        localExportRuntimeException = new ExportRuntimeException(-121, localThrowable);
        AppMethodBeat.o(218208);
        throw localExportRuntimeException;
      }
      finally
      {
        this.videoEncoderLock.unlock();
        AppMethodBeat.o(218208);
      }
      if (i >= 0)
      {
        ByteBuffer localByteBuffer = getOutputBuffer(this.videoEncoder, i);
        if (((this.videoBufferInfo.flags & 0x2) != 0) && (this.muxer.ignoreHeader())) {
          this.videoBufferInfo.size = 0;
        }
        if (this.muxerStarted)
        {
          paramBoolean = validAndCorrectBufferInfo(this.videoBufferInfo);
          if (!paramBoolean) {}
        }
        try
        {
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          localBufferInfo.set(this.videoBufferInfo.offset, this.videoBufferInfo.size, this.videoBufferInfo.presentationTimeUs, this.videoBufferInfo.flags);
          this.muxer.writeSampleData(this.outputVideoTrack, localByteBuffer, localBufferInfo);
          this.videoPresentationTimeUs = this.videoBufferInfo.presentationTimeUs;
          releaseOutputBuffer(this.videoEncoder, i, false);
          bool1 = bool2;
          if ((this.videoBufferInfo.flags & 0x4) == 0) {
            continue;
          }
          Logger.i("EncoderWriter", "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
          this.videoPresentationTimeUs = -1L;
          this.hasVideoTrack = false;
          bool1 = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e("EncoderWriter", "writeVideoFrame: ", localException);
          }
        }
        label348:
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
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
      AppMethodBeat.i(218190);
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      AppMethodBeat.o(218190);
      return localSurface;
    }
    finally {}
  }
  
  public void endWriteAudioSample()
  {
    AppMethodBeat.i(218203);
    Logger.d("EncoderWriter", "endWriteAudioSample:".concat(String.valueOf(this)));
    try
    {
      this.lock.readLock().lock();
      if (!this.released)
      {
        boolean bool = this.enOfAudioInputStream;
        if (!bool) {}
      }
      else
      {
        return;
      }
      Logger.d("EncoderWriter", "endWriteAudioSample: ");
      try
      {
        int i = dequeueInputBuffer(this.audioEncoder);
        if (i >= 0)
        {
          queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
          this.enOfAudioInputStream = true;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Logger.e("EncoderWriter", "endWriteAudioSample failed", localThrowable);
        }
      }
      drainEncoder(false);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
      AppMethodBeat.o(218203);
    }
  }
  
  /* Error */
  public void endWriteVideoSample()
  {
    // Byte code:
    //   0: ldc_w 636
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 33
    //   8: ldc_w 638
    //   11: invokestatic 294	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   18: invokeinterface 628 1 0
    //   23: invokeinterface 492 1 0
    //   28: aload_0
    //   29: getfield 132	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +24 -> 58
    //   37: aload_0
    //   38: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   41: invokeinterface 628 1 0
    //   46: invokeinterface 504 1 0
    //   51: ldc_w 636
    //   54: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: aload_0
    //   59: getfield 109	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   62: ifnull +12 -> 74
    //   65: aload_0
    //   66: getfield 93	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   69: istore_1
    //   70: iload_1
    //   71: ifeq +24 -> 95
    //   74: aload_0
    //   75: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   78: invokeinterface 628 1 0
    //   83: invokeinterface 504 1 0
    //   88: ldc_w 636
    //   91: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_0
    //   96: getfield 461	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   99: invokevirtual 540	android/media/MediaCodec:signalEndOfInputStream	()V
    //   102: aload_0
    //   103: iconst_1
    //   104: putfield 93	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   107: aload_0
    //   108: iconst_0
    //   109: invokespecial 632	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(Z)V
    //   112: aload_0
    //   113: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   116: invokeinterface 628 1 0
    //   121: invokeinterface 504 1 0
    //   126: ldc_w 636
    //   129: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: astore_2
    //   134: ldc 33
    //   136: ldc_w 640
    //   139: aload_2
    //   140: invokestatic 166	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -36 -> 107
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 107	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   151: invokeinterface 628 1 0
    //   156: invokeinterface 504 1 0
    //   161: ldc_w 636
    //   164: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_2
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	EncoderWriter
    //   32	39	1	bool	boolean
    //   133	7	2	localThrowable	Throwable
    //   146	22	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   95	107	133	java/lang/Throwable
    //   14	33	146	finally
    //   58	70	146	finally
    //   95	107	146	finally
    //   107	112	146	finally
    //   134	143	146	finally
  }
  
  public long getAudioPresentationTimeUs()
  {
    return this.audioPresentationTimeUs;
  }
  
  public int getOutHeight()
  {
    return this.outHeight;
  }
  
  public int getOutWidth()
  {
    return this.outWidth;
  }
  
  public long getVideoPresentationTimeUs()
  {
    return this.videoPresentationTimeUs;
  }
  
  public void setEncodeOption(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(218191);
    if ((paramExportConfig.getOutputWidth() <= 0) || (paramExportConfig.getOutputHeight() <= 0))
    {
      paramExportConfig = new IllegalArgumentException("width and height must > 0");
      AppMethodBeat.o(218191);
      throw paramExportConfig;
    }
    this.encodeOption = paramExportConfig.clone();
    this.muxer.setExportConfig(paramExportConfig);
    AppMethodBeat.o(218191);
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 668
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 102	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 492 1 0
    //   17: ldc 33
    //   19: ldc_w 670
    //   22: aload_0
    //   23: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 294	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 663	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   37: invokespecial 672	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 91	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   45: aload_0
    //   46: getfield 412	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   49: invokevirtual 673	android/media/MediaCodec:start	()V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 130	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   57: aload_0
    //   58: getfield 102	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 504 1 0
    //   66: ldc_w 668
    //   69: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 102	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   80: invokeinterface 504 1 0
    //   85: ldc_w 668
    //   88: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	EncoderWriter
    //   75	17	1	localObject1	Object
    //   93	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	57	75	finally
    //   2	8	93	finally
    //   57	72	93	finally
    //   76	93	93	finally
  }
  
  /* Error */
  public void startVideoEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 675
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 100	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 492 1 0
    //   17: ldc 33
    //   19: ldc_w 677
    //   22: aload_0
    //   23: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 294	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 663	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   37: invokespecial 679	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 89	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   45: aload_0
    //   46: invokevirtual 680	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   49: pop
    //   50: aload_0
    //   51: getfield 461	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   54: invokevirtual 673	android/media/MediaCodec:start	()V
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 128	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   62: aload_0
    //   63: getfield 100	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   66: invokeinterface 504 1 0
    //   71: ldc_w 675
    //   74: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 100	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   85: invokeinterface 504 1 0
    //   90: ldc_w 675
    //   93: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public void stop()
  {
    AppMethodBeat.i(218217);
    Logger.d("EncoderWriter", "AssetWriter stop ".concat(String.valueOf(this)));
    if (this.released)
    {
      AppMethodBeat.o(218217);
      return;
    }
    if ((!this.videoEncoderStarted) && (!this.audioEncoderStarted))
    {
      AppMethodBeat.o(218217);
      return;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainEncoder(true);
    release();
    AppMethodBeat.o(218217);
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
    AppMethodBeat.i(218206);
    Logger.e("EncoderWriter", "writeAudioSample: " + paramLong + "  " + paramByteBuffer.limit());
    long l2 = System.currentTimeMillis();
    label509:
    for (;;)
    {
      int j;
      try
      {
        this.lock.readLock().lock();
        StringBuilder localStringBuilder = new StringBuilder("writeAudioSample: ").append(paramLong).append("  ");
        Object localObject;
        boolean bool;
        if (paramByteBuffer != null)
        {
          localObject = Integer.valueOf(paramByteBuffer.limit());
          Logger.v("EncoderWriter", localObject);
          if (paramByteBuffer != null)
          {
            bool = this.released;
            if (!bool) {
              continue;
            }
          }
        }
        else
        {
          localObject = "null";
          continue;
        }
        int i = paramByteBuffer.position();
        j = paramByteBuffer.limit();
        long l1 = 0L;
        if (i < j)
        {
          bool = this.released;
          if (!bool) {
            try
            {
              this.audioEncoderLock.lock();
              int m = dequeueInputBuffer(this.audioEncoder);
              if (m < 0) {
                break label509;
              }
              localObject = getInputBuffer(this.audioEncoder, m);
              int k = Math.min(j - i, ((ByteBuffer)localObject).capacity());
              paramByteBuffer.limit(i + k);
              paramByteBuffer.position(i);
              ((ByteBuffer)localObject).put(paramByteBuffer);
              queueInputBuffer(this.audioEncoder, m, 0, k, paramLong + l1, 0);
              i += k;
              long l3 = DecoderUtils.getAudioDuration(k, this.encodeOption.getAudioChannelCount(), this.encodeOption.getAudioSampleRateHz());
              l1 = l3 + l1;
              this.audioEncoderLock.unlock();
              drainEncoder(false);
              continue;
            }
            finally
            {
              this.audioEncoderLock.unlock();
              AppMethodBeat.o(218206);
            }
          }
        }
        paramByteBuffer.position(0);
      }
      catch (Throwable paramByteBuffer)
      {
        paramByteBuffer = new ExportRuntimeException(-122, paramByteBuffer);
        AppMethodBeat.o(218206);
        throw paramByteBuffer;
      }
      finally
      {
        this.lock.readLock().unlock();
        Logger.e("EncoderWriter", "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
        AppMethodBeat.o(218206);
      }
      paramByteBuffer.limit(j);
      this.lock.readLock().unlock();
      Logger.e("EncoderWriter", "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
      AppMethodBeat.o(218206);
      return;
    }
  }
  
  public void writeVideoSample()
  {
    AppMethodBeat.i(218200);
    Logger.i("EncoderWriter", "writeVideoSample");
    long l = System.currentTimeMillis();
    try
    {
      this.lock.readLock().lock();
      Surface localSurface = this._inputSurface;
      if (localSurface == null) {
        return;
      }
      drainEncoder(false);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
      Logger.i("EncoderWriter", "writeVideoSample finish cost " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(218200);
    }
  }
  
  public void writeVideoSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(218205);
    if (this._inputSurface != null)
    {
      AppMethodBeat.o(218205);
      return;
    }
    int i = 1;
    while (i != 0) {
      try
      {
        this.videoEncoderLock.lock();
        int j = dequeueInputBuffer(this.videoEncoder);
        if (j >= 0)
        {
          ByteBuffer localByteBuffer = getInputBuffer(this.videoEncoder, j);
          i = paramByteBuffer.limit();
          int k = paramByteBuffer.position();
          localByteBuffer.put(paramByteBuffer);
          queueInputBuffer(this.videoEncoder, j, 0, i - k, paramLong, 0);
          i = 0;
        }
        this.videoEncoderLock.unlock();
        drainEncoder(false);
      }
      finally
      {
        this.videoEncoderLock.unlock();
        AppMethodBeat.o(218205);
      }
    }
    AppMethodBeat.o(218205);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */