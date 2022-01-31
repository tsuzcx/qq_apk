package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$6
  extends g
{
  e$6(e parame, MMActivity paramMMActivity, i parami)
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
        this.rQD.a(this.gfb, 0, e.al(this.rQD));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    e.am(this.rQD).putBoolean("key_is_follow_bank_username", ((Boolean)paramVarArgs[0]).booleanValue());
    e.an(this.rQD);
    this.wBd.a(new y(), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.6
 * JD-Core Version:    0.7.0.1
 */