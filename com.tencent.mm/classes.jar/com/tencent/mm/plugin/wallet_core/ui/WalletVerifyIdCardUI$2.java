package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletVerifyIdCardUI$2
  implements EditHintPasswdView.a
{
  WalletVerifyIdCardUI$2(WalletVerifyIdCardUI paramWalletVerifyIdCardUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47720);
    WalletVerifyIdCardUI.c(this.uur).postDelayed(new WalletVerifyIdCardUI.2.1(this, paramBoolean), 50L);
    AppMethodBeat.o(47720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.2
 * JD-Core Version:    0.7.0.1
 */