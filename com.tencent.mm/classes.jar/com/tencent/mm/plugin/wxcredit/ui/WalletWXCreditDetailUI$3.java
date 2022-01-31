package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.e;

final class WalletWXCreditDetailUI$3
  implements View.OnClickListener
{
  WalletWXCreditDetailUI$3(WalletWXCreditDetailUI paramWalletWXCreditDetailUI) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.f.wallet_wxcredit_detail_username_tv) {
      if (WalletWXCreditDetailUI.b(this.rRL) != null) {
        e.ab(this.rRL, WalletWXCreditDetailUI.b(this.rRL).rRc.username);
      }
    }
    while ((paramView.getId() != a.f.wallet_wxcredit_detail_help_tv) || (WalletWXCreditDetailUI.b(this.rRL) == null)) {
      return;
    }
    e.l(this.rRL, WalletWXCreditDetailUI.b(this.rRL).rRb, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.3
 * JD-Core Version:    0.7.0.1
 */