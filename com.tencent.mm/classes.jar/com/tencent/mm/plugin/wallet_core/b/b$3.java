package com.tencent.mm.plugin.wallet_core.b;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$3
  extends g
{
  b$3(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof a))
      {
        y.i("MicroMsg.BindCardProcess", "verify code success!");
        paramString = (a)paramm;
        b.f(this.qqt).putString("kreq_token", paramString.token);
        return true;
      }
      if (!(paramm instanceof q)) {
        break label99;
      }
      this.qqt.a(this.wBd);
      if (((q)paramm).qqu != null) {
        b.g(this.qqt).putParcelable("key_bindcard_value_result", ((q)paramm).qqu);
      }
    }
    label99:
    while (!(paramm instanceof h)) {
      return false;
    }
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    this.qqt.A(new Object[] { "WalletVerifyCodeUI onNext", paramVarArgs });
    y.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
    paramVarArgs = (p)paramVarArgs[1];
    if (o.bVs().bVN()) {}
    for (paramVarArgs.flag = "2"; "realname_verify_process".equals(this.qqt.aTh()); paramVarArgs.flag = "1")
    {
      this.wBd.a(new q(paramVarArgs, this.qqt.kke.getInt("entry_scene", -1)), true, 1);
      return true;
    }
    this.wBd.a(new q(paramVarArgs), true, 1);
    return true;
  }
  
  public final CharSequence vy(int paramInt)
  {
    return this.gfb.getString(a.i.wallet_verify_code_bind_card_hint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.3
 * JD-Core Version:    0.7.0.1
 */