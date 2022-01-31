package com.tencent.mm.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.y;

final class e$6
  implements View.OnClickListener
{
  e$6(String paramString1, TextView paramTextView, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.val$url);
    paramView.putExtra("showShare", false);
    d.b(this.wCw.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    f.eZ(e.adL(this.wCx), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.6
 * JD-Core Version:    0.7.0.1
 */