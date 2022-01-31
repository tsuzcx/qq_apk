package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pay.a.d.e;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.k;

final class b$4
  extends g
{
  b$4(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof e))
      {
        paramString = (e)paramm;
        if (paramString.qno) {
          b.r(this.qfj).putParcelable("key_orders", paramString.qmc);
        }
        a.j(this.gfb, b.s(this.qfj));
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
        paramm = paramString.mKP;
        if (paramm != null) {
          b.t(this.qfj).putParcelable("key_realname_guide_helper", paramm);
        }
        b.u(this.qfj).putString("kreq_token", paramString.token);
        return true;
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[1];
    if ((paramVarArgs != null) && (paramVarArgs.nqa != null)) {
      paramVarArgs.nqa.bUV = 21;
    }
    Orders localOrders = (Orders)b.v(this.qfj).getParcelable("key_orders");
    switch (this.qfj.kke.getInt("key_pay_flag", 0))
    {
    default: 
      return false;
    case 1: 
      paramVarArgs.flag = "1";
    }
    for (;;)
    {
      this.wBd.a(new e(paramVarArgs, localOrders), true, 1);
      return true;
      if (!this.qfj.bXd())
      {
        paramVarArgs.flag = "2";
      }
      else
      {
        paramVarArgs.flag = "5";
        continue;
        if (!this.qfj.bXd()) {
          paramVarArgs.flag = "3";
        } else {
          paramVarArgs.flag = "6";
        }
      }
    }
  }
  
  public final boolean t(Object... paramVarArgs)
  {
    paramVarArgs = (Orders)b.w(this.qfj).getParcelable("key_orders");
    Authen localAuthen = (Authen)b.x(this.qfj).getParcelable("key_authen");
    this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.4
 * JD-Core Version:    0.7.0.1
 */