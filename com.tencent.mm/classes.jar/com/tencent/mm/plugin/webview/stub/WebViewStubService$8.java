package com.tencent.mm.plugin.webview.stub;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewStubService$8
  implements w.a
{
  WebViewStubService$8(WebViewStubService paramWebViewStubService) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.WebViewStubService", "ServiceClick CGI return, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("MicroMsg.WebViewStubService", "ServiceClick CGI fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.8
 * JD-Core Version:    0.7.0.1
 */