package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "alphaStartOffset", "canScrollVertically", "", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollToPositionWithOffset", "position", "offset", "updateChild", "plugin-story_release"})
public final class AvatarLayoutManager
  extends LinearLayoutManager
{
  private final int AXz;
  
  public AvatarLayoutManager(Context paramContext)
  {
    super(1);
    AppMethodBeat.i(119918);
    this.AXz = a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(119918);
  }
  
  private final void ckJ()
  {
    AppMethodBeat.i(119917);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null) {
        p.gfZ();
      }
      p.g(localView, "getChildAt(i)!!");
      int k = (localView.getTop() + localView.getBottom()) / 2;
      int m = getHeight() / 2;
      int n = localView.getMeasuredHeight();
      if (n - Math.abs(k - m) > this.AXz)
      {
        localView.setAlpha(Math.min(1.0F - Math.abs(k - m) / (n - this.AXz), 1.0F));
        label113:
        if (1.0F - localView.getAlpha() >= 0.1F) {
          break label152;
        }
      }
      label152:
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        i += 1;
        break;
        localView.setAlpha(0.0F);
        break label113;
      }
    }
    AppMethodBeat.o(119917);
  }
  
  public final void ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119916);
    super.ag(paramInt1, paramInt2);
    ckJ();
    AppMethodBeat.o(119916);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(119915);
    super.c(paramo, paramt);
    ckJ();
    AppMethodBeat.o(119915);
  }
  
  public final boolean kd()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager
 * JD-Core Version:    0.7.0.1
 */