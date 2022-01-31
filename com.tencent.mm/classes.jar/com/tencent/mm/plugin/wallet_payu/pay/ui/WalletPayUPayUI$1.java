package com.tencent.mm.plugin.wallet_payu.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.utils.d;

final class WalletPayUPayUI$1
  implements b.b
{
  WalletPayUPayUI$1(WalletPayUPayUI paramWalletPayUPayUI) {}
  
  public final void a(String paramString1, String paramString2, FavorPayInfo paramFavorPayInfo)
  {
    AppMethodBeat.i(48483);
    this.uDn.hideVKB();
    WalletPayUPayUI.a(this.uDn, paramString1);
    WalletPayUPayUI.b(this.uDn, paramString2);
    this.uDn.nB(false);
    d.cWY();
    AppMethodBeat.o(48483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.1
 * JD-Core Version:    0.7.0.1
 */