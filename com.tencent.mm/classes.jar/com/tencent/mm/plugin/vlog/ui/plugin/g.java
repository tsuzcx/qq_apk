package com.tencent.mm.plugin.vlog.ui.plugin;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.effect.e;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "items", "", "plugin-vlog_release"})
public final class g
  extends RecyclerView.a<h>
{
  private final LinkedList<e> gjQ;
  m<? super Integer, ? super e, z> sLA;
  
  public g()
  {
    AppMethodBeat.i(191671);
    this.gjQ = new LinkedList();
    AppMethodBeat.o(191671);
  }
  
  public final void V(List<? extends e> paramList)
  {
    AppMethodBeat.i(191666);
    p.h(paramList, "items");
    this.gjQ.clear();
    this.gjQ.addAll((Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(191666);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(191669);
    int i = this.gjQ.size();
    AppMethodBeat.o(191669);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(191667);
    paramInt = ((e)this.gjQ.get(paramInt)).type;
    AppMethodBeat.o(191667);
    return paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(g paramg, int paramInt, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191665);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.CeK.sLA;
      if (paramView != null) {
        paramView.p(Integer.valueOf(this.gke), this.CeL);
      }
      a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191665);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.g
 * JD-Core Version:    0.7.0.1
 */