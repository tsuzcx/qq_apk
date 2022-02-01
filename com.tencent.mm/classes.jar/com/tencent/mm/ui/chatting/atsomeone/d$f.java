package com.tencent.mm.ui.chatting.atsomeone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$f
  implements View.OnClickListener
{
  d$f(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198175);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.WGi.cancel();
    a.a(this, "com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.d.f
 * JD-Core Version:    0.7.0.1
 */