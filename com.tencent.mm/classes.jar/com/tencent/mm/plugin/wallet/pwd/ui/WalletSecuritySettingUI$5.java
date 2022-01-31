package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class WalletSecuritySettingUI$5
  implements DialogInterface.OnClickListener
{
  WalletSecuritySettingUI$5(WalletSecuritySettingUI paramWalletSecuritySettingUI, WalletSecuritySettingUI.e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46397);
    if (this.uaA.uaM.pdt == 1)
    {
      e.m(this.uaz.getContext(), this.uaA.uaM.uaJ, true);
      AppMethodBeat.o(46397);
      return;
    }
    if (this.uaA.uaM.pdt == 2)
    {
      e.q(this.uaA.uaM.uaK, this.uaA.uaM.uaL, 0, 1000);
      AppMethodBeat.o(46397);
      return;
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(46397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.5
 * JD-Core Version:    0.7.0.1
 */