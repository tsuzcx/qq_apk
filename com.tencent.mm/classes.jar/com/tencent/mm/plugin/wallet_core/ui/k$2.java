package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.y;

public final class k$2
  implements View.OnClickListener
{
  public k$2(ECardInfo paramECardInfo, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    String str = this.qDH.quO;
    y.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { str });
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("geta8key_username", q.Gj());
    paramView.putExtra("pay_channel", 1);
    d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k.2
 * JD-Core Version:    0.7.0.1
 */