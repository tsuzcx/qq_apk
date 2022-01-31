package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class WebViewUI$31
  implements KeyboardLinearLayout.a
{
  WebViewUI$31(WebViewUI paramWebViewUI, WebViewKeyboardLinearLayout paramWebViewKeyboardLinearLayout) {}
  
  public final void sJ(int paramInt)
  {
    AppMethodBeat.i(153243);
    ab.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramInt)));
    WebViewUI.a(this.vgz, this.vgC, paramInt);
    if (paramInt == -3)
    {
      this.vgz.uVh.dck().uXf = 1;
      int i = this.vgC.getKeyBoardHeight();
      if (i > 0)
      {
        WebViewUI.b(this.vgz, i);
        WebViewUI.a(this.vgz, i);
      }
      if (WebViewUI.l(this.vgz)) {
        WebViewUI.m(this.vgz).dhc();
      }
    }
    for (;;)
    {
      this.vgz.KB(paramInt);
      this.vgz.khm = paramInt;
      AppMethodBeat.o(153243);
      return;
      WebViewUI.b(this.vgz, 0);
      WebViewUI.a(this.vgz, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.31
 * JD-Core Version:    0.7.0.1
 */