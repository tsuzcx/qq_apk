package com.tencent.mm.plugin.priority.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, hr paramhr)
  {
    AppMethodBeat.i(87810);
    if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyn, false))
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
    if (ab.Lj(paramhr.RMW))
    {
      j = 1;
      if (!a.aUy(paramhr.RMW)) {
        break label492;
      }
      k = 1;
      if (j != 1) {
        break label498;
      }
      m = v.Pu(paramhr.RMW);
      localObject = ((n)h.ae(n.class)).bbL().RG(paramhr.RMW);
      if (j != 1) {
        break label510;
      }
      if (!d.rk(((ax)localObject).field_type)) {
        break label504;
      }
      i = 3;
      label128:
      if (!((n)h.ae(n.class)).bbR().bwF(paramhr.RMW)) {
        break label530;
      }
    }
    label530:
    for (int n = 1;; n = 2)
    {
      long l2 = Math.round(paramhr.RNg * 100.0D);
      localObject = ((PluginPriority)h.ag(PluginPriority.class)).getC2CChatUsageResultStorage().aUE(paramhr.RMW);
      long l1 = 0L;
      int i1 = -1;
      if (localObject != null)
      {
        l1 = Math.round(((xo)localObject).Skc * 100.0D);
        i1 = ((xo)localObject).CRl;
      }
      paramhr = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(paramhr.RNc), Integer.valueOf(paramInt1), str, Integer.valueOf(paramhr.RNa), Integer.valueOf(paramInt2), Long.valueOf(cm.bfD() - paramhr.RMZ), Long.valueOf(paramhr.RNd), paramhr.RNe, Integer.valueOf(j), Integer.valueOf(k), paramhr.RMW, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(paramhr.RNh), paramhr.RMX, Long.valueOf(paramLong), Integer.valueOf(paramhr.RMY), paramhr.Id, Long.valueOf(l1), Integer.valueOf(i1), paramhr.RNi });
      Log.i("MicroMsg.Priority.PriorityReportLogic", "report18569File %s", new Object[] { paramhr });
      f.Iyx.kvStat(18569, paramhr);
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
      if (((as)localObject).ayh()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
  
  public static final void a(int paramInt1, long paramLong, int paramInt2, hs paramhs)
  {
    AppMethodBeat.i(87809);
    if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vym, false))
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
    if (ab.Lj(paramhs.RMW))
    {
      j = 1;
      if (!a.aUy(paramhs.RMW)) {
        break label473;
      }
      k = 1;
      if (j != 1) {
        break label479;
      }
      m = v.Pu(paramhs.RMW);
      localObject = ((n)h.ae(n.class)).bbL().RG(paramhs.RMW);
      if (j != 1) {
        break label491;
      }
      if (!d.rk(((ax)localObject).field_type)) {
        break label485;
      }
      i = 3;
      label128:
      if (!((n)h.ae(n.class)).bbR().bwF(paramhs.RMW)) {
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
      long l2 = Math.round(paramhs.RNg * 100.0D);
      localObject = ((PluginPriority)h.ag(PluginPriority.class)).getC2CChatUsageResultStorage().aUE(paramhs.RMW);
      long l1 = 0L;
      int i1 = -1;
      if (localObject != null)
      {
        l1 = Math.round(((xo)localObject).Skc * 100.0D);
        i1 = ((xo)localObject).CRl;
      }
      paramhs = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d,%s,%s", new Object[] { Long.valueOf(paramhs.RNj), Integer.valueOf(paramInt1), Long.valueOf(paramLong), str, Integer.valueOf(paramhs.RNa), Integer.valueOf(paramInt2), Long.valueOf(cm.bfD() - paramhs.RMZ), Integer.valueOf(0), Integer.valueOf(paramhs.RNk), Long.valueOf(paramhs.RNc), Integer.valueOf(j), Integer.valueOf(k), paramhs.RMW, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), paramhs.RMX, Integer.valueOf(paramhs.RNh), Long.valueOf(l1), Integer.valueOf(i1) });
      Log.i("MicroMsg.Priority.PriorityReportLogic", "report16308Img %s", new Object[] { paramhs });
      f.Iyx.kvStat(16308, paramhs);
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
      if (((as)localObject).ayh()) {}
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