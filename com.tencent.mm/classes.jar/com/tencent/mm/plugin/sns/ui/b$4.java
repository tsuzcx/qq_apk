package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$4
  extends Animation
{
  b$4(b paramb, int paramInt1, int paramInt2) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(38067);
    paramTransformation = (RelativeLayout.LayoutParams)this.rDU.rDS.getLayoutParams();
    if (paramFloat == 1.0F) {}
    for (int i = 0;; i = (int)((this.rDV - this.rDW) * (1.0F - paramFloat)))
    {
      paramTransformation.bottomMargin = i;
      this.rDU.rDS.requestLayout();
      AppMethodBeat.o(38067);
      return;
    }
  }
  
  public final boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.4
 * JD-Core Version:    0.7.0.1
 */