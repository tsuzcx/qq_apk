package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class PhoneRechargeUI$17
  implements b.a
{
  PhoneRechargeUI$17(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void a(n paramn)
  {
    if (!PhoneRechargeUI.a(this.nrb, paramn.qkP, paramn.dTJ))
    {
      if (!bk.bl(paramn.url))
      {
        paramn = PhoneRechargeUI.b(this.nrb, paramn.url);
        PhoneRechargeUI.c(this.nrb, paramn);
      }
    }
    else {
      return;
    }
    if (PhoneRechargeUI.a(this.nrb, paramn))
    {
      PhoneRechargeUI.d(this.nrb, paramn.id);
      return;
    }
    y.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.17
 * JD-Core Version:    0.7.0.1
 */