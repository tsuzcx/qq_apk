package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLoanRepaymentUI$4
  implements DialogInterface.OnClickListener
{
  WalletLoanRepaymentUI$4(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45994);
    ab.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
    this.tWh.cRV();
    AppMethodBeat.o(45994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.4
 * JD-Core Version:    0.7.0.1
 */