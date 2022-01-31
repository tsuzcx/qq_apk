package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletOfflineCoinPurseUI$30$2
  extends h
{
  WalletOfflineCoinPurseUI$30$2(WalletOfflineCoinPurseUI.30 param30, Context paramContext, Bankcard paramBankcard)
  {
    super(paramContext);
  }
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    String str = this.mNG.field_forbid_url;
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { str });
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("geta8key_username", q.Gj());
    paramView.putExtra("pay_channel", 1);
    d.b(this.mND.mNj.mController.uMN, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.30.2
 * JD-Core Version:    0.7.0.1
 */