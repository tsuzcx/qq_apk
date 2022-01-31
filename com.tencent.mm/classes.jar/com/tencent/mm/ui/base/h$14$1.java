package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.widget.LinearLayout;

final class h$14$1
  implements Runnable
{
  h$14$1(h.14 param14, int paramInt) {}
  
  public final void run()
  {
    ((Dialog)this.uUf.nTq.getTag()).dismiss();
    if (this.uUf.uUd != null) {
      this.uUf.uUd.wv(this.uUe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.14.1
 * JD-Core Version:    0.7.0.1
 */