package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public abstract interface h
{
  public abstract void d(double paramDouble, boolean paramBoolean);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract double getLastProgresstime();
  
  public abstract long getLastSurfaceUpdateTime();
  
  public abstract String getVideoPath();
  
  public abstract boolean isPlaying();
  
  public abstract void onDetach();
  
  public abstract void p(double paramDouble);
  
  public abstract void pause();
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setOnInfoCallback(h.b paramb);
  
  public abstract void setOnSeekCompleteCallback(c paramc);
  
  public abstract void setOnSurfaceCallback(d paramd);
  
  public abstract void setOneTimeVideoTextureUpdateCallback(e parame);
  
  public abstract void setPlayProgressCallback(boolean paramBoolean);
  
  public abstract void setThumb(Bitmap paramBitmap);
  
  public abstract void setVideoCallback(a parama);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract boolean z(Context paramContext, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void dZ(int paramInt1, int paramInt2);
    
    public abstract int eP(int paramInt1, int paramInt2);
    
    public abstract void onCompletion();
    
    public abstract void onError(int paramInt1, int paramInt2);
    
    public abstract void rB();
  }
  
  public static abstract interface c
  {
    public abstract void eS(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void aJn();
  }
  
  public static abstract interface e
  {
    public abstract void bli();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */