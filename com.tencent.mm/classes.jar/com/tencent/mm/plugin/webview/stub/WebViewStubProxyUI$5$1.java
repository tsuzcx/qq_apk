package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewStubProxyUI$5$1
  implements Runnable
{
  WebViewStubProxyUI$5$1(WebViewStubProxyUI.5 param5, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(7073);
    h.KW(WebViewStubProxyUI.b(this.uZq.uZk)).a(null, null, null);
    this.uZq.uZk.finish();
    try
    {
      WebViewStubProxyUI.a(this.uZq.uZk).a(this.uZm, this.uZn, this.uZo, this.uZp);
      AppMethodBeat.o(7073);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(7073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.5.1
 * JD-Core Version:    0.7.0.1
 */