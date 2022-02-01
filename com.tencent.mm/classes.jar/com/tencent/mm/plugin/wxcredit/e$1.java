package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;

final class e$1
  extends g
{
  e$1(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72267);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof b))
      {
        paramString = (b)paramp;
        e.a(this.XHr).putString("KEY_SESSION_KEY", paramString.token);
        e.b(this.XHr).putString("key_pre_name", paramString.name);
        e.c(this.XHr).putString("key_pre_indentity", paramString.nnR);
        e.d(this.XHr).putBoolean("key_has_indentity_info", paramString.XHv);
      }
      this.XHr.a(this.activity, 0, e.e(this.XHr));
      AppMethodBeat.o(72267);
      return true;
    }
    AppMethodBeat.o(72267);
    return false;
  }
  
  public final boolean t(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(72268);
    e.f(this.XHr).putString("key_pwd1", (String)paramVarArgs[0]);
    i locali = this.agTR;
    String str = (String)paramVarArgs[0];
    if (paramVarArgs[1] == null) {}
    for (;;)
    {
      locali.a(new b(str, i, e.g(this.XHr).getString("key_bank_type")), true, 1);
      AppMethodBeat.o(72268);
      return true;
      i = Util.safeParseInt((String)paramVarArgs[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.1
 * JD-Core Version:    0.7.0.1
 */