package com.tencent.mm.plugin.wallet.pwd;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.pwd.a.p;
import com.tencent.mm.plugin.wallet.pwd.a.r;
import com.tencent.mm.plugin.wallet_core.model.v;
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
  
  public final boolean A(Object... paramVarArgs)
  {
    AppMethodBeat.i(199285);
    if (a.f(this.CKw) != null)
    {
      a.f(this.CKw).resend();
      this.LyU.b(a.f(this.CKw), false);
    }
    AppMethodBeat.o(199285);
    return true;
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(69489);
    String str = this.activity.getString(2131765911);
    AppMethodBeat.o(69489);
    return str;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69487);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof p)))
    {
      paramString = (p)paramn;
      a.e(this.CKw).putString("kreq_token", paramString.getToken());
      AppMethodBeat.o(69487);
      return true;
    }
    AppMethodBeat.o(69487);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    AppMethodBeat.i(69488);
    paramVarArgs = (v)paramVarArgs[1];
    paramVarArgs.flag = "3";
    this.LyU.a(new r(paramVarArgs), true, 1);
    AppMethodBeat.o(69488);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.4
 * JD-Core Version:    0.7.0.1
 */