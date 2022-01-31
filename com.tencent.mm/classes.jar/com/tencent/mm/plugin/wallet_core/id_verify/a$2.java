package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.c))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.f(this.qrx).putInt("realname_verify_process_ret", -1);
        y.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
        o.bVs().xO();
        paramString = new tk();
        paramString.ccZ.scene = 16;
        paramString.bFJ = new a.2.1(this);
        com.tencent.mm.sdk.b.a.udP.m(paramString);
        a.a(this.qrx, this.wBd);
        this.qrx.b(this.gfb, a.g(this.qrx));
      }
    }
    else {
      while ((paramm instanceof h)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[0];
    String str = a.e(this.qrx).getString("key_real_name_token");
    if ((paramVarArgs == null) || (bk.bl(paramVarArgs.feN)))
    {
      y.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
      return true;
    }
    if (bk.bl(str))
    {
      y.e("MicroMsg.RealNameVerifyProcess", "get token error");
      return true;
    }
    paramVarArgs = new com.tencent.mm.plugin.wallet_core.id_verify.model.c(paramVarArgs.feN, str, this.qrx.kke.getInt("entry_scene", -1));
    this.wBd.a(paramVarArgs, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.2
 * JD-Core Version:    0.7.0.1
 */