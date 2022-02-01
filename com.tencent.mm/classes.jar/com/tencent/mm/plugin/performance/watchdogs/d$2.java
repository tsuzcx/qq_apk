package com.tencent.mm.plugin.performance.watchdogs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.dice.a.a;

final class d$2
  implements a.a
{
  d$2(d paramd) {}
  
  public final void action(double paramDouble)
  {
    AppMethodBeat.i(301029);
    d.a(this.MOm);
    AppMethodBeat.o(301029);
  }
  
  public final long cycleMinutes()
  {
    return 0L;
  }
  
  public final String key()
  {
    return "MicroMsg.MemoryWatchDog";
  }
  
  public final double rate()
  {
    AppMethodBeat.i(301039);
    double d = 1.0D / ((c)h.ax(c.class)).a(c.a.zjM, -1L);
    AppMethodBeat.o(301039);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d.2
 * JD-Core Version:    0.7.0.1
 */