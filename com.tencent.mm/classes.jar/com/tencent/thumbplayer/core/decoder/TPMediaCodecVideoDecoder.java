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
  private MediaCrypto mMediaCrypto = null;
  private String mMimeType = null;
  private int mRotation = 0;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  
  void configCodec(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(220560);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mMimeType, this.mVideoWidth, this.mVideoHeight);
    if (Build.VERSION.SDK_INT > 22) {
      localMediaFormat.setInteger("rotation-degrees", this.mRotation);
    }
    if (TPSystemInfo.getDeviceName().equalsIgnoreCase("vivo X5L")) {
      localMediaFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
    }
    paramMediaCodec.configure(localMediaFormat, this.mSurface, this.mMediaCrypto, 0);
    paramMediaCodec.setVideoScalingMode(1);
    AppMethodBeat.o(220560);
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
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4)
  {
    this.mMimeType = paramString;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mRotation = paramInt3;
    this.mSurface = paramSurface;
    this.mDrmType = paramInt4;
    return true;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.width = this.mVideoWidth;
    paramTPFrameInfo.height = this.mVideoHeight;
    paramTPFrameInfo.cropLeft = this.mCropLeft;
    paramTPFrameInfo.cropRight = this.mCropRight;
    paramTPFrameInfo.cropTop = this.mCropTop;
    paramTPFrameInfo.cropBottom = this.mCropBottom;
  }
  
  void processOutputConfigData(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo, TPFrameInfo paramTPFrameInfo)
  {
    AppMethodBeat.i(220561);
    paramTPFrameInfo.errCode = 0;
    processOutputBuffer(paramMediaCodec, paramInt, paramBufferInfo, paramTPFrameInfo);
    AppMethodBeat.o(220561);
  }
  
  void processOutputFormatChanged(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(220562);
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
      AppMethodBeat.o(220562);
      return;
    }
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(220563);
    int i = super.setOutputSurface(paramSurface);
    AppMethodBeat.o(220563);
    return i;
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(220564);
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      AppMethodBeat.o(220564);
      return true;
    }
    boolean bool = super.setParamObject(paramInt, paramObject);
    AppMethodBeat.o(220564);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecVideoDecoder
 * JD-Core Version:    0.7.0.1
 */