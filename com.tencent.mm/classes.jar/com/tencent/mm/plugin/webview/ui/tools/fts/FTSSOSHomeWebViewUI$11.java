package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.concurrent.CountDownLatch;

final class FTSSOSHomeWebViewUI$11
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FTSSOSHomeWebViewUI$11(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(153295);
    if (FTSSOSHomeWebViewUI.b(this.vkS).getHeight() <= 0)
    {
      AppMethodBeat.o(153295);
      return;
    }
    FTSSOSHomeWebViewUI.c(this.vkS).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.vkS.vls.countDown();
    if ((this.vkS.vjy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
      FTSSOSHomeWebViewUI.b(this.vkS, ((RelativeLayout.LayoutParams)this.vkS.vjy.getLayoutParams()).topMargin);
    }
    if ((FTSSOSHomeWebViewUI.c(this.vkS).getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      FTSSOSHomeWebViewUI.c(this.vkS, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.c(this.vkS).getLayoutParams()).topMargin);
      if ((this.vkS.vlr) && (FTSSOSHomeWebViewUI.d(this.vkS).getTopView() != null) && ((FTSSOSHomeWebViewUI.e(this.vkS).getTopView() instanceof AbsoluteLayout)))
      {
        ((ViewGroup)FTSSOSHomeWebViewUI.c(this.vkS).getParent()).removeView(FTSSOSHomeWebViewUI.c(this.vkS));
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, FTSSOSHomeWebViewUI.f(this.vkS) - FTSSOSHomeWebViewUI.b(this.vkS).getHeight());
        ((AbsoluteLayout)FTSSOSHomeWebViewUI.g(this.vkS).getTopView()).addView(FTSSOSHomeWebViewUI.c(this.vkS), localLayoutParams);
      }
    }
    FTSSOSHomeWebViewUI.h(this.vkS);
    AppMethodBeat.o(153295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */