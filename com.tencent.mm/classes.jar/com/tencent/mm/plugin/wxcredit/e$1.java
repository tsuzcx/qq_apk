package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.bk;
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
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        if ((paramm instanceof b))
        {
          paramString = (b)paramm;
          e.a(this.rQD).putString("KEY_SESSION_KEY", paramString.token);
          e.b(this.rQD).putString("key_pre_name", paramString.name);
          e.c(this.rQD).putString("key_pre_indentity", paramString.rQG);
          e.d(this.rQD).putBoolean("key_has_indentity_info", paramString.rQH);
        }
        this.rQD.a(this.gfb, 0, e.e(this.rQD));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    int i = 0;
    e.f(this.rQD).putString("key_pwd1", (String)paramVarArgs[0]);
    i locali = this.wBd;
    String str = (String)paramVarArgs[0];
    if (paramVarArgs[1] == null) {}
    for (;;)
    {
      locali.a(new b(str, i, e.g(this.rQD).getString("key_bank_type")), true, 1);
      return true;
      i = bk.ZR((String)paramVarArgs[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.1
 * JD-Core Version:    0.7.0.1
 */