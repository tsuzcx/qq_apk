package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewRedesignInputFooter$5
  implements TextWatcher
{
  WebViewRedesignInputFooter$5(WebViewRedesignInputFooter paramWebViewRedesignInputFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(298062);
    if (WebViewRedesignInputFooter.d(this.Xse).getText() == null)
    {
      AppMethodBeat.o(298062);
      return;
    }
    WebViewRedesignInputFooter.d(this.Xse).requestFocus();
    if ((paramEditable.length() > 0) && (paramEditable.toString().trim().length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      WebViewRedesignInputFooter.a(this.Xse, bool);
      AppMethodBeat.o(298062);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewRedesignInputFooter.5
 * JD-Core Version:    0.7.0.1
 */