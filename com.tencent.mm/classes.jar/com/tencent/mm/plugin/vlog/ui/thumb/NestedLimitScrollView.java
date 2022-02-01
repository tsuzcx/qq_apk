package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/NestedLimitScrollView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "leftLimit", "getLeftLimit", "()I", "setLeftLimit", "(I)V", "rightLimit", "getRightLimit", "setRightLimit", "targetChild", "Landroid/view/View;", "targetChildWidth", "clampScroll", "", "getCanScroll", "dx", "onFinishInflate", "onLayout", "changed", "", "left", "top", "right", "bottom", "onNestedPreScroll", "target", "dy", "comsumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NestedLimitScrollView
  extends FrameLayout
  implements p
{
  private final String TAG;
  private View UpV;
  private int UpW;
  private int UpX;
  private int UpY;
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281627);
    AppMethodBeat.o(281627);
  }
  
  public NestedLimitScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281622);
    this.TAG = "MicroMsg.ThumbCropView";
    if (getChildCount() > 0) {}
    for (paramContext = getChildAt(0);; paramContext = null)
    {
      this.UpV = paramContext;
      AppMethodBeat.o(281622);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(281687);
    s.u(paramView, "target");
    Log.i(this.TAG, "onNestedScroll: " + paramInt1 + ", " + paramInt3 + ", " + getScrollX());
    if (getScrollX() + paramInt3 > this.UpY)
    {
      setScrollX(this.UpY);
      AppMethodBeat.o(281687);
      return;
    }
    if (getScrollX() + paramInt3 < -this.UpX)
    {
      setScrollX(-this.UpX);
      AppMethodBeat.o(281687);
      return;
    }
    setScrollX(getScrollX() + paramInt3);
    AppMethodBeat.o(281687);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(281680);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "comsumed");
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
      AppMethodBeat.o(281680);
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
    AppMethodBeat.i(281668);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    Log.i(this.TAG, "onStartNestedScroll: ");
    if (paramInt1 == 1)
    {
      AppMethodBeat.o(281668);
      return true;
    }
    AppMethodBeat.o(281668);
    return false;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281674);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    Log.i(this.TAG, "onNestedScrollAccepted: ");
    AppMethodBeat.o(281674);
  }
  
  public final int getLeftLimit()
  {
    return this.UpX;
  }
  
  public final int getRightLimit()
  {
    return this.UpY;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(281691);
    s.u(paramView, "target");
    Log.i(this.TAG, "onStopNestedScroll: ");
    AppMethodBeat.o(281691);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(281654);
    if (getChildCount() > 0) {}
    for (View localView = getChildAt(0);; localView = null)
    {
      this.UpV = localView;
      super.onFinishInflate();
      AppMethodBeat.o(281654);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(281661);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.UpV;
    if (localView == null) {}
    for (paramInt1 = 0;; paramInt1 = localView.getWidth())
    {
      this.UpW = paramInt1;
      AppMethodBeat.o(281661);
      return;
    }
  }
  
  public final void setLeftLimit(int paramInt)
  {
    this.UpX = paramInt;
  }
  
  public final void setRightLimit(int paramInt)
  {
    this.UpY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.NestedLimitScrollView
 * JD-Core Version:    0.7.0.1
 */