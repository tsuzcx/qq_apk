package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$36
  implements View.OnClickListener
{
  c$36(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(100257);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.LpH.gB(paramView);
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(100257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.36
 * JD-Core Version:    0.7.0.1
 */