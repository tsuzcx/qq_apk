package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class f
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
    if (paramBundle.getBoolean("key_is_show_detail", true))
    {
      a(paramActivity, "wallet", ".bind.ui.WalletBankcardDetailUI", paramBundle);
      return this;
    }
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new f.1(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (paramActivity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI")) {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    while (!(paramActivity instanceof WalletCheckPwdUI)) {
      return;
    }
    b(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "WXCreditUnbindProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    d(paramActivity, "mall", ".ui.MallIndexUI");
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.f
 * JD-Core Version:    0.7.0.1
 */