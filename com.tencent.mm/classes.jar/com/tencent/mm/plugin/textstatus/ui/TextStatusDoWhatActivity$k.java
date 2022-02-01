package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusDoWhatActivity$k
  implements View.OnClickListener
{
  TextStatusDoWhatActivity$k(TextStatusDoWhatActivity paramTextStatusDoWhatActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(237395);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    TextStatusDoWhatActivity.f(this.MLa);
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$showCustomDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(237395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.k
 * JD-Core Version:    0.7.0.1
 */