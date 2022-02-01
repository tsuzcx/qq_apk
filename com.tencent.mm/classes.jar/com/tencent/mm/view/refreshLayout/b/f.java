package com.tencent.mm.view.refreshLayout.b;

import android.view.View;
import com.tencent.mm.view.refreshLayout.e.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshPlugin;", "Lcom/tencent/mm/view/refreshLayout/listener/OnStateChangedListener;", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "onFinish", "", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "", "onInitialized", "", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
  extends com.tencent.mm.view.refreshLayout.d.d
{
  public abstract int a(e parame, boolean paramBoolean);
  
  public abstract void a(d paramd);
  
  public abstract void a(e parame);
  
  public abstract void b(e parame);
  
  public abstract c getSpinnerStyle();
  
  public abstract View getView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.b.f
 * JD-Core Version:    0.7.0.1
 */