package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class FTSSOSHomeWebViewUI$14
  implements ViewTreeObserver.OnPreDrawListener
{
  FTSSOSHomeWebViewUI$14(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final boolean onPreDraw()
  {
    this.ruD.rts.getViewTreeObserver().removeOnPreDrawListener(this);
    FTSSOSHomeWebViewUI.a(this.ruD, this.ruD.rts.getX());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.14
 * JD-Core Version:    0.7.0.1
 */