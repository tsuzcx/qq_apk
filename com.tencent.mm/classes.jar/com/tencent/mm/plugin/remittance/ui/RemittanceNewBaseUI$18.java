package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;

final class RemittanceNewBaseUI$18
  implements View.OnClickListener
{
  RemittanceNewBaseUI$18(RemittanceNewBaseUI paramRemittanceNewBaseUI, v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142242);
    RemittanceNewBaseUI.r(this.qqR);
    this.qqR.a(this.qml.cwk, this.qqR.eaX, this.qqR.qlK, this.qml);
    if (this.qqR.mScene == 1)
    {
      h.qsU.e(12689, new Object[] { Integer.valueOf(12), Integer.valueOf(1) });
      AppMethodBeat.o(142242);
      return;
    }
    h.qsU.e(12689, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    AppMethodBeat.o(142242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.18
 * JD-Core Version:    0.7.0.1
 */