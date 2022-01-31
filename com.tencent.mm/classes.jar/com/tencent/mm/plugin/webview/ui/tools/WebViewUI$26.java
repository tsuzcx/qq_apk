package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.c;

final class WebViewUI$26
  implements h.c
{
  WebViewUI$26(WebViewUI paramWebViewUI, String paramString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(153239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(153239);
      return;
      if (!WebViewUI.c(this.vgz, this.val$url))
      {
        ab.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + this.val$url);
        WebViewUI.k(this.vgz);
        AppMethodBeat.o(153239);
        return;
      }
      this.vgz.loadUrl(this.val$url);
      AppMethodBeat.o(153239);
      return;
      this.vgz.getApplicationContext();
      a.b(this.val$url, this.val$url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.26
 * JD-Core Version:    0.7.0.1
 */