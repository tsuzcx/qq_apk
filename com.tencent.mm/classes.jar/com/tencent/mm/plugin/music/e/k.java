package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends h
{
  private static k oZf;
  public a oZe = null;
  private com.tencent.mm.plugin.music.h.a oZg;
  
  private k(a parama)
  {
    this.oZe = parama;
  }
  
  /* Error */
  public static void a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 20
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 28	com/tencent/mm/plugin/music/e/k:oZf	Lcom/tencent/mm/plugin/music/e/k;
    //   11: ifnull +41 -> 52
    //   14: ldc 30
    //   16: ldc 32
    //   18: invokestatic 38	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 28	com/tencent/mm/plugin/music/e/k:oZf	Lcom/tencent/mm/plugin/music/e/k;
    //   24: aload_0
    //   25: putfield 17	com/tencent/mm/plugin/music/e/k:oZe	Lcom/tencent/mm/plugin/music/e/a;
    //   28: aload_0
    //   29: getstatic 28	com/tencent/mm/plugin/music/e/k:oZf	Lcom/tencent/mm/plugin/music/e/k;
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
    //   60: putstatic 28	com/tencent/mm/plugin/music/e/k:oZf	Lcom/tencent/mm/plugin/music/e/k;
    //   63: aload_0
    //   64: getstatic 28	com/tencent/mm/plugin/music/e/k:oZf	Lcom/tencent/mm/plugin/music/e/k;
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
  
  public static k bVH()
  {
    AppMethodBeat.i(137535);
    if (oZf == null)
    {
      localObject = new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
      AppMethodBeat.o(137535);
      throw ((Throwable)localObject);
    }
    if (oZf.oZe == null) {
      oZf.oZe = new i();
    }
    Object localObject = oZf;
    AppMethodBeat.o(137535);
    return localObject;
  }
  
  public static void bVI()
  {
    try
    {
      AppMethodBeat.i(137536);
      if (oZf != null) {
        oZf.finish();
      }
      AppMethodBeat.o(137536);
      return;
    }
    finally {}
  }
  
  public static com.tencent.mm.plugin.music.h.a bVJ()
  {
    AppMethodBeat.i(137546);
    if (bVH().oZg == null) {
      bVH().oZg = new com.tencent.mm.plugin.music.h.a();
    }
    com.tencent.mm.plugin.music.h.a locala = bVH().oZg;
    AppMethodBeat.o(137546);
    return locala;
  }
  
  public static boolean isInit()
  {
    return oZf != null;
  }
  
  public final void Ai(int paramInt)
  {
    AppMethodBeat.i(137544);
    super.Ai(paramInt);
    AppMethodBeat.o(137544);
  }
  
  public final void aiu()
  {
    AppMethodBeat.i(137540);
    super.aiu();
    AppMethodBeat.o(137540);
  }
  
  public final e bVs()
  {
    AppMethodBeat.i(137545);
    e locale = this.oZe.bVs();
    AppMethodBeat.o(137545);
    return locale;
  }
  
  public final com.tencent.mm.plugin.music.f.a.d bVu()
  {
    AppMethodBeat.i(137539);
    com.tencent.mm.plugin.music.f.a.d locald = super.bVu();
    AppMethodBeat.o(137539);
    return locald;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(137542);
    super.finish();
    this.oZe.release();
    this.oZg = null;
    AppMethodBeat.o(137542);
  }
  
  public final void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(137543);
    super.jL(paramBoolean);
    AppMethodBeat.o(137543);
  }
  
  public final void p(e parame)
  {
    AppMethodBeat.i(137537);
    if (parame != null) {
      ab.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[] { Integer.valueOf(parame.fKh) });
    }
    ab.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
    t(this.oZe.i(parame));
    AppMethodBeat.o(137537);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137541);
    ab.i("MicroMsg.Music.MusicPlayerManager", "release");
    super.release();
    AppMethodBeat.o(137541);
  }
  
  final void t(e parame)
  {
    AppMethodBeat.i(137538);
    com.tencent.mm.plugin.music.h.d.N(parame);
    if (this.oZe.g(parame))
    {
      q(parame);
      AppMethodBeat.o(137538);
      return;
    }
    ab.e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
    AppMethodBeat.o(137538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.k
 * JD-Core Version:    0.7.0.1
 */