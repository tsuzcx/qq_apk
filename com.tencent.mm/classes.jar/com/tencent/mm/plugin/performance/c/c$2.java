package com.tencent.mm.plugin.performance.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$2
  implements Runnable
{
  c$2(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(215450);
    ae.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", new Object[] { this.wZP.P(true, this.ohh) });
    AppMethodBeat.o(215450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.c.2
 * JD-Core Version:    0.7.0.1
 */