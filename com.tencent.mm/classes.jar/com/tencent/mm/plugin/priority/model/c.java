package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, ho paramho)
  {
    AppMethodBeat.i(87810);
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    Object localObject2 = b.a.qsQ;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (!com.tencent.mm.util.c.fNK())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (!com.tencent.mm.util.c.fNL()) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87810);
      return;
    }
    localObject1 = ay.iR(aj.getContext());
    int j;
    int k;
    label107:
    int m;
    label123:
    int i;
    if (w.vF(paramho.FzS))
    {
      j = 1;
      if (!a.auu(paramho.FzS)) {
        break label532;
      }
      k = 1;
      if (j != 1) {
        break label538;
      }
      m = q.yS(paramho.FzS);
      localObject2 = ((l)g.ab(l.class)).azp().Bf(paramho.FzS);
      if (j != 1) {
        break label550;
      }
      if (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type)) {
        break label544;
      }
      i = 3;
      label168:
      if (!((l)g.ab(l.class)).azv().aTH(paramho.FzS)) {
        break label570;
      }
    }
    label532:
    label538:
    label544:
    label550:
    label570:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramho.FAc * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().auz(paramho.FzS);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((vx)localObject2).FVz * 100.0D);
        i1 = ((vx)localObject2).ujD;
      }
      paramho = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramho.FzY), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramho.FzW), Integer.valueOf(paramInt2), Long.valueOf(cf.aCL() - paramho.FzV), Long.valueOf(paramho.FzZ), paramho.FAa, Integer.valueOf(j), Integer.valueOf(k), paramho.FzS, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramho.FAd), paramho.FzT, Long.valueOf(paramLong), Integer.valueOf(paramho.FzU), paramho.Id, Long.valueOf(l1), Integer.valueOf(i1), paramho.FAe });
      ad.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramho });
      e.ygI.kvStat(18569, paramho);
      AppMethodBeat.o(87810);
      return;
      j = 2;
      break;
      k = 2;
      break label107;
      m = 1;
      break label123;
      i = 4;
      break label168;
      if (((am)localObject2).adm()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, hp paramhp)
  {
    AppMethodBeat.i(87809);
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    Object localObject2 = b.a.qsP;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (!com.tencent.mm.util.c.fNK())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (!com.tencent.mm.util.c.fNL()) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87809);
      return;
    }
    localObject1 = ay.iR(aj.getContext());
    int j;
    int k;
    label107:
    int m;
    label123:
    int i;
    if (w.vF(paramhp.FzS))
    {
      j = 1;
      if (!a.auu(paramhp.FzS)) {
        break label513;
      }
      k = 1;
      if (j != 1) {
        break label519;
      }
      m = q.yS(paramhp.FzS);
      localObject2 = ((l)g.ab(l.class)).azp().Bf(paramhp.FzS);
      if (j != 1) {
        break label531;
      }
      if (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type)) {
        break label525;
      }
      i = 3;
      label168:
      if (!((l)g.ab(l.class)).azv().aTH(paramhp.FzS)) {
        break label551;
      }
    }
    label513:
    label519:
    label525:
    label531:
    label551:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramhp.FAc * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().auz(paramhp.FzS);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((vx)localObject2).FVz * 100.0D);
        i1 = ((vx)localObject2).ujD;
      }
      paramhp = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramhp.FAf), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject1, Integer.valueOf(paramhp.FzW), Integer.valueOf(paramInt2), Long.valueOf(cf.aCL() - paramhp.FzV), Integer.valueOf(0), Integer.valueOf(paramhp.FAg), Long.valueOf(paramhp.FzY), Integer.valueOf(j), Integer.valueOf(k), paramhp.FzS, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramhp.FzT, Integer.valueOf(paramhp.FAd), Long.valueOf(l1), Integer.valueOf(i1) });
      ad.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramhp });
      e.ygI.kvStat(16308, paramhp);
      AppMethodBeat.o(87809);
      return;
      j = 2;
      break;
      k = 2;
      break label107;
      m = 1;
      break label123;
      i = 4;
      break label168;
      if (((am)localObject2).adm()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c
 * JD-Core Version:    0.7.0.1
 */