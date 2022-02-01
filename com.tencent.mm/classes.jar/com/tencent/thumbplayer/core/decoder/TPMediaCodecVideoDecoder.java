package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.tmediacodec.b;
import com.tencent.tmediacodec.b.c;
import java.nio.ByteBuffer;

public class TPMediaCodecVideoDecoder
  extends TPBaseMediaCodecDecoder
{
  private static final String DEVICE_NAME_VIVO_X5L = "vivo X5L";
  private static final String KEY_CROP_BOTTOM = "crop-bottom";
  private static final String KEY_CROP_LEFT = "crop-left";
  private static final String KEY_CROP_RIGHT = "crop-right";
  private static final String KEY_CROP_TOP = "crop-top";
  private static final String TAG = "TPMediaCodecVideoDecode";
  private int mCropBottom = 0;
  private int mCropLeft = 0;
  private int mCropRight = 0;
  private int mCropTop = 0;
  private byte[] mCsd0Data = null;
  private byte[] mCsd1Data = null;
  private byte[] mCsd2Data = null;
  private MediaCrypto mMediaCrypto = null;
  private String mMimeType = null;
  private int mRotation = 0;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  
  public TPMediaCodecVideoDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  void configCodec(b paramb)
  {
    AppMethodBeat.i(189922);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mMimeType, this.mVideoWidth, this.mVideoHeight);
    if (Build.VERSION.SDK_INT > 22) {
      localMediaFormat.setInteger("rotation-degrees", this.mRotation);
    }
    if (TPSystemInfo.getDeviceName().equalsIgnoreCase("vivo X5L")) {
      localMediaFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
    }
    if (this.mCsd0Data != null) {
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mCsd0Data));
    }
    if (this.mCsd1Data != null) {
      localMediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(this.mCsd1Data));
    }
    if (this.mCsd2Data != null) {
      localMediaFormat.setByteBuffer("csd-2", ByteBuffer.wrap(this.mCsd2Data));
    }
    paramb.a(localMediaFormat, this.mSurface, this.mMediaCrypto);
    if (paramb.Sll != null)
    {
      paramb = paramb.Sll.hps();
      if (paramb != null) {
        paramb.setVideoScalingMode(1);
      }
    }
    AppMethodBeat.o(189922);
  }
  
  String getLogTag()
  {
    return "TPMediaCodecVideoDecode";
  }
  
  String getMimeType()
  {
    return this.mMimeType;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mMimeType = paramString;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mRotation = paramInt3;
    this.mSurface = paramSurface;
    this.mDrmType = paramInt4;
    this.mDolbyVisionProfile = paramInt5;
    this.mDolbyVisionLevel = paramInt6;
    return true;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.width = this.mVideoWidth;
    paramTPFrameInfo.height = this.mVideoHeight;
    paramTPFrameInfo.cropLeft = this.mCropLeft;
    paramTPFrameInfo.cropRight = this.mCropRight;
    paramTPFrameInfo.cropTop = this.mCropTop;
    paramTPFrameInfo.cropBottom = this.mCropBottom;
  }
  
  void processOutputConfigData(b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    AppMethodBeat.i(189923);
    paramTPFrameInfo.errCode = 0;
    processOutputBuffer(paramb, paramInt, paramBufferInfo, paramTPFrameInfo);
    AppMethodBeat.o(189923);
  }
  
  void processOutputFormatChanged(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(189924);
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {}
    for (int i = 1;; i = 0)
    {
      this.mVideoWidth = paramMediaFormat.getInteger("width");
      this.mVideoHeight = paramMediaFormat.getInteger("height");
      if (i != 0)
      {
        this.mCropLeft = paramMediaFormat.getInteger("crop-left");
        this.mCropRight = paramMediaFormat.getInteger("crop-right");
        this.mCropTop = paramMediaFormat.getInteger("crop-top");
        this.mCropBottom = paramMediaFormat.getInteger("crop-bottom");
      }
      TPNativeLog.printLog(2, "TPMediaCodecVideoDecode", "processOutputFormatChanged: mVideoWidth: " + this.mVideoWidth + ", mVideoHeight: " + this.mVideoHeight + ", mCropLeft: " + this.mCropLeft + ", mCropRight: " + this.mCropRight + ", mCropTop: " + this.mCropTop + ", mCropBottom: " + this.mCropBottom);
      AppMethodBeat.o(189924);
      return;
    }
  }
  
  public int setOperateRate(float paramFloat)
  {
    AppMethodBeat.i(189928);
    int i = super.setOperateRate(paramFloat);
    AppMethodBeat.o(189928);
    return i;
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(189925);
    int i = super.setOutputSurface(paramSurface);
    AppMethodBeat.o(189925);
    return i;
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189926);
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    }
    for (;;)
    {
      boolean bool = super.setParamBytes(paramInt, paramArrayOfByte);
      AppMethodBeat.o(189926);
      return bool;
      if (paramInt == 201) {
        this.mCsd1Data = paramArrayOfByte;
      } else if (paramInt == 202) {
        this.mCsd2Data = paramArrayOfByte;
      }
    }
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(189927);
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      AppMethodBeat.o(189927);
      return true;
    }
    boolean bool = super.setParamObject(paramInt, paramObject);
    AppMethodBeat.o(189927);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecVideoDecoder
 * JD-Core Version:    0.7.0.1
 */