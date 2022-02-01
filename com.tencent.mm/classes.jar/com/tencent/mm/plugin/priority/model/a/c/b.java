package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.wcdb.database.SQLiteStatement;

public class b
{
  public static void a(ca paramca, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().Pf(paramca.field_msgId))
    {
      f.Iyx.idkeyStat(957L, 0L, 1L, false);
      if (a.iQ(paramInt, 8)) {
        f.Iyx.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.iQ(paramInt, 4)) {
        f.Iyx.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.iQ(paramInt, 2)) {
        f.Iyx.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.iQ(paramInt, 16)) {
        f.Iyx.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.iQ(paramInt, 1)) {
        f.Iyx.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.iQ(paramInt, 32)) {
        f.Iyx.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.iQ(paramInt, 64)) {
        f.Iyx.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.iQ(paramInt, 128)) {
        f.Iyx.idkeyStat(957L, 8L, 1L, false);
      }
      hs localhs = new hs();
      localhs.RNj = paramca.field_msgId;
      localhs.RMW = paramca.field_talker;
      if (ab.Lj(paramca.field_talker)) {}
      for (localhs.RMX = Util.nullAs(bq.RL(paramca.field_content), "");; localhs.RMX = paramca.field_talker)
      {
        localhs.RMY = 1;
        localhs.RMZ = paramca.field_createTime;
        localhs.RNa = paramInt;
        localhs.rVU = 1;
        localhs.RNb = 0L;
        localhs.RNc = paramca.field_msgSvrId;
        localhs.RNk = 0;
        localhs.RNg = paramDouble;
        localhs.RNh = 1;
        c localc = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.GSv.bindLong(1, localhs.RNj);
        localc.GSv.bindString(2, localhs.RMW);
        localc.GSv.bindString(3, localhs.RMX);
        localc.GSv.bindLong(4, localhs.RMY);
        localc.GSv.bindLong(5, localhs.RMZ);
        localc.GSv.bindLong(6, localhs.RNa);
        localc.GSv.bindLong(7, localhs.rVU);
        localc.GSv.bindLong(8, localhs.RNb);
        localc.GSv.bindLong(9, localhs.RNc);
        localc.GSv.bindLong(10, localhs.RNk);
        localc.GSv.bindLong(11, localhs.RNf);
        localc.GSv.bindDouble(12, localhs.RNg);
        localc.GSv.bindLong(13, localhs.RNh);
        localc.GSv.execute();
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(paramca.field_msgId), paramca.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localhs.RMZ, 1, localhs);
        if (ab.Lj(paramca.field_talker)) {
          ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jB(localhs.RMW, "@all");
        }
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jB(paramca.field_talker, localhs.RMX);
        AppMethodBeat.o(87852);
        return;
      }
    }
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(paramca.field_msgId), paramca.field_talker, Integer.valueOf(1) });
    ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().n(paramca.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
  
  public static void a(ca paramca, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235200);
    if (paramBoolean1)
    {
      hs localhs = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().Pg(paramca.field_msgId);
      if (localhs == null)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(paramca.field_msgId) });
        AppMethodBeat.o(235200);
        return;
      }
      if (localhs.rVU == 3)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(paramca.field_msgId) });
        AppMethodBeat.o(235200);
        return;
      }
      f.Iyx.idkeyStat(957L, 20L, 1L, false);
      if (localhs != null)
      {
        long l1 = System.currentTimeMillis();
        paramca = q.bmh().C(paramca.field_talker, localhs.RNc);
        localhs.RNk = paramca.lAW;
        com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localhs);
        c localc = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l2 = localhs.RNj;
        int i = paramca.lAW;
        localc.GSI.bindLong(1, l1);
        localc.GSI.bindLong(2, 3L);
        localc.GSI.bindLong(3, i);
        localc.GSI.bindLong(4, l2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.GSI.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
        if (a.iQ(localhs.RNa, 1))
        {
          f.Iyx.idkeyStat(957L, 21L, 1L, false);
          f.Iyx.idkeyStat(957L, 22L, paramca.lAW, false);
        }
        if (a.iQ(localhs.RNa, 8))
        {
          f.Iyx.idkeyStat(957L, 23L, 1L, false);
          f.Iyx.idkeyStat(957L, 24L, paramca.lAW, false);
        }
        if ((a.iQ(localhs.RNa, 2)) || (a.iQ(localhs.RNa, 4)))
        {
          f.Iyx.idkeyStat(957L, 25L, 1L, false);
          f.Iyx.idkeyStat(957L, 26L, paramca.lAW, false);
        }
        if (a.iQ(localhs.RNa, 16))
        {
          f.Iyx.idkeyStat(957L, 27L, 1L, false);
          f.Iyx.idkeyStat(957L, 28L, paramca.lAW, false);
        }
        if (a.iQ(localhs.RNa, 32))
        {
          f.Iyx.idkeyStat(957L, 29L, 1L, false);
          f.Iyx.idkeyStat(957L, 30L, paramca.lAW, false);
        }
        if (a.iQ(localhs.RNa, 64))
        {
          f.Iyx.idkeyStat(957L, 33L, 1L, false);
          f.Iyx.idkeyStat(957L, 34L, paramca.lAW, false);
        }
        if (a.iQ(localhs.RNa, 128))
        {
          f.Iyx.idkeyStat(957L, 35L, 1L, false);
          f.Iyx.idkeyStat(957L, 36L, paramca.lAW, false);
        }
        AppMethodBeat.o(235200);
        return;
      }
      f.Iyx.idkeyStat(957L, 31L, 1L, false);
      AppMethodBeat.o(235200);
      return;
    }
    if (paramBoolean2)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(paramca.field_msgId) });
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(paramca.field_msgId, 1);
    }
    for (;;)
    {
      f.Iyx.idkeyStat(957L, 32L, 1L, false);
      AppMethodBeat.o(235200);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(paramca.field_msgId) });
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().aa(paramca.field_msgId, 4);
    }
  }
  
  public static void aU(ca paramca)
  {
    AppMethodBeat.i(235201);
    hs localhs = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().Pg(paramca.field_msgId);
    if (localhs == null)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
      AppMethodBeat.o(235201);
      return;
    }
    if (localhs.rVU == 1) {
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().n(paramca.field_msgId, 32, 2);
    }
    AppMethodBeat.o(235201);
  }
  
  public static void aV(ca paramca)
  {
    AppMethodBeat.i(235203);
    f.Iyx.idkeyStat(957L, 10L, 1L, false);
    hs localhs = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().Pg(paramca.field_msgId);
    if (localhs == null)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
      f.Iyx.idkeyStat(957L, 13L, 1L, false);
      AppMethodBeat.o(235203);
      return;
    }
    if (localhs.RNf > 0L)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(paramca.field_msgId) });
      AppMethodBeat.o(235203);
      return;
    }
    if (ab.Lj(paramca.field_talker)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jC(localhs.RMW, "@all");
    }
    ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jC(localhs.RMW, localhs.RMX);
    localhs.RNf = System.currentTimeMillis();
    c localc = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    long l1 = paramca.field_msgId;
    long l2 = localhs.RNf;
    localc.GSJ.bindLong(1, l2);
    localc.GSJ.bindLong(2, l1);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.GSJ.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
    int i;
    if (localhs.rVU == 3)
    {
      i = 1;
      f.Iyx.idkeyStat(957L, 14L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.priority.model.c.a(2, localhs.RNf, i, localhs);
      AppMethodBeat.o(235203);
      return;
      if (localhs.rVU == 2)
      {
        i = 3;
        f.Iyx.idkeyStat(957L, 16L, 1L, false);
      }
      else if (localhs.rVU == 4)
      {
        i = 4;
        f.Iyx.idkeyStat(957L, 17L, 1L, false);
      }
      else if (localhs.rVU == 5)
      {
        i = 5;
        f.Iyx.idkeyStat(957L, 18L, 1L, false);
      }
      else
      {
        i = 2;
        f.Iyx.idkeyStat(957L, 15L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.b
 * JD-Core Version:    0.7.0.1
 */