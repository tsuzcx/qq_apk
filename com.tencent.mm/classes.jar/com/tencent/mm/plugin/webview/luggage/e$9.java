package com.tencent.mm.plugin.webview.luggage;

import android.net.http.SslError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import com.tencent.xweb.w;

final class e$9
  extends w
{
  e$9(e parame) {}
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(153091);
    ab.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    this.uRQ.bFs();
    AppMethodBeat.o(153091);
  }
  
  public final void a(WebView paramWebView, m paramm, SslError paramSslError)
  {
    AppMethodBeat.i(153092);
    if (e.f(this.uRQ) == null) {
      e.a(this.uRQ, new d(this.uRQ.mContext, paramWebView));
    }
    e.f(this.uRQ).a(this.uRQ.getUrl(), paramm, paramSslError);
    AppMethodBeat.o(153092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.9
 * JD-Core Version:    0.7.0.1
 */