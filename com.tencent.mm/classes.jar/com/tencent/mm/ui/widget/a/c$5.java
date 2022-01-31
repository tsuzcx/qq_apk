package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

final class c$5
  implements View.OnClickListener
{
  c$5(c paramc, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.wmQ != null) {
      this.wmQ.onClick(this.wmN, -2);
    }
    if (this.wmR) {
      this.wmN.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c.5
 * JD-Core Version:    0.7.0.1
 */