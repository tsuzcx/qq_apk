package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$3
  implements WebViewSmileyPanel.a
{
  WebViewInputFooter$3(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(10078);
    if ((WebViewInputFooter.c(this.vtA)) && (WebViewInputFooter.j(this.vtA) != null))
    {
      WebViewInputFooter.j(this.vtA).FO("[DELETE_EMOTION]");
      AppMethodBeat.o(10078);
      return;
    }
    if (WebViewInputFooter.d(this.vtA) != null)
    {
      MMEditText localMMEditText = WebViewInputFooter.d(this.vtA);
      if (localMMEditText.getInputConnection() != null)
      {
        localMMEditText.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        localMMEditText.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(10078);
        return;
      }
      localMMEditText.dispatchKeyEvent(new KeyEvent(0, 67));
      localMMEditText.dispatchKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(10078);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(10077);
    try
    {
      if (WebViewInputFooter.c(this.vtA))
      {
        WebViewInputFooter.j(this.vtA).FO(paramString);
        AppMethodBeat.o(10077);
        return;
      }
      this.vtA.vtw.avk(paramString);
      AppMethodBeat.o(10077);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[] { paramString });
      AppMethodBeat.o(10077);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.3
 * JD-Core Version:    0.7.0.1
 */