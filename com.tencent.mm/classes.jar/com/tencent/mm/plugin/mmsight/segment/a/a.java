package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;

public abstract interface a
{
  public abstract void a(a.a parama);
  
  public abstract void a(a.b paramb);
  
  public abstract void a(a.c paramc);
  
  public abstract void a(a.d paramd);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract void ih(int paramInt1, int paramInt2);
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.a
 * JD-Core Version:    0.7.0.1
 */