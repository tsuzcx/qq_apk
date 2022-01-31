package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewInputFooter$2
  implements View.OnTouchListener
{
  WebViewInputFooter$2(WebViewInputFooter paramWebViewInputFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(10076);
    WebViewInputFooter.g(this.vtA);
    WebViewInputFooter.i(this.vtA).setVisibility(8);
    WebViewInputFooter.i(this.vtA);
    WebViewInputFooter.f(this.vtA).setImageResource(2130838345);
    WebViewInputFooter.a(this.vtA, 0);
    AppMethodBeat.o(10076);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.2
 * JD-Core Version:    0.7.0.1
 */