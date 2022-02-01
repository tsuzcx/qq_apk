package com.tencent.youtu.sdkkitframework.common;

import android.graphics.Bitmap;
import android.graphics.YuvImage;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class YtVideoEncoder
{
  private static final int AUDIO_CHANNEL_NUM = 1;
  private static final int BIT_RATE = 16000000;
  private static final int FRAME_RATE = 30;
  private static final int I_FRAME_INTERVAL = 1;
  private static final String MIME_TYPE = "video/avc";
  private static final String TAG;
  private static int mHeight;
  private static int mWidth;
  private int addedTrackCount;
  private boolean audioEncodeFinished;
  private ConcurrentLinkedQueue<byte[]> audioEncodeQueue;
  private Thread audioEncodeThread;
  private MediaCodec audioEncoder;
  private int audioGenerateIndex;
  private AudioRecord audioRecord;
  private int audioSampleRate;
  private int audioTrackIndex;
  private int colorFormat;
  private boolean isEncodingStarted;
  private boolean isMediaMuxerStarted;
  private boolean mAbort;
  private IYUVToVideoEncoderCallback mCallback;
  private final Object mFrameSync;
  private boolean mNeedWork;
  private CountDownLatch mNewFrameLatch;
  private boolean mNoMoreFrames;
  private File mOutputFile;
  private ConcurrentLinkedQueue<MediaData> mediaDataQueue;
  private MediaMuxer mediaMuxer;
  private final Object mediaMuxerSync;
  private int minAudioBufferSize;
  private boolean needAudio;
  private int realColorFormat;
  private MediaCodec videoEncoder;
  private int videoGenerateIndex;
  private int videoTrackIndex;
  private ConcurrentLinkedQueue<YuvImage> vidoeEncodeQueue;
  private byte[] yuvnv12;
  
  static
  {
    AppMethodBeat.i(218432);
    TAG = YtVideoEncoder.class.getSimpleName();
    AppMethodBeat.o(218432);
  }
  
  public YtVideoEncoder(IYUVToVideoEncoderCallback paramIYUVToVideoEncoderCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(218304);
    this.vidoeEncodeQueue = new ConcurrentLinkedQueue();
    this.audioEncodeQueue = new ConcurrentLinkedQueue();
    this.mediaDataQueue = new ConcurrentLinkedQueue();
    this.isMediaMuxerStarted = false;
    this.needAudio = false;
    this.audioRecord = null;
    this.mFrameSync = new Object();
    this.mediaMuxerSync = new Object();
    this.mNeedWork = false;
    this.videoGenerateIndex = 0;
    this.audioGenerateIndex = 0;
    this.addedTrackCount = 0;
    this.mNoMoreFrames = false;
    this.mAbort = false;
    this.isEncodingStarted = false;
    this.audioEncodeFinished = false;
    this.minAudioBufferSize = 0;
    this.colorFormat = 21;
    this.realColorFormat = 0;
    this.audioSampleRate = 8000;
    this.mCallback = paramIYUVToVideoEncoderCallback;
    this.mNeedWork = paramBoolean;
    AppMethodBeat.o(218304);
  }
  
  private byte[] I420ToNV21(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    AppMethodBeat.i(218410);
    if (this.yuvnv12 == null) {
      this.yuvnv12 = new byte[paramInt1 * paramInt2 * 3 / 2];
    }
    paramYuvImage = paramYuvImage.getYuvData();
    paramInt1 *= paramInt2;
    if (paramInt1 >= 0) {
      System.arraycopy(paramYuvImage, 0, this.yuvnv12, 0, paramInt1);
    }
    int j = paramInt1 + paramInt1 / 4;
    int i = paramInt1;
    paramInt2 = paramInt1;
    while (i < paramInt1 * 3 / 2)
    {
      this.yuvnv12[j] = paramYuvImage[i];
      this.yuvnv12[paramInt2] = paramYuvImage[(i + 1)];
      j += 1;
      paramInt2 += 1;
      i += 2;
    }
    paramYuvImage = this.yuvnv12;
    AppMethodBeat.o(218410);
    return paramYuvImage;
  }
  
  private byte[] NV12ToNV21(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    AppMethodBeat.i(218404);
    if (this.yuvnv12 == null) {
      this.yuvnv12 = new byte[paramInt1 * paramInt2 * 3 / 2];
    }
    paramYuvImage = paramYuvImage.getYuvData();
    paramInt2 = paramInt1 * paramInt2;
    if (paramInt2 >= 0) {
      System.arraycopy(paramYuvImage, 0, this.yuvnv12, 0, paramInt2);
    }
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 * 3 / 2)
    {
      if ((paramInt1 + 1) % 2 == 0)
      {
        this.yuvnv12[paramInt1] = paramYuvImage[(paramInt1 - 1)];
        this.yuvnv12[(paramInt1 - 1)] = paramYuvImage[paramInt1];
      }
      paramInt1 += 1;
    }
    paramYuvImage = this.yuvnv12;
    AppMethodBeat.o(218404);
    return paramYuvImage;
  }
  
  private long computePresentationTime(long paramLong, int paramInt)
  {
    return 132L + 1000000L * paramLong / paramInt;
  }
  
  private byte[] convertYUV(int paramInt1, int paramInt2, YuvImage paramYuvImage)
  {
    AppMethodBeat.i(218397);
    if (this.colorFormat == 21)
    {
      paramYuvImage = NV12ToNV21(paramInt1, paramInt2, paramYuvImage);
      AppMethodBeat.o(218397);
      return paramYuvImage;
    }
    paramYuvImage = I420ToNV21(paramInt1, paramInt2, paramYuvImage);
    AppMethodBeat.o(218397);
    return paramYuvImage;
  }
  
  private void encodeYUV420SP(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = paramInt1 * paramInt2;
    int i = 0;
    int j = 0;
    int n = 0;
    int i1;
    label25:
    int m;
    int i2;
    int i4;
    int i3;
    if (n < paramInt2)
    {
      i1 = 0;
      if (i1 < paramInt1)
      {
        m = (paramArrayOfInt[j] & 0xFF0000) >> 16;
        i2 = (paramArrayOfInt[j] & 0xFF00) >> 8;
        int i5 = paramArrayOfInt[j] & 0xFF;
        i4 = (m * 66 + i2 * 129 + i5 * 25 + 128 >> 8) + 16;
        i3 = (m * -38 - i2 * 74 + i5 * 112 + 128 >> 8) + 128;
        i2 = (m * 112 - i2 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i4 < 0)
        {
          m = 0;
          label163:
          paramArrayOfByte[i] = ((byte)m);
          if ((n % 2 != 0) || (j % 2 != 0)) {
            break label323;
          }
          i4 = k + 1;
          if (i3 >= 0) {
            break label267;
          }
          m = 0;
          label198:
          paramArrayOfByte[k] = ((byte)m);
          if (i2 >= 0) {
            break label290;
          }
          k = 0;
          label213:
          paramArrayOfByte[i4] = ((byte)k);
          k = i4 + 1;
        }
      }
    }
    label267:
    label290:
    label323:
    for (;;)
    {
      i1 += 1;
      j += 1;
      i += 1;
      break label25;
      m = i4;
      if (i4 <= 255) {
        break label163;
      }
      m = 255;
      break label163;
      if (i3 > 255)
      {
        m = 255;
        break label198;
      }
      m = i3;
      break label198;
      if (i2 > 255)
      {
        k = 255;
        break label213;
      }
      k = i2;
      break label213;
      n += 1;
      break;
      return;
    }
  }
  
  private ByteBuffer getInputBuffer(YtVideoEncoder.MediaType paramMediaType, int paramInt)
  {
    AppMethodBeat.i(218351);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaType == YtVideoEncoder.MediaType.VideoType)
      {
        paramMediaType = this.videoEncoder.getInputBuffer(paramInt);
        AppMethodBeat.o(218351);
        return paramMediaType;
      }
      paramMediaType = this.audioEncoder.getInputBuffer(paramInt);
      AppMethodBeat.o(218351);
      return paramMediaType;
    }
    if (paramMediaType == YtVideoEncoder.MediaType.VideoType)
    {
      paramMediaType = this.videoEncoder.getInputBuffers()[paramInt];
      AppMethodBeat.o(218351);
      return paramMediaType;
    }
    paramMediaType = this.audioEncoder.getInputBuffers()[paramInt];
    AppMethodBeat.o(218351);
    return paramMediaType;
  }
  
  private byte[] getNV21(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(218417);
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt1 * paramInt2 * 3 / 2];
    encodeYUV420SP(arrayOfByte, arrayOfInt, paramInt1, paramInt2);
    paramBitmap.recycle();
    AppMethodBeat.o(218417);
    return arrayOfByte;
  }
  
  private ByteBuffer getOutputBuffer(YtVideoEncoder.MediaType paramMediaType, int paramInt)
  {
    AppMethodBeat.i(218359);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaType == YtVideoEncoder.MediaType.VideoType)
      {
        paramMediaType = this.videoEncoder.getOutputBuffer(paramInt);
        AppMethodBeat.o(218359);
        return paramMediaType;
      }
      paramMediaType = this.audioEncoder.getOutputBuffer(paramInt);
      AppMethodBeat.o(218359);
      return paramMediaType;
    }
    if (paramMediaType == YtVideoEncoder.MediaType.VideoType)
    {
      paramMediaType = this.videoEncoder.getOutputBuffers()[paramInt];
      AppMethodBeat.o(218359);
      return paramMediaType;
    }
    paramMediaType = this.audioEncoder.getOutputBuffers()[paramInt];
    AppMethodBeat.o(218359);
    return paramMediaType;
  }
  
  private static boolean isRecognizedFormat(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void onAudioStart()
  {
    AppMethodBeat.i(218339);
    this.audioEncoder.start();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    long l4 = 0L;
    long l2 = 0L;
    this.audioEncodeFinished = false;
    long l1 = l4;
    label35:
    int i;
    ByteBuffer localByteBuffer;
    label159:
    long l3;
    for (;;)
    {
      if (!this.audioEncodeFinished)
      {
        byte[] arrayOfByte = (byte[])this.audioEncodeQueue.poll();
        if (arrayOfByte == null)
        {
          try
          {
            Thread.sleep(1L);
          }
          catch (InterruptedException localInterruptedException)
          {
            YtLogger.e(TAG, localInterruptedException.getLocalizedMessage());
          }
        }
        else
        {
          i = this.audioEncoder.dequeueInputBuffer(10000L);
          if (i < 0) {
            break label463;
          }
          localByteBuffer = getInputBuffer(YtVideoEncoder.MediaType.AudioType, i);
          localByteBuffer.clear();
          localByteBuffer.limit(localInterruptedException.length);
          localByteBuffer.put(localInterruptedException);
          l1 = localInterruptedException.length + l1;
          if (this.isEncodingStarted)
          {
            this.audioEncoder.queueInputBuffer(i, 0, localInterruptedException.length, l2, 0);
            l3 = 1000000L * (l1 / 1L) / this.audioSampleRate / 2L;
            this.audioGenerateIndex += 1;
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        i = this.audioEncoder.dequeueOutputBuffer(localBufferInfo, 10000L);
        if (i == -2)
        {
          ??? = this.audioEncoder.getOutputFormat();
          startMediaMuxer(YtVideoEncoder.MediaType.AudioType, (MediaFormat)???);
          l2 = l3;
          break label35;
          YtLogger.d(TAG, "End of audio stream");
          this.audioEncodeFinished = true;
          this.audioEncoder.queueInputBuffer(i, 0, ???.length, l2, 4);
          break label159;
        }
        l4 = l1;
        l2 = l3;
        if (i == -1) {
          break;
        }
        l4 = l1;
        l2 = l3;
        if (i < 0) {
          break;
        }
        l4 = l1;
        l2 = l3;
        if (localBufferInfo.size == 0) {
          break;
        }
        localByteBuffer = getOutputBuffer(YtVideoEncoder.MediaType.AudioType, i);
        l4 = l1;
        l2 = l3;
        if (localByteBuffer == null) {
          break;
        }
        localByteBuffer.position(localBufferInfo.offset);
        localByteBuffer.limit(localBufferInfo.offset + localBufferInfo.size);
        YtLogger.d(TAG, "media muxer write audio data outputindex " + this.audioGenerateIndex + " buff size:" + localBufferInfo.size);
        synchronized (this.mediaMuxer)
        {
          this.mediaMuxer.writeSampleData(this.audioTrackIndex, localByteBuffer, localBufferInfo);
          this.audioEncoder.releaseOutputBuffer(i, false);
          l2 = l3;
        }
      }
      return;
      label463:
      l3 = l2;
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: ldc_w 375
    //   3: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 120	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxerSync	Ljava/lang/Object;
    //   10: astore_1
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 213	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   17: ifnull +38 -> 55
    //   20: aload_0
    //   21: getfield 213	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   24: invokevirtual 378	android/media/MediaCodec:reset	()V
    //   27: aload_0
    //   28: getfield 213	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   31: invokevirtual 381	android/media/MediaCodec:stop	()V
    //   34: aload_0
    //   35: getfield 213	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   38: invokevirtual 383	android/media/MediaCodec:release	()V
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 213	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:videoEncoder	Landroid/media/MediaCodec;
    //   46: getstatic 92	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   49: ldc_w 385
    //   52: invokestatic 325	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   55: aload_0
    //   56: getfield 220	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +38 -> 99
    //   64: aload_0
    //   65: getfield 387	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncodeThread	Ljava/lang/Thread;
    //   68: invokevirtual 390	java/lang/Thread:join	()V
    //   71: aload_0
    //   72: getfield 220	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   75: invokevirtual 381	android/media/MediaCodec:stop	()V
    //   78: aload_0
    //   79: getfield 220	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   82: invokevirtual 383	android/media/MediaCodec:release	()V
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 220	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:audioEncoder	Landroid/media/MediaCodec;
    //   90: getstatic 92	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   93: ldc_w 392
    //   96: invokestatic 325	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   99: aload_0
    //   100: getfield 357	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +36 -> 141
    //   108: aload_0
    //   109: getfield 357	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   112: invokevirtual 393	android/media/MediaMuxer:stop	()V
    //   115: aload_0
    //   116: getfield 357	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   119: invokevirtual 394	android/media/MediaMuxer:release	()V
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 357	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:mediaMuxer	Landroid/media/MediaMuxer;
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield 112	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:isMediaMuxerStarted	Z
    //   132: getstatic 92	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   135: ldc_w 396
    //   138: invokestatic 325	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   141: aload_1
    //   142: monitorexit
    //   143: ldc_w 375
    //   146: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: return
    //   150: astore_2
    //   151: getstatic 92	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   154: aload_2
    //   155: invokevirtual 270	java/lang/InterruptedException:getLocalizedMessage	()Ljava/lang/String;
    //   158: invokestatic 276	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto -90 -> 71
    //   164: astore_2
    //   165: aload_1
    //   166: monitorexit
    //   167: ldc_w 375
    //   170: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_2
    //   174: athrow
    //   175: astore_2
    //   176: getstatic 92	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:TAG	Ljava/lang/String;
    //   179: new 338	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 398
    //   186: invokespecial 343	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_2
    //   190: invokevirtual 399	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   193: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 276	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: goto -87 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	YtVideoEncoder
    //   10	156	1	localObject1	Object
    //   59	46	2	localObject2	Object
    //   150	5	2	localInterruptedException	InterruptedException
    //   164	10	2	localObject3	Object
    //   175	15	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   64	71	150	java/lang/InterruptedException
    //   13	55	164	finally
    //   55	60	164	finally
    //   64	71	164	finally
    //   71	99	164	finally
    //   99	104	164	finally
    //   108	115	164	finally
    //   115	141	164	finally
    //   141	143	164	finally
    //   151	161	164	finally
    //   176	202	164	finally
    //   108	115	175	java/lang/Exception
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(218382);
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
            AppMethodBeat.o(218382);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(218382);
    return null;
  }
  
  private static int selectColorFormat(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(218390);
    paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    int i = 0;
    while (i < paramMediaCodecInfo.colorFormats.length)
    {
      int j = paramMediaCodecInfo.colorFormats[i];
      YtLogger.d(TAG, "found colorformat: ".concat(String.valueOf(j)));
      if (isRecognizedFormat(j))
      {
        AppMethodBeat.o(218390);
        return j;
      }
      i += 1;
    }
    AppMethodBeat.o(218390);
    return 0;
  }
  
  private void startAudioEncoding(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218313);
    if (!this.mNeedWork)
    {
      AppMethodBeat.o(218313);
      return;
    }
    this.needAudio = true;
    try
    {
      this.audioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt2, 1);
      localMediaFormat.setInteger("aac-profile", 2);
      localMediaFormat.setInteger("bitrate", paramInt1);
      localMediaFormat.setInteger("max-input-size", 16384);
      this.audioSampleRate = paramInt2;
      this.audioEncoder.configure(localMediaFormat, null, null, 1);
      this.isEncodingStarted = true;
      startAudioRecord();
      this.audioEncodeThread = new Thread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(218287);
          YtVideoEncoder.access$000(YtVideoEncoder.this);
          AppMethodBeat.o(218287);
        }
      });
      this.audioEncodeThread.start();
      AppMethodBeat.o(218313);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(218313);
    }
  }
  
  private void startAudioRecord()
  {
    AppMethodBeat.i(218322);
    new Thread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218296);
        YtVideoEncoder.access$102(YtVideoEncoder.this, AudioRecord.getMinBufferSize(YtVideoEncoder.this.audioSampleRate, 16, 2));
        int i = Math.min(16384, YtVideoEncoder.this.minAudioBufferSize * 2);
        YtVideoEncoder.access$302(YtVideoEncoder.this, new AudioRecord(1, YtVideoEncoder.this.audioSampleRate, 16, 2, i));
        YtLogger.i(YtVideoEncoder.TAG, "Audio recorder init :" + YtVideoEncoder.this.audioRecord.getState());
        byte[] arrayOfByte = new byte[2048];
        YtVideoEncoder.this.audioRecord.startRecording();
        while (!YtVideoEncoder.this.audioEncodeFinished) {
          if (YtVideoEncoder.this.audioRecord.read(arrayOfByte, 0, 2048) > 0) {
            YtVideoEncoder.this.encodeAudioData(arrayOfByte);
          }
        }
        YtLogger.d(YtVideoEncoder.TAG, "Audio push last buffer");
        YtVideoEncoder.this.audioRecord.stop();
        YtVideoEncoder.this.audioRecord.release();
        YtVideoEncoder.access$302(YtVideoEncoder.this, null);
        AppMethodBeat.o(218296);
      }
    }).start();
    AppMethodBeat.o(218322);
  }
  
  private void startMediaMuxer(YtVideoEncoder.MediaType paramMediaType, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218423);
    synchronized (this.mediaMuxerSync)
    {
      if (this.isMediaMuxerStarted)
      {
        AppMethodBeat.o(218423);
        return;
      }
      if (paramMediaType == YtVideoEncoder.MediaType.VideoType)
      {
        this.videoTrackIndex = this.mediaMuxer.addTrack(paramMediaFormat);
        this.addedTrackCount += 1;
      }
      if (paramMediaType == YtVideoEncoder.MediaType.AudioType)
      {
        this.audioTrackIndex = this.mediaMuxer.addTrack(paramMediaFormat);
        this.addedTrackCount += 1;
      }
      if (((this.needAudio) && (this.addedTrackCount >= 2)) || ((!this.needAudio) && (this.addedTrackCount > 0)))
      {
        YtLogger.d(TAG, "Media muxer is starting...");
        this.mediaMuxer.start();
        this.isMediaMuxerStarted = true;
        this.mediaMuxerSync.notifyAll();
      }
      for (;;)
      {
        AppMethodBeat.o(218423);
        return;
        boolean bool = this.needAudio;
        if (!bool) {
          continue;
        }
        try
        {
          this.mediaMuxerSync.wait();
        }
        catch (InterruptedException paramMediaType) {}
      }
    }
  }
  
  public void abortEncoding()
  {
    AppMethodBeat.i(218443);
    this.isEncodingStarted = false;
    if (this.mOutputFile != null)
    {
      YtLogger.d(TAG, "Clean up record file");
      this.mOutputFile.delete();
      this.mOutputFile = null;
    }
    if (!this.mNeedWork)
    {
      AppMethodBeat.o(218443);
      return;
    }
    if ((this.videoEncoder == null) || (this.mediaMuxer == null))
    {
      YtLogger.i(TAG, "Failed to abort encoding since it never started");
      AppMethodBeat.o(218443);
      return;
    }
    YtLogger.i(TAG, "Aborting encoding");
    this.mNoMoreFrames = true;
    this.mAbort = true;
    this.vidoeEncodeQueue = new ConcurrentLinkedQueue();
    this.audioEncodeQueue = new ConcurrentLinkedQueue();
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      release();
      AppMethodBeat.o(218443);
      return;
    }
  }
  
  public void encode()
  {
    AppMethodBeat.i(218447);
    if (!this.mNeedWork)
    {
      AppMethodBeat.o(218447);
      return;
    }
    if (!this.isEncodingStarted)
    {
      AppMethodBeat.o(218447);
      return;
    }
    YtLogger.d(TAG, "Encoder started");
    if ((this.mNoMoreFrames) && (this.vidoeEncodeQueue.size() == 0))
    {
      AppMethodBeat.o(218447);
      return;
    }
    YuvImage localYuvImage = (YuvImage)this.vidoeEncodeQueue.poll();
    ??? = localYuvImage;
    if (localYuvImage == null) {
      synchronized (this.mFrameSync)
      {
        this.mNewFrameLatch = new CountDownLatch(1);
      }
    }
    try
    {
      this.mNewFrameLatch.await();
      label119:
      ??? = (YuvImage)this.vidoeEncodeQueue.poll();
      if (??? == null)
      {
        AppMethodBeat.o(218447);
        return;
        localObject2 = finally;
        AppMethodBeat.o(218447);
        throw localObject2;
      }
      ??? = convertYUV(mWidth, mHeight, (YuvImage)???);
      int i = this.videoEncoder.dequeueInputBuffer(200000L);
      long l = computePresentationTime(this.videoGenerateIndex, 30);
      if (i >= 0)
      {
        localObject3 = getInputBuffer(YtVideoEncoder.MediaType.VideoType, i);
        ((ByteBuffer)localObject3).clear();
        ((ByteBuffer)localObject3).put((byte[])???);
        this.videoEncoder.queueInputBuffer(i, 0, ???.length, l, 0);
        this.videoGenerateIndex += 1;
      }
      Object localObject3 = new MediaCodec.BufferInfo();
      i = this.videoEncoder.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject3, 200000L);
      if (i == -1)
      {
        YtLogger.e(TAG, "No output from encoder available");
        AppMethodBeat.o(218447);
        return;
      }
      if (i == -2)
      {
        ??? = this.videoEncoder.getOutputFormat();
        startMediaMuxer(YtVideoEncoder.MediaType.VideoType, (MediaFormat)???);
        AppMethodBeat.o(218447);
        return;
      }
      if (i < 0)
      {
        YtLogger.e(TAG, "unexpected result from encoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
        AppMethodBeat.o(218447);
        return;
      }
      ByteBuffer localByteBuffer;
      if (((MediaCodec.BufferInfo)localObject3).size != 0)
      {
        localByteBuffer = getOutputBuffer(YtVideoEncoder.MediaType.VideoType, i);
        if (localByteBuffer == null)
        {
          YtLogger.e(TAG, "encoderOutputBuffer " + i + " was null");
          AppMethodBeat.o(218447);
          return;
        }
        localByteBuffer.position(((MediaCodec.BufferInfo)localObject3).offset);
        localByteBuffer.limit(((MediaCodec.BufferInfo)localObject3).offset + ((MediaCodec.BufferInfo)localObject3).size);
        YtLogger.d(TAG, "media muxer write video data outputindex " + this.videoGenerateIndex);
      }
      synchronized (this.mediaMuxer)
      {
        this.mediaMuxer.writeSampleData(this.videoTrackIndex, localByteBuffer, (MediaCodec.BufferInfo)localObject3);
        this.videoEncoder.releaseOutputBuffer(i, false);
        AppMethodBeat.o(218447);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label119;
    }
  }
  
  public void encodeAudioData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218437);
    this.audioEncodeQueue.add(paramArrayOfByte);
    AppMethodBeat.o(218437);
  }
  
  public int getColorFormat()
  {
    return this.realColorFormat;
  }
  
  public int getYUVImageSize()
  {
    AppMethodBeat.i(218436);
    int i = this.vidoeEncodeQueue.size();
    AppMethodBeat.o(218436);
    return i;
  }
  
  public boolean isEncodingStarted()
  {
    return this.isEncodingStarted;
  }
  
  public void queueFrame(YuvImage arg1)
  {
    AppMethodBeat.i(218445);
    if (!this.mNeedWork)
    {
      AppMethodBeat.o(218445);
      return;
    }
    if ((this.videoEncoder == null) || (this.mediaMuxer == null))
    {
      AppMethodBeat.o(218445);
      return;
    }
    YtLogger.d(TAG, "Queueing frame");
    this.vidoeEncodeQueue.add(???);
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      AppMethodBeat.o(218445);
      return;
    }
  }
  
  public void startAudioVideoEncoding(int paramInt1, int paramInt2, File paramFile, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(218438);
    try
    {
      paramFile.delete();
      String str = paramFile.getCanonicalPath();
      if (this.mediaMuxer == null) {
        this.mediaMuxer = new MediaMuxer(str, 0);
      }
      startAudioEncoding(paramInt7, paramInt6);
      startEncoding(paramInt1, paramInt2, paramFile, paramInt3, paramInt4, paramInt5);
      return;
    }
    catch (IOException localIOException)
    {
      try
      {
        Thread.sleep(300L);
        AppMethodBeat.o(218438);
        return;
      }
      catch (InterruptedException paramFile)
      {
        AppMethodBeat.o(218438);
      }
      localIOException = localIOException;
      YtLogger.e(TAG, "Unable to get path for ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(218438);
      return;
    }
  }
  
  public void startEncoding(int paramInt1, int paramInt2, File paramFile, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(218441);
    if (!this.mNeedWork)
    {
      AppMethodBeat.o(218441);
      return;
    }
    mWidth = paramInt1;
    mHeight = paramInt2;
    this.mOutputFile = paramFile;
    try
    {
      String str = paramFile.getCanonicalPath();
      if (this.mediaMuxer == null) {
        this.mediaMuxer = new MediaMuxer(str, 0);
      }
      paramFile = selectCodec("video/avc");
      if (paramFile == null)
      {
        YtLogger.e(TAG, "Unable to find an appropriate codec for video/avc");
        AppMethodBeat.o(218441);
        return;
      }
    }
    catch (IOException localIOException)
    {
      YtLogger.e(TAG, "Unable to get path for ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(218441);
      return;
    }
    YtLogger.i(TAG, "found codec: " + paramFile.getName());
    this.colorFormat = 21;
    try
    {
      paramInt1 = selectColorFormat(paramFile, "video/avc");
      this.colorFormat = paramInt1;
      this.realColorFormat = paramInt1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.videoEncoder = MediaCodec.createByCodecName(paramFile.getName());
          paramFile = MediaFormat.createVideoFormat("video/avc", mWidth, mHeight);
          paramFile.setInteger("bitrate", paramInt3);
          paramFile.setInteger("frame-rate", paramInt4);
          paramFile.setInteger("color-format", this.colorFormat);
          paramFile.setInteger("i-frame-interval", paramInt5);
          this.videoEncoder.configure(paramFile, null, null, 1);
          this.videoEncoder.start();
          YtLogger.i(TAG, "Initialization complete. Starting encoder...");
          this.isEncodingStarted = true;
          AppMethodBeat.o(218441);
          return;
        }
        catch (Exception paramFile)
        {
          YtLogger.e(TAG, "Unable to create MediaCodec " + paramFile.getMessage());
          AppMethodBeat.o(218441);
        }
        localException = localException;
        this.colorFormat = 21;
      }
    }
  }
  
  public void stopEncoding()
  {
    AppMethodBeat.i(218442);
    this.isEncodingStarted = false;
    if (!this.mNeedWork)
    {
      AppMethodBeat.o(218442);
      return;
    }
    if ((this.videoEncoder == null) || (this.mediaMuxer == null))
    {
      AppMethodBeat.o(218442);
      return;
    }
    YtLogger.i(TAG, "Stopping encoding");
    this.mNoMoreFrames = true;
    synchronized (this.mFrameSync)
    {
      if ((this.mNewFrameLatch != null) && (this.mNewFrameLatch.getCount() > 0L)) {
        this.mNewFrameLatch.countDown();
      }
      release();
      AppMethodBeat.o(218442);
      return;
    }
  }
  
  public static abstract interface IYUVToVideoEncoderCallback
  {
    public abstract void onEncodingComplete(File paramFile);
  }
  
  class MediaData
  {
    MediaCodec.BufferInfo bufferInfo;
    ByteBuffer byteBuffer;
    int index = 0;
    int trackIndex;
    
    public MediaData(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
    {
      this.index = paramInt1;
      this.trackIndex = paramInt2;
      this.byteBuffer = paramByteBuffer;
      this.bufferInfo = paramBufferInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtVideoEncoder
 * JD-Core Version:    0.7.0.1
 */