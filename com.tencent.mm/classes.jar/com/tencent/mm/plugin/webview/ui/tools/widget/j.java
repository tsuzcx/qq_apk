package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class j
  extends i
{
  private final b Jyx;
  
  public j(MMWebView paramMMWebView, b paramb)
  {
    super((MMWebViewWithJsApi)paramMMWebView);
    AppMethodBeat.i(82128);
    this.Jyx = paramb;
    AppMethodBeat.o(82128);
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82129);
    if (this.Jyx != null)
    {
      this.Jyx.Lc(paramString);
      AppMethodBeat.o(82129);
      return;
    }
    super.d(paramWebView, paramString);
    AppMethodBeat.o(82129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.j
 * JD-Core Version:    0.7.0.1
 */