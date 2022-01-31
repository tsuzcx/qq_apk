package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$57
  implements View.OnClickListener
{
  WebViewUI$57(WebViewUI paramWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.rpH.niQ != null)
    {
      this.rpH.niQ.goBack();
      WebViewUI.as(this.rpH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.57
 * JD-Core Version:    0.7.0.1
 */