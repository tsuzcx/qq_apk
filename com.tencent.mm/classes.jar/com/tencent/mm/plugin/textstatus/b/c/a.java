package com.tencent.mm.plugin.textstatus.b.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.f.a;
import com.tencent.mm.plugin.textstatus.ui.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetHeaderCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "onItemClickListener", "Landroid/view/View$OnClickListener;", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "(Landroid/view/View$OnClickListener;Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
public final class a
  extends e<com.tencent.mm.plugin.textstatus.f.d.a>
{
  private final View.OnClickListener FXS;
  private final f.a FXT;
  
  public a(View.OnClickListener paramOnClickListener, f.a parama)
  {
    AppMethodBeat.i(216112);
    this.FXS = paramOnClickListener;
    this.FXT = parama;
    AppMethodBeat.o(216112);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216110);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramRecyclerView = new f(paramRecyclerView);
    paramh.setTag(paramRecyclerView);
    paramh = paramh.aus;
    if (paramh == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(216110);
      throw paramRecyclerView;
    }
    ((RelativeLayout)paramh).addView(paramRecyclerView.tlx);
    paramRecyclerView = paramRecyclerView.tlx.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216110);
      throw paramRecyclerView;
    }
    ((RelativeLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(216110);
  }
  
  public final int getLayoutId()
  {
    return 2131496693;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.a
 * JD-Core Version:    0.7.0.1
 */