package com.tencent.mm.plugin.webview.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewStubService$1$6$1
  implements b.a
{
  WebViewStubService$1$6$1(WebViewStubService.1.6 param6) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(7110);
    ab.i("MicroMsg.WebViewStubService", "onGetLocation %b %f|%f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    d.agQ().c(this);
    AppMethodBeat.o(7110);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1.6.1
 * JD-Core Version:    0.7.0.1
 */