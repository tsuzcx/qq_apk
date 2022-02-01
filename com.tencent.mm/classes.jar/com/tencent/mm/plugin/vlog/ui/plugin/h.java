package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.effect.e;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "items", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends RecyclerView.a<i>
{
  m<? super Integer, ? super e, ah> CyZ;
  private final LinkedList<e> mew;
  
  public h()
  {
    AppMethodBeat.i(282403);
    this.mew = new LinkedList();
    AppMethodBeat.o(282403);
  }
  
  private static final void a(h paramh, int paramInt, e parame, View paramView)
  {
    AppMethodBeat.i(282411);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramh);
    localb.sc(paramInt);
    localb.cH(parame);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    s.u(parame, "$item");
    paramh = paramh.CyZ;
    if (paramh != null) {
      paramh.invoke(Integer.valueOf(paramInt), parame);
    }
    a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282411);
  }
  
  public final void bz(List<? extends e> paramList)
  {
    AppMethodBeat.i(282426);
    s.u(paramList, "items");
    this.mew.clear();
    this.mew.addAll((Collection)paramList);
    this.bZE.notifyChanged();
    AppMethodBeat.o(282426);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(282434);
    int i = this.mew.size();
    AppMethodBeat.o(282434);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(282430);
    paramInt = ((e)this.mew.get(paramInt)).type;
    AppMethodBeat.o(282430);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.h
 * JD-Core Version:    0.7.0.1
 */