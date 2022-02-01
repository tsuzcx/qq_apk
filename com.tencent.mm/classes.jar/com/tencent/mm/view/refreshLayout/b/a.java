package com.tencent.mm.view.refreshLayout.b;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshContentPlugin;", "", "scrollableView", "Landroid/view/View;", "getScrollableView", "()Landroid/view/View;", "view", "getView", "canLoadMore", "", "canRefresh", "moveSpinner", "", "spinner", "", "onActionDown", "e", "Landroid/view/MotionEvent;", "scrollContentWhenFinished", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "setEnableLoadMoreWhenContentNotFull", "enable", "setScrollBoundaryDecider", "boundary", "Lcom/tencent/mm/view/refreshLayout/interfaces/IScrollBoundaryDecider;", "setUpPlugin", "layout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void Og(boolean paramBoolean);
  
  public abstract void aGn(int paramInt);
  
  public abstract ValueAnimator.AnimatorUpdateListener aGo(int paramInt);
  
  public abstract void aN(MotionEvent paramMotionEvent);
  
  public abstract void c(e parame);
  
  public abstract boolean egB();
  
  public abstract View getView();
  
  public abstract boolean jNA();
  
  public abstract View jNz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.b.a
 * JD-Core Version:    0.7.0.1
 */