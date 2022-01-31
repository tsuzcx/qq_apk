package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewSearchContentInputFooter$3
  implements View.OnClickListener
{
  WebViewSearchContentInputFooter$3(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(10060);
    if (WebViewSearchContentInputFooter.c(this.vto) != null) {
      WebViewSearchContentInputFooter.c(this.vto).dbl();
    }
    AppMethodBeat.o(10060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.3
 * JD-Core Version:    0.7.0.1
 */