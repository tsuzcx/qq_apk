package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.sdk.platformtools.y;

final class WalletBalanceFetchUI$11$1
  extends h
{
  WalletBalanceFetchUI$11$1(WalletBalanceFetchUI.11 param11, Context paramContext, Bankcard paramBankcard)
  {
    super(paramContext);
  }
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    String str = this.qge.field_forbid_url;
    y.i("MicroMsg.WalletBalanceFetchUI", "go to url %s", new Object[] { str });
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("geta8key_username", q.Gj());
    paramView.putExtra("pay_channel", 1);
    d.b(this.qgV.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.11.1
 * JD-Core Version:    0.7.0.1
 */