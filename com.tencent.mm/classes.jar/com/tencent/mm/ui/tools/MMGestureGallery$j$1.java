package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$j$1
  implements Runnable
{
  MMGestureGallery$j$1(MMGestureGallery.j paramj) {}
  
  public final void run()
  {
    MMGestureGallery.a(this.wdm.wdi).getImageMatrix().getValues(this.wdm.kLk);
    float f1 = MMGestureGallery.a(this.wdm.wdi).getScale();
    float f2 = MMGestureGallery.a(this.wdm.wdi).getImageWidth() * f1;
    float f3 = this.wdm.kLk[2];
    f1 = MMGestureGallery.b(this.wdm.wdi);
    if (f2 < MMGestureGallery.b(this.wdm.wdi)) {
      f1 = MMGestureGallery.b(this.wdm.wdi) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if (f1 <= 0.0F) {
      this.wdm.bur = true;
    }
    for (;;)
    {
      MMGestureGallery.a(this.wdm.wdi).ae(f1, 0.0F);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.wdm.bur = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.j.1
 * JD-Core Version:    0.7.0.1
 */