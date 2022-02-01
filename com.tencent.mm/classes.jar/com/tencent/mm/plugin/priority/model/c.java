package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, hh paramhh)
  {
    AppMethodBeat.i(87810);
    Object localObject1 = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
    Object localObject2 = b.a.pOR;
    if ((com.tencent.mm.util.c.fwW()) || (com.tencent.mm.util.c.fwY())) {}
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.a.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87810);
      return;
    }
    localObject1 = ax.iH(com.tencent.mm.sdk.platformtools.ai.getContext());
    int j;
    int k;
    label97:
    int m;
    label113:
    int i;
    if (w.sQ(paramhh.vTL))
    {
      j = 1;
      if (!a.apo(paramhh.vTL)) {
        break label522;
      }
      k = 1;
      if (j != 1) {
        break label528;
      }
      m = q.wb(paramhh.vTL);
      localObject2 = ((k)g.ab(k.class)).awB().aNt(paramhh.vTL);
      if (j != 1) {
        break label540;
      }
      if (!com.tencent.mm.n.b.ln(((av)localObject2).field_type)) {
        break label534;
      }
      i = 3;
      label158:
      if (!((k)g.ab(k.class)).awG().aNQ(paramhh.vTL)) {
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
      long l2 = Math.round(paramhh.DUH * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().apt(paramhh.vTL);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((uc)localObject2).Eoq * 100.0D);
        i1 = ((uc)localObject2).tlu;
      }
      paramhh = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramhh.DUD), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramhh.DUB), Integer.valueOf(paramInt2), Long.valueOf(ce.azI() - paramhh.DUA), Long.valueOf(paramhh.DUE), paramhh.DUF, Integer.valueOf(j), Integer.valueOf(k), paramhh.vTL, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramhh.DUI), paramhh.DUy, Long.valueOf(paramLong), Integer.valueOf(paramhh.DUz), paramhh.Id, Long.valueOf(l1), Integer.valueOf(i1), paramhh.DUJ });
      ac.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramhh });
      e.wTc.kvStat(18569, paramhh);
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
      if (((com.tencent.mm.storage.ai)localObject2).aaJ()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, hi paramhi)
  {
    AppMethodBeat.i(87809);
    Object localObject1 = (com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class);
    Object localObject2 = b.a.pOQ;
    if ((com.tencent.mm.util.c.fwW()) || (com.tencent.mm.util.c.fwY())) {}
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.a.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87809);
      return;
    }
    localObject1 = ax.iH(com.tencent.mm.sdk.platformtools.ai.getContext());
    int j;
    int k;
    label97:
    int m;
    label113:
    int i;
    if (w.sQ(paramhi.vTL))
    {
      j = 1;
      if (!a.apo(paramhi.vTL)) {
        break label503;
      }
      k = 1;
      if (j != 1) {
        break label509;
      }
      m = q.wb(paramhi.vTL);
      localObject2 = ((k)g.ab(k.class)).awB().aNt(paramhi.vTL);
      if (j != 1) {
        break label521;
      }
      if (!com.tencent.mm.n.b.ln(((av)localObject2).field_type)) {
        break label515;
      }
      i = 3;
      label158:
      if (!((k)g.ab(k.class)).awG().aNQ(paramhi.vTL)) {
        break label541;
      }
    }
    label515:
    label521:
    label541:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramhi.DUH * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().apt(paramhi.vTL);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((uc)localObject2).Eoq * 100.0D);
        i1 = ((uc)localObject2).tlu;
      }
      paramhi = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramhi.DUK), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject1, Integer.valueOf(paramhi.DUB), Integer.valueOf(paramInt2), Long.valueOf(ce.azI() - paramhi.DUA), Integer.valueOf(0), Integer.valueOf(paramhi.DUL), Long.valueOf(paramhi.DUD), Integer.valueOf(j), Integer.valueOf(k), paramhi.vTL, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramhi.DUy, Integer.valueOf(paramhi.DUI), Long.valueOf(l1), Integer.valueOf(i1) });
      ac.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramhi });
      e.wTc.kvStat(16308, paramhi);
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
      if (((com.tencent.mm.storage.ai)localObject2).aaJ()) {}
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