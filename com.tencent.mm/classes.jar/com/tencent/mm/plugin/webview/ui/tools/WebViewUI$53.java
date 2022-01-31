package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewUI$53
  implements View.OnApplyWindowInsetsListener
{
  WebViewUI$53(WebViewUI paramWebViewUI, ViewGroup paramViewGroup) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(7884);
    this.vgz.a(this.vgH, paramWindowInsets);
    WebViewUI.c(this.vgz);
    paramView = paramWindowInsets.consumeSystemWindowInsets();
    AppMethodBeat.o(7884);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.53
 * JD-Core Version:    0.7.0.1
 */