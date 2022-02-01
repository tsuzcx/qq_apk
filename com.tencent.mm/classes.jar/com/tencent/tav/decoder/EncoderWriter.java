package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.Utils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
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
  private static final String TAG = "AssetWriter";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private Surface _inputSurface;
  private volatile MediaCodec.BufferInfo audioBufferInfo;
  private volatile MediaFormat audioEncodeFormat;
  private MediaCodec audioEncoder;
  private Lock audioEncoderLock;
  private boolean audioEncoderStarted;
  private long audioPresentationTimeUs;
  private int baselineLevel;
  private boolean enOfAudioInputStream;
  private boolean enOfVideoInputStream;
  private boolean hasAudioTrack;
  private boolean hasVideoTrack;
  private ReadWriteLock lock;
  private MediaMuxer muxer;
  private volatile boolean muxerStarted;
  private int outHeight;
  private int outWidth;
  private volatile int outputAudioTrack;
  private OutputConfig outputConfig;
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
    AppMethodBeat.i(201747);
    this.hasVideoTrack = false;
    this.hasAudioTrack = false;
    this.enOfVideoInputStream = false;
    this.enOfAudioInputStream = false;
    this.videoEncoderLock = new ReentrantLock();
    this.audioEncoderLock = new ReentrantLock();
    this.outputConfig = new OutputConfig();
    this.lock = new ReentrantReadWriteLock();
    this._inputSurface = null;
    this.baselineLevel = 0;
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
    this.muxer = new MediaMuxer(paramString, 0);
    AppMethodBeat.o(201747);
  }
  
  private void configureQualityEncoder(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(201753);
    paramMediaFormat.setInteger("frame-rate", 30);
    paramMediaFormat.setInteger("i-frame-interval", 1);
    selectProfileAndLevel(paramMediaFormat);
    try
    {
      paramMediaCodec.configure(paramMediaFormat, null, null, 1);
      AppMethodBeat.o(201753);
      return;
    }
    catch (Exception paramMediaCodec)
    {
      Logger.e("AssetWriter", "configureQualityEncoder: ", paramMediaCodec);
      if (this.baselineLevel != -1)
      {
        paramMediaFormat.setInteger("profile", 1);
        paramMediaFormat.setInteger("level", this.baselineLevel);
      }
      for (;;)
      {
        try
        {
          MediaCodec.createEncoderByType("video/avc").configure(paramMediaFormat, null, null, 1);
          AppMethodBeat.o(201753);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          Logger.e("AssetWriter", "configureQualityEncoder: ", paramMediaCodec);
          AppMethodBeat.o(201753);
        }
        paramMediaFormat.setInteger("profile", 0);
        paramMediaFormat.setInteger("level", 0);
      }
    }
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(201766);
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      AppMethodBeat.o(201766);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("AssetWriter", "dequeueInputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(201766);
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
    AppMethodBeat.i(201765);
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(201765);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("AssetWriter", "dequeueOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(201765);
      throw localException;
    }
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(201763);
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    boolean bool1;
    label51:
    boolean bool3;
    label61:
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
        break label316;
      }
      bool1 = true;
      if (this.hasAudioTrack) {
        break label322;
      }
      bool3 = true;
      l = System.currentTimeMillis();
      bool4 = bool1;
      bool1 = bool3;
      label74:
      if (((bool4) || (!this.hasVideoTrack)) && ((bool1) || (!this.hasAudioTrack))) {
        break label353;
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
          break label375;
        }
        if (paramBoolean) {
          break label328;
        }
        bool3 = true;
        label146:
        this.hasVideoTrack = bool3;
        Logger.e("AssetWriter", "drainEncoder: 视频写入处理时间超时，提前结束写入");
        bool3 = true;
      }
    }
    label207:
    label353:
    label360:
    label375:
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
              break label334;
            }
            bool1 = true;
            this.hasAudioTrack = bool1;
            Logger.e("AssetWriter", "drainEncoder: 音频写入处理时间超时，提前结束写入");
            bool1 = true;
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (!unStarted()) {
              break label360;
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
              AppMethodBeat.o(201763);
            }
          }
          signalEndOfVideoStream();
          i = j;
          break;
          bool1 = false;
          break label51;
          bool3 = false;
          break label61;
          bool3 = false;
          break label146;
          bool1 = false;
          break label207;
          AppMethodBeat.o(201763);
          return;
          bool4 = bool3;
          i = j;
          break label74;
        }
      }
    }
  }
  
  private ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(201767);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(201767);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("AssetWriter", "getInputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(201767);
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
    AppMethodBeat.i(201768);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(201768);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("AssetWriter", "getOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(201768);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private void prepareAudioEncoder(OutputConfig paramOutputConfig)
  {
    AppMethodBeat.i(201752);
    Logger.d("AssetWriter", "AssetWriter prepareAudioEncoder ".concat(String.valueOf(this)));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(paramOutputConfig.AUDIO_MIME_TYPE, paramOutputConfig.AUDIO_SAMPLE_RATE_HZ, paramOutputConfig.AUDIO_CHANNEL_COUNT);
    localMediaFormat.setInteger("bitrate", paramOutputConfig.AUDIO_BIT_RATE);
    localMediaFormat.setInteger("aac-profile", paramOutputConfig.AUDIO_AAC_PROFILE);
    localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0 }));
    this.audioEncoder = MediaCodec.createEncoderByType(paramOutputConfig.AUDIO_MIME_TYPE);
    this.audioEncoder.configure(localMediaFormat, null, null, 1);
    AppMethodBeat.o(201752);
  }
  
  private void prepareVideoEncoder(OutputConfig paramOutputConfig)
  {
    AppMethodBeat.i(201751);
    Logger.d("AssetWriter", "AssetWriter prepareVideoEncoder " + this + "  " + paramOutputConfig.VIDEO_TARGET_WIDTH + " x " + paramOutputConfig.VIDEO_TARGET_HEIGHT);
    int i;
    int j;
    if (paramOutputConfig.VIDEO_BIT_RATE <= 0)
    {
      i = 8000000;
      if (paramOutputConfig.VIDEO_FRAME_RATE > 0) {
        break label236;
      }
      j = 30;
      label74:
      if (paramOutputConfig.VIDEO_IFRAME_INTERVAL > 0) {
        break label244;
      }
    }
    Object localObject;
    label236:
    label244:
    for (int k = 1;; k = paramOutputConfig.VIDEO_IFRAME_INTERVAL)
    {
      localObject = CodecHelper.correctSupportSize(new CGSize(paramOutputConfig.VIDEO_TARGET_WIDTH, paramOutputConfig.VIDEO_TARGET_HEIGHT), "video/avc");
      this.outHeight = ((int)((CGSize)localObject).height);
      this.outWidth = ((int)((CGSize)localObject).width);
      localObject = MediaFormat.createVideoFormat("video/avc", (int)((CGSize)localObject).width, (int)((CGSize)localObject).height);
      ((MediaFormat)localObject).setInteger("color-format", 2130708361);
      ((MediaFormat)localObject).setInteger("bitrate", i);
      ((MediaFormat)localObject).setInteger("frame-rate", j);
      ((MediaFormat)localObject).setInteger("i-frame-interval", k);
      this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
      if ((!paramOutputConfig.VIDEO_QUALITY) || ("OPPO_OPPO_R9s".equals(Utils.getPhoneName()))) {
        break label253;
      }
      configureQualityEncoder(this.videoEncoder, (MediaFormat)localObject);
      AppMethodBeat.o(201751);
      return;
      i = paramOutputConfig.VIDEO_BIT_RATE;
      break;
      j = paramOutputConfig.VIDEO_FRAME_RATE;
      break label74;
    }
    label253:
    this.videoEncoder.configure((MediaFormat)localObject, null, null, 1);
    AppMethodBeat.o(201751);
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(201770);
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(201770);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AssetWriter", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      AppMethodBeat.o(201770);
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
    //   0: ldc_w 445
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 138	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   11: new 209	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 447
    //   18: invokespecial 213	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_0
    //   27: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   30: invokeinterface 453 1 0
    //   35: invokeinterface 457 1 0
    //   40: ldc 33
    //   42: ldc_w 459
    //   45: aload_0
    //   46: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: invokevirtual 322	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic 325	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 418	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +22 -> 83
    //   64: aload_0
    //   65: getfield 418	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   68: invokevirtual 462	android/media/MediaCodec:stop	()V
    //   71: aload_0
    //   72: getfield 418	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   75: invokevirtual 464	android/media/MediaCodec:release	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 418	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   83: aload_0
    //   84: getfield 363	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +22 -> 111
    //   92: aload_0
    //   93: getfield 363	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   96: invokevirtual 462	android/media/MediaCodec:stop	()V
    //   99: aload_0
    //   100: getfield 363	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   103: invokevirtual 464	android/media/MediaCodec:release	()V
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 363	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   111: aload_0
    //   112: getfield 145	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   115: ifnull +34 -> 149
    //   118: aload_0
    //   119: getfield 132	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   122: ifeq +15 -> 137
    //   125: aload_0
    //   126: iconst_0
    //   127: putfield 132	com/tencent/tav/decoder/EncoderWriter:muxerStarted	Z
    //   130: aload_0
    //   131: getfield 145	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   134: invokevirtual 465	android/media/MediaMuxer:stop	()V
    //   137: aload_0
    //   138: getfield 145	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   141: invokevirtual 466	android/media/MediaMuxer:release	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 145	com/tencent/tav/decoder/EncoderWriter:muxer	Landroid/media/MediaMuxer;
    //   149: aload_0
    //   150: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   153: invokeinterface 453 1 0
    //   158: invokeinterface 469 1 0
    //   163: ldc_w 445
    //   166: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    //   170: astore_1
    //   171: ldc 33
    //   173: aload_1
    //   174: invokestatic 472	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -106 -> 71
    //   180: astore_1
    //   181: aload_0
    //   182: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   185: invokeinterface 453 1 0
    //   190: invokeinterface 469 1 0
    //   195: ldc_w 445
    //   198: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_1
    //   202: athrow
    //   203: astore_1
    //   204: ldc 33
    //   206: aload_1
    //   207: invokestatic 472	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: goto -132 -> 78
    //   213: astore_1
    //   214: ldc 33
    //   216: aload_1
    //   217: invokestatic 472	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -121 -> 99
    //   223: astore_1
    //   224: ldc 33
    //   226: aload_1
    //   227: invokestatic 472	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: goto -124 -> 106
    //   233: astore_1
    //   234: ldc 33
    //   236: aload_1
    //   237: invokestatic 472	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   240: goto -103 -> 137
    //   243: astore_1
    //   244: ldc 33
    //   246: aload_1
    //   247: invokestatic 472	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: goto -106 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	EncoderWriter
    //   59	30	1	localMediaCodec	MediaCodec
    //   170	4	1	localException1	Exception
    //   180	22	1	localObject	Object
    //   203	4	1	localException2	Exception
    //   213	4	1	localException3	Exception
    //   223	4	1	localException4	Exception
    //   233	4	1	localException5	Exception
    //   243	4	1	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   64	71	170	java/lang/Exception
    //   26	60	180	finally
    //   64	71	180	finally
    //   71	78	180	finally
    //   78	83	180	finally
    //   83	88	180	finally
    //   92	99	180	finally
    //   99	106	180	finally
    //   106	111	180	finally
    //   111	130	180	finally
    //   130	137	180	finally
    //   137	144	180	finally
    //   144	149	180	finally
    //   171	177	180	finally
    //   204	210	180	finally
    //   214	220	180	finally
    //   224	230	180	finally
    //   234	240	180	finally
    //   244	250	180	finally
    //   71	78	203	java/lang/Exception
    //   92	99	213	java/lang/Exception
    //   99	106	223	java/lang/Exception
    //   130	137	233	java/lang/Exception
    //   137	144	243	java/lang/Exception
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201769);
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(201769);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AssetWriter", "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AssetWriter", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          releaseOutputBuffer(paramMediaCodec, paramInt, paramBoolean);
        }
      }
      AppMethodBeat.o(201769);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(201755);
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(201755);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(201755);
    return null;
  }
  
  private void selectProfileAndLevel(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(201754);
    Object localObject = selectCodec("video/avc");
    int k;
    int j;
    int i;
    int n;
    int m;
    if (localObject != null)
    {
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType("video/avc");
      if (((MediaCodecInfo.CodecCapabilities)localObject).profileLevels != null)
      {
        k = 0;
        j = -1;
        i = -1;
        n = j;
        m = i;
        if (k >= ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length) {
          break label204;
        }
        if (localObject.profileLevels[k].profile > 8) {
          break label265;
        }
        if (localObject.profileLevels[k].profile > i)
        {
          i = localObject.profileLevels[k].profile;
          j = localObject.profileLevels[k].level;
        }
      }
    }
    label265:
    for (;;)
    {
      if (localObject.profileLevels[k].profile == 1) {
        this.baselineLevel = localObject.profileLevels[k].level;
      }
      k += 1;
      break;
      if ((localObject.profileLevels[k].profile == i) && (localObject.profileLevels[k].level > j))
      {
        j = localObject.profileLevels[k].level;
        continue;
        n = -1;
        m = -1;
        label204:
        if (m == 8)
        {
          paramMediaFormat.setInteger("profile", m);
          paramMediaFormat.setInteger("level", n);
          Logger.d("AssetWriter", String.format("selectProfileAndLevel: 0x%x, 0x%x", new Object[] { Integer.valueOf(m), Integer.valueOf(n) }));
        }
        AppMethodBeat.o(201754);
        return;
      }
    }
  }
  
  private void signalEndOfAudioStream()
  {
    AppMethodBeat.i(201760);
    try
    {
      boolean bool = this.enOfAudioInputStream;
      if (bool)
      {
        AppMethodBeat.o(201760);
        return;
      }
      Logger.e("AssetWriter", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        this.enOfAudioInputStream = true;
      }
      AppMethodBeat.o(201760);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AssetWriter", "signalEndOfAudioStream failed", localThrowable);
      AppMethodBeat.o(201760);
    }
  }
  
  private void signalEndOfVideoStream()
  {
    AppMethodBeat.i(201758);
    Logger.e("AssetWriter", "signalEndOfVideoStream: ");
    if ((this._inputSurface == null) || (this.enOfVideoInputStream))
    {
      AppMethodBeat.o(201758);
      return;
    }
    try
    {
      this.videoEncoder.signalEndOfInputStream();
      this.enOfVideoInputStream = true;
      AppMethodBeat.o(201758);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("AssetWriter", "signalEndOfVideoStream failed", localThrowable);
      AppMethodBeat.o(201758);
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
    AppMethodBeat.i(201771);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(201771);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(201771);
    }
  }
  
  private boolean writeAudioFrame(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(201772);
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        this.audioEncoderLock.lock();
        if ((!this.muxerStarted) && (this.audioEncodeFormat != null)) {
          break label377;
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
        AppMethodBeat.o(201772);
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
          Logger.d("AssetWriter", "writeAudioFrame:  " + this.audioBufferInfo.presentationTimeUs);
          this.audioPresentationTimeUs = this.audioBufferInfo.presentationTimeUs;
          releaseOutputBuffer(this.audioEncoder, i, false);
          bool1 = bool2;
          if ((this.audioBufferInfo.flags & 0x4) == 0) {
            continue;
          }
          Logger.e("AssetWriter", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
          this.audioPresentationTimeUs = -1L;
          this.hasAudioTrack = false;
          bool1 = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e("AssetWriter", localException);
          }
        }
        label377:
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
    AppMethodBeat.i(201764);
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        this.videoEncoderLock.lock();
        if ((!this.muxerStarted) && (this.videoEncodeFormat != null)) {
          break label307;
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
        bool1 = bool2;
      }
      finally
      {
        this.videoEncoderLock.unlock();
        AppMethodBeat.o(201764);
      }
      if (i >= 0)
      {
        ByteBuffer localByteBuffer = getOutputBuffer(this.videoEncoder, i);
        if ((this.videoBufferInfo.flags & 0x2) != 0) {
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
          Logger.e("AssetWriter", "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
          this.videoPresentationTimeUs = -1L;
          this.hasVideoTrack = false;
          bool1 = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e("AssetWriter", localException);
          }
        }
        label307:
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
      AppMethodBeat.i(201748);
      if ((this._inputSurface == null) && (this.hasVideoTrack)) {
        this._inputSurface = this.videoEncoder.createInputSurface();
      }
      Surface localSurface = this._inputSurface;
      AppMethodBeat.o(201748);
      return localSurface;
    }
    finally {}
  }
  
  public void endWriteAudioSample()
  {
    AppMethodBeat.i(201759);
    Logger.e("AssetWriter", "endWriteAudioSample:".concat(String.valueOf(this)));
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
      Logger.e("AssetWriter", "endWriteAudioSample: ");
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
          Logger.e("AssetWriter", "endWriteAudioSample failed", localThrowable);
        }
      }
      drainEncoder(false);
      return;
    }
    finally
    {
      this.lock.readLock().unlock();
      AppMethodBeat.o(201759);
    }
  }
  
  /* Error */
  public void endWriteVideoSample()
  {
    // Byte code:
    //   0: ldc_w 633
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 33
    //   8: ldc_w 635
    //   11: invokestatic 245	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   18: invokeinterface 625 1 0
    //   23: invokeinterface 457 1 0
    //   28: aload_0
    //   29: getfield 138	com/tencent/tav/decoder/EncoderWriter:released	Z
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +24 -> 58
    //   37: aload_0
    //   38: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   41: invokeinterface 625 1 0
    //   46: invokeinterface 469 1 0
    //   51: ldc_w 633
    //   54: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: aload_0
    //   59: getfield 113	com/tencent/tav/decoder/EncoderWriter:_inputSurface	Landroid/view/Surface;
    //   62: ifnull +12 -> 74
    //   65: aload_0
    //   66: getfield 94	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   69: istore_1
    //   70: iload_1
    //   71: ifeq +24 -> 95
    //   74: aload_0
    //   75: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   78: invokeinterface 625 1 0
    //   83: invokeinterface 469 1 0
    //   88: ldc_w 633
    //   91: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_0
    //   96: getfield 418	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   99: invokevirtual 551	android/media/MediaCodec:signalEndOfInputStream	()V
    //   102: aload_0
    //   103: iconst_1
    //   104: putfield 94	com/tencent/tav/decoder/EncoderWriter:enOfVideoInputStream	Z
    //   107: aload_0
    //   108: iconst_0
    //   109: invokespecial 629	com/tencent/tav/decoder/EncoderWriter:drainEncoder	(Z)V
    //   112: aload_0
    //   113: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   116: invokeinterface 625 1 0
    //   121: invokeinterface 469 1 0
    //   126: ldc_w 633
    //   129: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: astore_2
    //   134: ldc 33
    //   136: ldc_w 637
    //   139: aload_2
    //   140: invokestatic 181	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: goto -36 -> 107
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 111	com/tencent/tav/decoder/EncoderWriter:lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   151: invokeinterface 625 1 0
    //   156: invokeinterface 469 1 0
    //   161: ldc_w 633
    //   164: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public void outputAudioEncoderConfig(OutputConfig paramOutputConfig)
  {
    try
    {
      this.outputConfig.AUDIO_SAMPLE_RATE_HZ = paramOutputConfig.AUDIO_SAMPLE_RATE_HZ;
      this.outputConfig.AUDIO_MIME_TYPE = paramOutputConfig.AUDIO_MIME_TYPE;
      this.outputConfig.AUDIO_CHANNEL_COUNT = paramOutputConfig.AUDIO_CHANNEL_COUNT;
      this.outputConfig.AUDIO_BIT_RATE = paramOutputConfig.AUDIO_BIT_RATE;
      this.outputConfig.AUDIO_AAC_PROFILE = paramOutputConfig.AUDIO_AAC_PROFILE;
      return;
    }
    finally
    {
      paramOutputConfig = finally;
      throw paramOutputConfig;
    }
  }
  
  public void outputVideoEncoderConfig(OutputConfig paramOutputConfig)
  {
    try
    {
      this.outputConfig.VIDEO_TARGET_WIDTH = paramOutputConfig.VIDEO_TARGET_WIDTH;
      this.outputConfig.VIDEO_TARGET_HEIGHT = paramOutputConfig.VIDEO_TARGET_HEIGHT;
      this.outputConfig.VIDEO_IFRAME_INTERVAL = paramOutputConfig.VIDEO_IFRAME_INTERVAL;
      this.outputConfig.VIDEO_BIT_RATE = paramOutputConfig.VIDEO_BIT_RATE;
      this.outputConfig.VIDEO_FRAME_RATE = paramOutputConfig.VIDEO_FRAME_RATE;
      this.outputConfig.VIDEO_QUALITY = paramOutputConfig.VIDEO_QUALITY;
      return;
    }
    finally
    {
      paramOutputConfig = finally;
      throw paramOutputConfig;
    }
  }
  
  /* Error */
  public void startAudioEncoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 645
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 103	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 457 1 0
    //   17: ldc 33
    //   19: ldc_w 647
    //   22: aload_0
    //   23: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 322	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 325	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 106	com/tencent/tav/decoder/EncoderWriter:outputConfig	Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;
    //   37: invokespecial 649	com/tencent/tav/decoder/EncoderWriter:prepareAudioEncoder	(Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 92	com/tencent/tav/decoder/EncoderWriter:hasAudioTrack	Z
    //   45: aload_0
    //   46: getfield 363	com/tencent/tav/decoder/EncoderWriter:audioEncoder	Landroid/media/MediaCodec;
    //   49: invokevirtual 650	android/media/MediaCodec:start	()V
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 136	com/tencent/tav/decoder/EncoderWriter:audioEncoderStarted	Z
    //   57: aload_0
    //   58: getfield 103	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 469 1 0
    //   66: ldc_w 645
    //   69: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 103	com/tencent/tav/decoder/EncoderWriter:audioEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   80: invokeinterface 469 1 0
    //   85: ldc_w 645
    //   88: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 652
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 101	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 457 1 0
    //   17: ldc 33
    //   19: ldc_w 654
    //   22: aload_0
    //   23: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 322	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 325	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 106	com/tencent/tav/decoder/EncoderWriter:outputConfig	Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;
    //   36: getfield 375	com/tencent/tav/decoder/EncoderWriter$OutputConfig:VIDEO_TARGET_WIDTH	I
    //   39: ifle +61 -> 100
    //   42: aload_0
    //   43: getfield 106	com/tencent/tav/decoder/EncoderWriter:outputConfig	Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;
    //   46: getfield 380	com/tencent/tav/decoder/EncoderWriter$OutputConfig:VIDEO_TARGET_HEIGHT	I
    //   49: ifle +51 -> 100
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 106	com/tencent/tav/decoder/EncoderWriter:outputConfig	Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;
    //   57: invokespecial 656	com/tencent/tav/decoder/EncoderWriter:prepareVideoEncoder	(Lcom/tencent/tav/decoder/EncoderWriter$OutputConfig;)V
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 90	com/tencent/tav/decoder/EncoderWriter:hasVideoTrack	Z
    //   65: aload_0
    //   66: invokevirtual 657	com/tencent/tav/decoder/EncoderWriter:createInputSurface	()Landroid/view/Surface;
    //   69: pop
    //   70: aload_0
    //   71: getfield 418	com/tencent/tav/decoder/EncoderWriter:videoEncoder	Landroid/media/MediaCodec;
    //   74: invokevirtual 650	android/media/MediaCodec:start	()V
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 134	com/tencent/tav/decoder/EncoderWriter:videoEncoderStarted	Z
    //   82: aload_0
    //   83: getfield 101	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   86: invokeinterface 469 1 0
    //   91: ldc_w 652
    //   94: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: new 659	java/lang/IllegalArgumentException
    //   103: dup
    //   104: ldc_w 661
    //   107: invokespecial 662	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   110: astore_1
    //   111: ldc_w 652
    //   114: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: aload_0
    //   121: getfield 101	com/tencent/tav/decoder/EncoderWriter:videoEncoderLock	Ljava/util/concurrent/locks/Lock;
    //   124: invokeinterface 469 1 0
    //   129: ldc_w 652
    //   132: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	EncoderWriter
    //   110	8	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   119	17	1	localObject1	Object
    //   137	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	82	119	finally
    //   100	119	119	finally
    //   2	8	137	finally
    //   82	97	137	finally
    //   120	137	137	finally
  }
  
  public void stop()
  {
    AppMethodBeat.i(201773);
    Logger.e("AssetWriter", "AssetWriter stop ".concat(String.valueOf(this)));
    if (this.released)
    {
      AppMethodBeat.o(201773);
      return;
    }
    if ((!this.videoEncoderStarted) && (!this.audioEncoderStarted))
    {
      AppMethodBeat.o(201773);
      return;
    }
    this.videoEncoderStarted = false;
    this.audioEncoderStarted = false;
    drainEncoder(true);
    release();
    AppMethodBeat.o(201773);
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
    AppMethodBeat.i(201762);
    label327:
    for (;;)
    {
      int j;
      try
      {
        this.lock.readLock().lock();
        new StringBuilder("writeAudioSample: ").append(paramLong).append("  ").append(paramByteBuffer.limit());
        boolean bool;
        if (paramByteBuffer != null)
        {
          bool = this.released;
          if (!bool) {}
        }
        else
        {
          return;
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
                break label327;
              }
              ByteBuffer localByteBuffer = getInputBuffer(this.audioEncoder, m);
              int k = Math.min(j - i, localByteBuffer.capacity());
              paramByteBuffer.limit(i + k);
              paramByteBuffer.position(i);
              localByteBuffer.put(paramByteBuffer);
              queueInputBuffer(this.audioEncoder, m, 0, k, paramLong + l1, 0);
              i += k;
              long l2 = DecoderUtils.getAudioDuration(k, 1, 44100);
              l1 = l2 + l1;
              this.audioEncoderLock.unlock();
              drainEncoder(false);
              continue;
            }
            finally
            {
              this.audioEncoderLock.unlock();
              AppMethodBeat.o(201762);
            }
          }
        }
        paramByteBuffer.position(0);
      }
      finally
      {
        this.lock.readLock().unlock();
        AppMethodBeat.o(201762);
      }
      paramByteBuffer.limit(j);
      this.lock.readLock().unlock();
      AppMethodBeat.o(201762);
      return;
    }
  }
  
  public void writeVideoSample()
  {
    AppMethodBeat.i(201756);
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
      AppMethodBeat.o(201756);
    }
  }
  
  public void writeVideoSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(201761);
    if (this._inputSurface != null)
    {
      AppMethodBeat.o(201761);
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
        AppMethodBeat.o(201761);
      }
    }
    AppMethodBeat.o(201761);
  }
  
  public static final class OutputConfig
  {
    public int AUDIO_AAC_PROFILE = 2;
    public int AUDIO_BIT_RATE = 128000;
    public int AUDIO_CHANNEL_COUNT = 1;
    public String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public int AUDIO_SAMPLE_RATE_HZ = 44100;
    public int VIDEO_BIT_RATE = 8000000;
    public int VIDEO_FRAME_RATE = 30;
    public int VIDEO_IFRAME_INTERVAL = 1;
    public boolean VIDEO_QUALITY = false;
    public int VIDEO_TARGET_HEIGHT = 0;
    public int VIDEO_TARGET_WIDTH = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.EncoderWriter
 * JD-Core Version:    0.7.0.1
 */