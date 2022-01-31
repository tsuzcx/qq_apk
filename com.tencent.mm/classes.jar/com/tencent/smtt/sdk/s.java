package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;

class s
  implements Runnable
{
  s(r paramr, WebView.WebViewTransport paramWebViewTransport, Message paramMessage) {}
  
  public void run()
  {
    AppMethodBeat.i(139058);
    WebView localWebView = this.a.getWebView();
    if (localWebView != null) {
      ((IX5WebViewBase.WebViewTransport)this.b.obj).setWebView(localWebView.c());
    }
    this.b.sendToTarget();
    AppMethodBeat.o(139058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.s
 * JD-Core Version:    0.7.0.1
 */