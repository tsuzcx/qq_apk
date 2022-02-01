package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class r
{
  private DexLoader a;
  private Object b;
  
  public r(DexLoader paramDexLoader, Context paramContext)
  {
    AppMethodBeat.i(192576);
    this.a = null;
    this.b = null;
    this.a = paramDexLoader;
    this.b = this.a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(192576);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(192580);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[] { Float.TYPE }, new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(192580);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(192582);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(192582);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(192586);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[] { Long.TYPE }, new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(192586);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(192577);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[] { SurfaceTexture.class }, new Object[] { paramSurfaceTexture });
    AppMethodBeat.o(192577);
  }
  
  public void a(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    AppMethodBeat.i(192578);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[] { Object.class }, new Object[] { paramTbsMediaPlayerListener });
    AppMethodBeat.o(192578);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(192581);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    AppMethodBeat.o(192581);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(55178);
    if (this.b != null)
    {
      AppMethodBeat.o(55178);
      return true;
    }
    AppMethodBeat.o(55178);
    return false;
  }
  
  public float b()
  {
    AppMethodBeat.i(192579);
    Float localFloat = (Float)this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
    if (localFloat != null)
    {
      float f = localFloat.floatValue();
      AppMethodBeat.o(192579);
      return f;
    }
    AppMethodBeat.o(192579);
    return 0.0F;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(192583);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(192583);
  }
  
  public void c()
  {
    AppMethodBeat.i(192584);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
    AppMethodBeat.o(192584);
  }
  
  public void d()
  {
    AppMethodBeat.i(192585);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    AppMethodBeat.o(192585);
  }
  
  public void e()
  {
    AppMethodBeat.i(192587);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
    AppMethodBeat.o(192587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.r
 * JD-Core Version:    0.7.0.1
 */