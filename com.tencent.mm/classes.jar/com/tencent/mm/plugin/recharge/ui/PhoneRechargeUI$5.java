package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.sdk.platformtools.ab;

final class PhoneRechargeUI$5
  implements View.OnClickListener
{
  PhoneRechargeUI$5(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44256);
    if (!PhoneRechargeUI.a(this.pWp, PhoneRechargeUI.k(this.pWp).tTY, PhoneRechargeUI.k(this.pWp).fjP))
    {
      paramView = PhoneRechargeUI.b(this.pWp, PhoneRechargeUI.k(this.pWp).url);
      ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramView });
      PhoneRechargeUI.c(this.pWp, paramView);
    }
    AppMethodBeat.o(44256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.5
 * JD-Core Version:    0.7.0.1
 */