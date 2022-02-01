package com.tencent.mm.plugin.textstatus.e;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$k
  implements View.OnClickListener
{
  c$k(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(238108);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.MCD.glE();
    a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$update$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(238108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.c.k
 * JD-Core Version:    0.7.0.1
 */