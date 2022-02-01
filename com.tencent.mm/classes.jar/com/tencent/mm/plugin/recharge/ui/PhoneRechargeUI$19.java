package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class PhoneRechargeUI$19
  implements View.OnClickListener
{
  PhoneRechargeUI$19(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67181);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (PhoneRechargeUI.f(this.xoG) != null) {
      PhoneRechargeUI.g(this.xoG);
    }
    for (;;)
    {
      PhoneRechargeUI.h(this.xoG).setVisibility(8);
      a.a(this, "com/tencent/mm/plugin/recharge/ui/PhoneRechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(67181);
      return;
      ad.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.19
 * JD-Core Version:    0.7.0.1
 */