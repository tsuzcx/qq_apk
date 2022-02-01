package com.tencent.mm.plugin.n;

import android.view.Surface;

public abstract interface c
{
  public abstract long getDurationMs();
  
  public abstract void pause();
  
  public abstract boolean prepare();
  
  public abstract void release();
  
  public abstract void seek(int paramInt);
  
  public abstract void setPath(String paramString);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.c
 * JD-Core Version:    0.7.0.1
 */