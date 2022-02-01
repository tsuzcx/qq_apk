package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class c$7
  implements Runnable
{
  c$7(c paramc, long paramLong1, at.a parama, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(51506);
    if (!h.baz())
    {
      AppMethodBeat.o(51506);
      return;
    }
    CrashReportFactory.setHeavyUserFlag(this.Lgh);
    h.baF();
    h.baE().ban().set(at.a.acPU, Long.valueOf(this.Lgh));
    if (this.Lgi != null)
    {
      h.baF();
      h.baE().ban().set(this.Lgi, Long.valueOf(this.xoK));
    }
    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", new Object[] { Long.valueOf(this.Lgh), Long.valueOf(c.r(this.LfZ)), this.Lgi, Long.valueOf(this.xoK) });
    AppMethodBeat.o(51506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.7
 * JD-Core Version:    0.7.0.1
 */