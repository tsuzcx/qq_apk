package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$13
  implements Runnable
{
  WalletBalanceManagerUI$13(WalletBalanceManagerUI paramWalletBalanceManagerUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(142287);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG)) {
      e.a(this.tOJ.tNM, this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
    }
    AppMethodBeat.o(142287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.13
 * JD-Core Version:    0.7.0.1
 */