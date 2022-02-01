package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public static void a(bv parambv, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yV(parambv.field_msgId))
    {
      e.ywz.idkeyStat(957L, 0L, 1L, false);
      if (a.hb(paramInt, 8)) {
        e.ywz.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.hb(paramInt, 4)) {
        e.ywz.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.hb(paramInt, 2)) {
        e.ywz.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.hb(paramInt, 16)) {
        e.ywz.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.hb(paramInt, 1)) {
        e.ywz.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.hb(paramInt, 32)) {
        e.ywz.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.hb(paramInt, 64)) {
        e.ywz.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.hb(paramInt, 128)) {
        e.ywz.idkeyStat(957L, 8L, 1L, false);
      }
      hp localhp = new hp();
      localhp.FSD = parambv.field_msgId;
      localhp.FSq = parambv.field_talker;
      if (x.wb(parambv.field_talker)) {}
      for (localhp.FSr = bu.bI(bl.BM(parambv.field_content), "");; localhp.FSr = parambv.field_talker)
      {
        localhp.FSs = 1;
        localhp.FSt = parambv.field_createTime;
        localhp.FSu = paramInt;
        localhp.nJb = 1;
        localhp.FSv = 0L;
        localhp.FSw = parambv.field_msgSvrId;
        localhp.FSE = 0;
        localhp.FSA = paramDouble;
        localhp.FSB = 1;
        c localc = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.xaV.bindLong(1, localhp.FSD);
        localc.xaV.bindString(2, localhp.FSq);
        localc.xaV.bindString(3, localhp.FSr);
        localc.xaV.bindLong(4, localhp.FSs);
        localc.xaV.bindLong(5, localhp.FSt);
        localc.xaV.bindLong(6, localhp.FSu);
        localc.xaV.bindLong(7, localhp.nJb);
        localc.xaV.bindLong(8, localhp.FSv);
        localc.xaV.bindLong(9, localhp.FSw);
        localc.xaV.bindLong(10, localhp.FSE);
        localc.xaV.bindLong(11, localhp.FSz);
        localc.xaV.bindDouble(12, localhp.FSA);
        localc.xaV.bindLong(13, localhp.FSB);
        localc.xaV.execute();
        ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(parambv.field_msgId), parambv.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localhp.FSt, 1, localhp);
        if (x.wb(parambv.field_talker)) {
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iD(localhp.FSq, "@all");
        }
        ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iD(parambv.field_talker, localhp.FSr);
        AppMethodBeat.o(87852);
        return;
      }
    }
    ae.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(parambv.field_msgId), parambv.field_talker, Integer.valueOf(1) });
    ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().n(parambv.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.b
 * JD-Core Version:    0.7.0.1
 */