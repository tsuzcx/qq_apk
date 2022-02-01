package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

final class b$11
  extends com.tencent.e.i.b
{
  b$11(b paramb) {}
  
  public final String getKey()
  {
    return "reportHeavyUser";
  }
  
  public final void run()
  {
    AppMethodBeat.i(51510);
    ad.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
    if (g.afw()) {
      b.h(this.tMX);
    }
    AppMethodBeat.o(51510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.11
 * JD-Core Version:    0.7.0.1
 */