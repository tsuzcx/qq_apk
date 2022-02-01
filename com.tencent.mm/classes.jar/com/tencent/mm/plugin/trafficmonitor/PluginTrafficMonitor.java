package com.tencent.mm.plugin.trafficmonitor;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.trafficmonitor.a.a;

public class PluginTrafficMonitor
  extends f
  implements a
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(123901);
    if ((paramg.aIE()) && (Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT > 19))
    {
      paramg.Zw.registerReceiver(new TrafficClickFlowReceiver(), new IntentFilter("com.tencent.mm.Intent.ACTION_NET_STATS"));
      g.gsl();
      g.gsm();
    }
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