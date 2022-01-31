package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$6
  implements Runnable
{
  b$6(b paramb, long paramLong1, ac.a parama, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(84522);
    if (!g.RG())
    {
      AppMethodBeat.o(84522);
      return;
    }
    g.RM();
    g.RL().Ru().set(ac.a.yFg, Long.valueOf(this.oSd));
    if (this.oSe != null)
    {
      g.RM();
      g.RL().Ru().set(this.oSe, Long.valueOf(this.kZt));
    }
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.oSd), Long.valueOf(b.s(this.oRW)), this.oSe, Long.valueOf(this.kZt) });
    AppMethodBeat.o(84522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.6
 * JD-Core Version:    0.7.0.1
 */