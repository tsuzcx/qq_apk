package com.tencent.mm.plugin.textstatus.h.c;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.j.a;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/feed/CardFeedItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/feed/CardFeedItem;", "cardEventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;)V", "getCardEventListener", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "createViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "convertView", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onViewRecycled", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.view.recyclerview.f<c>
{
  public static final d.a Tnr;
  private final j.a Tns;
  
  static
  {
    AppMethodBeat.i(290655);
    Tnr = new d.a((byte)0);
    AppMethodBeat.o(290655);
  }
  
  public d(j.a parama)
  {
    this.Tns = parama;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(290679);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    Log.d("MicroMsg.TextStatus.CardFeedItemConvert", "onCreateViewHolder() called with: recyclerView = " + paramRecyclerView + ", holder = " + paramj + ", type = " + paramInt);
    Object localObject = (RelativeLayout)paramj.caK;
    x localx = x.hFO();
    paramRecyclerView = ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getStatusCardView(paramRecyclerView.getContext(), localx);
    ((RelativeLayout)localObject).addView(paramRecyclerView.getView(), 0);
    paramj.tag = paramRecyclerView;
    paramRecyclerView.a(this.Tns);
    localObject = paramRecyclerView.getView().getLayoutParams();
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(290679);
      throw paramRecyclerView;
    }
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    localObject = k.aeZF;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramj = ((com.tencent.mm.plugin.textstatus.ui.a.a)k.nq(paramj).q(com.tencent.mm.plugin.textstatus.ui.a.a.class)).TAE;
    s.s(paramRecyclerView, "cardView");
    paramj.add(paramRecyclerView);
    AppMethodBeat.o(290679);
  }
  
  public final com.tencent.mm.view.recyclerview.j b(RecyclerView paramRecyclerView, View paramView)
  {
    AppMethodBeat.i(290669);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramView, "convertView");
    int i = paramRecyclerView.getHeight();
    if (i != 0)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = (i - com.tencent.mm.cd.a.fromDPToPix(paramRecyclerView.getContext(), 1));
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    paramRecyclerView = new com.tencent.mm.view.recyclerview.j(paramView);
    AppMethodBeat.o(290669);
    return paramRecyclerView;
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfe;
  }
  
  public final void m(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(290672);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.d("MicroMsg.TextStatus.CardFeedItemConvert", s.X("onViewRecycled() called with: holder = ", paramj));
    AppMethodBeat.o(290672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c.d
 * JD-Core Version:    0.7.0.1
 */