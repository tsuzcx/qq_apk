package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.wallet_core.d.g;

final class WalletBalanceFetchPwdInputUI$2
  implements o.c
{
  WalletBalanceFetchPwdInputUI$2(WalletBalanceFetchPwdInputUI paramWalletBalanceFetchPwdInputUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    WalletBalanceFetchPwdInputUI.a(this.qgp).dismiss();
    if (this.qgp.cNj() != null) {
      this.qgp.cNk().m(new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI.2
 * JD-Core Version:    0.7.0.1
 */