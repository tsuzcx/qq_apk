package com.tencent.mm.plugin.webview.luggage;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;

final class e$4
  implements WebView.FindListener
{
  e$4(e parame) {}
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(153086);
    e.d(this.uRQ).t(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(153086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.4
 * JD-Core Version:    0.7.0.1
 */