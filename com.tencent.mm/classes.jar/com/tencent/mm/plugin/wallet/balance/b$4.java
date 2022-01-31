package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.d.f;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.n;

final class b$4
  extends g
{
  b$4(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45205);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof f))
      {
        paramString = (f)paramm;
        if (paramString.isPaySuccess) {
          b.s(this.tLW).putParcelable("key_orders", paramString.tVr);
        }
        a.j(this.hwZ, b.t(this.tLW));
        AppMethodBeat.o(45205);
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
        paramm = paramString.plg;
        if (paramm != null) {
          b.u(this.tLW).putParcelable("key_realname_guide_helper", paramm);
        }
        b.v(this.tLW).putString("kreq_token", paramString.getToken());
        AppMethodBeat.o(45205);
        return true;
      }
    }
    AppMethodBeat.o(45205);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45206);
    paramVarArgs = (u)paramVarArgs[1];
    if ((paramVarArgs != null) && (paramVarArgs.pVo != null)) {
      paramVarArgs.pVo.cCD = 21;
    }
    Orders localOrders = (Orders)b.w(this.tLW).getParcelable("key_orders");
    switch (this.tLW.mEJ.getInt("key_pay_flag", 0))
    {
    default: 
      AppMethodBeat.o(45206);
      return false;
    case 1: 
      paramVarArgs.flag = "1";
    }
    for (;;)
    {
      this.AXB.a(new f(paramVarArgs, localOrders), true, 1);
      AppMethodBeat.o(45206);
      return true;
      if (!this.tLW.cWe())
      {
        paramVarArgs.flag = "2";
      }
      else
      {
        paramVarArgs.flag = "5";
        continue;
        if (!this.tLW.cWe()) {
          paramVarArgs.flag = "3";
        } else {
          paramVarArgs.flag = "6";
        }
      }
    }
  }
  
  public final boolean y(Object... paramVarArgs)
  {
    AppMethodBeat.i(45207);
    paramVarArgs = (Orders)b.x(this.tLW).getParcelable("key_orders");
    Authen localAuthen = (Authen)b.y(this.tLW).getParcelable("key_authen");
    this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
    AppMethodBeat.o(45207);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.4
 * JD-Core Version:    0.7.0.1
 */