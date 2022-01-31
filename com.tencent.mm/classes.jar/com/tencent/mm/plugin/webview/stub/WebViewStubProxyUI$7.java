package com.tencent.mm.plugin.webview.stub;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WebViewStubProxyUI$7
  implements ap.a
{
  WebViewStubProxyUI$7(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(7096);
    if ((this.uZk.getWindow() == null) || (this.uZk.getWindow().getDecorView() == null) || (this.uZk.getWindow().getDecorView().getWindowToken() == null))
    {
      if (WebViewStubProxyUI.c(this.uZk) < 10)
      {
        WebViewStubProxyUI.d(this.uZk);
        AppMethodBeat.o(7096);
        return true;
      }
      ab.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
      this.uZk.finish();
      AppMethodBeat.o(7096);
      return false;
    }
    WebViewStubProxyUI.e(this.uZk);
    WebViewStubProxyUI.f(this.uZk);
    AppMethodBeat.o(7096);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.7
 * JD-Core Version:    0.7.0.1
 */