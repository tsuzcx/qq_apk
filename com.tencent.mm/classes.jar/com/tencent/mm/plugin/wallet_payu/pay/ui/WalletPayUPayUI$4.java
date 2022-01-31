package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUPayUI$4
  implements DialogInterface.OnClickListener
{
  WalletPayUPayUI$4(WalletPayUPayUI paramWalletPayUPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48486);
    WalletPayUPayUI.h(this.uDn).putInt("key_pay_flag", 3);
    this.uDn.Z(WalletPayUPayUI.i(this.uDn));
    AppMethodBeat.o(48486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.4
 * JD-Core Version:    0.7.0.1
 */