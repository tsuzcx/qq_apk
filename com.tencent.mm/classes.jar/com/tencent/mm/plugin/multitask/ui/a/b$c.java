package com.tencent.mm.plugin.multitask.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "ui-multitask_release"})
public final class b$c
  extends WxRecyclerAdapter<a>
{
  b$c(f paramf, ArrayList paramArrayList)
  {
    super(paramArrayList, localArrayList, true);
  }
  
  public final void p(i parami)
  {
    AppMethodBeat.i(197562);
    p.k(parami, "holder");
    super.p(parami);
    b.t(parami);
    Log.d("RecyclerViewAdapterEx", "onViewAttachedToWindow, posttion: " + parami.mc());
    AppMethodBeat.o(197562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.b.c
 * JD-Core Version:    0.7.0.1
 */