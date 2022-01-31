package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a
  extends com.tencent.mm.plugin.wallet_core.b.a
{
  public a.a tXA;
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131305083;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46137);
    ab.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
    Bundle localBundle = this.mEJ;
    s.cRG();
    boolean bool1;
    int i;
    if (!s.cRH().cUu())
    {
      bool1 = true;
      localBundle.putBoolean("key_is_oversea", bool1);
      localBundle = this.mEJ;
      s.cRG();
      if (!s.cRH().cUu()) {
        break label142;
      }
      i = 1;
      label64:
      localBundle.putInt("key_support_bankcard", i);
      this.mEJ.putBoolean("key_is_forgot_process", true);
      bool1 = paramBundle.getBoolean("isFromKinda");
      boolean bool2 = paramBundle.getBoolean("isDomesticUser");
      s.cRG();
      if ((!s.cRH().cUu()) && ((!bool1) || (!bool2))) {
        break label147;
      }
      b(paramActivity, WalletForgotPwdVerifyIdUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(46137);
      return this;
      bool1 = false;
      break;
      label142:
      i = 2;
      break label64;
      label147:
      b(paramActivity, WalletForgotPwdUI.class, paramBundle);
    }
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(46140);
    if ((paramMMActivity instanceof WalletForgotPwdUI))
    {
      paramMMActivity = new a.1(this, paramMMActivity, parami);
      AppMethodBeat.o(46140);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletForgotPwdVerifyIdUI))
    {
      paramMMActivity = new a.2(this, paramMMActivity, parami);
      AppMethodBeat.o(46140);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCardElementUI))
    {
      paramMMActivity = new a.3(this, paramMMActivity, parami);
      AppMethodBeat.o(46140);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new a.4(this, paramMMActivity, parami);
      AppMethodBeat.o(46140);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new a.5(this, paramMMActivity, parami);
      AppMethodBeat.o(46140);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(46140);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(46138);
    if ((paramActivity instanceof WalletForgotPwdUI))
    {
      if ((paramBundle.containsKey("key_is_force_bind")) && (paramBundle.getBoolean("key_is_force_bind")))
      {
        b(paramActivity, WalletForgotPwdBindNewUI.class, paramBundle);
        AppMethodBeat.o(46138);
        return;
      }
      b(paramActivity, WalletCardElementUI.class, paramBundle);
      AppMethodBeat.o(46138);
      return;
    }
    if ((paramActivity instanceof WalletCardElementUI))
    {
      if (!cWe())
      {
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(46138);
        return;
      }
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(46138);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(46138);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(46138);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(46138);
      return;
    }
    if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI)))
    {
      G(new Object[] { "startActivity2", paramActivity, WalletCardElementUI.class, paramBundle, "flag: 67108864" });
      Intent localIntent = new Intent(paramActivity, WalletCardElementUI.class);
      localIntent.putExtra("process_id", getClass().hashCode());
      localIntent.addFlags(67108864);
      paramActivity.startActivity(localIntent);
      if (paramBundle != null) {
        this.mEJ.putAll(paramBundle);
      }
      ab.d("MicroMsg.ProcessManager", "bankcard tag :" + dRO());
      AppMethodBeat.o(46138);
      return;
    }
    if ((paramActivity instanceof WalletForgotPwdVerifyIdUI))
    {
      if ((paramBundle.containsKey("key_is_support_face")) && (paramBundle.getInt("key_is_support_face") == 1))
      {
        ab.i("MicroMsg.ProcessManager", "forward support face");
        com.tencent.mm.plugin.report.service.h.qsU.e(15774, new Object[] { Integer.valueOf(this.mEJ.getInt("key_forgot_scene", 1)), Integer.valueOf(1) });
        b(paramActivity, WalletForgotPwdSelectUI.class, paramBundle);
        AppMethodBeat.o(46138);
        return;
      }
      ab.i("MicroMsg.ProcessManager", "forward not support face");
      b(paramActivity, WalletForgotPwdUI.class, paramBundle);
      AppMethodBeat.o(46138);
      return;
    }
    if ((paramActivity instanceof WalletForgotPwdSelectUI))
    {
      if ((paramBundle.containsKey("key_select_bank_card")) && (paramBundle.getBoolean("key_select_bank_card")))
      {
        ab.i("MicroMsg.ProcessManager", "forward select bankcard");
        b(paramActivity, WalletForgotPwdUI.class, paramBundle);
        AppMethodBeat.o(46138);
        return;
      }
      ab.i("MicroMsg.ProcessManager", "forward after face check");
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
    }
    AppMethodBeat.o(46138);
  }
  
  public final boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    AppMethodBeat.i(46141);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(46141);
      return false;
    }
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(2131305083), false, new a.6(this, paramWalletBaseUI));
    AppMethodBeat.o(46141);
    return true;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46139);
    s.cRG();
    if (s.cRH().cUu())
    {
      a(paramActivity, WalletForgotPwdVerifyIdUI.class, -1, false);
      if (this.tXA != null)
      {
        this.tXA.run(0);
        AppMethodBeat.o(46139);
      }
    }
    else
    {
      a(paramActivity, WalletForgotPwdUI.class, -1, false);
      if (this.tXA != null) {
        this.tXA.run(-1);
      }
    }
    AppMethodBeat.o(46139);
  }
  
  public final String bzC()
  {
    return "ForgotPwdProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return paramActivity instanceof WalletPwdConfirmUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a
 * JD-Core Version:    0.7.0.1
 */