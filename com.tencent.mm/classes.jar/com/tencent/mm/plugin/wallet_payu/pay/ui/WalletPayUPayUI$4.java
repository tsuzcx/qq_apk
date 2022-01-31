package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

final class WalletPayUPayUI$4
  implements DialogInterface.OnClickListener
{
  WalletPayUPayUI$4(WalletPayUPayUI paramWalletPayUPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    WalletPayUPayUI.h(this.qOg).putInt("key_pay_flag", 3);
    this.qOg.I(WalletPayUPayUI.i(this.qOg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.4
 * JD-Core Version:    0.7.0.1
 */