package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.MMScrollView.b;

final class WalletCardImportUI$1
  implements MMScrollView.b
{
  WalletCardImportUI$1(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void kD(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      y.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : " + paramBoolean);
      WalletCardImportUI.b(this.qCx).post(new WalletCardImportUI.1.1(this, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.1
 * JD-Core Version:    0.7.0.1
 */