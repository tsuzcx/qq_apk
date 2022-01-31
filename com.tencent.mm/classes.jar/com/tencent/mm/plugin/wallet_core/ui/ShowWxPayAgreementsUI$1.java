package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class ShowWxPayAgreementsUI$1
  implements View.OnClickListener
{
  ShowWxPayAgreementsUI$1(ShowWxPayAgreementsUI paramShowWxPayAgreementsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47132);
    h.qsU.e(15236, new Object[] { Integer.valueOf(2) });
    this.umV.setResult(-1);
    this.umV.finish();
    AppMethodBeat.o(47132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI.1
 * JD-Core Version:    0.7.0.1
 */