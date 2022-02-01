package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public static void a(bu parambu, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yw(parambu.field_msgId))
    {
      e.ygI.idkeyStat(957L, 0L, 1L, false);
      if (a.gZ(paramInt, 8)) {
        e.ygI.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.gZ(paramInt, 4)) {
        e.ygI.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.gZ(paramInt, 2)) {
        e.ygI.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.gZ(paramInt, 16)) {
        e.ygI.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.gZ(paramInt, 1)) {
        e.ygI.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.gZ(paramInt, 32)) {
        e.ygI.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.gZ(paramInt, 64)) {
        e.ygI.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.gZ(paramInt, 128)) {
        e.ygI.idkeyStat(957L, 8L, 1L, false);
      }
      hp localhp = new hp();
      localhp.FAf = parambu.field_msgId;
      localhp.FzS = parambu.field_talker;
      if (w.vF(parambu.field_talker)) {}
      for (localhp.FzT = bt.bI(bj.Bk(parambu.field_content), "");; localhp.FzT = parambu.field_talker)
      {
        localhp.FzU = 1;
        localhp.FzV = parambu.field_createTime;
        localhp.FzW = paramInt;
        localhp.nDG = 1;
        localhp.FzX = 0L;
        localhp.FzY = parambu.field_msgSvrId;
        localhp.FAg = 0;
        localhp.FAc = paramDouble;
        localhp.FAd = 1;
        c localc = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.wLh.bindLong(1, localhp.FAf);
        localc.wLh.bindString(2, localhp.FzS);
        localc.wLh.bindString(3, localhp.FzT);
        localc.wLh.bindLong(4, localhp.FzU);
        localc.wLh.bindLong(5, localhp.FzV);
        localc.wLh.bindLong(6, localhp.FzW);
        localc.wLh.bindLong(7, localhp.nDG);
        localc.wLh.bindLong(8, localhp.FzX);
        localc.wLh.bindLong(9, localhp.FzY);
        localc.wLh.bindLong(10, localhp.FAg);
        localc.wLh.bindLong(11, localhp.FAb);
        localc.wLh.bindDouble(12, localhp.FAc);
        localc.wLh.bindLong(13, localhp.FAd);
        localc.wLh.execute();
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(parambu.field_msgId), parambu.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localhp.FzV, 1, localhp);
        if (w.vF(parambu.field_talker)) {
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().ix(localhp.FzS, "@all");
        }
        ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().ix(parambu.field_talker, localhp.FzT);
        AppMethodBeat.o(87852);
        return;
      }
    }
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(parambu.field_msgId), parambu.field_talker, Integer.valueOf(1) });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().n(parambu.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.b
 * JD-Core Version:    0.7.0.1
 */