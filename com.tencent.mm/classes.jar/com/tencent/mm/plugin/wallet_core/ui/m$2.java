package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.ab;

final class m$2
  implements View.OnClickListener
{
  m$2(ECardInfo paramECardInfo, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47393);
    paramView = new Intent();
    String str = this.uqC.uhg;
    ab.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[] { str });
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("geta8key_username", r.Zn());
    paramView.putExtra("pay_channel", 1);
    d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(47393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m.2
 * JD-Core Version:    0.7.0.1
 */