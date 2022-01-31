package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewStubProxyUI$5
  implements e
{
  WebViewStubProxyUI$5(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final boolean Ke(int paramInt)
  {
    AppMethodBeat.i(7074);
    WebViewStubProxyUI.a(this.uZk).Ke(paramInt);
    AppMethodBeat.o(7074);
    return false;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(7076);
    WebViewStubProxyUI.a(this.uZk).a(paramc);
    AppMethodBeat.o(7076);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(7077);
    ab.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
    this.uZk.uZe = WebViewStubProxyUI.ahK(paramString2);
    this.uZk.runOnUiThread(new WebViewStubProxyUI.5.1(this, paramString1, paramString2, paramBundle, paramBoolean));
    AppMethodBeat.o(7077);
    return false;
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(7086);
    WebViewStubProxyUI.a(this.uZk).af(paramBundle);
    AppMethodBeat.o(7086);
  }
  
  public final void ag(Bundle paramBundle)
  {
    AppMethodBeat.i(7091);
    WebViewStubProxyUI.a(this.uZk).ag(paramBundle);
    AppMethodBeat.o(7091);
  }
  
  public final void ahL(String paramString)
  {
    AppMethodBeat.i(7087);
    WebViewStubProxyUI.a(this.uZk).ahL(paramString);
    AppMethodBeat.o(7087);
  }
  
  public final IBinder asBinder()
  {
    return null;
  }
  
  public final String dcW()
  {
    AppMethodBeat.i(7078);
    String str = WebViewStubProxyUI.a(this.uZk).dcW();
    AppMethodBeat.o(7078);
    return str;
  }
  
  public final String dcX()
  {
    AppMethodBeat.i(7080);
    String str = WebViewStubProxyUI.a(this.uZk).dcX();
    AppMethodBeat.o(7080);
    return str;
  }
  
  public final int dcY()
  {
    AppMethodBeat.i(7081);
    int i = WebViewStubProxyUI.a(this.uZk).dcY();
    AppMethodBeat.o(7081);
    return i;
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(7085);
    WebViewStubProxyUI.a(this.uZk).dcZ();
    AppMethodBeat.o(7085);
  }
  
  public final void dda()
  {
    AppMethodBeat.i(7088);
    if (WebViewStubProxyUI.a(this.uZk) == null)
    {
      AppMethodBeat.o(7088);
      return;
    }
    WebViewStubProxyUI.a(this.uZk).dda();
    AppMethodBeat.o(7088);
  }
  
  public final Bundle dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7094);
    paramString1 = WebViewStubProxyUI.a(this.uZk).dm(paramString1, paramString2);
    AppMethodBeat.o(7094);
    return paramString1;
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7075);
    WebViewStubProxyUI.a(this.uZk).e(paramInt, paramBundle);
    AppMethodBeat.o(7075);
    return false;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(7079);
    String str = WebViewStubProxyUI.a(this.uZk).getCurrentUrl();
    AppMethodBeat.o(7079);
    return str;
  }
  
  public final void hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7089);
    WebViewStubProxyUI.a(this.uZk).hu(paramString1, paramString2);
    AppMethodBeat.o(7089);
  }
  
  public final void hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7093);
    WebViewStubProxyUI.a(this.uZk).hv(paramString1, paramString2);
    AppMethodBeat.o(7093);
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7090);
    paramBundle = WebViewStubProxyUI.a(this.uZk).i(paramInt, paramBundle);
    AppMethodBeat.o(7090);
    return paramBundle;
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(7082);
    WebViewStubProxyUI.a(this.uZk).om(paramBoolean);
    AppMethodBeat.o(7082);
  }
  
  public final void on(boolean paramBoolean)
  {
    AppMethodBeat.i(7083);
    WebViewStubProxyUI.a(this.uZk).on(paramBoolean);
    AppMethodBeat.o(7083);
  }
  
  public final void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(7092);
    WebViewStubProxyUI.a(this.uZk).oo(paramBoolean);
    AppMethodBeat.o(7092);
  }
  
  public final void t(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7084);
    WebViewStubProxyUI.a(this.uZk).t(paramInt, paramBundle);
    AppMethodBeat.o(7084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.5
 * JD-Core Version:    0.7.0.1
 */