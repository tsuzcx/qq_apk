package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class RemittanceDetailUI$14
  implements View.OnLongClickListener
{
  RemittanceDetailUI$14(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(68139);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$21", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    ae.d("MicroMsg.RemittanceDetailUI", "onLongClick");
    if (RemittanceDetailUI.s(this.yuO) == null) {
      RemittanceDetailUI.a(this.yuO, new com.tencent.mm.ui.widget.b.a(this.yuO.getContext()));
    }
    RemittanceDetailUI.s(this.yuO).a(paramView, this.yuO, RemittanceDetailUI.t(this.yuO), RemittanceDetailUI.u(this.yuO), RemittanceDetailUI.v(this.yuO));
    RemittanceDetailUI.c(this.yuO, paramView.getId());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/RemittanceDetailUI$21", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(68139);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.14
 * JD-Core Version:    0.7.0.1
 */