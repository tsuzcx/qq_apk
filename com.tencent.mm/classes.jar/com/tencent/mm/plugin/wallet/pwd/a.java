package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.a.p;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class a
  extends com.tencent.mm.plugin.wallet_core.b.a
{
  public a CKu;
  private p CKv;
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131765275;
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(69496);
    if ((paramMMActivity instanceof WalletForgotPwdUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69483);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
          {
            paramAnonymousString = t.eFt().eHg();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[] { paramAnonymousString.field_reset_passwd_flag, paramAnonymousString.field_find_passwd_url });
            paramAnonymousString = t.eFy().eGn();
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ProcessManager", "jump to forget url: %s", new Object[] { paramAnonymousString });
              e.o(this.activity, paramAnonymousString, false);
              AppMethodBeat.o(69483);
              return true;
            }
          }
          AppMethodBeat.o(69483);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletForgotPwdVerifyIdUI))
    {
      paramMMActivity = new a.2(this, paramMMActivity, parami);
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCardElementUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69485);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof p)))
          {
            paramAnonymousString = (p)paramAnonymousn;
            a.a(a.this).putString("kreq_token", paramAnonymousString.getToken());
            a.a(a.this, paramAnonymousString);
            if (!paramAnonymousString.CIk) {
              a.this.a(this.activity, 0, a.b(a.this));
            }
            AppMethodBeat.o(69485);
            return true;
          }
          AppMethodBeat.o(69485);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69486);
          paramAnonymousVarArgs = (Authen)paramAnonymousVarArgs[0];
          if (!a.this.eIa())
          {
            paramAnonymousVarArgs.dDp = 1;
            if (!a.c(a.this).getBoolean("key_is_paymanager")) {
              break label90;
            }
          }
          label90:
          for (int i = 1;; i = 0)
          {
            this.LyU.a(new p(paramAnonymousVarArgs, a.d(a.this).getBoolean("key_is_reset_with_new_card", false), i), true, 1);
            AppMethodBeat.o(69486);
            return true;
            paramAnonymousVarArgs.dDp = 4;
            break;
          }
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new a.4(this, paramMMActivity, parami);
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new a.5(this, paramMMActivity, parami);
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(69496);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69493);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
    Bundle localBundle = this.dxT;
    s.eDp();
    boolean bool1;
    int i;
    if (!s.eDq().eGj())
    {
      bool1 = true;
      localBundle.putBoolean("key_is_oversea", bool1);
      localBundle = this.dxT;
      s.eDp();
      if (!s.eDq().eGj()) {
        break label142;
      }
      i = 1;
      label64:
      localBundle.putInt("key_support_bankcard", i);
      this.dxT.putBoolean("key_is_forgot_process", true);
      bool1 = paramBundle.getBoolean("isFromKinda");
      boolean bool2 = paramBundle.getBoolean("isDomesticUser");
      s.eDp();
      if ((!s.eDq().eGj()) && ((!bool1) || (!bool2))) {
        break label147;
      }
      b(paramActivity, WalletForgotPwdVerifyIdUI.class, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(69493);
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
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69494);
    if ((paramActivity instanceof WalletForgotPwdUI))
    {
      if ((paramBundle.containsKey("key_is_force_bind")) && (paramBundle.getBoolean("key_is_force_bind")))
      {
        b(paramActivity, WalletForgotPwdBindNewUI.class, paramBundle);
        AppMethodBeat.o(69494);
        return;
      }
      b(paramActivity, WalletCardElementUI.class, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletCardElementUI))
    {
      if (!eIa())
      {
        b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
        AppMethodBeat.o(69494);
        return;
      }
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI)))
    {
      K(new Object[] { "startActivity2", paramActivity, WalletCardElementUI.class, paramBundle, "flag: 67108864" });
      Object localObject = new Intent(paramActivity, WalletCardElementUI.class);
      ((Intent)localObject).putExtra("process_id", getClass().hashCode());
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (paramBundle != null) {
        this.dxT.putAll(paramBundle);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ProcessManager", "bankcard tag :" + fQP());
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletForgotPwdVerifyIdUI))
    {
      if ((paramBundle.containsKey("key_is_support_face")) && (paramBundle.getInt("key_is_support_face") == 1))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ProcessManager", "forward support face");
        com.tencent.mm.plugin.report.service.g.yhR.f(15774, new Object[] { Integer.valueOf(this.dxT.getInt("key_forgot_scene", 1)), Integer.valueOf(1) });
        b(paramActivity, WalletForgotPwdSelectUI.class, paramBundle);
        AppMethodBeat.o(69494);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ProcessManager", "forward not support face");
      b(paramActivity, WalletForgotPwdUI.class, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletForgotPwdSelectUI))
    {
      if ((paramBundle.containsKey("key_select_bank_card")) && (paramBundle.getBoolean("key_select_bank_card")))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ProcessManager", "forward select bankcard");
        b(paramActivity, WalletForgotPwdUI.class, paramBundle);
        AppMethodBeat.o(69494);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ProcessManager", "forward after face check");
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
    }
    AppMethodBeat.o(69494);
  }
  
  public final boolean a(final WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    AppMethodBeat.i(69497);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(69497);
      return false;
    }
    h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(2131765275), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69492);
        a.this.b(paramWalletBaseUI, a.h(a.this));
        if (paramWalletBaseUI.isTransparent()) {
          paramWalletBaseUI.finish();
        }
        paramWalletBaseUI.clearErr();
        AppMethodBeat.o(69492);
      }
    });
    AppMethodBeat.o(69497);
    return true;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69495);
    s.eDp();
    if (s.eDq().eGj())
    {
      a(paramActivity, WalletForgotPwdVerifyIdUI.class, -1, false);
      if (this.CKu != null)
      {
        this.CKu.run(0);
        AppMethodBeat.o(69495);
      }
    }
    else
    {
      a(paramActivity, WalletForgotPwdUI.class, -1, false);
      if (this.CKu != null) {
        this.CKu.run(-1);
      }
    }
    AppMethodBeat.o(69495);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return paramActivity instanceof WalletPwdConfirmUI;
  }
  
  public final String cQc()
  {
    return "ForgotPwdProcess";
  }
  
  public static abstract interface a
  {
    public abstract void run(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a
 * JD-Core Version:    0.7.0.1
 */