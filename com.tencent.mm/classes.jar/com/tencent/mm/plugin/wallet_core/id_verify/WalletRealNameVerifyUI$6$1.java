package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;

final class WalletRealNameVerifyUI$6$1
  implements h.d
{
  WalletRealNameVerifyUI$6$1(WalletRealNameVerifyUI.6 param6) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      d.b(this.qsf.qse.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      localIntent.putExtra("rawUrl", this.qsf.qse.getString(a.i.wallet_agreemnet_user, new Object[] { x.cqJ() }));
      continue;
      if (WalletRealNameVerifyUI.e(this.qsf.qse) != null) {
        localIntent.putExtra("rawUrl", this.qsf.qse.getString(a.i.wallet_agreemnet_bank, new Object[] { x.cqJ(), WalletRealNameVerifyUI.e(this.qsf.qse).mOb }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.6.1
 * JD-Core Version:    0.7.0.1
 */