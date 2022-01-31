package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceFetchUI$2
  implements Runnable
{
  WalletBalanceFetchUI$2(WalletBalanceFetchUI paramWalletBalanceFetchUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(45354);
    WalletBalanceFetchUI.l(this.tOj).scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(45354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.2
 * JD-Core Version:    0.7.0.1
 */