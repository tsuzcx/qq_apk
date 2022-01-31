package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

final class c$2
  extends g
{
  c$2(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.a.a))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.a.a)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.nUR))
      {
        c.a(this.qNi).putString("payu_reference", paramString.qNA);
        com.tencent.mm.wallet_core.a.j(this.gfb, this.qNi.kke);
        return true;
      }
    }
    else if (((paramm instanceof b)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (b)paramm;
      this.qNi.kke.putString("payu_reference", paramString.bRP);
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    this.wBd.a(new com.tencent.mm.plugin.wallet_payu.a.a((String)paramVarArgs[0], this.qNi.kke.getString("payu_reference")), true);
    return true;
  }
  
  public final boolean t(Object... paramVarArgs)
  {
    this.wBd.a(new b(this.qNi.kke.getString("dial_code"), this.qNi.kke.getString("key_mobile")), true, 1);
    return true;
  }
  
  public final CharSequence vy(int paramInt)
  {
    if (paramInt == 0) {
      return this.gfb.getString(a.i.wallet_verify_code_bind_hint_payu, new Object[] { e.afk("+" + c.b(this.qNi).getString("dial_code") + c.c(this.qNi).getString("key_mobile")) });
    }
    return super.vy(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.2
 * JD-Core Version:    0.7.0.1
 */