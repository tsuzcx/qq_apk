package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$w
  implements View.OnClickListener
{
  TextStatusEditActivity$w(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216513);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.GeQ.Tx(null);
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.w
 * JD-Core Version:    0.7.0.1
 */