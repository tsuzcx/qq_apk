package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.ai;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class q
  extends d
{
  private String OIm;
  private String nfX;
  private int scene;
  private String token;
  
  public final g a(final MMActivity paramMMActivity, final i parami)
  {
    AppMethodBeat.i(70972);
    paramMMActivity = new g(paramMMActivity, parami)
    {
      public final boolean B(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(70968);
        Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
        paramAnonymousVarArgs = new y(q.c(q.this), q.a(q.this), '\000');
        parami.a(paramAnonymousVarArgs, true, 1);
        AppMethodBeat.o(70968);
        return true;
      }
      
      public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(70969);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if ((paramAnonymousq instanceof ai))
          {
            Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
            paramAnonymousString = (ai)paramAnonymousq;
            paramAnonymousq = q.this.fKb;
            paramAnonymousq.putString("key_jsapi_token", paramAnonymousString.OIv);
            q.this.b(paramMMActivity, paramAnonymousq);
            AppMethodBeat.o(70969);
            return true;
          }
          if ((paramAnonymousq instanceof y))
          {
            AppMethodBeat.o(70969);
            return true;
          }
          AppMethodBeat.o(70969);
          return false;
        }
        if ((paramAnonymousq instanceof ai)) {
          Log.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + paramAnonymousInt1 + ",errCode=" + paramAnonymousInt2 + ",errMsg=" + paramAnonymousString);
        }
        AppMethodBeat.o(70969);
        return false;
      }
      
      public final boolean r(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(70967);
        if (paramAnonymousVarArgs.length == 2)
        {
          paramAnonymousVarArgs = (w)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.token = q.a(q.this);
          Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
          paramAnonymousVarArgs = new ai(paramAnonymousVarArgs, q.b(q.this));
          parami.a(paramAnonymousVarArgs, true, 1);
          AppMethodBeat.o(70967);
          return true;
        }
        Log.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
        AppMethodBeat.o(70967);
        return false;
      }
    };
    AppMethodBeat.o(70972);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(70970);
    Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
    this.OIm = paramBundle.getString("key_relation_key");
    this.nfX = paramBundle.getString("key_pwd1");
    this.token = paramBundle.getString("key_jsapi_token");
    this.scene = paramBundle.getInt("key_verify_scene");
    b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
    AppMethodBeat.o(70970);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle) {}
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(70971);
    Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
    if (this.scene == 8)
    {
      a(paramActivity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
      AppMethodBeat.o(70971);
      return;
    }
    a(paramActivity, WalletCheckPwdUI.class, -1, null, false);
    AppMethodBeat.o(70971);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String epb()
  {
    return null;
  }
  
  public final void h(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q
 * JD-Core Version:    0.7.0.1
 */