package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$5
  implements TextWatcher
{
  WebViewInputFooter$5(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(10082);
    if (WebViewInputFooter.d(this.vtA).getText() == null)
    {
      AppMethodBeat.o(10082);
      return;
    }
    WebViewInputFooter.d(this.vtA).requestFocus();
    if ((paramEditable.length() > 0) && (paramEditable.toString().trim().length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      WebViewInputFooter.a(this.vtA, bool);
      AppMethodBeat.o(10082);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.5
 * JD-Core Version:    0.7.0.1
 */