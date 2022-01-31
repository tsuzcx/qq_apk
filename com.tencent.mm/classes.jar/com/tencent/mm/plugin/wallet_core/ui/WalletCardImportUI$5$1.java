package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;

final class WalletCardImportUI$5$1
  implements h.d
{
  WalletCardImportUI$5$1(WalletCardImportUI.5 param5) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      d.b(this.qCA.qCx.mController.uMN, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
      localIntent.putExtra("rawUrl", this.qCA.qCx.getString(a.i.wallet_agreemnet_user, new Object[] { x.cqJ() }));
      continue;
      if (WalletCardImportUI.c(this.qCA.qCx) != null) {
        localIntent.putExtra("rawUrl", this.qCA.qCx.getString(a.i.wallet_agreemnet_bank, new Object[] { x.cqJ(), WalletCardImportUI.c(this.qCA.qCx).mOb }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.5.1
 * JD-Core Version:    0.7.0.1
 */