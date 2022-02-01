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
    AppMethodBeat.i(188401);
    this.a = null;
    this.b = null;
    this.a = paramDexLoader;
    this.b = this.a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(188401);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(188405);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setVolume", new Class[] { Float.TYPE }, new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(188405);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(188407);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(188407);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(188411);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[] { Long.TYPE }, new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(188411);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(188402);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[] { SurfaceTexture.class }, new Object[] { paramSurfaceTexture });
    AppMethodBeat.o(188402);
  }
  
  public void a(TbsMediaPlayer.TbsMediaPlayerListener paramTbsMediaPlayerListener)
  {
    AppMethodBeat.i(188403);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[] { Object.class }, new Object[] { paramTbsMediaPlayerListener });
    AppMethodBeat.o(188403);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(188406);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    AppMethodBeat.o(188406);
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
    AppMethodBeat.i(188404);
    Float localFloat = (Float)this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
    if (localFloat != null)
    {
      float f = localFloat.floatValue();
      AppMethodBeat.o(188404);
      return f;
    }
    AppMethodBeat.o(188404);
    return 0.0F;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(188408);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "audio", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(188408);
  }
  
  public void c()
  {
    AppMethodBeat.i(188409);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "pause", new Class[0], new Object[0]);
    AppMethodBeat.o(188409);
  }
  
  public void d()
  {
    AppMethodBeat.i(188410);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    AppMethodBeat.o(188410);
  }
  
  public void e()
  {
    AppMethodBeat.i(188412);
    this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "close", new Class[0], new Object[0]);
    AppMethodBeat.o(188412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.r
 * JD-Core Version:    0.7.0.1
 */