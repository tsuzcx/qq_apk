package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b;

import android.support.v4.view.ViewPager.f;
import android.view.View;

public final class a
  implements ViewPager.f
{
  public final void j(View paramView, float paramFloat)
  {
    float f2 = 0.0F;
    float f1;
    if ((0.0F <= paramFloat) && (paramFloat <= 1.0F)) {
      f1 = 1.0F - paramFloat;
    }
    for (;;)
    {
      paramView.setAlpha(f1);
      paramView.setTranslationX(paramView.getWidth() * -paramFloat);
      paramView.setTranslationY(paramView.getHeight() * paramFloat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b.a
 * JD-Core Version:    0.7.0.1
 */