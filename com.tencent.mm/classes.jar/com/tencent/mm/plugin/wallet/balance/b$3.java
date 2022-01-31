package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.ab;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45203);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
      {
        paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
        b.m(this.tLW).putString("kreq_token", paramString.getToken());
        if (paramString.isPaySuccess) {
          b.n(this.tLW).putParcelable("key_orders", paramString.tVr);
        }
      }
      if (this.tLW.c(this.hwZ, null))
      {
        this.AXB.a(new ab(b.o(this.tLW), 13), true, 1);
        AppMethodBeat.o(45203);
        return true;
      }
      this.tLW.a(this.hwZ, 0, b.p(this.tLW));
      AppMethodBeat.o(45203);
      return true;
    }
    AppMethodBeat.o(45203);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45204);
    Authen localAuthen = (Authen)paramVarArgs[0];
    paramVarArgs = (Orders)paramVarArgs[1];
    switch (b.q(this.tLW).getInt("key_pay_flag", 0))
    {
    default: 
      AppMethodBeat.o(45204);
      return false;
    case 1: 
      if (!this.tLW.cWe()) {
        localAuthen.bsY = 1;
      }
      break;
    }
    for (;;)
    {
      b.r(this.tLW).putParcelable("key_authen", localAuthen);
      this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
      AppMethodBeat.o(45204);
      return true;
      localAuthen.bsY = 4;
      continue;
      if (!this.tLW.cWe())
      {
        localAuthen.bsY = 2;
      }
      else
      {
        localAuthen.bsY = 5;
        continue;
        if (!this.tLW.cWe()) {
          localAuthen.bsY = 3;
        } else {
          localAuthen.bsY = 6;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.3
 * JD-Core Version:    0.7.0.1
 */