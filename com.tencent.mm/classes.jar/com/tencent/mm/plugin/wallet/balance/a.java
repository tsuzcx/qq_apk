package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;

public class a
  extends b
{
  public static int CNY = 1;
  public static int CNZ = 2;
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68368);
    z.agV(14);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(68368);
    return paramActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(68370);
    z.fVV();
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      if (paramBundle.getInt("from_bind_ui", CNZ) == CNY)
      {
        localIntent.putExtra("from_bind_ui", CNY);
        a(paramActivity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, localIntent, true);
        AppMethodBeat.o(68370);
        return;
      }
      localIntent.putExtra("from_bind_ui", CNZ);
      a(paramActivity, "wallet", ".balance.ui.WalletBalanceFetchUI", -1, localIntent, true);
      AppMethodBeat.o(68370);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(68370);
  }
  
  public final String cSH()
  {
    return "BalanceFetchCardProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(68369);
    z.fVV();
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(68369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a
 * JD-Core Version:    0.7.0.1
 */