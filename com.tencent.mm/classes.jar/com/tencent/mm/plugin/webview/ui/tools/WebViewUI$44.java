package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewUI$44
  implements View.OnClickListener
{
  WebViewUI$44(WebViewUI paramWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153258);
    paramView = AnimationUtils.loadAnimation(this.vgz, 2131034186);
    paramView.setAnimationListener(new WebViewUI.44.1(this));
    this.vgz.vei.startAnimation(paramView);
    this.vgz.vei.setVisibility(8);
    AppMethodBeat.o(153258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.44
 * JD-Core Version:    0.7.0.1
 */