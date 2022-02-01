package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class j$7
  implements View.OnClickListener
{
  j$7(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251824);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.agfU.cyW();
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.j.7
 * JD-Core Version:    0.7.0.1
 */