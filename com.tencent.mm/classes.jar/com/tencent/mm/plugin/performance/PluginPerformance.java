package com.tencent.mm.plugin.performance;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.plugin.report.PluginReport;

public class PluginPerformance
  extends f
  implements a
{
  public void configure(g paramg)
  {
    com.tencent.mm.ch.c.uFS = new a.1();
  }
  
  public void dependency()
  {
    dependsOn(PluginReport.class);
    dependsOn(p.class);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    alias(a.class);
  }
  
  public String toString()
  {
    return "plugin-performance";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance
 * JD-Core Version:    0.7.0.1
 */