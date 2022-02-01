package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$16
  implements View.OnClickListener
{
  c$16(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(100224);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.AQE.eZ(paramView);
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(100224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.16
 * JD-Core Version:    0.7.0.1
 */