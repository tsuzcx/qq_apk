package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pay.a.e.a;
import com.tencent.mm.plugin.wallet.pay.a.e.d;
import com.tencent.mm.plugin.wallet.pay.a.e.e;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet.pay.a.e.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$15
  extends b.a
{
  b$15(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (!super.c(paramInt1, paramInt2, paramString, paramm))
    {
      if (((paramm instanceof g)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (g)paramm;
        if (paramString.qno) {
          b.m(this.qlV).putParcelable("key_orders", paramString.qmc);
        }
        paramString = paramString.mKP;
        if (paramString != null) {
          b.n(this.qlV).putParcelable("key_realname_guide_helper", paramString);
        }
        this.qlV.a(this.gfb, 0, b.o(this.qlV));
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    p localp = (p)paramVarArgs[0];
    Orders localOrders = (Orders)b.p(this.qlV).getParcelable("key_orders");
    if ((localp == null) || (localOrders == null))
    {
      y.e("MicroMsg.CgiManager", "empty verify or orders");
      paramVarArgs = null;
    }
    for (;;)
    {
      if (paramVarArgs != null) {
        this.wBd.a(paramVarArgs, true, 1);
      }
      return true;
      PayInfo localPayInfo = localp.nqa;
      paramVarArgs = "";
      if (localPayInfo != null)
      {
        y.i("MicroMsg.CgiManager", "get reqKey from payInfo");
        paramVarArgs = localPayInfo.bMX;
      }
      Object localObject = paramVarArgs;
      if (bk.bl(paramVarArgs))
      {
        y.i("MicroMsg.CgiManager", "get reqKey from orders");
        localObject = localOrders.bMX;
      }
      if (bk.bl((String)localObject))
      {
        y.i("MicroMsg.CgiManager", "empty reqKey!");
        paramVarArgs = new g(localp, localOrders);
      }
      else
      {
        if (localPayInfo != null) {
          y.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[] { localPayInfo.bMX, localOrders.bMX });
        }
        y.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", new Object[] { localObject });
        y.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
        if (((String)localObject).startsWith("sns_aa_")) {
          paramVarArgs = new a(localp, localOrders);
        } else if (((String)localObject).startsWith("sns_tf_")) {
          paramVarArgs = new e(localp, localOrders);
        } else if (((String)localObject).startsWith("sns_ff_")) {
          paramVarArgs = new com.tencent.mm.plugin.wallet.pay.a.e.b(localp, localOrders);
        } else if (((String)localObject).startsWith("ts_")) {
          paramVarArgs = new com.tencent.mm.plugin.wallet.pay.a.e.c(localp, localOrders);
        } else if (((String)localObject).startsWith("sns_")) {
          paramVarArgs = new d(localp, localOrders);
        } else if (((String)localObject).startsWith("up_")) {
          paramVarArgs = new f(localp, localOrders);
        } else {
          paramVarArgs = new g(localp, localOrders);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.15
 * JD-Core Version:    0.7.0.1
 */