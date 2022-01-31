package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCheckIdentityUI$1
  implements View.OnClickListener
{
  WalletCheckIdentityUI$1(WalletCheckIdentityUI paramWalletCheckIdentityUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = WalletCheckIdentityUI.a(this.rRk).getText();
    String str = WalletCheckIdentityUI.b(this.rRk).getText();
    if (WalletCheckIdentityUI.a(this.rRk, paramView, str)) {
      this.rRk.cNk().m(new Object[] { paramView, str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI.1
 * JD-Core Version:    0.7.0.1
 */