package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.d.a.a.a;
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
    AppMethodBeat.i(146930);
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
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
    AppMethodBeat.o(146930);
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
    AppMethodBeat.i(146931);
    a.dUd();
    a.iP("TRAE", "manufacture:" + Build.MANUFACTURER);
    a.dUd();
    a.iP("TRAE", "MODEL:" + Build.MODEL);
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-" + paramString;
    a.dUd();
    a.iP("TRAE", "dump:".concat(String.valueOf(paramString)));
    a.dUd();
    a.iP("TRAE", "dump replace:" + paramString.replace(" ", "_"));
    paramString = paramString.replace(" ", "_");
    AppMethodBeat.o(146931);
    return paramString;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  public int createAACEncoder(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 189
    //   8: invokestatic 195	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   11: putfield 54	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   14: aload_0
    //   15: ldc 189
    //   17: iload_1
    //   18: iload_2
    //   19: invokestatic 201	android/media/MediaFormat:createAudioFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   22: putfield 56	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   25: aload_0
    //   26: getfield 56	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   29: ldc 203
    //   31: iconst_2
    //   32: invokevirtual 207	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   35: aload_0
    //   36: getfield 56	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   39: ldc 209
    //   41: iload_1
    //   42: invokevirtual 207	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   45: aload_0
    //   46: getfield 56	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   49: ldc 211
    //   51: iload_2
    //   52: invokevirtual 207	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   55: aload_0
    //   56: getfield 56	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   59: ldc 213
    //   61: iload_3
    //   62: invokevirtual 207	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 54	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   69: aload_0
    //   70: getfield 56	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioFormat	Landroid/media/MediaFormat;
    //   73: aconst_null
    //   74: aconst_null
    //   75: iconst_1
    //   76: invokevirtual 217	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   79: aload_0
    //   80: getfield 54	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   83: ifnull +36 -> 119
    //   86: aload_0
    //   87: getfield 54	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAudioAACEncoder	Landroid/media/MediaCodec;
    //   90: invokevirtual 220	android/media/MediaCodec:start	()V
    //   93: aload_0
    //   94: new 222	android/media/MediaCodec$BufferInfo
    //   97: dup
    //   98: invokespecial 223	android/media/MediaCodec$BufferInfo:<init>	()V
    //   101: putfield 58	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mAACEncBufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   104: aload_0
    //   105: iload_1
    //   106: putfield 65	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mSampleRate	I
    //   109: aload_0
    //   110: iload_2
    //   111: putfield 67	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mChannels	I
    //   114: aload_0
    //   115: iload_3
    //   116: putfield 69	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mBitrate	I
    //   119: getstatic 41	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mDumpEnable	Z
    //   122: ifeq +35 -> 157
    //   125: aload_0
    //   126: new 147	java/io/File
    //   129: dup
    //   130: aload_0
    //   131: ldc 225
    //   133: invokespecial 227	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:getDumpFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokespecial 228	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: putfield 76	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mRecFileDump	Ljava/io/File;
    //   142: aload_0
    //   143: new 230	java/io/FileOutputStream
    //   146: dup
    //   147: aload_0
    //   148: getfield 76	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mRecFileDump	Ljava/io/File;
    //   151: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: putfield 78	com/tencent/rtmp/sharp/jni/MediaCodecEncoder:mRecFileOut	Ljava/io/FileOutputStream;
    //   157: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   160: pop
    //   161: ldc 8
    //   163: new 111	java/lang/StringBuilder
    //   166: dup
    //   167: ldc 235
    //   169: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: iload_1
    //   173: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 240
    //   178: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_2
    //   182: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc 240
    //   187: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_3
    //   191: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 242
    //   196: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 133	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: ldc 187
    //   207: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: iconst_0
    //   211: ireturn
    //   212: astore 4
    //   214: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   217: pop
    //   218: ldc 8
    //   220: new 111	java/lang/StringBuilder
    //   223: dup
    //   224: ldc 244
    //   226: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   229: iload_1
    //   230: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc 240
    //   235: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload_2
    //   239: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 240
    //   244: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload_3
    //   248: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: ldc 242
    //   253: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 247	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: ldc 187
    //   264: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: iconst_m1
    //   268: ireturn
    //   269: astore 4
    //   271: goto -114 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	MediaCodecEncoder
    //   0	274	1	paramInt1	int
    //   0	274	2	paramInt2	int
    //   0	274	3	paramInt3	int
    //   212	1	4	localException	Exception
    //   269	1	4	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   5	119	212	java/lang/Exception
    //   119	142	212	java/lang/Exception
    //   142	157	212	java/lang/Exception
    //   157	205	212	java/lang/Exception
    //   142	157	269	java/io/FileNotFoundException
  }
  
  @SuppressLint({"NewApi"})
  public int encodeAACFrame(int paramInt)
  {
    AppMethodBeat.i(146933);
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
      AppMethodBeat.o(146933);
      return paramInt;
    }
  }
  
  @SuppressLint({"NewApi"})
  public int encodeInternalAACFrame(int paramInt)
  {
    AppMethodBeat.i(146934);
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
        AppMethodBeat.o(146934);
        return 0;
        label109:
        this.mMediaInputBuffers = this.mAudioAACEncoder.getInputBuffers();
      }
      AppMethodBeat.o(146934);
    }
    catch (Exception localException1)
    {
      paramInt = 0;
    }
    for (;;)
    {
      return paramInt;
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
          AppMethodBeat.o(146934);
          return paramInt;
        }
        catch (Exception localException2)
        {
          label286:
          a.dUd();
          a.iO("MediaCodecEncoder", "[ERROR] encoding aac stream failed!!!");
        }
        this.mMediaOutputBuffers = this.mAudioAACEncoder.getOutputBuffers();
        this.mOutputBuffer = this.mMediaOutputBuffers[i];
        break;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public int releaseAACEncoder()
  {
    AppMethodBeat.i(146935);
    try
    {
      if (this.mAudioAACEncoder != null)
      {
        this.mAudioAACEncoder.stop();
        this.mAudioAACEncoder.release();
        this.mAudioAACEncoder = null;
        a.dUd();
        a.iP("MediaCodecEncoder", "releaseAACEncoder, release aac encode stream succeed!!");
        AppMethodBeat.o(146935);
        return 0;
      }
    }
    catch (Exception localException)
    {
      a.dUd();
      a.iO("MediaCodecEncoder", "[ERROR] releaseAACEncoder, release aac encode stream failed!!!");
      AppMethodBeat.o(146935);
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public int setAACEncodeBitrate(int paramInt)
  {
    AppMethodBeat.i(146936);
    if ((this.mAudioAACEncoder != null) && (this.mBitrate != paramInt))
    {
      this.mFormatChangeFlag = true;
      this.mBitrate = paramInt;
      a.dUd();
      a.iP("MediaCodecEncoder", "Set AAC bitrate = ".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(146936);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.MediaCodecEncoder
 * JD-Core Version:    0.7.0.1
 */