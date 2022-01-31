package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.e;
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
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof e)) {
        break label38;
      }
      b.a(this.rQA).putString("kreq_token", ((e)paramm).token);
    }
    label38:
    while (!(paramm instanceof com.tencent.mm.plugin.wxcredit.a.c)) {
      return false;
    }
    b.b(this.rQA).putDouble("key_credit_amount", ((com.tencent.mm.plugin.wxcredit.a.c)paramm).rQI);
    this.rQA.a(this.gfb, 0, b.c(this.rQA));
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (Bankcard)b.d(this.rQA).getParcelable("key_bankcard");
    this.wBd.a(new e(paramVarArgs.field_bindSerial), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b.1
 * JD-Core Version:    0.7.0.1
 */