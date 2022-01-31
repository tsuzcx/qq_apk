package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.d;

final class WalletBalanceFetchUI$4
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchUI$4(WalletBalanceFetchUI paramWalletBalanceFetchUI, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45358);
    paramDialogInterface.dismiss();
    if (!WalletBalanceFetchUI.a(this.tOj, this.tOm))
    {
      WalletBalanceFetchUI.a(this.tOj, this.tOm.cwk);
      WalletBalanceFetchUI.b(this.tOj, this.tOm);
    }
    AppMethodBeat.o(45358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.4
 * JD-Core Version:    0.7.0.1
 */