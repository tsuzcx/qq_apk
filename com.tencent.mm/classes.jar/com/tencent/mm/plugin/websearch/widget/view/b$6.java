package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class b$6
  implements View.OnTouchListener
{
  b$6(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116708);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    this.DXi.DWX[0] = paramMotionEvent.getX();
    this.DXi.DWX[1] = paramMotionEvent.getY();
    a.a(false, this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(116708);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.6
 * JD-Core Version:    0.7.0.1
 */