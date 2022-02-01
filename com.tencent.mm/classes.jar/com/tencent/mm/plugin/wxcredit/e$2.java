package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$2
  extends g
{
  e$2(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72269);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof a))
      {
        paramString = (a)paramn;
        e.h(this.EGo).putString("KEY_SESSION_KEY", paramString.token);
        e.i(this.EGo).putString("key_mobile", paramString.dzn);
        e.j(this.EGo).putBoolean("key_need_bind_deposit", paramString.dML);
        e.k(this.EGo).putBoolean("key_is_bank_user", paramString.EGr);
      }
      this.EGo.a(this.activity, 0, e.l(this.EGo));
      AppMethodBeat.o(72269);
      return true;
    }
    AppMethodBeat.o(72269);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    AppMethodBeat.i(72270);
    String str = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    e.m(this.EGo).putString("key_name", str);
    e.n(this.EGo).putString("key_indentity", paramVarArgs);
    this.LyU.a(new a(str, paramVarArgs, e.o(this.EGo).getString("KEY_SESSION_KEY"), e.p(this.EGo).getString("key_bank_type")), true, 1);
    AppMethodBeat.o(72270);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.2
 * JD-Core Version:    0.7.0.1
 */