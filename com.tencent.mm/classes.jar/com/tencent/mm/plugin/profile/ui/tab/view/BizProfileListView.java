package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import androidx.core.g.l;
import androidx.core.g.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileListView;", "Landroid/widget/ListView;", "Landroidx/core/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mScrollingChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "dispatchNestedFling", "", "velocityX", "", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "hasNestedScrollingParent", "isNestedScrollingEnabled", "setNestedScrollingEnabled", "", "enabled", "startNestedScroll", "axes", "stopNestedScroll", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileListView
  extends ListView
  implements l
{
  private final n bZw;
  
  public BizProfileListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(305983);
    this.bZw = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(305983);
  }
  
  public BizProfileListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(305996);
    this.bZw = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(305996);
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(306073);
    paramBoolean = this.bZw.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(306073);
    return paramBoolean;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(306084);
    boolean bool = this.bZw.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(306084);
    return bool;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(306062);
    boolean bool = this.bZw.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(306062);
    return bool;
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(306053);
    boolean bool = this.bZw.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(306053);
    return bool;
  }
  
  public final void em(int paramInt)
  {
    AppMethodBeat.i(306097);
    this.bZw.em(paramInt);
    AppMethodBeat.o(306097);
  }
  
  public final boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(306043);
    boolean bool = this.bZw.en(0);
    AppMethodBeat.o(306043);
    return bool;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    return this.bZw.bts;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(306004);
    this.bZw.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(306004);
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(306020);
    boolean bool = this.bZw.az(paramInt, 0);
    AppMethodBeat.o(306020);
    return bool;
  }
  
  public final void stopNestedScroll()
  {
    AppMethodBeat.i(306030);
    this.bZw.em(0);
    AppMethodBeat.o(306030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileListView
 * JD-Core Version:    0.7.0.1
 */