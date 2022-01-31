package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$1
  extends g
{
  b$1(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(46143);
    switch (paramInt)
    {
    default: 
      localObject = super.getTips(paramInt);
      AppMethodBeat.o(46143);
      return localObject;
    case 0: 
      localObject = this.hwZ.getString(2131305008);
      AppMethodBeat.o(46143);
      return localObject;
    }
    Object localObject = this.hwZ.getString(2131305429);
    AppMethodBeat.o(46143);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46142);
    String str = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    this.AXB.a(new u(str, 3, paramVarArgs), true, 1);
    AppMethodBeat.o(46142);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b.1
 * JD-Core Version:    0.7.0.1
 */