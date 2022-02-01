package com.tencent.rtmp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WXLivePushConfig
  extends TXLivePushConfig
{
  public int mVideoEncodeHeight = 640;
  public int mVideoEncodeWidth = 368;
  
  public WXLivePushConfig()
  {
    this.mTouchFocus = false;
  }
  
  public WXLivePushConfig clone()
  {
    AppMethodBeat.i(13939);
    WXLivePushConfig localWXLivePushConfig = new WXLivePushConfig();
    localWXLivePushConfig.mVideoEncodeWidth = this.mVideoEncodeWidth;
    localWXLivePushConfig.mVideoEncodeHeight = this.mVideoEncodeHeight;
    localWXLivePushConfig.mHomeOrientation = this.mHomeOrientation;
    localWXLivePushConfig.mFrontCamera = this.mFrontCamera;
    localWXLivePushConfig.mTouchFocus = this.mTouchFocus;
    localWXLivePushConfig.mEnableZoom = this.mEnableZoom;
    localWXLivePushConfig.mMinVideoBitrate = this.mMinVideoBitrate;
    localWXLivePushConfig.mMaxVideoBitrate = this.mMaxVideoBitrate;
    localWXLivePushConfig.mVideoBitrate = this.mVideoBitrate;
    localWXLivePushConfig.mVideoFPS = this.mVideoFPS;
    localWXLivePushConfig.mVideoResolution = this.mVideoResolution;
    localWXLivePushConfig.mVideoEncodeGop = this.mVideoEncodeGop;
    localWXLivePushConfig.mVideoEncoderXMirror = this.mVideoEncoderXMirror;
    localWXLivePushConfig.mHardwareAccel = this.mHardwareAccel;
    localWXLivePushConfig.mAudioSample = this.mAudioSample;
    localWXLivePushConfig.mAudioChannels = this.mAudioChannels;
    localWXLivePushConfig.mAudioBitrate = this.mAudioBitrate;
    localWXLivePushConfig.mEnableAec = this.mEnableAec;
    localWXLivePushConfig.mEnableAgc = this.mEnableAgc;
    localWXLivePushConfig.mEnableAns = this.mEnableAns;
    localWXLivePushConfig.mVolumeType = this.mVolumeType;
    localWXLivePushConfig.mPauseFlag = this.mPauseFlag;
    localWXLivePushConfig.mHomeOrientation = this.mHomeOrientation;
    localWXLivePushConfig.mLocalVideoMirrorType = this.mLocalVideoMirrorType;
    localWXLivePushConfig.mEnableAudioPreview = this.mEnableAudioPreview;
    AppMethodBeat.o(13939);
    return localWXLivePushConfig;
  }
  
  public void setVideoResolution(int paramInt1, int paramInt2)
  {
    this.mVideoEncodeWidth = paramInt1;
    this.mVideoEncodeHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePushConfig
 * JD-Core Version:    0.7.0.1
 */