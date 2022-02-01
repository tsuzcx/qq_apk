package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "targetSnapPos", "", "attachToRecyclerView", "", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findSnapView", "Landroid/view/View;", "findTargetSnapPosition", "velocityX", "velocityY", "OnPageSelectedListener", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends t
{
  private int EBt = -1;
  a TkQ;
  private RecyclerView mkw;
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290790);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    this.EBt = paramInt1;
    paramLayoutManager = this.TkQ;
    if (paramLayoutManager != null) {
      paramLayoutManager.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(290790);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(290798);
    View localView = super.a(paramLayoutManager);
    if (localView == null)
    {
      paramLayoutManager = null;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        break label79;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)paramLayoutManager;
      label29:
      if (paramLayoutManager != null) {
        break label84;
      }
    }
    label79:
    label84:
    for (int i = -1;; i = paramLayoutManager.bXh.KJ())
    {
      if (this.EBt == -1)
      {
        paramLayoutManager = this.TkQ;
        if (paramLayoutManager != null) {
          paramLayoutManager.onPageSelected(i);
        }
      }
      this.EBt = -1;
      AppMethodBeat.o(290798);
      return localView;
      paramLayoutManager = localView.getLayoutParams();
      break;
      paramLayoutManager = null;
      break label29;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(290769);
    super.a(paramRecyclerView);
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(290769);
  }
  
  public final RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(290781);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(290781);
      return null;
    }
    paramLayoutManager = this.mkw;
    if (paramLayoutManager == null) {}
    for (paramLayoutManager = null;; paramLayoutManager = paramLayoutManager.getContext())
    {
      paramLayoutManager = (RecyclerView.r)new b(this, paramLayoutManager);
      AppMethodBeat.o(290781);
      return paramLayoutManager;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends o
  {
    b(k paramk, Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(290756);
      s.u(paramView, "targetView");
      s.u(params, "state");
      s.u(parama, "action");
      if (k.a(this.TkR) != null)
      {
        k localk = this.TkR;
        params = k.a(this.TkR);
        if (params == null) {}
        int i;
        int j;
        for (params = null;; params = params.getLayoutManager())
        {
          s.checkNotNull(params);
          paramView = localk.a(params, paramView);
          s.checkNotNull(paramView);
          i = paramView[0];
          j = paramView[1];
          int k = fO(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.bXY);
          AppMethodBeat.o(290756);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.bXY);
      }
      AppMethodBeat.o(290756);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(290771);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 50.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(290771);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.k
 * JD-Core Version:    0.7.0.1
 */