package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$2
  extends g
{
  a$2(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 3)
    {
      paramVarArgs = new k(paramVarArgs[0].toString(), ((Integer)paramVarArgs[1]).intValue(), (String)paramVarArgs[2]);
      this.wBd.a(paramVarArgs, true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.2
 * JD-Core Version:    0.7.0.1
 */