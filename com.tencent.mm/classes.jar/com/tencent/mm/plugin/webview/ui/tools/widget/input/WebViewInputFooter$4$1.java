package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.widget.Toast;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$4$1
  implements c.a
{
  WebViewInputFooter$4$1(WebViewInputFooter.4 param4) {}
  
  public final void eP(String paramString)
  {
    if (WebViewInputFooter.k(this.rDp.rDo) != null) {
      WebViewInputFooter.k(this.rDp.rDo).RJ(WebViewInputFooter.d(this.rDp.rDo).getText().toString());
    }
    paramString = this.rDp.rDo;
    paramString.rDk.clearComposingText();
    paramString.rDk.setText("");
  }
  
  public final void xB() {}
  
  public final void xC()
  {
    if (WebViewInputFooter.b(this.rDp.rDo) != null) {
      Toast.makeText(WebViewInputFooter.b(this.rDp.rDo), "exceed max-length", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.4.1
 * JD-Core Version:    0.7.0.1
 */