package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "alphaStartOffset", "canScrollVertically", "", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollToPositionWithOffset", "position", "offset", "updateChild", "plugin-story_release"})
public final class AvatarLayoutManager
  extends LinearLayoutManager
{
  private final int Gfo;
  
  public AvatarLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(119918);
    this.Gfo = a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(119918);
  }
  
  private final void cWY()
  {
    AppMethodBeat.i(119917);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null) {
        p.iCn();
      }
      p.j(localView, "getChildAt(i)!!");
      int k = (localView.getTop() + localView.getBottom()) / 2;
      int m = getHeight() / 2;
      int n = localView.getMeasuredHeight();
      if (n - Math.abs(k - m) > this.Gfo)
      {
        localView.setAlpha(Math.min(1.0F - Math.abs(k - m) / (n - this.Gfo), 1.0F));
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
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119916);
    super.au(paramInt1, paramInt2);
    cWY();
    AppMethodBeat.o(119916);
  }
  
  public final boolean canScrollVertically()
  {
    return false;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(223478);
    super.onLayoutChildren(paramn, params);
    cWY();
    AppMethodBeat.o(223478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager
 * JD-Core Version:    0.7.0.1
 */