package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RemittanceResultNewUI$2
  implements View.OnClickListener
{
  RemittanceResultNewUI$2(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68280);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    RemittanceResultNewUI.a(this.ywh);
    a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceResultNewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.2
 * JD-Core Version:    0.7.0.1
 */