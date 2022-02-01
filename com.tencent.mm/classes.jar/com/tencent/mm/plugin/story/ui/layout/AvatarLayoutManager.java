package com.tencent.mm.plugin.story.ui.layout;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "alphaStartOffset", "canScrollVertically", "", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollToPositionWithOffset", "position", "offset", "updateChild", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AvatarLayoutManager
  extends LinearLayoutManager
{
  private final int MaH;
  
  public AvatarLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(119918);
    this.MaH = a.fromDPToPix(paramContext, 0);
    AppMethodBeat.o(119918);
  }
  
  private final void dDo()
  {
    AppMethodBeat.i(119917);
    int k = getChildCount();
    if (k > 0) {}
    int j;
    label156:
    label162:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = getChildAt(i);
      s.checkNotNull(localView);
      s.s(localView, "getChildAt(i)!!");
      i = (localView.getTop() + localView.getBottom()) / 2;
      int m = getHeight() / 2;
      int n = localView.getMeasuredHeight();
      if (n - Math.abs(i - m) > this.MaH)
      {
        localView.setAlpha(Math.min(1.0F - Math.abs(i - m) / (n - this.MaH), 1.0F));
        if (1.0F - localView.getAlpha() >= 0.1F) {
          break label156;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (j < k) {
          break label162;
        }
        AppMethodBeat.o(119917);
        return;
        localView.setAlpha(0.0F);
        break;
      }
    }
  }
  
  public final void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119916);
    super.bo(paramInt1, paramInt2);
    dDo();
    AppMethodBeat.o(119916);
  }
  
  public final boolean canScrollVertically()
  {
    return false;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(367220);
    super.onLayoutChildren(paramn, params);
    dDo();
    AppMethodBeat.o(367220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager
 * JD-Core Version:    0.7.0.1
 */