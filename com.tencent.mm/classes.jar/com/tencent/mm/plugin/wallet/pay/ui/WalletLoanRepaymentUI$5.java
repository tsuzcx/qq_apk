package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLoanRepaymentUI$5
  implements DialogInterface.OnClickListener
{
  WalletLoanRepaymentUI$5(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45995);
    if (this.tWh.isTransparent()) {
      this.tWh.finish();
    }
    AppMethodBeat.o(45995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.5
 * JD-Core Version:    0.7.0.1
 */