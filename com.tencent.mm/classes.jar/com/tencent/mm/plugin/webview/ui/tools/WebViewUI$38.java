package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$38
  implements View.OnClickListener
{
  WebViewUI$38(WebViewUI paramWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7862);
    if (this.vgz.pOd != null) {
      this.vgz.pOd.reload();
    }
    AppMethodBeat.o(7862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.38
 * JD-Core Version:    0.7.0.1
 */