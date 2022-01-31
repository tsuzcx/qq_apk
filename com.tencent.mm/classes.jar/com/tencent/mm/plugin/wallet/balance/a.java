package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.v;

public class a
  extends b
{
  public static int qfh = 1;
  public static int qfi = 2;
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    v.IX(14);
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
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      if (paramBundle.getInt("from_bind_ui", qfi) == qfh)
      {
        localIntent.putExtra("from_bind_ui", qfh);
        a(paramActivity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, localIntent, true);
        return;
      }
      localIntent.putExtra("from_bind_ui", qfi);
      a(paramActivity, "wallet", ".balance.ui.ltWalletLqtSaveFetchUI", -1, localIntent, true);
      return;
    }
    paramActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a
 * JD-Core Version:    0.7.0.1
 */