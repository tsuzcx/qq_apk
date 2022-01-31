package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.ui.MMActivity;

final class WebViewSearchContentInputFooter$5
  implements View.OnFocusChangeListener
{
  WebViewSearchContentInputFooter$5(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (WebViewSearchContentInputFooter.c(this.rDc) != null))
    {
      paramView = paramView.getContext();
      if ((paramView instanceof MMActivity)) {
        ((MMActivity)paramView).hideVKB(WebViewSearchContentInputFooter.d(this.rDc));
      }
    }
    WebViewSearchContentInputFooter.e(this.rDc).setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.5
 * JD-Core Version:    0.7.0.1
 */