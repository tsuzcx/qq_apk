package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class b$7
  implements Runnable
{
  b$7(b paramb, long paramLong1, ah.a parama, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(51506);
    if (!g.agM())
    {
      AppMethodBeat.o(51506);
      return;
    }
    g.agS();
    g.agR().agA().set(ah.a.GLE, Long.valueOf(this.uVI));
    if (this.uVJ != null)
    {
      g.agS();
      g.agR().agA().set(this.uVJ, Long.valueOf(this.oJJ));
    }
    ac.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.uVI), Long.valueOf(b.s(this.uVA)), this.uVJ, Long.valueOf(this.oJJ) });
    AppMethodBeat.o(51506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.7
 * JD-Core Version:    0.7.0.1
 */