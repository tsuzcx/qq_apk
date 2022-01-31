package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.wallet_core.c;

public class b
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    return super.a(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "BalanceFetchCardProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null) {
      paramActivity.finish();
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("intent_bind_end", false)))
    {
      a(paramActivity, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
      return;
    }
    paramActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.b
 * JD-Core Version:    0.7.0.1
 */