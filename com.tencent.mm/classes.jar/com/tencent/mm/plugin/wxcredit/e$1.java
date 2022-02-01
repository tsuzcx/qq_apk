package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$1
  extends g
{
  e$1(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72267);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof b))
      {
        paramString = (b)paramn;
        e.a(this.Dco).putString("KEY_SESSION_KEY", paramString.token);
        e.b(this.Dco).putString("key_pre_name", paramString.name);
        e.c(this.Dco).putString("key_pre_indentity", paramString.gIe);
        e.d(this.Dco).putBoolean("key_has_indentity_info", paramString.Dcs);
      }
      this.Dco.a(this.activity, 0, e.e(this.Dco));
      AppMethodBeat.o(72267);
      return true;
    }
    AppMethodBeat.o(72267);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(72268);
    e.f(this.Dco).putString("key_pwd1", (String)paramVarArgs[0]);
    i locali = this.JFQ;
    String str = (String)paramVarArgs[0];
    if (paramVarArgs[1] == null) {}
    for (;;)
    {
      locali.a(new b(str, i, e.g(this.Dco).getString("key_bank_type")), true, 1);
      AppMethodBeat.o(72268);
      return true;
      i = bs.aLy((String)paramVarArgs[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.1
 * JD-Core Version:    0.7.0.1
 */