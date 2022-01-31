package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$3
  extends g
{
  b$3(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
        b.l(this.qfj).putString("kreq_token", paramString.token);
        if (paramString.qno) {
          b.m(this.qfj).putParcelable("key_orders", paramString.qmc);
        }
      }
      if (this.qfj.c(this.gfb, null))
      {
        this.wBd.a(new y(b.n(this.qfj), 13), true, 1);
        return true;
      }
      this.qfj.a(this.gfb, 0, b.o(this.qfj));
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    Authen localAuthen = (Authen)paramVarArgs[0];
    paramVarArgs = (Orders)paramVarArgs[1];
    switch (b.p(this.qfj).getInt("key_pay_flag", 0))
    {
    default: 
      return false;
    case 1: 
      if (!this.qfj.bXd()) {
        localAuthen.bcw = 1;
      }
      break;
    }
    for (;;)
    {
      b.q(this.qfj).putParcelable("key_authen", localAuthen);
      this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
      return true;
      localAuthen.bcw = 4;
      continue;
      if (!this.qfj.bXd())
      {
        localAuthen.bcw = 2;
      }
      else
      {
        localAuthen.bcw = 5;
        continue;
        if (!this.qfj.bXd()) {
          localAuthen.bcw = 3;
        } else {
          localAuthen.bcw = 6;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.3
 * JD-Core Version:    0.7.0.1
 */