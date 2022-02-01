package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceManagerUI$4
  implements DialogInterface.OnClickListener
{
  WalletBalanceManagerUI$4(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(316355);
    paramDialogInterface.dismiss();
    WalletBalanceManagerUI.f(this.VcP);
    AppMethodBeat.o(316355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.4
 * JD-Core Version:    0.7.0.1
 */