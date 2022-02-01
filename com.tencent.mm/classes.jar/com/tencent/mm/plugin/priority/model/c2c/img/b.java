package com.tencent.mm.plugin.priority.model.c2c.img;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.wcdb.database.SQLiteStatement;

public class b
{
  public static void a(cc paramcc, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87852);
    if (!((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().th(paramcc.field_msgId))
    {
      f.Ozc.idkeyStat(957L, 0L, 1L, false);
      if (a.kw(paramInt, 8)) {
        f.Ozc.idkeyStat(957L, 1L, 1L, false);
      }
      if (a.kw(paramInt, 4)) {
        f.Ozc.idkeyStat(957L, 2L, 1L, false);
      }
      if (a.kw(paramInt, 2)) {
        f.Ozc.idkeyStat(957L, 3L, 1L, false);
      }
      if (a.kw(paramInt, 16)) {
        f.Ozc.idkeyStat(957L, 4L, 1L, false);
      }
      if (a.kw(paramInt, 1)) {
        f.Ozc.idkeyStat(957L, 5L, 1L, false);
      }
      if (a.kw(paramInt, 32)) {
        f.Ozc.idkeyStat(957L, 6L, 1L, false);
      }
      if (a.kw(paramInt, 64)) {
        f.Ozc.idkeyStat(957L, 7L, 1L, false);
      }
      if (a.kw(paramInt, 128)) {
        f.Ozc.idkeyStat(957L, 8L, 1L, false);
      }
      io localio = new io();
      localio.YKx = paramcc.field_msgId;
      localio.YKk = paramcc.field_talker;
      if (au.bwE(paramcc.field_talker)) {}
      for (localio.YKl = Util.nullAs(br.JJ(paramcc.field_content), "");; localio.YKl = paramcc.field_talker)
      {
        localio.YKm = 1;
        localio.YKn = paramcc.getCreateTime();
        localio.YKo = paramInt;
        localio.vhk = 1;
        localio.YKp = 0L;
        localio.YKq = paramcc.field_msgSvrId;
        localio.YKy = 0;
        localio.YKu = paramDouble;
        localio.YKv = 1;
        c localc = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        localc.MPZ.bindLong(1, localio.YKx);
        localc.MPZ.bindString(2, localio.YKk);
        localc.MPZ.bindString(3, localio.YKl);
        localc.MPZ.bindLong(4, localio.YKm);
        localc.MPZ.bindLong(5, localio.YKn);
        localc.MPZ.bindLong(6, localio.YKo);
        localc.MPZ.bindLong(7, localio.vhk);
        localc.MPZ.bindLong(8, localio.YKp);
        localc.MPZ.bindLong(9, localio.YKq);
        localc.MPZ.bindLong(10, localio.YKy);
        localc.MPZ.bindLong(11, localio.YKt);
        localc.MPZ.bindDouble(12, localio.YKu);
        localc.MPZ.bindLong(13, localio.YKv);
        localc.MPZ.execute();
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", new Object[] { Long.valueOf(paramcc.field_msgId), paramcc.field_talker, Integer.valueOf(paramInt), Integer.valueOf(1), Double.valueOf(paramDouble), Integer.valueOf(1) });
        com.tencent.mm.plugin.priority.model.c.a(3, localio.YKn, 1, localio);
        if (au.bwE(paramcc.field_talker)) {
          ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kV(localio.YKk, "@all");
        }
        ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kV(paramcc.field_talker, localio.YKl);
        AppMethodBeat.o(87852);
        return;
      }
    }
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgReceive %d %s Update Status %d", new Object[] { Long.valueOf(paramcc.field_msgId), paramcc.field_talker, Integer.valueOf(1) });
    ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().v(paramcc.field_msgId, paramInt, 1);
    AppMethodBeat.o(87852);
  }
  
  public static void a(cc paramcc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(283811);
    if (paramBoolean1)
    {
      io localio = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ti(paramcc.field_msgId);
      if (localio == null)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "sender img %d", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(283811);
        return;
      }
      if (localio.vhk == 3)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "already auto download msgid %d", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(283811);
        return;
      }
      f.Ozc.idkeyStat(957L, 20L, 1L, false);
      if (localio != null)
      {
        long l1 = System.currentTimeMillis();
        paramcc = r.bKa().G(paramcc.field_talker, localio.YKq);
        localio.YKy = paramcc.osy;
        com.tencent.mm.plugin.priority.model.c.a(1, l1, 0, localio);
        c localc = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        long l2 = localio.YKx;
        int i = paramcc.osy;
        localc.MQm.bindLong(1, l1);
        localc.MQm.bindLong(2, 3L);
        localc.MQm.bindLong(3, i);
        localc.MQm.bindLong(4, l2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndDownloadTime %d res %d %d %d", new Object[] { Integer.valueOf(localc.MQm.executeUpdateDelete()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(3) });
        if (a.kw(localio.YKo, 1))
        {
          f.Ozc.idkeyStat(957L, 21L, 1L, false);
          f.Ozc.idkeyStat(957L, 22L, paramcc.osy, false);
        }
        if (a.kw(localio.YKo, 8))
        {
          f.Ozc.idkeyStat(957L, 23L, 1L, false);
          f.Ozc.idkeyStat(957L, 24L, paramcc.osy, false);
        }
        if ((a.kw(localio.YKo, 2)) || (a.kw(localio.YKo, 4)))
        {
          f.Ozc.idkeyStat(957L, 25L, 1L, false);
          f.Ozc.idkeyStat(957L, 26L, paramcc.osy, false);
        }
        if (a.kw(localio.YKo, 16))
        {
          f.Ozc.idkeyStat(957L, 27L, 1L, false);
          f.Ozc.idkeyStat(957L, 28L, paramcc.osy, false);
        }
        if (a.kw(localio.YKo, 32))
        {
          f.Ozc.idkeyStat(957L, 29L, 1L, false);
          f.Ozc.idkeyStat(957L, 30L, paramcc.osy, false);
        }
        if (a.kw(localio.YKo, 64))
        {
          f.Ozc.idkeyStat(957L, 33L, 1L, false);
          f.Ozc.idkeyStat(957L, 34L, paramcc.osy, false);
        }
        if (a.kw(localio.YKo, 128))
        {
          f.Ozc.idkeyStat(957L, 35L, 1L, false);
          f.Ozc.idkeyStat(957L, 36L, paramcc.osy, false);
        }
        AppMethodBeat.o(283811);
        return;
      }
      f.Ozc.idkeyStat(957L, 31L, 1L, false);
      AppMethodBeat.o(283811);
      return;
    }
    if (paramBoolean2)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download cancel %d", new Object[] { Long.valueOf(paramcc.field_msgId) });
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(paramcc.field_msgId, 1);
    }
    for (;;)
    {
      f.Ozc.idkeyStat(957L, 32L, 1L, false);
      AppMethodBeat.o(283811);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "updateStatus download fail %d", new Object[] { Long.valueOf(paramcc.field_msgId) });
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ar(paramcc.field_msgId, 4);
    }
  }
  
  public static void bl(cc paramcc)
  {
    AppMethodBeat.i(283814);
    io localio = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ti(paramcc.field_msgId);
    if (localio == null)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
      AppMethodBeat.o(283814);
      return;
    }
    if (localio.vhk == 1) {
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().v(paramcc.field_msgId, 32, 2);
    }
    AppMethodBeat.o(283814);
  }
  
  public static void bm(cc paramcc)
  {
    AppMethodBeat.i(283820);
    f.Ozc.idkeyStat(957L, 10L, 1L, false);
    io localio = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().ti(paramcc.field_msgId);
    if (localio == null)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "This Image Sender is Me");
      f.Ozc.idkeyStat(957L, 13L, 1L, false);
      AppMethodBeat.o(283820);
      return;
    }
    if (localio.YKt > 0L)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgLogic", "onImgOpen img already use %d", new Object[] { Long.valueOf(paramcc.field_msgId) });
      AppMethodBeat.o(283820);
      return;
    }
    if (au.bwE(paramcc.field_talker)) {
      ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kW(localio.YKk, "@all");
    }
    ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kW(localio.YKk, localio.YKl);
    localio.YKt = System.currentTimeMillis();
    c localc = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
    long l1 = paramcc.field_msgId;
    long l2 = localio.YKt;
    localc.MQn.bindLong(1, l2);
    localc.MQn.bindLong(2, l1);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateOpenTime %d res %d %d", new Object[] { Integer.valueOf(localc.MQn.executeUpdateDelete()), Long.valueOf(l1), Long.valueOf(l2) });
    int i;
    if (localio.vhk == 3)
    {
      i = 1;
      f.Ozc.idkeyStat(957L, 14L, 1L, false);
    }
    for (;;)
    {
      com.tencent.mm.plugin.priority.model.c.a(2, localio.YKt, i, localio);
      AppMethodBeat.o(283820);
      return;
      if (localio.vhk == 2)
      {
        i = 3;
        f.Ozc.idkeyStat(957L, 16L, 1L, false);
      }
      else if (localio.vhk == 4)
      {
        i = 4;
        f.Ozc.idkeyStat(957L, 17L, 1L, false);
      }
      else if (localio.vhk == 5)
      {
        i = 5;
        f.Ozc.idkeyStat(957L, 18L, 1L, false);
      }
      else
      {
        i = 2;
        f.Ozc.idkeyStat(957L, 15L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.img.b
 * JD-Core Version:    0.7.0.1
 */