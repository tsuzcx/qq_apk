package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public class e
  extends d
{
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
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
      paramMMActivity = new e.2(this, paramMMActivity, parami);
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72271);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wxcredit.a.g))
            {
              paramAnonymousString = ((com.tencent.mm.plugin.wxcredit.a.g)paramAnonymousn).dCB;
              if (!bt.isNullOrNil(paramAnonymousString)) {
                e.q(e.this).putString("key_bank_username", paramAnonymousString);
              }
              e.this.a(this.activity, 0, e.r(e.this));
              AppMethodBeat.o(72271);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wxcredit.a.h))
            {
              e.this.a(this.activity, 0, e.s(e.this));
              AppMethodBeat.o(72271);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.c.v))
            {
              if (t.eFy().eGa())
              {
                this.LyU.a(new com.tencent.mm.plugin.wallet_core.c.ad(), true, 1);
                AppMethodBeat.o(72271);
                return true;
              }
              e.this.a(this.activity, 0, e.t(e.this));
              AppMethodBeat.o(72271);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
            {
              paramAnonymousString = t.eFy().eGE();
              paramAnonymousString = new com.tencent.mm.plugin.wxcredit.a.g(e.u(e.this).getString("key_verify_code"), e.v(e.this).getString("KEY_SESSION_KEY"), e.w(e.this).getString("key_pwd1"), paramAnonymousString, e.x(e.this).getString("key_bank_type"));
              this.LyU.a(paramAnonymousString, true, 1);
              AppMethodBeat.o(72271);
              return true;
            }
            AppMethodBeat.o(72271);
            return false;
          }
          AppMethodBeat.o(72271);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72272);
          String str = (String)paramAnonymousVarArgs[0];
          e.y(e.this).putString("key_verify_code", str);
          if (t.eFy().eGa()) {
            if ((e.z(e.this).getBoolean("key_need_bind_deposit", true)) && (!e.A(e.this).getBoolean("key_is_bank_user")))
            {
              paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.v)paramAnonymousVarArgs[1];
              paramAnonymousVarArgs.flag = "2";
              this.LyU.a(new com.tencent.mm.plugin.wallet_core.c.v(paramAnonymousVarArgs), true, 1);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(72272);
            return true;
            this.LyU.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.B(e.this).getString("KEY_SESSION_KEY"), e.C(e.this).getString("key_pwd1"), e.D(e.this).getString("key_bind_serial"), e.E(e.this).getString("key_bank_type")), true, 1);
            continue;
            if (e.F(e.this).getBoolean("key_is_bank_user", false))
            {
              e.G(e.this).putString("key_verify_code", str);
              this.LyU.a(new com.tencent.mm.plugin.wxcredit.a.h(str, e.H(e.this).getString("KEY_SESSION_KEY"), e.I(e.this).getString("key_pwd1"), e.J(e.this).getString("key_bind_serial"), e.K(e.this).getString("key_bank_type")), true, 1);
            }
            else
            {
              paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.v)paramAnonymousVarArgs[1];
              paramAnonymousVarArgs.flag = "1";
              this.LyU.a(new com.tencent.mm.plugin.wallet_core.c.v(paramAnonymousVarArgs), true, 1);
            }
          }
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletBindDepositUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        Authen CIo;
        
        public final boolean A(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72278);
          this.LyU.a(new y("", (String)paramAnonymousVarArgs[0], (PayInfo)e.Z(e.this).getParcelable("key_pay_info")), true, 1);
          AppMethodBeat.o(72278);
          return true;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72276);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && ((paramAnonymousn instanceof a)))
          {
            paramAnonymousString = (a)paramAnonymousn;
            if (paramAnonymousString.COB == null)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.OpenWXCreditProcess", "reqKey  " + paramAnonymousString.mReqKey);
              e.P(e.this).putString("kreq_token", paramAnonymousString.getToken());
              e.this.a(this.activity, 0, e.Q(e.this));
            }
            for (;;)
            {
              AppMethodBeat.o(72276);
              return true;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
              com.tencent.mm.ui.base.h.e(this.activity, paramAnonymousString.COB.dxD, "", paramAnonymousString.COB.Dae, paramAnonymousString.COB.Dad, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72274);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard dialog lOk");
                  e.4.this.LyU.a(new a(e.4.this.CIo, "1", ""), true, 1);
                  u.tQ(1);
                  AppMethodBeat.o(72274);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72275);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                  u.tQ(0);
                  AppMethodBeat.o(72275);
                }
              });
            }
          }
          AppMethodBeat.o(72276);
          return false;
        }
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72277);
          f.eIT();
          this.CIo = new Authen();
          this.CIo.CTS = ((String)paramAnonymousVarArgs[0]);
          this.CIo.dkR = ((String)paramAnonymousVarArgs[1]);
          this.CIo.CPf = ((String)paramAnonymousVarArgs[2]);
          e.R(e.this).putString("key_bank_phone", (String)paramAnonymousVarArgs[3]);
          paramAnonymousVarArgs = this.CIo;
          if (t.eFy().eGa()) {}
          for (int i = 2;; i = 1)
          {
            paramAnonymousVarArgs.dDp = i;
            this.CIo.CTR = 1;
            this.CIo.xnF = ((PayInfo)e.S(e.this).getParcelable("key_pay_info"));
            this.CIo.CTP = e.T(e.this).getString("key_pwd1");
            if (!e.U(e.this).getBoolean("key_has_indentity_info", false))
            {
              this.CIo.CTa = e.V(e.this).getString("key_name");
              this.CIo.CTQ = e.W(e.this).getString("key_indentity");
            }
            paramAnonymousVarArgs = com.tencent.mm.wallet_core.ui.e.aYI(this.CIo.CPf);
            e.X(e.this).putString("key_mobile", paramAnonymousVarArgs);
            e.Y(e.this).putBoolean("key_is_oversea", false);
            this.LyU.a(new a(this.CIo, "", ""), true, 1);
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
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(72279);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof b))
            {
              this.LyU.a(new com.tencent.mm.plugin.wallet_core.c.ad(), true, 1);
              AppMethodBeat.o(72279);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
            {
              paramAnonymousString = new com.tencent.mm.plugin.wxcredit.a.g(e.aa(e.this).getString("key_verify_code"), e.ab(e.this).getString("KEY_SESSION_KEY"), e.ac(e.this).getString("key_pwd1"), t.eFy().eGE(), e.ad(e.this).getString("key_bank_type"));
              this.LyU.a(paramAnonymousString, true, 1);
              AppMethodBeat.o(72279);
              return true;
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wxcredit.a.g))
            {
              paramAnonymousString = ((com.tencent.mm.plugin.wxcredit.a.g)paramAnonymousn).dCB;
              if (!bt.isNullOrNil(paramAnonymousString)) {
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
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72280);
          if (!e.ag(e.this).getBoolean("key_is_bank_user", false)) {
            this.LyU.a(new b((com.tencent.mm.plugin.wallet_core.model.v)paramAnonymousVarArgs[0]), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(72280);
            return true;
            this.LyU.a(new com.tencent.mm.plugin.wxcredit.a.g(e.ah(e.this).getString("key_verify_code"), e.ai(e.this).getString("KEY_SESSION_KEY"), e.aj(e.this).getString("key_pwd1"), t.eFy().eGE(), e.ak(e.this).getString("key_bank_type")), true, 1);
          }
        }
      };
      AppMethodBeat.o(72287);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletWXCreditOpenResultUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
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
        
        public final boolean s(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(72282);
          e.am(e.this).putBoolean("key_is_follow_bank_username", ((Boolean)paramAnonymousVarArgs[0]).booleanValue());
          e.an(e.this);
          this.LyU.a(new com.tencent.mm.plugin.wallet_core.c.ad(), true, 1);
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
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72283);
    if (t.eFy().eGf()) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.OpenWXCreditProcess", "unknow wallet reg status!");
    }
    for (;;)
    {
      AppMethodBeat.o(72283);
      return this;
      if (t.eFy().eGa()) {
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
      Q(paramActivity);
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
      if (t.eFy().eGa())
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
    e(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
    AppMethodBeat.o(72286);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cQc()
  {
    return "WXCreditOpenProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72285);
    Q(paramActivity);
    AppMethodBeat.o(72285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e
 * JD-Core Version:    0.7.0.1
 */