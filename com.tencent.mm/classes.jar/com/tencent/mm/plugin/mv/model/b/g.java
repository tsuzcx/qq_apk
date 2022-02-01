package com.tencent.mm.plugin.mv.model.b;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewSelectedItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "()V", "getLayoutId", "", "getShowDuration", "", "seconds", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f<e>
{
  private static String adT(int paramInt)
  {
    AppMethodBeat.i(286206);
    String str2 = String.valueOf(paramInt % 60);
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = s.X("0", str2);
    }
    str1 = paramInt / 60 + ':' + str1;
    AppMethodBeat.o(286206);
    return str1;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(286228);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(286228);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.g
 * JD-Core Version:    0.7.0.1
 */