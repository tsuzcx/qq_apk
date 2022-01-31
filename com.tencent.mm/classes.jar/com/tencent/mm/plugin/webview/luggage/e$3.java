package com.tencent.mm.plugin.webview.luggage;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;

final class e$3
  implements WebViewSearchContentInputFooter.a
{
  e$3(e parame) {}
  
  public final void a(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    AppMethodBeat.i(153082);
    if (paramWebViewSearchContentInputFooter.getVisibility() == 0) {
      b(paramWebViewSearchContentInputFooter);
    }
    AppMethodBeat.o(153082);
  }
  
  public final void b(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    AppMethodBeat.i(153085);
    this.uRQ.uRk.clearMatches();
    paramWebViewSearchContentInputFooter.reset();
    e.d(this.uRQ).t(0, 0, true);
    this.uRQ.uRk.findAllAsync(paramWebViewSearchContentInputFooter.getSearchContent());
    AppMethodBeat.o(153085);
  }
  
  public final boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final void dbj()
  {
    AppMethodBeat.i(153081);
    e.a(this.uRQ, 0);
    this.uRQ.uRk.clearMatches();
    e.d(this.uRQ).dgZ();
    AppMethodBeat.o(153081);
  }
  
  public final void dbk()
  {
    AppMethodBeat.i(153083);
    this.uRQ.uRk.findNext(false);
    AppMethodBeat.o(153083);
  }
  
  public final void dbl()
  {
    AppMethodBeat.i(153084);
    this.uRQ.uRk.findNext(true);
    AppMethodBeat.o(153084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.3
 * JD-Core Version:    0.7.0.1
 */