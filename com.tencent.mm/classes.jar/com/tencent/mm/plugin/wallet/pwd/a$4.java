package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;

final class a$4
  extends com.tencent.mm.wallet_core.d.g
{
  a$4(a parama, MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.g)))
    {
      paramString = (com.tencent.mm.plugin.wallet.pwd.a.g)paramm;
      a.e(this.qoe).putString("kreq_token", paramString.token);
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[1];
    paramVarArgs.flag = "3";
    this.wBd.a(new com.tencent.mm.plugin.wallet.pwd.a.i(paramVarArgs), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.4
 * JD-Core Version:    0.7.0.1
 */