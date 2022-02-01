package com.tencent.mm.plugin.multitask.ui.panel;

import android.support.design.widget.CoordinatorLayout.Behavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.d.a;
import com.tencent.mm.ui.c.a.b.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/panel/OverScrollMultiTaskVerticalBehavior;", "Landroid/support/design/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "()V", "mMultiTaskItemListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onNestedScroll", "", "coordinatorLayout", "Landroid/support/design/widget/CoordinatorLayout;", "child", "target", "Landroid/view/View;", "dxConsumed", "", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "onStartNestedScroll", "", "directTargetChild", "axes", "onStopNestedScroll", "setMultiTaskItemListener", "itemListener", "Companion", "ui-multitask_release"})
public final class OverScrollMultiTaskVerticalBehavior
  extends CoordinatorLayout.Behavior<WxRecyclerView>
{
  public static final OverScrollMultiTaskVerticalBehavior.a Afj;
  public a Afi;
  
  static
  {
    AppMethodBeat.i(236603);
    Afj = new OverScrollMultiTaskVerticalBehavior.a((byte)0);
    AppMethodBeat.o(236603);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onUpdate"})
  static final class b
    implements b.a
  {
    b(OverScrollMultiTaskVerticalBehavior paramOverScrollMultiTaskVerticalBehavior) {}
    
    public final void by(float paramFloat)
    {
      AppMethodBeat.i(236598);
      a locala = OverScrollMultiTaskVerticalBehavior.a(this.Afk);
      if (locala != null)
      {
        locala.erE();
        AppMethodBeat.o(236598);
        return;
      }
      AppMethodBeat.o(236598);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onUpdate"})
  static final class c
    implements b.a
  {
    c(OverScrollMultiTaskVerticalBehavior paramOverScrollMultiTaskVerticalBehavior) {}
    
    public final void by(float paramFloat)
    {
      AppMethodBeat.i(236599);
      a locala = OverScrollMultiTaskVerticalBehavior.a(this.Afk);
      if (locala != null)
      {
        locala.erE();
        AppMethodBeat.o(236599);
        return;
      }
      AppMethodBeat.o(236599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskVerticalBehavior
 * JD-Core Version:    0.7.0.1
 */