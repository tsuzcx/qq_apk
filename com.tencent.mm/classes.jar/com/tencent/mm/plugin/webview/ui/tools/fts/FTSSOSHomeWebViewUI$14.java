package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSSOSHomeWebViewUI$14
  implements ViewTreeObserver.OnPreDrawListener
{
  FTSSOSHomeWebViewUI$14(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(153298);
    this.vkS.vjy.getViewTreeObserver().removeOnPreDrawListener(this);
    FTSSOSHomeWebViewUI.a(this.vkS, this.vkS.vjy.getX());
    AppMethodBeat.o(153298);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.14
 * JD-Core Version:    0.7.0.1
 */