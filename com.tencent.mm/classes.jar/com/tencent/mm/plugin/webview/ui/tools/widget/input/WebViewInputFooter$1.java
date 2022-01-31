package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

final class WebViewInputFooter$1
  implements View.OnClickListener
{
  WebViewInputFooter$1(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(10075);
    if (WebViewInputFooter.a(this.vtA) == 0)
    {
      WebViewInputFooter.b(this.vtA).hideVKB();
      if (!WebViewInputFooter.c(this.vtA)) {
        WebViewInputFooter.d(this.vtA).requestFocus();
      }
      WebViewInputFooter.e(this.vtA);
      WebViewInputFooter.f(this.vtA).setImageResource(2131231506);
      WebViewInputFooter.a(this.vtA, 1);
      WebViewInputFooter.g(this.vtA);
      AppMethodBeat.o(10075);
      return;
    }
    WebViewInputFooter.g(this.vtA);
    WebViewInputFooter.d(this.vtA).requestFocus();
    WebViewInputFooter.b(this.vtA).showVKB();
    WebViewInputFooter.h(this.vtA);
    WebViewInputFooter.a(this.vtA, 0);
    AppMethodBeat.o(10075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.1
 * JD-Core Version:    0.7.0.1
 */