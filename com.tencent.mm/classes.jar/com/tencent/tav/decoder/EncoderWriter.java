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
    AppMethodBeat.i(218162);
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
    AppMethodBeat.o(218162);
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(218188);
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      AppMethodBeat.o(218188);
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
      AppMethodBeat.o(218188);
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
    AppMethodBeat.i(218187);
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(218187);
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
      AppMethodBeat.o(218187);
      throw localException;
    }
  }
  
  private void drainEncoder(boolean paramBoolean, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(218185);
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
        break label327;
      }
      bool1 = true;
      if (this.hasAudioTrack) {
        break label333;
      }
      bool3 = true;
      l = System.currentTimeMillis();
      bool4 = bool1;
      bool1 = bool3;
      label75:
      if (((bool4) || (!this.hasVideoTrack)) && ((bool1) || (!this.hasAudioTrack))) {
        break label361;
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
          break label383;
        }
        if (paramBoolean) {
          break label339;
        }
        bool3 = true;
        label150:
        this.hasVideoTrack = bool3;
        Logger.e("EncoderWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
        bool3 = true;
      }
    }
    label210:
    label339:
    label345:
    label361:
    label367:
    label383:
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
              break label345;
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
              break label367;
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
              AppMethodBeat.o(218185);
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
          break label210;
          AppMethodBeat.o(218185);
          return;
          bool4 = bool3;
          i = j;
          break label75;
        }
      }
    }
  }
  
  private void fixAudioFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218175);
    fixStringKey(paramMediaFormat, "mime", "audio/mp4a-latm");
    fixIntegerKey(paramMediaFormat, "sample-rate", 44100);
    fixIntegerKey(paramMediaFormat, "channel-count", 1);
    fixIntegerKey(paramMediaFormat, "bitrate", 128000);
    fixIntegerKey(paramMediaFormat, "aac-profile", 2);
    Logger.d("EncoderWriter", "fixAudioFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(218175);
  }
  
  private void fixIntegerKey(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(218176);
    if ((!paramMediaFormat.containsKey(paramString)) || (paramMediaFormat.getInteger(paramString) <= 0))
    {
      Logger.w("EncoderWriter", "fixIntegerKey: 缺少关键配置：" + paramString + ", 使用默认值：" + paramInt);
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(218176);
  }
  
  private void fixStringKey(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    AppMethodBeat.i(218177);
    if ((!paramMediaFormat.containsKey(paramString1)) || (TextUtils.isEmpty(paramMediaFormat.getString(paramString1))))
    {
      Logger.w("EncoderWriter", "fixStringKey: 缺少关键配置：" + paramString1 + ", 使用默认值：" + paramString2);
      paramMediaFormat.setString(paramString1, paramString2);
    }
    AppMethodBeat.o(218177);
  }
  
  private void fixVideoFormat(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218174);
    paramMediaFormat.setInteger("color-format", 2130708361);
    fixStringKey(paramMediaFormat, "mime", "video/avc");
    fixIntegerKey(paramMediaFormat, "bitrate", 8000000);
    fixIntegerKey(paramMediaFormat, "frame-rate", 30);
    fixIntegerKey(paramMediaFormat, "i-frame-interval", 1);
    Logger.d("EncoderWriter", "fixVideoFormat() called with: format = [" + paramMediaFormat + "]");
    AppMethodBeat.o(218174);
  }
  
  private ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(218189);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(218189);
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
      AppMethodBeat.o(218189);
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
    AppMethodBeat.i(218190);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(218190);
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
      AppMethodBeat.o(218190);
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
    AppMethodBeat.i(218173);
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
      AppMethodBeat.o(218173);
      return;
    }
    catch (Exception paramExportConfig)
    {
      paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-104, paramExportConfig, localMediaFormat.toString()));
      AppMethodBeat.o(218173);
      throw paramExportConfig;
    }
  }
  
  private void prepareVideoEncoder(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(218172);
    MediaFormat localMediaFormat = paramExportConfig.getVideoFormat();
    fixVideoFormat(localMediaFormat);
    this.videoEncoder.prepare(paramExportConfig, localMediaFormat);
    AppMethodBeat.o(218172);
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(218192);
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(218192);
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
      AppMethodBeat.o(218192);
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
    //   0: ldc_w 462
    //   3: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 134	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   11: ldc 33
    //   13: ldc_w 464
    //   16: aload_0
    //   17: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 382	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 399	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   30: invokeinterface 470 1 0
    //   35: invokeinterface 474 1 0
    //   40: ldc 33
    //   42: ldc_w 476
    //   45: aload_0
    //   46: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: invokevirtual 382	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +26 -> 87
    //   64: aload_0
    //   65: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   68: invokeinterface 479 1 0
    //   73: aload_0
    //   74: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   77: invokeinterface 481 1 0
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   87: aload_0
    //   88: getfield 425	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +22 -> 115
    //   96: aload_0
    //   97: getfield 425	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   100: invokevirtual 482	android/media/MediaCodec:stop	()V
    //   103: aload_0
    //   104: getfield 425	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   107: invokevirtual 483	android/media/MediaCodec:release	()V
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 425	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   115: aload_0
    //   116: getfield 142	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   119: ifnull +38 -> 157
    //   122: aload_0
    //   123: getfield 128	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   126: ifeq +17 -> 143
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 128	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   134: aload_0
    //   135: getfield 142	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   138: invokeinterface 484 1 0
    //   143: aload_0
    //   144: getfield 142	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   147: invokeinterface 485 1 0
    //   152: aload_0
    //   153: aconst_null
    //   154: putfield 142	com/tencent/tav/decoder/EncoderWriter:muxer	Lcom/tencent/tav/decoder/muxer/IMediaMuxer;
    //   157: aload_0
    //   158: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   161: invokeinterface 470 1 0
    //   166: invokeinterface 488 1 0
    //   171: ldc_w 462
    //   174: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: astore_1
    //   179: ldc 33
    //   181: ldc_w 490
    //   184: aload_1
    //   185: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -115 -> 73
    //   191: astore_1
    //   192: aload_0
    //   193: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   196: invokeinterface 470 1 0
    //   201: invokeinterface 488 1 0
    //   206: ldc_w 462
    //   209: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: ldc 33
    //   217: ldc_w 492
    //   220: aload_1
    //   221: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -142 -> 82
    //   227: astore_1
    //   228: ldc 33
    //   230: ldc_w 494
    //   233: aload_1
    //   234: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: goto -134 -> 103
    //   240: astore_1
    //   241: ldc 33
    //   243: ldc_w 496
    //   246: aload_1
    //   247: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: goto -140 -> 110
    //   253: astore_1
    //   254: ldc 33
    //   256: ldc_w 498
    //   259: aload_1
    //   260: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -120 -> 143
    //   266: astore_1
    //   267: ldc 33
    //   269: ldc_w 500
    //   272: aload_1
    //   273: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: goto -124 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	EncoderWriter
    //   59	34	1	localObject1	Object
    //   178	7	1	localException1	Exception
    //   191	22	1	localObject2	Object
    //   214	7	1	localException2	Exception
    //   227	7	1	localException3	Exception
    //   240	7	1	localException4	Exception
    //   253	7	1	localException5	Exception
    //   266	7	1	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   64	73	178	java/lang/Exception
    //   26	60	191	finally
    //   64	73	191	finally
    //   73	82	191	finally
    //   82	87	191	finally
    //   87	92	191	finally
    //   96	103	191	finally
    //   103	110	191	finally
    //   110	115	191	finally
    //   115	134	191	finally
    //   134	143	191	finally
    //   143	152	191	finally
    //   152	157	191	finally
    //   179	188	191	finally
    //   215	224	191	finally
    //   228	237	191	finally
    //   241	250	191	finally
    //   254	263	191	finally
    //   267	276	191	finally
    //   73	82	214	java/lang/Exception
    //   96	103	227	java/lang/Exception
    //   103	110	240	java/lang/Exception
    //   134	143	253	java/lang/Exception
    //   143	152	266	java/lang/Exception
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(218191);
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(218191);
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
      AppMethodBeat.o(218191);
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
    AppMethodBeat.i(218183);
    try
    {
      boolean bool = this.enOfAudioInputStream;
      if (bool)
      {
        AppMethodBeat.o(218183);
        return;
      }
      Logger.d("EncoderWriter", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        this.enOfAudioInputStream = true;
      }
      AppMethodBeat.o(218183);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfAudioStream failed", localThrowable);
      AppMethodBeat.o(218183);
    }
  }
  
  private void signalEndOfVideoStream()
  {
    AppMethodBeat.i(218181);
    Logger.d("EncoderWriter", "signalEndOfVideoStream: ");
    if ((this._inputSurface == null) || (this.enOfVideoInputStream))
    {
      AppMethodBeat.o(218181);
      return;
    }
    try
    {
      this.videoEncoder.signalEndOfInputStream();
      this.enOfVideoInputStream = true;
      AppMethodBeat.o(218181);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("EncoderWriter", "signalEndOfVideoStream failed", localThrowable);
      AppMethodBeat.o(218181);
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
    AppMethodBeat.i(218193);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(218193);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(218193);
    }
  }
  
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(218194);
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
        AppMethodBeat.o(218194);
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
    AppMethodBeat.i(218186);
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
      AppMethodBeat.o(218186);
      throw paramCMSampleBuffer;
    }
    finally
    {
      this.videoEncoderLock.unlock();
      AppMethodBeat.o(218186);
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
      AppMethodBeat.i(218163);
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      AppMethodBeat.o(218163);
      return localSurface;
    }
    finally {}
  }
  
  public void endWriteAudioSample()
  {
    AppMethodBeat.i(218182);
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
      AppMethodBeat.o(218182);
    }
  }
  
  /* Error */
  public void endWriteVideoSample(CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: ldc_w 631
    //   3: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 33
    //   8: ldc_w 633
    //   11: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   18: invokeinterface 622 1 0
    //   23: invokeinterface 474 1 0
    //   28: aload_0
    //   29: getfield 134	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +24 -> 58
    //   37: aload_0
    //   38: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   41: invokeinterface 622 1 0
    //   46: invokeinterface 488 1 0
    //   51: ldc_w 631
    //   54: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: aload_0
    //   59: getfield 111	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   62: ifnull +12 -> 74
    //   65: aload_0
    //   66: getfield 95	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq +24 -> 95
    //   74: aload_0
    //   75: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   78: invokeinterface 622 1 0
    //   83: invokeinterface 488 1 0
    //   88: ldc_w 631
    //   91: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_0
    //   96: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   99: invokeinterface 524 1 0
    //   104: aload_0
    //   105: iconst_1
    //   106: putfield 95	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   109: aload_0
    //   110: iconst_0
    //   111: aload_1
    //   112: invokespecial 626	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(ZLcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   115: aload_0
    //   116: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   119: invokeinterface 622 1 0
    //   124: invokeinterface 488 1 0
    //   129: ldc_w 631
    //   132: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_3
    //   137: ldc 33
    //   139: ldc_w 635
    //   142: aload_3
    //   143: invokestatic 178	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: goto -37 -> 109
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 109	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   154: invokeinterface 622 1 0
    //   159: invokeinterface 488 1 0
    //   164: ldc_w 631
    //   167: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(218165);
    int i = (int)this.videoEncoder.getEncodeSize().height;
    AppMethodBeat.o(218165);
    return i;
  }
  
  public int getOutWidth()
  {
    AppMethodBeat.i(218164);
    int i = (int)this.videoEncoder.getEncodeSize().width;
    AppMethodBeat.o(218164);
    return i;
  }
  
  public long getVideoPresentationTimeUs()
  {
    AppMethodBeat.i(218166);
    long l = this.videoEncoder.getEncodePresentationTimeUs();
    AppMethodBeat.o(218166);
    return l;
  }
  
  public void inputVideoSampleTexture(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218171);
    this.videoEncoder.inputVideoTexture(paramTextureInfo);
    AppMethodBeat.o(218171);
  }
  
  public boolean isVideoEncodeNeedVideoRenderOutputTexture()
  {
    AppMethodBeat.i(218170);
    boolean bool = this.videoEncoder.isNeedVideoOutputTexture();
    AppMethodBeat.o(218170);
    return bool;
  }
  
  public void setEncodeOption(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(218167);
    if ((paramExportConfig.getOutputWidth() <= 0) || (paramExportConfig.getOutputHeight() <= 0))
    {
      paramExportConfig = new IllegalArgumentException("width and height must > 0");
      AppMethodBeat.o(218167);
      throw paramExportConfig;
    }
    this.encodeOption = paramExportConfig.clone();
    this.muxer.setExportConfig(paramExportConfig);
    AppMethodBeat.o(218167);
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(218179);
    this.videoEncoder.setVideoSampleRenderContext(paramRenderContext);
    AppMethodBeat.o(218179);
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 698
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 104	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 474 1 0
    //   17: ldc 33
    //   19: ldc_w 700
    //   22: aload_0
    //   23: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 382	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 688	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   37: invokespecial 702	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 93	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   45: aload_0
    //   46: getfield 425	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   49: invokevirtual 703	android/media/MediaCodec:start	()V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 132	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   57: aload_0
    //   58: getfield 104	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 488 1 0
    //   66: ldc_w 698
    //   69: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 104	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   80: invokeinterface 488 1 0
    //   85: ldc_w 698
    //   88: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 705
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 102	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 474 1 0
    //   17: ldc 33
    //   19: ldc_w 707
    //   22: aload_0
    //   23: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 382	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 307	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 688	com/tencent/tav/decoder/EncoderWriter:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   37: invokespecial 709	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/core/ExportConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 91	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   45: aload_0
    //   46: invokevirtual 710	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   49: pop
    //   50: aload_0
    //   51: getfield 147	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;
    //   54: invokeinterface 712 1 0
    //   59: pop
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 130	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   65: aload_0
    //   66: getfield 102	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 488 1 0
    //   74: ldc_w 705
    //   77: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 102	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 488 1 0
    //   93: ldc_w 705
    //   96: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(218195);
    Logger.i("EncoderWriter", "AssetWriter stop ".concat(String.valueOf(this)));
    if (this.released)
    {
      AppMethodBeat.o(218195);
      return;
    }
    if ((!this.videoEncoderStarted) && (!this.audioEncoderStarted))
    {
      AppMethodBeat.o(218195);
      return;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainEncoder(true, null);
    release();
    AppMethodBeat.o(218195);
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
    AppMethodBeat.i(218184);
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
              AppMethodBeat.o(218184);
            }
          }
        }
        paramByteBuffer.position(0);
      }
      catch (Throwable paramByteBuffer)
      {
        paramByteBuffer = new ExportRuntimeException(-122, paramByteBuffer);
        AppMethodBeat.o(218184);
        throw paramByteBuffer;
      }
      finally
      {
        this.lock.readLock().unlock();
        Logger.e("EncoderWriter", "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
        AppMethodBeat.o(218184);
      }
      paramByteBuffer.limit(j);
      this.lock.readLock().unlock();
      Logger.e("EncoderWriter", "writeAudioSample finish cost " + (System.currentTimeMillis() - l2));
      AppMethodBeat.o(218184);
      return;
    }
  }
  
  public void writeVideoSample(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(218178);
    Logger.i("EncoderWriter", "writeVideoSample");
    long l = System.currentTimeMillis();
    try
    {
      this.lock.readLock().lock();
      Surface localSurface = this._inputSurface;
      if (localSurface == null) {
        return;
      }
      drainEncoder(false, paramCMSampleBuffer);
      if (!paramCMSampleBuffer.getState().isInvalid()) {
        this.muxer.writeSampleDataTime(true, paramCMSampleBuffer.getTime());
      }
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
      Logger.i("EncoderWriter", "writeVideoSample finish cost " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(218178);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */