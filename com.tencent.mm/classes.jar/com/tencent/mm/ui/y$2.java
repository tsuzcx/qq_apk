package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class y$2
  implements View.OnLongClickListener
{
  y$2(y paramy, y.a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(249505);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    boolean bool = y.a(this.adEy, paramView, this.adEz);
    a.a(bool, this, "com/tencent/mm/ui/MMActivityController$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(249505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y.2
 * JD-Core Version:    0.7.0.1
 */