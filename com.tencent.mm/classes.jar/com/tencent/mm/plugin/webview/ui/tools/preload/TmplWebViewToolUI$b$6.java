package com.tencent.mm.plugin.webview.ui.tools.preload;

import com.tencent.xweb.p;

final class TmplWebViewToolUI$b$6
  implements Runnable
{
  TmplWebViewToolUI$b$6(TmplWebViewToolUI.b paramb) {}
  
  public final void run()
  {
    TmplWebViewToolUI.p(this.rBM.rBF);
    TmplWebViewToolUI.h(this.rBM.rBF).getCurWebviewClient().a(TmplWebViewToolUI.h(this.rBM.rBF), TmplWebViewToolUI.h(this.rBM.rBF).getUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI.b.6
 * JD-Core Version:    0.7.0.1
 */