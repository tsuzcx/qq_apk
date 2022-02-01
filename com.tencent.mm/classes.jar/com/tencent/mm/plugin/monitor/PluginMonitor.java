package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginMonitor
  extends f
  implements a
{
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(51498);
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
      pin(new y(b.class));
    }
    AppMethodBeat.o(51498);
  }
  
  public void installed()
  {
    AppMethodBeat.i(51497);
    super.installed();
    alias(a.class);
    AppMethodBeat.o(51497);
  }
  
  public String name()
  {
    return "plugin-monitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.PluginMonitor
 * JD-Core Version:    0.7.0.1
 */