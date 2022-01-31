package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46145);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof j))
      {
        this.tXC.a(this.hwZ, 0, b.a(this.tXC));
        h.bO(this.hwZ, this.hwZ.getString(2131305411));
      }
      AppMethodBeat.o(46145);
      return true;
    }
    if ((paramm instanceof j))
    {
      h.a(this.hwZ, paramString, "", false, new b.2.1(this));
      AppMethodBeat.o(46145);
      return true;
    }
    AppMethodBeat.o(46145);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46146);
    paramVarArgs = (u)paramVarArgs[0];
    String str = b.b(this.tXC).getString("key_pwd1");
    this.AXB.a(new j(str, paramVarArgs.gww), true, 1);
    AppMethodBeat.o(46146);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b.2
 * JD-Core Version:    0.7.0.1
 */