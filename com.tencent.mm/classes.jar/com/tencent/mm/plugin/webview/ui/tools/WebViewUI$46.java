package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class WebViewUI$46
  implements a.b
{
  WebViewUI$46(WebViewUI paramWebViewUI) {}
  
  public final void beL()
  {
    AppMethodBeat.i(210069);
    try
    {
      this.CAQ.kYt.favEditTag();
      AppMethodBeat.o(210069);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
      AppMethodBeat.o(210069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.46
 * JD-Core Version:    0.7.0.1
 */