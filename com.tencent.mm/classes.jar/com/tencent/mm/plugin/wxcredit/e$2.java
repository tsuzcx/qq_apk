package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
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
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        if ((paramm instanceof a))
        {
          paramString = (a)paramm;
          e.h(this.rQD).putString("KEY_SESSION_KEY", paramString.token);
          e.i(this.rQD).putString("key_mobile", paramString.bSe);
          e.j(this.rQD).putBoolean("key_need_bind_deposit", paramString.cde);
          e.k(this.rQD).putBoolean("key_is_bank_user", paramString.rQF);
        }
        this.rQD.a(this.gfb, 0, e.l(this.rQD));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    String str = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    e.m(this.rQD).putString("key_name", str);
    e.n(this.rQD).putString("key_indentity", paramVarArgs);
    this.wBd.a(new a(str, paramVarArgs, e.o(this.rQD).getString("KEY_SESSION_KEY"), e.p(this.rQD).getString("key_bank_type")), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.2
 * JD-Core Version:    0.7.0.1
 */