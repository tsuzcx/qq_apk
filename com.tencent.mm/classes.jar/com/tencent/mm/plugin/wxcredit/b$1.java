package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48600);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof e))
      {
        b.a(this.vHr).putString("kreq_token", ((e)paramm).token);
        AppMethodBeat.o(48600);
        return false;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wxcredit.a.c))
      {
        b.b(this.vHr).putDouble("key_credit_amount", ((com.tencent.mm.plugin.wxcredit.a.c)paramm).vHz);
        this.vHr.a(this.hwZ, 0, b.c(this.vHr));
        AppMethodBeat.o(48600);
        return true;
      }
    }
    AppMethodBeat.o(48600);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48601);
    paramVarArgs = (Bankcard)b.d(this.vHr).getParcelable("key_bankcard");
    this.AXB.a(new e(paramVarArgs.field_bindSerial), true, 1);
    AppMethodBeat.o(48601);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b.1
 * JD-Core Version:    0.7.0.1
 */