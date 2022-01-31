package com.tencent.mm.plugin.priority.b.a;

import android.net.TrafficStats;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.b.d;
import com.tencent.mm.sdk.platformtools.ab;

final class a$b
  extends com.tencent.mm.plugin.priority.b.b.a
{
  private a$b(a parama) {}
  
  public final String getName()
  {
    return "Priority.CheckNetworkNetStatTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(54906);
    long l1 = TrafficStats.getUidRxBytes(this.ptF.uid);
    long l2 = TrafficStats.getUidTxBytes(this.ptF.uid);
    long l3 = l1 - this.ptF.ptD + (l2 - this.ptF.ptE);
    if (l3 <= 20480L)
    {
      this.ptF.ptC = false;
      this.ptF.start();
      AppMethodBeat.o(54906);
      return;
    }
    ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", new Object[] { Long.valueOf(l3) });
    this.ptF.ptD = l1;
    this.ptF.ptE = l2;
    ((PluginPriority)g.G(PluginPriority.class)).getPriorityTaskRunner().b(new b(this.ptF));
    AppMethodBeat.o(54906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */