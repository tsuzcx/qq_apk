package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class d$2
  extends g
{
  d$2(d paramd, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof f)) {
        this.wBd.a(new y(), true);
      }
      while (!(paramm instanceof y)) {
        return true;
      }
      this.rQC.b(this.gfb, d.a(this.rQC));
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    Bankcard localBankcard = (Bankcard)d.b(this.rQC).getParcelable("key_bankcard");
    this.wBd.a(new f(localBankcard.field_bankcardType, localBankcard.field_bindSerial, (String)paramVarArgs[0]), true, 1);
    return true;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    paramVarArgs = (Bankcard)paramVarArgs[0];
    this.wBd.a(new com.tencent.mm.plugin.wxcredit.a.d(paramVarArgs.field_bindSerial, paramVarArgs.field_bankcardType), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.d.2
 * JD-Core Version:    0.7.0.1
 */