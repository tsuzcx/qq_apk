package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NewFileExplorerUI$1
  implements View.OnClickListener
{
  NewFileExplorerUI$1(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31979);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (NewFileExplorerUI.a(this.FDf) != null)
    {
      paramView = NewFileExplorerUI.a(this.FDf);
      if (paramView.jR) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      paramView.mW(bool);
      a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(31979);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.1
 * JD-Core Version:    0.7.0.1
 */