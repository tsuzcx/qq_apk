package com.tencent.mm.plugin.performance.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class c$2
  implements Runnable
{
  c$2(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(211780);
    ad.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", new Object[] { this.wKe.M(true, this.obr) });
    AppMethodBeat.o(211780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.c.2
 * JD-Core Version:    0.7.0.1
 */