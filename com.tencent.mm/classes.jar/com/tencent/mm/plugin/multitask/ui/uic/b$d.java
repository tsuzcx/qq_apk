package com.tencent.mm.plugin.multitask.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "onViewAttachedToWindow", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$d
  extends WxRecyclerAdapter<a>
{
  b$d(b paramb, g paramg, ArrayList<a> paramArrayList)
  {
    super(paramg, paramArrayList, true);
  }
  
  public final void v(j paramj)
  {
    AppMethodBeat.i(304242);
    s.u(paramj, "holder");
    super.v(paramj);
    b.ac(paramj);
    Log.d("RecyclerViewAdapterEx", s.X("onViewAttachedToWindow, posttion: ", Integer.valueOf(paramj.KI())));
    AppMethodBeat.o(304242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.b.d
 * JD-Core Version:    0.7.0.1
 */