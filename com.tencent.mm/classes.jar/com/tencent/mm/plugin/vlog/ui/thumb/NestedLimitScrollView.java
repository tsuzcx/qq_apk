package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/NestedLimitScrollView;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "leftLimit", "getLeftLimit", "()I", "setLeftLimit", "(I)V", "rightLimit", "getRightLimit", "setRightLimit", "targetChild", "Landroid/view/View;", "targetChildWidth", "clampScroll", "", "getCanScroll", "dx", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onNestedPreScroll", "target", "dy", "comsumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "plugin-vlog_release"})
public final class NestedLimitScrollView
  extends FrameLayout
  implements n
{
  private View Lvp;
  private int Lvq;
  private int Lvr;
  private int Lvs;
  private final String TAG;
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(201244);
    AppMethodBeat.o(201244);
  }
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201243);
    this.TAG = "MicroMsg.ThumbCropView";
    if (getChildCount() > 0) {}
    for (paramContext = getChildAt(0);; paramContext = null)
    {
      this.Lvp = paramContext;
      AppMethodBeat.o(201243);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(201241);
    k.h(paramView, "target");
    ad.i(this.TAG, "onNestedScroll: " + paramInt1 + ", " + paramInt3 + ", " + getScrollX());
    if (getScrollX() + paramInt3 > this.Lvs)
    {
      setScrollX(this.Lvs);
      AppMethodBeat.o(201241);
      return;
    }
    if (getScrollX() + paramInt3 < -this.Lvr)
    {
      setScrollX(-this.Lvr);
      AppMethodBeat.o(201241);
      return;
    }
    setScrollX(getScrollX() + paramInt3);
    AppMethodBeat.o(201241);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(201240);
    k.h(paramView, "target");
    k.h(paramArrayOfInt, "comsumed");
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
      AppMethodBeat.o(201240);
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
    AppMethodBeat.i(201238);
    k.h(paramView1, "child");
    k.h(paramView2, "target");
    ad.i(this.TAG, "onStartNestedScroll: ");
    if (paramInt1 == 1)
    {
      AppMethodBeat.o(201238);
      return true;
    }
    AppMethodBeat.o(201238);
    return false;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201239);
    k.h(paramView1, "child");
    k.h(paramView2, "target");
    ad.i(this.TAG, "onNestedScrollAccepted: ");
    AppMethodBeat.o(201239);
  }
  
  public final int getLeftLimit()
  {
    return this.Lvr;
  }
  
  public final int getRightLimit()
  {
    return this.Lvs;
  }
  
  public final void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(201242);
    k.h(paramView, "target");
    ad.i(this.TAG, "onStopNestedScroll: ");
    AppMethodBeat.o(201242);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(201236);
    if (getChildCount() > 0) {}
    for (View localView = getChildAt(0);; localView = null)
    {
      this.Lvp = localView;
      super.onFinishInflate();
      AppMethodBeat.o(201236);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201237);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.Lvp;
    if (localView != null) {}
    for (paramInt1 = localView.getWidth();; paramInt1 = 0)
    {
      this.Lvq = paramInt1;
      AppMethodBeat.o(201237);
      return;
    }
  }
  
  public final void setLeftLimit(int paramInt)
  {
    this.Lvr = paramInt;
  }
  
  public final void setRightLimit(int paramInt)
  {
    this.Lvs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.NestedLimitScrollView
 * JD-Core Version:    0.7.0.1
 */