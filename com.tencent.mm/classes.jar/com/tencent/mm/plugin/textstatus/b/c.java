package com.tencent.mm.plugin.textstatus.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "onItemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "OnItemClickListener", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f<com.tencent.mm.plugin.textstatus.h.e.c>
{
  public static final c.a TjN;
  private final b TjO;
  
  static
  {
    AppMethodBeat.i(290273);
    TjN = new c.a((byte)0);
    AppMethodBeat.o(290273);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(290258);
    this.TjO = paramb;
    AppMethodBeat.o(290258);
  }
  
  private static final void a(c paramc, com.tencent.mm.plugin.textstatus.h.e.c paramc1, View paramView)
  {
    AppMethodBeat.i(290265);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramc1);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.u(paramc1, "$item");
    paramc = paramc.TjO;
    s.s(paramView, "it");
    paramc.a(paramView, paramc1);
    a.a(new Object(), "com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290265);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(290287);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(290287);
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.textstatus.h.e.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c
 * JD-Core Version:    0.7.0.1
 */