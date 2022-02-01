package com.tencent.mm.plugin.textstatus.b;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatHeaderItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<com.tencent.mm.plugin.textstatus.h.e.b>
{
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290269);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290269);
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.b
 * JD-Core Version:    0.7.0.1
 */