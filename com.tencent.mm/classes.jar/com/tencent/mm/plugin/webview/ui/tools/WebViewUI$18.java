package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;

final class WebViewUI$18
  implements View.OnTouchListener
{
  WebViewUI$18(WebViewUI paramWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7839);
    if ((this.vgz.vei != null) && (this.vgz.vei.getVisibility() == 0))
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this.vgz, 2131034186);
      localAnimation.setAnimationListener(new WebViewUI.18.1(this));
      this.vgz.vei.startAnimation(localAnimation);
      this.vgz.vei.setVisibility(8);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.vgz.pOd == null)
    {
      AppMethodBeat.o(7839);
      return false;
      if (!paramView.hasFocus()) {
        paramView.requestFocus();
      }
      if (paramMotionEvent.getAction() == 0)
      {
        this.vgz.jUm = ((int)paramMotionEvent.getRawX());
        this.vgz.jUn = ((int)paramMotionEvent.getRawY());
      }
    }
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261) || (paramMotionEvent.getAction() == 517))
    {
      if (paramMotionEvent.getPointerCount() <= 1) {
        break label251;
      }
      this.vgz.pOd.getSettings().setBuiltInZoomControls(true);
      this.vgz.pOd.getSettings().setSupportZoom(true);
    }
    for (;;)
    {
      AppMethodBeat.o(7839);
      return false;
      label251:
      this.vgz.pOd.getSettings().setBuiltInZoomControls(false);
      this.vgz.pOd.getSettings().setSupportZoom(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.18
 * JD-Core Version:    0.7.0.1
 */