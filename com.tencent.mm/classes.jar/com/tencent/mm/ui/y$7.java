package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class y$7
  implements View.OnClickListener
{
  y$7(y paramy, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141336);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (SystemClock.elapsedRealtime() - y.l(this.adEy) < 300L) {
      this.adEA.run();
    }
    y.a(this.adEy, SystemClock.elapsedRealtime());
    a.a(this, "com/tencent/mm/ui/MMActivityController$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(141336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.7
 * JD-Core Version:    0.7.0.1
 */