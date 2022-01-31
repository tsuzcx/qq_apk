package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewSearchContentInputFooter$2
  implements View.OnClickListener
{
  WebViewSearchContentInputFooter$2(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(10059);
    if (WebViewSearchContentInputFooter.c(this.vto) != null) {
      WebViewSearchContentInputFooter.c(this.vto).dbk();
    }
    AppMethodBeat.o(10059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.2
 * JD-Core Version:    0.7.0.1
 */