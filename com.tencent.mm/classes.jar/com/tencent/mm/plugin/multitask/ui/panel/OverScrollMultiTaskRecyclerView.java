package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.a;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/design/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBehavior", "Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "getBehavior", "ui-multitask_release"})
public final class OverScrollMultiTaskRecyclerView
  extends WxRecyclerView
  implements CoordinatorLayout.a
{
  private final OverScrollMultiTaskVerticalBehavior Afh;
  
  public OverScrollMultiTaskRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236596);
    this.Afh = new OverScrollMultiTaskVerticalBehavior();
    AppMethodBeat.o(236596);
  }
  
  public OverScrollMultiTaskRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236597);
    this.Afh = new OverScrollMultiTaskVerticalBehavior();
    AppMethodBeat.o(236597);
  }
  
  public final OverScrollMultiTaskVerticalBehavior getBehavior()
  {
    return this.Afh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView
 * JD-Core Version:    0.7.0.1
 */