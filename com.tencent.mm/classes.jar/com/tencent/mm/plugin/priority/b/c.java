package com.tencent.mm.plugin.priority.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;

public final class c
{
  public static final void a(int paramInt1, long paramLong, int paramInt2, gh paramgh)
  {
    AppMethodBeat.i(54897);
    if (!((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTX, a.pto))
    {
      AppMethodBeat.o(54897);
      return;
    }
    String str = at.gU(ah.getContext());
    int j;
    int k;
    label69:
    int m;
    label85:
    ad localad;
    int i;
    if (t.lA(paramgh.pIB))
    {
      j = 1;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.WR(paramgh.pIB)) {
        break label402;
      }
      k = 1;
      if (j != 1) {
        break label408;
      }
      m = n.nv(paramgh.pIB);
      localad = ((j)g.E(j.class)).YA().arw(paramgh.pIB);
      if (j != 1) {
        break label420;
      }
      if (!com.tencent.mm.n.a.je(localad.field_type)) {
        break label414;
      }
      i = 3;
      label130:
      if (!((j)g.E(j.class)).YF().arP(paramgh.pIB)) {
        break label440;
      }
    }
    label402:
    label408:
    label414:
    label420:
    label440:
    for (int n = 1;; n = 2)
    {
      long l = Math.round(paramgh.wsI * 100.0D);
      paramgh = String.format("%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d,%d,%s,%d", new Object[] { Long.valueOf(paramgh.wsz), Integer.valueOf(paramInt1), Long.valueOf(paramLong), str, Integer.valueOf(paramgh.wsD), Integer.valueOf(paramInt2), Long.valueOf(paramLong - paramgh.wsC), Integer.valueOf(0), Integer.valueOf(paramgh.wsG), Long.valueOf(paramgh.wsF), Integer.valueOf(j), Integer.valueOf(k), paramgh.pIB, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l), paramgh.wsA, Integer.valueOf(paramgh.wsJ) });
      ab.i("MicroMsg.Priority.PriorityReportLogic", "report16308 %s", new Object[] { paramgh });
      e.qrI.kvStat(16308, paramgh);
      AppMethodBeat.o(54897);
      return;
      j = 2;
      break;
      k = 2;
      break label69;
      m = 1;
      break label85;
      i = 4;
      break label130;
      if (localad.NY()) {}
      for (i = 1;; i = 2) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.c
 * JD-Core Version:    0.7.0.1
 */