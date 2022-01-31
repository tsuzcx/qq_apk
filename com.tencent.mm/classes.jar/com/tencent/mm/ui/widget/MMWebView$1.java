package com.tencent.mm.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMWebView$1
  implements View.OnTouchListener
{
  MMWebView$1(MMWebView paramMMWebView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107934);
    if (this.AEg.getIsX5Kernel())
    {
      int i = paramMotionEvent.getAction();
      if (MMWebView.d(this.AEg) != null) {
        switch (i & 0xFF)
        {
        default: 
          MMWebView.d(this.AEg).requestDisallowInterceptTouchEvent(true);
        }
      }
      while (MMWebView.e(this.AEg) != null)
      {
        boolean bool = MMWebView.e(this.AEg).onTouch(paramView, paramMotionEvent);
        AppMethodBeat.o(107934);
        return bool;
        MMWebView.d(this.AEg).requestDisallowInterceptTouchEvent(true);
        continue;
        MMWebView.d(this.AEg).requestDisallowInterceptTouchEvent(false);
      }
    }
    AppMethodBeat.o(107934);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMWebView.1
 * JD-Core Version:    0.7.0.1
 */