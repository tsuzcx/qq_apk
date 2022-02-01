package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abu;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

public final class m
  implements s.a
{
  IListener ECh;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.ECh = new IListener() {};
    EventCenter.instance.addListener(this.ECh);
    k.fkT();
    k.fkU().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void bM(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    abu localabu = new abu();
    localabu.gbG.gbI = paramInt;
    localabu.gbG.action = 4;
    localabu.gbG.content = paramString;
    EventCenter.instance.publish(localabu);
    AppMethodBeat.o(66277);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66278);
    if (paramc.GDo == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.GDw.ORd != null) && (paramc.GDw.ORd.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.GDw.ORd.get(0);
        bM(0, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_result_info, new Object[] { g.d(paramc.tVK, paramc.GHz) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      bM(9, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_error));
      continue;
      if (paramc.GDo == 8) {
        bM(6, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_error));
      } else if (paramc.GDo == 5) {
        bM(7, Util.nullAs(((s.e)paramc).GDs, ""));
      } else if (paramc.GDo == 4) {
        bM(8, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_freeze_error));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */