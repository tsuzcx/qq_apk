package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class WalletLqtPlanAddUI$1
  implements Runnable
{
  WalletLqtPlanAddUI$1(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(68833);
    WalletFormView localWalletFormView = WalletLqtPlanAddUI.a(this.CCt);
    if (localWalletFormView.LAy != null)
    {
      localWalletFormView.LAy.setFocusable(true);
      localWalletFormView.LAy.requestFocus();
    }
    AppMethodBeat.o(68833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.1
 * JD-Core Version:    0.7.0.1
 */