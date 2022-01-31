package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

final class a$1
  extends g
{
  a$1(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46127);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)))
    {
      paramString = t.cTJ().cVl();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[] { paramString.field_reset_passwd_flag, paramString.field_find_passwd_url });
      paramString = t.cTN().cUy();
      if (!bo.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ProcessManager", "jump to forget url: %s", new Object[] { paramString });
        e.m(this.hwZ, paramString, false);
        AppMethodBeat.o(46127);
        return true;
      }
    }
    AppMethodBeat.o(46127);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.1
 * JD-Core Version:    0.7.0.1
 */