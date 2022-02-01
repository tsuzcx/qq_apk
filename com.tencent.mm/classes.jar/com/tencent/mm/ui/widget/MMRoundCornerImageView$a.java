package com.tencent.mm.ui.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/MMRoundCornerImageView$RoundCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "radius", "", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "libmmui_release"})
public final class MMRoundCornerImageView$a
  extends ViewOutlineProvider
{
  private int radius;
  
  public MMRoundCornerImageView$a(int paramInt)
  {
    this.radius = paramInt;
  }
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(204873);
    int i;
    if (paramView != null)
    {
      i = paramView.getMeasuredWidth();
      if (paramView == null) {
        break label62;
      }
    }
    label62:
    for (int j = paramView.getMeasuredHeight();; j = 0)
    {
      paramView = new Rect(0, 0, i, j);
      if (paramOutline == null) {
        break label68;
      }
      paramOutline.setRoundRect(paramView, this.radius);
      AppMethodBeat.o(204873);
      return;
      i = 0;
      break;
    }
    label68:
    AppMethodBeat.o(204873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMRoundCornerImageView.a
 * JD-Core Version:    0.7.0.1
 */