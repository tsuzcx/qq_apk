package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FileSelectorUI$v
  implements View.OnClickListener
{
  public static final v Kvi;
  
  static
  {
    AppMethodBeat.i(231130);
    Kvi = new v();
    AppMethodBeat.o(231130);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(231129);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(231129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.v
 * JD-Core Version:    0.7.0.1
 */