package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.pwd.a.t;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public final boolean q(Object... paramVarArgs)
  {
    AppMethodBeat.i(69484);
    if (paramVarArgs.length == 3)
    {
      paramVarArgs = new t(paramVarArgs[0].toString(), ((Integer)paramVarArgs[1]).intValue(), (String)paramVarArgs[2]);
      this.Ieo.b(paramVarArgs, true);
    }
    AppMethodBeat.o(69484);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.2
 * JD-Core Version:    0.7.0.1
 */