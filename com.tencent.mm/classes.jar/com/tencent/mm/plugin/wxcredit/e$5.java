package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

final class e$5
  extends com.tencent.mm.wallet_core.d.g
{
  e$5(e parame, MMActivity paramMMActivity, i parami)
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
        if (!(paramm instanceof b)) {
          break label49;
        }
        this.wBd.a(new y(), true, 1);
        bool1 = true;
      }
    }
    label49:
    do
    {
      return bool1;
      if ((paramm instanceof y))
      {
        paramString = new com.tencent.mm.plugin.wxcredit.a.g(e.aa(this.rQD).getString("key_verify_code"), e.ab(this.rQD).getString("KEY_SESSION_KEY"), e.ac(this.rQD).getString("key_pwd1"), o.bVs().bWd(), e.ad(this.rQD).getString("key_bank_type"));
        this.wBd.a(paramString, true, 1);
        return true;
      }
      bool1 = bool2;
    } while (!(paramm instanceof com.tencent.mm.plugin.wxcredit.a.g));
    paramString = ((com.tencent.mm.plugin.wxcredit.a.g)paramm).bUU;
    if (!bk.bl(paramString)) {
      e.ae(this.rQD).putString("key_bank_username", paramString);
    }
    this.rQD.a(this.gfb, 0, e.af(this.rQD));
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    if (!e.ag(this.rQD).getBoolean("key_is_bank_user", false))
    {
      this.wBd.a(new b((p)paramVarArgs[0]), true, 1);
      return true;
    }
    this.wBd.a(new com.tencent.mm.plugin.wxcredit.a.g(e.ah(this.rQD).getString("key_verify_code"), e.ai(this.rQD).getString("KEY_SESSION_KEY"), e.aj(this.rQD).getString("key_pwd1"), o.bVs().bWd(), e.ak(this.rQD).getString("key_bank_type")), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.5
 * JD-Core Version:    0.7.0.1
 */