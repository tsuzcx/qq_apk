package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48602);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.vHr.a(this.hwZ, 0, b.e(this.vHr));
      this.hwZ.finish();
      AppMethodBeat.o(48602);
      return true;
    }
    AppMethodBeat.o(48602);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48603);
    b.f(this.vHr).putString("key_pwd1", (String)paramVarArgs[0]);
    this.AXB.a(new u((String)paramVarArgs[0], 5, ""), true, 1);
    AppMethodBeat.o(48603);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b.2
 * JD-Core Version:    0.7.0.1
 */