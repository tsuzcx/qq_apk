package com.tencent.mm.plugin.vlog.ui.plugin;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.effect.e;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "items", "", "plugin-vlog_release"})
public final class h
  extends RecyclerView.a<i>
{
  private final LinkedList<e> jEz;
  m<? super Integer, ? super e, x> yWH;
  
  public h()
  {
    AppMethodBeat.i(250258);
    this.jEz = new LinkedList();
    AppMethodBeat.o(250258);
  }
  
  public final void aa(List<? extends e> paramList)
  {
    AppMethodBeat.i(250250);
    p.k(paramList, "items");
    this.jEz.clear();
    this.jEz.addAll((Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(250250);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(250255);
    int i = this.jEz.size();
    AppMethodBeat.o(250255);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(250251);
    paramInt = ((e)this.jEz.get(paramInt)).type;
    AppMethodBeat.o(250251);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.h
 * JD-Core Version:    0.7.0.1
 */