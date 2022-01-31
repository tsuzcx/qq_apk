package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.y;

final class f$1$2
  extends h
{
  f$1$2(f.1 param1, Context paramContext, Bankcard paramBankcard)
  {
    super(paramContext);
  }
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    String str = this.qge.field_forbid_url;
    y.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("geta8key_username", q.Gj());
    paramView.putExtra("pay_channel", 1);
    d.b(this.qAu.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f.1.2
 * JD-Core Version:    0.7.0.1
 */