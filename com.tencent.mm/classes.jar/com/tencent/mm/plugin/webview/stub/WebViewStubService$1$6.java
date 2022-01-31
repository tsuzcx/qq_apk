package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewStubService$1$6
  implements a.a
{
  WebViewStubService$1$6(WebViewStubService.1 param1) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    y.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    c.Ob().c(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1.6
 * JD-Core Version:    0.7.0.1
 */