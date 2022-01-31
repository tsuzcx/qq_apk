package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

final class s$6
  implements View.OnClickListener
{
  s$6(o paramo, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    this.uYH.dismiss();
    if (this.uYK != null) {
      this.uYK.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.s.6
 * JD-Core Version:    0.7.0.1
 */