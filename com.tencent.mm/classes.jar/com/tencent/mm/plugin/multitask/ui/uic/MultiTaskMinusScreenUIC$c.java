package com.tencent.mm.plugin.multitask.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "ui-multitask_release"})
public final class MultiTaskMinusScreenUIC$c
  extends WxRecyclerAdapter<a>
{
  MultiTaskMinusScreenUIC$c(f paramf, ArrayList paramArrayList, boolean paramBoolean)
  {
    super(paramArrayList, paramBoolean, true);
  }
  
  public final void n(h paramh)
  {
    AppMethodBeat.i(236604);
    p.h(paramh, "holder");
    super.n(paramh);
    MultiTaskMinusScreenUIC.q(paramh);
    Log.d("RecyclerViewAdapterEx", "onViewAttachedToWindow, posttion: " + paramh.lQ());
    AppMethodBeat.o(236604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC.c
 * JD-Core Version:    0.7.0.1
 */