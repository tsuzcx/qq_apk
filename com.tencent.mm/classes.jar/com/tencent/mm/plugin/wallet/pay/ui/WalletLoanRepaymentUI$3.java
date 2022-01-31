package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.ui.o;

final class WalletLoanRepaymentUI$3
  implements DialogInterface.OnCancelListener
{
  WalletLoanRepaymentUI$3(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.qmQ.qgo != null)
    {
      this.qmQ.qgo.cancel();
      this.qmQ.setResult(0);
      this.qmQ.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.3
 * JD-Core Version:    0.7.0.1
 */