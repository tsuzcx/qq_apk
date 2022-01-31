package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c
  extends com.tencent.mm.wallet_core.c
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_set_password_finish_confirm;
  }
  
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
    b(paramActivity, WalletSetPasswordUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new c.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      new g(paramMMActivity, parami)
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousm instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
            {
              c.a(c.this).putInt("RESET_PWD_USER_ACTION", 1);
              c.this.a(this.gfb, 0, c.b(c.this));
              com.tencent.mm.ui.base.h.bC(this.gfb, this.gfb.getString(a.i.wallet_password_setting_success_tip));
            }
            return true;
          }
          if ((paramAnonymousm instanceof com.tencent.mm.plugin.wallet.pwd.a.h))
          {
            com.tencent.mm.ui.base.h.a(this.gfb, paramAnonymousString, "", false, new c.2.1(this));
            return true;
          }
          return false;
        }
        
        public final boolean m(Object... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = (p)paramAnonymousVarArgs[0];
          c.e(c.this).getString("key_pwd1");
          this.wBd.a(new com.tencent.mm.plugin.wallet.pwd.a.h(paramAnonymousVarArgs.feN, paramAnonymousVarArgs.token), true, 1);
          return true;
        }
      };
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletSetPasswordUI)) {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
    }
    while (!(paramActivity instanceof WalletPwdConfirmUI)) {
      return;
    }
    b(paramActivity, paramBundle);
  }
  
  public final boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(a.i.wallet_set_password_finish_confirm), false, new c.3(this, paramWalletBaseUI));
    return true;
  }
  
  public final String aTh()
  {
    return "ResetPwdProcessByToken";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, WalletResetPwdAdapterUI.class);
    localIntent.putExtra("RESET_PWD_USER_ACTION", paramBundle.getInt("RESET_PWD_USER_ACTION", 0));
    a(paramActivity, WalletResetPwdAdapterUI.class, -1, localIntent, false);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.c
 * JD-Core Version:    0.7.0.1
 */