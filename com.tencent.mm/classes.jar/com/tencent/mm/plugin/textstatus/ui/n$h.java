package com.tencent.mm.plugin.textstatus.ui;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$4", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
public final class n$h
  extends ViewOutlineProvider
{
  n$h(int paramInt) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(232928);
    p.k(paramView, "view");
    p.k(paramOutline, "outline");
    paramOutline.setRoundRect(0, -this.MNn, paramView.getWidth(), paramView.getHeight(), this.MNn);
    AppMethodBeat.o(232928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.n.h
 * JD-Core Version:    0.7.0.1
 */