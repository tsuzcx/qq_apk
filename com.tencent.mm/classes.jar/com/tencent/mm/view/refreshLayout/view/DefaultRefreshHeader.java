package com.tencent.mm.view.refreshLayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.refreshLayout.b.d;
import com.tencent.mm.view.refreshLayout.b.e;
import com.tencent.mm.view.refreshLayout.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/view/DefaultRefreshHeader;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshHeader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "spinnerStyle", "Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "getSpinnerStyle", "()Lcom/tencent/mm/view/refreshLayout/status/SpinnerStyle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "init", "", "onFinish", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "success", "", "onInitialized", "kernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "height", "maxDragHeight", "onMoving", "isDragging", "percent", "", "offset", "onReleased", "onStartAnimator", "onStateChanged", "oldState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "newState", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DefaultRefreshHeader
  extends RelativeLayout
  implements com.tencent.mm.view.refreshLayout.b.c
{
  public DefaultRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DefaultRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235083);
    paramContext = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(235083);
    throw paramContext;
  }
  
  public final int a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(235104);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(235104);
    return 0;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(235120);
    s.u(paramd, "kernel");
    AppMethodBeat.o(235120);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(235127);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(235127);
  }
  
  public final void a(e parame, b paramb1, b paramb2)
  {
    AppMethodBeat.i(235110);
    s.u(parame, "refreshLayout");
    s.u(paramb1, "oldState");
    s.u(paramb2, "newState");
    AppMethodBeat.o(235110);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(235098);
    s.u(parame, "refreshLayout");
    AppMethodBeat.o(235098);
  }
  
  public final com.tencent.mm.view.refreshLayout.e.c getSpinnerStyle()
  {
    return com.tencent.mm.view.refreshLayout.e.c.agRc;
  }
  
  public final View getView()
  {
    return (View)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.view.DefaultRefreshHeader
 * JD-Core Version:    0.7.0.1
 */