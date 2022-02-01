package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public static void a(bo parambo, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().wl(parambo.field_msgId))
    {
      e.wTc.idkeyStat(957L, 0L, 1L, false);
      if (a.gH(paramInt, 8)) {
        e.wTc.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.gH(paramInt, 4)) {
        e.wTc.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.gH(paramInt, 2)) {
        e.wTc.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.gH(paramInt, 16)) {
        e.wTc.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.gH(paramInt, 1)) {
        e.wTc.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.gH(paramInt, 32)) {
        e.wTc.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.gH(paramInt, 64)) {
        e.wTc.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.gH(paramInt, 128)) {
        e.wTc.idkeyStat(957L, 8L, 1L, false);
      }
      hi localhi = new hi();
      localhi.DUK = parambo.field_msgId;
      localhi.vTL = parambo.field_talker;
      if (w.sQ(parambo.field_talker)) {}
      for (localhi.DUy = bs.bG(bi.yl(parambo.field_content), "");; localhi.DUy = parambo.field_talker)
      {
        localhi.DUz = 1;
        localhi.DUA = parambo.field_createTime;
        localhi.DUB = paramInt;
        localhi.ndj = 1;
        localhi.DUC = 0L;
        localhi.DUD = parambo.field_msgSvrId;
        localhi.DUL = 0;
        localhi.DUH = paramDouble;
        localhi.DUI = 1;
        c localc = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.vEb.bindLong(1, localhi.DUK);
        localc.vEb.bindString(2, localhi.vTL);
        localc.vEb.bindString(3, localhi.DUy);
        localc.vEb.bindLong(4, localhi.DUz);
        localc.vEb.bindLong(5, localhi.DUA);
        localc.vEb.bindLong(6, localhi.DUB);
        localc.vEb.bindLong(7, localhi.ndj);
        localc.vEb.bindLong(8, localhi.DUC);
        localc.vEb.bindLong(9, localhi.DUD);
        localc.vEb.bindLong(10, localhi.DUL);
        localc.vEb.bindLong(11, localhi.DUG);
        localc.vEb.bindDouble(12, localhi.DUH);
        localc.vEb.bindLong(13, localhi.DUI);
        localc.vEb.execute();
        ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(parambo.field_msgId), parambo.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localhi.DUA, 1, localhi);
        if (w.sQ(parambo.field_talker)) {
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().ij(localhi.vTL, "@all");
        }
        ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().ij(parambo.field_talker, localhi.DUy);
        AppMethodBeat.o(87852);
        return;
      }
    }
    ac.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(parambo.field_msgId), parambo.field_talker, Integer.valueOf(1) });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().m(parambo.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.b
 * JD-Core Version:    0.7.0.1
 */