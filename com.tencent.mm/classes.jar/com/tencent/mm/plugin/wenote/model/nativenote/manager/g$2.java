package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

final class g$2
  implements View.OnClickListener
{
  g$2(g paramg) {}
  
  public final void onClick(View paramView)
  {
    this.rIa.rHY.dismiss();
    this.rIa.mParentView.setVisibility(8);
    if (this.rIa.rHZ != null) {
      this.rIa.rHZ.cio();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g.2
 * JD-Core Version:    0.7.0.1
 */