package com.tencent.mm.plugin.textstatus.b.c;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "itemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;)V", "getItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "setItemClickListener", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "planetItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "OnClickCardItemListener", "plugin-textstatus_release"})
public final class c
  extends e<com.tencent.mm.plugin.textstatus.g.c.b>
{
  public static final c.a MAJ;
  b MAI;
  
  static
  {
    AppMethodBeat.i(233250);
    MAJ = new c.a((byte)0);
    AppMethodBeat.o(233250);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(233249);
    this.MAI = paramb;
    AppMethodBeat.o(233249);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(233239);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(233239);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxY;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "", "onClickItem", "", "itemData", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "view", "Landroid/view/View;", "plugin-textstatus_release"})
  public static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.textstatus.g.c.b paramb, View paramView);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, com.tencent.mm.plugin.textstatus.g.c.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237842);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.MAK.MAI;
      com.tencent.mm.plugin.textstatus.g.c.b localb = this.MAL;
      p.j(paramView, "it");
      ((c.b)localObject).a(localb, paramView);
      a.a(this, "com/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.c
 * JD-Core Version:    0.7.0.1
 */