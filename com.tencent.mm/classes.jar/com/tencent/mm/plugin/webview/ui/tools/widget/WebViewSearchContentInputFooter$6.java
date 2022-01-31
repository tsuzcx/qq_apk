package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewSearchContentInputFooter$6
  implements TextWatcher
{
  WebViewSearchContentInputFooter$6(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(10063);
    if (WebViewSearchContentInputFooter.c(this.vto) != null)
    {
      WebViewSearchContentInputFooter.a locala = WebViewSearchContentInputFooter.c(this.vto);
      WebViewSearchContentInputFooter localWebViewSearchContentInputFooter = this.vto;
      if (paramCharSequence != null) {
        paramCharSequence.toString();
      }
      locala.a(localWebViewSearchContentInputFooter);
    }
    AppMethodBeat.o(10063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.6
 * JD-Core Version:    0.7.0.1
 */