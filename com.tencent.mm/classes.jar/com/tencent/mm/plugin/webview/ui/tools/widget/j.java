package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class j
  extends i
{
  private final b vso;
  
  public j(MMWebView paramMMWebView, b paramb)
  {
    super((MMWebViewWithJsApi)paramMMWebView);
    AppMethodBeat.i(9919);
    this.vso = paramb;
    AppMethodBeat.o(9919);
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(9920);
    if (this.vso != null)
    {
      this.vso.pW(paramString);
      AppMethodBeat.o(9920);
      return;
    }
    super.d(paramWebView, paramString);
    AppMethodBeat.o(9920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.j
 * JD-Core Version:    0.7.0.1
 */