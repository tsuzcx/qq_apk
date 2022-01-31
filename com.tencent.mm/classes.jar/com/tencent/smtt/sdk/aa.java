package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class aa
  implements Runnable
{
  aa(SystemWebChromeClient paramSystemWebChromeClient, WebView.WebViewTransport paramWebViewTransport, Message paramMessage) {}
  
  public void run()
  {
    AppMethodBeat.i(139128);
    WebView localWebView = this.a.getWebView();
    if (localWebView != null) {
      ((android.webkit.WebView.WebViewTransport)this.b.obj).setWebView(localWebView.b());
    }
    this.b.sendToTarget();
    AppMethodBeat.o(139128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.aa
 * JD-Core Version:    0.7.0.1
 */