package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.p;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$4
  extends g
{
  a$4(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(46133);
    String str = this.hwZ.getString(2131305692);
    AppMethodBeat.o(46133);
    return str;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46131);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof n)))
    {
      paramString = (n)paramm;
      a.e(this.tXB).putString("kreq_token", paramString.getToken());
      AppMethodBeat.o(46131);
      return true;
    }
    AppMethodBeat.o(46131);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(46132);
    paramVarArgs = (u)paramVarArgs[1];
    paramVarArgs.flag = "3";
    this.AXB.a(new p(paramVarArgs), true, 1);
    AppMethodBeat.o(46132);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.4
 * JD-Core Version:    0.7.0.1
 */