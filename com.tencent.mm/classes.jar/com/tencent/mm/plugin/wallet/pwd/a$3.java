package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$3
  extends g
{
  a$3(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46129);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof n)))
    {
      paramString = (n)paramm;
      a.a(this.tXB).putString("kreq_token", paramString.getToken());
      this.tXB.a(this.hwZ, 0, a.b(this.tXB));
      AppMethodBeat.o(46129);
      return true;
    }
    AppMethodBeat.o(46129);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46130);
    paramVarArgs = (Authen)paramVarArgs[0];
    if (!this.tXB.cWe())
    {
      paramVarArgs.bsY = 1;
      if (!a.c(this.tXB).getBoolean("key_is_paymanager")) {
        break label90;
      }
    }
    label90:
    for (int i = 1;; i = 0)
    {
      this.AXB.a(new n(paramVarArgs, a.d(this.tXB).getBoolean("key_is_reset_with_new_card", false), i), true, 1);
      AppMethodBeat.o(46130);
      return true;
      paramVarArgs.bsY = 4;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.3
 * JD-Core Version:    0.7.0.1
 */