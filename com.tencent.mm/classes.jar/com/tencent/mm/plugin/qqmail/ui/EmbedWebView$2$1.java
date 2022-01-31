package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class EmbedWebView$2$1
  implements View.OnTouchListener
{
  EmbedWebView$2$1(EmbedWebView.2 param2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2) {
      this.nhz.nhy.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView.2.1
 * JD-Core Version:    0.7.0.1
 */