package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.priority.b.a.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.wcdb.database.SQLiteStatement;

final class a$b
  extends com.tencent.mm.plugin.priority.b.b.a
{
  private bi cEE;
  
  public a$b(a parama, bi parambi)
  {
    this.cEE = parambi;
  }
  
  public final String getName()
  {
    return "Priority.onC2CImgOpenTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(54876);
    if (this.cEE.field_createTime <= ((PluginPriority)g.G(PluginPriority.class)).getInstallPriorityTime())
    {
      ab.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", new Object[] { h.formatTime("yyyy-MM-dd HH:mm:ss", this.cEE.field_createTime / 1000L) });
      AppMethodBeat.o(54876);
      return;
    }
    gh localgh;
    int i;
    if (((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null)
    {
      ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
      bi localbi = this.cEE;
      e.qrI.idkeyStat(957L, 10L, 1L, false);
      localgh = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().kS(localbi.field_msgId);
      if (localgh == null)
      {
        ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "This Image Sender is Me");
        e.qrI.idkeyStat(957L, 13L, 1L, false);
        AppMethodBeat.o(54876);
        return;
      }
      if (localgh.wsH > 0L)
      {
        ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(localbi.field_msgId) });
        AppMethodBeat.o(54876);
        return;
      }
      if (t.lA(localbi.field_talker)) {
        ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fK(localgh.pIB, "@all");
      }
      ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fK(localgh.pIB, localgh.wsA);
      localgh.wsH = System.currentTimeMillis();
      com.tencent.mm.plugin.priority.b.a.c localc = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
      long l1 = localbi.field_msgId;
      long l2 = localgh.wsH;
      localc.ptL.bindLong(1, l2);
      localc.ptL.bindLong(2, l1);
      ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.ptL.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
      if (localgh.jJS != 3) {
        break label394;
      }
      i = 1;
      e.qrI.idkeyStat(957L, 14L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.priority.b.c.a(2, localgh.wsH, i, localgh);
      AppMethodBeat.o(54876);
      return;
      label394:
      if (localgh.jJS == 2)
      {
        i = 3;
        e.qrI.idkeyStat(957L, 16L, 1L, false);
      }
      else if (localgh.jJS == 4)
      {
        i = 4;
        e.qrI.idkeyStat(957L, 17L, 1L, false);
      }
      else if (localgh.jJS == 5)
      {
        i = 5;
        e.qrI.idkeyStat(957L, 18L, 1L, false);
      }
      else
      {
        i = 2;
        e.qrI.idkeyStat(957L, 15L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.b
 * JD-Core Version:    0.7.0.1
 */