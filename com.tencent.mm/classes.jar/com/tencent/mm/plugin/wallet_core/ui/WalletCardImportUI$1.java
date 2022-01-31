package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.ui.MMScrollView.b;

final class WalletCardImportUI$1
  implements MMScrollView.b
{
  WalletCardImportUI$1(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void nK(boolean paramBoolean)
  {
    AppMethodBeat.i(47265);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      ab.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(paramBoolean)));
      WalletCardImportUI.b(this.uph).post(new WalletCardImportUI.1.1(this, i));
      AppMethodBeat.o(47265);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.1
 * JD-Core Version:    0.7.0.1
 */