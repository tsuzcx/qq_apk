package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.concurrent.CountDownLatch;

final class FTSSOSHomeWebViewUI$11
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FTSSOSHomeWebViewUI$11(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onGlobalLayout()
  {
    if (FTSSOSHomeWebViewUI.b(this.ruD).getHeight() <= 0) {
      return;
    }
    FTSSOSHomeWebViewUI.c(this.ruD).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.ruD.rvd.countDown();
    if ((this.ruD.rts.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
      FTSSOSHomeWebViewUI.b(this.ruD, ((RelativeLayout.LayoutParams)this.ruD.rts.getLayoutParams()).topMargin);
    }
    if ((FTSSOSHomeWebViewUI.c(this.ruD).getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      FTSSOSHomeWebViewUI.c(this.ruD, ((RelativeLayout.LayoutParams)FTSSOSHomeWebViewUI.c(this.ruD).getLayoutParams()).topMargin);
      if ((this.ruD.rvc) && (FTSSOSHomeWebViewUI.d(this.ruD).getTopView() != null) && ((FTSSOSHomeWebViewUI.e(this.ruD).getTopView() instanceof AbsoluteLayout)))
      {
        ((ViewGroup)FTSSOSHomeWebViewUI.c(this.ruD).getParent()).removeView(FTSSOSHomeWebViewUI.c(this.ruD));
        AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, FTSSOSHomeWebViewUI.f(this.ruD) - FTSSOSHomeWebViewUI.b(this.ruD).getHeight());
        ((AbsoluteLayout)FTSSOSHomeWebViewUI.g(this.ruD).getTopView()).addView(FTSSOSHomeWebViewUI.c(this.ruD), localLayoutParams);
      }
    }
    FTSSOSHomeWebViewUI.h(this.ruD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */