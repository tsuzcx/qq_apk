package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class f$1
  extends g
{
  f$1(f paramf, MMActivity paramMMActivity, i parami)
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
        bool1 = bool2;
        if ((paramm instanceof com.tencent.mm.plugin.wxcredit.a.f))
        {
          this.rQE.a(this.gfb, 0, f.a(this.rQE));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    if (!f.b(this.rQE).getBoolean("key_is_show_detail", true))
    {
      paramVarArgs = (Bankcard)f.c(this.rQE).getParcelable("key_bankcard");
      this.wBd.a(new com.tencent.mm.plugin.wxcredit.a.f(paramVarArgs.field_bankcardType, paramVarArgs.field_bindSerial, f.d(this.rQE).getString("key_pwd1")), true, 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.f.1
 * JD-Core Version:    0.7.0.1
 */