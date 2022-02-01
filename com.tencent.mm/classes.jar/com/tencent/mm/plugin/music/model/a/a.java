package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class a
  implements com.tencent.mm.plugin.music.cache.b
{
  public final void diW()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)g.agR().agA().get(ah.a.GMf, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < cRD.longValue())
    {
      ac.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    g.agR().agA().set(ah.a.GMf, Long.valueOf(l2));
    com.tencent.mm.sdk.g.b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.diX();
        AppMethodBeat.o(63037);
      }
    }, "ScanMusicThread");
    AppMethodBeat.o(63039);
  }
  
  public final void dih()
  {
    AppMethodBeat.i(210241);
    diW();
    AppMethodBeat.o(210241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */