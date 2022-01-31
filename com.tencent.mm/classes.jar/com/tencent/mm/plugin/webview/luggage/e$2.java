package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;

final class e$2
  implements WebViewInputFooter.b
{
  e$2(e parame) {}
  
  public final void dbh()
  {
    AppMethodBeat.i(153079);
    this.uRQ.JQ(0);
    AppMethodBeat.o(153079);
  }
  
  public final void dbi()
  {
    AppMethodBeat.i(153080);
    if ((e.c(this.uRQ) != null) && (e.c(this.uRQ).getKeyBoardHeight() > 0)) {
      this.uRQ.JQ(e.c(this.uRQ).getKeyBoardHeight());
    }
    AppMethodBeat.o(153080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.2
 * JD-Core Version:    0.7.0.1
 */