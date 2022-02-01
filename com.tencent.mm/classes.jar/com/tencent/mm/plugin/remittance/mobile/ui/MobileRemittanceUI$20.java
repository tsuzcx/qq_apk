package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class MobileRemittanceUI$20
  implements View.OnClickListener
{
  MobileRemittanceUI$20(MobileRemittanceUI paramMobileRemittanceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67791);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
    MobileRemittanceUI.o(this.xXk);
    MobileRemittanceUI.Oe(8);
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.20
 * JD-Core Version:    0.7.0.1
 */