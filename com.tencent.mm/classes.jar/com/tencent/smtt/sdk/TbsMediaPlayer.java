package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;

public class TbsMediaPlayer
{
  private ba a = null;
  
  public TbsMediaPlayer(ba paramba)
  {
    this.a = paramba;
  }
  
  public void audio(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void close()
  {
    this.a.e();
  }
  
  public float getVolume()
  {
    return this.a.b();
  }
  
  public boolean isAvailable()
  {
    return this.a.a();
  }
  
  public void pause()
  {
    this.a.c();
  }
  
  public void play()
  {
    this.a.d();
  }
  
  public void seek(long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void setPlayerListener(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    this.a.a(paramTbsMediaPlayerListener);
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    this.a.a(paramSurfaceTexture);
  }
  
  public void setVolume(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void startPlay(String paramString, Bundle paramBundle)
  {
    this.a.a(paramString, paramBundle);
  }
  
  public void subtitle(int paramInt)
  {
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */