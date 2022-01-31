package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class PhoneRechargeUI$18
  implements View.OnClickListener
{
  PhoneRechargeUI$18(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    if (PhoneRechargeUI.f(this.nrb) != null) {
      PhoneRechargeUI.g(this.nrb);
    }
    for (;;)
    {
      PhoneRechargeUI.h(this.nrb).setVisibility(8);
      return;
      y.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.18
 * JD-Core Version:    0.7.0.1
 */