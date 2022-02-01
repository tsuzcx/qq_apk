package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class RemittanceHKUI$1
  implements View.OnClickListener
{
  RemittanceHKUI$1(RemittanceHKUI paramRemittanceHKUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68202);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceHKUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
    if (!Util.isNullOrNil(RemittanceHKUI.a(this.Cwy))) {
      f.bn(this.Cwy.getContext(), RemittanceHKUI.a(this.Cwy));
    }
    a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceHKUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI.1
 * JD-Core Version:    0.7.0.1
 */