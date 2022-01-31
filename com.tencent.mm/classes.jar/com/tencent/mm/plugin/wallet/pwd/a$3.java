package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

final class a$3
  extends com.tencent.mm.wallet_core.d.g
{
  a$3(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        bool1 = bool2;
        if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.g))
        {
          paramString = (com.tencent.mm.plugin.wallet.pwd.a.g)paramm;
          a.a(this.qoe).putString("kreq_token", paramString.token);
          this.qoe.a(this.gfb, 0, a.b(this.qoe));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (Authen)paramVarArgs[0];
    if (!this.qoe.bXd())
    {
      paramVarArgs.bcw = 1;
      if (!a.c(this.qoe).getBoolean("key_is_paymanager")) {
        break label80;
      }
    }
    label80:
    for (int i = 1;; i = 0)
    {
      this.wBd.a(new com.tencent.mm.plugin.wallet.pwd.a.g(paramVarArgs, a.d(this.qoe).getBoolean("key_is_reset_with_new_card", false), i), true, 1);
      return true;
      paramVarArgs.bcw = 4;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.3
 * JD-Core Version:    0.7.0.1
 */