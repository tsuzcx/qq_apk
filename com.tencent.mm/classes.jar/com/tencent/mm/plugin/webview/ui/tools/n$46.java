package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;

final class n$46
  implements Runnable
{
  n$46(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(7759);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7759);
      return;
    }
    WebViewUI localWebViewUI = (WebViewUI)n.a(this.vdr).get();
    if (localWebViewUI.pOd != null) {
      localWebViewUI.pOd.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new WebViewUI.5(localWebViewUI));
    }
    AppMethodBeat.o(7759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.46
 * JD-Core Version:    0.7.0.1
 */