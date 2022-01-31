package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$i
  extends MMGestureGallery.a
{
  float[] nhN;
  
  public MMGestureGallery$i(MMGestureGallery paramMMGestureGallery)
  {
    super(paramMMGestureGallery);
    AppMethodBeat.i(107669);
    this.nhN = new float[9];
    AppMethodBeat.o(107669);
  }
  
  public final void play()
  {
    AppMethodBeat.i(107670);
    MMGestureGallery.c(this.AvP).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107668);
        MMGestureGallery.a(MMGestureGallery.i.this.AvP).getImageMatrix().getValues(MMGestureGallery.i.this.nhN);
        float f2 = MMGestureGallery.i.this.nhN[2];
        float f1 = MMGestureGallery.a(MMGestureGallery.i.this.AvP).getScale() * MMGestureGallery.a(MMGestureGallery.i.this.AvP).getImageWidth();
        if (f1 < MMGestureGallery.b(MMGestureGallery.i.this.AvP)) {}
        for (f1 = MMGestureGallery.b(MMGestureGallery.i.this.AvP) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
        {
          f1 -= f2;
          if (f1 >= 0.0F) {
            MMGestureGallery.i.this.bVC = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.i.this.AvP).ap(f1, 0.0F);
            AppMethodBeat.o(107668);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.i.this.bVC = true;
            } else {
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      }
    });
    AppMethodBeat.o(107670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.i
 * JD-Core Version:    0.7.0.1
 */