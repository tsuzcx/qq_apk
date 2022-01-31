package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

final class e$3
  extends com.tencent.mm.wallet_core.d.g
{
  e$3(e parame, MMActivity paramMMActivity, i parami)
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
        if (!(paramm instanceof com.tencent.mm.plugin.wxcredit.a.g)) {
          break label81;
        }
        paramString = ((com.tencent.mm.plugin.wxcredit.a.g)paramm).bUU;
        if (!bk.bl(paramString)) {
          e.q(this.rQD).putString("key_bank_username", paramString);
        }
        this.rQD.a(this.gfb, 0, e.r(this.rQD));
        bool1 = true;
      }
    }
    label81:
    do
    {
      return bool1;
      if ((paramm instanceof h))
      {
        this.rQD.a(this.gfb, 0, e.s(this.rQD));
        return true;
      }
      if ((paramm instanceof q))
      {
        if (o.bVs().bVN())
        {
          this.wBd.a(new y(), true, 1);
          return true;
        }
        this.rQD.a(this.gfb, 0, e.t(this.rQD));
        return true;
      }
      bool1 = bool2;
    } while (!(paramm instanceof y));
    paramString = o.bVs().bWd();
    paramString = new com.tencent.mm.plugin.wxcredit.a.g(e.u(this.rQD).getString("key_verify_code"), e.v(this.rQD).getString("KEY_SESSION_KEY"), e.w(this.rQD).getString("key_pwd1"), paramString, e.x(this.rQD).getString("key_bank_type"));
    this.wBd.a(paramString, true, 1);
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    String str = (String)paramVarArgs[0];
    e.y(this.rQD).putString("key_verify_code", str);
    if (o.bVs().bVN())
    {
      if ((e.z(this.rQD).getBoolean("key_need_bind_deposit", true)) && (!e.A(this.rQD).getBoolean("key_is_bank_user")))
      {
        paramVarArgs = (p)paramVarArgs[1];
        paramVarArgs.flag = "2";
        this.wBd.a(new q(paramVarArgs), true, 1);
        return true;
      }
      this.wBd.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.B(this.rQD).getString("KEY_SESSION_KEY"), e.C(this.rQD).getString("key_pwd1"), e.D(this.rQD).getString("key_bind_serial"), e.E(this.rQD).getString("key_bank_type")), true, 1);
      return true;
    }
    if (e.F(this.rQD).getBoolean("key_is_bank_user", false))
    {
      e.G(this.rQD).putString("key_verify_code", str);
      this.wBd.a(new h(str, e.H(this.rQD).getString("KEY_SESSION_KEY"), e.I(this.rQD).getString("key_pwd1"), e.J(this.rQD).getString("key_bind_serial"), e.K(this.rQD).getString("key_bank_type")), true, 1);
      return true;
    }
    paramVarArgs = (p)paramVarArgs[1];
    paramVarArgs.flag = "1";
    this.wBd.a(new q(paramVarArgs), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.3
 * JD-Core Version:    0.7.0.1
 */