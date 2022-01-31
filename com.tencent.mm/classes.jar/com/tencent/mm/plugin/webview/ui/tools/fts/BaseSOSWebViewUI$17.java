package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSOSWebViewUI$17
  implements Runnable
{
  BaseSOSWebViewUI$17(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final void run()
  {
    if (BaseSOSWebViewUI.f(this.rtA) != null) {
      BaseSOSWebViewUI.g(this.rtA).a(this.rtA.getTotalQuery(), this.rtA.getInEditTextQuery(), this.rtA.cfw());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.17
 * JD-Core Version:    0.7.0.1
 */