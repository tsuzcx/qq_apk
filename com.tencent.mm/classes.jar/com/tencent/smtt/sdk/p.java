package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class p
{
  private DexLoader a;
  private Object b;
  
  public p(DexLoader paramDexLoader, Context paramContext)
  {
    AppMethodBeat.i(55139);
    this.a = null;
    this.b = null;
    this.a = paramDexLoader;
    this.b = this.a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(55139);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(55143);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[] { Float.TYPE }, new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(55143);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(55145);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(55145);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(55149);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[] { Long.TYPE }, new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(55149);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(55140);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[] { SurfaceTexture.class }, new Object[] { paramSurfaceTexture });
    AppMethodBeat.o(55140);
  }
  
  public void a(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    AppMethodBeat.i(55141);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[] { Object.class }, new Object[] { paramTbsMediaPlayerListener });
    AppMethodBeat.o(55141);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(55144);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    AppMethodBeat.o(55144);
  }
  
  public boolean a()
  {
    return this.b != null;
  }
  
  public float b()
  {
    AppMethodBeat.i(55142);
    Float localFloat = (Float)this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
    if (localFloat != null)
    {
      float f = localFloat.floatValue();
      AppMethodBeat.o(55142);
      return f;
    }
    AppMethodBeat.o(55142);
    return 0.0F;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(55146);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(55146);
  }
  
  public void c()
  {
    AppMethodBeat.i(55147);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
    AppMethodBeat.o(55147);
  }
  
  public void d()
  {
    AppMethodBeat.i(55148);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    AppMethodBeat.o(55148);
  }
  
  public void e()
  {
    AppMethodBeat.i(55150);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
    AppMethodBeat.o(55150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.p
 * JD-Core Version:    0.7.0.1
 */