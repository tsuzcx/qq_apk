package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zg;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public final class m
  implements s.a
{
  c vCZ;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.vCZ = new m.1(this);
    a.IvT.c(this.vCZ);
    k.dzG();
    k.dzH().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void bA(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    zg localzg = new zg();
    localzg.dPn.dPp = paramInt;
    localzg.dPn.action = 4;
    localzg.dPn.content = paramString;
    a.IvT.l(localzg);
    AppMethodBeat.o(66277);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66278);
    if (paramc.wOB == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.wOJ.DpP != null) && (paramc.wOJ.DpP.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.wOJ.DpP.get(0);
        bA(0, ak.getContext().getString(2131765933, new Object[] { f.d(paramc.phz, paramc.wSq) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      bA(9, ak.getContext().getString(2131765931));
      continue;
      if (paramc.wOB == 8) {
        bA(6, ak.getContext().getString(2131765931));
      } else if (paramc.wOB == 5) {
        bA(7, bu.bI(((s.e)paramc).wOF, ""));
      } else if (paramc.wOB == 4) {
        bA(8, ak.getContext().getString(2131765932));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */