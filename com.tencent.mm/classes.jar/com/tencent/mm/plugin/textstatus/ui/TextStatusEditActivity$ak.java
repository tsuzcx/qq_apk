package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.proto.am;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$ak
  implements View.OnClickListener
{
  TextStatusEditActivity$ak(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232506);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    TextStatusEditActivity.b(this.MMz).onClick(paramView);
    paramView = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramView = this.MMz.getContext();
    p.j(paramView, "context");
    paramView = (am)a.a.a((Context)paramView, 8, am.class);
    if (paramView != null) {
      paramView.MGr = (1L + paramView.MGr);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.ak
 * JD-Core Version:    0.7.0.1
 */