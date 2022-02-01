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
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
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
  private final AverageTimeReporter encodeReporter;
  private boolean hasAudioTrack;
  private boolean hasVideoTrack;
  private ReadWriteLock lock;
  private IMediaMuxer muxer;
  private volatile boolean muxerStarted;
  private volatile int outputAudioTrack;
  private volatile int outputVideoTrack;
  private boolean released;
  private volatile MediaCodec.BufferInfo videoBufferInfo;
  private volatile MediaFormat videoEncodeFormat;
  private AssetWriterVideoEncoder videoEncoder;
  private Lock videoEncoderLock;
  private boolean videoEncoderStarted;
  
  public EncoderWriter(String paramString)
  {
    this(paramString, null);
  }
  
  public EncoderWriter(String paramString, AssetWriterVideoEncoder paramAssetWriterVideoEncoder)
  {
    AppMethodBeat.i(190659);
    this.encodeReporter = new AverageTimeReporter();
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
    paramString = paramAssetWriterVideoEncoder;
    if (paramAssetWriterVideoEncoder == null) {
      paramString = new MediaCodecAssetWriterVideoEncoder();
    }
    this.videoEncoder = paramString;
    this.videoEncoder.setMediaMuxer(this.muxer);
    AppMethodBeat.o(190659);
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(190799);
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      AppMethodBeat.o(190799);
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
      AppMethodBeat.o(190799);
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
    AppMethodBeat.i(190793);
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(190793);
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
      AppMethodBeat.o(190793);
      throw localException;
    }
  }
  
  private void drainEncoder(boolean paramBoolean, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(190778);
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    boolean bool1;
    label52:
    boolean bool3;
    label62:
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
        break label328;
      }
      bool1 = true;
      if (this.hasAudioTrack) {
        break label334;
      }
      bool3 = true;
      l = System.currentTimeMillis();
      bool4 = bool1;
      bool1 = bool3;
      label75:
      if (((bool4) || (!this.hasVideoTrack)) && ((bool1) || (!this.hasAudioTrack))) {
        break label362;
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
        bool3 = writeVideoFrame(paramCMSampleBuffer, paramBoolean);
        if (System.currentTimeMillis() - l <= 2000L) {
          break label384;
        }
        if (paramBoolean) {
          break label340;
        }
        bool3 = true;
        label150:
        this.hasVideoTrack = bool3;
        Logger.e("EncoderWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
        bool3 = true;
      }
    }
    label384:
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
              break label346;
            }
            bool1 = true;
            label211:
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
              break label368;
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
              label328:
              label334:
              label340:
              label346:
              AppMethodBeat.o(190778);
            }
          }
          signalEndOfVideoStream();
          i = j;
          break;
          bool1 = false;
          break label52;
          bool3 = false;
          break label62;
          bool3 = false;
          break label150;
          bool1 = false;
          break label211;
          label362:
          AppMethodBeat.o(190778);
          return;
          label368:
          bool4 = bool3;
          i = j;
          break label75;
        }
      }
    }
  }
  
  private void fixAudioFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(190713);
    fixStringKey(paramMediaFormat, "mime", "audio/mp4a-latm");
    fixIntegerKey(paramMediaFormat, "sample-rate", 44100);
    fixIntegerKey(paramMediaFormat, "channel-count", 1);
    fixIntegerKey(paramMediaFormat, "bitrate", 128000);
    fixIntegerKey(paramMediaFormat, "aac-profile", 2);
    Logger.d("EncoderWriter", "fixAudioFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(190713);
  }
  
  private void fixIntegerKey(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(190718);
    if ((!paramMediaFormat.containsKey(paramString)) || (paramMediaFormat.getInteger(paramString) <= 0))
    {
      Logger.w("EncoderWriter", "fixIntegerKey: 缺少关键配置：" + paramString + ", 使用默认值：" + paramInt);
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(190718);
  }
  
  private void fixStringKey(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    AppMethodBeat.i(190721);
    if ((!paramMediaFormat.containsKey(paramString1)) || (TextUtils.isEmpty(paramMediaFormat.getString(paramString1))))
    {
      Logger.w("EncoderWriter", "fixStringKey: 缺少关键配置：" + paramString1 + ", 使用默认值：" + paramString2);
      paramMediaFormat.setString(paramString1, paramString2);
    }
    AppMethodBeat.o(190721);
  }
  
  private void fixVideoFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(190706);
    paramMediaFormat.setInteger("color-format", 2130708361);
    fixStringKey(paramMediaFormat, "mime", "video/avc");
    fixIntegerKey(paramMediaFormat, "bitrate", 8000000);
    fixIntegerKey(paramMediaFormat, "frame-rate", 30);
    fixIntegerKey(paramMediaFormat, "i-frame-interval", 1);
    Logger.d("EncoderWriter", "fixVideoFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(190706);
  }
  
  private ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(190807);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(190807);
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
      AppMethodBeat.o(190807);
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
    AppMethodBeat.i(190817);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(190817);
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
      AppMethodBeat.o(190817);
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
    AppMethodBeat.i(190700);
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
      AppMethodBeat.o(190700);
      return;
    }
    catch (Exception paramExportConfig)
    {
      paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-104, paramExportConfig, localMediaFormat.toString()));
      AppMethodBeat.o(190700);
      throw paramExportConfig;
    }
  }
  
  private void prepareVideoEncoder(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(190692);
    MediaFormat localMediaFormat = paramExportConfig.getVideoFormat();
    fixVideoFormat(localMediaFormat);
    this.videoEncoder.prepare(paramExportConfig, localMediaFormat);
    AppMethodBeat.o(190692);
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(190834);
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(190834);
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
      AppMethodBeat.o(190834);
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
    //   0: ldc_w 468
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 140	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   11: ldc 32
    //   13: ldc_w 470
    //   16: aload_0
    //   17: invokestatic 385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 388	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 405	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   30: invokeinterface 476 1 0
    //   35: invokeinterface 480 1 0
    //   40: ldc 32
    //   42: ldc_w 482
    //   45: aload_0
    //   46: invokestatic 385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: invokevirtual 388	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic 313	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 153	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +26 -> 87
    //   64: aload_0
    //   65: getfield 153	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   68: invokeinterface 485 1 0
    //   73: aload_0
    //   74: getfield 153	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   77: invokeinterface 487 1 0
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 153	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   87: aload_0
    //   88: getfield 431	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +22 -> 115
    //   96: aload_0
    //   97: getfield 431	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   100: invokevirtual 488	android/media/MediaCodec:stop	()V
    //   103: aload_0
    //   104: getfield 431	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   107: invokevirtual 489	android/media/MediaCodec:release	()V
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 431	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   115: aload_0
    //   116: getfield 148	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   119: ifnull +38 -> 157
    //   122: aload_0
    //   123: getfield 134	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   126: ifeq +17 -> 143
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 134	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   134: aload_0
    //   135: getfield 148	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   138: invokeinterface 490 1 0
    //   143: aload_0
    //   144: getfield 148	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   147: invokeinterface 491 1 0
    //   152: aload_0
    //   153: aconst_null
    //   154: putfield 148	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   157: aload_0
    //   158: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   161: invokeinterface 476 1 0
    //   166: invokeinterface 494 1 0
    //   171: ldc 32
    //   173: new 193	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 496
    //   180: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_0
    //   184: getfield 95	com/tencent/tav/decoder/EncoderWriter:encodeReporter	Lcom/tencent/tav/report/AverageTimeReporter;
    //   187: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 405	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc_w 468
    //   199: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: astore_1
    //   204: ldc 32
    //   206: ldc_w 498
    //   209: aload_1
    //   210: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: goto -140 -> 73
    //   216: astore_1
    //   217: aload_0
    //   218: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   221: invokeinterface 476 1 0
    //   226: invokeinterface 494 1 0
    //   231: ldc_w 468
    //   234: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: ldc 32
    //   242: ldc_w 500
    //   245: aload_1
    //   246: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: goto -167 -> 82
    //   252: astore_1
    //   253: ldc 32
    //   255: ldc_w 502
    //   258: aload_1
    //   259: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: goto -159 -> 103
    //   265: astore_1
    //   266: ldc 32
    //   268: ldc_w 504
    //   271: aload_1
    //   272: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   275: goto -165 -> 110
    //   278: astore_1
    //   279: ldc 32
    //   281: ldc_w 506
    //   284: aload_1
    //   285: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto -145 -> 143
    //   291: astore_1
    //   292: ldc 32
    //   294: ldc_w 508
    //   297: aload_1
    //   298: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: goto -149 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	EncoderWriter
    //   59	34	1	localObject1	Object
    //   203	7	1	localException1	Exception
    //   216	22	1	localObject2	Object
    //   239	7	1	localException2	Exception
    //   252	7	1	localException3	Exception
    //   265	7	1	localException4	Exception
    //   278	7	1	localException5	Exception
    //   291	7	1	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   64	73	203	java/lang/Exception
    //   26	60	216	finally
    //   64	73	216	finally
    //   73	82	216	finally
    //   82	87	216	finally
    //   87	92	216	finally
    //   96	103	216	finally
    //   103	110	216	finally
    //   110	115	216	finally
    //   115	134	216	finally
    //   134	143	216	finally
    //   143	152	216	finally
    //   152	157	216	finally
    //   204	213	216	finally
    //   240	249	216	finally
    //   253	262	216	finally
    //   266	275	216	finally
    //   279	288	216	finally
    //   292	301	216	finally
    //   73	82	239	java/lang/Exception
    //   96	103	252	java/lang/Exception
    //   103	110	265	java/lang/Exception
    //   134	143	278	java/lang/Exception
    //   143	152	291	java/lang/Exception
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190827);
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(190827);
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
      AppMethodBeat.o(190827);
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
    AppMethodBeat.i(190753);
    try
    {
      boolean bool = this.enOfAudioInputStream;
      if (bool)
      {
        AppMethodBeat.o(190753);
        return;
      }
      Logger.d("EncoderWriter", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        this.enOfAudioInputStream = true;
      }
      AppMethodBeat.o(190753);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfAudioStream failed", localThrowable);
      AppMethodBeat.o(190753);
    }
  }
  
  private void signalEndOfVideoStream()
  {
    AppMethodBeat.i(190745);
    Logger.d("EncoderWriter", "signalEndOfVideoStream: ");
    if ((this._inputSurface == null) || (this.enOfVideoInputStream))
    {
      AppMethodBeat.o(190745);
      return;
    }
    try
    {
      this.videoEncoder.signalEndOfInputStream();
      this.enOfVideoInputStream = true;
      AppMethodBeat.o(190745);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfVideoStream failed", localThrowable);
      AppMethodBeat.o(190745);
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
    AppMethodBeat.i(190838);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(190838);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(190838);
    }
  }
  
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(190852);
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        this.audioEncoderLock.lock();
        if ((!this.muxerStarted) && (this.audioEncodeFormat != null)) {
          break label415;
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
        AppMethodBeat.o(190852);
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
          if (this.audioBufferInfo.presentationTimeUs >= 0L) {
            this.muxer.writeSampleDataTime(false, CMTime.fromSeconds((float)this.audioBufferInfo.presentationTimeUs));
          }
          this.muxer.writeSampleData(this.outputAudioTrack, localByteBuffer, localBufferInfo);
          Logger.v("EncoderWriter", "writeAudioFrame:  " + this.audioBufferInfo.presentationTimeUs);
          this.audioPresentationTimeUs = this.audioBufferInfo.presentationTimeUs;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e("EncoderWriter", "writeAudioFrame: ", localException);
          }
        }
        releaseOutputBuffer(this.audioEncoder, i, false);
        bool1 = bool2;
        if ((this.audioBufferInfo.flags & 0x4) != 0)
        {
          Logger.i("EncoderWriter", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
          this.audioPresentationTimeUs = -1L;
          this.hasAudioTrack = false;
          bool1 = true;
          continue;
          label415:
          bool1 = bool2;
          if (!paramBoolean) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private boolean writeVideoFrame(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(190785);
    try
    {
      this.videoEncoderLock.lock();
      paramBoolean = this.videoEncoder.writeVideoSample(paramCMSampleBuffer, paramBoolean);
      this.videoEncodeFormat = this.videoEncoder.getEncodeFormat();
      if (this.videoEncoder.isEncodeToEndOfStream()) {
        this.hasVideoTrack = false;
      }
      return paramBoolean;
    }
    catch (Throwable paramCMSampleBuffer)
    {
      paramCMSampleBuffer = new ExportRuntimeException(-121, paramCMSampleBuffer);
      AppMethodBeat.o(190785);
      throw paramCMSampleBuffer;
    }
    finally
    {
      this.videoEncoderLock.unlock();
      AppMethodBeat.o(190785);
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
      AppMethodBeat.i(190663);
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      AppMethodBeat.o(190663);
      return localSurface;
    }
    finally {}
  }
  
  public void endWriteAudioSample()
  {
    AppMethodBeat.i(190748);
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
      drainEncoder(false, null);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
      AppMethodBeat.o(190748);
    }
  }
  
  /* Error */
  public void endWriteVideoSample(CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: ldc_w 639
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 32
    //   8: ldc_w 641
    //   11: invokestatic 313	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   18: invokeinterface 630 1 0
    //   23: invokeinterface 480 1 0
    //   28: aload_0
    //   29: getfield 140	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +24 -> 58
    //   37: aload_0
    //   38: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   41: invokeinterface 630 1 0
    //   46: invokeinterface 494 1 0
    //   51: ldc_w 639
    //   54: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: aload_0
    //   59: getfield 117	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   62: ifnull +12 -> 74
    //   65: aload_0
    //   66: getfield 101	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq +24 -> 95
    //   74: aload_0
    //   75: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   78: invokeinterface 630 1 0
    //   83: invokeinterface 494 1 0
    //   88: ldc_w 639
    //   91: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_0
    //   96: getfield 153	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   99: invokeinterface 532 1 0
    //   104: aload_0
    //   105: iconst_1
    //   106: putfield 101	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   109: aload_0
    //   110: iconst_0
    //   111: aload_1
    //   112: invokespecial 634	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(ZLcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   115: aload_0
    //   116: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   119: invokeinterface 630 1 0
    //   124: invokeinterface 494 1 0
    //   129: ldc_w 639
    //   132: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_3
    //   137: ldc 32
    //   139: ldc_w 643
    //   142: aload_3
    //   143: invokestatic 184	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: goto -37 -> 109
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 115	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   154: invokeinterface 630 1 0
    //   159: invokeinterface 494 1 0
    //   164: ldc_w 639
    //   167: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	EncoderWriter
    //   0	172	1	paramCMSampleBuffer	CMSampleBuffer
    //   32	39	2	bool	boolean
    //   136	7	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   95	109	136	java/lang/Throwable
    //   14	33	149	finally
    //   58	70	149	finally
    //   95	109	149	finally
    //   109	115	149	finally
    //   137	146	149	finally
  }
  
  public long getAudioPresentationTimeUs()
  {
    return this.audioPresentationTimeUs;
  }
  
  public int getOutHeight()
  {
    AppMethodBeat.i(190669);
    int i = (int)this.videoEncoder.getEncodeSize().height;
    AppMethodBeat.o(190669);
    return i;
  }
  
  public int getOutWidth()
  {
    AppMethodBeat.i(190664);
    int i = (int)this.videoEncoder.getEncodeSize().width;
    AppMethodBeat.o(190664);
    return i;
  }
  
  public AverageTimeReporter getPerformance()
  {
    return this.encodeReporter;
  }
  
  public long getVideoPresentationTimeUs()
  {
    AppMethodBeat.i(190673);
    long l = this.videoEncoder.getEncodePresentationTimeUs();
    AppMethodBeat.o(190673);
    return l;
  }
  
  public boolean isVideoEncodeNeedVideoRenderOutputTexture()
  {
    AppMethodBeat.i(190688);
    boolean bool = this.videoEncoder.isNeedVideoOutputTexture();
    AppMethodBeat.o(190688);
    return bool;
  }
  
  public void processVideoTexture(TextureInfo paramTextureInfo, CMTime paramCMTime)
  {
    AppMethodBeat.i(190690);
    this.videoEncoder.processVideoTexture(paramTextureInfo, paramCMTime);
    AppMethodBeat.o(190690);
  }
  
  public void setEncodeOption(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(190677);
    if ((paramExportConfig.getOutputWidth() <= 0) || (paramExportConfig.getOutputHeight() <= 0))
    {
      paramExportConfig = new IllegalArgumentException("width and height must > 0");
      AppMethodBeat.o(190677);
      throw paramExportConfig;
    }
    this.encodeOption = paramExportConfig.clone();
    this.muxer.setExportConfig(paramExportConfig);
    AppMethodBeat.o(190677);
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(190735);
    this.videoEncoder.setVideoSampleRenderContext(paramRenderContext);
    AppMethodBeat.o(190735);
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 707
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 110	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 480 1 0
    //   17: ldc 32
    //   19: ldc_w 709
    //   22: aload_0
    //   23: invokestatic 385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 388	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 313	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 697	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   37: invokespecial 711	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 99	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   45: aload_0
    //   46: getfield 431	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   49: invokevirtual 712	android/media/MediaCodec:start	()V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 138	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   57: aload_0
    //   58: getfield 110	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 494 1 0
    //   66: ldc_w 707
    //   69: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 110	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   80: invokeinterface 494 1 0
    //   85: ldc_w 707
    //   88: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 714
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 108	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 480 1 0
    //   17: ldc 32
    //   19: ldc_w 716
    //   22: aload_0
    //   23: invokestatic 385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 388	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 313	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 697	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   37: invokespecial 718	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 97	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   45: aload_0
    //   46: invokevirtual 719	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   49: pop
    //   50: aload_0
    //   51: getfield 153	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   54: invokeinterface 721 1 0
    //   59: pop
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 136	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   65: aload_0
    //   66: getfield 108	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 494 1 0
    //   74: ldc_w 714
    //   77: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 108	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 494 1 0
    //   93: ldc_w 714
    //   96: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	EncoderWriter
    //   83	17	1	localObject1	Object
    //   101	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	65	83	finally
    //   2	8	101	finally
    //   65	80	101	finally
    //   84	101	101	finally
  }
  
  public void stop()
  {
    AppMethodBeat.i(190857);
    Logger.i("EncoderWriter", "AssetWriter stop ".concat(String.valueOf(this)));
    if (this.released)
    {
      AppMethodBeat.o(190857);
      return;
    }
    if ((!this.videoEncoderStarted) && (!this.audioEncoderStarted))
    {
      AppMethodBeat.o(190857);
      return;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainEncoder(true, null);
    release();
    AppMethodBeat.o(190857);
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
    AppMethodBeat.i(190766);
    Logger.e("EncoderWriter", "writeAudioSample: " + paramLong + "  " + paramByteBuffer.limit());
    long l2 = System.currentTimeMillis();
    label510:
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
                break label510;
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
              drainEncoder(false, null);
              continue;
            }
            finally
            {
              this.audioEncoderLock.unlock();
              AppMethodBeat.o(190766);
            }
          }
        }
        paramByteBuffer.position(0);
      }
      catch (Throwable paramByteBuffer)
      {
        paramByteBuffer = new ExportRuntimeException(-122, paramByteBuffer);
        AppMethodBeat.o(190766);
        throw paramByteBuffer;
      }
      finally
      {
        this.lock.readLock().unlock();
        Logger.e("EncoderWriter", "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
        AppMethodBeat.o(190766);
      }
      paramByteBuffer.limit(j);
      this.lock.readLock().unlock();
      Logger.e("EncoderWriter", "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
      AppMethodBeat.o(190766);
      return;
    }
  }
  
  public void writeVideoSample(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(190732);
    Logger.i("EncoderWriter", "writeVideoSample");
    long l1 = System.currentTimeMillis();
    try
    {
      this.lock.readLock().lock();
      Surface localSurface = this._inputSurface;
      if (localSurface == null) {
        return;
      }
      long l2 = System.currentTimeMillis();
      drainEncoder(false, paramCMSampleBuffer);
      this.encodeReporter.add(System.currentTimeMillis() - l2);
      if (!paramCMSampleBuffer.getState().isInvalid()) {
        this.muxer.writeSampleDataTime(true, paramCMSampleBuffer.getTime());
      }
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
      Logger.i("EncoderWriter", "writeVideoSample finish cost " + (System.currentTimeMillis() - l1));
      AppMethodBeat.o(190732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */