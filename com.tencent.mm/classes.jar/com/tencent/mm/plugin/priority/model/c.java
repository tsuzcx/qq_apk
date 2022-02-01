package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, ho paramho)
  {
    AppMethodBeat.i(87810);
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    Object localObject2 = b.a.qzF;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (!com.tencent.mm.util.c.fSf())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (!com.tencent.mm.util.c.fSg()) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87810);
      return;
    }
    localObject1 = az.iW(ak.getContext());
    int j;
    int k;
    label107:
    int m;
    label123:
    int i;
    if (x.wb(paramho.FSq))
    {
      j = 1;
      if (!a.avJ(paramho.FSq)) {
        break label532;
      }
      k = 1;
      if (j != 1) {
        break label538;
      }
      m = r.zC(paramho.FSq);
      localObject2 = ((l)g.ab(l.class)).azF().BH(paramho.FSq);
      if (j != 1) {
        break label550;
      }
      if (!com.tencent.mm.contact.c.lO(((aw)localObject2).field_type)) {
        break label544;
      }
      i = 3;
      label168:
      if (!((l)g.ab(l.class)).azL().aVi(paramho.FSq)) {
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
      long l2 = Math.round(paramho.FSA * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().avO(paramho.FSq);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((wa)localObject2).GnY * 100.0D);
        i1 = ((wa)localObject2).uvb;
      }
      paramho = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramho.FSw), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramho.FSu), Integer.valueOf(paramInt2), Long.valueOf(ch.aDb() - paramho.FSt), Long.valueOf(paramho.FSx), paramho.FSy, Integer.valueOf(j), Integer.valueOf(k), paramho.FSq, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramho.FSB), paramho.FSr, Long.valueOf(paramLong), Integer.valueOf(paramho.FSs), paramho.Id, Long.valueOf(l1), Integer.valueOf(i1), paramho.FSC });
      ae.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramho });
      e.ywz.kvStat(18569, paramho);
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
      if (((an)localObject2).adx()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, hp paramhp)
  {
    AppMethodBeat.i(87809);
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    Object localObject2 = b.a.qzE;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (!com.tencent.mm.util.c.fSf())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (!com.tencent.mm.util.c.fSg()) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87809);
      return;
    }
    localObject1 = az.iW(ak.getContext());
    int j;
    int k;
    label107:
    int m;
    label123:
    int i;
    if (x.wb(paramhp.FSq))
    {
      j = 1;
      if (!a.avJ(paramhp.FSq)) {
        break label513;
      }
      k = 1;
      if (j != 1) {
        break label519;
      }
      m = r.zC(paramhp.FSq);
      localObject2 = ((l)g.ab(l.class)).azF().BH(paramhp.FSq);
      if (j != 1) {
        break label531;
      }
      if (!com.tencent.mm.contact.c.lO(((aw)localObject2).field_type)) {
        break label525;
      }
      i = 3;
      label168:
      if (!((l)g.ab(l.class)).azL().aVi(paramhp.FSq)) {
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
      long l2 = Math.round(paramhp.FSA * 100.0D);
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().avO(paramhp.FSq);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((wa)localObject2).GnY * 100.0D);
        i1 = ((wa)localObject2).uvb;
      }
      paramhp = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramhp.FSD), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject1, Integer.valueOf(paramhp.FSu), Integer.valueOf(paramInt2), Long.valueOf(ch.aDb() - paramhp.FSt), Integer.valueOf(0), Integer.valueOf(paramhp.FSE), Long.valueOf(paramhp.FSw), Integer.valueOf(j), Integer.valueOf(k), paramhp.FSq, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramhp.FSr, Integer.valueOf(paramhp.FSB), Long.valueOf(l1), Integer.valueOf(i1) });
      ae.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramhp });
      e.ywz.kvStat(16308, paramhp);
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
      if (((an)localObject2).adx()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c
 * JD-Core Version:    0.7.0.1
 */