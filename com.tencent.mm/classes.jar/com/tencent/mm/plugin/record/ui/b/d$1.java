package com.tencent.mm.plugin.record.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$1
  implements View.OnTouchListener
{
  d$1(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(28033);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (paramMotionEvent.getAction() == 0)
    {
      this.xtg.nYw = ((int)paramMotionEvent.getRawX());
      this.xtg.nYx = ((int)paramMotionEvent.getRawY());
    }
    a.a(false, this, "com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(28033);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.1
 * JD-Core Version:    0.7.0.1
 */