package com.tencent.mm.plugin.wallet_core.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$3
  extends g
{
  b$3(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(46473);
    String str = this.hwZ.getString(2131305684);
    AppMethodBeat.o(46473);
    return str;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46471);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof a))
      {
        ab.i("MicroMsg.BindCardProcess", "verify code success!");
        paramString = (a)paramm;
        b.e(this.ubp).putString("kreq_token", paramString.getToken());
        AppMethodBeat.o(46471);
        return true;
      }
      if (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.t)) {
        break label114;
      }
      this.ubp.a(this.AXB);
      if (((com.tencent.mm.plugin.wallet_core.c.t)paramm).ubq != null) {
        b.f(this.ubp).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.c.t)paramm).ubq);
      }
    }
    label114:
    while (!(paramm instanceof h))
    {
      AppMethodBeat.o(46471);
      return false;
    }
    AppMethodBeat.o(46471);
    return true;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46472);
    this.ubp.G(new Object[] { "WalletVerifyCodeUI onNext", paramVarArgs });
    ab.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
    paramVarArgs = (u)paramVarArgs[1];
    if (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUl())
    {
      paramVarArgs.flag = "2";
      if (!"realname_verify_process".equals(this.ubp.bzC())) {
        break label115;
      }
      this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.t(paramVarArgs, this.ubp.mEJ.getInt("entry_scene", -1)), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(46472);
      return true;
      paramVarArgs.flag = "1";
      break;
      label115:
      this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.t(paramVarArgs), true, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.3
 * JD-Core Version:    0.7.0.1
 */