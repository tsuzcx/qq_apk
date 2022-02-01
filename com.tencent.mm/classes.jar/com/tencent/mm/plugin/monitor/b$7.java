package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class b$7
  implements Runnable
{
  b$7(b paramb, long paramLong1, ae.a parama, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(51506);
    if (!g.afw())
    {
      AppMethodBeat.o(51506);
      return;
    }
    g.afC();
    g.afB().afk().set(ae.a.FnP, Long.valueOf(this.tNf));
    if (this.tNg != null)
    {
      g.afC();
      g.afB().afk().set(this.tNg, Long.valueOf(this.ogj));
    }
    ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.tNf), Long.valueOf(b.s(this.tMX)), this.tNg, Long.valueOf(this.ogj) });
    AppMethodBeat.o(51506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.7
 * JD-Core Version:    0.7.0.1
 */