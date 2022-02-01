package com.tencent.mm.plugin.textstatus.b.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/album/AlbumItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "longClickListener", "Landroid/view/View$OnLongClickListener;", "(Landroid/view/View$OnLongClickListener;)V", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class b
  extends e<a>
{
  public static final b.a MAt;
  private View.OnLongClickListener wOt;
  
  static
  {
    AppMethodBeat.i(235286);
    MAt = new b.a((byte)0);
    AppMethodBeat.o(235286);
  }
  
  public b(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(235284);
    this.wOt = paramOnLongClickListener;
    AppMethodBeat.o(235284);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(235279);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    Log.i("MicroMsg.TextStatus.AlbumItemConvert", "onCreateViewHolder");
    Object localObject = parami.amk;
    if (localObject == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(235279);
      throw paramRecyclerView;
    }
    localObject = (LinearLayout)localObject;
    r localr = r.gkQ();
    paramRecyclerView = ((d)com.tencent.mm.kernel.h.ag(d.class)).getStatusCardView(paramRecyclerView.getContext(), localr);
    p.j(paramRecyclerView, "cardView");
    ((LinearLayout)localObject).addView(paramRecyclerView.getView());
    parami.setTag(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getView();
    p.j(paramRecyclerView, "cardView.view");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(235279);
      throw paramRecyclerView;
    }
    ((LinearLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(235279);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.a.b
 * JD-Core Version:    0.7.0.1
 */