package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.priority.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.Calendar;

final class PluginPriority$a
  implements Runnable
{
  private PluginPriority$a(PluginPriority paramPluginPriority) {}
  
  public final void run()
  {
    AppMethodBeat.i(54867);
    long l1 = System.currentTimeMillis();
    int i = g.RL().Ru().getInt(ac.a.yLo, 0);
    if (i != 6)
    {
      ab.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(6) });
      g.RM();
      com.tencent.mm.vfs.e.deleteFile(new File(g.RL().cachePath, "MicroMsgPriority.db").getAbsolutePath());
      g.RL().Ru().set(ac.a.yLo, Integer.valueOf(6));
    }
    Object localObject = this.ptl;
    g.RM();
    PluginPriority.access$102((PluginPriority)localObject, new com.tencent.mm.plugin.priority.b.b(g.RL().cachePath));
    PluginPriority.access$202(this.ptl, PluginPriority.access$100(this.ptl).T(16777217L, 0L));
    if (PluginPriority.access$200(this.ptl) == 0L)
    {
      PluginPriority.access$202(this.ptl, System.currentTimeMillis());
      PluginPriority.access$100(this.ptl).U(16777217L, PluginPriority.access$200(this.ptl));
    }
    ab.i("MicroMsg.Priority.PluginPriority", "install priority time %s", new Object[] { com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.access$200(this.ptl) / 1000L) });
    PluginPriority.access$302(this.ptl, new c(PluginPriority.access$100(this.ptl)));
    PluginPriority.access$402(this.ptl, new com.tencent.mm.plugin.priority.b.a.d(PluginPriority.access$100(this.ptl)));
    PluginPriority.access$502(this.ptl, new com.tencent.mm.plugin.priority.b.d());
    PluginPriority.access$602(this.ptl, new com.tencent.mm.plugin.priority.b.a.b());
    PluginPriority.access$702(this.ptl, new com.tencent.mm.plugin.priority.b.a.a());
    localObject = PluginPriority.access$500(this.ptl);
    ab.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
    ((com.tencent.mm.plugin.priority.b.d)localObject).kQ(0L);
    long l3 = PluginPriority.access$100(this.ptl).T(16777218L, -1L);
    long l2 = Calendar.getInstance().get(5);
    if (l2 != l3)
    {
      l3 = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ChatImgAutoDownloadMax"), 0);
      localObject = String.format("%d,%d", new Object[] { Long.valueOf(bo.a((Long)g.RL().Ru().get(ac.a.yyI, null), 0L)), Long.valueOf(l3) });
      ab.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", new Object[] { localObject });
      com.tencent.mm.plugin.report.e.qrI.kvStat(16341, (String)localObject);
      PluginPriority.access$100(this.ptl).U(16777218L, l2);
    }
    ((j)g.E(j.class)).bPQ().a(PluginPriority.access$800(this.ptl), null);
    ab.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(54867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.PluginPriority.a
 * JD-Core Version:    0.7.0.1
 */