package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.c.a;

final class RemittanceResultNewUI$5
  implements View.OnLongClickListener
{
  RemittanceResultNewUI$5(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(45119);
    ab.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
    if (RemittanceResultNewUI.f(this.qru) == null) {
      RemittanceResultNewUI.a(this.qru, new a(this.qru.getContext()));
    }
    RemittanceResultNewUI.f(this.qru).a(paramView, this.qru, RemittanceResultNewUI.g(this.qru), RemittanceResultNewUI.h(this.qru), RemittanceResultNewUI.i(this.qru));
    RemittanceResultNewUI.c(this.qru, paramView.getId());
    AppMethodBeat.o(45119);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.5
 * JD-Core Version:    0.7.0.1
 */