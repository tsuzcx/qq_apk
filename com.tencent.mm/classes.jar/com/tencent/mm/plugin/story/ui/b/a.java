package com.tencent.mm.plugin.story.ui.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "alphaStartOffset", "canScrollVertically", "", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollToPositionWithOffset", "position", "offset", "updateChild", "plugin-story_release"})
public final class a
  extends LinearLayoutManager
{
  private final int sKc;
  
  public a(Context paramContext)
  {
    super(1);
    AppMethodBeat.i(110212);
    this.sKc = com.tencent.mm.cb.a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(110212);
  }
  
  private final void bpo()
  {
    AppMethodBeat.i(110211);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      j.p(localView, "child");
      int k = (localView.getTop() + localView.getBottom()) / 2;
      int m = getHeight() / 2;
      int n = localView.getMeasuredHeight();
      if (n - Math.abs(k - m) > this.sKc)
      {
        localView.setAlpha(Math.min(1.0F - Math.abs(k - m) / (n - this.sKc), 1.0F));
        label105:
        if (1.0F - localView.getAlpha() >= 0.1F) {
          break label144;
        }
      }
      label144:
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        i += 1;
        break;
        localView.setAlpha(0.0F);
        break label105;
      }
    }
    AppMethodBeat.o(110211);
  }
  
  public final void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110210);
    super.ad(paramInt1, paramInt2);
    bpo();
    AppMethodBeat.o(110210);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(110209);
    super.c(paramo, params);
    bpo();
    AppMethodBeat.o(110209);
  }
  
  public final boolean ik()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.b.a
 * JD-Core Version:    0.7.0.1
 */