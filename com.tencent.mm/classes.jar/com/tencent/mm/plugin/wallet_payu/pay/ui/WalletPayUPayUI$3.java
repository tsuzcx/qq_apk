package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUPayUI$3
  implements DialogInterface.OnCancelListener
{
  WalletPayUPayUI$3(WalletPayUPayUI paramWalletPayUPayUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48485);
    WalletPayUPayUI.f(this.uDn);
    WalletPayUPayUI.g(this.uDn);
    if (this.uDn.isTransparent()) {
      this.uDn.finish();
    }
    AppMethodBeat.o(48485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI.3
 * JD-Core Version:    0.7.0.1
 */