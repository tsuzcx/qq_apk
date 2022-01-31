package com.tencent.mm.plugin.offline;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.wallet_core.b.a.b;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class d$2
  extends g
{
  d$2(d paramd, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43297);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof ab))
      {
        if ((((WalletBaseUI)this.hwZ).getInput() != null) && (((WalletBaseUI)this.hwZ).getInput().getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.bZw())) {
          d.i(this.hwZ);
        }
        AppMethodBeat.o(43297);
        return true;
      }
      if ((paramm instanceof k))
      {
        paramString = ((WalletBaseUI)this.hwZ).getInput();
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this.hwZ, paramString);
        com.tencent.mm.plugin.offline.c.a.ac(this.hwZ);
        AppMethodBeat.o(43297);
        return true;
      }
    }
    AppMethodBeat.o(43297);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(43296);
    paramVarArgs = (u)paramVarArgs[0];
    this.AXB.a(new b(paramVarArgs), true, 1);
    AppMethodBeat.o(43296);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.d.2
 * JD-Core Version:    0.7.0.1
 */