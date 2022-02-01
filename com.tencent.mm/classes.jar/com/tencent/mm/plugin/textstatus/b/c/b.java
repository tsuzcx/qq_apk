package com.tencent.mm.plugin.textstatus.b.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.g;
import com.tencent.mm.plugin.textstatus.k.n;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetHeaderSetConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "clickListener", "Landroid/view/View$OnClickListener;", "(Landroid/view/View$OnClickListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
public final class b
  extends e<com.tencent.mm.plugin.textstatus.g.c.a>
{
  private final View.OnClickListener dig;
  
  public b(View.OnClickListener paramOnClickListener)
  {
    this.dig = paramOnClickListener;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(232288);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    Object localObject = parami.amk;
    p.j(localObject, "holder.itemView");
    paramInt = com.tencent.mm.ci.a.fromDPToPix(((View)localObject).getContext(), 12.0F);
    localObject = n.MOY;
    n.B(parami.amk, paramInt);
    parami = (ImageView)parami.RD(b.e.Mvd);
    localObject = paramRecyclerView.getContext().getDrawable(b.g.icons_outlined_add);
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    parami.setImageDrawable(au.e((Drawable)localObject, paramRecyclerView.getResources().getColor(b.b.white)));
    AppMethodBeat.o(232288);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.b
 * JD-Core Version:    0.7.0.1
 */