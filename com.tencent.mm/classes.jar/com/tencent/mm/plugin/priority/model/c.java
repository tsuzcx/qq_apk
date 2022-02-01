package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.priority.model.c2c.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, in paramin)
  {
    AppMethodBeat.i(87810);
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLP, false))
    {
      AppMethodBeat.o(87810);
      return;
    }
    String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    int j;
    int k;
    label67:
    int m;
    label83:
    Object localObject;
    int i;
    if (au.bwE(paramin.YKk))
    {
      j = 1;
      if (!a.aRG(paramin.YKk)) {
        break label492;
      }
      k = 1;
      if (j != 1) {
        break label498;
      }
      m = v.getMembersCountByChatRoomName(paramin.YKk);
      localObject = ((n)h.ax(n.class)).bzA().JE(paramin.YKk);
      if (j != 1) {
        break label510;
      }
      if (!d.rs(((az)localObject).field_type)) {
        break label504;
      }
      i = 3;
      label128:
      if (!((n)h.ax(n.class)).bzG().bxV(paramin.YKk)) {
        break label530;
      }
    }
    label530:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramin.YKu * 100.0D);
      localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageResultStorage().aRM(paramin.YKk);
      long l1 = 0L;
      int i1 = -1;
      if (localObject != null)
      {
        l1 = Math.round(((zj)localObject).Zii * 100.0D);
        i1 = ((zj)localObject).ILB;
      }
      paramin = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramin.YKq), Integer.valueOf(paramInt1), str, Integer.valueOf(paramin.YKo), Integer.valueOf(paramInt2), Long.valueOf(cn.bDv() - paramin.YKn), Long.valueOf(paramin.YKr), paramin.YKs, Integer.valueOf(j), Integer.valueOf(k), paramin.YKk, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramin.YKv), paramin.YKl, Long.valueOf(paramLong), Integer.valueOf(paramin.YKm), paramin.Id, Long.valueOf(l1), Integer.valueOf(i1), paramin.YKw });
      Log.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramin });
      f.Ozc.kvStat(18569, paramin);
      AppMethodBeat.o(87810);
      return;
      j = 2;
      break;
      label492:
      k = 2;
      break label67;
      label498:
      m = 1;
      break label83;
      label504:
      i = 4;
      break label128;
      label510:
      if (((au)localObject).aSK()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, io paramio)
  {
    AppMethodBeat.i(87809);
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLO, false))
    {
      AppMethodBeat.o(87809);
      return;
    }
    String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    int j;
    int k;
    label67:
    int m;
    label83:
    Object localObject;
    int i;
    if (au.bwE(paramio.YKk))
    {
      j = 1;
      if (!a.aRG(paramio.YKk)) {
        break label473;
      }
      k = 1;
      if (j != 1) {
        break label479;
      }
      m = v.getMembersCountByChatRoomName(paramio.YKk);
      localObject = ((n)h.ax(n.class)).bzA().JE(paramio.YKk);
      if (j != 1) {
        break label491;
      }
      if (!d.rs(((az)localObject).field_type)) {
        break label485;
      }
      i = 3;
      label128:
      if (!((n)h.ax(n.class)).bzG().bxV(paramio.YKk)) {
        break label511;
      }
    }
    label473:
    label479:
    label485:
    label491:
    label511:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramio.YKu * 100.0D);
      localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageResultStorage().aRM(paramio.YKk);
      long l1 = 0L;
      int i1 = -1;
      if (localObject != null)
      {
        l1 = Math.round(((zj)localObject).Zii * 100.0D);
        i1 = ((zj)localObject).ILB;
      }
      paramio = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramio.YKx), Integer.valueOf(paramInt1), Long.valueOf(paramLong), str, Integer.valueOf(paramio.YKo), Integer.valueOf(paramInt2), Long.valueOf(cn.bDv() - paramio.YKn), Integer.valueOf(0), Integer.valueOf(paramio.YKy), Long.valueOf(paramio.YKq), Integer.valueOf(j), Integer.valueOf(k), paramio.YKk, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramio.YKl, Integer.valueOf(paramio.YKv), Long.valueOf(l1), Integer.valueOf(i1) });
      Log.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramio });
      f.Ozc.kvStat(16308, paramio);
      AppMethodBeat.o(87809);
      return;
      j = 2;
      break;
      k = 2;
      break label67;
      m = 1;
      break label83;
      i = 4;
      break label128;
      if (((au)localObject).aSK()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c
 * JD-Core Version:    0.7.0.1
 */