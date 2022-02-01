package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBalanceManagerUI$5
  implements DialogInterface.OnClickListener
{
  WalletBalanceManagerUI$5(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163859);
    paramDialogInterface.dismiss();
    WalletBalanceManagerUI.f(this.AZz);
    AppMethodBeat.o(163859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.5
 * JD-Core Version:    0.7.0.1
 */