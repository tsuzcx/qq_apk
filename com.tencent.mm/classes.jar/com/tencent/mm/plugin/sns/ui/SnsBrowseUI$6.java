package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

final class SnsBrowseUI$6
  implements MMGestureGallery.b
{
  SnsBrowseUI$6(SnsBrowseUI paramSnsBrowseUI, Gallery paramGallery) {}
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    if (((SnsBrowseUI.f(this.oVL) == 0) || (SnsBrowseUI.g(this.oVL) == 0)) && (this.oVL.oVy != null))
    {
      SnsBrowseUI.b(this.oVL, this.oVL.oVy.getHeight());
      SnsBrowseUI.a(this.oVL, this.oVL.oVy.getWidth());
    }
    if (SnsBrowseUI.f(this.oVL) != 0)
    {
      float f2 = 1.0F - paramFloat2 / SnsBrowseUI.f(this.oVL);
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      SnsBrowseUI.a(this.oVL, f1);
      View localView = ((MMGestureGallery)this.oVP).getSelectedView();
      if ((localView instanceof MultiTouchImageView))
      {
        localView.setPivotX(SnsBrowseUI.g(this.oVL) / 2);
        localView.setPivotY(SnsBrowseUI.f(this.oVL) / 2);
        localView.setScaleX(f1);
        localView.setScaleY(f1);
        localView.setTranslationX(paramFloat1);
        localView.setTranslationY(paramFloat2);
        SnsBrowseUI.d(this.oVL).setAlpha(f1);
      }
    }
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    SnsBrowseUI.e(this.oVL, (int)paramFloat1);
    SnsBrowseUI.f(this.oVL, (int)paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.6
 * JD-Core Version:    0.7.0.1
 */