package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.effect.e;
import kotlin.g.a.m;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$a
  implements View.OnClickListener
{
  h$a(h paramh, int paramInt, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(227883);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.NuZ.yWH;
    if (paramView != null) {
      paramView.invoke(Integer.valueOf(this.jEN), this.Nva);
    }
    a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(227883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.h.a
 * JD-Core Version:    0.7.0.1
 */