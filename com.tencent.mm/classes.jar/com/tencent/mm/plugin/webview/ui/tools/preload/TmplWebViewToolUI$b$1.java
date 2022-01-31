package com.tencent.mm.plugin.webview.ui.tools.preload;

import com.tencent.mm.sdk.platformtools.y;

final class TmplWebViewToolUI$b$1
  implements Runnable
{
  TmplWebViewToolUI$b$1(TmplWebViewToolUI.b paramb) {}
  
  public final void run()
  {
    boolean bool = TmplWebViewToolUI.h(this.rBM.rBF).rBm;
    y.i("MicroMsg.WebviewUIForTmpl", "isInjectDataSuccess:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      this.rBM.rBJ.rjs = true;
      TmplWebViewToolUI.k(this.rBM.rBF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI.b.1
 * JD-Core Version:    0.7.0.1
 */