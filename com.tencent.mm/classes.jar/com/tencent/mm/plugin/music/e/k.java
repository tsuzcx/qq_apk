package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends h
{
  private static k wkq;
  public a wkp = null;
  private com.tencent.mm.plugin.music.h.a wkr;
  
  private k(a parama)
  {
    this.wkp = parama;
  }
  
  /* Error */
  public static void a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 20
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 28	com/tencent/mm/plugin/music/e/k:wkq	Lcom/tencent/mm/plugin/music/e/k;
    //   11: ifnull +41 -> 52
    //   14: ldc 30
    //   16: ldc 32
    //   18: invokestatic 38	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 28	com/tencent/mm/plugin/music/e/k:wkq	Lcom/tencent/mm/plugin/music/e/k;
    //   24: aload_0
    //   25: putfield 17	com/tencent/mm/plugin/music/e/k:wkp	Lcom/tencent/mm/plugin/music/e/a;
    //   28: aload_0
    //   29: getstatic 28	com/tencent/mm/plugin/music/e/k:wkq	Lcom/tencent/mm/plugin/music/e/k;
    //   32: invokeinterface 43 2 0
    //   37: aload_0
    //   38: invokeinterface 46 1 0
    //   43: ldc 20
    //   45: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: new 2	com/tencent/mm/plugin/music/e/k
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 51	com/tencent/mm/plugin/music/e/k:<init>	(Lcom/tencent/mm/plugin/music/e/a;)V
    //   60: putstatic 28	com/tencent/mm/plugin/music/e/k:wkq	Lcom/tencent/mm/plugin/music/e/k;
    //   63: aload_0
    //   64: getstatic 28	com/tencent/mm/plugin/music/e/k:wkq	Lcom/tencent/mm/plugin/music/e/k;
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
  
  public static k dta()
  {
    AppMethodBeat.i(137285);
    if (wkq == null)
    {
      localObject = new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
      AppMethodBeat.o(137285);
      throw ((Throwable)localObject);
    }
    if (wkq.wkp == null) {
      wkq.wkp = new i();
    }
    Object localObject = wkq;
    AppMethodBeat.o(137285);
    return localObject;
  }
  
  public static void dtb()
  {
    try
    {
      AppMethodBeat.i(137286);
      if (wkq != null) {
        wkq.finish();
      }
      AppMethodBeat.o(137286);
      return;
    }
    finally {}
  }
  
  public static com.tencent.mm.plugin.music.h.a dtc()
  {
    AppMethodBeat.i(137296);
    if (dta().wkr == null) {
      dta().wkr = new com.tencent.mm.plugin.music.h.a();
    }
    com.tencent.mm.plugin.music.h.a locala = dta().wkr;
    AppMethodBeat.o(137296);
    return locala;
  }
  
  public static boolean isInit()
  {
    return wkq != null;
  }
  
  public final void Ln(int paramInt)
  {
    AppMethodBeat.i(137294);
    super.Ln(paramInt);
    AppMethodBeat.o(137294);
  }
  
  public final void aJE()
  {
    AppMethodBeat.i(137290);
    super.aJE();
    AppMethodBeat.o(137290);
  }
  
  public final f dsL()
  {
    AppMethodBeat.i(137295);
    f localf = this.wkp.dsL();
    AppMethodBeat.o(137295);
    return localf;
  }
  
  public final com.tencent.mm.plugin.music.f.a.d dsN()
  {
    AppMethodBeat.i(137289);
    com.tencent.mm.plugin.music.f.a.d locald = super.dsN();
    AppMethodBeat.o(137289);
    return locald;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(137292);
    super.finish();
    this.wkp.release();
    this.wkr = null;
    AppMethodBeat.o(137292);
  }
  
  public final void m(f paramf)
  {
    AppMethodBeat.i(194989);
    super.m(paramf);
    this.wkp.m(paramf);
    AppMethodBeat.o(194989);
  }
  
  public final void pc(boolean paramBoolean)
  {
    AppMethodBeat.i(137293);
    super.pc(paramBoolean);
    AppMethodBeat.o(137293);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137291);
    ad.i("MicroMsg.Music.MusicPlayerManager", "release");
    super.release();
    AppMethodBeat.o(137291);
  }
  
  public final void s(f paramf)
  {
    AppMethodBeat.i(137287);
    if (paramf != null) {
      ad.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[] { Integer.valueOf(paramf.ihe) });
    }
    ad.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
    w(this.wkp.k(paramf));
    AppMethodBeat.o(137287);
  }
  
  final void w(f paramf)
  {
    AppMethodBeat.i(137288);
    com.tencent.mm.plugin.music.h.d.R(paramf);
    if (this.wkp.i(paramf))
    {
      t(paramf);
      AppMethodBeat.o(137288);
      return;
    }
    ad.e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
    AppMethodBeat.o(137288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.k
 * JD-Core Version:    0.7.0.1
 */