package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;

final class RemittanceBusiUI$30
  implements View.OnClickListener
{
  RemittanceBusiUI$30(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44923);
    if (!RemittanceBusiUI.k(this.qoF)) {
      this.qoF.showCircleStWcKb();
    }
    h.qsU.e(15235, new Object[] { Integer.valueOf(6) });
    a.a(this.qoF, this.qoF.getString(2131302518), RemittanceBusiUI.l(this.qoF), this.qoF.getString(2131302520), 20, new RemittanceBusiUI.30.1(this), new RemittanceBusiUI.30.2(this));
    AppMethodBeat.o(44923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.30
 * JD-Core Version:    0.7.0.1
 */