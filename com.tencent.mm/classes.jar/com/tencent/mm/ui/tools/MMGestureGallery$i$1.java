package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$i$1
  implements Runnable
{
  MMGestureGallery$i$1(MMGestureGallery.i parami) {}
  
  public final void run()
  {
    MMGestureGallery.a(this.wdl.wdi).getImageMatrix().getValues(this.wdl.kLk);
    float f2 = this.wdl.kLk[2];
    float f1 = MMGestureGallery.a(this.wdl.wdi).getScale() * MMGestureGallery.a(this.wdl.wdi).getImageWidth();
    if (f1 < MMGestureGallery.b(this.wdl.wdi)) {}
    for (f1 = MMGestureGallery.b(this.wdl.wdi) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if (f1 >= 0.0F) {
        this.wdl.bur = true;
      }
      for (;;)
      {
        MMGestureGallery.a(this.wdl.wdi).ae(f1, 0.0F);
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.wdl.bur = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.i.1
 * JD-Core Version:    0.7.0.1
 */