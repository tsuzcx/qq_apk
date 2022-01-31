package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.c))
      {
        this.qof.a(this.gfb, 0, b.a(this.qof));
        h.bC(this.gfb, this.gfb.getString(a.i.wallet_password_setting_success_tip));
      }
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.c))
    {
      h.a(this.gfb, paramString, "", false, new b.2.1(this));
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[0];
    String str = b.b(this.qof).getString("key_pwd1");
    this.wBd.a(new com.tencent.mm.plugin.wallet.pwd.a.c(str, paramVarArgs.feN), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b.2
 * JD-Core Version:    0.7.0.1
 */