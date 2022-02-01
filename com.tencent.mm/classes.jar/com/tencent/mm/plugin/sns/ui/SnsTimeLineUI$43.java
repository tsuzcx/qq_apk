package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsTimeLineUI$43
  implements View.OnLongClickListener
{
  SnsTimeLineUI$43(SnsTimeLineUI paramSnsTimeLineUI)
  {
    AppMethodBeat.i(179254);
    AppMethodBeat.o(179254);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(308281);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    boolean bool = SnsTimeLineUI.M(this.RAo);
    a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(308281);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.43
 * JD-Core Version:    0.7.0.1
 */