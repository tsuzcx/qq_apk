package com.tencent.mm.plugin.repairer.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/model/RepairerItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerConvertDataItem;", "onItemClickListener", "Lcom/tencent/mm/plugin/repairer/ui/model/OnItemClickListener;", "(Lcom/tencent/mm/plugin/repairer/ui/model/OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/repairer/ui/model/OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "dataItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ui-repairer_release"})
public final class d
  extends e<b>
{
  final a Iyg;
  
  public d(a parama)
  {
    AppMethodBeat.i(226686);
    this.Iyg = parama;
    AppMethodBeat.o(226686);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(226676);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(226676);
  }
  
  public final int getLayoutId()
  {
    return b.b.IwO;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, int paramInt, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227485);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/model/RepairerItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Iyh.Iyg.a(this.jEN, this.Iyi);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/model/RepairerItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.b.d
 * JD-Core Version:    0.7.0.1
 */