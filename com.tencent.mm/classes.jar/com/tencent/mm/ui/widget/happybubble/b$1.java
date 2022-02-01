package com.tencent.mm.ui.widget.happybubble;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnTouchListener
{
  b$1(b paramb, WindowManager.LayoutParams paramLayoutParams, int paramInt) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143525);
    if (b.a(this.JgH))
    {
      if (this.JgF.x < 0) {}
      for (float f1 = 0.0F;; f1 = this.JgF.x)
      {
        float f2 = f1;
        if (paramView.getWidth() + f1 > this.JgG) {
          f2 = this.JgG - paramView.getWidth();
        }
        paramMotionEvent.setLocation(f2 + paramMotionEvent.getX(), this.JgF.y + paramMotionEvent.getY());
        b.b(this.JgH).getWindow().getDecorView().dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143525);
        return true;
      }
    }
    AppMethodBeat.o(143525);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b.1
 * JD-Core Version:    0.7.0.1
 */