package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

final class SnsBrowseUI$6
  implements MMGestureGallery.b
{
  SnsBrowseUI$6(SnsBrowseUI paramSnsBrowseUI, Gallery paramGallery) {}
  
  public final void ae(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(38757);
    if (((SnsBrowseUI.f(this.rOg) == 0) || (SnsBrowseUI.g(this.rOg) == 0)) && (this.rOg.rNT != null))
    {
      SnsBrowseUI.b(this.rOg, this.rOg.rNT.getHeight());
      SnsBrowseUI.a(this.rOg, this.rOg.rNT.getWidth());
    }
    if (SnsBrowseUI.f(this.rOg) != 0)
    {
      float f2 = 1.0F - paramFloat2 / SnsBrowseUI.f(this.rOg);
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      SnsBrowseUI.a(this.rOg, f1);
      View localView = ((MMGestureGallery)this.rOk).getSelectedView();
      if ((localView instanceof MultiTouchImageView))
      {
        localView.setPivotX(SnsBrowseUI.g(this.rOg) / 2);
        localView.setPivotY(SnsBrowseUI.f(this.rOg) / 2);
        localView.setScaleX(f1);
        localView.setScaleY(f1);
        localView.setTranslationX(paramFloat1);
        localView.setTranslationY(paramFloat2);
        SnsBrowseUI.d(this.rOg).setAlpha(f1);
      }
    }
    AppMethodBeat.o(38757);
  }
  
  public final void af(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(38758);
    SnsBrowseUI.e(this.rOg, (int)paramFloat1);
    SnsBrowseUI.f(this.rOg, (int)paramFloat2);
    AppMethodBeat.o(38758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.6
 * JD-Core Version:    0.7.0.1
 */