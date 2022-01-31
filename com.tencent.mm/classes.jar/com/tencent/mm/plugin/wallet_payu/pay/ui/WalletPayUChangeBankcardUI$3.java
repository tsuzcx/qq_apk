package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;

final class WalletPayUChangeBankcardUI$3
  implements DialogInterface.OnCancelListener
{
  WalletPayUChangeBankcardUI$3(WalletPayUChangeBankcardUI paramWalletPayUChangeBankcardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    WalletPayUChangeBankcardUI.j(this.qOe);
    if (WalletPayUChangeBankcardUI.k(this.qOe).getVisibility() != 0) {
      WalletPayUChangeBankcardUI.l(this.qOe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.3
 * JD-Core Version:    0.7.0.1
 */