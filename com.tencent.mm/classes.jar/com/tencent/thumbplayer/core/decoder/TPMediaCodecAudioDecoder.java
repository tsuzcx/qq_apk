package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.b;
import com.tencent.tmediacodec.b.c;
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
  
  public TPMediaCodecAudioDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  void configCodec(b paramb)
  {
    AppMethodBeat.i(227492);
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
    paramb.a(localMediaFormat, null, this.mMediaCrypto);
    AppMethodBeat.o(227492);
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
    AppMethodBeat.i(227469);
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "initDecoder, mimeType:" + paramString + " sampleRate:" + paramInt1 + " channelCount:" + paramInt2 + " drmType:" + paramInt3 + " audioFormat:" + paramInt4);
    this.mMimeType = paramString;
    this.mSampleRate = paramInt1;
    this.mChannelCount = paramInt2;
    this.mDrmType = paramInt3;
    this.mAudioFormat = paramInt4;
    AppMethodBeat.o(227469);
    return true;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4, int paramInt5, int paramInt6)
  {
    return false;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(227522);
    paramTPFrameInfo.sampleRate = this.mSampleRate;
    paramTPFrameInfo.channelCount = this.mChannelCount;
    paramTPFrameInfo.format = this.mAudioFormat;
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramb.ahSX != null)
      {
        localObject = paramb.ahSX.kcs();
        if (localObject == null) {}
      }
      for (localObject = ((MediaCodec)localObject).getOutputBuffer(paramInt);; localObject = null)
      {
        if (localObject != null)
        {
          arrayOfByte = new byte[paramBufferInfo.size];
          ((ByteBuffer)localObject).get(arrayOfByte, paramBufferInfo.offset, paramBufferInfo.size);
        }
        paramTPFrameInfo.data = arrayOfByte;
        if ((paramBufferInfo.flags == 4) && (paramBufferInfo.size <= 0))
        {
          TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
          paramTPFrameInfo.errCode = 2;
        }
        paramb.releaseOutputBuffer(paramInt, false);
        AppMethodBeat.o(227522);
        return;
      }
    }
    if (paramb.ahSX != null)
    {
      localObject = paramb.ahSX.kcs();
      if (localObject == null) {}
    }
    for (Object localObject = ((MediaCodec)localObject).getOutputBuffers();; localObject = null)
    {
      localObject = localObject[paramInt];
      break;
    }
  }
  
  void processOutputConfigData(b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    AppMethodBeat.i(227500);
    paramb.releaseOutputBuffer(paramInt, false);
    paramTPFrameInfo.errCode = 1;
    AppMethodBeat.o(227500);
  }
  
  /* Error */
  void processOutputFormatChanged(MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: ldc 202
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 204
    //   8: invokevirtual 208	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   11: ifeq +13 -> 24
    //   14: aload_0
    //   15: aload_1
    //   16: ldc 204
    //   18: invokevirtual 212	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   21: putfield 28	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mSampleRate	I
    //   24: aload_1
    //   25: ldc 214
    //   27: invokevirtual 208	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   30: ifeq +13 -> 43
    //   33: aload_0
    //   34: aload_1
    //   35: ldc 214
    //   37: invokevirtual 212	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   40: putfield 30	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mChannelCount	I
    //   43: getstatic 148	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 24
    //   48: if_icmplt +146 -> 194
    //   51: aload_1
    //   52: ldc 216
    //   54: invokevirtual 208	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   57: ifeq +137 -> 194
    //   60: aload_1
    //   61: ldc 216
    //   63: invokevirtual 212	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   66: istore_2
    //   67: iconst_2
    //   68: ldc 8
    //   70: ldc 218
    //   72: iload_2
    //   73: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   76: invokevirtual 228	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 57	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   82: iconst_2
    //   83: ldc 8
    //   85: new 100	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 230
    //   91: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 40	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mEnableAudioPassThrough	Z
    //   98: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: ldc 235
    //   103: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 28	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mSampleRate	I
    //   110: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 237
    //   115: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 30	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mChannelCount	I
    //   122: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 239
    //   127: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: getfield 32	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:mAudioFormat	I
    //   134: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc 241
    //   139: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_2
    //   143: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 57	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   152: ldc 202
    //   154: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_1
    //   159: iconst_2
    //   160: istore_2
    //   161: iconst_4
    //   162: ldc 8
    //   164: new 100	java/lang/StringBuilder
    //   167: dup
    //   168: ldc 243
    //   170: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: aload_1
    //   175: invokevirtual 247	com/tencent/thumbplayer/core/decoder/TPMediaCodecAudioDecoder:getStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   178: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 57	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
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
  
  public int setOperateRate(float paramFloat)
  {
    AppMethodBeat.i(227571);
    int i = super.setOperateRate(paramFloat);
    AppMethodBeat.o(227571);
    return i;
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(227546);
    if (paramInt == 2)
    {
      this.mIsAdts = paramBoolean;
      AppMethodBeat.o(227546);
      return true;
    }
    if (paramInt == 3)
    {
      this.mEnableAudioPassThrough = paramBoolean;
      TPNativeLog.printLog(2, getLogTag(), "setParamBool mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
      AppMethodBeat.o(227546);
      return true;
    }
    paramBoolean = super.setParamBool(paramInt, paramBoolean);
    AppMethodBeat.o(227546);
    return paramBoolean;
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227556);
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    }
    boolean bool = super.setParamBytes(paramInt, paramArrayOfByte);
    AppMethodBeat.o(227556);
    return bool;
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(227564);
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      AppMethodBeat.o(227564);
      return true;
    }
    boolean bool = super.setParamObject(paramInt, paramObject);
    AppMethodBeat.o(227564);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */