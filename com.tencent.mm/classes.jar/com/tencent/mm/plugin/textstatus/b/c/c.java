package com.tencent.mm.plugin.textstatus.b.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "itemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;)V", "getItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "setItemClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "planetItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "OnClickCardItemListener", "plugin-textstatus_release"})
public final class c
  extends e<com.tencent.mm.plugin.textstatus.f.d.b>
{
  public static final a FXV;
  b FXU;
  
  static
  {
    AppMethodBeat.i(216120);
    FXV = new a((byte)0);
    AppMethodBeat.o(216120);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(216119);
    this.FXU = paramb;
    AppMethodBeat.o(216119);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(216117);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(216117);
  }
  
  public final int getLayoutId()
  {
    return 2131496696;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "", "onClickItem", "", "itemData", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "view", "Landroid/view/View;", "plugin-textstatus_release"})
  public static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.textstatus.f.d.b paramb, View paramView);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, com.tencent.mm.plugin.textstatus.f.d.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216115);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.FXW.FXU;
      com.tencent.mm.plugin.textstatus.f.d.b localb = this.FXX;
      p.g(paramView, "it");
      ((c.b)localObject).a(localb, paramView);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216115);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh, com.tencent.mm.plugin.textstatus.f.d.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216116);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = TextStatusSameTopicsActivity.GfI;
      paramView = this.qhp.aus;
      p.g(paramView, "holder.itemView");
      paramView = paramView.getContext();
      p.g(paramView, "holder.itemView.context");
      TextStatusSameTopicsActivity.a.bE(paramView, this.FXX.FZz);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.c
 * JD-Core Version:    0.7.0.1
 */