package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.c.a;

final class RemittanceDetailUI$13
  implements View.OnLongClickListener
{
  RemittanceDetailUI$13(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(45011);
    ab.d("MicroMsg.RemittanceDetailUI", "onLongClick");
    if (RemittanceDetailUI.s(this.qpY) == null) {
      RemittanceDetailUI.a(this.qpY, new a(this.qpY.getContext()));
    }
    RemittanceDetailUI.s(this.qpY).a(paramView, this.qpY, RemittanceDetailUI.t(this.qpY), RemittanceDetailUI.u(this.qpY), RemittanceDetailUI.v(this.qpY));
    RemittanceDetailUI.c(this.qpY, paramView.getId());
    AppMethodBeat.o(45011);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.13
 * JD-Core Version:    0.7.0.1
 */