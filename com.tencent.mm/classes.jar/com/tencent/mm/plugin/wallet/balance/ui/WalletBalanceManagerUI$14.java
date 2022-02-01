package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class WalletBalanceManagerUI$14
  implements Runnable
{
  WalletBalanceManagerUI$14(WalletBalanceManagerUI paramWalletBalanceManagerUI, aba paramaba) {}
  
  public final void run()
  {
    AppMethodBeat.i(68660);
    if (!Util.isNullOrNil(this.uaN.gad.gae)) {
      g.a(this.OnZ.OmT, this.uaN.gad.gae, this.uaN.gad.content, this.uaN.gad.url);
    }
    AppMethodBeat.o(68660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.14
 * JD-Core Version:    0.7.0.1
 */