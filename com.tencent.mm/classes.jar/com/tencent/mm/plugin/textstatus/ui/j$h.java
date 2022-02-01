package com.tencent.mm.plugin.textstatus.ui;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$4", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
public final class j$h
  extends ViewOutlineProvider
{
  j$h(int paramInt) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(216608);
    p.h(paramView, "view");
    p.h(paramOutline, "outline");
    paramOutline.setRoundRect(0, -this.Gfu, paramView.getWidth(), paramView.getHeight(), this.Gfu);
    AppMethodBeat.o(216608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.j.h
 * JD-Core Version:    0.7.0.1
 */