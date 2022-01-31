package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$2
  extends g
{
  a$2(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46578);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.c))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.i(this.ucw).putInt("realname_verify_process_ret", -1);
        ab.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
        t.cTN().Kg();
        paramString = new vf();
        paramString.cLJ.scene = 16;
        paramString.callback = new a.2.1(this);
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        a.a(this.ucw, this.AXB);
        if (a.j(this.ucw) == 2) {
          this.ucw.b(this.hwZ, a.k(this.ucw));
        }
        for (;;)
        {
          AppMethodBeat.o(46578);
          return true;
          this.ucw.a(this.hwZ, 0, a.l(this.ucw));
        }
      }
    }
    else
    {
      if (!(paramm instanceof b)) {
        break label332;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.m(this.ucw).putInt("realname_verify_process_ret", -1);
        ab.i("MicroMsg.RealNameVerifyProcess", "bind card verify succ ,update user info");
        if (((b)paramm).ubq != null) {
          a.n(this.ucw).putParcelable("key_bindcard_value_result", ((b)paramm).ubq);
        }
        t.cTN().Kg();
        paramString = new vf();
        paramString.cLJ.scene = 16;
        paramString.callback = new a.2.2(this);
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        a.b(this.ucw, this.AXB);
        if (a.j(this.ucw) != 2) {
          break label310;
        }
        this.ucw.b(this.hwZ, a.o(this.ucw));
      }
    }
    label310:
    label332:
    while (!(paramm instanceof h)) {
      for (;;)
      {
        AppMethodBeat.o(46578);
        return false;
        this.ucw.a(this.hwZ, 0, a.p(this.ucw));
      }
    }
    AppMethodBeat.o(46578);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46577);
    paramVarArgs = (u)paramVarArgs[0];
    String str1 = a.f(this.ucw).getString("key_real_name_token");
    String str2 = a.g(this.ucw).getString("realname_verify_process_face_token");
    if ((paramVarArgs == null) || (bo.isNullOrNil(paramVarArgs.gww))) {
      ab.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
    }
    for (;;)
    {
      AppMethodBeat.o(46577);
      return true;
      if (a.h(this.ucw).containsKey("kreq_token"))
      {
        ab.i("MicroMsg.RealNameVerifyProcess", "bindcard verify");
        this.AXB.a(new b(paramVarArgs, this.ucw.mEJ.getInt("entry_scene", -1)), true);
      }
      else if (!bo.isNullOrNil(str1))
      {
        paramVarArgs = new com.tencent.mm.plugin.wallet_core.id_verify.model.c(paramVarArgs.gww, str1, str2, this.ucw.mEJ.getInt("entry_scene", -1));
        this.AXB.a(paramVarArgs, true);
      }
      else
      {
        ab.e("MicroMsg.RealNameVerifyProcess", "realnamereg error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.2
 * JD-Core Version:    0.7.0.1
 */