package com.tencent.mm.plugin.textstatus.b.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h.a;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.ui.h;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetHeaderCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "onItemClickListener", "Landroid/view/View$OnClickListener;", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "(Landroid/view/View$OnClickListener;Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
public final class a
  extends e<com.tencent.mm.plugin.textstatus.g.c.a>
{
  private final View.OnClickListener MAG;
  private final h.a MAH;
  
  public a(View.OnClickListener paramOnClickListener, h.a parama)
  {
    AppMethodBeat.i(237366);
    this.MAG = paramOnClickListener;
    this.MAH = parama;
    AppMethodBeat.o(237366);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(237363);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new h(paramRecyclerView);
    parami.setTag(paramRecyclerView);
    parami = parami.amk;
    if (parami == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(237363);
      throw paramRecyclerView;
    }
    ((RelativeLayout)parami).addView(paramRecyclerView.wRV);
    paramRecyclerView = paramRecyclerView.wRV.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(237363);
      throw paramRecyclerView;
    }
    ((RelativeLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(237363);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.a
 * JD-Core Version:    0.7.0.1
 */