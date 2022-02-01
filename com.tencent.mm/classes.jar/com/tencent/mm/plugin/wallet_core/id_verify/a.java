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
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.autogen.a.adl;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.autogen.a.uu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.id_verify.model.j;
import com.tencent.mm.plugin.wallet_core.id_verify.model.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.protocal.protobuf.emi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;

public class a
  extends com.tencent.mm.plugin.wallet_core.b.b
{
  private IListener<ng> Myr;
  private boolean VyG;
  private int VyH;
  public a VyI;
  private String mActivityName;
  private int mMode;
  private String mPluginName;
  private boolean nxG;
  private int resultCode;
  
  public a()
  {
    AppMethodBeat.i(69999);
    this.mPluginName = null;
    this.mActivityName = null;
    this.VyG = false;
    this.resultCode = 0;
    this.VyH = -1;
    this.nxG = false;
    this.Myr = new RealNameVerifyProcess.6(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(69999);
  }
  
  private boolean ihP()
  {
    AppMethodBeat.i(70002);
    boolean bool = "rename".equals(this.hPH.getString("key_realname_scene"));
    AppMethodBeat.o(70002);
    return bool;
  }
  
  private boolean j(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(70006);
    com.tencent.mm.wallet_core.b.jNX();
    if (com.tencent.mm.wallet_core.b.b(c.a.yWP, true))
    {
      this.Myr.alive();
      Log.d("MicroMsg.RealNameVerifyProcess", "startKindaBindCard:true");
      if (paramBundle != null)
      {
        ac.pu(6, paramBundle.getInt("key_bind_scene"));
        aa.aGq(paramBundle.getInt("key_bind_scene"));
      }
      for (;;)
      {
        paramBundle.putInt("key_bind_scene", 10);
        if (ihP()) {
          paramBundle.putInt("reg_flag", 0);
        }
        ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(paramContext, paramBundle);
        AppMethodBeat.o(70006);
        return true;
        ac.pu(6, 0);
        aa.aGq(0);
      }
    }
    Log.d("MicroMsg.RealNameVerifyProcess", "startKindaBindCard:false");
    AppMethodBeat.o(70006);
    return false;
  }
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_input_realname_finish_confirm;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(70005);
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      if ((this.mMode == 2) || (this.mMode == 4))
      {
        paramMMActivity = new g(paramMMActivity, parami)
        {
          public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(69986);
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.f))
            {
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                if (((com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramAnonymousp).Vxv == 0) {
                  a.k(a.this).putInt("realname_verify_process_ret", -1);
                }
                a.l(a.this).putString("realname_verify_process_finish_title", ((com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramAnonymousp).title);
                a.m(a.this).putString("realname_verify_process_finish_desc", ((com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramAnonymousp).desc);
                a.n(a.this).putString("realname_verify_process_finish_page", ((com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramAnonymousp).egj);
                a.o(a.this).putInt("realname_verify_process_finish_err_jump", ((com.tencent.mm.plugin.wallet_core.id_verify.model.f)paramAnonymousp).Vxv);
                Log.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                u.iiC().aNm();
                paramAnonymousString = new acz();
                paramAnonymousString.igq.scene = 16;
                paramAnonymousString.callback = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(69983);
                    Log.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                    AppMethodBeat.o(69983);
                  }
                };
                paramAnonymousString.publish();
                a.a(a.this, this.agTR);
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
            else if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.b.a.b))
            {
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).Vxv == 0) {
                  a.s(a.this).putInt("realname_verify_process_ret", -1);
                }
                a.t(a.this).putString("realname_verify_process_finish_title", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).title);
                a.u(a.this).putString("realname_verify_process_finish_desc", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).desc);
                a.v(a.this).putString("realname_verify_process_finish_page", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).egj);
                a.w(a.this).putInt("realname_verify_process_finish_err_jump", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).Vxv);
                Log.i("MicroMsg.RealNameVerifyProcess", "bind card verify succ ,update user info");
                if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).Vxu != null) {
                  a.x(a.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramAnonymousp).Vxu);
                }
                u.iiC().aNm();
                paramAnonymousString = new acz();
                paramAnonymousString.igq.scene = 16;
                paramAnonymousString.callback = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(69984);
                    Log.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                    AppMethodBeat.o(69984);
                  }
                };
                paramAnonymousString.publish();
                a.b(a.this, this.agTR);
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
            else if ((paramAnonymousp instanceof m))
            {
              AppMethodBeat.o(69986);
              return true;
            }
            AppMethodBeat.o(69986);
            return false;
          }
          
          public final boolean t(Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(69985);
            paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.w)paramAnonymousVarArgs[0];
            String str1 = a.f(a.this).getString("key_real_name_token");
            String str2 = a.g(a.this).getString("realname_verify_process_face_token");
            String str3 = a.h(a.this).getString("key_realname_sessionid");
            RealNameBundle localRealNameBundle = (RealNameBundle)a.i(a.this).getParcelable("realname_verify_process_bundle");
            if ((paramAnonymousVarArgs == null) || (Util.isNullOrNil(paramAnonymousVarArgs.pRM))) {
              Log.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
            }
            for (;;)
            {
              AppMethodBeat.o(69985);
              return true;
              if (a.j(a.this).containsKey("kreq_token"))
              {
                Log.i("MicroMsg.RealNameVerifyProcess", "bindcard verify");
                this.agTR.b(new com.tencent.mm.plugin.wallet_core.b.a.b(paramAnonymousVarArgs, a.this.hPH.getInt("entry_scene", -1), str3, localRealNameBundle), true);
              }
              else
              {
                paramAnonymousVarArgs = new com.tencent.mm.plugin.wallet_core.id_verify.model.f(paramAnonymousVarArgs.pRM, str1, str2, a.this.hPH.getInt("entry_scene", -1), str3, localRealNameBundle);
                this.agTR.b(paramAnonymousVarArgs, true);
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
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69987);
          Object localObject = null;
          if (paramAnonymousInt == 0)
          {
            String str = this.activity.getString(a.i.wallet_real_name_verify_cur_verify_id_tip);
            localObject = this.activity.getString(a.i.wallet_real_name_verify_change_to_bindcard);
            str = this.activity.getString(a.i.wallet_real_name_verify_tip, new Object[] { str, localObject });
            n localn = new n(this.activity);
            SpannableString localSpannableString = new SpannableString(str);
            localSpannableString.setSpan(localn, str.length() - ((String)localObject).length(), str.length(), 33);
            localObject = localSpannableString.subSequence(0, localSpannableString.length());
          }
          AppMethodBeat.o(69987);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          return false;
        }
      };
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    if (((paramMMActivity instanceof WalletCardElementUI)) || ((paramMMActivity instanceof WalletCardImportUI)))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        private Authen VmM;
        
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(69993);
          Log.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousInt1 == 1)
          {
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.getExtras() != null))
            {
              paramAnonymousIntent = paramAnonymousIntent.getExtras().getString("token");
              a.this.hPH.putString("realname_verify_process_face_token", paramAnonymousIntent);
              a.this.a(this.activity, 0, a.this.hPH);
              AppMethodBeat.o(69993);
            }
          }
          else {
            super.onActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          }
          AppMethodBeat.o(69993);
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(69990);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousp;
              if (paramAnonymousString.Vxt == null)
              {
                a.A(a.this).putString("kreq_token", paramAnonymousString.getToken());
                if (a.this.c(this.activity, a.B(a.this)))
                {
                  Log.i("MicroMsg.RealNameVerifyProcess", "need update bankcardlist");
                  this.agTR.b(new ae(null, 12), true);
                }
              }
              for (;;)
              {
                AppMethodBeat.o(69990);
                return true;
                Log.i("MicroMsg.RealNameVerifyProcess", "not need update bankcardlist");
                a.this.a(this.activity, 0, a.C(a.this));
                continue;
                Log.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                com.tencent.mm.ui.base.k.b(this.activity, paramAnonymousString.Vxt.wording, "", paramAnonymousString.Vxt.VJn, paramAnonymousString.Vxt.VJm, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69988);
                    Log.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard dialog lOk");
                    paramAnonymous2DialogInterface = a.D(a.this).getString("key_realname_sessionid");
                    a.4.b(a.4.this).a(new com.tencent.mm.plugin.wallet_core.b.a.a(a.4.a(a.4.this), "1", paramAnonymous2DialogInterface), true, 1);
                    v.BI(1);
                    AppMethodBeat.o(69988);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(69989);
                    Log.i("MicroMsg.RealNameVerifyProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                    v.BI(0);
                    AppMethodBeat.o(69989);
                  }
                });
              }
            }
            if ((paramAnonymousp instanceof ae))
            {
              Log.i("MicroMsg.RealNameVerifyProcess", "update bankcardlist success!");
              a.this.a(this.activity, 0, a.E(a.this));
              AppMethodBeat.o(69990);
              return true;
            }
          }
          AppMethodBeat.o(69990);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69992);
          a.this.P(new Object[] { "onNext", paramAnonymousVarArgs });
          this.VmM = ((Authen)paramAnonymousVarArgs[0]);
          this.VmM.eQp = a.F(a.this);
          paramAnonymousVarArgs = a.G(a.this).getString("key_realname_sessionid");
          this.agTR.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.VmM, "", paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(69992);
          return true;
        }
      };
      AppMethodBeat.o(70005);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69997);
          String str = this.activity.getString(a.i.wallet_verify_code_bind_card_hint);
          AppMethodBeat.o(69997);
          return str;
        }
        
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(69995);
          Log.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousInt1 == 1)
          {
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.getExtras() != null))
            {
              paramAnonymousIntent = paramAnonymousIntent.getExtras().getString("token");
              a.this.hPH.putString("realname_verify_process_face_token", paramAnonymousIntent);
              a.this.a(this.activity, 0, a.this.hPH);
              AppMethodBeat.o(69995);
            }
          }
          else {
            super.onActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          }
          AppMethodBeat.o(69995);
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(69994);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              Log.i("MicroMsg.RealNameVerifyProcess", "verify code success!");
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousp;
              a.H(a.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(69994);
              return true;
            }
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet_core.c.w))
            {
              a.c(a.this, this.agTR);
              if (((com.tencent.mm.plugin.wallet_core.c.w)paramAnonymousp).Vxu != null) {
                a.I(a.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.c.w)paramAnonymousp).Vxu);
              }
              a.J(a.this).putString("key_resetpwd", ((com.tencent.mm.plugin.wallet_core.c.w)paramAnonymousp).action);
              boolean bool = a.K(a.this).getBoolean("realname_verify_process_need_face", false);
              Log.i("MicroMsg.RealNameVerifyProcess", "forward: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                paramAnonymousString = new uu();
                paramAnonymousString.hYx.hHU = this.activity;
                paramAnonymousString.hYx.scene = ((int)a.L(a.this).getLong("realname_verify_process_face_scene"));
                paramAnonymousString.hYx.packageName = a.M(a.this).getString("realname_verify_process_face_package");
                paramAnonymousString.hYx.hYz = a.N(a.this).getString("realname_verify_process_face_package_sign");
                paramAnonymousString.hYx.hPm = 1;
                paramAnonymousString.publish();
              }
              for (;;)
              {
                AppMethodBeat.o(69994);
                return true;
                a.this.a(this.activity, 0, a.O(a.this));
              }
            }
            if ((paramAnonymousp instanceof m))
            {
              AppMethodBeat.o(69994);
              return true;
            }
          }
          AppMethodBeat.o(69994);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69996);
          a.this.P(new Object[] { "WalletVerifyCodeUI onNext", paramAnonymousVarArgs });
          Log.i("MicroMsg.RealNameVerifyProcess", "onNext, do bind verify!");
          paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.w)paramAnonymousVarArgs[1];
          if ((u.iiC().ijf()) && (!a.P(a.this))) {}
          for (paramAnonymousVarArgs.flag = "2";; paramAnonymousVarArgs.flag = "1")
          {
            String str = a.Q(a.this).getString("key_realname_sessionid");
            this.agTR.a(new com.tencent.mm.plugin.wallet_core.c.w(paramAnonymousVarArgs, a.this.hPH.getInt("entry_scene", -1), str), true, 1);
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
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(70000);
    P(new Object[] { "start", paramActivity, paramBundle });
    if (this.hPH == null) {
      this.hPH = new Bundle();
    }
    b(paramActivity, WcPayRealnameProxyUI.class, paramBundle);
    AppMethodBeat.o(70000);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(70003);
    P(new Object[] { "forward", paramActivity, "actionCode:".concat(String.valueOf(paramInt)), paramBundle });
    int i = this.hPH.getInt("real_name_verify_mode", this.mMode);
    if (this.mMode != i) {
      this.mMode = i;
    }
    Object localObject;
    boolean bool;
    if ((paramActivity instanceof WcPayRealnameProxyUI))
    {
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = this.hPH;
      }
      if (localObject != null)
      {
        this.mMode = ((Bundle)localObject).getInt("real_name_verify_mode", 0);
        this.VyH = this.mMode;
        ((Bundle)localObject).putBoolean("key_is_realname_verify_process", true);
        this.mPluginName = ((Bundle)localObject).getString("realname_verify_process_jump_plugin", "");
        this.mActivityName = ((Bundle)localObject).getString("realname_verify_process_jump_activity", "");
        if (((Bundle)localObject).getInt("realname_verify_process_allow_idverify", 0) != 1) {
          break label267;
        }
        bool = true;
        label173:
        this.VyG = bool;
        Log.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[] { Boolean.valueOf(this.VyG), this.mPluginName, this.mActivityName });
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
        if (!j(paramActivity, (Bundle)localObject))
        {
          aa.aGq(10);
          super.a(paramActivity, (Bundle)localObject);
          AppMethodBeat.o(70003);
          return;
          aa.aGq(10);
          b(paramActivity, SwitchRealnameVerifyModeUI.class, (Bundle)localObject);
          AppMethodBeat.o(70003);
          return;
          b(paramActivity, WalletRealNameVerifyUI.class, (Bundle)localObject);
          AppMethodBeat.o(70003);
          return;
          paramBundle = this.hPH.getString("key_realname_scene");
          Log.i("MicroMsg.RealNameVerifyProcess", "realname scene: %s", new Object[] { paramBundle });
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
        localObject = paramBundle;
        if (((c)h.ax(c.class)).a(c.a.yXx, false))
        {
          Log.i("MicroMsg.RealNameVerifyProcess", "Abtest need Sm2Encrypt 1");
          localObject = paramBundle;
          if (paramBundle == null) {
            localObject = new Bundle();
          }
          ((Bundle)localObject).putBoolean("isNeedSm2Encrypt", true);
          ((Bundle)localObject).putInt("Sm2EncryptType", 5);
        }
        b(paramActivity, WalletPwdConfirmUI.class, (Bundle)localObject);
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
          if (u.iiC().ijf())
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
            if (j(paramActivity, paramBundle))
            {
              AppMethodBeat.o(70003);
              return;
            }
            if ((u.iiC().ijf()) && (!ihP()))
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(70003);
              return;
            }
            b(paramActivity, WalletBankcardIdUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          bool = this.hPH.getBoolean("realname_verify_process_show_bindcard_page", false);
          Log.i("MicroMsg.RealNameVerifyProcess", "show bind page: %s", new Object[] { Boolean.valueOf(bool) });
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
            if (j(paramActivity, paramBundle))
            {
              AppMethodBeat.o(70003);
              return;
            }
            if ((u.iiC().ijf()) && (!ihP()))
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(70003);
              return;
            }
            b(paramActivity, WalletBankcardIdUI.class, paramBundle);
            AppMethodBeat.o(70003);
            return;
          }
          if (this.hPH.getBoolean("realname_verify_process_verify_sms_without_bindcard", false))
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
          localObject = paramBundle;
          if (((c)h.ax(c.class)).a(c.a.yXx, false))
          {
            Log.i("MicroMsg.RealNameVerifyProcess", "Abtest need Sm2Encrypt 2");
            localObject = paramBundle;
            if (paramBundle == null) {
              localObject = new Bundle();
            }
            ((Bundle)localObject).putBoolean("isNeedSm2Encrypt", true);
            ((Bundle)localObject).putInt("Sm2EncryptType", 5);
          }
          b(paramActivity, WalletPwdConfirmUI.class, (Bundle)localObject);
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
          localObject = this.hPH.getString("key_resetpwd");
          Log.i("MicroMsg.RealNameVerifyProcess", "resetpwd: %s", new Object[] { localObject });
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
    P(new Object[] { "end", paramActivity, paramBundle });
    aa.jOQ();
    if (paramBundle == null) {
      paramBundle = this.hPH;
    }
    for (;;)
    {
      final Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      final acz localacz;
      if (this.mMode == 1)
      {
        jOj();
        if (localBundle.getBoolean("intent_bind_end", false))
        {
          this.resultCode = -1;
          if (localBundle.containsKey("intent_bind_end")) {
            localBundle.remove("intent_bind_end");
          }
          if (localBundle.containsKey("key_is_bind_reg_process")) {
            localBundle.remove("key_is_bind_reg_process");
          }
          localBundle.putInt("realname_verify_process_ret", this.resultCode);
          paramBundle = new Intent();
          paramBundle.putExtras(localBundle);
          if (this.resultCode == -1) {
            Toast.makeText(paramActivity, paramActivity.getString(a.i.realname_verify_succ), 0).show();
          }
          localacz = new acz();
          if (this.resultCode != -1) {
            break label268;
          }
          localacz.igq.scene = 17;
        }
      }
      for (;;)
      {
        localacz.callback = new Runnable()
        {
          public final void run()
          {
            Object localObject1 = null;
            AppMethodBeat.i(69982);
            localacz.callback = null;
            a.a(a.this);
            boolean bool1;
            boolean bool2;
            Object localObject2;
            if ((!Util.isNullOrNil(a.b(a.this))) && (!Util.isNullOrNil(a.c(a.this))))
            {
              Log.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.b(a.this) + a.c(a.this));
              bool1 = a.this.hPH.getBoolean("process_finish_stay_orgpage", true);
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
                a.a(a.this, paramActivity, (Class)localObject1, a.d(a.this), paramBundle, bool1);
              }
            }
            a.b(a.this, paramActivity, a.b(a.this), a.c(a.this), a.d(a.this), paramBundle, bool1);
            if (a.d(a.this) == -1)
            {
              localObject1 = new adl();
              ((adl)localObject1).ihF.result = a.d(a.this);
              ((adl)localObject1).publish();
            }
            AppMethodBeat.o(69982);
            return;
            a.this.b(paramActivity, a.d(a.this), localBundle);
            if (a.d(a.this) == -1)
            {
              localObject1 = new adl();
              ((adl)localObject1).ihF.result = a.d(a.this);
              ((adl)localObject1).publish();
            }
            AppMethodBeat.o(69982);
          }
        };
        localacz.callback.run();
        AppMethodBeat.o(70004);
        return;
        this.resultCode = 0;
        break;
        if (localBundle.containsKey("realname_verify_process_ret"))
        {
          this.resultCode = localBundle.getInt("realname_verify_process_ret", -1);
          break;
        }
        this.resultCode = 0;
        break;
        label268:
        if (this.resultCode == 0) {
          localacz.igq.scene = 18;
        } else {
          localacz.igq.scene = 0;
        }
      }
    }
  }
  
  public final String fud()
  {
    return "realname_verify_process";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(70001);
    P(new Object[] { "back", paramActivity, Integer.valueOf(paramInt) });
    aa.jOQ();
    if (((paramActivity instanceof SwitchRealnameVerifyModeUI)) || ((paramActivity instanceof WcPayRealnameVerifyMainUI)))
    {
      if (paramInt == 0)
      {
        b(paramActivity, this.hPH);
        AppMethodBeat.o(70001);
      }
    }
    else if (((paramActivity instanceof WalletRealNameVerifyUI)) || ((paramActivity instanceof WalletBankcardIdUI)))
    {
      if (this.VyH != 0)
      {
        b(paramActivity, this.hPH);
        AppMethodBeat.o(70001);
      }
    }
    else
    {
      if ((paramActivity instanceof WalletCheckPwdUI))
      {
        b(paramActivity, this.hPH);
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
    extends g
  {
    int VyN = 0;
    
    public b(MMActivity paramMMActivity, i parami)
    {
      super(parami);
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(174440);
      if ((paramp instanceof j))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          AppMethodBeat.o(174440);
          return true;
        }
      }
      else if (((paramp instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.k)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        a.this.a(this.activity, 0, new Bundle());
        AppMethodBeat.o(174440);
        return true;
      }
      AppMethodBeat.o(174440);
      return false;
    }
    
    public final boolean t(Object... paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a
 * JD-Core Version:    0.7.0.1
 */