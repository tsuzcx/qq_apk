package com.tencent.mm.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ui.base.preference.IconPreference;

final class h$13$2
  implements Runnable
{
  h$13$2(h.13 param13, Bitmap paramBitmap, int paramInt) {}
  
  public final void run()
  {
    h.a(this.uJt.uJi, true);
    this.uJt.uJq.Z(this.izh);
    if (this.uJt.uJr == 3) {
      h.a(this.uJt.uJq, 8, 8, false, 0, 0, 0);
    }
    for (;;)
    {
      h.c(this.uJt.val$appId, this.uJt.qyH, this.uJt.uJs, this.uJt.dUE, this.uJt.uJr);
      if (this.uJu == 2) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(858L, 13L, 1L, false);
      }
      return;
      if (this.uJt.uJr == 4) {
        h.a(this.uJt.uJq, 8, 0, false, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.h.13.2
 * JD-Core Version:    0.7.0.1
 */