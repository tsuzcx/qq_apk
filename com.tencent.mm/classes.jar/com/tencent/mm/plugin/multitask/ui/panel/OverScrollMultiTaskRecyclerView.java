package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBehavior", "Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "getBehavior", "ui-multitask_release"})
public final class OverScrollMultiTaskRecyclerView
  extends WxRecyclerView
  implements CoordinatorLayout.a
{
  private final OverScrollMultiTaskVerticalBehavior FLK;
  
  public OverScrollMultiTaskRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197479);
    this.FLK = new OverScrollMultiTaskVerticalBehavior();
    AppMethodBeat.o(197479);
  }
  
  public OverScrollMultiTaskRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197480);
    this.FLK = new OverScrollMultiTaskVerticalBehavior();
    AppMethodBeat.o(197480);
  }
  
  public final OverScrollMultiTaskVerticalBehavior getBehavior()
  {
    return this.FLK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView
 * JD-Core Version:    0.7.0.1
 */