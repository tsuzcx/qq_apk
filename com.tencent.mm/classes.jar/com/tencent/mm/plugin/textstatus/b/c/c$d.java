package com.tencent.mm.plugin.textstatus.b.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$d
  implements View.OnClickListener
{
  c$d(i parami, com.tencent.mm.plugin.textstatus.g.c.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(237328);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = TextStatusSameTopicsActivity.MNZ;
    paramView = this.tDl.amk;
    p.j(paramView, "holder.itemView");
    paramView = paramView.getContext();
    p.j(paramView, "holder.itemView.context");
    TextStatusSameTopicsActivity.a.a(paramView, this.MAL.topicId, false, 0, "");
    a.a(this, "com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(237328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.c.d
 * JD-Core Version:    0.7.0.1
 */