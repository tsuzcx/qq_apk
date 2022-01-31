package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.ab;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48617);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof f)) {
        this.AXB.a(new ab(), true);
      }
      for (;;)
      {
        AppMethodBeat.o(48617);
        return true;
        if ((paramm instanceof ab)) {
          this.vHt.b(this.hwZ, d.a(this.vHt));
        }
      }
    }
    AppMethodBeat.o(48617);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48618);
    Bankcard localBankcard = (Bankcard)d.b(this.vHt).getParcelable("key_bankcard");
    this.AXB.a(new f(localBankcard.field_bankcardType, localBankcard.field_bindSerial, (String)paramVarArgs[0]), true, 1);
    AppMethodBeat.o(48618);
    return true;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(48619);
    paramVarArgs = (Bankcard)paramVarArgs[0];
    this.AXB.a(new com.tencent.mm.plugin.wxcredit.a.d(paramVarArgs.field_bindSerial, paramVarArgs.field_bankcardType), true, 1);
    AppMethodBeat.o(48619);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.d.2
 * JD-Core Version:    0.7.0.1
 */