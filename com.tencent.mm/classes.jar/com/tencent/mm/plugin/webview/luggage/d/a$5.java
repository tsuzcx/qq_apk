package com.tencent.mm.plugin.webview.luggage.d;

import android.graphics.Bitmap;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.xweb.WebView;

final class a$5
  extends g
{
  a$5(a parama) {}
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(6518);
    d.i(getClass().getSimpleName(), "onPageStarted");
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(6518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a.5
 * JD-Core Version:    0.7.0.1
 */