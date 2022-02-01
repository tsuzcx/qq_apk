package com.tencent.mm.plugin.multitalk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.t;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MultiTalkScreenCastUI$d
  implements View.OnClickListener
{
  MultiTalkScreenCastUI$d(MultiTalkScreenCastUI paramMultiTalkScreenCastUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(239717);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = ac.eom();
    p.g(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
    paramView.enw();
    t.Rk(102);
    this.zPZ.finish();
    a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(239717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkScreenCastUI.d
 * JD-Core Version:    0.7.0.1
 */