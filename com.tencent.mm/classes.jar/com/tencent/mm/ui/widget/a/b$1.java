package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (this.wmt.isShowing()) {
      this.wmt.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.b.1
 * JD-Core Version:    0.7.0.1
 */