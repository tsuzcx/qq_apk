package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public final class m
  implements s.a
{
  c tgb;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.tgb = new c() {};
    a.ESL.c(this.tgb);
    k.cYr();
    k.cYs().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void bq(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    xv localxv = new xv();
    localxv.dDY.dEa = paramInt;
    localxv.dDY.action = 4;
    localxv.dDY.content = paramString;
    a.ESL.l(localxv);
    AppMethodBeat.o(66277);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66278);
    if (paramc.ukC == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.ukK.Afx != null) && (paramc.ukK.Afx.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.ukK.Afx.get(0);
        bq(0, aj.getContext().getString(2131765933, new Object[] { e.d(paramc.nUf, paramc.uop) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      bq(9, aj.getContext().getString(2131765931));
      continue;
      if (paramc.ukC == 8) {
        bq(6, aj.getContext().getString(2131765931));
      } else if (paramc.ukC == 5) {
        bq(7, bt.by(((s.e)paramc).ukG, ""));
      } else if (paramc.ukC == 4) {
        bq(8, aj.getContext().getString(2131765932));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */