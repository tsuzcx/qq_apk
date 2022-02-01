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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "items", "", "plugin-vlog_release"})
public final class g
  extends RecyclerView.a<h>
{
  private final LinkedList<e> ghy;
  m<? super Integer, ? super e, z> sAA;
  
  public g()
  {
    AppMethodBeat.i(196212);
    this.ghy = new LinkedList();
    AppMethodBeat.o(196212);
  }
  
  public final void V(List<? extends e> paramList)
  {
    AppMethodBeat.i(196207);
    p.h(paramList, "items");
    this.ghy.clear();
    this.ghy.addAll((Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(196207);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(196210);
    int i = this.ghy.size();
    AppMethodBeat.o(196210);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(196208);
    paramInt = ((e)this.ghy.get(paramInt)).type;
    AppMethodBeat.o(196208);
    return paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(g paramg, int paramInt, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196206);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.BNl.sAA;
      if (paramView != null) {
        paramView.p(Integer.valueOf(this.ghM), this.BNm);
      }
      a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.g
 * JD-Core Version:    0.7.0.1
 */