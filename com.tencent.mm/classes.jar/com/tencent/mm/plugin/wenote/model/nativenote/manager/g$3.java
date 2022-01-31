package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$3
  implements View.OnClickListener
{
  g$3(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26777);
    this.vyG.vyE.dismiss();
    this.vyG.mParentView.setVisibility(8);
    if (this.vyG.vyF != null) {
      this.vyG.vyF.diG();
    }
    AppMethodBeat.o(26777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g.3
 * JD-Core Version:    0.7.0.1
 */