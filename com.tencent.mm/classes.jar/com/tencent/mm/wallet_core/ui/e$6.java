package com.tencent.mm.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.ab;

final class e$6
  implements View.OnClickListener
{
  e$6(String paramString1, TextView paramTextView, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49261);
    ab.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.val$url);
    paramView.putExtra("showShare", false);
    d.b(this.AYJ.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    g.gK(e.aus(this.rAR), 1);
    AppMethodBeat.o(49261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.6
 * JD-Core Version:    0.7.0.1
 */