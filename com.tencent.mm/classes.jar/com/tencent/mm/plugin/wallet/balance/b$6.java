package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

final class b$6
  extends com.tencent.mm.wallet_core.d.g
{
  b$6(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        bool1 = bool2;
        if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.e.g))
        {
          paramString = (com.tencent.mm.plugin.wallet.pay.a.e.g)paramm;
          if (paramString.qno) {
            b.C(this.qfj).putParcelable("key_orders", paramString.qmc);
          }
          this.qfj.a(this.gfb, 0, b.D(this.qfj));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[0];
    Orders localOrders = (Orders)b.E(this.qfj).getParcelable("key_orders");
    this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.e.g(paramVarArgs, localOrders), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.6
 * JD-Core Version:    0.7.0.1
 */