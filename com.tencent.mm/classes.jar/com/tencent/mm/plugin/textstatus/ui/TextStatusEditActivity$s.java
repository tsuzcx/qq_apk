package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.g.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$s
  implements View.OnClickListener
{
  TextStatusEditActivity$s(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(258451);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    TextStatusEditActivity.j(this.GeQ).onClick(paramView);
    paramView = SecDataUIC.CWq;
    paramView = this.GeQ.getContext();
    p.g(paramView, "context");
    paramView = (z)SecDataUIC.a.a((Context)paramView, 8, z.class);
    if (paramView != null) {
      paramView.Usv = (1L + paramView.Usv);
    }
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(258451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.s
 * JD-Core Version:    0.7.0.1
 */