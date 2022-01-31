package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  extends b
{
  b$1(Context paramContext, b.a parama)
  {
    super(paramContext);
  }
  
  public final int bWV()
  {
    int j = 3;
    int i = j;
    if (this.qOl.qOn != null)
    {
      i = j;
      if (this.qOl.qOn.field_bankcardClientType == 1)
      {
        y.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
        i = new com.tencent.mm.plugin.wallet_core.model.a.b(this.qOl.qOn).qzV;
      }
    }
    if (i == 4)
    {
      y.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
      return a.g.payu_full_cvv_4_dialog;
    }
    return a.g.payu_full_cvv_dialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.b.1
 * JD-Core Version:    0.7.0.1
 */