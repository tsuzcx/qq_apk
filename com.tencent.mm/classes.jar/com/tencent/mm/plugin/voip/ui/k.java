package com.tencent.mm.plugin.voip.ui;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/ui/VoipRectangleViewOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "mRadius", "", "(F)V", "getMRadius", "()F", "setMRadius", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends ViewOutlineProvider
{
  private float Ri;
  
  public k(float paramFloat)
  {
    this.Ri = paramFloat;
  }
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(184119);
    Rect localRect = new Rect();
    if (paramView != null) {
      paramView.getDrawingRect(localRect);
    }
    paramView = new Rect(0, 0, localRect.right - localRect.left + 0, localRect.bottom - localRect.top + 0);
    if (paramOutline != null) {
      paramOutline.setRoundRect(paramView, this.Ri);
    }
    AppMethodBeat.o(184119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.k
 * JD-Core Version:    0.7.0.1
 */