package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c;

public class b
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(45499);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(45499);
    return paramActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(45501);
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      a(paramActivity, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
      AppMethodBeat.o(45501);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(45501);
  }
  
  public final String bzC()
  {
    return "BalanceFetchCardProcess";
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(45500);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(45500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.b
 * JD-Core Version:    0.7.0.1
 */