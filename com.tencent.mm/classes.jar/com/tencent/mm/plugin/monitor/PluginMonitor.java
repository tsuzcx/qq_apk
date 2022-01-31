package com.tencent.mm.plugin.monitor;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.sdk.platformtools.y;

public class PluginMonitor
  extends f
  implements a
{
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.hardcoder.b.class);
  }
  
  public void execute(g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
      pin(new p(b.class));
    }
  }
  
  public void installed()
  {
    super.installed();
    alias(a.class);
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