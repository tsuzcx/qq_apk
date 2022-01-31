package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$d
  extends g
{
  public b$d(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof d))
    {
      this.wBd.ki(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.qKs.ino == 0)
        {
          b.n(this.qKz).putInt(a.qJV, a.qKm);
          b.o(this.qKz).putString(a.qJY, paramm.qKt);
          b.p(this.qKz).putString(a.qJZ, paramm.qKu);
          b.q(this.qKz).putString(a.qKa, paramm.qKv);
          paramString = new Bundle();
          if (paramm.qKs.sAX != null)
          {
            y.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.qKg, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.r(this.qKz).putByteArray(a.qKk, paramm.qKs.sAX.toByteArray());
          this.qKz.a(this.gfb, 0, paramString);
          return true;
        }
        catch (IOException paramm)
        {
          y.printErrStackTrace("MicroMsg.OpenECardProcess", paramm, "", new Object[0]);
          continue;
        }
        y.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(a.qKg, true);
        paramString.putString(a.qKe, paramm.qKs.sAV);
        paramString.putString(a.qKf, paramm.qKs.twP);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm.qKs.sAW)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm, paramm.iHq, paramm.iHr, paramm.qKs.ino, paramm.qKs.inp)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramm.qKs.inp, paramm.iHr, paramString });
          h.b(this.gfb, paramString, "", false);
          continue;
          y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
          h.b(this.gfb, paramString, "", false);
        }
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (fv)paramVarArgs[0];
    String str = b.l(this.qKz).getString(a.qJT, "");
    if (paramVarArgs == null)
    {
      y.w("MicroMsg.OpenECardProcess", "empty bank item");
      return false;
    }
    this.wBd.kh(1985);
    paramVarArgs = new d(b.b(this.qKz), str, paramVarArgs.szT, paramVarArgs.qqU, paramVarArgs.mOb, b.m(this.qKz), true);
    this.wBd.a(paramVarArgs, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.d
 * JD-Core Version:    0.7.0.1
 */