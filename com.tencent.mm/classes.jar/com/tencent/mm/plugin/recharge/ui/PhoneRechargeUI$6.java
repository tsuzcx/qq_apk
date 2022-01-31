package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.sdk.platformtools.ab;

final class PhoneRechargeUI$6
  implements View.OnClickListener
{
  PhoneRechargeUI$6(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44257);
    if (!PhoneRechargeUI.a(this.pWp, PhoneRechargeUI.l(this.pWp).tTY, PhoneRechargeUI.l(this.pWp).fjP))
    {
      paramView = PhoneRechargeUI.b(this.pWp, PhoneRechargeUI.l(this.pWp).url);
      ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[] { paramView });
      PhoneRechargeUI.c(this.pWp, paramView);
    }
    AppMethodBeat.o(44257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.6
 * JD-Core Version:    0.7.0.1
 */