package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletLqtSimpleCheckPwdUI$2
  implements EditHintPasswdView.a
{
  WalletLqtSimpleCheckPwdUI$2(WalletLqtSimpleCheckPwdUI paramWalletLqtSimpleCheckPwdUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WalletLqtSimpleCheckPwdUI.a(this.qjn, new r(WalletLqtSimpleCheckPwdUI.a(this.qjn).getText(), 7, this.qjn.bTO()));
      this.qjn.a(WalletLqtSimpleCheckPwdUI.b(this.qjn), true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI.2
 * JD-Core Version:    0.7.0.1
 */