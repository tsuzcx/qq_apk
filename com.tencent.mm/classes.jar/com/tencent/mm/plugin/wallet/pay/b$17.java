package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.e.a;
import com.tencent.mm.plugin.wallet.pay.a.e.d;
import com.tencent.mm.plugin.wallet.pay.a.e.e;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet.pay.a.e.g;
import com.tencent.mm.plugin.wallet.pay.a.e.h;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$17
  extends b.a
{
  b$17(b paramb, WalletBaseUI paramWalletBaseUI, com.tencent.mm.wallet_core.d.i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45888);
    if (!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      if (((paramm instanceof j)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (j)paramm;
        if (paramString.isPaySuccess) {
          b.n(this.tVh).putParcelable("key_orders", paramString.tVr);
        }
        paramString = paramString.plg;
        if (paramString != null) {
          b.o(this.tVh).putParcelable("key_realname_guide_helper", paramString);
        }
        this.tVh.a(this.hwZ, 0, b.p(this.tVh));
        AppMethodBeat.o(45888);
        return true;
      }
      AppMethodBeat.o(45888);
      return false;
    }
    AppMethodBeat.o(45888);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45889);
    u localu = (u)paramVarArgs[0];
    Orders localOrders = (Orders)b.q(this.tVh).getParcelable("key_orders");
    if ((localu == null) || (localOrders == null))
    {
      ab.e("MicroMsg.CgiManager", "empty verify or orders");
      paramVarArgs = null;
    }
    for (;;)
    {
      if (paramVarArgs != null) {
        this.AXB.a(paramVarArgs, true, 1);
      }
      AppMethodBeat.o(45889);
      return true;
      PayInfo localPayInfo = localu.pVo;
      paramVarArgs = "";
      if (localPayInfo != null)
      {
        ab.i("MicroMsg.CgiManager", "get reqKey from payInfo");
        paramVarArgs = localPayInfo.cnI;
      }
      Object localObject = paramVarArgs;
      if (bo.isNullOrNil(paramVarArgs))
      {
        ab.i("MicroMsg.CgiManager", "get reqKey from orders");
        localObject = localOrders.cnI;
      }
      if (bo.isNullOrNil((String)localObject))
      {
        ab.i("MicroMsg.CgiManager", "empty reqKey!");
        paramVarArgs = new j(localu, localOrders);
      }
      else
      {
        if (localPayInfo != null) {
          ab.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.cnI, localOrders.cnI });
        }
        ab.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", new Object[] { localObject });
        ab.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
        if (((String)localObject).startsWith("sns_aa_")) {
          paramVarArgs = new a(localu, localOrders);
        } else if (((String)localObject).startsWith("sns_tf_")) {
          paramVarArgs = new h(localu, localOrders);
        } else if (((String)localObject).startsWith("sns_ff_")) {
          paramVarArgs = new com.tencent.mm.plugin.wallet.pay.a.e.c(localu, localOrders);
        } else if (((String)localObject).startsWith("ts_")) {
          paramVarArgs = new d(localu, localOrders);
        } else if (((String)localObject).startsWith("sns_")) {
          paramVarArgs = new f(localu, localOrders);
        } else if (((String)localObject).startsWith("up_")) {
          paramVarArgs = new com.tencent.mm.plugin.wallet.pay.a.e.i(localu, localOrders);
        } else if (((String)localObject).startsWith("seb_ff_")) {
          paramVarArgs = new e(localu, localOrders);
        } else if (((String)localObject).startsWith("tax_")) {
          paramVarArgs = new g(localu, localOrders);
        } else if (((String)localObject).startsWith("dc_")) {
          paramVarArgs = new com.tencent.mm.plugin.wallet.pay.a.e.b(localu, localOrders);
        } else {
          paramVarArgs = new j(localu, localOrders);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.17
 * JD-Core Version:    0.7.0.1
 */