package com.tencent.mm.plugin.trafficmonitor;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.trafficmonitor.a.a;

public class PluginTrafficMonitor
  extends f
  implements a
{
  public void execute(g paramg)
  {
    if ((paramg.Ex()) && (Build.VERSION.SDK_INT < 28))
    {
      paramg.bT.registerReceiver(new TrafficClickFlowReceiver(), new IntentFilter("com.tencent.mm.Intent.ACTION_NET_STATS"));
      e.bOT();
      e.bOU();
    }
  }
  
  public void installed()
  {
    super.installed();
    alias(a.class);
  }
  
  public String name()
  {
    return "plugin-trafficmonitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor
 * JD-Core Version:    0.7.0.1
 */