package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$16
  implements WebView.FindListener
{
  WebViewUI$16(WebViewUI paramWebViewUI) {}
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(7836);
    if ((paramBoolean) && (!WebViewUI.e(this.vgz)) && (!bo.isNullOrNil(this.vgz.ves.getSearchContent())))
    {
      if (paramInt2 != 0) {
        break label83;
      }
      h.qsU.idkeyStat(480L, 3L, 1L, false);
    }
    for (;;)
    {
      WebViewUI.a(this.vgz, true);
      this.vgz.ves.t(paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(7836);
      return;
      label83:
      h.qsU.idkeyStat(480L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.16
 * JD-Core Version:    0.7.0.1
 */