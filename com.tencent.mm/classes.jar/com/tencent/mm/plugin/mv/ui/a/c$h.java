package com.tencent.mm.plugin.mv.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$h
  implements View.OnClickListener
{
  c$h(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(226613);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initDeleteStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.tDl.amk.findViewById(b.e.FYi);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initDeleteStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(226613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.h
 * JD-Core Version:    0.7.0.1
 */