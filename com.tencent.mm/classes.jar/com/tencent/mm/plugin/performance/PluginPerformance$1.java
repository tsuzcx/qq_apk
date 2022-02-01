package com.tencent.mm.plugin.performance;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.c.b;
import java.util.Set;

final class PluginPerformance$1
  implements com.tencent.mm.kernel.api.g
{
  PluginPerformance$1(PluginPerformance paramPluginPerformance) {}
  
  public final void MP()
  {
    AppMethodBeat.i(211731);
    h.LTJ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124897);
        b.a(com.tencent.mm.plugin.performance.c.c.dyZ().M(true, 0), c.dyx().toArray());
        AppMethodBeat.o(124897);
      }
    }, 10000L);
    com.tencent.mm.kernel.g.ajD().b(this);
    AppMethodBeat.o(211731);
  }
  
  public final void cg(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance.1
 * JD-Core Version:    0.7.0.1
 */