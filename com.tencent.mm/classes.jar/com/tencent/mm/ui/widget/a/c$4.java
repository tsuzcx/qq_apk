package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

final class c$4
  implements View.OnClickListener
{
  c$4(c paramc, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.uMd != null) {
      this.uMd.onClick(this.wmN, -1);
    }
    if (this.uMe) {
      this.wmN.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c.4
 * JD-Core Version:    0.7.0.1
 */