package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsMediaPlayer
{
  private p a = null;
  
  public TbsMediaPlayer(p paramp)
  {
    this.a = paramp;
  }
  
  public void audio(int paramInt)
  {
    AppMethodBeat.i(55158);
    this.a.b(paramInt);
    AppMethodBeat.o(55158);
  }
  
  public void close()
  {
    AppMethodBeat.i(55162);
    this.a.e();
    AppMethodBeat.o(55162);
  }
  
  public float getVolume()
  {
    AppMethodBeat.i(55154);
    float f = this.a.b();
    AppMethodBeat.o(55154);
    return f;
  }
  
  public boolean isAvailable()
  {
    AppMethodBeat.i(55151);
    boolean bool = this.a.a();
    AppMethodBeat.o(55151);
    return bool;
  }
  
  public void pause()
  {
    AppMethodBeat.i(55159);
    this.a.c();
    AppMethodBeat.o(55159);
  }
  
  public void play()
  {
    AppMethodBeat.i(55160);
    this.a.d();
    AppMethodBeat.o(55160);
  }
  
  public void seek(long paramLong)
  {
    AppMethodBeat.i(55161);
    this.a.a(paramLong);
    AppMethodBeat.o(55161);
  }
  
  public void setPlayerListener(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    AppMethodBeat.i(55153);
    this.a.a(paramTbsMediaPlayerListener);
    AppMethodBeat.o(55153);
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(55152);
    this.a.a(paramSurfaceTexture);
    AppMethodBeat.o(55152);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(55155);
    this.a.a(paramFloat);
    AppMethodBeat.o(55155);
  }
  
  public void startPlay(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(55156);
    this.a.a(paramString, paramBundle);
    AppMethodBeat.o(55156);
  }
  
  public void subtitle(int paramInt)
  {
    AppMethodBeat.i(55157);
    this.a.a(paramInt);
    AppMethodBeat.o(55157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */