package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.so;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletOfflineCoinPurseUI$30$2
  extends j
{
  WalletOfflineCoinPurseUI$30$2(WalletOfflineCoinPurseUI.30 param30, Context paramContext, Bankcard paramBankcard)
  {
    super(paramContext);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43539);
    paramView = this.pnV.field_forbid_url;
    if ((this.pnV.cTk()) && (bo.isNullOrNil(paramView)))
    {
      ab.i("MicroMsg.WalletOfflineCoinPurseUI", "goto appbrand");
      paramView = new so();
      paramView.cIQ.userName = this.pnV.ugl;
      paramView.cIQ.cIS = this.pnV.uaL;
      paramView.cIQ.scene = 1137;
      paramView.cIQ.cIT = 0;
      a.ymk.l(paramView);
      AppMethodBeat.o(43539);
      return;
    }
    Intent localIntent = new Intent();
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[] { paramView });
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("geta8key_username", r.Zn());
    localIntent.putExtra("pay_channel", 1);
    d.b(this.pnS.pny.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(43539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.30.2
 * JD-Core Version:    0.7.0.1
 */