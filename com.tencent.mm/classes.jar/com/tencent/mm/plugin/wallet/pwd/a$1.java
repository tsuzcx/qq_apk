package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bk;
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
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)))
    {
      paramString = o.bVo().bWq();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[] { paramString.field_reset_passwd_flag, paramString.field_find_passwd_url });
      paramString = o.bVs().bVW();
      if (!bk.bl(paramString))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ProcessManager", "jump to forget url: %s", new Object[] { paramString });
        e.l(this.gfb, paramString, false);
        return true;
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.1
 * JD-Core Version:    0.7.0.1
 */