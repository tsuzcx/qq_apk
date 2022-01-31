package com.tencent.mm.plugin.wallet_core.b;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$2
  extends g
{
  b$2(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof a))
      {
        paramString = (a)paramm;
        b.a(this.qqt).putString("kreq_token", paramString.token);
        if (this.qqt.c(this.gfb, b.b(this.qqt)))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindCardProcess", "need update bankcardlist");
          this.wBd.a(new com.tencent.mm.plugin.wallet_core.c.y(null, 12), false);
          return true;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
        this.qqt.a(this.gfb, 0, b.c(this.qqt));
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
        this.qqt.a(this.gfb, 0, b.d(this.qqt));
        return true;
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    this.qqt.A(new Object[] { "onNext", paramVarArgs });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
    paramVarArgs = (Authen)paramVarArgs[0];
    paramVarArgs.bcw = b.e(this.qqt);
    this.wBd.a(new a(paramVarArgs), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.2
 * JD-Core Version:    0.7.0.1
 */