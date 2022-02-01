package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecEncoder
{
  private static final String TAG = "MediaCodecEncoder";
  private static boolean mDumpEnable = false;
  private MediaCodec.BufferInfo mAACEncBufferInfo;
  private MediaCodec mAudioAACEncoder;
  private MediaFormat mAudioFormat;
  private int mBitrate;
  private int mChannels;
  private Context mContext;
  private ByteBuffer mEncInBuffer;
  private ByteBuffer mEncOutBuffer;
  private boolean mFormatChangeFlag;
  private ByteBuffer mInputBuffer;
  private ByteBuffer[] mMediaInputBuffers;
  private ByteBuffer[] mMediaOutputBuffers;
  private ByteBuffer mOutputBuffer;
  private File mRecFileDump;
  private FileOutputStream mRecFileOut;
  private int mSampleRate;
  private byte[] mTempBufEncIn;
  private byte[] mTempBufEncOut;
  private int nMaxBitRate;
  
  public MediaCodecEncoder()
  {
    AppMethodBeat.i(13694);
    this.mAudioAACEncoder = null;
    this.mAudioFormat = null;
    this.mAACEncBufferInfo = null;
    this.mInputBuffer = null;
    this.mOutputBuffer = null;
    this.mSampleRate = 48000;
    this.mChannels = 1;
    this.mBitrate = 32000;
    this.nMaxBitRate = 256000;
    this.mFormatChangeFlag = false;
    this.mRecFileDump = null;
    this.mRecFileOut = null;
    this.mContext = TXCCommonUtil.getAppContext();
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
    AppMethodBeat.o(13694);
  }
  
  public MediaCodecEncoder(Context paramContext)
  {
    AppMethodBeat.i(182239);
    this.mAudioAACEncoder = null;
    this.mAudioFormat = null;
    this.mAACEncBufferInfo = null;
    this.mInputBuffer = null;
    this.mOutputBuffer = null;
    this.mSampleRate = 48000;
    this.mChannels = 1;
    this.mBitrate = 32000;
    this.nMaxBitRate = 256000;
    this.mFormatChangeFlag = false;
    this.mRecFileDump = null;
    this.mRecFileOut = null;
    this.mContext = paramContext;
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
    AppMethodBeat.o(182239);
  }
  
  private void addADTStoPacket(byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    if (this.mSampleRate == 48000) {
      i = 3;
    }
    for (;;)
    {
      int j = this.mChannels;
      paramArrayOfByte[0] = -1;
      paramArrayOfByte[1] = -7;
      paramArrayOfByte[2] = ((byte)((i << 2) + 64 + (j >> 2)));
      paramArrayOfByte[3] = ((byte)(((j & 0x3) << 6) + (paramInt >> 11)));
      paramArrayOfByte[4] = ((byte)((paramInt & 0x7FF) >> 3));
      paramArrayOfByte[5] = ((byte)(((paramInt & 0x7) << 5) + 31));
      paramArrayOfByte[6] = -4;
      return;
      if (this.mSampleRate == 44100) {
        i = 4;
      } else if (this.mSampleRate == 32000) {
        i = 5;
      } else if (this.mSampleRate == 24000) {
        i = 6;
      } else if (this.mSampleRate == 16000) {
        i = 8;
      } else {
        i = 3;
      }
    }
  }
  
  private String getDumpFilePath(String paramString)
  {
    AppMethodBeat.i(13695);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(13695);
      return null;
    }
    File localFile = this.mContext.getExternalFilesDir(null);
    if (localFile == null)
    {
      AppMethodBeat.o(13695);
      return null;
    }
    paramString = localFile.getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-" + paramString;
    localFile = new File(paramString);
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:".concat(String.valueOf(paramString)));
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    paramString = paramString.replace(" ", "_");
    AppMethodBeat.o(13695);
    return paramString;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  public int createAACEncoder(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 13696
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 209
    //   9: invokestatic 215	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   12: putfield 55	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   15: aload_0
    //   16: ldc 209
    //   18: iload_1
    //   19: iload_2
    //   20: invokestatic 221	android/media/MediaFormat:createAudioFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   23: putfield 57	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   26: aload_0
    //   27: getfield 57	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   30: ldc 223
    //   32: iconst_2
    //   33: invokevirtual 227	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   36: aload_0
    //   37: getfield 57	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   40: ldc 229
    //   42: iload_1
    //   43: invokevirtual 227	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   46: aload_0
    //   47: getfield 57	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   50: ldc 231
    //   52: iload_2
    //   53: invokevirtual 227	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   56: aload_0
    //   57: getfield 57	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   60: ldc 233
    //   62: iload_3
    //   63: invokevirtual 227	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   66: aload_0
    //   67: getfield 55	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   70: aload_0
    //   71: getfield 57	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   74: aconst_null
    //   75: aconst_null
    //   76: iconst_1
    //   77: invokevirtual 237	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   80: aload_0
    //   81: getfield 55	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   84: ifnull +36 -> 120
    //   87: aload_0
    //   88: getfield 55	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   91: invokevirtual 240	android/media/MediaCodec:start	()V
    //   94: aload_0
    //   95: new 242	android/media/MediaCodec$BufferInfo
    //   98: dup
    //   99: invokespecial 243	android/media/MediaCodec$BufferInfo:<init>	()V
    //   102: putfield 59	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAACEncBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   105: aload_0
    //   106: iload_1
    //   107: putfield 66	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mSampleRate	I
    //   110: aload_0
    //   111: iload_2
    //   112: putfield 68	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mChannels	I
    //   115: aload_0
    //   116: iload_3
    //   117: putfield 70	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mBitrate	I
    //   120: getstatic 43	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mDumpEnable	Z
    //   123: ifeq +35 -> 158
    //   126: aload_0
    //   127: new 157	java/io/File
    //   130: dup
    //   131: aload_0
    //   132: ldc 245
    //   134: invokespecial 247	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:getDumpFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokespecial 167	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: putfield 77	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mRecFileDump	Ljava/io/File;
    //   143: aload_0
    //   144: new 249	java/io/FileOutputStream
    //   147: dup
    //   148: aload_0
    //   149: getfield 77	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mRecFileDump	Ljava/io/File;
    //   152: invokespecial 252	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: putfield 79	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mRecFileOut	Ljava/io/FileOutputStream;
    //   158: invokestatic 117	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   161: ifeq +51 -> 212
    //   164: ldc 8
    //   166: iconst_2
    //   167: new 121	java/lang/StringBuilder
    //   170: dup
    //   171: ldc 254
    //   173: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: iload_1
    //   177: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc_w 259
    //   183: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload_2
    //   187: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: ldc_w 259
    //   193: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_3
    //   197: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc_w 261
    //   203: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 143	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: sipush 13696
    //   215: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore 4
    //   222: invokestatic 117	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   225: ifeq +52 -> 277
    //   228: ldc 8
    //   230: iconst_2
    //   231: new 121	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 263
    //   238: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: iload_1
    //   242: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: ldc_w 259
    //   248: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload_2
    //   252: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 259
    //   258: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload_3
    //   262: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: ldc_w 261
    //   268: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 266	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: sipush 13696
    //   280: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_m1
    //   284: ireturn
    //   285: astore 4
    //   287: goto -129 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	MediaCodecEncoder
    //   0	290	1	paramInt1	int
    //   0	290	2	paramInt2	int
    //   0	290	3	paramInt3	int
    //   220	1	4	localException	Exception
    //   285	1	4	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   6	120	220	java/lang/Exception
    //   120	143	220	java/lang/Exception
    //   143	158	220	java/lang/Exception
    //   158	212	220	java/lang/Exception
    //   143	158	285	java/io/FileNotFoundException
  }
  
  @SuppressLint({"NewApi"})
  public int encodeAACFrame(int paramInt)
  {
    AppMethodBeat.i(13697);
    if (this.mFormatChangeFlag)
    {
      this.mFormatChangeFlag = false;
      this.mAudioAACEncoder.stop();
      this.mAudioFormat.setInteger("bitrate", this.mBitrate);
      this.mAudioAACEncoder.configure(this.mAudioFormat, null, null, 1);
      this.mAudioAACEncoder.start();
    }
    this.mEncInBuffer.get(this.mTempBufEncIn, 0, paramInt);
    i = encodeInternalAACFrame(paramInt);
    this.mEncOutBuffer.rewind();
    if (i > 0)
    {
      this.mEncOutBuffer.put(this.mTempBufEncOut, 0, i);
      paramInt = i;
      if (mDumpEnable)
      {
        paramInt = i;
        if (this.mRecFileOut == null) {}
      }
    }
    for (paramInt = i + 7;; paramInt = 0)
    {
      try
      {
        byte[] arrayOfByte = new byte[paramInt];
        addADTStoPacket(arrayOfByte, paramInt);
        System.arraycopy(this.mTempBufEncOut, 0, arrayOfByte, 7, i);
        this.mRecFileOut.write(arrayOfByte, 0, paramInt);
        paramInt = i;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramInt = i;
        }
      }
      AppMethodBeat.o(13697);
      return paramInt;
    }
  }
  
  @SuppressLint({"NewApi"})
  public int encodeInternalAACFrame(int paramInt)
  {
    AppMethodBeat.i(13698);
    int i;
    try
    {
      i = this.mAudioAACEncoder.dequeueInputBuffer(2000L);
      if (i != -1) {
        if (Build.VERSION.SDK_INT < 21) {
          break label109;
        }
      }
      for (this.mInputBuffer = this.mAudioAACEncoder.getInputBuffer(i);; this.mInputBuffer = this.mMediaInputBuffers[i])
      {
        this.mInputBuffer.clear();
        this.mInputBuffer.put(this.mTempBufEncIn, 0, paramInt);
        this.mAudioAACEncoder.queueInputBuffer(i, 0, paramInt, 0L, 0);
        this.mEncInBuffer.rewind();
        i = this.mAudioAACEncoder.dequeueOutputBuffer(this.mAACEncBufferInfo, 0L);
        if (i >= 0) {
          break;
        }
        AppMethodBeat.o(13698);
        return 0;
        label109:
        this.mMediaInputBuffers = this.mAudioAACEncoder.getInputBuffers();
      }
      AppMethodBeat.o(13698);
    }
    catch (Exception localException1)
    {
      i = 0;
    }
    for (;;)
    {
      return i;
      int j = this.mAACEncBufferInfo.size;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mOutputBuffer = this.mAudioAACEncoder.getOutputBuffer(i);
        paramInt = this.mAACEncBufferInfo.flags;
        if ((paramInt & 0x2) != 2) {
          break label286;
        }
      }
      for (paramInt = 0;; paramInt = this.mAACEncBufferInfo.size)
      {
        try
        {
          this.mOutputBuffer.position(this.mAACEncBufferInfo.offset);
          this.mOutputBuffer.limit(j + this.mAACEncBufferInfo.offset);
          this.mOutputBuffer.get(this.mTempBufEncOut, 0, paramInt);
          this.mOutputBuffer.position(0);
          this.mAudioAACEncoder.releaseOutputBuffer(i, false);
          AppMethodBeat.o(13698);
          return paramInt;
        }
        catch (Exception localException2)
        {
          label286:
          i = paramInt;
        }
        this.mMediaOutputBuffers = this.mAudioAACEncoder.getOutputBuffers();
        this.mOutputBuffer = this.mMediaOutputBuffers[i];
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("MediaCodecEncoder", 2, "[ERROR] encoding aac stream failed!!!");
        i = paramInt;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public int releaseAACEncoder()
  {
    AppMethodBeat.i(13699);
    try
    {
      if (this.mAudioAACEncoder != null)
      {
        this.mAudioAACEncoder.stop();
        this.mAudioAACEncoder.release();
        this.mAudioAACEncoder = null;
        if (QLog.isColorLevel()) {
          QLog.w("MediaCodecEncoder", 2, "releaseAACEncoder, release aac encode stream succeed!!");
        }
        AppMethodBeat.o(13699);
        return 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "[ERROR] releaseAACEncoder, release aac encode stream failed!!!");
      }
      AppMethodBeat.o(13699);
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public int setAACEncodeBitrate(int paramInt)
  {
    AppMethodBeat.i(13700);
    if ((this.mAudioAACEncoder != null) && (this.mBitrate != paramInt))
    {
      this.mFormatChangeFlag = true;
      this.mBitrate = paramInt;
      if (QLog.isColorLevel()) {
        QLog.w("MediaCodecEncoder", 2, "Set AAC bitrate = ".concat(String.valueOf(paramInt)));
      }
    }
    AppMethodBeat.o(13700);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.MediaCodecEncoder
 * JD-Core Version:    0.7.0.1
 */