package com.tencent.mm.plugin.webview.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewStubService$2
  implements w.a
{
  WebViewStubService$2(WebViewStubService paramWebViewStubService) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(155682);
    ab.i("MicroMsg.WebViewStubService", "ServiceClick CGI return, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.WebViewStubService", "ServiceClick CGI fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(155682);
      return 0;
    }
    AppMethodBeat.o(155682);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.2
 * JD-Core Version:    0.7.0.1
 */