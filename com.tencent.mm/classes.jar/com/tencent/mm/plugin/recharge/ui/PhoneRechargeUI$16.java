package com.tencent.mm.plugin.recharge.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class PhoneRechargeUI$16
  implements b.a
{
  PhoneRechargeUI$16(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(44270);
    if (paramq == null)
    {
      ab.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
      AppMethodBeat.o(44270);
      return;
    }
    if (!PhoneRechargeUI.a(this.pWp, paramq.tTY, paramq.fjP))
    {
      if (!bo.isNullOrNil(paramq.url))
      {
        paramq = PhoneRechargeUI.b(this.pWp, paramq.url);
        PhoneRechargeUI.c(this.pWp, paramq);
        AppMethodBeat.o(44270);
        return;
      }
      if (PhoneRechargeUI.a(this.pWp, paramq)) {
        PhoneRechargeUI.d(this.pWp, paramq.id);
      }
    }
    AppMethodBeat.o(44270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.16
 * JD-Core Version:    0.7.0.1
 */