package com.tencent.mm.plugin.vlog.ui.plugin;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.effect.e;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "items", "", "plugin-vlog_release"})
public final class i
  extends RecyclerView.a<j>
{
  private final LinkedList<e> gTV;
  m<? super Integer, ? super e, x> uAj;
  
  public i()
  {
    AppMethodBeat.i(191288);
    this.gTV = new LinkedList();
    AppMethodBeat.o(191288);
  }
  
  public final void ad(List<? extends e> paramList)
  {
    AppMethodBeat.i(191283);
    p.h(paramList, "items");
    this.gTV.clear();
    this.gTV.addAll((Collection)paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(191283);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(191286);
    int i = this.gTV.size();
    AppMethodBeat.o(191286);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(191284);
    paramInt = ((e)this.gTV.get(paramInt)).type;
    AppMethodBeat.o(191284);
    return paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(i parami, int paramInt, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191282);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.GHl.uAj;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(this.gUj), this.GHm);
      }
      a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191282);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */