package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class v$1
  implements View.OnClickListener
{
  v$1(v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(308219);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    v.b(this.RcS);
    a.a(this, "com/tencent/mm/plugin/sns/ui/FinderMediaWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v.1
 * JD-Core Version:    0.7.0.1
 */