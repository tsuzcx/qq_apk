package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBindDepositUI$2
  implements View.OnClickListener
{
  WalletBindDepositUI$2(WalletBindDepositUI paramWalletBindDepositUI) {}
  
  public final void onClick(View paramView)
  {
    if (WalletBindDepositUI.e(this.rRi)) {
      this.rRi.cNk().m(new Object[] { WalletBindDepositUI.a(this.rRi).getText(), WalletBindDepositUI.d(this.rRi).mOb, WalletBindDepositUI.f(this.rRi).getText(), WalletBindDepositUI.d(this.rRi).qvi, Boolean.valueOf(false) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI.2
 * JD-Core Version:    0.7.0.1
 */