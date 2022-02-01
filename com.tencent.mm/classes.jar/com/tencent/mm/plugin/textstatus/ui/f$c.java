package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.t;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class f$c
  implements View.OnClickListener
{
  f$c(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(234667);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$addStatusListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (t.gle())
    {
      paramView = this.MKh.MJK;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
    }
    f.a(this.MKh);
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/MoreTabCardView$addStatusListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(234667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.f.c
 * JD-Core Version:    0.7.0.1
 */