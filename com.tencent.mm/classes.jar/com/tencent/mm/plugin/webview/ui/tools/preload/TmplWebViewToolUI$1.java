package com.tencent.mm.plugin.webview.ui.tools.preload;

import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.sdk.platformtools.y;

final class TmplWebViewToolUI$1
  implements Runnable
{
  TmplWebViewToolUI$1(TmplWebViewToolUI paramTmplWebViewToolUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.WebviewUIForTmpl", "forceUseOriWebViewUI() isA8KeyDone:%b", new Object[] { Boolean.valueOf(TmplWebViewToolUI.a(this.rBF)) });
    if (!(TmplWebViewToolUI.b(this.rBF) instanceof a.a))
    {
      a.aa(TmplWebViewToolUI.c(this.rBF).rjC, 137, 1);
      TmplWebViewToolUI.a(this.rBF, new a.a());
      if (TmplWebViewToolUI.a(this.rBF))
      {
        y.i("MicroMsg.WebviewUIForTmpl", "forceUseOriWebViewUI()");
        if (TmplWebViewToolUI.d(this.rBF) != null)
        {
          TmplWebViewToolUI.e(this.rBF).rvc = false;
          TmplWebViewToolUI.a(this.rBF, new a.a());
        }
        if (TmplWebViewToolUI.f(this.rBF) == null) {
          break label157;
        }
        TmplWebViewToolUI.h(this.rBF).loadUrl(TmplWebViewToolUI.g(this.rBF), TmplWebViewToolUI.f(this.rBF));
      }
    }
    return;
    label157:
    TmplWebViewToolUI.h(this.rBF).loadUrl(TmplWebViewToolUI.g(this.rBF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI.1
 * JD-Core Version:    0.7.0.1
 */