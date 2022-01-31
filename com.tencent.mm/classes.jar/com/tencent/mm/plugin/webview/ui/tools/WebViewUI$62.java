package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;

final class WebViewUI$62
  implements View.OnClickListener
{
  WebViewUI$62(WebViewUI paramWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = AnimationUtils.loadAnimation(this.rpH, R.a.font_fade_out);
    paramView.setAnimationListener(new WebViewUI.62.1(this));
    WebViewUI.J(this.rpH).startAnimation(paramView);
    WebViewUI.J(this.rpH).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.62
 * JD-Core Version:    0.7.0.1
 */