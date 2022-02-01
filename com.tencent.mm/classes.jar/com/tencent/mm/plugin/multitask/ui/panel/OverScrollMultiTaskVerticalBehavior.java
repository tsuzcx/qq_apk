package com.tencent.mm.plugin.multitask.ui.panel;

import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.d.a;
import com.tencent.mm.ui.c.a.b.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "mMultiTaskItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onNestedScroll", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "setMultiTaskItemListener", "itemListener", "Companion", "ui-multitask_release"})
public final class OverScrollMultiTaskVerticalBehavior
  extends CoordinatorLayout.Behavior<WxRecyclerView>
{
  public static final a FLM;
  public a FLL;
  
  static
  {
    AppMethodBeat.i(196473);
    FLM = new a((byte)0);
    AppMethodBeat.o(196473);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onUpdate"})
  static final class b
    implements b.a
  {
    b(OverScrollMultiTaskVerticalBehavior paramOverScrollMultiTaskVerticalBehavior) {}
    
    public final void bB(float paramFloat)
    {
      AppMethodBeat.i(197461);
      a locala = OverScrollMultiTaskVerticalBehavior.a(this.FLN);
      if (locala != null)
      {
        locala.fbJ();
        AppMethodBeat.o(197461);
        return;
      }
      AppMethodBeat.o(197461);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onUpdate"})
  static final class c
    implements b.a
  {
    c(OverScrollMultiTaskVerticalBehavior paramOverScrollMultiTaskVerticalBehavior) {}
    
    public final void bB(float paramFloat)
    {
      AppMethodBeat.i(196883);
      a locala = OverScrollMultiTaskVerticalBehavior.a(this.FLN);
      if (locala != null)
      {
        locala.fbJ();
        AppMethodBeat.o(196883);
        return;
      }
      AppMethodBeat.o(196883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskVerticalBehavior
 * JD-Core Version:    0.7.0.1
 */