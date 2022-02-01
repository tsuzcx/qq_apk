package com.tencent.mm.plugin.textstatus.b;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "onItemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "OnItemClickListener", "plugin-textstatus_release"})
public final class c
  extends e<com.tencent.mm.plugin.textstatus.g.d.c>
{
  public static final c.a MAb;
  final b MAa;
  
  static
  {
    AppMethodBeat.i(237073);
    MAb = new c.a((byte)0);
    AppMethodBeat.o(237073);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(237071);
    this.MAa = paramb;
    AppMethodBeat.o(237071);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(237067);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(237067);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxK;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.textstatus.g.d.c paramc);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, com.tencent.mm.plugin.textstatus.g.d.c paramc1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235321);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = this.MAc.MAa;
      p.j(paramView, "it");
      ((c.b)localObject).a(paramView, this.MAd);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235321);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c
 * JD-Core Version:    0.7.0.1
 */