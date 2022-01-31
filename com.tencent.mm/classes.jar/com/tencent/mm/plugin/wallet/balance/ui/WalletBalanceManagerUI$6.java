package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceManagerUI$6
  implements DialogInterface.OnClickListener
{
  WalletBalanceManagerUI$6(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45433);
    paramDialogInterface.dismiss();
    WalletBalanceManagerUI.g(this.tOJ);
    AppMethodBeat.o(45433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.6
 * JD-Core Version:    0.7.0.1
 */