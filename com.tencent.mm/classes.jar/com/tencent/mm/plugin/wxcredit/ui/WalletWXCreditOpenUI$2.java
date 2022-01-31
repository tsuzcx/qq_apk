package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.e;

final class WalletWXCreditOpenUI$2
  implements View.OnClickListener
{
  WalletWXCreditOpenUI$2(WalletWXCreditOpenUI paramWalletWXCreditOpenUI) {}
  
  public final void onClick(View paramView)
  {
    e.a(this.rRU, WalletWXCreditOpenUI.b(this.rRU).field_bankcardType, WalletWXCreditOpenUI.b(this.rRU).field_bankName, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI.2
 * JD-Core Version:    0.7.0.1
 */