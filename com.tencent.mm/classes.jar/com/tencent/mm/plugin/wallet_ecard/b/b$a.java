package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$a
  extends g
{
  public b$a(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof t))
    {
      paramm = (t)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Bundle();
        if ((paramm.qqX != null) && (paramm.qqX.qvd))
        {
          paramString = b.F(this.qKz).getString(a.qKb);
          str = b.G(this.qKz).getString(a.qKc);
          paramm = paramm.qqX.mOb;
          b.H(this.qKz).putString(a.qKd, paramm);
          this.wBd.kh(1985);
          paramString = new d(b.b(this.qKz), b.e(this.qKz), paramString, str, paramm, b.m(this.qKz), false);
          this.wBd.a(paramString, true);
        }
      }
    }
    while (!(paramm instanceof d))
    {
      String str;
      return false;
      paramString.putBoolean(a.qKh, true);
      this.qKz.a(this.gfb, 0, paramString);
      return false;
      y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
      paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
      h.b(this.gfb, paramString, "", false);
      return false;
    }
    this.wBd.ki(1985);
    paramm = (d)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.qKs.ino == 0)
      {
        paramString = new Bundle();
        paramString.putBoolean(a.qKh, false);
        if ((paramm.qKs.sAX != null) && (!bk.bl(paramm.qKs.sAX.title)))
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
        b.I(this.qKz).putByteArray(a.qKk, paramm.qKs.sAX.toByteArray());
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
  
  public final boolean m(Object... paramVarArgs)
  {
    String str = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    b.D(this.qKz).putString(a.qKb, str);
    b.E(this.qKz).putString(a.qKc, paramVarArgs);
    paramVarArgs = new t("", str, null);
    this.wBd.a(paramVarArgs, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.a
 * JD-Core Version:    0.7.0.1
 */