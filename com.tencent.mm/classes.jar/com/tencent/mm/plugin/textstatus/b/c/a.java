package com.tencent.mm.plugin.textstatus.b.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.a;
import com.tencent.mm.plugin.textstatus.util.l;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/topic/NotifyInfoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/topic/NotifyInfoItem;", "callback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<com.tencent.mm.plugin.textstatus.h.g.a>
{
  public static final a.a Tkn;
  private final kotlin.g.a.a<Integer> callback;
  
  static
  {
    AppMethodBeat.i(290252);
    Tkn = new a.a((byte)0);
    AppMethodBeat.o(290252);
  }
  
  public a(kotlin.g.a.a<Integer> parama)
  {
    this.callback = parama;
  }
  
  private static final void a(j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(290248);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/topic/NotifyInfoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(parama, "this$0");
    paramView = TextStatusLikeListActivity.Tzn;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    parama = parama.callback;
    int i;
    if (parama == null) {
      i = 0;
    }
    for (;;)
    {
      TextStatusLikeListActivity.a.ba(paramj, i);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/topic/NotifyInfoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290248);
      return;
      parama = (Integer)parama.invoke();
      if (parama == null) {
        i = 0;
      } else {
        i = parama.intValue();
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290268);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj = paramj.UH(a.e.TcS);
    l locall = l.TBz;
    l.C(paramj, com.tencent.mm.cd.a.fromDPToPix(paramRecyclerView.getContext(), 4));
    AppMethodBeat.o(290268);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.a
 * JD-Core Version:    0.7.0.1
 */