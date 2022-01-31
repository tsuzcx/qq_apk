package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;

final class RemittanceBaseUI$15
  implements View.OnClickListener
{
  RemittanceBaseUI$15(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142147);
    RemittanceBaseUI.j(this.qmk);
    this.qmk.a(this.qml.cwk, this.qmk.eaX, this.qmk.qlK, this.qml);
    if (this.qmk.mScene == 1)
    {
      h.qsU.e(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
      AppMethodBeat.o(142147);
      return;
    }
    h.qsU.e(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    AppMethodBeat.o(142147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.15
 * JD-Core Version:    0.7.0.1
 */