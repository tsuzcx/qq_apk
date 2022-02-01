package com.tencent.mm.plugin.mv.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.mv.model.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$j
  implements View.OnClickListener
{
  c$j(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(225905);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initLocalPostStats$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = this.GfV.GfI.Gbi;
    if (paramView != null)
    {
      long l = ((Number)paramView).longValue();
      paramView = c.AnK;
      paramView = c.a.MS(l);
      if (paramView != null)
      {
        localObject = g.AAk;
        g.ecj().v(paramView);
      }
    }
    a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initLocalPostStats$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(225905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.j
 * JD-Core Version:    0.7.0.1
 */