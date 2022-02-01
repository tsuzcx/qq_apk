package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class e
  extends com.tencent.mm.wallet_core.e
{
  public final com.tencent.mm.wallet_core.c.g a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.i parami)
  {
    AppMethodBeat.i(72287);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new e.1(this, paramMMActivity, parami);
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCheckIdentityUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72269);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wxcredit.a.a))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wxcredit.a.a)paramAnonymousp;
              e.h(e.this).putString("KEY_SESSION_KEY", paramAnonymousString.token);
              e.i(e.this).putString("key_mobile", paramAnonymousString.hRk);
              e.j(e.this).putBoolean("key_need_bind_deposit", paramAnonymousString.igv);
              e.k(e.this).putBoolean("key_is_bank_user", paramAnonymousString.XHu);
            }
            e.this.a(this.activity, 0, e.l(e.this));
            AppMethodBeat.o(72269);
            return true;
          }
          AppMethodBeat.o(72269);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72270);
          String str = (String)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[1];
          e.m(e.this).putString("key_name", str);
          e.n(e.this).putString("key_indentity", paramAnonymousVarArgs);
          this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.a(str, paramAnonymousVarArgs, e.o(e.this).getString("KEY_SESSION_KEY"), e.p(e.this).getString("key_bank_type")), true, 1);
          AppMethodBeat.o(72270);
          return true;
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72271);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wxcredit.a.g))
            {
              paramAnonymousString = ((com.tencent.mm.plugin.wxcredit.a.g)paramAnonymousp).hUQ;
              if (!Util.isNullOrNil(paramAnonymousString)) {
                e.q(e.this).putString("key_bank_username", paramAnonymousString);
              }
              e.this.a(this.activity, 0, e.r(e.this));
              AppMethodBeat.o(72271);
              return true;
            }
            if ((paramAnonymousp instanceof h))
            {
              e.this.a(this.activity, 0, e.s(e.this));
              AppMethodBeat.o(72271);
              return true;
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.c.w))
            {
              if (u.iiC().ijf())
              {
                this.agTR.a(new ae(), true, 1);
                AppMethodBeat.o(72271);
                return true;
              }
              e.this.a(this.activity, 0, e.t(e.this));
              AppMethodBeat.o(72271);
              return true;
            }
            if ((paramAnonymousp instanceof ae))
            {
              paramAnonymousString = u.iiC().ijN();
              paramAnonymousString = new com.tencent.mm.plugin.wxcredit.a.g(e.u(e.this).getString("key_verify_code"), e.v(e.this).getString("KEY_SESSION_KEY"), e.w(e.this).getString("key_pwd1"), paramAnonymousString, e.x(e.this).getString("key_bank_type"));
              this.agTR.a(paramAnonymousString, true, 1);
              AppMethodBeat.o(72271);
              return true;
            }
            AppMethodBeat.o(72271);
            return false;
          }
          AppMethodBeat.o(72271);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72272);
          String str = (String)paramAnonymousVarArgs[0];
          e.y(e.this).putString("key_verify_code", str);
          if (u.iiC().ijf()) {
            if ((e.z(e.this).getBoolean("key_need_bind_deposit", true)) && (!e.A(e.this).getBoolean("key_is_bank_user")))
            {
              paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.w)paramAnonymousVarArgs[1];
              paramAnonymousVarArgs.flag = "2";
              this.agTR.a(new com.tencent.mm.plugin.wallet_core.c.w(paramAnonymousVarArgs), true, 1);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(72272);
            return true;
            this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.B(e.this).getString("KEY_SESSION_KEY"), e.C(e.this).getString("key_pwd1"), e.D(e.this).getString("key_bind_serial"), e.E(e.this).getString("key_bank_type")), true, 1);
            continue;
            if (e.F(e.this).getBoolean("key_is_bank_user", false))
            {
              e.G(e.this).putString("key_verify_code", str);
              this.agTR.a(new h(str, e.H(e.this).getString("KEY_SESSION_KEY"), e.I(e.this).getString("key_pwd1"), e.J(e.this).getString("key_bind_serial"), e.K(e.this).getString("key_bank_type")), true, 1);
            }
            else
            {
              paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.w)paramAnonymousVarArgs[1];
              paramAnonymousVarArgs.flag = "1";
              this.agTR.a(new com.tencent.mm.plugin.wallet_core.c.w(paramAnonymousVarArgs), true, 1);
            }
          }
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBindDepositUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        private Authen VmM;
        
        public final boolean E(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72278);
          this.agTR.a(new z("", (String)paramAnonymousVarArgs[0], (PayInfo)e.Z(e.this).getParcelable("key_pay_info")), true, 1);
          AppMethodBeat.o(72278);
          return true;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72276);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.b.a.a)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousp;
            if (paramAnonymousString.Vxt == null)
            {
              Log.d("MicroMsg.OpenWXCreditProcess", "reqKey  " + paramAnonymousString.mReqKey);
              e.P(e.this).putString("kreq_token", paramAnonymousString.getToken());
              e.this.a(this.activity, 0, e.Q(e.this));
            }
            for (;;)
            {
              AppMethodBeat.o(72276);
              return true;
              Log.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
              k.b(this.activity, paramAnonymousString.Vxt.wording, "", paramAnonymousString.Vxt.VJn, paramAnonymousString.Vxt.VJm, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72274);
                  Log.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard dialog lOk");
                  e.4.b(e.4.this).a(new com.tencent.mm.plugin.wallet_core.b.a.a(e.4.a(e.4.this), "1", ""), true, 1);
                  v.BI(1);
                  AppMethodBeat.o(72274);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72275);
                  Log.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                  v.BI(0);
                  AppMethodBeat.o(72275);
                }
              });
            }
          }
          AppMethodBeat.o(72276);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72277);
          m.imd();
          this.VmM = new Authen();
          this.VmM.VCD = ((String)paramAnonymousVarArgs[0]);
          this.VmM.hAk = ((String)paramAnonymousVarArgs[1]);
          this.VmM.VxX = ((String)paramAnonymousVarArgs[2]);
          e.R(e.this).putString("key_bank_phone", (String)paramAnonymousVarArgs[3]);
          paramAnonymousVarArgs = this.VmM;
          if (u.iiC().ijf()) {}
          for (int i = 2;; i = 1)
          {
            paramAnonymousVarArgs.eQp = i;
            this.VmM.VCC = 1;
            this.VmM.Nxi = ((PayInfo)e.S(e.this).getParcelable("key_pay_info"));
            this.VmM.VCA = e.T(e.this).getString("key_pwd1");
            if (!e.U(e.this).getBoolean("key_has_indentity_info", false))
            {
              this.VmM.VBL = e.V(e.this).getString("key_name");
              this.VmM.VCB = e.W(e.this).getString("key_indentity");
            }
            paramAnonymousVarArgs = com.tencent.mm.wallet_core.ui.i.bEO(this.VmM.VxX);
            e.X(e.this).putString("key_mobile", paramAnonymousVarArgs);
            e.Y(e.this).putBoolean("key_is_oversea", false);
            this.agTR.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.VmM, "", ""), true, 1);
            AppMethodBeat.o(72277);
            return true;
          }
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72279);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof b))
            {
              this.agTR.a(new ae(), true, 1);
              AppMethodBeat.o(72279);
              return true;
            }
            if ((paramAnonymousp instanceof ae))
            {
              paramAnonymousString = new com.tencent.mm.plugin.wxcredit.a.g(e.aa(e.this).getString("key_verify_code"), e.ab(e.this).getString("KEY_SESSION_KEY"), e.ac(e.this).getString("key_pwd1"), u.iiC().ijN(), e.ad(e.this).getString("key_bank_type"));
              this.agTR.a(paramAnonymousString, true, 1);
              AppMethodBeat.o(72279);
              return true;
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wxcredit.a.g))
            {
              paramAnonymousString = ((com.tencent.mm.plugin.wxcredit.a.g)paramAnonymousp).hUQ;
              if (!Util.isNullOrNil(paramAnonymousString)) {
                e.ae(e.this).putString("key_bank_username", paramAnonymousString);
              }
              e.this.a(this.activity, 0, e.af(e.this));
              AppMethodBeat.o(72279);
              return true;
            }
          }
          AppMethodBeat.o(72279);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72280);
          if (!e.ag(e.this).getBoolean("key_is_bank_user", false)) {
            this.agTR.a(new b((com.tencent.mm.plugin.wallet_core.model.w)paramAnonymousVarArgs[0]), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(72280);
            return true;
            this.agTR.a(new com.tencent.mm.plugin.wxcredit.a.g(e.ah(e.this).getString("key_verify_code"), e.ai(e.this).getString("KEY_SESSION_KEY"), e.aj(e.this).getString("key_pwd1"), u.iiC().ijN(), e.ak(e.this).getString("key_bank_type")), true, 1);
          }
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletWXCreditOpenResultUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.c.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(72281);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            e.this.a(this.activity, 0, e.al(e.this));
            AppMethodBeat.o(72281);
            return true;
          }
          AppMethodBeat.o(72281);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72282);
          e.am(e.this).putBoolean("key_is_follow_bank_username", ((Boolean)paramAnonymousVarArgs[0]).booleanValue());
          e.an(e.this);
          this.agTR.a(new ae(), true, 1);
          AppMethodBeat.o(72282);
          return true;
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    AppMethodBeat.o(72287);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72283);
    if (u.iiC().ijl()) {
      Log.e("MicroMsg.OpenWXCreditProcess", "unknow wallet reg status!");
    }
    for (;;)
    {
      AppMethodBeat.o(72283);
      return this;
      if (u.iiC().ijf()) {
        b(paramActivity, WalletCheckPwdUI.class, paramBundle);
      } else {
        b(paramActivity, WalletWXCreditOpenUI.class, paramBundle);
      }
    }
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(72284);
    if ((paramActivity instanceof WalletWXCreditOpenUI))
    {
      b(paramActivity, WalletCheckIdentityUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      Z(paramActivity);
      b(paramActivity, WalletWXCreditOpenUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditOpenUI))
    {
      b(paramActivity, WalletCheckIdentityUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletCheckIdentityUI))
    {
      if (paramBundle.getBoolean("key_need_bind_deposit", true))
      {
        b(paramActivity, WalletBindDepositUI.class, paramBundle);
        AppMethodBeat.o(72284);
        return;
      }
      b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletBindDepositUI))
    {
      b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletVerifyCodeUI))
    {
      if (u.iiC().ijf())
      {
        b(paramActivity, WalletWXCreditOpenResultUI.class, paramBundle);
        AppMethodBeat.o(72284);
        return;
      }
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      b(paramActivity, WalletWXCreditOpenResultUI.class, paramBundle);
      AppMethodBeat.o(72284);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditOpenResultUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(72284);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72286);
    g(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
    AppMethodBeat.o(72286);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "WXCreditOpenProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72285);
    Z(paramActivity);
    AppMethodBeat.o(72285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e
 * JD-Core Version:    0.7.0.1
 */