package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$2
  implements View.OnClickListener
{
  g$2(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26776);
    this.vyG.vyE.dismiss();
    this.vyG.mParentView.setVisibility(8);
    if (this.vyG.vyF != null) {
      this.vyG.vyF.diF();
    }
    AppMethodBeat.o(26776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g.2
 * JD-Core Version:    0.7.0.1
 */