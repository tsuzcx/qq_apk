package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

public class c
  extends com.tencent.mm.wallet_core.d
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(72027);
    if (paramInt == 1)
    {
      AppMethodBeat.o(72027);
      return 2131765713;
    }
    paramInt = super.a(paramMMActivity, paramInt);
    AppMethodBeat.o(72027);
    return paramInt;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(72028);
    if ((paramMMActivity instanceof WalletPayUStartOpenUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72012);
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_payu.a.b))
          {
            ac.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet_payu.a.b)paramAnonymousn;
              c.this.dmf.putString("payu_reference", paramAnonymousString.dnh);
              ac.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[] { paramAnonymousString.dnh });
              c.this.dmf.putBoolean("key_is_has_mobile", paramAnonymousString.BSk);
              com.tencent.mm.wallet_core.a.k(this.activity, c.this.dmf);
              AppMethodBeat.o(72012);
              return true;
            }
          }
          AppMethodBeat.o(72012);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72013);
          this.JFQ.b(new com.tencent.mm.plugin.wallet_payu.a.b(c.this.dmf.getString("dial_code"), c.this.dmf.getString("key_mobile")), true);
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
        public final boolean A(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72014);
          this.JFQ.a(new com.tencent.mm.plugin.wallet_payu.a.b(c.this.dmf.getString("dial_code"), c.this.dmf.getString("key_mobile")), true, 1);
          AppMethodBeat.o(72014);
          return true;
        }
        
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(72017);
          if (paramAnonymousInt == 0)
          {
            localObject = this.activity.getString(2131765905, new Object[] { e.aSJ("+" + c.b(c.this).getString("dial_code") + c.c(c.this).getString("key_mobile")) });
            AppMethodBeat.o(72017);
            return localObject;
          }
          Object localObject = super.getTips(paramAnonymousInt);
          AppMethodBeat.o(72017);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72015);
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_payu.a.a))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet_payu.a.a)paramAnonymousn;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString.xte))
            {
              c.a(c.this).putString("payu_reference", paramAnonymousString.BSj);
              com.tencent.mm.wallet_core.a.k(this.activity, c.this.dmf);
              AppMethodBeat.o(72015);
              return true;
            }
          }
          else if (((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_payu.a.b)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet_payu.a.b)paramAnonymousn;
            c.this.dmf.putString("payu_reference", paramAnonymousString.dnh);
            AppMethodBeat.o(72015);
            return true;
          }
          AppMethodBeat.o(72015);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72016);
          this.JFQ.b(new com.tencent.mm.plugin.wallet_payu.a.a((String)paramAnonymousVarArgs[0], c.this.dmf.getString("payu_reference")), true);
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72019);
          if (((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            c.this.dmf.putParcelableArrayList("key_security_question_list", ((com.tencent.mm.plugin.wallet_payu.security_question.model.d)paramAnonymousn).BTv);
            AppMethodBeat.o(72019);
            return true;
          }
          AppMethodBeat.o(72019);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          return false;
        }
        
        public final boolean z(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72018);
          this.JFQ.b(new com.tencent.mm.plugin.wallet_payu.security_question.model.d(), true);
          AppMethodBeat.o(72018);
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
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72020);
          if (((paramAnonymousn instanceof a)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ac.d("MicroMsg.PayUOpenProcess", "hy: create user success");
            com.tencent.mm.wallet_core.a.b(this.activity, c.this.dmf, 0);
            c.d(c.this).putInt("key_open_error_code", 0);
            t.makeText(this.activity, this.activity.getString(2131765730), 0).show();
            AppMethodBeat.o(72020);
            return true;
          }
          if (((paramAnonymousn instanceof b)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ac.d("MicroMsg.PayUOpenProcess", "hy: link user success");
            com.tencent.mm.wallet_core.a.b(this.activity, c.this.dmf, 0);
            c.e(c.this).putInt("key_open_error_code", 0);
            t.makeText(this.activity, this.activity.getString(2131765730), 0).show();
            AppMethodBeat.o(72020);
            return true;
          }
          AppMethodBeat.o(72020);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72021);
          Object localObject = (u)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = c.this.dmf.getString("dial_code");
          String str1 = c.this.dmf.getString("key_mobile");
          localObject = ((u)localObject).iJA;
          String str2 = c.this.dmf.getString("key_question_id");
          String str3 = c.this.dmf.getString("key_question_answer");
          String str4 = c.this.dmf.getString("payu_reference");
          if (!c.this.dmf.getBoolean("key_is_has_mobile")) {
            this.JFQ.b(new a(paramAnonymousVarArgs, str1, (String)localObject, str2, str3, str4), true);
          }
          for (;;)
          {
            AppMethodBeat.o(72021);
            return true;
            this.JFQ.b(new b(paramAnonymousVarArgs, str1, (String)localObject, str4), true);
          }
        }
      };
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUSecurityQuestionAnswerUI))
    {
      paramMMActivity = new com.tencent.mm.plugin.wallet_payu.security_question.model.a(paramMMActivity, parami, this.dmf);
      AppMethodBeat.o(72028);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(72028);
    return paramMMActivity;
  }
  
  public final com.tencent.mm.wallet_core.d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72022);
    ac.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
    s.epp();
    String str1 = s.aEt();
    s.epp();
    String str2 = s.epr();
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
      ac.i("MicroMsg.PayUOpenProcess", "hy: user open success");
      e(paramActivity, "mall", ".ui.MallIndexUI");
      AppMethodBeat.o(72026);
      return;
    }
    ac.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
    super.bt(paramActivity);
    e.kC(paramActivity);
    AppMethodBeat.o(72026);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cHN()
  {
    return "PayUOpenProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72024);
    if ((paramActivity instanceof WalletPayUPwdConfirmUI))
    {
      a(paramActivity, WalletPayUSetPasswordUI.class, paramInt);
      AppMethodBeat.o(72024);
      return;
    }
    b(paramActivity, this.dmf);
    AppMethodBeat.o(72024);
  }
  
  public final boolean i(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72025);
    paramBundle.putInt("key_open_error_code", 1);
    t.makeText(paramActivity, paramActivity.getString(2131765724), 0).show();
    b(paramActivity, paramBundle);
    AppMethodBeat.o(72025);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c
 * JD-Core Version:    0.7.0.1
 */