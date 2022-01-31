package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$g
  extends MMGestureGallery.a
{
  float[] nhN;
  
  public MMGestureGallery$g(MMGestureGallery paramMMGestureGallery)
  {
    super(paramMMGestureGallery);
    AppMethodBeat.i(107663);
    this.nhN = new float[9];
    AppMethodBeat.o(107663);
  }
  
  public final void play()
  {
    AppMethodBeat.i(107664);
    MMGestureGallery.c(this.AvP).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107662);
        MMGestureGallery.a(MMGestureGallery.g.this.AvP).getImageMatrix().getValues(MMGestureGallery.g.this.nhN);
        float f1 = MMGestureGallery.a(MMGestureGallery.g.this.AvP).getScale();
        float f2 = MMGestureGallery.a(MMGestureGallery.g.this.AvP).getImageHeight() * f1;
        float f3 = MMGestureGallery.g.this.nhN[5];
        f1 = MMGestureGallery.d(MMGestureGallery.g.this.AvP);
        if (f2 < MMGestureGallery.d(MMGestureGallery.g.this.AvP)) {
          f1 = MMGestureGallery.d(MMGestureGallery.g.this.AvP) / 2.0F + f2 / 2.0F;
        }
        f1 -= f3 + f2;
        if (f1 <= 0.0F) {
          MMGestureGallery.g.this.bVC = true;
        }
        for (;;)
        {
          MMGestureGallery.a(MMGestureGallery.g.this.AvP).ap(0.0F, f1);
          AppMethodBeat.o(107662);
          return;
          if (Math.abs(f1) <= 5.0F) {
            MMGestureGallery.g.this.bVC = true;
          } else {
            f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
          }
        }
      }
    });
    AppMethodBeat.o(107664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.g
 * JD-Core Version:    0.7.0.1
 */