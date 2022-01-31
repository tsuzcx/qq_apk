package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

final class WebViewUI$14
  implements WebViewInputFooter.b
{
  WebViewUI$14(WebViewUI paramWebViewUI) {}
  
  public final void dbh()
  {
    AppMethodBeat.i(7828);
    WebViewUI.a(this.vgz, 0);
    AppMethodBeat.o(7828);
  }
  
  public final void dbi()
  {
    AppMethodBeat.i(7829);
    WebViewKeyboardLinearLayout localWebViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout)this.vgz.findViewById(2131823716);
    if ((localWebViewKeyboardLinearLayout != null) && (localWebViewKeyboardLinearLayout.getKeyBoardHeight() > 0)) {
      WebViewUI.a(this.vgz, localWebViewKeyboardLinearLayout.getKeyBoardHeight());
    }
    AppMethodBeat.o(7829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.14
 * JD-Core Version:    0.7.0.1
 */