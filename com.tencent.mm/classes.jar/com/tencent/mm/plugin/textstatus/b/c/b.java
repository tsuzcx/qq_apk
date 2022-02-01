package com.tencent.mm.plugin.textstatus.b.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.f;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetHeaderSetConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "clickListener", "Landroid/view/View$OnClickListener;", "(Landroid/view/View$OnClickListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
public final class b
  extends e<com.tencent.mm.plugin.textstatus.f.d.a>
{
  private final View.OnClickListener dec;
  
  public b(View.OnClickListener paramOnClickListener)
  {
    this.dec = paramOnClickListener;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216113);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    Object localObject = paramh.aus;
    p.g(localObject, "holder.itemView");
    paramInt = com.tencent.mm.cb.a.fromDPToPix(((View)localObject).getContext(), 12.0F);
    localObject = f.Ggk;
    f.B(paramh.aus, paramInt);
    paramh = (ImageView)paramh.Mn(2131302478);
    localObject = paramRecyclerView.getContext().getDrawable(2131690727);
    paramRecyclerView = paramRecyclerView.getContext();
    p.g(paramRecyclerView, "recyclerView.context");
    paramh.setImageDrawable(ar.e((Drawable)localObject, paramRecyclerView.getResources().getColor(2131101424)));
    AppMethodBeat.o(216113);
  }
  
  public final int getLayoutId()
  {
    return 2131496694;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.b
 * JD-Core Version:    0.7.0.1
 */