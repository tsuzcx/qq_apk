package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import androidx.core.g.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileListView;", "Landroid/widget/ListView;", "Landroidx/core/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mScrollingChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "dispatchNestedFling", "", "velocityX", "", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "hasNestedScrollingParent", "isNestedScrollingEnabled", "setNestedScrollingEnabled", "", "enabled", "startNestedScroll", "axes", "stopNestedScroll", "app_release"})
public final class BizProfileListView
  extends ListView
  implements androidx.core.g.l
{
  private final n akU;
  
  public BizProfileListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219860);
    this.akU = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(219860);
  }
  
  public BizProfileListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219864);
    this.akU = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(219864);
  }
  
  public final void bw(int paramInt)
  {
    AppMethodBeat.i(219855);
    this.akU.bw(paramInt);
    AppMethodBeat.o(219855);
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(219850);
    paramBoolean = this.akU.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(219850);
    return paramBoolean;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(219853);
    boolean bool = this.akU.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(219853);
    return bool;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(219848);
    boolean bool = this.akU.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(219848);
    return bool;
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(219845);
    boolean bool = this.akU.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(219845);
    return bool;
  }
  
  public final boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(219842);
    boolean bool = this.akU.hasNestedScrollingParent();
    AppMethodBeat.o(219842);
    return bool;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(219835);
    boolean bool = this.akU.isNestedScrollingEnabled();
    AppMethodBeat.o(219835);
    return bool;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(219832);
    this.akU.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(219832);
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(219837);
    boolean bool = this.akU.startNestedScroll(paramInt);
    AppMethodBeat.o(219837);
    return bool;
  }
  
  public final void stopNestedScroll()
  {
    AppMethodBeat.i(219840);
    this.akU.stopNestedScroll();
    AppMethodBeat.o(219840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileListView
 * JD-Core Version:    0.7.0.1
 */