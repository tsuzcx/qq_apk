package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class WalletPayUPayUI$3
  implements DialogInterface.OnCancelListener
{
  WalletPayUPayUI$3(WalletPayUPayUI paramWalletPayUPayUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    WalletPayUPayUI.f(this.qOg);
    WalletPayUPayUI.g(this.qOg);
    if (this.qOg.aSk()) {
      this.qOg.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.3
 * JD-Core Version:    0.7.0.1
 */