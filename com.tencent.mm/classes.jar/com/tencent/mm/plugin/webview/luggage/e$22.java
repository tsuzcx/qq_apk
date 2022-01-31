package com.tencent.mm.plugin.webview.luggage;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;

final class e$22
  implements View.OnTouchListener
{
  e$22(e parame) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (e.b(this.rca).isShown()) {
      e.b(this.rca).hide();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.22
 * JD-Core Version:    0.7.0.1
 */