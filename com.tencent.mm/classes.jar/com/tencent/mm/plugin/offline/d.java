package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.h.a.kw;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d
  extends b
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      return new d.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new d.2(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final String aTh()
  {
    return "OfflineBindCardRegProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    a.udP.m(new kw());
    c(paramActivity, WalletOfflineEntranceUI.class);
    if (paramActivity != null) {
      paramActivity.finish();
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return super.c(paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.d
 * JD-Core Version:    0.7.0.1
 */