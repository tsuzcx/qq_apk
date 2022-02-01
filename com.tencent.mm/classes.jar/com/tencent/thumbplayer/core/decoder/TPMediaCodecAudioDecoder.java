package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.nio.ByteBuffer;

public class TPMediaCodecAudioDecoder
  extends TPBaseMediaCodecDecoder
{
  private static final String TAG = "TPMediaCodecAudioDecoder";
  private int mAudioFormat = 0;
  private int mChannelCount = 0;
  private byte[] mCsd0Data = null;
  private boolean mEnableAudioPassThrough = false;
  private boolean mIsAdts = false;
  private MediaCrypto mMediaCrypto = null;
  private String mMimeType = null;
  private int mSampleRate = 0;
  
  void configCodec(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(193750);
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: ");
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannelCount);
    if (this.mCsd0Data != null) {
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mCsd0Data));
    }
    if (this.mIsAdts)
    {
      TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: set is adts");
      localMediaFormat.setInteger("is-adts", 1);
    }
    paramMediaCodec.configure(localMediaFormat, null, this.mMediaCrypto, 0);
    AppMethodBeat.o(193750);
  }
  
  String getLogTag()
  {
    return "TPMediaCodecAudioDecoder";
  }
  
  String getMimeType()
  {
    return this.mMimeType;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193749);
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "initDecoder, mimeType:" + paramString + " sampleRate:" + paramInt1 + " channelCount:" + paramInt2 + " drmType:" + paramInt3 + " audioFormat:" + paramInt4);
    this.mMimeType = paramString;
    this.mSampleRate = paramInt1;
    this.mChannelCount = paramInt2;
    this.mDrmType = paramInt3;
    this.mAudioFormat = paramInt4;
    AppMethodBeat.o(193749);
    return true;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4)
  {
    return false;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    AppMethodBeat.i(193753);
    paramTPFrameInfo.sampleRate = this.mSampleRate;
    paramTPFrameInfo.channelCount = this.mChannelCount;
    paramTPFrameInfo.format = this.mAudioFormat;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (ByteBuffer localByteBuffer = paramMediaCodec.getOutputBuffer(paramInt);; localByteBuffer = paramMediaCodec.getOutputBuffers()[paramInt])
    {
      byte[] arrayOfByte = null;
      if (localByteBuffer != null)
      {
        arrayOfByte = new byte[paramBufferInfo.size];
        localByteBuffer.get(arrayOfByte, paramBufferInfo.offset, paramBufferInfo.size);
      }
      paramTPFrameInfo.data = arrayOfByte;
      if ((paramBufferInfo.flags == 4) && (paramBufferInfo.size <= 0))
      {
        TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
        paramTPFrameInfo.errCode = 2;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(193753);
      return;
    }
  }
  
  void processOutputConfigData(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    AppMethodBeat.i(193751);
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    paramTPFrameInfo.errCode = 1;
    AppMethodBeat.o(193751);
  }
  
  /* Error */
  void processOutputFormatChanged(MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 193
    //   8: invokevirtual 197	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   11: ifeq +13 -> 24
    //   14: aload_0
    //   15: aload_1
    //   16: ldc 193
    //   18: invokevirtual 201	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   21: putfield 28	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mSampleRate	I
    //   24: aload_1
    //   25: ldc 203
    //   27: invokevirtual 197	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   30: ifeq +13 -> 43
    //   33: aload_0
    //   34: aload_1
    //   35: ldc 203
    //   37: invokevirtual 201	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   40: putfield 30	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mChannelCount	I
    //   43: getstatic 149	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 24
    //   48: if_icmplt +146 -> 194
    //   51: aload_1
    //   52: ldc 205
    //   54: invokevirtual 197	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   57: ifeq +137 -> 194
    //   60: aload_1
    //   61: ldc 205
    //   63: invokevirtual 201	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   66: istore_2
    //   67: iconst_2
    //   68: ldc 8
    //   70: ldc 207
    //   72: iload_2
    //   73: invokestatic 213	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   76: invokevirtual 217	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 58	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   82: iconst_2
    //   83: ldc 8
    //   85: new 101	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 219
    //   91: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 40	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mEnableAudioPassThrough	Z
    //   98: invokevirtual 222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: ldc 224
    //   103: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 28	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mSampleRate	I
    //   110: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 226
    //   115: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 30	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mChannelCount	I
    //   122: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 228
    //   127: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: getfield 32	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mAudioFormat	I
    //   134: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc 230
    //   139: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_2
    //   143: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 58	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   152: ldc 191
    //   154: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_1
    //   159: iconst_2
    //   160: istore_2
    //   161: iconst_4
    //   162: ldc 8
    //   164: new 101	java/lang/StringBuilder
    //   167: dup
    //   168: ldc 232
    //   170: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: aload_1
    //   175: invokevirtual 236	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:getStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   178: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 58	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   187: goto -105 -> 82
    //   190: astore_1
    //   191: goto -30 -> 161
    //   194: iconst_2
    //   195: istore_2
    //   196: goto -114 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	TPMediaCodecAudioDecoder
    //   0	199	1	paramMediaFormat	MediaFormat
    //   66	130	2	i	int
    // Exception table:
    //   from	to	target	type
    //   5	24	158	java/lang/Exception
    //   24	43	158	java/lang/Exception
    //   43	67	158	java/lang/Exception
    //   67	82	190	java/lang/Exception
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(193754);
    if (paramInt == 2)
    {
      this.mIsAdts = paramBoolean;
      AppMethodBeat.o(193754);
      return true;
    }
    if (paramInt == 3)
    {
      this.mEnableAudioPassThrough = paramBoolean;
      TPNativeLog.printLog(2, getLogTag(), "setParamBool mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
      AppMethodBeat.o(193754);
      return true;
    }
    paramBoolean = super.setParamBool(paramInt, paramBoolean);
    AppMethodBeat.o(193754);
    return paramBoolean;
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193755);
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    }
    boolean bool = super.setParamBytes(paramInt, paramArrayOfByte);
    AppMethodBeat.o(193755);
    return bool;
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(193756);
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      AppMethodBeat.o(193756);
      return true;
    }
    boolean bool = super.setParamObject(paramInt, paramObject);
    AppMethodBeat.o(193756);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */