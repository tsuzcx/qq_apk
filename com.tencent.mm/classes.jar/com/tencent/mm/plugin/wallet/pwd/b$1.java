package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$1
  extends g
{
  b$1(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    String str = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    this.wBd.a(new r(str, 3, paramVarArgs), true, 1);
    return true;
  }
  
  public final CharSequence vy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.vy(paramInt);
    case 0: 
      return this.gfb.getString(a.i.wallet_check_pwd_modify_pwd_tip);
    }
    return this.gfb.getString(a.i.wallet_password_setting_ui_modify);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b.1
 * JD-Core Version:    0.7.0.1
 */