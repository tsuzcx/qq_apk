package com.tencent.mm.plugin.textstatus.b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "onItemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "OnItemClickListener", "plugin-textstatus_release"})
public final class c
  extends e<com.tencent.mm.plugin.textstatus.f.e.c>
{
  public static final a FXz;
  final b FXy;
  
  static
  {
    AppMethodBeat.i(216062);
    FXz = new a((byte)0);
    AppMethodBeat.o(216062);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(216061);
    this.FXy = paramb;
    AppMethodBeat.o(216061);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216059);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(216059);
  }
  
  public final int getLayoutId()
  {
    return 2131496683;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.textstatus.f.e.c paramc);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, com.tencent.mm.plugin.textstatus.f.e.c paramc1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216058);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = this.FXA.FXy;
      p.g(paramView, "it");
      ((c.b)localObject).a(paramView, this.FXB);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216058);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c
 * JD-Core Version:    0.7.0.1
 */