package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$5
  extends g
{
  a$5(a parama, MMActivity paramMMActivity, i parami)
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
      if (paramInt2 == 0) {
        if (!(paramm instanceof f))
        {
          bool1 = bool2;
          if (!(paramm instanceof b)) {}
        }
        else
        {
          this.qoe.a(this.gfb, 0, a.f(this.qoe));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[0];
    if (this.qoe.kke.getBoolean("key_is_set_pwd_after_face_action"))
    {
      y.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
      String str = this.qoe.kke.getString("key_face_action_result_token");
      this.wBd.a(new b(str, paramVarArgs.feN), true, 1);
      return true;
    }
    y.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
    this.wBd.a(new f(paramVarArgs), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.5
 * JD-Core Version:    0.7.0.1
 */