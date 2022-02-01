package com.tencent.mm.view.refreshLayout.h;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.k;
import androidx.core.g.o;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.g.c;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/wrapper/RefreshCenterWrapper;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshContentPlugin;", "Lcom/tencent/mm/view/refreshLayout/listener/OnCoordinatorLayoutListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "outView", "Landroid/view/View;", "(Landroid/view/View;)V", "mBoundaryAdapter", "Lcom/tencent/mm/view/refreshLayout/widget/RefreshBoundaryDecider;", "mEnableLoadMore", "", "mEnableRefresh", "mLastSpinner", "", "mOriginalContentView", "scrollableView", "getScrollableView", "()Landroid/view/View;", "setScrollableView", "view", "getView", "setView", "canLoadMore", "canRefresh", "checkCoordinatorLayout", "", "content", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "listener", "findScrollableView", "outContent", "layout", "findScrollableViewByPoint", "event", "Landroid/graphics/PointF;", "orgScrollableView", "findScrollableViewInternal", "selfAble", "measureViewHeight", "moveSpinner", "spinner", "onActionDown", "e", "Landroid/view/MotionEvent;", "onAnimationUpdate", "animation", "Landroid/animation/ValueAnimator;", "onCoordinatorUpdate", "enableRefresh", "enableLoadMore", "scrollContentWhenFinished", "scrollListBy", "listView", "Landroid/widget/AbsListView;", "y", "setEnableLoadMoreWhenContentNotFull", "enable", "setScrollBoundaryDecider", "boundary", "Lcom/tencent/mm/view/refreshLayout/interfaces/IScrollBoundaryDecider;", "setUpPlugin", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements ValueAnimator.AnimatorUpdateListener, com.tencent.mm.view.refreshLayout.b.a, com.tencent.mm.view.refreshLayout.d.a
{
  private View agRu;
  private c agRv;
  private int agRw;
  private boolean agRx;
  private View agRy;
  private boolean mEnableRefresh;
  private View view;
  
  public a(View paramView)
  {
    AppMethodBeat.i(235145);
    this.agRu = paramView;
    this.agRv = new c();
    this.mEnableRefresh = true;
    this.agRx = true;
    this.agRy = paramView;
    this.view = paramView;
    AppMethodBeat.o(235145);
  }
  
  private final View a(View paramView1, PointF paramPointF, View paramView2)
  {
    AppMethodBeat.i(235155);
    int i;
    PointF localPointF;
    if (((paramView1 instanceof ViewGroup)) && (paramPointF != null))
    {
      i = ((ViewGroup)paramView1).getChildCount();
      localPointF = new PointF();
      if (i <= 0) {}
    }
    for (;;)
    {
      int j = i - 1;
      View localView = ((ViewGroup)paramView1).getChildAt(i - 1);
      s.s(localView, "child");
      if (c.a(paramView1, localView, paramPointF.x, paramPointF.y, localPointF))
      {
        if (!(localView instanceof ViewPager))
        {
          paramView1 = com.tencent.mm.view.refreshLayout.f.a.agRg;
          paramView1 = localView;
          if (com.tencent.mm.view.refreshLayout.f.a.aU(localView)) {}
        }
        else
        {
          paramPointF.offset(localPointF.x, localPointF.y);
          paramView1 = a(localView, paramPointF, paramView2);
          paramPointF.offset(-localPointF.x, -localPointF.y);
        }
        s.s(paramView1, "child");
        AppMethodBeat.o(235155);
        return paramView1;
      }
      if (j <= 0)
      {
        AppMethodBeat.o(235155);
        return paramView2;
      }
      i = j;
    }
  }
  
  private static void a(View paramView, e parame, com.tencent.mm.view.refreshLayout.d.a parama)
  {
    AppMethodBeat.i(235164);
    for (;;)
    {
      int j;
      try
      {
        if ((paramView instanceof CoordinatorLayout))
        {
          parame.jNw();
          paramView = (ViewGroup)paramView;
          i = paramView.getChildCount() - 1;
          if (i >= 0)
          {
            j = i - 1;
            parame = paramView.getChildAt(i);
            if ((parame instanceof AppBarLayout)) {
              ((AppBarLayout)parame).a(new a..ExternalSyntheticLambda0(parama));
            }
            if (j >= 0) {
              break label86;
            }
          }
        }
      }
      finally
      {
        AppMethodBeat.o(235164);
        return;
      }
      label86:
      int i = j;
    }
  }
  
  private static final void a(com.tencent.mm.view.refreshLayout.d.a parama, AppBarLayout paramAppBarLayout, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(235168);
    s.u(parama, "$listener");
    boolean bool1;
    if (paramInt >= 0)
    {
      bool1 = true;
      if (paramAppBarLayout.getTotalScrollRange() + paramInt > 0) {
        break label49;
      }
    }
    for (;;)
    {
      parama.bT(bool1, bool2);
      AppMethodBeat.o(235168);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  private void mG(View paramView)
  {
    AppMethodBeat.i(235149);
    s.u(paramView, "<set-?>");
    this.agRy = paramView;
    AppMethodBeat.o(235149);
  }
  
  public final void Og(boolean paramBoolean)
  {
    this.agRv.agRt = paramBoolean;
  }
  
  public final void aGn(int paramInt)
  {
    AppMethodBeat.i(235177);
    this.agRu.setTranslationY(paramInt);
    AppMethodBeat.o(235177);
  }
  
  public final ValueAnimator.AnimatorUpdateListener aGo(int paramInt)
  {
    AppMethodBeat.i(235202);
    if ((paramInt != 0) && (((paramInt < 0) && (this.agRy.canScrollVertically(1))) || ((paramInt > 0) && (this.agRy.canScrollVertically(-1)))))
    {
      this.agRw = paramInt;
      ValueAnimator.AnimatorUpdateListener localAnimatorUpdateListener = (ValueAnimator.AnimatorUpdateListener)this;
      AppMethodBeat.o(235202);
      return localAnimatorUpdateListener;
    }
    AppMethodBeat.o(235202);
    return null;
  }
  
  public final void aN(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235190);
    s.u(paramMotionEvent, "e");
    paramMotionEvent = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    paramMotionEvent.offset(-this.view.getLeft(), -this.view.getTop());
    if (this.agRy != this.view) {
      mG(a(this.view, paramMotionEvent, this.agRy));
    }
    if (this.agRy == this.view)
    {
      this.agRv.agRr = null;
      AppMethodBeat.o(235190);
      return;
    }
    this.agRv.agRr = paramMotionEvent;
    AppMethodBeat.o(235190);
  }
  
  public final void bT(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mEnableRefresh = paramBoolean1;
    this.agRx = paramBoolean2;
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(235196);
    s.u(parame, "layout");
    Object localObject2 = this.view;
    boolean bool = this.view.isInEditMode();
    Object localObject4 = null;
    while ((localObject4 == null) || (((localObject4 instanceof o)) && (!(localObject4 instanceof k))))
    {
      int i;
      LinkedList localLinkedList;
      List localList;
      Object localObject3;
      if (localObject4 == null)
      {
        i = 1;
        localLinkedList = new LinkedList();
        localList = (List)localLinkedList;
        localList.add(localObject2);
        localObject3 = null;
      }
      for (;;)
      {
        if ((localList.size() > 0) && (localObject3 == null))
        {
          localObject1 = (View)localLinkedList.poll();
          if (localObject1 != null)
          {
            Object localObject5;
            if ((i != 0) || (localObject1 != localObject2))
            {
              localObject5 = com.tencent.mm.view.refreshLayout.f.a.agRg;
              if (com.tencent.mm.view.refreshLayout.f.a.aU((View)localObject1))
              {
                localObject3 = localObject1;
                continue;
                i = 0;
                break;
              }
            }
            if ((localObject1 instanceof ViewGroup))
            {
              int j = 0;
              int m = ((ViewGroup)localObject1).getChildCount();
              if (m > 0) {
                for (;;)
                {
                  int k = j + 1;
                  localObject5 = ((ViewGroup)localObject1).getChildAt(j);
                  s.s(localObject5, "group.getChildAt(j)");
                  localList.add(localObject5);
                  if (k >= m) {
                    break;
                  }
                  j = k;
                }
              }
            }
          }
        }
      }
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = localObject2;
      }
      if (localObject1 == localObject4) {
        break;
      }
      if (!bool) {
        a((View)localObject1, parame, (com.tencent.mm.view.refreshLayout.d.a)this);
      }
      localObject4 = localObject1;
      localObject2 = localObject1;
    }
    if (localObject4 != null) {
      mG(localObject4);
    }
    AppMethodBeat.o(235196);
  }
  
  public final boolean egB()
  {
    AppMethodBeat.i(235185);
    if ((this.agRx) && (this.agRv.mE(this.view)))
    {
      AppMethodBeat.o(235185);
      return true;
    }
    AppMethodBeat.o(235185);
    return false;
  }
  
  public final View getView()
  {
    return this.view;
  }
  
  public final boolean jNA()
  {
    AppMethodBeat.i(235183);
    if ((this.mEnableRefresh) && (this.agRv.mD(this.view)))
    {
      AppMethodBeat.o(235183);
      return true;
    }
    AppMethodBeat.o(235183);
    return false;
  }
  
  public final View jNz()
  {
    return this.agRy;
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(235208);
    s.u(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(235208);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    try
    {
      float f = i - this.agRw;
      f = this.agRy.getScaleY() * f;
      if ((this.agRy instanceof AbsListView))
      {
        ((AbsListView)this.agRy).scrollListBy((int)f);
        label89:
        this.agRw = i;
        AppMethodBeat.o(235208);
        return;
      }
      this.agRy.scrollBy(0, (int)f);
    }
    finally
    {
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.h.a
 * JD-Core Version:    0.7.0.1
 */