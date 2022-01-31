package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.wallet_core.c;

public class l
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletVerifyCodeUI)) {
      b(paramActivity, paramBundle);
    }
  }
  
  public final String aTh()
  {
    return "VerifyProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt) {}
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    paramBundle = new Intent(paramActivity, WalletOfflineCoinPurseUI.class);
    paramBundle.addFlags(67108864);
    paramActivity.startActivity(paramBundle);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.l
 * JD-Core Version:    0.7.0.1
 */