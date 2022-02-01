package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.48;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class FTSSOSHomeWebViewUI$b$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$b$a$1(FTSSOSHomeWebViewUI.b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(80635);
    h localh = this.JoD.JoC.Jos.getJsapi();
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, not ready");
      AppMethodBeat.o(80635);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onFocusSearchInput success, ready");
    MMHandlerThread.postToMainThread(new h.48(localh, n.a.b("onFocusSearchInput", null, localh.IRj, localh.zpY)));
    AppMethodBeat.o(80635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.b.a.1
 * JD-Core Version:    0.7.0.1
 */