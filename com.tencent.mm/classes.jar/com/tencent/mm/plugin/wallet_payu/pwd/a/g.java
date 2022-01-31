package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

public class g
  extends e
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI)) {
      return new g.1(this, paramMMActivity, parami, this.kke);
    }
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI)) {
      new com.tencent.mm.wallet_core.d.g(paramMMActivity, parami)
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          boolean bool2 = false;
          boolean bool1 = bool2;
          if ((paramAnonymousm instanceof b))
          {
            y.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
            bool1 = bool2;
            if (paramAnonymousInt1 == 0)
            {
              bool1 = bool2;
              if (paramAnonymousInt2 == 0)
              {
                g.a(g.this).putInt("key_errcode_payu", 0);
                a.b(this.gfb, g.this.kke, 0);
                bool1 = true;
              }
            }
          }
          return bool1;
        }
        
        public final boolean m(Object... paramAnonymousVarArgs)
        {
          Object localObject = (p)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = g.b(g.this).getString("key_pwd1");
          localObject = ((p)localObject).feN;
          this.wBd.a(new b(paramAnonymousVarArgs, (String)localObject), true);
          return true;
        }
      };
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletPayUCheckPwdUI))
    {
      b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      return;
    }
    super.a(paramActivity, paramInt, paramBundle);
  }
  
  public final String aTh()
  {
    return "PayUModifyPasswordProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */