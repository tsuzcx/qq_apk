package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class WebViewSearchContentInputFooter$4
  implements View.OnKeyListener
{
  WebViewSearchContentInputFooter$4(WebViewSearchContentInputFooter paramWebViewSearchContentInputFooter) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(10061);
    if (WebViewSearchContentInputFooter.c(this.vto) != null) {
      WebViewSearchContentInputFooter.c(this.vto).c(paramInt, paramKeyEvent);
    }
    if ((paramInt == 66) && (WebViewSearchContentInputFooter.c(this.vto) != null))
    {
      paramView = paramView.getContext();
      if ((paramView instanceof MMActivity)) {
        ((MMActivity)paramView).hideVKB(WebViewSearchContentInputFooter.d(this.vto));
      }
      WebViewSearchContentInputFooter.c(this.vto).b(this.vto);
      AppMethodBeat.o(10061);
      return true;
    }
    AppMethodBeat.o(10061);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.4
 * JD-Core Version:    0.7.0.1
 */