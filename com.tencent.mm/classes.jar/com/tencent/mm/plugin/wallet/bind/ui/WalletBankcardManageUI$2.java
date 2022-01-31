package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.s.a;

final class WalletBankcardManageUI$2
  implements s.a
{
  WalletBankcardManageUI$2(WalletBankcardManageUI paramWalletBankcardManageUI, Runnable paramRunnable) {}
  
  public final void bOM()
  {
    AppMethodBeat.i(45762);
    this.tTl.run();
    AppMethodBeat.o(45762);
  }
  
  public final void bON()
  {
    AppMethodBeat.i(45764);
    this.tTl.run();
    AppMethodBeat.o(45764);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(45763);
    WalletBankcardManageUI.c(this.tTk).coy = false;
    AppMethodBeat.o(45763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.2
 * JD-Core Version:    0.7.0.1
 */