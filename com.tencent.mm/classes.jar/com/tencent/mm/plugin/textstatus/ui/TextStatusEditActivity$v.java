package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class TextStatusEditActivity$v
  implements View.OnLongClickListener
{
  public static final v MML;
  
  static
  {
    AppMethodBeat.i(234234);
    MML = new v();
    AppMethodBeat.o(234234);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(234230);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initEditText$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initEditText$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(234230);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.v
 * JD-Core Version:    0.7.0.1
 */