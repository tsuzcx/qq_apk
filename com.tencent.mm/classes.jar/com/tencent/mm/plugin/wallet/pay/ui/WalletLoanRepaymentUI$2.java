package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.q;

final class WalletLoanRepaymentUI$2
  implements View.OnClickListener
{
  WalletLoanRepaymentUI$2(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45992);
    WalletLoanRepaymentUI.c(this.tWh);
    if (this.tWh.tVM != null) {
      this.tWh.tVM.dismiss();
    }
    AppMethodBeat.o(45992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.2
 * JD-Core Version:    0.7.0.1
 */