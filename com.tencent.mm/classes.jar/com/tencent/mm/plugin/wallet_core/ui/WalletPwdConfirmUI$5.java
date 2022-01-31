package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WalletPwdConfirmUI$5
  implements ap.a
{
  WalletPwdConfirmUI$5(WalletPwdConfirmUI paramWalletPwdConfirmUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(47542);
    if (WalletPwdConfirmUI.c(this.usw))
    {
      WalletPwdConfirmUI.d(this.usw);
      WalletPwdConfirmUI.e(this.usw);
    }
    AppMethodBeat.o(47542);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.5
 * JD-Core Version:    0.7.0.1
 */