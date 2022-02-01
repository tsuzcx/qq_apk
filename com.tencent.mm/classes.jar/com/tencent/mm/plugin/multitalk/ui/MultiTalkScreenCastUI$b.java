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
final class MultiTalkScreenCastUI$b
  implements View.OnClickListener
{
  public static final b FvD;
  
  static
  {
    AppMethodBeat.i(205482);
    FvD = new b();
    AppMethodBeat.o(205482);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205480);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = ad.eYc();
    p.j(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
    paramView.eXm();
    t.Xy(102);
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI.b
 * JD-Core Version:    0.7.0.1
 */