package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  extends b
{
  b$1(Context paramContext, b.a parama)
  {
    super(paramContext);
  }
  
  public final int bvM()
  {
    AppMethodBeat.i(48496);
    int j = 3;
    int i = j;
    if (this.uDs.uDu != null)
    {
      i = j;
      if (this.uDs.uDu.field_bankcardClientType == 1)
      {
        ab.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
        i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.uDs.uDu).umF;
      }
    }
    if (i == 4)
    {
      ab.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
      AppMethodBeat.o(48496);
      return 2130970404;
    }
    AppMethodBeat.o(48496);
    return 2130970405;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b.1
 * JD-Core Version:    0.7.0.1
 */