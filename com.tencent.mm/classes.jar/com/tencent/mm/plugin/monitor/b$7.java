package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class b$7
  implements Runnable
{
  b$7(b paramb, long paramLong1, am.a parama, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(51506);
    if (!g.ajM())
    {
      AppMethodBeat.o(51506);
      return;
    }
    g.ajS();
    g.ajR().ajA().set(am.a.ISu, Long.valueOf(this.wkU));
    if (this.wkV != null)
    {
      g.ajS();
      g.ajR().ajA().set(this.wkV, Long.valueOf(this.ptX));
    }
    ae.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.wkU), Long.valueOf(b.s(this.wkM)), this.wkV, Long.valueOf(this.ptX) });
    AppMethodBeat.o(51506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.7
 * JD-Core Version:    0.7.0.1
 */