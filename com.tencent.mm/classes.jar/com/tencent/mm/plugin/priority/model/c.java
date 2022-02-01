package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, ib paramib)
  {
    AppMethodBeat.i(87810);
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    Object localObject2 = b.a.rRQ;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (!com.tencent.mm.util.c.hde())
    {
      localc = com.tencent.mm.util.c.QYz;
      if (!com.tencent.mm.util.c.hdf()) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87810);
      return;
    }
    localObject1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    int j;
    int k;
    label107:
    int m;
    label123:
    int i;
    if (ab.Eq(paramib.KLZ))
    {
      j = 1;
      if (!a.aKb(paramib.KLZ)) {
        break label532;
      }
      k = 1;
      if (j != 1) {
        break label538;
      }
      m = v.Ie(paramib.KLZ);
      localObject2 = ((l)g.af(l.class)).aSN().Kn(paramib.KLZ);
      if (j != 1) {
        break label550;
      }
      if (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)) {
        break label544;
      }
      i = 3;
      label168:
      if (!((l)g.af(l.class)).aST().bkg(paramib.KLZ)) {
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
      long l2 = Math.round(paramib.KMj * 100.0D);
      localObject2 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CChatUsageResultStorage().aKg(paramib.KLZ);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((xi)localObject2).LiL * 100.0D);
        i1 = ((xi)localObject2).xNc;
      }
      paramib = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramib.KMf), Integer.valueOf(paramInt1), localObject1, Integer.valueOf(paramib.KMd), Integer.valueOf(paramInt2), Long.valueOf(cl.aWz() - paramib.KMc), Long.valueOf(paramib.KMg), paramib.KMh, Integer.valueOf(j), Integer.valueOf(k), paramib.KLZ, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramib.KMk), paramib.KMa, Long.valueOf(paramLong), Integer.valueOf(paramib.KMb), paramib.Id, Long.valueOf(l1), Integer.valueOf(i1), paramib.KMl });
      Log.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramib });
      e.Cxv.kvStat(18569, paramib);
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
      if (((as)localObject2).arA()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, ic paramic)
  {
    AppMethodBeat.i(87809);
    Object localObject1 = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    Object localObject2 = b.a.rRP;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (!com.tencent.mm.util.c.hde())
    {
      localc = com.tencent.mm.util.c.QYz;
      if (!com.tencent.mm.util.c.hdf()) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true; !((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, bool); bool = false)
    {
      AppMethodBeat.o(87809);
      return;
    }
    localObject1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    int j;
    int k;
    label107:
    int m;
    label123:
    int i;
    if (ab.Eq(paramic.KLZ))
    {
      j = 1;
      if (!a.aKb(paramic.KLZ)) {
        break label513;
      }
      k = 1;
      if (j != 1) {
        break label519;
      }
      m = v.Ie(paramic.KLZ);
      localObject2 = ((l)g.af(l.class)).aSN().Kn(paramic.KLZ);
      if (j != 1) {
        break label531;
      }
      if (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)) {
        break label525;
      }
      i = 3;
      label168:
      if (!((l)g.af(l.class)).aST().bkg(paramic.KLZ)) {
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
      long l2 = Math.round(paramic.KMj * 100.0D);
      localObject2 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CChatUsageResultStorage().aKg(paramic.KLZ);
      long l1 = 0L;
      int i1 = -1;
      if (localObject2 != null)
      {
        l1 = Math.round(((xi)localObject2).LiL * 100.0D);
        i1 = ((xi)localObject2).xNc;
      }
      paramic = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramic.KMm), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject1, Integer.valueOf(paramic.KMd), Integer.valueOf(paramInt2), Long.valueOf(cl.aWz() - paramic.KMc), Integer.valueOf(0), Integer.valueOf(paramic.KMn), Long.valueOf(paramic.KMf), Integer.valueOf(j), Integer.valueOf(k), paramic.KLZ, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramic.KMa, Integer.valueOf(paramic.KMk), Long.valueOf(l1), Integer.valueOf(i1) });
      Log.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramic });
      e.Cxv.kvStat(16308, paramic);
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
      if (((as)localObject2).arA()) {}
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