package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$14
  extends b.a
{
  b$14(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45881);
    if (!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
        {
          paramString = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramm;
          b.d(this.tVh).putString("kreq_token", paramString.getToken());
          if (paramString.isPaySuccess) {
            b.e(this.tVh).putParcelable("key_orders", paramString.tVr);
          }
          paramString = paramString.plg;
          if (paramString != null) {
            b.f(this.tVh).putParcelable("key_realname_guide_helper", paramString);
          }
        }
        while (this.tVh.c(this.hwZ, null))
        {
          this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.ab(b.i(this.tVh), 13), true, 1);
          AppMethodBeat.o(45881);
          return true;
          if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.c))
          {
            paramString = (com.tencent.mm.plugin.wallet.pay.a.a.c)paramm;
            b.g(this.tVh).putString("kreq_token", paramString.getToken());
            if (paramString.isPaySuccess) {
              b.h(this.tVh).putParcelable("key_orders", paramString.tVr);
            }
          }
        }
        this.tVh.a(this.hwZ, 0, b.j(this.tVh));
        AppMethodBeat.o(45881);
        return true;
      }
      AppMethodBeat.o(45881);
      return false;
    }
    AppMethodBeat.o(45881);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45882);
    Authen localAuthen = (Authen)paramVarArgs[0];
    paramVarArgs = (Orders)paramVarArgs[1];
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + this.tVh.mEJ.getInt("key_pay_flag", 0));
    switch (this.tVh.mEJ.getInt("key_pay_flag", 0))
    {
    default: 
      AppMethodBeat.o(45882);
      return false;
    case 1: 
      if (!this.tVh.cWe()) {}
      for (localAuthen.bsY = 1;; localAuthen.bsY = 4)
      {
        this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
        AppMethodBeat.o(45882);
        return true;
      }
    case 2: 
      if (!this.tVh.cWe())
      {
        localAuthen.bsY = 2;
        if (!this.tVh.mEJ.getBoolean("key_is_changing_balance_phone_num", false)) {
          break label220;
        }
        this.AXB.a(a.b(localAuthen, paramVarArgs, this.tVh.mEJ.getBoolean("key_isbalance", false)), true, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(45882);
        return true;
        localAuthen.bsY = 5;
        break;
        label220:
        this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
      }
    }
    if (!this.tVh.cWe()) {}
    for (localAuthen.bsY = 3;; localAuthen.bsY = 6)
    {
      this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(localAuthen, paramVarArgs), true, 1);
      AppMethodBeat.o(45882);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.14
 * JD-Core Version:    0.7.0.1
 */