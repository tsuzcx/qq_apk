package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.Util;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72267);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof b))
      {
        paramString = (b)paramq;
        e.a(this.QNT).putString("KEY_SESSION_KEY", paramString.token);
        e.b(this.QNT).putString("key_pre_name", paramString.name);
        e.c(this.QNT).putString("key_pre_indentity", paramString.kLV);
        e.d(this.QNT).putBoolean("key_has_indentity_info", paramString.QNX);
      }
      this.QNT.a(this.activity, 0, e.e(this.QNT));
      AppMethodBeat.o(72267);
      return true;
    }
    AppMethodBeat.o(72267);
    return false;
  }
  
  public final boolean r(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(72268);
    e.f(this.QNT).putString("key_pwd1", (String)paramVarArgs[0]);
    i locali = this.YVX;
    String str = (String)paramVarArgs[0];
    if (paramVarArgs[1] == null) {}
    for (;;)
    {
      locali.a(new b(str, i, e.g(this.QNT).getString("key_bank_type")), true, 1);
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