package com.tencent.mm.plugin.sns.ui.listener;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$11
  implements View.OnClickListener
{
  c$11(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(100218);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView.getTag();
    this.RQM.gt(paramView);
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(100218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.c.11
 * JD-Core Version:    0.7.0.1
 */