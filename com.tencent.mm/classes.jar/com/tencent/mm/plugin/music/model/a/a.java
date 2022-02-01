package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
  implements com.tencent.mm.plugin.music.cache.b
{
  public final void dvI()
  {
    AppMethodBeat.i(224249);
    dwx();
    AppMethodBeat.o(224249);
  }
  
  public final void dwx()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)g.ajR().ajA().get(am.a.ISV, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < ddV.longValue())
    {
      ae.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    g.ajR().ajA().set(am.a.ISV, Long.valueOf(l2));
    com.tencent.mm.sdk.g.b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.dwy();
        AppMethodBeat.o(63037);
      }
    }, "ScanMusicThread");
    AppMethodBeat.o(63039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */