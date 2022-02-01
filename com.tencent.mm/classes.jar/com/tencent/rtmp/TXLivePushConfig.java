package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.a.c;
import java.util.HashMap;

public class TXLivePushConfig
{
  public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
  public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
  int mAudioBitrate;
  int mAudioChannels = 1;
  String mAudioPreProcessFuncName;
  String mAudioPreProcessLibrary;
  int mAudioSample = 48000;
  boolean mAutoAdjustBitrate = false;
  int mAutoAdjustStrategy = 0;
  int mBeautyLevel = 0;
  int mConnectRetryCount = 3;
  int mConnectRetryInterval = 3;
  int mCustomModeType = 0;
  boolean mEnableAec = false;
  boolean mEnableAgc = false;
  boolean mEnableAns = false;
  boolean mEnableAudioPreview = false;
  boolean mEnableHighResolutionCapture = true;
  boolean mEnableNearestIP = true;
  boolean mEnablePureAudioPush = false;
  boolean mEnableScreenCaptureAutoRotate = false;
  boolean mEnableVideoHardEncoderMainProfile = true;
  boolean mEnableZoom = false;
  int mEyeScaleLevel = 0;
  int mFaceSlimLevel = 0;
  boolean mFrontCamera = true;
  int mHardwareAccel = 2;
  int mHomeOrientation = 1;
  int mLocalVideoMirrorType = 0;
  int mMaxVideoBitrate = 1500;
  HashMap<String, String> mMetaData;
  int mMinVideoBitrate = 800;
  int mPauseFlag = 1;
  int mPauseFps = 5;
  Bitmap mPauseImg = null;
  int mPauseTime = 300;
  int mRtmpChannelType = 0;
  int mRuddyLevel = 0;
  boolean mTouchFocus = true;
  int mVideoBitrate = 1200;
  int mVideoEncodeGop = 3;
  boolean mVideoEncoderXMirror = false;
  int mVideoFPS = 20;
  String mVideoPreProcessFuncName;
  String mVideoPreProcessLibrary;
  c mVideoResolution = c.c;
  int mVolumeType = 0;
  Bitmap mWatermark;
  float mWatermarkWidth = -1.0F;
  int mWatermarkX = 0;
  float mWatermarkXF = 0.0F;
  int mWatermarkY = 0;
  float mWatermarkYF = 0.0F;
  int mWhiteningLevel = 0;
  
  public void enableAEC(boolean paramBoolean)
  {
    this.mEnableAec = paramBoolean;
  }
  
  public void enableAGC(boolean paramBoolean)
  {
    this.mEnableAgc = paramBoolean;
  }
  
  public void enableANS(boolean paramBoolean)
  {
    this.mEnableAns = paramBoolean;
  }
  
  public void enableAudioEarMonitoring(boolean paramBoolean)
  {
    this.mEnableAudioPreview = paramBoolean;
  }
  
  public void enableHighResolutionCaptureMode(boolean paramBoolean)
  {
    this.mEnableHighResolutionCapture = paramBoolean;
  }
  
  @Deprecated
  public void enableNearestIP(boolean paramBoolean)
  {
    this.mEnableNearestIP = paramBoolean;
  }
  
  public void enablePureAudioPush(boolean paramBoolean)
  {
    this.mEnablePureAudioPush = paramBoolean;
  }
  
  public void enableScreenCaptureAutoRotate(boolean paramBoolean)
  {
    this.mEnableScreenCaptureAutoRotate = paramBoolean;
  }
  
  public void enableVideoHardEncoderMainProfile(boolean paramBoolean)
  {
    this.mEnableVideoHardEncoderMainProfile = paramBoolean;
  }
  
  public void setAudioChannels(int paramInt)
  {
    this.mAudioChannels = paramInt;
  }
  
  public void setAudioSampleRate(int paramInt)
  {
    this.mAudioSample = paramInt;
  }
  
  public void setAutoAdjustBitrate(boolean paramBoolean)
  {
    this.mAutoAdjustBitrate = paramBoolean;
  }
  
  public void setAutoAdjustStrategy(int paramInt)
  {
    this.mAutoAdjustStrategy = paramInt;
  }
  
