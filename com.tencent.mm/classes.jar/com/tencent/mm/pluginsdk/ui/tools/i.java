package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public abstract interface i
{
  public abstract void H(double paramDouble);
  
  public abstract boolean P(Context paramContext, boolean paramBoolean);
  
  public abstract void c(double paramDouble, boolean paramBoolean);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract double getLastProgresstime();
  
  public abstract long getLastSurfaceUpdateTime();
  
  public abstract String getVideoPath();
  
  public abstract boolean isPlaying();
  
  public abstract void onDetach();
  
  public abstract void pause();
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setOnInfoCallback(i.b paramb);
  
  public abstract void setOnSeekCompleteCallback(i.c paramc);
  
  public abstract void setOnSurfaceCallback(i.d paramd);
  
  public abstract void setOneTimeVideoTextureUpdateCallback(i.e parame);
  
  public abstract void setPlayProgressCallback(boolean paramBoolean);
  
  public abstract void setThumb(Bitmap paramBitmap);
  
  public abstract void setVideoCallback(a parama);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract void Qz();
    
    public abstract void fG(int paramInt1, int paramInt2);
    
    public abstract int gw(int paramInt1, int paramInt2);
    
    public abstract void onCompletion();
    
    public abstract void onError(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */