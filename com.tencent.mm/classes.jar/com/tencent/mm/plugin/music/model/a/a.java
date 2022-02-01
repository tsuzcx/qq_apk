package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class a
  implements com.tencent.mm.plugin.music.cache.b
{
  public final void cUB()
  {
    AppMethodBeat.i(200803);
    cVq();
    AppMethodBeat.o(200803);
  }
  
  public final void cVq()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)g.afB().afk().get(ae.a.Foq, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < cUg.longValue())
    {
      ad.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    g.afB().afk().set(ae.a.Foq, Long.valueOf(l2));
    com.tencent.mm.sdk.g.b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.cVr();
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