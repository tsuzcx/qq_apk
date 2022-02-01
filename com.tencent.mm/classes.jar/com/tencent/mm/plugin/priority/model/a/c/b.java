package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public static void a(bl parambl, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().rI(parambl.field_msgId))
    {
      e.vIY.idkeyStat(957L, 0L, 1L, false);
      if (a.gA(paramInt, 8)) {
        e.vIY.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.gA(paramInt, 4)) {
        e.vIY.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.gA(paramInt, 2)) {
        e.vIY.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.gA(paramInt, 16)) {
        e.vIY.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.gA(paramInt, 1)) {
        e.vIY.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.gA(paramInt, 32)) {
        e.vIY.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.gA(paramInt, 64)) {
        e.vIY.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.gA(paramInt, 128)) {
        e.vIY.idkeyStat(957L, 8L, 1L, false);
      }
      he localhe = new he();
      localhe.CCn = parambl.field_msgId;
      localhe.uKU = parambl.field_talker;
      if (w.pF(parambl.field_talker)) {}
      for (localhe.CCb = bt.by(bi.uf(parambl.field_content), "");; localhe.CCb = parambl.field_talker)
      {
        localhe.CCc = 1;
        localhe.CCd = parambl.field_createTime;
        localhe.CCe = paramInt;
        localhe.mBi = 1;
        localhe.CCf = 0L;
        localhe.CCg = parambl.field_msgSvrId;
        localhe.CCo = 0;
        localhe.CCk = paramDouble;
        localhe.CCl = 1;
        c localc = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.uvi.bindLong(1, localhe.CCn);
        localc.uvi.bindString(2, localhe.uKU);
        localc.uvi.bindString(3, localhe.CCb);
        localc.uvi.bindLong(4, localhe.CCc);
        localc.uvi.bindLong(5, localhe.CCd);
        localc.uvi.bindLong(6, localhe.CCe);
        localc.uvi.bindLong(7, localhe.mBi);
        localc.uvi.bindLong(8, localhe.CCf);
        localc.uvi.bindLong(9, localhe.CCg);
        localc.uvi.bindLong(10, localhe.CCo);
        localc.uvi.bindLong(11, localhe.CCj);
        localc.uvi.bindDouble(12, localhe.CCk);
        localc.uvi.bindLong(13, localhe.CCl);
        localc.uvi.execute();
        ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(parambl.field_msgId), parambl.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localhe.CCd, 1, localhe);
        if (w.pF(parambl.field_talker)) {
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hQ(localhe.uKU, "@all");
        }
        ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hQ(parambl.field_talker, localhe.CCb);
        AppMethodBeat.o(87852);
        return;
      }
    }
    ad.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(parambl.field_msgId), parambl.field_talker, Integer.valueOf(1) });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().l(parambl.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.b
 * JD-Core Version:    0.7.0.1
 */