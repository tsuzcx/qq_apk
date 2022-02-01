package com.tencent.mm.ui.contact;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/RecentForwardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/contact/RecentForwardItemConvertData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends f<ah>
{
  public static final ag.a afhi;
  
  static
  {
    AppMethodBeat.i(252802);
    afhi = new ag.a((byte)0);
    AppMethodBeat.o(252802);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(252805);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(252805);
  }
  
  public final int getLayoutId()
  {
    return a.f.recent_foward_horizontal_list_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ag
 * JD-Core Version:    0.7.0.1
 */