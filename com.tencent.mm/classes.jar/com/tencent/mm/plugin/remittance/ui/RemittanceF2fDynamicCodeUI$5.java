package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RemittanceF2fDynamicCodeUI$5
  implements View.OnLongClickListener
{
  RemittanceF2fDynamicCodeUI$5(RemittanceF2fDynamicCodeUI paramRemittanceF2fDynamicCodeUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(68184);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    RemittanceF2fDynamicCodeUI.d(this.OrT);
    a.a(false, this, "com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(68184);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.5
 * JD-Core Version:    0.7.0.1
 */