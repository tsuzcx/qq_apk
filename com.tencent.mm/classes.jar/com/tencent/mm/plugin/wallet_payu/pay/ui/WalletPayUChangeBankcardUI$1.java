package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;

final class WalletPayUChangeBankcardUI$1
  implements b.b
{
  WalletPayUChangeBankcardUI$1(WalletPayUChangeBankcardUI paramWalletPayUChangeBankcardUI) {}
  
  public final void a(String paramString1, String paramString2, FavorPayInfo paramFavorPayInfo)
  {
    AppMethodBeat.i(48461);
    WalletPayUChangeBankcardUI.a(this.uDl, paramFavorPayInfo);
    this.uDl.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(this.uDl));
    WalletPayUChangeBankcardUI.a(this.uDl, paramString1);
    WalletPayUChangeBankcardUI.b(this.uDl, paramString2);
    this.uDl.hideVKB();
    this.uDl.afb(paramString1);
    AppMethodBeat.o(48461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.1
 * JD-Core Version:    0.7.0.1
 */