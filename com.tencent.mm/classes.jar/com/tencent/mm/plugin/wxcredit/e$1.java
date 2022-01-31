package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$1
  extends g
{
  e$1(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48625);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof b))
      {
        paramString = (b)paramm;
        e.a(this.vHu).putString("KEY_SESSION_KEY", paramString.token);
        e.b(this.vHu).putString("key_pre_name", paramString.name);
        e.c(this.vHu).putString("key_pre_indentity", paramString.vHx);
        e.d(this.vHu).putBoolean("key_has_indentity_info", paramString.vHy);
      }
      this.vHu.a(this.hwZ, 0, e.e(this.vHu));
      AppMethodBeat.o(48625);
      return true;
    }
    AppMethodBeat.o(48625);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(48626);
    e.f(this.vHu).putString("key_pwd1", (String)paramVarArgs[0]);
    i locali = this.AXB;
    String str = (String)paramVarArgs[0];
    if (paramVarArgs[1] == null) {}
    for (;;)
    {
      locali.a(new b(str, i, e.g(this.vHu).getString("key_bank_type")), true, 1);
      AppMethodBeat.o(48626);
      return true;
      i = bo.apV((String)paramVarArgs[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.1
 * JD-Core Version:    0.7.0.1
 */