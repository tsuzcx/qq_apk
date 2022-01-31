package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.w;

final class WebViewUI$24
  implements Runnable
{
  WebViewUI$24(WebViewUI paramWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(153237);
    if (this.vgz.pOd != null) {
      this.vgz.pOd.getCurWebviewClient().b(this.vgz.pOd, this.vgz.pOd.getUrl());
    }
    AppMethodBeat.o(153237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.24
 * JD-Core Version:    0.7.0.1
 */