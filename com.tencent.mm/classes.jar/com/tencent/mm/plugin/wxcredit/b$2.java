package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.r;
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
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        this.rQA.a(this.gfb, 0, b.e(this.rQA));
        this.gfb.finish();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    b.f(this.rQA).putString("key_pwd1", (String)paramVarArgs[0]);
    this.wBd.a(new r((String)paramVarArgs[0], 5, ""), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b.2
 * JD-Core Version:    0.7.0.1
 */