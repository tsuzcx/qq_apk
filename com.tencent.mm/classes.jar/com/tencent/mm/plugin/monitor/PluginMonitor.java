package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.monitor.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.a;

public class PluginMonitor
  extends f
  implements b
{
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(51498);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
      pin(new y(c.class));
    }
    paramg = k.aeZF;
    k.a(new k.a() {});
    AppMethodBeat.o(51498);
  }
  
  public void installed()
  {
    AppMethodBeat.i(51497);
    super.installed();
    alias(b.class);
    AppMethodBeat.o(51497);
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