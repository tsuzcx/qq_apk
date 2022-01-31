package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class WebViewSearchContentInputFooter$7
  implements Runnable
{
  WebViewSearchContentInputFooter$7(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(10064);
    MMActivity.showVKB((Activity)this.vto.getContext());
    AppMethodBeat.o(10064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.7
 * JD-Core Version:    0.7.0.1
 */