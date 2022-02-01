package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.o;
import com.tencent.mm.plugin.wallet.pwd.a.q;
import com.tencent.mm.plugin.wallet.pwd.a.s;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a
  extends com.tencent.mm.plugin.wallet_core.b.a
{
  public a VoT;
  private o VoU;
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_forget_password_finish_confirm;
  }
  
  public final g a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.i parami)
  {
    AppMethodBeat.i(69496);
    if ((paramMMActivity instanceof WalletForgotPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(69483);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof ae)))
          {
            paramAnonymousString = u.iix().ijK();
            Log.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[] { paramAnonymousString.field_reset_passwd_flag, paramAnonymousString.field_find_passwd_url });
            paramAnonymousString = u.iiC().iju();
            if (!Util.isNullOrNil(paramAnonymousString))
            {
              Log.i("MicroMsg.ProcessManager", "jump to forget url: %s", new Object[] { paramAnonymousString });
              com.tencent.mm.wallet_core.ui.i.p(this.activity, paramAnonymousString, false);
              AppMethodBeat.o(69483);
              return true;
            }
          }
          AppMethodBeat.o(69483);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletForgotPwdVerifyIdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69484);
          if (paramAnonymousVarArgs.length == 3)
          {
            paramAnonymousVarArgs = new s(paramAnonymousVarArgs[0].toString(), ((Integer)paramAnonymousVarArgs[1]).intValue(), (String)paramAnonymousVarArgs[2]);
            this.agTR.b(paramAnonymousVarArgs, true);
          }
          AppMethodBeat.o(69484);
          return true;
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCardElementUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(69485);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof o)))
          {
            paramAnonymousString = (o)paramAnonymousp;
            a.a(a.this).putString("kreq_token", paramAnonymousString.getToken());
            a.a(a.this, paramAnonymousString);
            if (!paramAnonymousString.VmI) {
              a.this.a(this.activity, 0, a.b(a.this));
            }
            AppMethodBeat.o(69485);
            return true;
          }
          AppMethodBeat.o(69485);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69486);
          paramAnonymousVarArgs = (Authen)paramAnonymousVarArgs[0];
          if (!a.this.ill())
          {
            paramAnonymousVarArgs.eQp = 1;
            if (!a.c(a.this).getBoolean("key_is_paymanager")) {
              break label90;
            }
          }
          label90:
          for (int i = 1;; i = 0)
          {
            this.agTR.a(new o(paramAnonymousVarArgs, a.d(a.this).getBoolean("key_is_reset_with_new_card", false), i), true, 1);
            AppMethodBeat.o(69486);
            return true;
            paramAnonymousVarArgs.eQp = 4;
            break;
          }
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean E(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(315576);
          if (a.f(a.this) != null)
          {
            a.f(a.this).resend();
            this.agTR.b(a.f(a.this), false);
          }
          AppMethodBeat.o(315576);
          return true;
        }
        
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69489);
          String str = this.activity.getString(a.i.wallet_verify_code_common_hint1);
          AppMethodBeat.o(69489);
          return str;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(69487);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof o)))
          {
            paramAnonymousString = (o)paramAnonymousp;
            a.e(a.this).putString("kreq_token", paramAnonymousString.getToken());
            AppMethodBeat.o(69487);
            return true;
          }
          AppMethodBeat.o(69487);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69488);
          paramAnonymousVarArgs = (w)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.flag = "3";
          this.agTR.a(new q(paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(69488);
          return true;
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(69490);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((paramAnonymousp instanceof n)) || ((paramAnonymousp instanceof j))))
          {
            a.this.a(this.activity, 0, a.g(a.this));
            AppMethodBeat.o(69490);
            return true;
          }
          AppMethodBeat.o(69490);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69491);
          paramAnonymousVarArgs = (w)paramAnonymousVarArgs[0];
          if (a.this.hPH.getBoolean("key_is_set_pwd_after_face_action"))
          {
            Log.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
            String str = a.this.hPH.getString("key_face_action_result_token");
            this.agTR.a(new j(str, paramAnonymousVarArgs.pRM), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(69491);
            return true;
            Log.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
            this.agTR.a(new n(paramAnonymousVarArgs), true, 1);
          }
        }
      };
      AppMethodBeat.o(69496);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(69496);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69493);
    Log.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
    Bundle localBundle = this.hPH;
    com.tencent.mm.plugin.wallet.model.p.ifO();
    boolean bool1;
    int i;
    if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijq())
    {
      bool1 = true;
      localBundle.putBoolean("key_is_oversea", bool1);
      localBundle = this.hPH;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (!com.tencent.mm.plugin.wallet.model.p.ifP().ijq()) {
        break label142;
      }
      i = 1;
      label64:
      localBundle.putInt("key_support_bankcard", i);
      this.hPH.putBoolean("key_is_forgot_process", true);
      bool1 = paramBundle.getBoolean("isFromKinda");
      boolean bool2 = paramBundle.getBoolean("isDomesticUser");
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if ((!com.tencent.mm.plugin.wallet.model.p.ifP().ijq()) && ((!bool1) || (!bool2))) {
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
      if (!ill())
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
      P(new Object[] { "startActivity2", paramActivity, WalletCardElementUI.class, paramBundle, "flag: 67108864" });
      Object localObject = new Intent(paramActivity, WalletCardElementUI.class);
      ((Intent)localObject).putExtra("process_id", getClass().hashCode());
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (paramBundle != null) {
        this.hPH.putAll(paramBundle);
      }
      Log.d("MicroMsg.ProcessManager", "bankcard tag :" + jOf());
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletForgotPwdVerifyIdUI))
    {
      if ((paramBundle.containsKey("key_is_support_face")) && (paramBundle.getInt("key_is_support_face") == 1))
      {
        Log.i("MicroMsg.ProcessManager", "forward support face");
        h.OAn.b(15774, new Object[] { Integer.valueOf(this.hPH.getInt("key_forgot_scene", 1)), Integer.valueOf(1) });
        b(paramActivity, WalletForgotPwdSelectUI.class, paramBundle);
        AppMethodBeat.o(69494);
        return;
      }
      Log.i("MicroMsg.ProcessManager", "forward not support face");
      b(paramActivity, WalletForgotPwdUI.class, paramBundle);
      AppMethodBeat.o(69494);
      return;
    }
    if ((paramActivity instanceof WalletForgotPwdSelectUI))
    {
      if ((paramBundle.containsKey("key_select_bank_card")) && (paramBundle.getBoolean("key_select_bank_card")))
      {
        Log.i("MicroMsg.ProcessManager", "forward select bankcard");
        b(paramActivity, WalletForgotPwdUI.class, paramBundle);
        AppMethodBeat.o(69494);
        return;
      }
      Log.i("MicroMsg.ProcessManager", "forward after face check");
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
    com.tencent.mm.ui.base.k.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(a.i.wallet_forget_password_finish_confirm), false, new DialogInterface.OnClickListener()
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
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijq())
    {
      a(paramActivity, WalletForgotPwdVerifyIdUI.class, -1, false);
      if (this.VoT != null)
      {
        this.VoT.run(0);
        AppMethodBeat.o(69495);
      }
    }
    else
    {
      a(paramActivity, WalletForgotPwdUI.class, -1, false);
      if (this.VoT != null) {
        this.VoT.run(-1);
      }
    }
    AppMethodBeat.o(69495);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return paramActivity instanceof WalletPwdConfirmUI;
  }
  
  public final String fud()
  {
    return "ForgotPwdProcess";
  }
  
  public static abstract interface a
  {
    public abstract void run(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a
 * JD-Core Version:    0.7.0.1
 */