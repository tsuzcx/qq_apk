package com.tencent.qqvideo.proxy.api;

import android.content.Context;

public abstract interface IPlayManager
{
  public abstract void appToBack();
  
  public abstract void appToFront();
  
  public abstract String buildPlayURLMp4(int paramInt);
  
  public abstract int cleanStorage();
  
  public abstract void deinit();
  
  public abstract int getCurrentOffset(int paramInt);
  
  public abstract int getLocalServerPort();
  
  public abstract String getProxyVersion();
  
  public abstract int getTotalOffset(int paramInt);
  
  public abstract int init(Context paramContext, String paramString);
  
  public abstract int preLoad(int paramInt1, int paramInt2);
  
  public abstract void setCookie(String paramString);
  
  public abstract int setMaxStorageSize(long paramLong);
  
  public abstract void setNetWorkState(int paramInt);
  
  public abstract void setPlayerState(int paramInt);
  
  public abstract void setRemainTime(int paramInt1, int paramInt2);
  
  public abstract void setUtilsObject(IUtils paramIUtils);
  
  public abstract int startPlay(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2);
  
  public abstract void stopPlay(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.api.IPlayManager
 * JD-Core Version:    0.7.0.1
 */