package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class y$1
  implements View.OnClickListener
{
  y$1(y paramy, MenuItem paramMenuItem, y.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249513);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    y.a(this.adEy, this.mU, this.adEz);
    a.a(this, "com/tencent/mm/ui/MMActivityController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y.1
 * JD-Core Version:    0.7.0.1
 */