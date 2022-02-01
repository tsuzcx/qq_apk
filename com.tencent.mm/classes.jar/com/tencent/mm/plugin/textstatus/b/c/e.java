package com.tencent.mm.plugin.textstatus.b.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.plugin.textstatus.ui.TextStatusCardFeedsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusCardFeedsActivity.a;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendData;", "()V", "clickArrowListener", "Lkotlin/Function0;", "", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setOnClickArrowListener", "listener", "updateNameTextColor", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f<c>
{
  public static final e.a Tkt;
  kotlin.g.a.a<ah> Tku;
  
  static
  {
    AppMethodBeat.i(290276);
    Tkt = new e.a((byte)0);
    AppMethodBeat.o(290276);
  }
  
  private static final void a(e parame, c paramc, View paramView)
  {
    AppMethodBeat.i(290254);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramc, "$item");
    paramView = parame.Tku;
    parame = paramView;
    if (paramView == null)
    {
      s.bIx("clickArrowListener");
      parame = null;
    }
    parame.invoke();
    parame = com.tencent.mm.plugin.textstatus.i.b.Trt;
    parame = ((com.tencent.mm.plugin.textstatus.h.f.b)paramc.Tkq.TnV.bMQ.get(0)).field_IconID;
    s.s(parame, "item.groupItem.info.items[0].field_IconID");
    com.tencent.mm.plugin.textstatus.i.b.a(8L, parame, paramc.Tkq.TnV.bMQ.size(), null, null, null, 0, 0L, 248);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290254);
  }
  
  private static final void a(j paramj, c paramc, View paramView)
  {
    AppMethodBeat.i(290267);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramc, "$item");
    paramView = TextStatusCardFeedsActivity.Txc;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    TextStatusCardFeedsActivity.a.cb(paramj, paramc.userName);
    paramj = com.tencent.mm.plugin.textstatus.i.b.Trt;
    paramj = paramc.Tkr;
    if (paramj == null) {
      paramj = "";
    }
    for (;;)
    {
      paramView = paramc.userName;
      com.tencent.mm.plugin.textstatus.i.b.a(7L, paramj, paramc.Tkq.TnV.bMQ.size(), paramView, null, null, 0, 0L, 240);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290267);
      return;
      paramView = paramj.field_IconID;
      paramj = paramView;
      if (paramView == null) {
        paramj = "";
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290312);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290312);
  }
  
  public final int getLayoutId()
  {
    return a.f.TfG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.e
 * JD-Core Version:    0.7.0.1
 */