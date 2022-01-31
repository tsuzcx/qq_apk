package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.b;

public class a
  extends b
{
  public final String aTh()
  {
    return "BindCardForPayProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null) {
      paramActivity.finish();
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, "wallet", ".pay.ui.WalletPayUI", -1, localIntent, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a
 * JD-Core Version:    0.7.0.1
 */