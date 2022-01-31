package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class as$f$1
  implements View.OnClickListener
{
  as$f$1(as.f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    this.pcE.pcD = ((as.f.a)paramView.getTag());
    int i = this.pcE.pcD.onc;
    int j = this.pcE.pcD.position;
    this.pcE.dX(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.f.1
 * JD-Core Version:    0.7.0.1
 */