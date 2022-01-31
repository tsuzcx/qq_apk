package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    this.rIa.rHY.dismiss();
    this.rIa.mParentView.setVisibility(8);
    if (this.rIa.rHZ != null) {
      this.rIa.rHZ.cin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.g.1
 * JD-Core Version:    0.7.0.1
 */