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
import com.tencent.thumbplayer.core.postprocessor.DisplaySurface;
import com.tencent.thumbplayer.core.postprocessor.ProcessSurface;
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
  private DisplaySurface mDisplaySurface = null;
  private MediaCrypto mMediaCrypto = null;
  private String mMimeType = null;
  private ProcessSurface mProcessSurface = null;
  private int mRotation = 0;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  
  public TPMediaCodecVideoDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  void configCodec(b paramb)
  {
    AppMethodBeat.i(227505);
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
    if (paramb.ahSX != null)
    {
      paramb = paramb.ahSX.kcs();
      if (paramb != null) {
        paramb.setVideoScalingMode(1);
      }
    }
    AppMethodBeat.o(227505);
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
    AppMethodBeat.i(227484);
    this.mMimeType = paramString;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mRotation = paramInt3;
    if ((this.mEnableRendererSharpen > 0) && (!this.mEnableAsyncMode)) {}
    try
    {
      this.mDisplaySurface = new DisplaySurface(paramSurface);
      this.mDisplaySurface.makeCurrent();
      this.mProcessSurface = new ProcessSurface(this.mVideoWidth, this.mVideoHeight, this.mSharpenShaderPath);
      this.mSurface = this.mProcessSurface.getSurface();
      if ((this.mEnableRendererSharpen <= 0) || (this.mEnableAsyncMode) || (this.mSurface == null)) {
        this.mSurface = paramSurface;
      }
      this.mDrmType = paramInt4;
      this.mDolbyVisionProfile = paramInt5;
      this.mDolbyVisionLevel = paramInt6;
      AppMethodBeat.o(227484);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        this.mEnableRendererSharpen = 0;
        TPNativeLog.printLog(2, "TPMediaCodecVideoDecode", "sifeng create sharpen surface failed!");
      }
    }
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
    AppMethodBeat.i(227513);
    paramTPFrameInfo.errCode = 0;
    processOutputBuffer(paramb, paramInt, paramBufferInfo, paramTPFrameInfo);
    AppMethodBeat.o(227513);
  }
  
  void processOutputFormatChanged(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(227525);
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
      AppMethodBeat.o(227525);
      return;
    }
  }
  
  public int release()
  {
    AppMethodBeat.i(227565);
    int i = super.release();
    try
    {
      if (this.mDisplaySurface != null)
      {
        this.mDisplaySurface.makeCurrent();
        if (this.mProcessSurface != null) {
          this.mProcessSurface.release();
        }
        this.mDisplaySurface.release();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPNativeLog.printLog(2, "TPMediaCodecVideoDecode", "custom render release failed!");
      }
    }
    this.mProcessSurface = null;
    this.mDisplaySurface = null;
    AppMethodBeat.o(227565);
    return i;
  }
  
  public int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(227559);
    paramInt = super.releaseOutputBuffer(paramInt, paramBoolean);
    if ((paramInt == 0) && (paramBoolean == true) && (this.mEnableRendererSharpen > 0) && (this.mSurface == this.mProcessSurface.getSurface())) {}
    try
    {
      this.mDisplaySurface.makeCurrent();
      this.mDisplaySurface.querySurface();
      this.mProcessSurface.awaitNewImage();
      this.mProcessSurface.drawImage(this.mVideoWidth, this.mVideoHeight, this.mDisplaySurface.getmWidth(), this.mDisplaySurface.getmHeight(), this.mSwitchEnableRendererSharpen, this.mEnableRendererSharpen);
      this.mDisplaySurface.swapBuffers();
      AppMethodBeat.o(227559);
      return paramInt;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPNativeLog.printLog(2, "TPMediaCodecVideoDecode", "sifeng sharpen render pass failed!");
      }
    }
  }
  
  public int setOperateRate(float paramFloat)
  {
    AppMethodBeat.i(227587);
    int i = super.setOperateRate(paramFloat);
    AppMethodBeat.o(227587);
    return i;
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(227549);
    int i = super.setOutputSurface(paramSurface);
    AppMethodBeat.o(227549);
    return i;
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227574);
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    }
    for (;;)
    {
      boolean bool = super.setParamBytes(paramInt, paramArrayOfByte);
      AppMethodBeat.o(227574);
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
    AppMethodBeat.i(227578);
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      AppMethodBeat.o(227578);
      return true;
    }
    boolean bool = super.setParamObject(paramInt, paramObject);
    AppMethodBeat.o(227578);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecVideoDecoder
 * JD-Core Version:    0.7.0.1
 */