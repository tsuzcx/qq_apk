package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletWXCreditOpenNotifyUI$2
  implements View.OnClickListener
{
  WalletWXCreditOpenNotifyUI$2(WalletWXCreditOpenNotifyUI paramWalletWXCreditOpenNotifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putParcelable("key_bankcard", this.rRR.BX.getParcelable("key_bankcard"));
    a.a(this.rRR, b.class, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI.2
 * JD-Core Version:    0.7.0.1
 */