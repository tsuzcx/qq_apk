package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class b$7
  implements Runnable
{
  b$7(b paramb, long paramLong1, al.a parama, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(51506);
    if (!g.ajx())
    {
      AppMethodBeat.o(51506);
      return;
    }
    g.ajD();
    g.ajC().ajl().set(al.a.IxW, Long.valueOf(this.vYQ));
    if (this.vYR != null)
    {
      g.ajD();
      g.ajC().ajl().set(this.vYR, Long.valueOf(this.pnq));
    }
    ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.vYQ), Long.valueOf(b.s(this.vYI)), this.vYR, Long.valueOf(this.pnq) });
    AppMethodBeat.o(51506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.7
 * JD-Core Version:    0.7.0.1
 */