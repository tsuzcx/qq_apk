package com.tencent.mm.plugin.sns.ui.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class c$21
  implements View.OnTouchListener
{
  c$21(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(220119);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$28", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    ae.d("MicroMsg.TimelineClickListener", "v " + paramView.getId() + "  ");
    this.AQE.fb(paramView);
    a.a(false, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$28", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(220119);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.21
 * JD-Core Version:    0.7.0.1
 */