package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewFileExplorerUI$1
  implements View.OnClickListener
{
  NewFileExplorerUI$1(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28175);
    if (NewFileExplorerUI.a(this.wfn) != null)
    {
      paramView = NewFileExplorerUI.a(this.wfn);
      if (paramView.Zb) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      paramView.hV(bool);
      AppMethodBeat.o(28175);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.1
 * JD-Core Version:    0.7.0.1
 */