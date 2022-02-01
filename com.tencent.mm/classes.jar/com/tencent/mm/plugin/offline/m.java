package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public final class m
  implements s.a
{
  c uoq;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.uoq = new c() {};
    a.GpY.c(this.uoq);
    k.dlZ();
    k.dma().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void bv(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    yg localyg = new yg();
    localyg.dBK.dBM = paramInt;
    localyg.dBK.action = 4;
    localyg.dBK.content = paramString;
    a.GpY.l(localyg);
    AppMethodBeat.o(66277);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66278);
    if (paramc.vty == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.vtG.BxR != null) && (paramc.vtG.BxR.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.vtG.BxR.get(0);
        bv(0, ai.getContext().getString(2131765933, new Object[] { e.d(paramc.oxA, paramc.vxl) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      bv(9, ai.getContext().getString(2131765931));
      continue;
      if (paramc.vty == 8) {
        bv(6, ai.getContext().getString(2131765931));
      } else if (paramc.vty == 5) {
        bv(7, bs.bG(((s.e)paramc).vtC, ""));
      } else if (paramc.vty == 4) {
        bv(8, ai.getContext().getString(2131765932));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */