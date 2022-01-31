package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class l
  extends c
{
  private String foR;
  private String qqV;
  private int scene;
  private String token;
  
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
    this.qqV = paramBundle.getString("key_relation_key");
    this.foR = paramBundle.getString("key_pwd1");
    this.token = paramBundle.getString("key_jsapi_token");
    this.scene = paramBundle.getInt("key_verify_scene");
    b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
    return this;
  }
  
  public final g a(final MMActivity paramMMActivity, final i parami)
  {
    new g(paramMMActivity, parami)
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if ((paramAnonymousm instanceof ac))
          {
            y.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
            paramAnonymousString = (ac)paramAnonymousm;
            paramAnonymousm = l.this.kke;
            paramAnonymousm.putString("key_jsapi_token", paramAnonymousString.qrc);
            l.this.b(paramMMActivity, paramAnonymousm);
          }
          while ((paramAnonymousm instanceof s)) {
            return true;
          }
          return false;
        }
        if ((paramAnonymousm instanceof ac)) {
          y.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + paramAnonymousInt1 + ",errCode=" + paramAnonymousInt2 + ",errMsg=" + paramAnonymousString);
        }
        return false;
      }
      
      public final boolean m(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length == 2)
        {
          paramAnonymousVarArgs = (p)paramAnonymousVarArgs[1];
          paramAnonymousVarArgs.token = l.a(l.this);
          y.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
          paramAnonymousVarArgs = new ac(paramAnonymousVarArgs, l.b(l.this));
          parami.a(paramAnonymousVarArgs, true, 1);
          return true;
        }
        y.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
        return false;
      }
      
      public final boolean t(Object... paramAnonymousVarArgs)
      {
        y.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
        paramAnonymousVarArgs = new s(l.c(l.this), l.a(l.this), '\000');
        parami.a(paramAnonymousVarArgs, true, 1);
        return true;
      }
    };
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle) {}
  
  public final String aTh()
  {
    return null;
  }
  
  public final void b(Activity paramActivity, int paramInt) {}
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    y.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
    if (this.scene == 8)
    {
      a(paramActivity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
      return;
    }
    a(paramActivity, WalletCheckPwdUI.class, -1, null, false);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l
 * JD-Core Version:    0.7.0.1
 */