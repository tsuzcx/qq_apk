package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

final class WalletPayUI$16
  implements DialogInterface.OnClickListener
{
  WalletPayUI$16(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.qnV.qnt.putInt("key_pay_flag", 3);
    this.qnV.I(this.qnV.qnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.16
 * JD-Core Version:    0.7.0.1
 */