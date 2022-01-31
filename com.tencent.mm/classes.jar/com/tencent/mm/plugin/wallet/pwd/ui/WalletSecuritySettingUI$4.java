package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class WalletSecuritySettingUI$4
  implements DialogInterface.OnClickListener
{
  WalletSecuritySettingUI$4(WalletSecuritySettingUI paramWalletSecuritySettingUI, WalletSecuritySettingUI.e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46396);
    if (this.uaA.uaN.pdt == 1)
    {
      e.m(this.uaz.getContext(), this.uaA.uaN.uaJ, true);
      AppMethodBeat.o(46396);
      return;
    }
    if (this.uaA.uaN.pdt == 2) {
      e.q(this.uaA.uaN.uaK, this.uaA.uaN.uaL, 0, 1000);
    }
    AppMethodBeat.o(46396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.4
 * JD-Core Version:    0.7.0.1
 */