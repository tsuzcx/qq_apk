package com.tencent.rtmp;

import java.util.Map;

public class TXLivePlayConfig
{
  boolean mAutoAdjustCacheTime = true;
  boolean mAutoRotate = true;
  String mCacheFolderPath;
  float mCacheTime = 5.0F;
  int mConnectRetryCount = 3;
  int mConnectRetryInterval = 3;
  boolean mEnableAec = false;
  boolean mEnableMessage = false;
  boolean mEnableNearestIP = true;
  protected Map<String, String> mHeaders;
  float mMaxAutoAdjustCacheTime = 5.0F;
  int mMaxCacheItems;
  float mMinAutoAdjustCacheTime = 1.0F;
  int mRtmpChannelType = 0;
  int mVideoBlockThreshold = 800;
  
  public void enableAEC(boolean paramBoolean)
  {
    this.mEnableAec = paramBoolean;
  }
  
  public void setAutoAdjustCacheTime(boolean paramBoolean)
  {
    this.mAutoAdjustCacheTime = paramBoolean;
  }
  
  public void setCacheFolderPath(String paramString)
  {
    this.mCacheFolderPath = paramString;
  }
  
  public void setCacheTime(float paramFloat)
  {
    this.mCacheTime = paramFloat;
  }
  
  public void setConnectRetryCount(int paramInt)
  {
    this.mConnectRetryCount = paramInt;
  }
  
  public void setConnectRetryInterval(int paramInt)
  {
    this.mConnectRetryInterval = paramInt;
  }
  
  public void setEnableMessage(boolean paramBoolean)
  {
    this.mEnableMessage = paramBoolean;
  }
  
  public void setEnableNearestIP(boolean paramBoolean)
  {
    this.mEnableNearestIP = paramBoolean;
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    this.mHeaders = paramMap;
  }
  
  public void setMaxAutoAdjustCacheTime(float paramFloat)
  {
    this.mMaxAutoAdjustCacheTime = paramFloat;
  }
  
  public void setMaxCacheItems(int paramInt)
  {
    this.mMaxCacheItems = paramInt;
  }
  
  public void setMinAutoAdjustCacheTime(float paramFloat)
  {
    this.mMinAutoAdjustCacheTime = paramFloat;
  }
  
  public void setRtmpChannelType(int paramInt)
  {
    this.mRtmpChannelType = paramInt;
  }
  
  public void setVideoBlockThreshold(int paramInt)
  {
    this.mVideoBlockThreshold = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayConfig
 * JD-Core Version:    0.7.0.1
 */