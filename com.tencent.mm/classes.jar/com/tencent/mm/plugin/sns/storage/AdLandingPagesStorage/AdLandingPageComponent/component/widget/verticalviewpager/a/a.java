package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.view.View;
import androidx.viewpager.widget.ViewPager.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements ViewPager.d
{
  public final void p(View paramView, float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(97128);
    float f1;
    if ((0.0F <= paramFloat) && (paramFloat <= 1.0F)) {
      f1 = 1.0F - paramFloat;
    }
    for (;;)
    {
      paramView.setAlpha(f1);
      paramView.setTranslationX(paramView.getWidth() * -paramFloat);
      paramView.setTranslationY(paramView.getHeight() * paramFloat);
      AppMethodBeat.o(97128);
      return;
      f1 = f2;
      if (-1.0F < paramFloat)
      {
        f1 = f2;
        if (paramFloat < 0.0F) {
          f1 = paramFloat + 1.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a
 * JD-Core Version:    0.7.0.1
 */