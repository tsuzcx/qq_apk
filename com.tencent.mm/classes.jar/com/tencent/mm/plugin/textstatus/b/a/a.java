package com.tencent.mm.plugin.textstatus.b.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/album/AlbumItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "longClickListener", "Landroid/view/View$OnLongClickListener;", "(Landroid/view/View$OnLongClickListener;)V", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.textstatus.h.a.a>
{
  public static final a.a Tkg;
  private View.OnLongClickListener AkV;
  
  static
  {
    AppMethodBeat.i(290261);
    Tkg = new a.a((byte)0);
    AppMethodBeat.o(290261);
  }
  
  public a(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(290253);
    this.AkV = paramOnLongClickListener;
    AppMethodBeat.o(290253);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(290282);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    Log.i("MicroMsg.TextStatus.AlbumItemConvert", "onCreateViewHolder");
    LinearLayout localLinearLayout = (LinearLayout)paramj.caK;
    x localx = x.hFJ();
    paramRecyclerView = ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getStatusCardView(paramRecyclerView.getContext(), localx);
    localLinearLayout.addView(paramRecyclerView.getView());
    paramj.tag = paramRecyclerView;
    paramRecyclerView = paramRecyclerView.getView().getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(290282);
      throw paramRecyclerView;
    }
    ((LinearLayout.LayoutParams)paramRecyclerView).width = -1;
    AppMethodBeat.o(290282);
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.a.a
 * JD-Core Version:    0.7.0.1
 */