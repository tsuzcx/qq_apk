package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginMonitor
  extends f
  implements a
{
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(84516);
    if (paramg.SD())
    {
      ab.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
      pin(new q(b.class));
    }
    AppMethodBeat.o(84516);
  }
  
  public void installed()
  {
    AppMethodBeat.i(84515);
    super.installed();
    alias(a.class);
    AppMethodBeat.o(84515);
  }
  
  public String name()
  {
    return "plugin-monitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.PluginMonitor
 * JD-Core Version:    0.7.0.1
 */