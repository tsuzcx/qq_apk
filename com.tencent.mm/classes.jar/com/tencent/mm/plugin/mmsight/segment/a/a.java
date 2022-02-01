package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;

public abstract interface a
{
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(d paramd);
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setLoop(int paramInt1, int paramInt2);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface a
  {
    public abstract boolean gB(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void dw(Object paramObject);
  }
  
  public static abstract interface c
  {
    public abstract void dx(Object paramObject);
  }
  
  public static abstract interface d
  {
    public abstract void ak(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.a
 * JD-Core Version:    0.7.0.1
 */