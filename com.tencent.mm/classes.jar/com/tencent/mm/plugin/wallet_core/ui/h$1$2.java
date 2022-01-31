package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1$2
  extends j
{
  h$1$2(h.1 param1, Context paramContext, Bankcard paramBankcard)
  {
    super(paramContext);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47156);
    paramView = new Intent();
    String str = this.tNr.field_forbid_url;
    ab.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
    paramView.putExtra("rawUrl", str);
    paramView.putExtra("geta8key_username", r.Zn());
    paramView.putExtra("pay_channel", 1);
    d.b(this.une.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(47156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h.1.2
 * JD-Core Version:    0.7.0.1
 */