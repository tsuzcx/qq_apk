package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.Iterator;
import java.util.LinkedList;

final class HomeUI$22
  implements View.OnClickListener
{
  HomeUI$22(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(279534);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/HomeUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (SystemClock.elapsedRealtime() - HomeUI.C(this.VWJ) < 300L)
    {
      paramView = HomeUI.D(this.VWJ).iterator();
      while (paramView.hasNext()) {
        ((Runnable)paramView.next()).run();
      }
    }
    HomeUI.b(this.VWJ, SystemClock.elapsedRealtime());
    a.a(this, "com/tencent/mm/ui/HomeUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.22
 * JD-Core Version:    0.7.0.1
 */