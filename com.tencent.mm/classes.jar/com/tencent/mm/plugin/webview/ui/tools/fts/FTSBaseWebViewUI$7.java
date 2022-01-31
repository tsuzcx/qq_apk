package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$7
  implements Runnable
{
  FTSBaseWebViewUI$7(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    if (FTSBaseWebViewUI.a(this.rtV) != null) {
      FTSBaseWebViewUI.b(this.rtV).a(this.rtV.getTotalQuery(), this.rtV.getInEditTextQuery(), this.rtV.cfw(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */