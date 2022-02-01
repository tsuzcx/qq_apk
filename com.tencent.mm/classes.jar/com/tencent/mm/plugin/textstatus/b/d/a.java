package com.tencent.mm.plugin.textstatus.b.d;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class a
  extends e<com.tencent.mm.plugin.textstatus.f.g.a>
{
  public static final a.a FXY;
  
  static
  {
    AppMethodBeat.i(216123);
    FXY = new a.a((byte)0);
    AppMethodBeat.o(216123);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216121);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    Object localObject = paramh.aus;
    if (localObject == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(216121);
      throw paramRecyclerView;
    }
    localObject = (RelativeLayout)localObject;
    n localn = n.FXu.fvA();
    p.g(localn, "StatusShowParam.sDefSameTopicCardParam.clone()");
    localn.awv(2);
    paramRecyclerView = ((c)g.ah(c.class)).getStatusCardView(paramRecyclerView.getContext(), localn);
    p.g(paramRecyclerView, "cardView");
    ((RelativeLayout)localObject).addView(paramRecyclerView.getView());
    paramh.setTag(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getView();
    p.g(paramRecyclerView, "cardView.view");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216121);
      throw paramRecyclerView;
    }
    ((RelativeLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(216121);
  }
  
  public final int getLayoutId()
  {
    return 2131496699;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.d.a
 * JD-Core Version:    0.7.0.1
 */