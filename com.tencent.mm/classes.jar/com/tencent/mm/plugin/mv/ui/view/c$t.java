package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$roundCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$t
  extends ViewOutlineProvider
{
  c$t(float paramFloat) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(287000);
    s.u(paramView, "view");
    s.u(paramOutline, "outline");
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.vtJ);
    AppMethodBeat.o(287000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.c.t
 * JD-Core Version:    0.7.0.1
 */