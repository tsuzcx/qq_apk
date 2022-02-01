package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.za;
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
  c vqU;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.vqU = new m.1(this);
    a.IbL.c(this.vqU);
    k.dwq();
    k.dwr().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void bA(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    za localza = new za();
    localza.dNX.dNZ = paramInt;
    localza.dNX.action = 4;
    localza.dNX.content = paramString;
    a.IbL.l(localza);
    AppMethodBeat.o(66277);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66278);
    if (paramc.wyQ == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.wyY.CYk != null) && (paramc.wyY.CYk.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.wyY.CYk.get(0);
        bA(0, aj.getContext().getString(2131765933, new Object[] { e.d(paramc.paV, paramc.wCF) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      bA(9, aj.getContext().getString(2131765931));
      continue;
      if (paramc.wyQ == 8) {
        bA(6, aj.getContext().getString(2131765931));
      } else if (paramc.wyQ == 5) {
        bA(7, bt.bI(((s.e)paramc).wyU, ""));
      } else if (paramc.wyQ == 4) {
        bA(8, aj.getContext().getString(2131765932));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */