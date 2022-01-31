package com.tencent.mm.plugin.webview.luggage;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;

final class e$19
  implements View.OnTouchListener
{
  e$19(e parame) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(6042);
    if (e.b(this.uRQ).isShown()) {
      e.b(this.uRQ).hide();
    }
    AppMethodBeat.o(6042);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.19
 * JD-Core Version:    0.7.0.1
 */