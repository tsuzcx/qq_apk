package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletPayUI$1
  implements Runnable
{
  WalletPayUI$1(WalletPayUI paramWalletPayUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(69386);
    ad.i(this.zRD.TAG, "auto reset create flag");
    WalletPayUI.acT();
    AppMethodBeat.o(69386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.1
 * JD-Core Version:    0.7.0.1
 */