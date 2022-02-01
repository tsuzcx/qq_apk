package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RemittanceResultOldUI$1
  implements View.OnClickListener
{
  RemittanceResultOldUI$1(RemittanceResultOldUI paramRemittanceResultOldUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68304);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultOldUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    RemittanceResultOldUI.a(this.ygs);
    a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultOldUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.1
 * JD-Core Version:    0.7.0.1
 */