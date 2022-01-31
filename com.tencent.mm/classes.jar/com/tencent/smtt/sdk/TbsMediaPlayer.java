package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsMediaPlayer
{
  private bb a = null;
  
  public TbsMediaPlayer(bb parambb)
  {
    this.a = parambb;
  }
  
  public void audio(int paramInt)
  {
    AppMethodBeat.i(64528);
    this.a.b(paramInt);
    AppMethodBeat.o(64528);
  }
  
  public void close()
  {
    AppMethodBeat.i(64532);
    this.a.e();
    AppMethodBeat.o(64532);
  }
  
  public float getVolume()
  {
    AppMethodBeat.i(64524);
    float f = this.a.b();
    AppMethodBeat.o(64524);
    return f;
  }
  
  public boolean isAvailable()
  {
    AppMethodBeat.i(64521);
    boolean bool = this.a.a();
    AppMethodBeat.o(64521);
    return bool;
  }
  
  public void pause()
  {
    AppMethodBeat.i(64529);
    this.a.c();
    AppMethodBeat.o(64529);
  }
  
  public void play()
  {
    AppMethodBeat.i(64530);
    this.a.d();
    AppMethodBeat.o(64530);
  }
  
  public void seek(long paramLong)
  {
    AppMethodBeat.i(64531);
    this.a.a(paramLong);
    AppMethodBeat.o(64531);
  }
  
  public void setPlayerListener(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    AppMethodBeat.i(64523);
    this.a.a(paramTbsMediaPlayerListener);
    AppMethodBeat.o(64523);
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(64522);
    this.a.a(paramSurfaceTexture);
    AppMethodBeat.o(64522);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(64525);
    this.a.a(paramFloat);
    AppMethodBeat.o(64525);
  }
  
  public void startPlay(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(64526);
    this.a.a(paramString, paramBundle);
    AppMethodBeat.o(64526);
  }
  
  public void subtitle(int paramInt)
  {
    AppMethodBeat.i(64527);
    this.a.a(paramInt);
    AppMethodBeat.o(64527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */