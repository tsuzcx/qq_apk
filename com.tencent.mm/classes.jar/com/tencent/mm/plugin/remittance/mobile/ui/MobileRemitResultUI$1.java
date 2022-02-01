package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class MobileRemitResultUI$1
  implements View.OnClickListener
{
  MobileRemitResultUI$1(MobileRemitResultUI paramMobileRemitResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67742);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
    this.Cnp.eNv();
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI.1
 * JD-Core Version:    0.7.0.1
 */