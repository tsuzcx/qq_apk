package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBehavior", "Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "getBehavior", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OverScrollMultiTaskRecyclerView
  extends WxRecyclerView
  implements CoordinatorLayout.a
{
  private final OverScrollMultiTaskVerticalBehavior LGP;
  
  public OverScrollMultiTaskRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304478);
    this.LGP = new OverScrollMultiTaskVerticalBehavior();
    AppMethodBeat.o(304478);
  }
  
  public OverScrollMultiTaskRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304488);
    this.LGP = new OverScrollMultiTaskVerticalBehavior();
    AppMethodBeat.o(304488);
  }
  
  public final OverScrollMultiTaskVerticalBehavior getBehavior()
  {
    return this.LGP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView
 * JD-Core Version:    0.7.0.1
 */