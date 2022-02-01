package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class i$b
  implements View.OnClickListener
{
  i$b(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(237499);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    p.j(paramView, "it");
    if (paramView.getId() == b.e.MwH) {
      this.MKL.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(237499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.i.b
 * JD-Core Version:    0.7.0.1
 */