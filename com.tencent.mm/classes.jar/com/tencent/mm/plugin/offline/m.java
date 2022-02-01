package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adr;
import com.tencent.mm.plugin.offline.a.u;
import com.tencent.mm.plugin.offline.a.u.a;
import com.tencent.mm.plugin.offline.a.u.d;
import com.tencent.mm.plugin.offline.a.u.f;
import com.tencent.mm.plugin.offline.a.u.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import java.util.List;

public final class m
  implements u.a
{
  IListener Kvi;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.Kvi = new WearOfflineLogic.1(this, f.hfK);
    this.Kvi.alive();
    k.gvj();
    k.gvk().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void cu(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    adr localadr = new adr();
    localadr.ihS.ihU = paramInt;
    localadr.ihS.action = 4;
    localadr.ihS.content = paramString;
    localadr.publish();
    AppMethodBeat.o(66277);
  }
  
  public final boolean onNotify(u.d paramd)
  {
    AppMethodBeat.i(66278);
    if (paramd.MzB == 6)
    {
      paramd = (u.g)paramd;
      if ((paramd.MzL.VGX != null) && (paramd.MzL.VGX.size() > 0))
      {
        paramd = (Orders.Commodity)paramd.MzL.VGX.get(0);
        cu(0, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_result_info, new Object[] { i.e(paramd.wZe, paramd.MEq) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      cu(9, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_error));
      continue;
      if (paramd.MzB == 8) {
        cu(6, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_error));
      } else if (paramd.MzB == 5) {
        cu(7, Util.nullAs(((u.f)paramd).MzG, ""));
      } else if (paramd.MzB == 4) {
        cu(8, MMApplicationContext.getContext().getString(a.i.wallet_wear_pay_freeze_error));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */