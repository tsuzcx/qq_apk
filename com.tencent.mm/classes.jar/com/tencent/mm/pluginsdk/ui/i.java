package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;

public abstract interface i
{
  public abstract boolean aO(float paramFloat);
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract void dFl();
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
  public abstract boolean isLive();
  
  public abstract boolean isPlaying();
  
  public abstract void onUIDestroy();
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract boolean p(double paramDouble);
  
  public abstract boolean pause();
  
  public abstract void setCover(Bitmap paramBitmap);
  
  public abstract void setFullDirection(int paramInt);
  
  public abstract void setIsShowBasicControls(boolean paramBoolean);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setLoopCompletionCallback(d paramd);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(i.e parame);
  
  public abstract void setVideoFooterView(h paramh);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void aO(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void DX(String paramString);
    
    public abstract void yU(long paramLong);
  }
  
  public static abstract interface d
  {
    public abstract void fdO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.i
 * JD-Core Version:    0.7.0.1
 */