package com.tencent.mm.plugin.multitalk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.t;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MultiTalkScreenCastUI$c
  implements View.OnClickListener
{
  public static final c FvE;
  
  static
  {
    AppMethodBeat.i(195956);
    FvE = new c();
    AppMethodBeat.o(195956);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195954);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = ad.eYc();
    p.j(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
    paramView.eXm();
    t.Xy(103);
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(195954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI.c
 * JD-Core Version:    0.7.0.1
 */