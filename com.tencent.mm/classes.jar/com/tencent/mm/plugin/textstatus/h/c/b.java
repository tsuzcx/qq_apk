package com.tencent.mm.plugin.textstatus.h.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.aa;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/feed/CardFeedBottomItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/feed/CardFeedBottomItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<a>
{
  public static final b.a Tnq;
  
  static
  {
    AppMethodBeat.i(290658);
    Tnq = new b.a((byte)0);
    AppMethodBeat.o(290658);
  }
  
  private static final void n(j paramj, View paramView)
  {
    AppMethodBeat.i(290653);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/model/feed/CardFeedBottomItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    paramView = new w.a().ThS;
    paramView.Toi = 14L;
    localObject = aa.ThY;
    aa.b(paramj.context, paramView);
    paramj = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(34L, null, null, 0L, null, 30);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/model/feed/CardFeedBottomItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290653);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290678);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290678);
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfd;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(290673);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.d("MicroMsg.TextStatus.CardFeedBottomItemConvert", s.X("onViewRecycled() called with: holder = ", paramj));
    AppMethodBeat.o(290673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c.b
 * JD-Core Version:    0.7.0.1
 */