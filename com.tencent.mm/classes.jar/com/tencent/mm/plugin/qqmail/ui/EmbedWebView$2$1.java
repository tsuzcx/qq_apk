package com.tencent.mm.plugin.qqmail.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmbedWebView$2$1
  implements View.OnTouchListener
{
  EmbedWebView$2$1(EmbedWebView.2 param2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68278);
    if (paramMotionEvent.getPointerCount() == 2) {
      this.pMM.pML.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(68278);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView.2.1
 * JD-Core Version:    0.7.0.1
 */