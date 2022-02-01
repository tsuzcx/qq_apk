package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/NestedLimitScrollView;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "leftLimit", "getLeftLimit", "()I", "setLeftLimit", "(I)V", "rightLimit", "getRightLimit", "setRightLimit", "targetChild", "Landroid/view/View;", "targetChildWidth", "clampScroll", "", "getCanScroll", "dx", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onNestedPreScroll", "target", "dy", "comsumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "plugin-vlog_release"})
public final class NestedLimitScrollView
  extends FrameLayout
  implements n
{
  private View BUv;
  private int BUw;
  private int BUx;
  private int BUy;
  private final String TAG;
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(196856);
    AppMethodBeat.o(196856);
  }
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196855);
    this.TAG = "MicroMsg.ThumbCropView";
    if (getChildCount() > 0) {}
    for (paramContext = getChildAt(0);; paramContext = null)
    {
      this.BUv = paramContext;
      AppMethodBeat.o(196855);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(196853);
    p.h(paramView, "target");
    ad.i(this.TAG, "onNestedScroll: " + paramInt1 + ", " + paramInt3 + ", " + getScrollX());
    if (getScrollX() + paramInt3 > this.BUy)
    {
      setScrollX(this.BUy);
      AppMethodBeat.o(196853);
      return;
    }
    if (getScrollX() + paramInt3 < -this.BUx)
    {
      setScrollX(-this.BUx);
      AppMethodBeat.o(196853);
      return;
    }
    setScrollX(getScrollX() + paramInt3);
    AppMethodBeat.o(196853);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(196852);
    p.h(paramView, "target");
    p.h(paramArrayOfInt, "comsumed");
    ad.i(this.TAG, "onNestedPreScroll: " + paramInt1 + ", " + getScrollX());
    if ((paramInt1 > 0) && (getScrollX() < 0))
    {
      paramInt3 = paramInt1;
      if (getScrollX() + paramInt1 > 0) {
        paramInt3 = -getScrollX();
      }
    }
    for (;;)
    {
      paramArrayOfInt[0] = paramInt3;
      paramInt1 = getScrollX();
      setScrollX(paramArrayOfInt[0] + paramInt1);
      paramArrayOfInt[1] = paramInt2;
      AppMethodBeat.o(196852);
      return;
      if ((paramInt1 < 0) && (getScrollX() > 0))
      {
        paramInt3 = paramInt1;
        if (getScrollX() + paramInt1 < 0) {
          paramInt3 = -getScrollX();
        }
      }
      else
      {
        paramInt3 = 0;
      }
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196850);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    ad.i(this.TAG, "onStartNestedScroll: ");
    if (paramInt1 == 1)
    {
      AppMethodBeat.o(196850);
      return true;
    }
    AppMethodBeat.o(196850);
    return false;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196851);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    ad.i(this.TAG, "onNestedScrollAccepted: ");
    AppMethodBeat.o(196851);
  }
  
  public final int getLeftLimit()
  {
    return this.BUx;
  }
  
  public final int getRightLimit()
  {
    return this.BUy;
  }
  
  public final void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(196854);
    p.h(paramView, "target");
    ad.i(this.TAG, "onStopNestedScroll: ");
    AppMethodBeat.o(196854);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(196848);
    if (getChildCount() > 0) {}
    for (View localView = getChildAt(0);; localView = null)
    {
      this.BUv = localView;
      super.onFinishInflate();
      AppMethodBeat.o(196848);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196849);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.BUv;
    if (localView != null) {}
    for (paramInt1 = localView.getWidth();; paramInt1 = 0)
    {
      this.BUw = paramInt1;
      AppMethodBeat.o(196849);
      return;
    }
  }
  
  public final void setLeftLimit(int paramInt)
  {
    this.BUx = paramInt;
  }
  
  public final void setRightLimit(int paramInt)
  {
    this.BUy = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.NestedLimitScrollView
 * JD-Core Version:    0.7.0.1
 */