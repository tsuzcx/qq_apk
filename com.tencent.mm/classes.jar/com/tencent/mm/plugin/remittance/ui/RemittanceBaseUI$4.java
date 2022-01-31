package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class RemittanceBaseUI$4
  implements View.OnClickListener
{
  RemittanceBaseUI$4(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142142);
    f.a(this.qmk, this.qmk.mScene, RemittanceBaseUI.f(this.qmk), RemittanceBaseUI.b(this.qmk));
    if (this.qmk.mScene == 1)
    {
      h.qsU.e(12689, new Object[] { Integer.valueOf(13), Integer.valueOf(1) });
      AppMethodBeat.o(142142);
      return;
    }
    h.qsU.e(12689, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
    AppMethodBeat.o(142142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.4
 * JD-Core Version:    0.7.0.1
 */