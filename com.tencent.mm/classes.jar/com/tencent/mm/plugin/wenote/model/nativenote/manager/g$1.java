package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26775);
    this.vyG.vyE.dismiss();
    this.vyG.mParentView.setVisibility(8);
    if (this.vyG.vyF != null) {
      this.vyG.vyF.diE();
    }
    AppMethodBeat.o(26775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g.1
 * JD-Core Version:    0.7.0.1
 */