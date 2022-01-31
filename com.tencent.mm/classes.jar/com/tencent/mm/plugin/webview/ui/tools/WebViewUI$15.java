package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$15
  implements WebViewSearchContentInputFooter.a
{
  WebViewUI$15(WebViewUI paramWebViewUI) {}
  
  public final void a(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    AppMethodBeat.i(7831);
    if (paramWebViewSearchContentInputFooter.getVisibility() == 0) {
      b(paramWebViewSearchContentInputFooter);
    }
    AppMethodBeat.o(7831);
  }
  
  public final void b(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter)
  {
    AppMethodBeat.i(7834);
    this.vgz.pOd.clearMatches();
    paramWebViewSearchContentInputFooter.reset();
    this.vgz.ves.t(0, 0, true);
    WebViewUI.a(this.vgz, false);
    this.vgz.pOd.findAllAsync(paramWebViewSearchContentInputFooter.getSearchContent());
    AppMethodBeat.o(7834);
  }
  
  public final boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7835);
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      h.qsU.idkeyStat(480L, 6L, 1L, false);
    }
    AppMethodBeat.o(7835);
    return false;
  }
  
  public final void dbj()
  {
    AppMethodBeat.i(7830);
    WebViewUI.b(this.vgz, 0);
    this.vgz.pOd.clearMatches();
    this.vgz.ves.dgZ();
    AppMethodBeat.o(7830);
  }
  
  public final void dbk()
  {
    AppMethodBeat.i(7832);
    h.qsU.idkeyStat(480L, 5L, 1L, false);
    this.vgz.pOd.findNext(false);
    AppMethodBeat.o(7832);
  }
  
  public final void dbl()
  {
    AppMethodBeat.i(7833);
    h.qsU.idkeyStat(480L, 4L, 1L, false);
    this.vgz.pOd.findNext(true);
    AppMethodBeat.o(7833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.15
 * JD-Core Version:    0.7.0.1
 */