package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.n.b;

final class WalletBankCardSelectUI$2
  implements n.b
{
  WalletBankCardSelectUI$2(WalletBankCardSelectUI paramWalletBankCardSelectUI) {}
  
  public final void Wl()
  {
    WalletBankCardSelectUI.a(this.qAo, false);
    this.qAo.XM();
    WalletBankCardSelectUI.a(this.qAo).ng(true);
    WalletBankCardSelectUI.a(this.qAo).setMode(0);
  }
  
  public final void Wm()
  {
    WalletBankCardSelectUI.a(this.qAo, true);
    WalletBankCardSelectUI.a(this.qAo).ng(false);
    WalletBankCardSelectUI.a(this.qAo).setMode(1);
  }
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final boolean pB(String paramString)
  {
    this.qAo.XM();
    return false;
  }
  
  public final void pC(String paramString)
  {
    y.d("WalletBankCardSelectUI", "search text: %s", new Object[] { paramString });
    WalletBankCardSelectUI.a(this.qAo).adg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.2
 * JD-Core Version:    0.7.0.1
 */