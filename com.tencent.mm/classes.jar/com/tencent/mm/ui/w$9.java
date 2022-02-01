package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class w$9
  implements View.OnClickListener
{
  w$9(w paramw, Runnable paramRunnable1, Runnable paramRunnable2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141338);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (SystemClock.elapsedRealtime() - w.l(this.Wad) < 300L) {
      if (this.Wag != null) {
        this.Wag.run();
      }
    }
    for (;;)
    {
      w.a(this.Wad, SystemClock.elapsedRealtime());
      a.a(this, "com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(141338);
      return;
      if (this.Wah != null) {
        this.Wah.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.w.9
 * JD-Core Version:    0.7.0.1
 */