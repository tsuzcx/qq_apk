package com.tencent.mm.plugin.voip.ui;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/ui/VoipRectangleViewOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "mRadius", "", "(F)V", "getMRadius", "()F", "setMRadius", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-voip_release"})
public final class e
  extends ViewOutlineProvider
{
  private float asb;
  
  public e(float paramFloat)
  {
    this.asb = paramFloat;
  }
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(184119);
    Rect localRect = new Rect();
    if (paramView != null) {
      paramView.getDrawingRect(localRect);
    }
    paramView = new Rect(0, 0, localRect.right - localRect.left + 0, localRect.bottom - localRect.top + 0);
    if (paramOutline != null)
    {
      paramOutline.setRoundRect(paramView, this.asb);
      AppMethodBeat.o(184119);
      return;
    }
    AppMethodBeat.o(184119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e
 * JD-Core Version:    0.7.0.1
 */