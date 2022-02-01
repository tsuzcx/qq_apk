package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/NestedLimitScrollView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "leftLimit", "getLeftLimit", "()I", "setLeftLimit", "(I)V", "rightLimit", "getRightLimit", "setRightLimit", "targetChild", "Landroid/view/View;", "targetChildWidth", "clampScroll", "", "getCanScroll", "dx", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onNestedPreScroll", "target", "dy", "comsumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "plugin-vlog_release"})
public final class NestedLimitScrollView
  extends FrameLayout
  implements androidx.core.g.p
{
  private View NDv;
  private int NDw;
  private int NDx;
  private int NDy;
  private final String TAG;
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(244558);
    AppMethodBeat.o(244558);
  }
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(244557);
    this.TAG = "MicroMsg.ThumbCropView";
    if (getChildCount() > 0) {}
    for (paramContext = getChildAt(0);; paramContext = null)
    {
      this.NDv = paramContext;
      AppMethodBeat.o(244557);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(244555);
    kotlin.g.b.p.k(paramView, "target");
    Log.i(this.TAG, "onNestedScroll: " + paramInt1 + ", " + paramInt3 + ", " + getScrollX());
    if (getScrollX() + paramInt3 > this.NDy)
    {
      setScrollX(this.NDy);
      AppMethodBeat.o(244555);
      return;
    }
    if (getScrollX() + paramInt3 < -this.NDx)
    {
      setScrollX(-this.NDx);
      AppMethodBeat.o(244555);
      return;
    }
    setScrollX(getScrollX() + paramInt3);
    AppMethodBeat.o(244555);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(244553);
    kotlin.g.b.p.k(paramView, "target");
    kotlin.g.b.p.k(paramArrayOfInt, "comsumed");
    Log.i(this.TAG, "onNestedPreScroll: " + paramInt1 + ", " + getScrollX());
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
      AppMethodBeat.o(244553);
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
    AppMethodBeat.i(244551);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    Log.i(this.TAG, "onStartNestedScroll: ");
    if (paramInt1 == 1)
    {
      AppMethodBeat.o(244551);
      return true;
    }
    AppMethodBeat.o(244551);
    return false;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244552);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    Log.i(this.TAG, "onNestedScrollAccepted: ");
    AppMethodBeat.o(244552);
  }
  
  public final int getLeftLimit()
  {
    return this.NDx;
  }
  
  public final int getRightLimit()
  {
    return this.NDy;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(244556);
    kotlin.g.b.p.k(paramView, "target");
    Log.i(this.TAG, "onStopNestedScroll: ");
    AppMethodBeat.o(244556);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(244546);
    if (getChildCount() > 0) {}
    for (View localView = getChildAt(0);; localView = null)
    {
      this.NDv = localView;
      super.onFinishInflate();
      AppMethodBeat.o(244546);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(244548);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.NDv;
    if (localView != null) {}
    for (paramInt1 = localView.getWidth();; paramInt1 = 0)
    {
      this.NDw = paramInt1;
      AppMethodBeat.o(244548);
      return;
    }
  }
  
  public final void setLeftLimit(int paramInt)
  {
    this.NDx = paramInt;
  }
  
  public final void setRightLimit(int paramInt)
  {
    this.NDy = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.NestedLimitScrollView
 * JD-Core Version:    0.7.0.1
 */