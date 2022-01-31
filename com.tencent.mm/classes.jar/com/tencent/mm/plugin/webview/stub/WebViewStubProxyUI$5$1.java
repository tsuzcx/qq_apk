package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewStubProxyUI$5$1
  implements Runnable
{
  WebViewStubProxyUI$5$1(WebViewStubProxyUI.5 param5, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean) {}
  
  public final void run()
  {
    h.Db(WebViewStubProxyUI.b(this.rjY.rjS)).a(null, null, null);
    this.rjY.rjS.finish();
    try
    {
      WebViewStubProxyUI.a(this.rjY.rjS).a(this.rjU, this.rjV, this.rjW, this.rjX);
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.5.1
 * JD-Core Version:    0.7.0.1
 */