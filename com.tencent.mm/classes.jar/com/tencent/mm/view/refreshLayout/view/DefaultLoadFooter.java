package com.tencent.mm.view.refreshLayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.refreshLayout.b.d;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.e.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/view/DefaultLoadFooter;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "init", "", "onFinish", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "", "onInitialized", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "newState", "setNoMoreData", "noMoreData", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DefaultLoadFooter
  extends RelativeLayout
  implements com.tencent.mm.view.refreshLayout.b.b
{
  public DefaultLoadFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DefaultLoadFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235073);
    paramContext = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(235073);
    throw paramContext;
  }
  
  public final int a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(235079);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(235079);
    return 0;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(235088);
    s.u(paramd, "kernel");
    AppMethodBeat.o(235088);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(235091);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(235091);
  }
  
  public final void a(e parame, com.tencent.mm.view.refreshLayout.e.b paramb1, com.tencent.mm.view.refreshLayout.e.b paramb2)
  {
    AppMethodBeat.i(235082);
    s.u(parame, "refreshLayout");
    s.u(paramb1, "oldState");
    s.u(paramb2, "newState");
    AppMethodBeat.o(235082);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(235095);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(235095);
  }
  
  public final c getSpinnerStyle()
  {
    return c.agRc;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final boolean tk(boolean paramBoolean)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.view.DefaultLoadFooter
 * JD-Core Version:    0.7.0.1
 */