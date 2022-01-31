package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

final class WebViewUI$70
  implements View.OnApplyWindowInsetsListener
{
  WebViewUI$70(WebViewUI paramWebViewUI, ViewGroup paramViewGroup) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    this.rpH.a(this.kYb, paramWindowInsets);
    WebViewUI.E(this.rpH);
    return paramWindowInsets.consumeSystemWindowInsets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.70
 * JD-Core Version:    0.7.0.1
 */