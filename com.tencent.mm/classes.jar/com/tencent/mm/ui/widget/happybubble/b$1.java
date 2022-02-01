package com.tencent.mm.ui.widget.happybubble;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class b$1
  implements View.OnTouchListener
{
  b$1(b paramb, WindowManager.LayoutParams paramLayoutParams, int paramInt) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143525);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/widget/happybubble/BubbleDialog$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if (b.a(this.Lut))
    {
      if (this.Lur.x < 0) {}
      for (float f1 = 0.0F;; f1 = this.Lur.x)
      {
        float f2 = f1;
        if (paramView.getWidth() + f1 > this.Lus) {
          f2 = this.Lus - paramView.getWidth();
        }
        paramMotionEvent.setLocation(f2 + paramMotionEvent.getX(), this.Lur.y + paramMotionEvent.getY());
        b.b(this.Lut).getWindow().getDecorView().dispatchTouchEvent(paramMotionEvent);
        a.a(true, this, "com/tencent/mm/ui/widget/happybubble/BubbleDialog$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143525);
        return true;
      }
    }
    a.a(false, this, "com/tencent/mm/ui/widget/happybubble/BubbleDialog$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(143525);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b.1
 * JD-Core Version:    0.7.0.1
 */