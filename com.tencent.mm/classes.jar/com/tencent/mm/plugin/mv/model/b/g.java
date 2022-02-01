package com.tencent.mm.plugin.mv.model.b;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewSelectedItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "()V", "getLayoutId", "", "getShowDuration", "", "seconds", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"})
public final class g
  extends com.tencent.mm.view.recyclerview.e<e>
{
  private static String ZG(int paramInt)
  {
    AppMethodBeat.i(230852);
    String str2 = String.valueOf(paramInt % 60);
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = "0".concat(String.valueOf(str2));
    }
    str1 = String.valueOf(paramInt / 60) + ":" + str1;
    AppMethodBeat.o(230852);
    return str1;
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(230847);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(230847);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.g
 * JD-Core Version:    0.7.0.1
 */