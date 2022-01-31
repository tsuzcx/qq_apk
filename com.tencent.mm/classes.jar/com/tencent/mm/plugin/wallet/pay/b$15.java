package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet.pay.a.d.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$15
  extends b.a
{
  b$15(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45883);
    if (!super.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((paramm instanceof f)) || ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.d.b)))
        {
          paramString = (f)paramm;
          if (paramString.isPaySuccess) {
            b.k(this.tVh).putParcelable("key_orders", paramString.tVr);
          }
          paramString = paramString.plg;
          if (paramString != null) {
            b.l(this.tVh).putParcelable("key_realname_guide_helper", paramString);
          }
          h.qsU.e(10707, new Object[] { Integer.valueOf(1), Integer.valueOf(d.cWZ()) });
          AppMethodBeat.o(45883);
          return false;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b))
        {
          AppMethodBeat.o(45883);
          return true;
        }
      }
      AppMethodBeat.o(45883);
      return false;
    }
    AppMethodBeat.o(45883);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45884);
    paramVarArgs = (u)paramVarArgs[1];
    Orders localOrders = (Orders)b.m(this.tVh).getParcelable("key_orders");
    ab.i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + this.tVh.mEJ.getInt("key_pay_flag", 0));
    boolean bool = this.tVh.mEJ.getBoolean("key_is_changing_balance_phone_num");
    String str;
    switch (this.tVh.mEJ.getInt("key_pay_flag", 0))
    {
    default: 
      AppMethodBeat.o(45884);
      return false;
    case 1: 
      paramVarArgs.flag = "1";
      if (!bool)
      {
        if (!bo.isNullOrNil(paramVarArgs.poq))
        {
          s.cRG();
          if (s.cRH().ulT != null)
          {
            str = paramVarArgs.poq;
            s.cRG();
            if (!str.equals(s.cRH().ulT.field_bankcardType)) {}
          }
        }
      }
      else {
        this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(paramVarArgs, localOrders), true, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(45884);
        return true;
        paramVarArgs = a.a(paramVarArgs, localOrders);
        if (paramVarArgs != null) {
          this.AXB.a(paramVarArgs, true, 1);
        }
      }
    case 2: 
      if (!this.tVh.cWe())
      {
        paramVarArgs.flag = "2";
        if (!bool)
        {
          if (bo.isNullOrNil(paramVarArgs.poq)) {
            break label331;
          }
          s.cRG();
          if (s.cRH().ulT == null) {
            break label331;
          }
          str = paramVarArgs.poq;
          s.cRG();
          if (!str.equals(s.cRH().ulT.field_bankcardType)) {
            break label331;
          }
        }
        this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(paramVarArgs, localOrders), true, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(45884);
        return true;
        paramVarArgs.flag = "5";
        break;
        label331:
        paramVarArgs = a.a(paramVarArgs, localOrders);
        if (paramVarArgs != null) {
          this.AXB.a(paramVarArgs, true, 1);
        }
      }
    }
    if (!this.tVh.cWe())
    {
      paramVarArgs.flag = "3";
      if (!bool)
      {
        if (bo.isNullOrNil(paramVarArgs.poq)) {
          break label458;
        }
        s.cRG();
        if (s.cRH().ulT == null) {
          break label458;
        }
        str = paramVarArgs.poq;
        s.cRG();
        if (!str.equals(s.cRH().ulT.field_bankcardType)) {
          break label458;
        }
      }
      this.AXB.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(paramVarArgs, localOrders), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(45884);
      return true;
      paramVarArgs.flag = "6";
      break;
      label458:
      paramVarArgs = a.a(paramVarArgs, localOrders);
      if (paramVarArgs != null) {
        this.AXB.a(paramVarArgs, true, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.15
 * JD-Core Version:    0.7.0.1
 */