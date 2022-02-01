package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, hd paramhd)
  {
    AppMethodBeat.i(87810);
    Object localObject1 = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
    Object localObject2 = b.a.plv;
    if ((com.tencent.mm.util.c.fgW()) || (com.tencent.mm.util.c.fgX())) {}
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.a.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87810);
      return;
    }
    localObject1 = ay.iw(aj.getContext());
    int j;
    int k;
    label97:
    int m;
    label113:
    int i;
    if (w.pF(paramhd.uKU))
    {
      j = 1;
      if (!a.akp(paramhd.uKU)) {
        break label522;
      }
      k = 1;
      if (j != 1) {
        break label528;
      }
      m = q.rY(paramhd.uKU);
      localObject2 = ((k)g.ab(k.class)).apM().aHY(paramhd.uKU);
      if (j != 1) {
        break label540;
      }
      if (!com.tencent.mm.n.b.ls(((au)localObject2).field_type)) {
        break label534;
      }
      i = 3;
      label158:
      if (!((k)g.ab(k.class)).apR().aIv(paramhd.uKU)) {
        break label560;
      }
    }
    label522:
    label528:
    label534:
    label540:
    label560:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramhd.CCk * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().aku(paramhd.uKU);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((ts)localObject2).CVG * 100.0D);
        i1 = ((ts)localObject2).sdA;
      }
      paramhd = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramhd.CCg), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramhd.CCe), Integer.valueOf(paramInt2), Long.valueOf(ce.asR() - paramhd.CCd), Long.valueOf(paramhd.CCh), paramhd.CCi, Integer.valueOf(j), Integer.valueOf(k), paramhd.uKU, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramhd.CCl), paramhd.CCb, Long.valueOf(paramLong), Integer.valueOf(paramhd.CCc), paramhd.Id, Long.valueOf(l1), Integer.valueOf(i1), paramhd.CCm });
      ad.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramhd });
      e.vIY.kvStat(18569, paramhd);
      AppMethodBeat.o(87810);
      return;
      j = 2;
      break;
      k = 2;
      break label97;
      m = 1;
      break label113;
      i = 4;
      break label158;
      if (((af)localObject2).ZO()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, he paramhe)
  {
    AppMethodBeat.i(87809);
    Object localObject1 = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
    Object localObject2 = b.a.plu;
    if ((com.tencent.mm.util.c.fgW()) || (com.tencent.mm.util.c.fgX())) {}
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.a.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87809);
      return;
    }
    localObject1 = ay.iw(aj.getContext());
    int j;
    int k;
    label97:
    int m;
    label113:
    int i;
    if (w.pF(paramhe.uKU))
    {
      j = 1;
      if (!a.akp(paramhe.uKU)) {
        break label503;
      }
      k = 1;
      if (j != 1) {
        break label509;
      }
      m = q.rY(paramhe.uKU);
      localObject2 = ((k)g.ab(k.class)).apM().aHY(paramhe.uKU);
      if (j != 1) {
        break label521;
      }
      if (!com.tencent.mm.n.b.ls(((au)localObject2).field_type)) {
        break label515;
      }
      i = 3;
      label158:
      if (!((k)g.ab(k.class)).apR().aIv(paramhe.uKU)) {
        break label541;
      }
    }
    label515:
    label521:
    label541:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramhe.CCk * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().aku(paramhe.uKU);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((ts)localObject2).CVG * 100.0D);
        i1 = ((ts)localObject2).sdA;
      }
      paramhe = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramhe.CCn), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject1, Integer.valueOf(paramhe.CCe), Integer.valueOf(paramInt2), Long.valueOf(ce.asR() - paramhe.CCd), Integer.valueOf(0), Integer.valueOf(paramhe.CCo), Long.valueOf(paramhe.CCg), Integer.valueOf(j), Integer.valueOf(k), paramhe.uKU, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramhe.CCb, Integer.valueOf(paramhe.CCl), Long.valueOf(l1), Integer.valueOf(i1) });
      ad.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramhe });
      e.vIY.kvStat(16308, paramhe);
      AppMethodBeat.o(87809);
      return;
      j = 2;
      break;
      label503:
      k = 2;
      break label97;
      label509:
      m = 1;
      break label113;
      i = 4;
      break label158;
      if (((af)localObject2).ZO()) {}
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