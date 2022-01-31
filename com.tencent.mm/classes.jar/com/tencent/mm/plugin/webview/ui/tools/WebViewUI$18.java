package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;

final class WebViewUI$18
  implements View.OnTouchListener
{
  WebViewUI$18(WebViewUI paramWebViewUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((WebViewUI.J(this.rpH) != null) && (WebViewUI.J(this.rpH).getVisibility() == 0))
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this.rpH, R.a.font_fade_out);
      localAnimation.setAnimationListener(new WebViewUI.18.1(this));
      WebViewUI.J(this.rpH).startAnimation(localAnimation);
      WebViewUI.J(this.rpH).setVisibility(8);
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      if (this.rpH.niQ != null) {
        break;
      }
    }
    while ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 5) && (paramMotionEvent.getAction() != 5) && (paramMotionEvent.getAction() != 261) && (paramMotionEvent.getAction() != 517))
    {
      return false;
      if (!paramView.hasFocus()) {
        paramView.requestFocus();
      }
      if (paramMotionEvent.getAction() != 0) {
        break;
      }
      WebViewUI.d(this.rpH, (int)paramMotionEvent.getRawX());
      WebViewUI.e(this.rpH, (int)paramMotionEvent.getRawY());
      break;
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.rpH.niQ.getSettings().setBuiltInZoomControls(true);
      this.rpH.niQ.getSettings().setSupportZoom(true);
      return false;
    }
    this.rpH.niQ.getSettings().setBuiltInZoomControls(false);
    this.rpH.niQ.getSettings().setSupportZoom(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.18
 * JD-Core Version:    0.7.0.1
 */