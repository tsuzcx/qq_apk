package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class ShowWxPayAgreementsUI$2
  implements View.OnClickListener
{
  ShowWxPayAgreementsUI$2(ShowWxPayAgreementsUI paramShowWxPayAgreementsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47133);
    h.qsU.e(15236, new Object[] { Integer.valueOf(3) });
    this.umV.finish();
    AppMethodBeat.o(47133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI.2
 * JD-Core Version:    0.7.0.1
 */