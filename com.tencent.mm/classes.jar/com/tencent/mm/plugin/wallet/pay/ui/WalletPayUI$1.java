package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletPayUI$1
  implements Runnable
{
  WalletPayUI$1(WalletPayUI paramWalletPayUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(46034);
    ab.i(this.tXq.TAG, "auto reset create flag");
    WalletPayUI.Pt();
    AppMethodBeat.o(46034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.1
 * JD-Core Version:    0.7.0.1
 */