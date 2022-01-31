package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.view.Surface;
import com.tencent.mm.compatible.b.j;

public final class d
  implements a
{
  private MediaPlayer eLh = new j();
  
  public final void a(a.a parama)
  {
    if (parama == null)
    {
      this.eLh.setOnErrorListener(null);
      return;
    }
    this.eLh.setOnErrorListener(new d.4(this, parama));
  }
  
  public final void a(a.b paramb)
  {
    if (paramb == null)
    {
      this.eLh.setOnPreparedListener(null);
      return;
    }
    this.eLh.setOnPreparedListener(new d.1(this, paramb));
  }
  
  public final void a(a.c paramc)
  {
    if (paramc == null)
    {
      this.eLh.setOnSeekCompleteListener(null);
      return;
    }
    this.eLh.setOnSeekCompleteListener(new d.2(this, paramc));
  }
  
  public final void a(a.d paramd)
  {
    if (paramd == null)
    {
      this.eLh.setOnVideoSizeChangedListener(null);
      return;
    }
    this.eLh.setOnVideoSizeChangedListener(new d.3(this, paramd));
  }
  
  public final int getCurrentPosition()
  {
    return this.eLh.getCurrentPosition();
  }
  
  public final int getDuration()
  {
    return this.eLh.getDuration();
  }
  
  public final boolean isPlaying()
  {
    return this.eLh.isPlaying();
  }
  
  public final void pause()
  {
    this.eLh.pause();
  }
  
  public final void prepareAsync()
  {
    this.eLh.prepareAsync();
  }
  
  public final void release()
  {
    this.eLh.release();
  }
  
  public final void seekTo(int paramInt)
  {
    this.eLh.seekTo(paramInt);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    this.eLh.setAudioStreamType(paramInt);
  }
  
  public final void setDataSource(String paramString)
  {
    this.eLh.setDataSource(paramString);
  }
  
  public final void setLoop(int paramInt1, int paramInt2) {}
  
  public final void setLooping(boolean paramBoolean)
  {
    this.eLh.setLooping(paramBoolean);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    this.eLh.setSurface(paramSurface);
  }
  
  public final void start()
  {
    this.eLh.start();
  }
  
  public final void stop()
  {
    this.eLh.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.d
 * JD-Core Version:    0.7.0.1
 */