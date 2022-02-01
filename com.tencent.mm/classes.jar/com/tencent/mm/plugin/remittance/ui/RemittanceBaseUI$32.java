package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RemittanceBaseUI$32
  implements View.OnClickListener
{
  RemittanceBaseUI$32(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67984);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.yqW.hideTenpayKB();
    RemittanceBaseUI.dMT();
    a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.32
 * JD-Core Version:    0.7.0.1
 */