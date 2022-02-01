package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.support.v4.view.k;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileListView;", "Landroid/widget/ListView;", "Landroid/support/v4/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mScrollingChildHelper", "Landroid/support/v4/view/NestedScrollingChildHelper;", "dispatchNestedFling", "", "velocityX", "", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "hasNestedScrollingParent", "isNestedScrollingEnabled", "setNestedScrollingEnabled", "", "enabled", "startNestedScroll", "axes", "stopNestedScroll", "app_release"})
public final class BizProfileListView
  extends ListView
  implements k
{
  private final android.support.v4.view.l atb;
  
  public BizProfileListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(230878);
    this.atb = new android.support.v4.view.l((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(230878);
  }
  
  public BizProfileListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230879);
    this.atb = new android.support.v4.view.l((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(230879);
  }
  
  public final void aM(int paramInt)
  {
    AppMethodBeat.i(230877);
    this.atb.aM(paramInt);
    AppMethodBeat.o(230877);
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(230875);
    paramBoolean = this.atb.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(230875);
    return paramBoolean;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(230876);
    boolean bool = this.atb.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(230876);
    return bool;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(230874);
    boolean bool = this.atb.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(230874);
    return bool;
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(230873);
    boolean bool = this.atb.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(230873);
    return bool;
  }
  
  public final boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(230872);
    boolean bool = this.atb.hasNestedScrollingParent();
    AppMethodBeat.o(230872);
    return bool;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(230869);
    boolean bool = this.atb.isNestedScrollingEnabled();
    AppMethodBeat.o(230869);
    return bool;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(230868);
    this.atb.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(230868);
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(230870);
    boolean bool = this.atb.startNestedScroll(paramInt);
    AppMethodBeat.o(230870);
    return bool;
  }
  
  public final void stopNestedScroll()
  {
    AppMethodBeat.i(230871);
    this.atb.stopNestedScroll();
    AppMethodBeat.o(230871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileListView
 * JD-Core Version:    0.7.0.1
 */