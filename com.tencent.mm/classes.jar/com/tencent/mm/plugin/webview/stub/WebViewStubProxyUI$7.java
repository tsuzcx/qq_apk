package com.tencent.mm.plugin.webview.stub;

import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewStubProxyUI$7
  implements am.a
{
  WebViewStubProxyUI$7(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final boolean tC()
  {
    if ((this.rjS.getWindow() == null) || (this.rjS.getWindow().getDecorView() == null) || (this.rjS.getWindow().getDecorView().getWindowToken() == null))
    {
      if (WebViewStubProxyUI.c(this.rjS) < 10)
      {
        WebViewStubProxyUI.d(this.rjS);
        return true;
      }
      y.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
      this.rjS.finish();
      return false;
    }
    WebViewStubProxyUI.e(this.rjS);
    WebViewStubProxyUI.f(this.rjS);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.7
 * JD-Core Version:    0.7.0.1
 */