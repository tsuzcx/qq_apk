package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FileSelectorUI$x
  implements View.OnClickListener
{
  public static final x Rws;
  
  static
  {
    AppMethodBeat.i(289953);
    Rws = new x();
    AppMethodBeat.o(289953);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289952);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.x
 * JD-Core Version:    0.7.0.1
 */