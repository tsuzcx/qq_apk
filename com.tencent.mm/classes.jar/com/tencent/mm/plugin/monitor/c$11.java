package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.b;

final class c$11
  extends b
{
  c$11(c paramc) {}
  
  public final String getKey()
  {
    return "reportHeavyUser";
  }
  
  public final void run()
  {
    AppMethodBeat.i(51510);
    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
    if (h.baz()) {
      c.h(this.LfZ);
    }
    AppMethodBeat.o(51510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.c.11
 * JD-Core Version:    0.7.0.1
 */