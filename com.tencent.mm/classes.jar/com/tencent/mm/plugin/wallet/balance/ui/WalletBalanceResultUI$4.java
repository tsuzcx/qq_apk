package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBalanceResultUI$4
  implements Runnable
{
  WalletBalanceResultUI$4(WalletBalanceResultUI paramWalletBalanceResultUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(45460);
    ab.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
    AppMethodBeat.o(45460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI.4
 * JD-Core Version:    0.7.0.1
 */