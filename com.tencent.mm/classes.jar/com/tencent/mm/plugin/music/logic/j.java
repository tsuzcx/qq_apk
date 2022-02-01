package com.tencent.mm.plugin.music.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends g
{
  private static j LLx;
  public a LLw = null;
  private com.tencent.mm.plugin.music.h.a LLy;
  
  private j(a parama)
  {
    this.LLw = parama;
  }
  
  /* Error */
  public static void a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 20
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 28	com/tencent/mm/plugin/music/logic/j:LLx	Lcom/tencent/mm/plugin/music/logic/j;
    //   11: ifnull +41 -> 52
    //   14: ldc 30
    //   16: ldc 32
    //   18: invokestatic 38	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 28	com/tencent/mm/plugin/music/logic/j:LLx	Lcom/tencent/mm/plugin/music/logic/j;
    //   24: aload_0
    //   25: putfield 17	com/tencent/mm/plugin/music/logic/j:LLw	Lcom/tencent/mm/plugin/music/logic/a;
    //   28: aload_0
    //   29: getstatic 28	com/tencent/mm/plugin/music/logic/j:LLx	Lcom/tencent/mm/plugin/music/logic/j;
    //   32: invokeinterface 43 2 0
    //   37: aload_0
    //   38: invokeinterface 46 1 0
    //   43: ldc 20
    //   45: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: new 2	com/tencent/mm/plugin/music/logic/j
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 51	com/tencent/mm/plugin/music/logic/j:<init>	(Lcom/tencent/mm/plugin/music/logic/a;)V
    //   60: putstatic 28	com/tencent/mm/plugin/music/logic/j:LLx	Lcom/tencent/mm/plugin/music/logic/j;
    //   63: aload_0
    //   64: getstatic 28	com/tencent/mm/plugin/music/logic/j:LLx	Lcom/tencent/mm/plugin/music/logic/j;
    //   67: invokeinterface 43 2 0
    //   72: aload_0
    //   73: invokeinterface 46 1 0
    //   78: ldc 20
    //   80: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -35 -> 48
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	parama	a
    // Exception table:
    //   from	to	target	type
    //   3	48	86	finally
    //   52	83	86	finally
  }
  
  public static j gnw()
  {
    AppMethodBeat.i(137285);
    if (LLx == null)
    {
      localObject = new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
      AppMethodBeat.o(137285);
      throw ((Throwable)localObject);
    }
    if (LLx.LLw == null) {
      LLx.LLw = new h();
    }
    Object localObject = LLx;
    AppMethodBeat.o(137285);
    return localObject;
  }
  
  public static void gnx()
  {
    try
    {
      AppMethodBeat.i(137286);
      if (LLx != null) {
        LLx.finish();
      }
      AppMethodBeat.o(137286);
      return;
    }
    finally {}
  }
  
  public static com.tencent.mm.plugin.music.h.a gny()
  {
    AppMethodBeat.i(137296);
    if (gnw().LLy == null) {
      gnw().LLy = new com.tencent.mm.plugin.music.h.a();
    }
    com.tencent.mm.plugin.music.h.a locala = gnw().LLy;
    AppMethodBeat.o(137296);
    return locala;
  }
  
  public static boolean isInit()
  {
    return LLx != null;
  }
  
  final void A(f paramf)
  {
    AppMethodBeat.i(137288);
    com.tencent.mm.plugin.music.h.d.ab(paramf);
    if (this.LLw.i(paramf))
    {
      x(paramf);
      AppMethodBeat.o(137288);
      return;
    }
    gnu();
    Log.e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
    AppMethodBeat.o(137288);
  }
  
  public final boolean adu(int paramInt)
  {
    AppMethodBeat.i(270918);
    boolean bool = this.LLw.adu(paramInt);
    AppMethodBeat.o(270918);
    return bool;
  }
  
  public final void adx(int paramInt)
  {
    AppMethodBeat.i(137294);
    super.adx(paramInt);
    AppMethodBeat.o(137294);
  }
  
  public final void bLi()
  {
    AppMethodBeat.i(137290);
    super.bLi();
    AppMethodBeat.o(137290);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(137292);
    super.finish();
    this.LLw.release();
    this.LLy = null;
    AppMethodBeat.o(137292);
  }
  
  public final f gng()
  {
    AppMethodBeat.i(137295);
    f localf = this.LLw.gng();
    AppMethodBeat.o(137295);
    return localf;
  }
  
  public final com.tencent.mm.plugin.music.e.a.d gnj()
  {
    AppMethodBeat.i(137289);
    com.tencent.mm.plugin.music.e.a.d locald = super.gnj();
    AppMethodBeat.o(137289);
    return locald;
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(270914);
    super.m(paramf);
    this.LLw.m(paramf);
    AppMethodBeat.o(270914);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137291);
    Log.i("MicroMsg.Music.MusicPlayerManager", "release");
    super.release();
    AppMethodBeat.o(137291);
  }
  
  public final void w(f paramf)
  {
    AppMethodBeat.i(137287);
    if (paramf != null) {
      Log.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[] { Integer.valueOf(paramf.oOt) });
    }
    Log.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
    A(this.LLw.k(paramf));
    AppMethodBeat.o(137287);
  }
  
  public final void zI(boolean paramBoolean)
  {
    AppMethodBeat.i(137293);
    super.zI(paramBoolean);
    AppMethodBeat.o(137293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.j
 * JD-Core Version:    0.7.0.1
 */