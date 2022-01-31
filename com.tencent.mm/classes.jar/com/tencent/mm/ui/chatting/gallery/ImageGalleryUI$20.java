package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;

final class ImageGalleryUI$20
  implements MMViewPager.b
{
  ImageGalleryUI$20(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    float f2 = 1.0F - paramFloat2 / this.vww.kJC.getHeight();
    if (f2 > 1.0F)
    {
      ImageGalleryUI.a(this.vww, f1);
      y.d("MicroMsg.ImageGalleryUI", "alvinluo onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      ImageGalleryUI.a(this.vww, ImageGalleryUI.a(this.vww, ImageGalleryUI.f(this.vww), this.vww.kJC));
      if (ImageGalleryUI.s(this.vww) == null) {
        break label243;
      }
      if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
        break label233;
      }
      ImageGalleryUI.t(this.vww);
    }
    for (;;)
    {
      ImageGalleryUI.s(this.vww).setPivotX(this.vww.kJC.getWidth() / 2);
      ImageGalleryUI.s(this.vww).setPivotY(this.vww.kJC.getHeight() / 2);
      ImageGalleryUI.s(this.vww).setScaleX(f1);
      ImageGalleryUI.s(this.vww).setScaleY(f1);
      ImageGalleryUI.s(this.vww).setTranslationX(paramFloat1);
      ImageGalleryUI.s(this.vww).setTranslationY(paramFloat2);
      ImageGalleryUI.p(this.vww).setAlpha(f1);
      return;
      f1 = f2;
      break;
      label233:
      ImageGalleryUI.n(this.vww);
    }
    label243:
    y.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    ImageGalleryUI.c(this.vww, (int)paramFloat1);
    ImageGalleryUI.d(this.vww, (int)paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.20
 * JD-Core Version:    0.7.0.1
 */