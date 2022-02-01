package com.tencent.mm.plugin.textstatus.util;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/util/UIHelper$roundCornerWithWidthPercent$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$b
  extends ViewOutlineProvider
{
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(290418);
    s.u(paramView, "view");
    s.u(paramOutline, "outline");
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.TBA * paramView.getWidth());
    AppMethodBeat.o(290418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.l.b
 * JD-Core Version:    0.7.0.1
 */