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
    AppMethodBeat.i(249430);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/HomeUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (SystemClock.elapsedRealtime() - HomeUI.C(this.adBf) < 300L)
    {
      paramView = HomeUI.D(this.adBf).iterator();
      while (paramView.hasNext()) {
        ((Runnable)paramView.next()).run();
      }
    }
    HomeUI.b(this.adBf, SystemClock.elapsedRealtime());
    a.a(this, "com/tencent/mm/ui/HomeUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.22
 * JD-Core Version:    0.7.0.1
 */