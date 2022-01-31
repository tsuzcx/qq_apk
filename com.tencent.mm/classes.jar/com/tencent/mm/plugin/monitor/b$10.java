package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class b$10
  implements Runnable
{
  b$10(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(84527);
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
    if (g.RG()) {
      b.h(this.oRW);
    }
    AppMethodBeat.o(84527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.10
 * JD-Core Version:    0.7.0.1
 */