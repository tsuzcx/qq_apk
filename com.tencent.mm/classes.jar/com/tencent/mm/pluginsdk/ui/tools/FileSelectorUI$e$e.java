package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FileSelectorUI$e$e
  implements View.OnClickListener
{
  FileSelectorUI$e$e(FileSelectorUI.e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(231065);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = this.KuG;
    p.g(paramView, "v");
    FileSelectorUI.e.a((FileSelectorUI.e)localObject, paramView);
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(231065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.e.e
 * JD-Core Version:    0.7.0.1
 */