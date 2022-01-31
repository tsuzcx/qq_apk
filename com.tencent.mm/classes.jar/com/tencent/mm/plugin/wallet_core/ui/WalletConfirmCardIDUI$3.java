package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tenpay.bankcard.TenpaySegmentEditText;

final class WalletConfirmCardIDUI$3
  implements View.OnClickListener
{
  WalletConfirmCardIDUI$3(WalletConfirmCardIDUI paramWalletConfirmCardIDUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47367);
    paramView = WalletConfirmCardIDUI.f(this.uqm).get3DesEncrptData();
    if ((paramView != null) && (paramView.equals(this.uqn))) {
      h.qsU.e(11353, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      WalletConfirmCardIDUI.g(this.uqm);
      AppMethodBeat.o(47367);
      return;
      h.qsU.e(11353, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.3
 * JD-Core Version:    0.7.0.1
 */