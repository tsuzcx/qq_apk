package com.tencent.mm.plugin.offline;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class d$1
  extends g
{
  d$1(d paramd, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof y))
      {
        if ((((WalletBaseUI)this.gfb).BX != null) && (((WalletBaseUI)this.gfb).BX.getInt("key_bind_scene", -1) == 5) && (!com.tencent.mm.plugin.offline.c.a.bqH()))
        {
          d.h(this.gfb);
          return true;
        }
      }
      else if ((paramm instanceof k))
      {
        com.tencent.mm.wallet_core.a.j(this.gfb, ((WalletBaseUI)this.gfb).BX);
        com.tencent.mm.plugin.offline.c.a.H(this.gfb);
        return true;
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[1];
    paramVarArgs.flag = "1";
    this.wBd.a(new q(paramVarArgs), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.d.1
 * JD-Core Version:    0.7.0.1
 */