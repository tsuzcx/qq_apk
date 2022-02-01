package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v4.view.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/NestedLimitScrollView;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "leftLimit", "getLeftLimit", "()I", "setLeftLimit", "(I)V", "rightLimit", "getRightLimit", "setRightLimit", "targetChild", "Landroid/view/View;", "targetChildWidth", "clampScroll", "", "getCanScroll", "dx", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onNestedPreScroll", "target", "dy", "comsumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "plugin-vlog_release"})
public final class NestedLimitScrollView
  extends FrameLayout
  implements n
{
  private View Ava;
  private int Avb;
  private int Avc;
  private int Avd;
  private final String TAG;
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(207929);
    AppMethodBeat.o(207929);
  }
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207928);
    this.TAG = "MicroMsg.ThumbCropView";
    if (getChildCount() > 0) {}
    for (paramContext = getChildAt(0);; paramContext = null)
    {
      this.Ava = paramContext;
      AppMethodBeat.o(207928);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(207926);
    k.h(paramView, "target");
    ac.i(this.TAG, "onNestedScroll: " + paramInt1 + ", " + paramInt3 + ", " + getScrollX());
    if (getScrollX() + paramInt3 > this.Avd)
    {
      setScrollX(this.Avd);
      AppMethodBeat.o(207926);
      return;
    }
    if (getScrollX() + paramInt3 < -this.Avc)
    {
      setScrollX(-this.Avc);
      AppMethodBeat.o(207926);
      return;
    }
    setScrollX(getScrollX() + paramInt3);
    AppMethodBeat.o(207926);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(207925);
    k.h(paramView, "target");
    k.h(paramArrayOfInt, "comsumed");
    ac.i(this.TAG, "onNestedPreScroll: " + paramInt1 + ", " + getScrollX());
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
      AppMethodBeat.o(207925);
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
    AppMethodBeat.i(207923);
    k.h(paramView1, "child");
    k.h(paramView2, "target");
    ac.i(this.TAG, "onStartNestedScroll: ");
    if (paramInt1 == 1)
    {
      AppMethodBeat.o(207923);
      return true;
    }
    AppMethodBeat.o(207923);
    return false;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207924);
    k.h(paramView1, "child");
    k.h(paramView2, "target");
    ac.i(this.TAG, "onNestedScrollAccepted: ");
    AppMethodBeat.o(207924);
  }
  
  public final int getLeftLimit()
  {
    return this.Avc;
  }
  
  public final int getRightLimit()
  {
    return this.Avd;
  }
  
  public final void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(207927);
    k.h(paramView, "target");
    ac.i(this.TAG, "onStopNestedScroll: ");
    AppMethodBeat.o(207927);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(207921);
    if (getChildCount() > 0) {}
    for (View localView = getChildAt(0);; localView = null)
    {
      this.Ava = localView;
      super.onFinishInflate();
      AppMethodBeat.o(207921);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(207922);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.Ava;
    if (localView != null) {}
    for (paramInt1 = localView.getWidth();; paramInt1 = 0)
    {
      this.Avb = paramInt1;
      AppMethodBeat.o(207922);
      return;
    }
  }
  
  public final void setLeftLimit(int paramInt)
  {
    this.Avc = paramInt;
  }
  
  public final void setRightLimit(int paramInt)
  {
    this.Avd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.NestedLimitScrollView
 * JD-Core Version:    0.7.0.1
 */