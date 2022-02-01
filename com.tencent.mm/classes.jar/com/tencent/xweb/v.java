package com.tencent.xweb;

public abstract interface v
{
  public abstract void blw();
  
  public abstract void onVideoEnded();
  
  public abstract void onVideoEnterFullscreen(boolean paramBoolean1, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean2, boolean paramBoolean3, double paramDouble3, double paramDouble4, double[] paramArrayOfDouble);
  
  public abstract void onVideoError(int paramInt, String paramString);
  
  public abstract void onVideoExitFullscreen();
  
  public abstract void onVideoPause();
  
  public abstract void onVideoPlay();
  
  public abstract void onVideoPlaying();
  
  public abstract void onVideoSeeked();
  
  public abstract void onVideoSeeking();
  
  public abstract void onVideoSizeUpdate(double paramDouble1, double paramDouble2);
  
  public abstract void onVideoTimeUpdate(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble);
  
  public abstract void onVideoWaiting();
  
  public abstract boolean td(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.v
 * JD-Core Version:    0.7.0.1
 */