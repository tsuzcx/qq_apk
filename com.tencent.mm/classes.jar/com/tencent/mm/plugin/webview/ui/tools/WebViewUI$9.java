package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$9
  implements View.OnClickListener
{
  WebViewUI$9(WebViewUI paramWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7817);
    WebViewUI localWebViewUI = this.vgz;
    if (bo.isNullOrNil(WebViewUI.d(this.vgz))) {}
    for (paramView = this.vgz.cJr;; paramView = WebViewUI.d(this.vgz))
    {
      localWebViewUI.Hr(paramView);
      AppMethodBeat.o(7817);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.9
 * JD-Core Version:    0.7.0.1
 */