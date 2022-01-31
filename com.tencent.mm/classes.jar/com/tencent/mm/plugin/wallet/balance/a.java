package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;

public class a
  extends b
{
  public static int tLU = 1;
  public static int tLV = 2;
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(45196);
    x.RT(14);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(45196);
    return paramActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(45198);
    x.dSs();
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      if (paramBundle.getInt("from_bind_ui", tLV) == tLU)
      {
        localIntent.putExtra("from_bind_ui", tLU);
        a(paramActivity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, localIntent, true);
        AppMethodBeat.o(45198);
        return;
      }
      localIntent.putExtra("from_bind_ui", tLV);
      a(paramActivity, "wallet", ".balance.ui.WalletBalanceFetchUI", -1, localIntent, true);
      AppMethodBeat.o(45198);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(45198);
  }
  
  public final String bzC()
  {
    return "BalanceFetchCardProcess";
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(45197);
    x.dSs();
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(45197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a
 * JD-Core Version:    0.7.0.1
 */