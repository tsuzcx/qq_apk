package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.af;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class n
  extends c
{
  private String gGl;
  private int scene;
  private String token;
  private String ubR;
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(47406);
    ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
    this.ubR = paramBundle.getString("key_relation_key");
    this.gGl = paramBundle.getString("key_pwd1");
    this.token = paramBundle.getString("key_jsapi_token");
    this.scene = paramBundle.getInt("key_verify_scene");
    b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
    AppMethodBeat.o(47406);
    return this;
  }
  
  public final g a(final MMActivity paramMMActivity, final i parami)
  {
    AppMethodBeat.i(47408);
    paramMMActivity = new g(paramMMActivity, parami)
    {
      public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(47405);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if ((paramAnonymousm instanceof af))
          {
            ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
            paramAnonymousString = (af)paramAnonymousm;
            paramAnonymousm = n.this.mEJ;
            paramAnonymousm.putString("key_jsapi_token", paramAnonymousString.ubZ);
            n.this.b(paramMMActivity, paramAnonymousm);
            AppMethodBeat.o(47405);
            return true;
          }
          if ((paramAnonymousm instanceof v))
          {
            AppMethodBeat.o(47405);
            return true;
          }
          AppMethodBeat.o(47405);
          return false;
        }
        if ((paramAnonymousm instanceof af)) {
          ab.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + paramAnonymousInt1 + ",errCode=" + paramAnonymousInt2 + ",errMsg=" + paramAnonymousString);
        }
        AppMethodBeat.o(47405);
        return false;
      }
      
      public final boolean p(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(47403);
        if (paramAnonymousVarArgs.length == 2)
        {
          paramAnonymousVarArgs = (u)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.token = n.a(n.this);
          ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
          paramAnonymousVarArgs = new af(paramAnonymousVarArgs, n.b(n.this));
          parami.a(paramAnonymousVarArgs, true, 1);
          AppMethodBeat.o(47403);
          return true;
        }
        ab.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
        AppMethodBeat.o(47403);
        return false;
      }
      
      public final boolean y(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(47404);
        ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
        paramAnonymousVarArgs = new v(n.c(n.this), n.a(n.this), '\000');
        parami.a(paramAnonymousVarArgs, true, 1);
        AppMethodBeat.o(47404);
        return true;
      }
    };
    AppMethodBeat.o(47408);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle) {}
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(47407);
    ab.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
    if (this.scene == 8)
    {
      a(paramActivity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
      AppMethodBeat.o(47407);
      return;
    }
    a(paramActivity, WalletCheckPwdUI.class, -1, null, false);
    AppMethodBeat.o(47407);
  }
  
  public final String bzC()
  {
    return null;
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n
 * JD-Core Version:    0.7.0.1
 */