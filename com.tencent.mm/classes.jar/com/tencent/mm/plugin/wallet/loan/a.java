package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c;

public class a
  extends b
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    if (o.bVs().bVN())
    {
      b(paramActivity, WalletLoanCheckPwdUI.class, paramBundle);
      return this;
    }
    super.a(paramActivity, paramBundle);
    return this;
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    b(paramActivity, this.kke);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle.getBoolean("intent_bind_end", false)) {
      i = -1;
    }
    a(paramActivity, WalletLoanRepaymentUI.class, i, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.loan.a
 * JD-Core Version:    0.7.0.1
 */