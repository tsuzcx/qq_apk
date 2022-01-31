package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewStubProxyUI$5
  implements e
{
  WebViewStubProxyUI$5(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final boolean Cl(int paramInt)
  {
    WebViewStubProxyUI.a(this.rjS).Cl(paramInt);
    return false;
  }
  
  public final void N(Bundle paramBundle)
  {
    WebViewStubProxyUI.a(this.rjS).N(paramBundle);
  }
  
  public final void O(Bundle paramBundle)
  {
    WebViewStubProxyUI.a(this.rjS).O(paramBundle);
  }
  
  public final void SJ(String paramString)
  {
    WebViewStubProxyUI.a(this.rjS).SJ(paramString);
  }
  
  public final boolean a(c paramc)
  {
    WebViewStubProxyUI.a(this.rjS).a(paramc);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    y.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
    this.rjS.rjL = WebViewStubProxyUI.SI(paramString2);
    this.rjS.runOnUiThread(new WebViewStubProxyUI.5.1(this, paramString1, paramString2, paramBundle, paramBoolean));
    return false;
  }
  
  public final IBinder asBinder()
  {
    return null;
  }
  
  public final boolean b(int paramInt, Bundle paramBundle)
  {
    WebViewStubProxyUI.a(this.rjS).b(paramInt, paramBundle);
    return false;
  }
  
  public final String cdb()
  {
    return WebViewStubProxyUI.a(this.rjS).cdb();
  }
  
  public final String cdc()
  {
    return WebViewStubProxyUI.a(this.rjS).cdc();
  }
  
  public final int cdd()
  {
    return WebViewStubProxyUI.a(this.rjS).cdd();
  }
  
  public final void cde()
  {
    WebViewStubProxyUI.a(this.rjS).cde();
  }
  
  public final void cdf()
  {
    if (WebViewStubProxyUI.a(this.rjS) == null) {
      return;
    }
    WebViewStubProxyUI.a(this.rjS).cdf();
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final Bundle f(int paramInt, Bundle paramBundle)
  {
    return WebViewStubProxyUI.a(this.rjS).f(paramInt, paramBundle);
  }
  
  public final void fx(String paramString1, String paramString2)
  {
    WebViewStubProxyUI.a(this.rjS).fx(paramString1, paramString2);
  }
  
  public final void fy(String paramString1, String paramString2)
  {
    WebViewStubProxyUI.a(this.rjS).fy(paramString1, paramString2);
  }
  
  public final String getCurrentUrl()
  {
    return WebViewStubProxyUI.a(this.rjS).getCurrentUrl();
  }
  
  public final void le(boolean paramBoolean)
  {
    WebViewStubProxyUI.a(this.rjS).le(paramBoolean);
  }
  
  public final void lf(boolean paramBoolean)
  {
    WebViewStubProxyUI.a(this.rjS).lf(paramBoolean);
  }
  
  public final void lg(boolean paramBoolean)
  {
    WebViewStubProxyUI.a(this.rjS).lg(paramBoolean);
  }
  
  public final void p(int paramInt, Bundle paramBundle)
  {
    WebViewStubProxyUI.a(this.rjS).p(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.5
 * JD-Core Version:    0.7.0.1
 */