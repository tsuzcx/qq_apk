package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a
  extends com.tencent.mm.plugin.wallet_core.b.a
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_forget_password_finish_confirm;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
    Bundle localBundle = this.kke;
    p.bTK();
    boolean bool;
    if (!p.bTL().bVS())
    {
      bool = true;
      localBundle.putBoolean("key_is_oversea", bool);
      localBundle = this.kke;
      p.bTK();
      if (!p.bTL().bVS()) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("key_support_bankcard", i);
      this.kke.putBoolean("key_is_forgot_process", true);
      p.bTK();
      if (!p.bTL().bVS()) {
        break label111;
      }
      b(paramActivity, WalletForgotPwdVerifyIdUI.class, paramBundle);
      return this;
      bool = false;
      break;
    }
    label111:
    b(paramActivity, WalletForgotPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletForgotPwdUI)) {
      return new a.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletForgotPwdVerifyIdUI)) {
      return new a.2(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletCardElementUI)) {
      return new a.3(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI)) {
      return new a.4(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI)) {
      return new a.5(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletForgotPwdUI)) {
      if ((paramBundle.containsKey("key_is_force_bind")) && (paramBundle.getBoolean("key_is_force_bind"))) {
        b(paramActivity, WalletForgotPwdBindNewUI.class, paramBundle);
      }
    }
    do
    {
      return;
      b(paramActivity, WalletCardElementUI.class, paramBundle);
      return;
      if ((paramActivity instanceof WalletCardElementUI))
      {
        if (!bXd())
        {
          b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
          return;
        }
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        return;
      }
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
      if ((paramActivity instanceof WalletPwdConfirmUI))
      {
        b(paramActivity, paramBundle);
        return;
      }
      if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI)))
      {
        A(new Object[] { "startActivity2", paramActivity, WalletCardElementUI.class, paramBundle, "flag: 67108864" });
        Intent localIntent = new Intent(paramActivity, WalletCardElementUI.class);
        localIntent.putExtra("process_id", getClass().hashCode());
        localIntent.addFlags(67108864);
        paramActivity.startActivity(localIntent);
        if (paramBundle != null) {
          this.kke.putAll(paramBundle);
        }
        y.d("MicroMsg.ProcessManager", "bankcard tag :" + cMm());
        return;
      }
      if ((paramActivity instanceof WalletForgotPwdVerifyIdUI))
      {
        if ((paramBundle.containsKey("key_is_support_face")) && (paramBundle.getInt("key_is_support_face") == 1))
        {
          y.i("MicroMsg.ProcessManager", "forward support face");
          com.tencent.mm.plugin.report.service.h.nFQ.f(15774, new Object[] { Integer.valueOf(this.kke.getInt("key_forgot_scene", 1)), Integer.valueOf(1) });
          b(paramActivity, WalletForgotPwdSelectUI.class, paramBundle);
          return;
        }
        y.i("MicroMsg.ProcessManager", "forward not support face");
        b(paramActivity, WalletForgotPwdUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletForgotPwdSelectUI));
    if ((paramBundle.containsKey("key_select_bank_card")) && (paramBundle.getBoolean("key_select_bank_card")))
    {
      y.i("MicroMsg.ProcessManager", "forward select bankcard");
      b(paramActivity, WalletForgotPwdUI.class, paramBundle);
      return;
    }
    y.i("MicroMsg.ProcessManager", "forward after face check");
    b(paramActivity, WalletSetPasswordUI.class, paramBundle);
  }
  
  public final boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(a.i.wallet_forget_password_finish_confirm), false, new a.6(this, paramWalletBaseUI));
    return true;
  }
  
  public final String aTh()
  {
    return "ForgotPwdProcess";
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    p.bTK();
    if (p.bTL().bVS())
    {
      a(paramActivity, WalletForgotPwdVerifyIdUI.class, -1, false);
      return;
    }
    a(paramActivity, WalletForgotPwdUI.class, -1, false);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return paramActivity instanceof WalletPwdConfirmUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a
 * JD-Core Version:    0.7.0.1
 */