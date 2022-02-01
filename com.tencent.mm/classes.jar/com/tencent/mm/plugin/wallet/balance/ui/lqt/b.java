package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d;

public class b
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68737);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(68737);
    return paramActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68739);
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      a(paramActivity, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
      AppMethodBeat.o(68739);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(68739);
  }
  
  public final String cuB()
  {
    return "BalanceFetchCardProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(68738);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(68738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.b
 * JD-Core Version:    0.7.0.1
 */