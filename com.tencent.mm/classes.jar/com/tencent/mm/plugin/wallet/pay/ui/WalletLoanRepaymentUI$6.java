package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c.a;

final class WalletLoanRepaymentUI$6
  implements c.a
{
  WalletLoanRepaymentUI$6(WalletLoanRepaymentUI paramWalletLoanRepaymentUI) {}
  
  public final Intent m(int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      WalletLoanRepaymentUI.b(this.qmQ, WalletLoanRepaymentUI.b(this.qmQ));
      return null;
    }
    paramBundle = o.bVt();
    if (paramBundle.bVD())
    {
      paramBundle = paramBundle.bVE();
      WalletLoanRepaymentUI.a(this.qmQ, paramBundle, WalletLoanRepaymentUI.d(this.qmQ), WalletLoanRepaymentUI.e(this.qmQ));
      return null;
    }
    this.qmQ.setResult(0, null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.6
 * JD-Core Version:    0.7.0.1
 */