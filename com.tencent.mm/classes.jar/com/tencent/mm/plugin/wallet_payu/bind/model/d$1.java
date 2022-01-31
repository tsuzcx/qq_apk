package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(48346);
    if (paramInt == 0)
    {
      localObject = this.hwZ.getString(2131305017);
      AppMethodBeat.o(48346);
      return localObject;
    }
    Object localObject = super.getTips(paramInt);
    AppMethodBeat.o(48346);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48347);
    if ((paramm instanceof c)) {
      if ((paramInt2 == 0) && (paramInt1 == 0))
      {
        paramString = (c)paramm;
        d.a(this.uBT).putString("payu_reference", paramString.token);
        if (bo.isNullOrNil(paramString.token)) {
          break label118;
        }
        ab.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
        paramString = (Bankcard)d.b(this.uBT).getParcelable("key_bankcard");
        if (paramString != null) {
          this.AXB.a(new b(paramString.field_bindSerial, d.c(this.uBT).getString("payu_reference")), true);
        }
      }
    }
    label118:
    while (!(paramm instanceof b)) {
      for (;;)
      {
        AppMethodBeat.o(48347);
        return false;
        ab.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      d.d(this.uBT).putInt("key_errcode_payu", 0);
      this.uBT.b(this.hwZ, d.e(this.uBT));
    }
    AppMethodBeat.o(48347);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48348);
    d.f(this.uBT).putString("key_pwd1", (String)paramVarArgs[0]);
    this.AXB.a(new c(d.g(this.uBT).getString("key_pwd1")), true);
    AppMethodBeat.o(48348);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.d.1
 * JD-Core Version:    0.7.0.1
 */