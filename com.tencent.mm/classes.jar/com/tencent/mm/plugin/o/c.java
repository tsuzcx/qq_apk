package com.tencent.mm.plugin.o;

import android.view.Surface;

public abstract interface c
{
  public abstract boolean cSW();
  
  public abstract long getDurationMs();
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void seek(int paramInt);
  
  public abstract void setPath(String paramString);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.o.c
 * JD-Core Version:    0.7.0.1
 */