package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$3
  implements WebViewSmileyPanel.a
{
  WebViewInputFooter$3(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final void append(String paramString)
  {
    try
    {
      if (WebViewInputFooter.c(this.rDo))
      {
        WebViewInputFooter.j(this.rDo).xb(paramString);
        return;
      }
      this.rDo.rDk.aex(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
    }
  }
  
  public final void asj()
  {
    if ((WebViewInputFooter.c(this.rDo)) && (WebViewInputFooter.j(this.rDo) != null)) {
      WebViewInputFooter.j(this.rDo).xb("[DELETE_EMOTION]");
    }
    while (WebViewInputFooter.d(this.rDo) == null) {
      return;
    }
    MMEditText localMMEditText = WebViewInputFooter.d(this.rDo);
    if (localMMEditText.getInputConnection() != null)
    {
      localMMEditText.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      localMMEditText.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      return;
    }
    localMMEditText.dispatchKeyEvent(new KeyEvent(0, 67));
    localMMEditText.dispatchKeyEvent(new KeyEvent(1, 67));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.3
 * JD-Core Version:    0.7.0.1
 */