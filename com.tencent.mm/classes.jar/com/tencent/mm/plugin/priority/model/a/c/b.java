package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b
{
  public static void a(ca paramca, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HL(paramca.field_msgId))
    {
      e.Cxv.idkeyStat(957L, 0L, 1L, false);
      if (a.hL(paramInt, 8)) {
        e.Cxv.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.hL(paramInt, 4)) {
        e.Cxv.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.hL(paramInt, 2)) {
        e.Cxv.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.hL(paramInt, 16)) {
        e.Cxv.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.hL(paramInt, 1)) {
        e.Cxv.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.hL(paramInt, 32)) {
        e.Cxv.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.hL(paramInt, 64)) {
        e.Cxv.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.hL(paramInt, 128)) {
        e.Cxv.idkeyStat(957L, 8L, 1L, false);
      }
      ic localic = new ic();
      localic.KMm = paramca.field_msgId;
      localic.KLZ = paramca.field_talker;
      if (ab.Eq(paramca.field_talker)) {}
      for (localic.KMa = Util.nullAs(bp.Ks(paramca.field_content), "");; localic.KMa = paramca.field_talker)
      {
        localic.KMb = 1;
        localic.KMc = paramca.field_createTime;
        localic.KMd = paramInt;
        localic.oTW = 1;
        localic.KMe = 0L;
        localic.KMf = paramca.field_msgSvrId;
        localic.KMn = 0;
        localic.KMj = paramDouble;
        localic.KMk = 1;
        c localc = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.AYx.bindLong(1, localic.KMm);
        localc.AYx.bindString(2, localic.KLZ);
        localc.AYx.bindString(3, localic.KMa);
        localc.AYx.bindLong(4, localic.KMb);
        localc.AYx.bindLong(5, localic.KMc);
        localc.AYx.bindLong(6, localic.KMd);
        localc.AYx.bindLong(7, localic.oTW);
        localc.AYx.bindLong(8, localic.KMe);
        localc.AYx.bindLong(9, localic.KMf);
        localc.AYx.bindLong(10, localic.KMn);
        localc.AYx.bindLong(11, localic.KMi);
        localc.AYx.bindDouble(12, localic.KMj);
        localc.AYx.bindLong(13, localic.KMk);
        localc.AYx.execute();
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(paramca.field_msgId), paramca.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localic.KMc, 1, localic);
        if (ab.Eq(paramca.field_talker)) {
          ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jp(localic.KLZ, "@all");
        }
        ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jp(paramca.field_talker, localic.KMa);
        AppMethodBeat.o(87852);
        return;
      }
    }
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(paramca.field_msgId), paramca.field_talker, Integer.valueOf(1) });
    ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().m(paramca.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.b
 * JD-Core Version:    0.7.0.1
 */