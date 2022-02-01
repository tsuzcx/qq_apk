package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.model.j;
import com.tencent.mm.plugin.wallet_core.id_verify.model.k;
import com.tencent.mm.plugin.wallet_core.id_verify.model.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  private int bRZ;
  private boolean gna;
  private String mActivityName;
  private int mMode;
  private String mPluginName;
  private c<kb> ujv;
  private boolean zXg;
  private int zXh;
  public a zXi;
  
  public a()
  {
    AppMethodBeat.i(69999);
    this.mPluginName = null;
    this.mActivityName = null;
    this.zXg = false;
    this.bRZ = 0;
    this.zXh = -1;
    this.gna = false;
    this.ujv = new c() {};
    AppMethodBeat.o(69999);
  }
  
  private boolean ebp()
  {
    AppMethodBeat.i(70002);
    boolean bool = "rename".equals(this.dow.getString("key_realname_scene"));
    AppMethodBeat.o(70002);
    return bool;
  }
  
  private boolean g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(70006);
    com.tencent.mm.wallet_core.b.fjk();
    if ((com.tencent.mm.wallet_core.b.b(b.a.pre, false)) && (s.ecc().ecN().ecx()))
    {
      com.tencent.mm.sdk.b.a.ESL.b(this.ujv);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.RealNameVerifyProcess", "startKindaBindCard:true");
      if (paramBundle != null)
      {
        ab.jZ(6, paramBundle.getInt("key_bind_scene"));
        z.abt(paramBundle.getInt("key_bind_scene"));
      }
      for (;;)
      {
        paramBundle.putInt("key_bind_scene", 10);
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
        AppMethodBeat.o(70006);
        return true;
        ab.jZ(6, 0);
        z.abt(0);
      }
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.RealNameVerifyProcess", "startKindaBindCard:false");
    AppMethodBeat.o(70006);
    return false;
  }
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131765335;
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(70005);
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      if ((this.mMode == 2) || (this.mMode == 4))
      {
        paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
        {
          public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(69986);
            if ((paramAnonymousn instanceof f))
            {
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                if (((f)paramAnonymousn).zVU == 0) {
                  a.k(a.this).putInt("realname_verify_process_ret", -1);
                }
                a.l(a.this).putString("realname_verify_process_finish_title", ((f)paramAnonymousn).title);
                a.m(a.this).putString("realname_verify_process_finish_desc", ((f)paramAnonymousn).desc);
                a.n(a.this).putString("realname_verify_process_finish_page", ((f)paramAnonymousn).huS);
                a.o(a.this).putInt("realname_verify_process_finish_err_jump", ((f)paramAnonymousn).zVU);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                s.ecc().VP();
                paramAnonymousString = new xf();
                paramAnonymousString.dCH.scene = 16;
                paramAnonymousString.callback = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(69983);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                    AppMethodBeat.o(69983);
                  }
                };
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
                a.a(a.this, this.Ieo);
                if (a.p(a.this) == 2) {
                  a.this.b(this.activity, a.q(a.this));
                }
                for (;;)
                {
                  AppMethodBeat.o(69986);
                  return true;
                  a.this.a(this.activity, 0, a.r(a.this));
                }
              }
            }
            else if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.b.a.b))
            {
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).zVU == 0) {
                  a.s(a.this).putInt("realname_verify_process_ret", -1);
                }
                a.t(a.this).putString("realname_verify_process_finish_title", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).title);
                a.u(a.this).putString("realname_verify_process_finish_desc", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).desc);
                a.v(a.this).putString("realname_verify_process_finish_page", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).huS);
                a.w(a.this).putInt("realname_verify_process_finish_err_jump", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).zVU);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "bind card verify succ ,update user info");
                if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).zVT != null) {
                  a.x(a.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousn).zVT);
                }
                s.ecc().VP();
                paramAnonymousString = new xf();
                paramAnonymousString.dCH.scene = 16;
                paramAnonymousString.callback = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(69984);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                    AppMethodBeat.o(69984);
                  }
                };
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
                a.b(a.this, this.Ieo);
                if (a.p(a.this) == 2) {
                  a.this.b(this.activity, a.y(a.this));
                }
                for (;;)
                {
                  AppMethodBeat.o(69986);
                  return true;
                  a.this.a(this.activity, 0, a.z(a.this));
                }
              }
            }
            else if ((paramAnonymousn instanceof m))
            {
              AppMethodBeat.o(69986);
              return true;
            }
            AppMethodBeat.o(69986);
            return false;
          }
          
          public final boolean q(Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(69985);
            paramAnonymousVarArgs = (u)paramAnonymousVarArgs[0];
            String str1 = a.f(a.this).getString("key_real_name_token");
            String str2 = a.g(a.this).getString("realname_verify_process_face_token");
            String str3 = a.h(a.this).getString("key_realname_sessionid");
            RealNameBundle localRealNameBundle = (RealNameBundle)a.i(a.this).getParcelable("realname_verify_process_bundle");
            if ((paramAnonymousVarArgs == null) || (bt.isNullOrNil(paramAnonymousVarArgs.ijt))) {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
            }
            for (;;)
            {
              AppMethodBeat.o(69985);
              return true;
              if (a.j(a.this).containsKey("kreq_token"))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "bindcard verify");
                this.Ieo.b(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs, a.this.dow.getInt("entry_scene", -1), str3, localRealNameBundle), true);
              }
              else
              {
                paramAnonymousVarArgs = new f(paramAnonymousVarArgs.ijt, str1, str2, a.this.dow.getInt("entry_scene", -1), str3, localRealNameBundle);
                this.Ieo.b(paramAnonymousVarArgs, true);
              }
            }
          }
        };
        AppMethodBeat.o(70005);
        return paramMMActivity;
      }
      paramMMActivity = super.a(paramMMActivity, parami);
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletRealNameVerifyUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69987);
          Object localObject = null;
          if (paramAnonymousInt == 0)
          {
            String str = this.activity.getString(2131765755);
            localObject = this.activity.getString(2131765751);
            str = this.activity.getString(2131765761, new Object[] { str, localObject });
            l locall = new l(this.activity);
            SpannableString localSpannableString = new SpannableString(str);
            localSpannableString.setSpan(locall, str.length() - ((String)localObject).length(), str.length(), 33);
            localObject = localSpannableString.subSequence(0, localSpannableString.length());
          }
          AppMethodBeat.o(69987);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    if (((paramMMActivity instanceof WalletCardElementUI)) || ((paramMMActivity instanceof WalletCardImportUI)))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        Authen zPG;
        
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(69993);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousInt1 == 1)
          {
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.getExtras() != null))
            {
              paramAnonymousIntent = paramAnonymousIntent.getExtras().getString("token");
              a.this.dow.putString("realname_verify_process_face_token", paramAnonymousIntent);
              a.this.a(this.activity, 0, a.this.dow);
              AppMethodBeat.o(69993);
            }
          }
          else {
            super.onActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          }
          AppMethodBeat.o(69993);
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69990);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousn;
              if (paramAnonymousString.zVS == null)
              {
                a.A(a.this).putString("kreq_token", paramAnonymousString.getToken());
                if (a.this.c(this.activity, a.B(a.this)))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "need update bankcardlist");
                  this.Ieo.b(new com.tencent.mm.plugin.wallet_core.c.ad(null, 12), true);
                }
              }
              for (;;)
              {
                AppMethodBeat.o(69990);
                return true;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "not need update bankcardlist");
                a.this.a(this.activity, 0, a.C(a.this));
                continue;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                h.d(this.activity, paramAnonymousString.zVS.doh, "", paramAnonymousString.zVS.Ahr, paramAnonymousString.zVS.Ahq, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69988);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard dialog lOk");
                    paramAnonymous2DialogInterface = a.D(a.this).getString("key_realname_sessionid");
                    a.4.this.Ieo.a(new com.tencent.mm.plugin.wallet_core.b.a.a(a.4.this.zPG, "1", paramAnonymous2DialogInterface), true, 1);
                    t.sw(1);
                    AppMethodBeat.o(69988);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69989);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                    t.sw(0);
                    AppMethodBeat.o(69989);
                  }
                });
              }
            }
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "update bankcardlist success!");
              a.this.a(this.activity, 0, a.E(a.this));
              AppMethodBeat.o(69990);
              return true;
            }
          }
          AppMethodBeat.o(69990);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69992);
          a.this.H(new Object[] { "onNext", paramAnonymousVarArgs });
          this.zPG = ((Authen)paramAnonymousVarArgs[0]);
          this.zPG.dtM = a.F(a.this);
          paramAnonymousVarArgs = a.G(a.this).getString("key_realname_sessionid");
          this.Ieo.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.zPG, "", paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(69992);
          return true;
        }
      };
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69997);
          String str = this.activity.getString(2131765903);
          AppMethodBeat.o(69997);
          return str;
        }
        
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(69995);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousInt1 == 1)
          {
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.getExtras() != null))
            {
              paramAnonymousIntent = paramAnonymousIntent.getExtras().getString("token");
              a.this.dow.putString("realname_verify_process_face_token", paramAnonymousIntent);
              a.this.a(this.activity, 0, a.this.dow);
              AppMethodBeat.o(69995);
            }
          }
          else {
            super.onActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          }
          AppMethodBeat.o(69995);
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69994);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "verify code success!");
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousn;
              a.H(a.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(69994);
              return true;
            }
            if ((paramAnonymousn instanceof v))
            {
              a.c(a.this, this.Ieo);
              if (((v)paramAnonymousn).zVT != null) {
                a.I(a.this).putParcelable("key_bindcard_value_result", ((v)paramAnonymousn).zVT);
              }
              a.J(a.this).putString("key_resetpwd", ((v)paramAnonymousn).action);
              boolean bool = a.K(a.this).getBoolean("realname_verify_process_need_face", false);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "forward: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                paramAnonymousString = new qn();
                paramAnonymousString.dwe.djj = this.activity;
                paramAnonymousString.dwe.scene = ((int)a.L(a.this).getLong("realname_verify_process_face_scene"));
                paramAnonymousString.dwe.packageName = a.M(a.this).getString("realname_verify_process_face_package");
                paramAnonymousString.dwe.dwg = a.N(a.this).getString("realname_verify_process_face_package_sign");
                paramAnonymousString.dwe.requestCode = 1;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
              }
              for (;;)
              {
                AppMethodBeat.o(69994);
                return true;
                a.this.a(this.activity, 0, a.O(a.this));
              }
            }
            if ((paramAnonymousn instanceof m))
            {
              AppMethodBeat.o(69994);
              return true;
            }
          }
          AppMethodBeat.o(69994);
          return false;
        }
        
        public final boolean q(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69996);
          a.this.H(new Object[] { "WalletVerifyCodeUI onNext", paramAnonymousVarArgs });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "onNext, do bind verify!");
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          if ((s.ecc().ecF()) && (!a.P(a.this))) {}
          for (paramAnonymousVarArgs.flag = "2";; paramAnonymousVarArgs.flag = "1")
          {
            String str = a.Q(a.this).getString("key_realname_sessionid");
            this.Ieo.a(new v(paramAnonymousVarArgs, a.this.dow.getInt("entry_scene", -1), str), true, 1);
            AppMethodBeat.o(69996);
            return true;
          }
        }
      };
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WcPayRealnameVerifyCodeUI))
    {
      paramMMActivity = new b(paramMMActivity, parami);
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(70005);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(70000);
    H(new Object[] { "start", paramActivity, paramBundle });
    if (this.dow == null) {
      this.dow = new Bundle();
    }
    b(paramActivity, WcPayRealnameProxyUI.class, paramBundle);
    AppMethodBeat.o(70000);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(70003);
    H(new Object[] { "forward", paramActivity, "actionCode:".concat(String.valueOf(paramInt)), paramBundle });
    int i = this.dow.getInt("real_name_verify_mode", this.mMode);
    if (this.mMode != i) {
      this.mMode = i;
    }
    Object localObject;
    boolean bool;
    if ((paramActivity instanceof WcPayRealnameProxyUI))
    {
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = this.dow;
      }
      if (localObject != null)
      {
        this.mMode = ((Bundle)localObject).getInt("real_name_verify_mode", 0);
        this.zXh = this.mMode;
        ((Bundle)localObject).putBoolean("key_is_realname_verify_process", true);
        this.mPluginName = ((Bundle)localObject).getString("realname_verify_process_jump_plugin", "");
        this.mActivityName = ((Bundle)localObject).getString("realname_verify_process_jump_activity", "");
        if (((Bundle)localObject).getInt("realname_verify_process_allow_idverify", 0) != 1) {
          break label267;
        }
        bool = true;
        label173:
        this.zXg = bool;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[] { Boolean.valueOf(this.zXg), this.mPluginName, this.mActivityName });
        switch (this.mMode)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(70003);
        return;
        this.mMode = 0;
        break;
        label267:
        bool = false;
        break label173;
        ((Bundle)localObject).putBoolean("key_need_bind_response", true);
        if (!g(paramActivity, (Bundle)localObject))
        {
          z.abt(10);
          super.a(paramActivity, (Bundle)localObject);
          AppMethodBeat.o(70003);
          return;
          z.abt(10);
          b(paramActivity, SwitchRealnameVerifyModeUI.class, (Bundle)localObject);
          AppMethodBeat.o(70003);
          return;
          b(paramActivity, WalletRealNameVerifyUI.class, (Bundle)localObject);
          AppMethodBeat.o(70003);
          return;
          paramBundle = this.dow.getString("key_realname_scene");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "realname scene: %s", new Object[] { paramBundle });
          if ("rename".equals(paramBundle))
          {
            b(paramActivity, WcPayRealnameVerifyIdInputUI.class, (Bundle)localObject);
            AppMethodBeat.o(70003);
            return;
          }
          b(paramActivity, WcPayRealnameVerifyMainUI.class, (Bundle)localObject);
        }
      }
    }
    if (this.mMode == 2)
    {
      if ((paramActivity instanceof WalletRealNameVerifyUI))
      {
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        AppMethodBeat.o(70003);
        return;
      }
      if ((paramActivity instanceof WalletSetPasswordUI))
      {
        b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
        AppMethodBeat.o(70003);
        return;
      }
      if ((!(paramActivity instanceof WalletPwdConfirmUI)) && ((paramActivity instanceof SwitchRealnameVerifyModeUI)))
      {
        b(paramActivity, WalletRealNameVerifyUI.class, paramBundle);
        this.mMode = 2;
        AppMethodBeat.o(70003);
      }
    }
    else
    {
      if (this.mMode == 1)
      {
        if ((paramActivity instanceof SwitchRealnameVerifyModeUI))
        {
          if (s.ecc().ecF())
          {
            b(paramActivity, WalletCheckPwdUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          b(paramActivity, WalletBankcardIdUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WalletCheckPwdUI))
        {
          b(paramActivity, WalletBankcardIdUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        super.a(paramActivity, paramInt, paramBundle);
        AppMethodBeat.o(70003);
        return;
      }
      if (this.mMode == 4)
      {
        if ((paramActivity instanceof WcPayRealnameVerifyMainUI))
        {
          b(paramActivity, WcPayRealnameVerifyIdInputUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WcPayRealnameVerifyIdInputUI))
        {
          if (paramBundle.getBoolean("realname_verify_process_need_bind_card", false))
          {
            if (g(paramActivity, paramBundle))
            {
              AppMethodBeat.o(70003);
              return;
            }
            if ((s.ecc().ecF()) && (!ebp()))
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(70003);
              return;
            }
            b(paramActivity, WalletBankcardIdUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          bool = this.dow.getBoolean("realname_verify_process_show_bindcard_page", false);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "show bind page: %s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            b(paramActivity, WcPayRealnameVerifyBindcardEntranceUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          b(paramActivity, WalletSetPasswordUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WcPayRealnameVerifyBindcardEntranceUI))
        {
          if (paramBundle.getBoolean("realname_verify_process_do_bind", false))
          {
            if (g(paramActivity, paramBundle))
            {
              AppMethodBeat.o(70003);
              return;
            }
            if ((s.ecc().ecF()) && (!ebp()))
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(70003);
              return;
            }
            b(paramActivity, WalletBankcardIdUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          if (this.dow.getBoolean("realname_verify_process_verify_sms_without_bindcard", false))
          {
            b(paramActivity, WcPayRealnameVerifyCodeUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          b(paramActivity, WalletSetPasswordUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WcPayRealnameVerifyCodeUI))
        {
          b(paramActivity, WalletSetPasswordUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WalletSetPasswordUI))
        {
          b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WalletPwdConfirmUI))
        {
          b(paramActivity, WcPayRealnameVerifySuccessUI.class, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        if ((paramActivity instanceof WalletVerifyCodeUI))
        {
          localObject = this.dow.getString("key_resetpwd");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "resetpwd: %s", new Object[] { localObject });
          if ("resetpwd".equals(localObject))
          {
            b(paramActivity, WalletSetPasswordUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          super.a(paramActivity, paramInt, paramBundle);
          AppMethodBeat.o(70003);
          return;
        }
        super.a(paramActivity, paramInt, paramBundle);
        AppMethodBeat.o(70003);
        return;
      }
      if ((paramActivity instanceof WalletRealNameVerifyUI))
      {
        b(paramActivity, WalletBankcardIdUI.class, paramBundle);
        this.mMode = 1;
        AppMethodBeat.o(70003);
        return;
      }
      super.a(paramActivity, paramInt, paramBundle);
    }
    AppMethodBeat.o(70003);
  }
  
  public final void b(final Activity paramActivity, final Bundle paramBundle)
  {
    AppMethodBeat.i(70004);
    H(new Object[] { "end", paramActivity, paramBundle });
    z.fjZ();
    if (paramBundle == null) {
      paramBundle = this.dow;
    }
    for (;;)
    {
      final Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      final xf localxf;
      if (this.mMode == 1)
      {
        fju();
        if (localBundle.getBoolean("intent_bind_end", false))
        {
          this.bRZ = -1;
          if (localBundle.containsKey("intent_bind_end")) {
            localBundle.remove("intent_bind_end");
          }
          if (localBundle.containsKey("key_is_bind_reg_process")) {
            localBundle.remove("key_is_bind_reg_process");
          }
          localBundle.putInt("realname_verify_process_ret", this.bRZ);
          paramBundle = new Intent();
          paramBundle.putExtras(localBundle);
          if (this.bRZ == -1) {
            Toast.makeText(paramActivity, paramActivity.getString(2131762206), 0).show();
          }
          localxf = new xf();
          if (this.bRZ != -1) {
            break label268;
          }
          localxf.dCH.scene = 17;
        }
      }
      for (;;)
      {
        localxf.callback = new Runnable()
        {
          public final void run()
          {
            Object localObject1 = null;
            AppMethodBeat.i(69982);
            localxf.callback = null;
            a.a(a.this);
            boolean bool1;
            boolean bool2;
            Object localObject2;
            if ((!bt.isNullOrNil(a.b(a.this))) && (!bt.isNullOrNil(a.c(a.this))))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.b(a.this) + a.c(a.this));
              bool1 = a.this.dow.getBoolean("process_finish_stay_orgpage", true);
              paramBundle.putExtra("key_process_is_end", true);
              paramBundle.putExtra("key_process_is_stay", bool1);
              bool2 = paramBundle.getExtras().getBoolean("is_from_new_cashier");
              localObject2 = paramBundle.getExtras().getString("start_activity_class", "");
            }
            try
            {
              localObject2 = Class.forName((String)localObject2);
              localObject1 = localObject2;
            }
            catch (Exception localException)
            {
              label161:
              break label161;
            }
            if (bool2)
            {
              if (localObject1 == null) {
                a.a(a.this, paramActivity, a.b(a.this), a.c(a.this), a.d(a.this), paramBundle, bool1);
              }
              for (;;)
              {
                if (a.e(a.this) != null) {
                  a.e(a.this).run(paramActivity);
                }
                AppMethodBeat.o(69982);
                return;
                a.a(a.this, paramActivity, (Class)localObject1);
              }
            }
            a.b(a.this, paramActivity, a.b(a.this), a.c(a.this), a.d(a.this), paramBundle, bool1);
            if (a.d(a.this) == -1)
            {
              localObject1 = new xr();
              ((xr)localObject1).dDT.result = a.d(a.this);
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            }
            AppMethodBeat.o(69982);
            return;
            a.this.b(paramActivity, a.d(a.this), localBundle);
            if (a.d(a.this) == -1)
            {
              localObject1 = new xr();
              ((xr)localObject1).dDT.result = a.d(a.this);
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            }
            AppMethodBeat.o(69982);
          }
        };
        localxf.callback.run();
        AppMethodBeat.o(70004);
        return;
        this.bRZ = 0;
        break;
        if (localBundle.containsKey("realname_verify_process_ret"))
        {
          this.bRZ = localBundle.getInt("realname_verify_process_ret", -1);
          break;
        }
        this.bRZ = 0;
        break;
        label268:
        if (this.bRZ == 0) {
          localxf.dCH.scene = 18;
        } else {
          localxf.dCH.scene = 0;
        }
      }
    }
  }
  
  public final String cuB()
  {
    return "realname_verify_process";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(70001);
    H(new Object[] { "back", paramActivity, Integer.valueOf(paramInt) });
    z.fjZ();
    if (((paramActivity instanceof SwitchRealnameVerifyModeUI)) || ((paramActivity instanceof WcPayRealnameVerifyMainUI)))
    {
      if (paramInt == 0)
      {
        b(paramActivity, this.dow);
        AppMethodBeat.o(70001);
      }
    }
    else if (((paramActivity instanceof WalletRealNameVerifyUI)) || ((paramActivity instanceof WalletBankcardIdUI)))
    {
      if (this.zXh != 0)
      {
        b(paramActivity, this.dow);
        AppMethodBeat.o(70001);
      }
    }
    else
    {
      if ((paramActivity instanceof WalletCheckPwdUI))
      {
        b(paramActivity, this.dow);
        AppMethodBeat.o(70001);
        return;
      }
      if ((paramActivity instanceof WalletPwdConfirmUI))
      {
        a(paramActivity, WalletSetPasswordUI.class, paramInt);
        AppMethodBeat.o(70001);
        return;
      }
      if ((paramActivity instanceof WcPayRealnameVerifySuccessUI))
      {
        a(paramActivity, WcPayRealnameVerifyIdInputUI.class, paramInt);
        AppMethodBeat.o(70001);
        return;
      }
      if ((paramActivity instanceof WcPayRealnameVerifyCodeUI)) {
        a(paramActivity, WcPayRealnameVerifyBindcardEntranceUI.class, paramInt);
      }
    }
    AppMethodBeat.o(70001);
  }
  
  public static abstract interface a
  {
    public abstract void run(Activity paramActivity);
  }
  
  final class b
    extends com.tencent.mm.wallet_core.d.g
  {
    int zXn = 0;
    
    public b(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(174440);
      if ((paramn instanceof j))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          AppMethodBeat.o(174440);
          return true;
        }
      }
      else if (((paramn instanceof k)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        a.this.a(this.activity, 0, new Bundle());
        AppMethodBeat.o(174440);
        return true;
      }
      AppMethodBeat.o(174440);
      return false;
    }
    
    public final boolean q(Object... paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a
 * JD-Core Version:    0.7.0.1
 */