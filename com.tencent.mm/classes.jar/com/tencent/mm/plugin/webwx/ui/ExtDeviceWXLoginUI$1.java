package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.aa;

final class ExtDeviceWXLoginUI$1
  implements View.OnClickListener
{
  ExtDeviceWXLoginUI$1(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26521);
    paramView = new Intent();
    paramView.putExtra("title", this.vux.getString(2131305917));
    paramView.putExtra("rawUrl", this.vux.getString(2131306162, new Object[] { aa.dsG() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    d.b(this.vux, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(26521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.1
 * JD-Core Version:    0.7.0.1
 */