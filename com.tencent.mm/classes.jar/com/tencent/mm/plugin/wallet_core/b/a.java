package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class a
  extends c
{
  public int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131305133;
  }
  
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    G(new Object[] { "start", paramActivity, paramBundle });
    if (paramBundle != null) {
      paramBundle.putBoolean("key_is_bind_reg_process", true);
    }
    b(paramActivity, WalletBankcardIdUI.class, paramBundle);
    return this;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    G(new Object[] { "forward", paramActivity, Integer.valueOf(paramInt), paramBundle });
    if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI))) {
      b(paramActivity, WalletCardElementUI.class, paramBundle);
    }
    do
    {
      return;
      if ((paramActivity instanceof WalletVerifyCodeUI))
      {
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletSetPasswordUI))
      {
        b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletOrderInfoUI));
    b(paramActivity, paramBundle);
  }
  
  public boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    ab.i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
    h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(2131304891), false, new a.1(this, paramWalletBaseUI));
    return true;
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return paramActivity instanceof WalletOrderInfoUI;
  }
  
  public void e(Activity paramActivity, int paramInt)
  {
    G(new Object[] { "back", paramActivity, Integer.valueOf(paramInt) });
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      return;
    }
    B(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a
 * JD-Core Version:    0.7.0.1
 */