package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.k;

final class WalletBalanceFetchUI$3
  implements e
{
  WalletBalanceFetchUI$3(WalletBalanceFetchUI paramWalletBalanceFetchUI, k paramk, ab paramab) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(45355);
    if (this.tOk.dSl()) {
      this.tOj.finish();
    }
    AppMethodBeat.o(45355);
  }
  
  public final void onEnter() {}
  
  public final void onUrlCancel()
  {
    AppMethodBeat.i(45357);
    if (this.tOk.dSl()) {
      this.tOj.finish();
    }
    AppMethodBeat.o(45357);
  }
  
  public final void onUrlOk()
  {
    AppMethodBeat.i(45356);
    if (this.tOk.dSl()) {
      WalletBalanceFetchUI.n(this.tOj);
    }
    AppMethodBeat.o(45356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.3
 * JD-Core Version:    0.7.0.1
 */