package com.tencent.mm.plugin.wxcredit;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48629);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wxcredit.a.g))
      {
        paramString = ((com.tencent.mm.plugin.wxcredit.a.g)paramm).cCC;
        if (!bo.isNullOrNil(paramString)) {
          e.q(this.vHu).putString("key_bank_username", paramString);
        }
        this.vHu.a(this.hwZ, 0, e.r(this.vHu));
        AppMethodBeat.o(48629);
        return true;
      }
      if ((paramm instanceof h))
      {
        this.vHu.a(this.hwZ, 0, e.s(this.vHu));
        AppMethodBeat.o(48629);
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.t))
      {
        if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl())
        {
          this.AXB.a(new ab(), true, 1);
          AppMethodBeat.o(48629);
          return true;
        }
        this.vHu.a(this.hwZ, 0, e.t(this.vHu));
        AppMethodBeat.o(48629);
        return true;
      }
      if ((paramm instanceof ab))
      {
        paramString = com.tencent.mm.plugin.wallet_core.model.t.cTN().cUP();
        paramString = new com.tencent.mm.plugin.wxcredit.a.g(e.u(this.vHu).getString("key_verify_code"), e.v(this.vHu).getString("KEY_SESSION_KEY"), e.w(this.vHu).getString("key_pwd1"), paramString, e.x(this.vHu).getString("key_bank_type"));
        this.AXB.a(paramString, true, 1);
        AppMethodBeat.o(48629);
        return true;
      }
      AppMethodBeat.o(48629);
      return false;
    }
    AppMethodBeat.o(48629);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48630);
    String str = (String)paramVarArgs[0];
    e.y(this.vHu).putString("key_verify_code", str);
    if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl()) {
      if ((e.z(this.vHu).getBoolean("key_need_bind_deposit", true)) && (!e.A(this.vHu).getBoolean("key_is_bank_user")))
      {
        paramVarArgs = (u)paramVarArgs[1];
        paramVarArgs.flag = "2";
        this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.t(paramVarArgs), true, 1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(48630);
      return true;
      this.AXB.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.B(this.vHu).getString("KEY_SESSION_KEY"), e.C(this.vHu).getString("key_pwd1"), e.D(this.vHu).getString("key_bind_serial"), e.E(this.vHu).getString("key_bank_type")), true, 1);
      continue;
      if (e.F(this.vHu).getBoolean("key_is_bank_user", false))
      {
        e.G(this.vHu).putString("key_verify_code", str);
        this.AXB.a(new h(str, e.H(this.vHu).getString("KEY_SESSION_KEY"), e.I(this.vHu).getString("key_pwd1"), e.J(this.vHu).getString("key_bind_serial"), e.K(this.vHu).getString("key_bank_type")), true, 1);
      }
      else
      {
        paramVarArgs = (u)paramVarArgs[1];
        paramVarArgs.flag = "1";
        this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.t(paramVarArgs), true, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.e.3
 * JD-Core Version:    0.7.0.1
 */