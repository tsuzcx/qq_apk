package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.q;

final class WalletLoanRepaymentUI$3
  implements DialogInterface.OnCancelListener
{
  WalletLoanRepaymentUI$3(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(45993);
    if (this.tWh.tVM != null)
    {
      this.tWh.tVM.cancel();
      this.tWh.setResult(0);
      this.tWh.finish();
    }
    AppMethodBeat.o(45993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.3
 * JD-Core Version:    0.7.0.1
 */