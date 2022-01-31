package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.text.Editable;
import android.text.TextWatcher;

final class WebViewSearchContentInputFooter$6
  implements TextWatcher
{
  WebViewSearchContentInputFooter$6(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (WebViewSearchContentInputFooter.c(this.rDc) != null)
    {
      WebViewSearchContentInputFooter.a locala = WebViewSearchContentInputFooter.c(this.rDc);
      WebViewSearchContentInputFooter localWebViewSearchContentInputFooter = this.rDc;
      if (paramCharSequence != null) {
        paramCharSequence.toString();
      }
      locala.a(localWebViewSearchContentInputFooter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.6
 * JD-Core Version:    0.7.0.1
 */