package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.trafficmonitor.a.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class PluginTrafficMonitor
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(123901);
    h.ahAA.bm(new PluginTrafficMonitor..ExternalSyntheticLambda0(paramg));
    AppMethodBeat.o(123901);
  }
  
  public void installed()
  {
    AppMethodBeat.i(123900);
    super.installed();
    alias(a.class);
    AppMethodBeat.o(123900);
  }
  
  public String name()
  {
    return "plugin-trafficmonitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor
 * JD-Core Version:    0.7.0.1
 */