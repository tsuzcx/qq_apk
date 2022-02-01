package com.tencent.mm.plugin.textstatus.b.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.f.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/album/AlbumItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "longClickListener", "Landroid/view/View$OnLongClickListener;", "(Landroid/view/View$OnLongClickListener;)V", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class b
  extends e<a>
{
  public static final b.a FXP;
  private View.OnLongClickListener tib;
  
  static
  {
    AppMethodBeat.i(216101);
    FXP = new b.a((byte)0);
    AppMethodBeat.o(216101);
  }
  
  public b(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(216100);
    this.tib = paramOnLongClickListener;
    AppMethodBeat.o(216100);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216098);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    Log.i("MicroMsg.TxtStatus.AlbumItemConvert", "onCreateViewHolder");
    Object localObject = paramh.aus;
    if (localObject == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(216098);
      throw paramRecyclerView;
    }
    localObject = (LinearLayout)localObject;
    n localn = n.FXs.fvA();
    p.g(localn, "StatusShowParam.sDefaultShowParam.clone()");
    localn.fvB().wq(false).awv(6);
    paramRecyclerView = ((c)g.ah(c.class)).getStatusCardView(paramRecyclerView.getContext(), localn);
    p.g(paramRecyclerView, "cardView");
    ((LinearLayout)localObject).addView(paramRecyclerView.getView());
    paramh.setTag(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getView();
    p.g(paramRecyclerView, "cardView.view");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(216098);
      throw paramRecyclerView;
    }
    ((LinearLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(216098);
  }
  
  public final int getLayoutId()
  {
    return 2131496675;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.a.b
 * JD-Core Version:    0.7.0.1
 */