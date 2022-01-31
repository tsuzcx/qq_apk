package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public final class m
  implements s.a
{
  c opW;
  
  public m()
  {
    AppMethodBeat.i(43378);
    this.opW = new m.1(this);
    a.ymk.c(this.opW);
    k.bYF();
    k.bYG().a(this);
    AppMethodBeat.o(43378);
  }
  
  private static void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(43379);
    vv localvv = new vv();
    localvv.cNa.cNc = paramInt;
    localvv.cNa.action = 4;
    localvv.cNa.content = paramString;
    a.ymk.l(localvv);
    AppMethodBeat.o(43379);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(43380);
    if (paramc.plW == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.pme.ujl != null) && (paramc.pme.ujl.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.pme.ujl.get(0);
        aU(0, ah.getContext().getString(2131305713, new Object[] { e.e(paramc.kNS, paramc.ppp) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43380);
      return false;
      aU(9, ah.getContext().getString(2131305711));
      continue;
      if (paramc.plW == 8) {
        aU(6, ah.getContext().getString(2131305711));
      } else if (paramc.plW == 5) {
        aU(7, bo.bf(((s.e)paramc).pma, ""));
      } else if (paramc.plW == 4) {
        aU(8, ah.getContext().getString(2131305712));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */