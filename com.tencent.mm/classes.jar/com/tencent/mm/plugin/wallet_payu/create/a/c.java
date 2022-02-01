package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;

public class c
  extends e
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(72027);
    if (paramInt == 1)
    {
      paramInt = a.i.wallet_payu_endprocesstip_create;
      AppMethodBeat.o(72027);
      return paramInt;
    }
    paramInt = super.a(paramMMActivity, paramInt);
    AppMethodBeat.o(72027);
    return paramInt;
  }
  
  public final g a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.i parami)
  {
    AppMethodBeat.i(72028);
    if ((paramMMActivity instanceof WalletPayUStartOpenUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(72012);
          if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_payu.a.b))
          {
            Log.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet_payu.a.b)paramAnonymousp;
              c.this.hPH.putString("payu_reference", paramAnonymousString.hQR);
              Log.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[] { paramAnonymousString.hQR });
              c.this.hPH.putBoolean("key_is_has_mobile", paramAnonymousString.Wdu);
              com.tencent.mm.wallet_core.a.k(this.activity, c.this.hPH);
              AppMethodBeat.o(72012);
              return true;
            }
          }
          AppMethodBeat.o(72012);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72013);
          this.agTR.b(new com.tencent.mm.plugin.wallet_payu.a.b(c.this.hPH.getString("dial_code"), c.this.hPH.getString("key_mobile")), true);
          AppMethodBeat.o(72013);
          return false;
        }
      };
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean E(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72014);
          this.agTR.a(new com.tencent.mm.plugin.wallet_payu.a.b(c.this.hPH.getString("dial_code"), c.this.hPH.getString("key_mobile")), true, 1);
          AppMethodBeat.o(72014);
          return true;
        }
        
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(72017);
          if (paramAnonymousInt == 0)
          {
            localObject = this.activity.getString(a.i.wallet_verify_code_bind_hint_payu, new Object[] { com.tencent.mm.wallet_core.ui.i.bEO("+" + c.b(c.this).getString("dial_code") + c.c(c.this).getString("key_mobile")) });
            AppMethodBeat.o(72017);
            return localObject;
          }
          Object localObject = super.getTips(paramAnonymousInt);
          AppMethodBeat.o(72017);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(72015);
          if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_payu.a.a))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet_payu.a.a)paramAnonymousp;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString.Puv))
            {
              c.a(c.this).putString("payu_reference", paramAnonymousString.Wdt);
              com.tencent.mm.wallet_core.a.k(this.activity, c.this.hPH);
              AppMethodBeat.o(72015);
              return true;
            }
          }
          else if (((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_payu.a.b)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet_payu.a.b)paramAnonymousp;
            c.this.hPH.putString("payu_reference", paramAnonymousString.hQR);
            AppMethodBeat.o(72015);
            return true;
          }
          AppMethodBeat.o(72015);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72016);
          this.agTR.b(new com.tencent.mm.plugin.wallet_payu.a.a((String)paramAnonymousVarArgs[0], c.this.hPH.getString("payu_reference")), true);
          AppMethodBeat.o(72016);
          return true;
        }
      };
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUSecurityQuestionSettingUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean D(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72018);
          this.agTR.b(new d(), true);
          AppMethodBeat.o(72018);
          return false;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(72019);
          if (((paramAnonymousp instanceof d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            c.this.hPH.putParcelableArrayList("key_security_question_list", ((d)paramAnonymousp).WdR);
            AppMethodBeat.o(72019);
            return true;
          }
          AppMethodBeat.o(72019);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(72020);
          if (((paramAnonymousp instanceof a)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            Log.d("MicroMsg.PayUOpenProcess", "hy: create user success");
            com.tencent.mm.wallet_core.a.b(this.activity, c.this.hPH, 0);
            c.d(c.this).putInt("key_open_error_code", 0);
            aa.makeText(this.activity, this.activity.getString(a.i.wallet_payu_start_success), 0).show();
            AppMethodBeat.o(72020);
            return true;
          }
          if (((paramAnonymousp instanceof b)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            Log.d("MicroMsg.PayUOpenProcess", "hy: link user success");
            com.tencent.mm.wallet_core.a.b(this.activity, c.this.hPH, 0);
            c.e(c.this).putInt("key_open_error_code", 0);
            aa.makeText(this.activity, this.activity.getString(a.i.wallet_payu_start_success), 0).show();
            AppMethodBeat.o(72020);
            return true;
          }
          AppMethodBeat.o(72020);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72021);
          Object localObject = (w)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = c.this.hPH.getString("dial_code");
          String str1 = c.this.hPH.getString("key_mobile");
          localObject = ((w)localObject).pRM;
          String str2 = c.this.hPH.getString("key_question_id");
          String str3 = c.this.hPH.getString("key_question_answer");
          String str4 = c.this.hPH.getString("payu_reference");
          if (!c.this.hPH.getBoolean("key_is_has_mobile")) {
            this.agTR.b(new a(paramAnonymousVarArgs, str1, (String)localObject, str2, str3, str4), true);
          }
          for (;;)
          {
            AppMethodBeat.o(72021);
            return true;
            this.agTR.b(new b(paramAnonymousVarArgs, str1, (String)localObject, str4), true);
          }
        }
      };
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUSecurityQuestionAnswerUI))
    {
      paramMMActivity = new com.tencent.mm.plugin.wallet_payu.security_question.model.a(paramMMActivity, parami, this.hPH);
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72028);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72022);
    Log.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
    com.tencent.mm.plugin.wallet.model.p.ifO();
    String str1 = com.tencent.mm.plugin.wallet.model.p.bIS();
    com.tencent.mm.plugin.wallet.model.p.ifO();
    String str2 = com.tencent.mm.plugin.wallet.model.p.ifQ();
    if (paramBundle != null)
    {
      paramBundle.putString("key_mobile", str1);
      paramBundle.putString("dial_code", str2);
    }
    b(paramActivity, WalletPayUStartOpenUI.class, paramBundle);
    AppMethodBeat.o(72022);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72023);
    if ((paramActivity instanceof WalletPayUStartOpenUI)) {
      b(paramActivity, WalletPayUVerifyCodeUI.class, paramBundle);
    }
    if ((paramActivity instanceof WalletPayUVerifyCodeUI))
    {
      if (paramBundle.getBoolean("key_is_has_mobile")) {
        break label95;
      }
      b(paramActivity, WalletPayUSecurityQuestionSettingUI.class, paramBundle);
    }
    for (;;)
    {
      if ((paramActivity instanceof WalletPayUSecurityQuestionSettingUI)) {
        b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      }
      if ((paramActivity instanceof WalletPayUSetPasswordUI)) {
        b(paramActivity, WalletPayUPwdConfirmUI.class, paramBundle);
      }
      if ((paramActivity instanceof WalletPayUSecurityQuestionAnswerUI)) {
        b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      }
      AppMethodBeat.o(72023);
      return;
      label95:
      b(paramActivity, WalletPayUSecurityQuestionAnswerUI.class, paramBundle);
    }
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72026);
    if (paramBundle.getInt("key_open_error_code", -1) == 0)
    {
      Log.i("MicroMsg.PayUOpenProcess", "hy: user open success");
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true);
      Log.i("MicroMsg.PayUOpenProcess", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        g(paramActivity, "mall", ".ui.MallIndexUIv2");
        AppMethodBeat.o(72026);
        return;
      }
      g(paramActivity, "mall", ".ui.MallIndexUI");
      AppMethodBeat.o(72026);
      return;
    }
    Log.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
    super.co(paramActivity);
    com.tencent.mm.wallet_core.ui.i.nT(paramActivity);
    AppMethodBeat.o(72026);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "PayUOpenProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72024);
    if ((paramActivity instanceof WalletPayUPwdConfirmUI))
    {
      a(paramActivity, WalletPayUSetPasswordUI.class, paramInt);
      AppMethodBeat.o(72024);
      return;
    }
    b(paramActivity, this.hPH);
    AppMethodBeat.o(72024);
  }
  
  public final boolean j(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72025);
    paramBundle.putInt("key_open_error_code", 1);
    aa.makeText(paramActivity, paramActivity.getString(a.i.wallet_payu_start_failed), 0).show();
    b(paramActivity, paramBundle);
    AppMethodBeat.o(72025);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c
 * JD-Core Version:    0.7.0.1
 */