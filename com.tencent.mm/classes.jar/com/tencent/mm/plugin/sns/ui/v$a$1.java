package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class v$a$1
  implements View.OnClickListener
{
  v$a$1(v.a parama) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getTag() == null) {
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.oPL.yx(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v.a.1
 * JD-Core Version:    0.7.0.1
 */