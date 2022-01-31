package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBindDepositUI$1
  implements View.OnClickListener
{
  WalletBindDepositUI$1(WalletBindDepositUI paramWalletBindDepositUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = WalletBindDepositUI.a(this.rRi).getText();
    if (bk.bl(paramView)) {
      return;
    }
    if (WalletBindDepositUI.b(this.rRi))
    {
      this.rRi.cNk().t(new Object[] { paramView });
      WalletBindDepositUI.c(this.rRi);
      return;
    }
    paramView = new Bundle();
    paramView.putInt("key_support_bankcard", 1);
    paramView.putString("key_bank_type", WalletBindDepositUI.d(this.rRi).mOb);
    paramView.putInt("key_bankcard_type", 1);
    a.aj(this.rRi).a(this.rRi, WalletCardSelectUI.class, paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI.1
 * JD-Core Version:    0.7.0.1
 */