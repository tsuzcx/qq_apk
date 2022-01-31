package com.tencent.mm.plugin.trafficmonitor;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.trafficmonitor.a.a;

public class PluginTrafficMonitor
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(114759);
    if ((paramg.SD()) && (Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT > 19))
    {
      paramg.bX.registerReceiver(new TrafficClickFlowReceiver(), new IntentFilter("com.tencent.mm.Intent.ACTION_NET_STATS"));
      e.cKP();
      e.cKQ();
    }
    AppMethodBeat.o(114759);
  }
  
  public void installed()
  {
    AppMethodBeat.i(114758);
    super.installed();
    alias(a.class);
    AppMethodBeat.o(114758);
  }
  
  public String name()
  {
    return "plugin-trafficmonitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor
 * JD-Core Version:    0.7.0.1
 */