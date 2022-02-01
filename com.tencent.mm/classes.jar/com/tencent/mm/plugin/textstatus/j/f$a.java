package com.tencent.mm.plugin.textstatus.j;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/util/UIHelper$roundCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
public final class f$a
  extends ViewOutlineProvider
{
  f$a(float paramFloat) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(216701);
    p.h(paramView, "view");
    p.h(paramOutline, "outline");
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.Ggl);
    AppMethodBeat.o(216701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.f.a
 * JD-Core Version:    0.7.0.1
 */