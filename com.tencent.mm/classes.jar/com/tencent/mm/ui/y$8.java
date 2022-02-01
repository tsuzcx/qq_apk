package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class y$8
  implements View.OnClickListener
{
  y$8(y paramy, Runnable paramRunnable1, Runnable paramRunnable2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141338);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (SystemClock.elapsedRealtime() - y.l(this.adEy) < 300L) {
      if (this.adEB != null) {
        this.adEB.run();
      }
    }
    for (;;)
    {
      y.a(this.adEy, SystemClock.elapsedRealtime());
      a.a(this, "com/tencent/mm/ui/MMActivityController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(141338);
      return;
      if (this.adEC != null) {
        this.adEC.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.8
 * JD-Core Version:    0.7.0.1
 */