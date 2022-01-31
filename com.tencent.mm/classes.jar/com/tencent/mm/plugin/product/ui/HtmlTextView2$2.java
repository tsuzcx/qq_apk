package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

final class HtmlTextView2$2
  extends w
{
  HtmlTextView2$2(HtmlTextView2 paramHtmlTextView2) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(44021);
    ab.d("test", paramString);
    AppMethodBeat.o(44021);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView2.2
 * JD-Core Version:    0.7.0.1
 */