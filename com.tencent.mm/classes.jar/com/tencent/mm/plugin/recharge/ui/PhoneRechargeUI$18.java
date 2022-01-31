package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class PhoneRechargeUI$18
  implements View.OnClickListener
{
  PhoneRechargeUI$18(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44272);
    if (PhoneRechargeUI.f(this.pWp) != null) {
      PhoneRechargeUI.g(this.pWp);
    }
    for (;;)
    {
      PhoneRechargeUI.h(this.pWp).setVisibility(8);
      AppMethodBeat.o(44272);
      return;
      ab.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.18
 * JD-Core Version:    0.7.0.1
 */