  @Deprecated
  public void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mBeautyLevel = paramInt1;
    this.mWhiteningLevel = paramInt2;
    this.mRuddyLevel = paramInt3;
  }
  
  public void setConnectRetryCount(int paramInt)
  {
    this.mConnectRetryCount = paramInt;
  }
  
  public void setConnectRetryInterval(int paramInt)
  {
    this.mConnectRetryInterval = paramInt;
  }
  
  public void setCustomAudioPreProcessLibrary(String paramString1, String paramString2)
  {
    this.mAudioPreProcessLibrary = paramString1;
    this.mAudioPreProcessFuncName = paramString2;
  }
  
  public void setCustomModeType(int paramInt)
  {
    this.mCustomModeType = paramInt;
  }
  
  public void setCustomVideoPreProcessLibrary(String paramString1, String paramString2)
  {
    this.mVideoPreProcessLibrary = paramString1;
    this.mVideoPreProcessFuncName = paramString2;
  }
  
  public void setEnableZoom(boolean paramBoolean)
  {
    this.mEnableZoom = paramBoolean;
  }
  
  @Deprecated
  public void setEyeScaleLevel(int paramInt)
  {
    this.mEyeScaleLevel = paramInt;
  }
  
  @Deprecated
  public void setFaceSlimLevel(int paramInt)
  {
    this.mFaceSlimLevel = paramInt;
  }
  
  @Deprecated
  public void setFrontCamera(boolean paramBoolean)
  {
    this.mFrontCamera = paramBoolean;
  }
  
  public void setHardwareAcceleration(int paramInt)
  {
    int i = 2;
    if (paramInt < 0) {
      paramInt = 2;
    }
    for (;;)
    {
      if (paramInt > 2) {
        paramInt = i;
      }
      for (;;)
      {
        this.mHardwareAccel = paramInt;
        return;
      }
    }
  }
  
  public void setHomeOrientation(int paramInt)
  {
    this.mHomeOrientation = paramInt;
  }
  
  public void setLocalVideoMirrorType(int paramInt)
  {
    this.mLocalVideoMirrorType = paramInt;
  }
  
  public void setMaxVideoBitrate(int paramInt)
  {
    this.mMaxVideoBitrate = paramInt;
  }
  
  public void setMetaData(HashMap<String, String> paramHashMap)
  {
    this.mMetaData = paramHashMap;
  }
  
  public void setMinVideoBitrate(int paramInt)
  {
    this.mMinVideoBitrate = paramInt;
  }
  
  public void setPauseFlag(int paramInt)
  {
    this.mPauseFlag = paramInt;
  }
  
  public void setPauseImg(int paramInt1, int paramInt2)
  {
    this.mPauseTime = paramInt1;
    this.mPauseFps = paramInt2;
  }
  
  public void setPauseImg(Bitmap paramBitmap)
  {
    this.mPauseImg = paramBitmap;
  }
  
  @Deprecated
  public void setRtmpChannelType(int paramInt)
  {
    this.mRtmpChannelType = paramInt;
  }
  
  public void setTouchFocus(boolean paramBoolean)
  {
    this.mTouchFocus = paramBoolean;
  }
  
  public void setVideoBitrate(int paramInt)
  {
    this.mVideoBitrate = paramInt;
  }
  
  public void setVideoEncodeGop(int paramInt)
  {
    this.mVideoEncodeGop = paramInt;
  }
  
  public void setVideoEncoderXMirror(boolean paramBoolean)
  {
    this.mVideoEncoderXMirror = paramBoolean;
  }
  
  public void setVideoFPS(int paramInt)
  {
    this.mVideoFPS = paramInt;
  }
  
  public void setVideoResolution(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      return;
    case 0: 
      this.mVideoResolution = c.b;
      return;
    case 1: 
      this.mVideoResolution = c.c;
      return;
    case 2: 
      this.mVideoResolution = c.d;
      return;
    case 3: 
      this.mVideoResolution = c.e;
      return;
    case 4: 
      this.mVideoResolution = c.f;
      return;
    case 5: 
      this.mVideoResolution = c.g;
      return;
    case 6: 
      this.mVideoResolution = c.h;
      return;
    case 7: 
      this.mVideoResolution = c.i;
      return;
    case 8: 
      this.mVideoResolution = c.j;
      return;
    case 9: 
      this.mVideoResolution = c.k;
      return;
    case 10: 
      this.mVideoResolution = c.l;
      return;
    case 11: 
      this.mVideoResolution = c.m;
      return;
    case 12: 
      this.mVideoResolution = c.n;
      return;
    case 13: 
      this.mVideoResolution = c.o;
      return;
    case 14: 
      this.mVideoResolution = c.p;
      return;
    case 15: 
      this.mVideoResolution = c.q;
      return;
    case 16: 
      this.mVideoResolution = c.r;
      return;
    case 17: 
      this.mVideoResolution = c.s;
      return;
    case 18: 
      this.mVideoResolution = c.t;
      return;
    case 19: 
      this.mVideoResolution = c.u;
      return;
    case 30: 
      this.mVideoResolution = c.w;
      return;
    }
    this.mVideoResolution = c.x;
  }
  
  public void setVolumeType(int paramInt)
  {
    this.mVolumeType = paramInt;
  }
  
  public void setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mWatermark = paramBitmap;
    this.mWatermarkXF = paramFloat1;
    this.mWatermarkYF = paramFloat2;
    this.mWatermarkWidth = paramFloat3;
  }
  
  public void setWatermark(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mWatermark = paramBitmap;
    this.mWatermarkX = paramInt1;
    this.mWatermarkY = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePushConfig
 * JD-Core Version:    0.7.0.1
 */