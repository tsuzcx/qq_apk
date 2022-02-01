package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$a
  implements View.OnClickListener
{
  public static final a Lmx;
  
  static
  {
    AppMethodBeat.i(197649);
    Lmx = new a();
    AppMethodBeat.o(197649);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197646);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = (com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class);
    p.j(paramView, "it");
    ((com.tencent.mm.plugin.festival.a.a)localObject).fp(paramView.getContext());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(197646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c.a
 * JD-Core Version:    0.7.0.1
 */