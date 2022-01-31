package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

final class WebViewUI$37
  implements View.OnClickListener
{
  WebViewUI$37(WebViewUI paramWebViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7861);
    if (this.vgz.pOd != null)
    {
      this.vgz.vex = System.currentTimeMillis();
      this.vgz.pOd.goBack();
      WebViewUI.o(this.vgz);
    }
    AppMethodBeat.o(7861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.37
 * JD-Core Version:    0.7.0.1
 */