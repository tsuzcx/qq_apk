package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class c$1
  extends g
{
  c$1(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof b))
    {
      y.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (b)paramm;
        this.qNi.kke.putString("payu_reference", paramString.bRP);
        y.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[] { paramString.bRP });
        this.qNi.kke.putBoolean("key_is_has_mobile", paramString.qNB);
        a.j(this.gfb, this.qNi.kke);
        return true;
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    this.wBd.a(new b(this.qNi.kke.getString("dial_code"), this.qNi.kke.getString("key_mobile")), true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.1
 * JD-Core Version:    0.7.0.1
 */