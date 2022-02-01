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
import androidx.recyclerview.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "targetSnapPos", "", "attachToRecyclerView", "", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findSnapView", "Landroid/view/View;", "findTargetSnapPosition", "velocityX", "velocityY", "OnPageSelectedListener", "plugin-textstatus_release"})
public final class k
  extends v
{
  a MBk;
  private RecyclerView jLl;
  private int zyA = -1;
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237062);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    this.zyA = paramInt1;
    paramLayoutManager = this.MBk;
    if (paramLayoutManager != null) {
      paramLayoutManager.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(237062);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(237065);
    View localView = super.a(paramLayoutManager);
    if (localView != null)
    {
      paramLayoutManager = localView.getLayoutParams();
      RecyclerView.LayoutManager localLayoutManager = paramLayoutManager;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        localLayoutManager = null;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)localLayoutManager;
      if (paramLayoutManager == null) {
        break label90;
      }
    }
    label90:
    for (int i = paramLayoutManager.lS();; i = -1)
    {
      if (this.zyA == -1)
      {
        paramLayoutManager = this.MBk;
        if (paramLayoutManager != null) {
          paramLayoutManager.onPageSelected(i);
        }
      }
      this.zyA = -1;
      AppMethodBeat.o(237065);
      return localView;
      paramLayoutManager = null;
      break;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(237057);
    super.a(paramRecyclerView);
    this.jLl = paramRecyclerView;
    AppMethodBeat.o(237057);
  }
  
  public final RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = null;
    AppMethodBeat.i(237059);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(237059);
      return null;
    }
    RecyclerView localRecyclerView = this.jLl;
    paramLayoutManager = localObject;
    if (localRecyclerView != null) {
      paramLayoutManager = localRecyclerView.getContext();
    }
    paramLayoutManager = (RecyclerView.r)new b(this, paramLayoutManager);
    AppMethodBeat.o(237059);
    return paramLayoutManager;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-textstatus_release"})
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiPagerScrollHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-textstatus_release"})
  public static final class b
    extends androidx.recyclerview.widget.p
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(238033);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 50.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(238033);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(238031);
      kotlin.g.b.p.k(paramView, "targetView");
      kotlin.g.b.p.k(params, "state");
      kotlin.g.b.p.k(parama, "action");
      if (k.a(this.MBl) != null)
      {
        k localk = this.MBl;
        params = k.a(this.MBl);
        if (params != null) {}
        int i;
        int j;
        for (params = params.getLayoutManager();; params = null)
        {
          if (params == null) {
            kotlin.g.b.p.iCn();
          }
          paramView = localk.a(params, paramView);
          if (paramView == null) {
            kotlin.g.b.p.iCn();
          }
          i = paramView[0];
          j = paramView[1];
          int k = cE(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.aju);
          AppMethodBeat.o(238031);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.aju);
      }
      AppMethodBeat.o(238031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.k
 * JD-Core Version:    0.7.0.1
 */