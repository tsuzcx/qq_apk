package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public abstract interface f
{
  public abstract void d(double paramDouble, boolean paramBoolean);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract double getLastProgresstime();
  
  public abstract long getLastSurfaceUpdateTime();
  
  public abstract String getVideoPath();
  
  public abstract boolean isPlaying();
  
  public abstract void onDetach();
  
  public abstract void pause();
  
  public abstract boolean s(Context paramContext, boolean paramBoolean);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setOnInfoCallback(f.b paramb);
  
  public abstract void setOnSeekCompleteCallback(f.c paramc);
  
  public abstract void setOnSurfaceCallback(f.d paramd);
  
  public abstract void setOneTimeVideoTextureUpdateCallback(f.e parame);
  
  public abstract void setPlayProgressCallback(boolean paramBoolean);
  
  public abstract void setThumb(Bitmap paramBitmap);
  
  public abstract void setVideoCallback(f.a parama);
  
  public abstract void setVideoPath(String paramString);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract void x(double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */