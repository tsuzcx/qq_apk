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
final class MultiTalkScreenCastUI$d
  implements View.OnClickListener
{
  MultiTalkScreenCastUI$d(MultiTalkScreenCastUI paramMultiTalkScreenCastUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207053);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = ad.eYc();
    p.j(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
    paramView.eXm();
    t.Xy(102);
    this.FvC.finish();
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(207053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI.d
 * JD-Core Version:    0.7.0.1
 */