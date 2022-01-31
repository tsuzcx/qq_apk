package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class j
  extends i
{
  private final b rCc;
  
  public j(MMWebView paramMMWebView, b paramb)
  {
    super((MMWebViewWithJsApi)paramMMWebView);
    this.rCc = paramb;
  }
  
  public final void d(WebView paramWebView, String paramString)
  {
    if (this.rCc != null)
    {
      this.rCc.ji(paramString);
      return;
    }
    super.d(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.j
 * JD-Core Version:    0.7.0.1
 */