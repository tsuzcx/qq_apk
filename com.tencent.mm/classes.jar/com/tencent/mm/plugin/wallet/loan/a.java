package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.wallet_core.d;

public class a
  extends b
{
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69177);
    if (s.ecc().ecF()) {
      b(paramActivity, WalletLoanCheckPwdUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(69177);
      return this;
      super.a(paramActivity, paramBundle);
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(69179);
    if (paramBundle.getBoolean("intent_bind_end", false)) {
      i = -1;
    }
    a(paramActivity, WalletLoanRepaymentUI.class, i, null, true);
    AppMethodBeat.o(69179);
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(69178);
    b(paramActivity, this.dow);
    AppMethodBeat.o(69178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.loan.a
 * JD-Core Version:    0.7.0.1
 */