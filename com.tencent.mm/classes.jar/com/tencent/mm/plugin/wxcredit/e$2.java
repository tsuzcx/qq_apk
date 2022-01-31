package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$2
  extends g
{
  e$2(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48627);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof a))
      {
        paramString = (a)paramm;
        e.h(this.vHu).putString("KEY_SESSION_KEY", paramString.token);
        e.i(this.vHu).putString("key_mobile", paramString.czF);
        e.j(this.vHu).putBoolean("key_need_bind_deposit", paramString.cLO);
        e.k(this.vHu).putBoolean("key_is_bank_user", paramString.vHw);
      }
      this.vHu.a(this.hwZ, 0, e.l(this.vHu));
      AppMethodBeat.o(48627);
      return true;
    }
    AppMethodBeat.o(48627);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48628);
    String str = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    e.m(this.vHu).putString("key_name", str);
    e.n(this.vHu).putString("key_indentity", paramVarArgs);
    this.AXB.a(new a(str, paramVarArgs, e.o(this.vHu).getString("KEY_SESSION_KEY"), e.p(this.vHu).getString("key_bank_type")), true, 1);
    AppMethodBeat.o(48628);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.2
 * JD-Core Version:    0.7.0.1
 */