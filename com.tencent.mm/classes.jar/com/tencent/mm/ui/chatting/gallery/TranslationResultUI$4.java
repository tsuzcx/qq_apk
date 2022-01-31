package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

final class TranslationResultUI$4
  implements MMGestureGallery.b
{
  TranslationResultUI$4(TranslationResultUI paramTranslationResultUI) {}
  
  public final void ae(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(138648);
    float f2 = 1.0F - paramFloat2 / TranslationResultUI.e(this.zOm).getHeight();
    if (f2 > 1.0F)
    {
      ab.d("MicroMsg.TranslationResultUI", "onGalleryScale tx: %f, ty: %f, scale: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1) });
      if (TranslationResultUI.f(this.zOm) == null) {
        break label224;
      }
      if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
        break label209;
      }
      TranslationResultUI.g(this.zOm).setVisibility(0);
    }
    for (;;)
    {
      TranslationResultUI.f(this.zOm).setPivotX(TranslationResultUI.e(this.zOm).getWidth() / 2);
      TranslationResultUI.f(this.zOm).setPivotY(TranslationResultUI.e(this.zOm).getHeight() / 2);
      TranslationResultUI.f(this.zOm).setScaleX(f1);
      TranslationResultUI.f(this.zOm).setScaleY(f1);
      TranslationResultUI.f(this.zOm).setTranslationX(paramFloat1);
      TranslationResultUI.f(this.zOm).setTranslationY(paramFloat2);
      TranslationResultUI.h(this.zOm).setAlpha(f1);
      AppMethodBeat.o(138648);
      return;
      f1 = f2;
      break;
      label209:
      TranslationResultUI.g(this.zOm).setVisibility(8);
    }
    label224:
    ab.d("MicroMsg.TranslationResultUI", "runDragAnimation contentView is null !!");
    AppMethodBeat.o(138648);
  }
  
  public final void af(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI.4
 * JD-Core Version:    0.7.0.1
 */