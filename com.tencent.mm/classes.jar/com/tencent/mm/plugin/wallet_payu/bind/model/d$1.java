package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class d$1
  extends g
{
  d$1(d paramd, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof c)) {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = (c)paramm;
        d.a(this.qMM).putString("payu_reference", paramString.token);
        if (bk.bl(paramString.token)) {
          break label108;
        }
        y.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
        paramString = (Bankcard)d.b(this.qMM).getParcelable("key_bankcard");
        if (paramString != null) {
          this.wBd.a(new b(paramString.field_bindSerial, d.c(this.qMM).getString("payu_reference")), true);
        }
      }
    }
    label108:
    while ((!(paramm instanceof b)) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      return false;
      y.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
      return false;
    }
    d.d(this.qMM).putInt("key_errcode_payu", 0);
    this.qMM.b(this.gfb, d.e(this.qMM));
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    d.f(this.qMM).putString("key_pwd1", (String)paramVarArgs[0]);
    this.wBd.a(new c(d.g(this.qMM).getString("key_pwd1")), true);
    return true;
  }
  
  public final CharSequence vy(int paramInt)
  {
    if (paramInt == 0) {
      return this.gfb.getString(a.i.wallet_check_pwd_unbind_bankcard_tip_payu);
    }
    return super.vy(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.d.1
 * JD-Core Version:    0.7.0.1
 */