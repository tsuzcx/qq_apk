package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
    if (paramBundle.getBoolean("key_is_show_detail", true))
    {
      d(paramActivity, paramBundle);
      return this;
    }
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new a.1(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletBankcardDetailUI)) {
      b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    }
    while (!(paramActivity instanceof WalletCheckPwdUI)) {
      return;
    }
    b(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "UnbindProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    E(paramActivity);
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    if (this.kke.getInt("scene", -1) == 1)
    {
      a(paramActivity, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", paramBundle.getInt("key_process_result_code", 0), false);
      return;
    }
    if (this.kke.getInt("scene", -1) == 2)
    {
      d(paramActivity, "wallet", ".balance.ui.WalletBalanceManagerUI");
      return;
    }
    d(paramActivity, "mall", ".ui.MallIndexUI");
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return (paramActivity instanceof WalletCheckPwdUI);
  }
  
  public void d(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity, WalletBankcardDetailUI.class, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a
 * JD-Core Version:    0.7.0.1
 */