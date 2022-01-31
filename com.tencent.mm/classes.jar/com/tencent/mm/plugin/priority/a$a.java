package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;

final class a$a
  extends com.tencent.mm.plugin.priority.b.b.a
{
  private long cpO;
  private boolean csk;
  private boolean eUJ;
  
  public a$a(a parama, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cpO = paramLong;
    this.csk = paramBoolean1;
    this.eUJ = paramBoolean2;
  }
  
  public final String getName()
  {
    return "Priority.onC2CImgDownloadedTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(54875);
    Object localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.cpO);
    if (((dd)localObject).field_createTime <= ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getInstallPriorityTime())
    {
      ab.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", new Object[] { com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", ((dd)localObject).field_createTime / 1000L) });
      AppMethodBeat.o(54875);
      return;
    }
    if (((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null)
    {
      ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
      boolean bool1 = this.csk;
      boolean bool2 = this.eUJ;
      if (bool1)
      {
        gh localgh = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().kS(((dd)localObject).field_msgId);
        if (localgh == null)
        {
          ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "sender img %d", new Object[] { Long.valueOf(((dd)localObject).field_msgId) });
          AppMethodBeat.o(54875);
          return;
        }
        if (localgh.jJS == 3)
        {
          ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "already auto download msgid %d", new Object[] { Long.valueOf(((dd)localObject).field_msgId) });
          AppMethodBeat.o(54875);
          return;
        }
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 20L, 1L, false);
        if (localgh != null)
        {
          long l1 = System.currentTimeMillis();
          localObject = o.ahC().gS(localgh.wsF);
          localgh.wsG = ((com.tencent.mm.at.e)localObject).fsd;
          com.tencent.mm.plugin.priority.b.c.a(1, l1, 0, localgh);
          com.tencent.mm.plugin.priority.b.a.c localc = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
          long l2 = localgh.wsz;
          int i = ((com.tencent.mm.at.e)localObject).fsd;
          localc.ptK.bindLong(1, l1);
          localc.ptK.bindLong(2, 3L);
          localc.ptK.bindLong(3, i);
          localc.ptK.bindLong(4, l2);
          ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.ptK.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
          if (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 1))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 21L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 22L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          if (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 8))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 23L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 24L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          if ((com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 2)) || (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 4)))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 25L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 26L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          if (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 16))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 27L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 28L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          if (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 32))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 29L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 30L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          if (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 64))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 33L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 34L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          if (com.tencent.mm.plugin.priority.a.a.a.ff(localgh.wsD, 128))
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 35L, 1L, false);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 36L, ((com.tencent.mm.at.e)localObject).fsd, false);
          }
          AppMethodBeat.o(54875);
          return;
        }
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 31L, 1L, false);
        AppMethodBeat.o(54875);
        return;
      }
      if (!bool2) {
        break label814;
      }
      ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(((dd)localObject).field_msgId) });
      ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().C(((dd)localObject).field_msgId, 1);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 32L, 1L, false);
      AppMethodBeat.o(54875);
      return;
      label814:
      ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(((dd)localObject).field_msgId) });
      ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().C(((dd)localObject).field_msgId, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a
 * JD-Core Version:    0.7.0.1
 */