package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends b
{
  private int bpE = 0;
  private boolean eRq = false;
  private String mActivityName = null;
  private int mMode;
  private String ucr = null;
  private boolean ucs = false;
  private int uct = -1;
  public a ucu;
  
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131305143;
  }
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46580);
    G(new Object[] { "start", paramActivity, paramBundle });
    if (this.mEJ == null) {
      this.mEJ = new Bundle();
    }
    b(paramActivity, WcPayRealnameProxyUI.class, paramBundle);
    AppMethodBeat.o(46580);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(46584);
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      if ((this.mMode == 2) || (this.mMode == 4))
      {
        paramMMActivity = new a.2(this, paramMMActivity, parami);
        AppMethodBeat.o(46584);
        return paramMMActivity;
      }
      paramMMActivity = super.a(paramMMActivity, parami);
      AppMethodBeat.o(46584);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletRealNameVerifyUI))
    {
      paramMMActivity = new a.3(this, paramMMActivity, parami);
      AppMethodBeat.o(46584);
      return paramMMActivity;
    }
    if (((paramMMActivity instanceof WalletCardElementUI)) || ((paramMMActivity instanceof WalletCardImportUI)))
    {
      paramMMActivity = new a.4(this, paramMMActivity, parami);
      AppMethodBeat.o(46584);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(142404);
          String str = this.hwZ.getString(2131305684);
          AppMethodBeat.o(142404);
          return str;
        }
        
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(142402);
          ab.i("MicroMsg.RealNameVerifyProcess", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousInt1 == 1)
          {
            if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null) && (paramAnonymousIntent.getExtras() != null))
            {
              paramAnonymousIntent = paramAnonymousIntent.getExtras().getString("token");
              a.this.mEJ.putString("realname_verify_process_face_token", paramAnonymousIntent);
              a.this.a(this.hwZ, 0, a.this.mEJ);
              AppMethodBeat.o(142402);
            }
          }
          else {
            super.onActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          }
          AppMethodBeat.o(142402);
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(142401);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousm instanceof com.tencent.mm.plugin.wallet_core.b.a.a))
            {
              ab.i("MicroMsg.RealNameVerifyProcess", "verify code success!");
              paramAnonymousString = (com.tencent.mm.plugin.wallet_core.b.a.a)paramAnonymousm;
              a.y(a.this).putString("kreq_token", paramAnonymousString.getToken());
              AppMethodBeat.o(142401);
              return true;
            }
            if ((paramAnonymousm instanceof com.tencent.mm.plugin.wallet_core.c.t))
            {
              a.c(a.this, this.AXB);
              if (((com.tencent.mm.plugin.wallet_core.c.t)paramAnonymousm).ubq != null) {
                a.z(a.this).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.c.t)paramAnonymousm).ubq);
              }
              boolean bool = a.A(a.this).getBoolean("realname_verify_process_need_face", false);
              ab.i("MicroMsg.RealNameVerifyProcess", "forward: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                paramAnonymousString = new ov();
                paramAnonymousString.cFu.cup = this.hwZ;
                paramAnonymousString.cFu.scene = ((int)a.B(a.this).getLong("realname_verify_process_face_scene"));
                paramAnonymousString.cFu.packageName = a.C(a.this).getString("realname_verify_process_face_package");
                paramAnonymousString.cFu.cFw = a.D(a.this).getString("realname_verify_process_face_package_sign");
                paramAnonymousString.cFu.requestCode = 1;
                com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousString);
              }
              for (;;)
              {
                AppMethodBeat.o(142401);
                return true;
                a.this.a(this.hwZ, 0, a.E(a.this));
              }
            }
            if ((paramAnonymousm instanceof h))
            {
              AppMethodBeat.o(142401);
              return true;
            }
          }
          AppMethodBeat.o(142401);
          return false;
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(142403);
          a.this.G(new Object[] { "WalletVerifyCodeUI onNext", paramAnonymousVarArgs });
          ab.i("MicroMsg.RealNameVerifyProcess", "onNext, do bind verify!");
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl()) {}
          for (paramAnonymousVarArgs.flag = "2";; paramAnonymousVarArgs.flag = "1")
          {
            this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.t(paramAnonymousVarArgs, a.this.mEJ.getInt("entry_scene", -1)), true, 1);
            AppMethodBeat.o(142403);
            return true;
          }
        }
      };
      AppMethodBeat.o(46584);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(46584);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(46582);
    G(new Object[] { "forward", paramActivity, "actionCode:".concat(String.valueOf(paramInt)), paramBundle });
    int i = this.mEJ.getInt("real_name_verify_mode", this.mMode);
    if (this.mMode != i) {
      this.mMode = i;
    }
    if ((paramActivity instanceof WcPayRealnameProxyUI))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = this.mEJ;
      }
      boolean bool;
      if (localBundle != null)
      {
        this.mMode = localBundle.getInt("real_name_verify_mode", 0);
        this.uct = this.mMode;
        localBundle.putBoolean("key_is_realname_verify_process", true);
        this.ucr = localBundle.getString("realname_verify_process_jump_plugin", "");
        this.mActivityName = localBundle.getString("realname_verify_process_jump_activity", "");
        if (localBundle.getInt("realname_verify_process_allow_idverify", 0) != 1) {
          break label254;
        }
        bool = true;
        label162:
        this.ucs = bool;
        ab.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[] { Boolean.valueOf(this.ucs), this.ucr, this.mActivityName });
        switch (this.mMode)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(46582);
        return;
        this.mMode = 0;
        break;
        label254:
        bool = false;
        break label162;
        localBundle.putBoolean("key_need_bind_response", true);
        x.RT(10);
        super.a(paramActivity, localBundle);
        AppMethodBeat.o(46582);
        return;
        x.RT(10);
        b(paramActivity, SwitchRealnameVerifyModeUI.class, localBundle);
        AppMethodBeat.o(46582);
        return;
        b(paramActivity, WalletRealNameVerifyUI.class, localBundle);
        AppMethodBeat.o(46582);
        return;
        b(paramActivity, WcPayRealnameVerifyMainUI.class, localBundle);
      }
    }
    if (this.mMode == 2)
    {
      if ((paramActivity instanceof WalletRealNameVerifyUI))
      {
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        AppMethodBeat.o(46582);
        return;
      }
      if ((paramActivity instanceof WalletSetPasswordUI))
      {
        b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
        AppMethodBeat.o(46582);
        return;
      }
      if ((!(paramActivity instanceof WalletPwdConfirmUI)) && ((paramActivity instanceof SwitchRealnameVerifyModeUI)))
      {
        b(paramActivity, WalletRealNameVerifyUI.class, paramBundle);
        this.mMode = 2;
        AppMethodBeat.o(46582);
      }
    }
    else
    {
      if (this.mMode == 1)
      {
        if ((paramActivity instanceof SwitchRealnameVerifyModeUI))
        {
          if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl())
          {
            b(paramActivity, WalletCheckPwdUI.class, paramBundle);
            AppMethodBeat.o(46582);
            return;
          }
          b(paramActivity, WalletBankcardIdUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        if ((paramActivity instanceof WalletCheckPwdUI))
        {
          b(paramActivity, WalletBankcardIdUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        super.a(paramActivity, paramInt, paramBundle);
        AppMethodBeat.o(46582);
        return;
      }
      if (this.mMode == 4)
      {
        if ((paramActivity instanceof WcPayRealnameVerifyMainUI))
        {
          b(paramActivity, WcPayRealnameVerifyIdInputUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        if ((paramActivity instanceof WcPayRealnameVerifyIdInputUI))
        {
          if (paramBundle.getBoolean("realname_verify_process_need_bind_card", false))
          {
            if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl())
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(46582);
              return;
            }
            b(paramActivity, WalletBankcardIdUI.class, paramBundle);
            AppMethodBeat.o(46582);
            return;
          }
          b(paramActivity, WcPayRealnameVerifyBindcardEntranceUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        if ((paramActivity instanceof WcPayRealnameVerifyBindcardEntranceUI))
        {
          if (paramBundle.getBoolean("realname_verify_process_do_bind", false))
          {
            if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl())
            {
              b(paramActivity, WalletCheckPwdUI.class, paramBundle);
              AppMethodBeat.o(46582);
              return;
            }
            b(paramActivity, WalletBankcardIdUI.class, paramBundle);
            AppMethodBeat.o(46582);
            return;
          }
          b(paramActivity, WalletSetPasswordUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        if ((paramActivity instanceof WalletSetPasswordUI))
        {
          b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        if ((paramActivity instanceof WalletPwdConfirmUI))
        {
          b(paramActivity, WcPayRealnameVerifySuccessUI.class, paramBundle);
          AppMethodBeat.o(46582);
          return;
        }
        super.a(paramActivity, paramInt, paramBundle);
        AppMethodBeat.o(46582);
        return;
      }
      if ((paramActivity instanceof WalletRealNameVerifyUI))
      {
        b(paramActivity, WalletBankcardIdUI.class, paramBundle);
        this.mMode = 1;
        AppMethodBeat.o(46582);
        return;
      }
      super.a(paramActivity, paramInt, paramBundle);
    }
    AppMethodBeat.o(46582);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46583);
    G(new Object[] { "end", paramActivity, paramBundle });
    x.dSs();
    if (paramBundle == null) {
      paramBundle = this.mEJ;
    }
    for (;;)
    {
      Object localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      if (this.mMode == 1)
      {
        dRS();
        if (((Bundle)localObject).getBoolean("intent_bind_end", false))
        {
          this.bpE = -1;
          if (((Bundle)localObject).containsKey("intent_bind_end")) {
            ((Bundle)localObject).remove("intent_bind_end");
          }
          if (((Bundle)localObject).containsKey("key_is_bind_reg_process")) {
            ((Bundle)localObject).remove("key_is_bind_reg_process");
          }
          ((Bundle)localObject).putInt("realname_verify_process_ret", this.bpE);
          paramBundle = new Intent();
          paramBundle.putExtras((Bundle)localObject);
          if (this.bpE == -1) {
            Toast.makeText(paramActivity, paramActivity.getString(2131302325), 0).show();
          }
          localObject = new vf();
          if (this.bpE != -1) {
            break label262;
          }
          ((vf)localObject).cLJ.scene = 17;
        }
      }
      for (;;)
      {
        ((vf)localObject).callback = new a.1(this, (vf)localObject, paramBundle, paramActivity);
        ((vf)localObject).callback.run();
        AppMethodBeat.o(46583);
        return;
        this.bpE = 0;
        break;
        if (((Bundle)localObject).containsKey("realname_verify_process_ret"))
        {
          this.bpE = ((Bundle)localObject).getInt("realname_verify_process_ret", -1);
          break;
        }
        this.bpE = 0;
        break;
        label262:
        if (this.bpE == 0) {
          ((vf)localObject).cLJ.scene = 18;
        } else {
          ((vf)localObject).cLJ.scene = 0;
        }
      }
    }
  }
  
  public final String bzC()
  {
    return "realname_verify_process";
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(46581);
    G(new Object[] { "back", paramActivity, Integer.valueOf(paramInt) });
    x.dSs();
    if (((paramActivity instanceof SwitchRealnameVerifyModeUI)) || ((paramActivity instanceof WcPayRealnameVerifyMainUI))) {
      if (paramInt == 0) {
        b(paramActivity, this.mEJ);
      }
    }
    for (;;)
    {
      if ((paramActivity instanceof WalletPwdConfirmUI)) {
        a(paramActivity, WalletSetPasswordUI.class, paramInt);
      }
      AppMethodBeat.o(46581);
      return;
      if (((paramActivity instanceof WalletRealNameVerifyUI)) || ((paramActivity instanceof WalletBankcardIdUI)))
      {
        if (this.uct != 0) {
          b(paramActivity, this.mEJ);
        }
      }
      else if ((paramActivity instanceof WalletCheckPwdUI)) {
        b(paramActivity, this.mEJ);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void run(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a
 * JD-Core Version:    0.7.0.1
 */