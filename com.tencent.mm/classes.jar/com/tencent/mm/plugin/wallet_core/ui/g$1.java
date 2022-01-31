package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String))
    {
      Intent localIntent = new Intent();
      paramView = (String)paramView.getTag();
      y.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[] { paramView });
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("geta8key_username", q.Gj());
      localIntent.putExtra("pay_channel", 1);
      d.b(g.a(this.qCS), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent, WalletChangeBankcardUI.qmv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.g.1
 * JD-Core Version:    0.7.0.1
 */