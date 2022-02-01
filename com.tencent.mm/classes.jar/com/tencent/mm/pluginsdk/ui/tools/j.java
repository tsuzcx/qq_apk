package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public abstract interface j
{
  public abstract boolean E(Context paramContext, boolean paramBoolean);
  
  public abstract void d(double paramDouble, boolean paramBoolean);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract double getLastProgresstime();
  
  public abstract long getLastSurfaceUpdateTime();
  
  public abstract String getVideoPath();
  
  public abstract boolean isPlaying();
  
  public abstract void onDetach();
  
  public abstract void pause();
  
  public abstract void q(double paramDouble);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setOnInfoCallback(j.b paramb);
  
  public abstract void setOnSeekCompleteCallback(j.c paramc);
  
  public abstract void setOnSurfaceCallback(j.d paramd);
  
  public abstract void setOneTimeVideoTextureUpdateCallback(j.e parame);
  
  public abstract void setPlayProgressCallback(boolean paramBoolean);
  
  public abstract void setThumb(Bitmap paramBitmap);
  
  public abstract void setVideoCallback(j.a parama);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract boolean start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */