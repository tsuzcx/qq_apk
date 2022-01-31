package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$g
  extends MMGestureGallery.a
{
  float[] kLk = new float[9];
  
  public MMGestureGallery$g(MMGestureGallery paramMMGestureGallery)
  {
    super(paramMMGestureGallery);
  }
  
  public final void play()
  {
    MMGestureGallery.c(this.wdi).post(new Runnable()
    {
      public final void run()
      {
        MMGestureGallery.a(MMGestureGallery.g.this.wdi).getImageMatrix().getValues(MMGestureGallery.g.this.kLk);
        float f1 = MMGestureGallery.a(MMGestureGallery.g.this.wdi).getScale();
        float f2 = MMGestureGallery.a(MMGestureGallery.g.this.wdi).getImageHeight() * f1;
        float f3 = MMGestureGallery.g.this.kLk[5];
        f1 = MMGestureGallery.d(MMGestureGallery.g.this.wdi);
        if (f2 < MMGestureGallery.d(MMGestureGallery.g.this.wdi)) {
          f1 = MMGestureGallery.d(MMGestureGallery.g.this.wdi) / 2.0F + f2 / 2.0F;
        }
        f1 -= f3 + f2;
        if (f1 <= 0.0F) {
          MMGestureGallery.g.this.bur = true;
        }
        for (;;)
        {
          MMGestureGallery.a(MMGestureGallery.g.this.wdi).ae(0.0F, f1);
          return;
          if (Math.abs(f1) <= 5.0F) {
            MMGestureGallery.g.this.bur = true;
          } else {
            f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
          }
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.g
 * JD-Core Version:    0.7.0.1
 */