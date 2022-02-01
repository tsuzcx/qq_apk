package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FileSelectorFolderView$3
  implements View.OnClickListener
{
  FileSelectorFolderView$3(FileSelectorFolderView paramFileSelectorFolderView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31950);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    FileSelectorFolderView.c(this.Kud);
    a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorFolderView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.3
 * JD-Core Version:    0.7.0.1
 */