package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.wallet_core.c.a;

final class WalletLoanRepaymentUI$6
  implements c.a
{
  WalletLoanRepaymentUI$6(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final Intent p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(45996);
    if (paramInt == -1) {
      WalletLoanRepaymentUI.b(this.tWh, WalletLoanRepaymentUI.b(this.tWh));
    }
    for (;;)
    {
      AppMethodBeat.o(45996);
      return null;
      paramBundle = t.cTO();
      if (paramBundle.cTZ())
      {
        paramBundle = paramBundle.cUa();
        WalletLoanRepaymentUI.a(this.tWh, paramBundle, WalletLoanRepaymentUI.d(this.tWh), WalletLoanRepaymentUI.e(this.tWh));
      }
      else
      {
        this.tWh.setResult(0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.6
 * JD-Core Version:    0.7.0.1
 */