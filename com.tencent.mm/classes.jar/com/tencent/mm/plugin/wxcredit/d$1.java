package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class d$1
  extends g
{
  d$1(d paramd, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    paramVarArgs = (Bankcard)paramVarArgs[0];
    this.wBd.a(new com.tencent.mm.plugin.wxcredit.a.d(paramVarArgs.field_bindSerial, paramVarArgs.field_bankcardType), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.d.1
 * JD-Core Version:    0.7.0.1
 */