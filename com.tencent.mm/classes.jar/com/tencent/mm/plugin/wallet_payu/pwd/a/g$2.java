package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

final class g$2
  extends com.tencent.mm.wallet_core.d.g
{
  g$2(g paramg, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48514);
    if ((paramm instanceof b))
    {
      ab.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        g.a(this.uDD).putInt("key_errcode_payu", 0);
        a.b(this.hwZ, this.uDD.mEJ, 0);
        AppMethodBeat.o(48514);
        return true;
      }
    }
    AppMethodBeat.o(48514);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48515);
    Object localObject = (u)paramVarArgs[0];
    paramVarArgs = g.b(this.uDD).getString("key_pwd1");
    localObject = ((u)localObject).gww;
    this.AXB.a(new b(paramVarArgs, (String)localObject), true);
    AppMethodBeat.o(48515);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.g.2
 * JD-Core Version:    0.7.0.1
 */