package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;

public abstract interface h
{
  public abstract boolean aXf();
  
  public abstract boolean ax(float paramFloat);
  
  public abstract void c(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract boolean c(double paramDouble, boolean paramBoolean);
  
  public abstract void cCC();
  
  public abstract int getCacheTimeSec();
  
  public abstract int getCurrPosMs();
  
  public abstract int getCurrPosSec();
  
  public abstract int getPlayerType();
  
  public abstract int getVideoDurationSec();
  
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
  
  public abstract void setLoopCompletionCallback(h.d paramd);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setScaleType(h.e parame);
  
  public abstract void setVideoFooterView(g paramg);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.h
 * JD-Core Version:    0.7.0.1
 */