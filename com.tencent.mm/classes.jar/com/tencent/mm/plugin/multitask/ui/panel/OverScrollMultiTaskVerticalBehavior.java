package com.tencent.mm.plugin.multitask.ui.panel;

import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.d.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "mMultiTaskItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onNestedScroll", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "setMultiTaskItemListener", "itemListener", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OverScrollMultiTaskVerticalBehavior
  extends CoordinatorLayout.Behavior<WxRecyclerView>
{
  public static final OverScrollMultiTaskVerticalBehavior.a LGQ;
  public a LGR;
  
  static
  {
    AppMethodBeat.i(304561);
    LGQ = new OverScrollMultiTaskVerticalBehavior.a((byte)0);
    AppMethodBeat.o(304561);
  }
  
  private static final void a(OverScrollMultiTaskVerticalBehavior paramOverScrollMultiTaskVerticalBehavior, float paramFloat)
  {
    AppMethodBeat.i(304546);
    s.u(paramOverScrollMultiTaskVerticalBehavior, "this$0");
    paramOverScrollMultiTaskVerticalBehavior = paramOverScrollMultiTaskVerticalBehavior.LGR;
    if (paramOverScrollMultiTaskVerticalBehavior != null) {
      paramOverScrollMultiTaskVerticalBehavior.gkN();
    }
    AppMethodBeat.o(304546);
  }
  
  private static final void b(OverScrollMultiTaskVerticalBehavior paramOverScrollMultiTaskVerticalBehavior, float paramFloat)
  {
    AppMethodBeat.i(304554);
    s.u(paramOverScrollMultiTaskVerticalBehavior, "this$0");
    paramOverScrollMultiTaskVerticalBehavior = paramOverScrollMultiTaskVerticalBehavior.LGR;
    if (paramOverScrollMultiTaskVerticalBehavior != null) {
      paramOverScrollMultiTaskVerticalBehavior.gkN();
    }
    AppMethodBeat.o(304554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskVerticalBehavior
 * JD-Core Version:    0.7.0.1
 */