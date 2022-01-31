package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;

final class WebViewUI$6
  implements View.OnSystemUiVisibilityChangeListener
{
  WebViewUI$6(WebViewUI paramWebViewUI, View paramView) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    if (((paramInt & 0x4) == 0) && (this.rpH.rnA)) {
      WebViewUI.dr(this.rpT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.6
 * JD-Core Version:    0.7.0.1
 */