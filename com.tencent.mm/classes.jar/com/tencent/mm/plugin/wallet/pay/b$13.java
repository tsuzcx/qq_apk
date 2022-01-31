package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet.pay.a.d.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$13
  extends b.a
{
  b$13(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!super.c(paramInt1, paramInt2, paramString, paramm))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label141;
      }
      if ((!(paramm instanceof e)) && (!(paramm instanceof com.tencent.mm.plugin.wallet.pay.a.d.b))) {
        break label129;
      }
      paramString = (e)paramm;
      if (paramString.qno) {
        b.j(this.qlV).putParcelable("key_orders", paramString.qmc);
      }
      paramString = paramString.mKP;
      if (paramString != null) {
        b.k(this.qlV).putParcelable("key_realname_guide_helper", paramString);
      }
      h.nFQ.f(10707, new Object[] { Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.wallet_core.e.c.bXu()) });
      bool1 = false;
    }
    label129:
    do
    {
      return bool1;
      bool1 = bool2;
    } while ((paramm instanceof com.tencent.mm.plugin.wallet.pay.a.a.b));
    label141:
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (com.tencent.mm.plugin.wallet_core.model.p)paramVarArgs[1];
    Orders localOrders = (Orders)b.l(this.qlV).getParcelable("key_orders");
    y.i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + this.qlV.kke.getInt("key_pay_flag", 0));
    boolean bool = this.qlV.kke.getBoolean("key_is_changing_balance_phone_num");
    String str;
    switch (this.qlV.kke.getInt("key_pay_flag", 0))
    {
    default: 
      return false;
    case 1: 
      paramVarArgs.flag = "1";
      if (!bool)
      {
        if (!bk.bl(paramVarArgs.mOb))
        {
          com.tencent.mm.plugin.wallet.a.p.bTK();
          if (com.tencent.mm.plugin.wallet.a.p.bTL().qzj != null)
          {
            str = paramVarArgs.mOb;
            com.tencent.mm.plugin.wallet.a.p.bTK();
            if (!str.equals(com.tencent.mm.plugin.wallet.a.p.bTL().qzj.field_bankcardType)) {}
          }
        }
      }
      else {
        this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(paramVarArgs, localOrders), true, 1);
      }
      for (;;)
      {
        return true;
        paramVarArgs = a.a(paramVarArgs, localOrders);
        if (paramVarArgs != null) {
          this.wBd.a(paramVarArgs, true, 1);
        }
      }
    case 2: 
      if (!this.qlV.bXd())
      {
        paramVarArgs.flag = "2";
        if (!bool)
        {
          if (bk.bl(paramVarArgs.mOb)) {
            break label312;
          }
          com.tencent.mm.plugin.wallet.a.p.bTK();
          if (com.tencent.mm.plugin.wallet.a.p.bTL().qzj == null) {
            break label312;
          }
          str = paramVarArgs.mOb;
          com.tencent.mm.plugin.wallet.a.p.bTK();
          if (!str.equals(com.tencent.mm.plugin.wallet.a.p.bTL().qzj.field_bankcardType)) {
            break label312;
          }
        }
        this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(paramVarArgs, localOrders), true, 1);
      }
      for (;;)
      {
        return true;
        paramVarArgs.flag = "5";
        break;
        label312:
        paramVarArgs = a.a(paramVarArgs, localOrders);
        if (paramVarArgs != null) {
          this.wBd.a(paramVarArgs, true, 1);
        }
      }
    }
    if (!this.qlV.bXd())
    {
      paramVarArgs.flag = "3";
      if (!bool)
      {
        if (bk.bl(paramVarArgs.mOb)) {
          break label434;
        }
        com.tencent.mm.plugin.wallet.a.p.bTK();
        if (com.tencent.mm.plugin.wallet.a.p.bTL().qzj == null) {
          break label434;
        }
        str = paramVarArgs.mOb;
        com.tencent.mm.plugin.wallet.a.p.bTK();
        if (!str.equals(com.tencent.mm.plugin.wallet.a.p.bTL().qzj.field_bankcardType)) {
          break label434;
        }
      }
      this.wBd.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(paramVarArgs, localOrders), true, 1);
    }
    for (;;)
    {
      return true;
      paramVarArgs.flag = "6";
      break;
      label434:
      paramVarArgs = a.a(paramVarArgs, localOrders);
      if (paramVarArgs != null) {
        this.wBd.a(paramVarArgs, true, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.13
 * JD-Core Version:    0.7.0.1
 */