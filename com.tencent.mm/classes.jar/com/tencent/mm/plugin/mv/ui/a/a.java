package com.tencent.mm.plugin.mv.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.m.b;
import com.tencent.mm.plugin.mv.ui.uic.m.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;)V", "TAG", "", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "itemWidth", "", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-mv_release"})
public final class a
  extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.mv.model.e>
{
  public static final a GfF;
  private final m.c GfD;
  final m.b GfE;
  private final String TAG;
  private final int tHY;
  
  static
  {
    AppMethodBeat.i(229622);
    GfF = new a((byte)0);
    AppMethodBeat.o(229622);
  }
  
  public a(m.c paramc, m.b paramb)
  {
    AppMethodBeat.i(229621);
    this.GfD = paramc;
    this.GfE = paramb;
    this.TAG = "MicroMsg.MusicMVVideoItemConverter";
    this.tHY = this.GfD.getItemWidth();
    AppMethodBeat.o(229621);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(229619);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (LinearLayout)parami.RD(b.e.FXX);
    Log.d(this.TAG, "onCreateViewHolder, itemWidth:" + this.tHY);
    p.j(paramRecyclerView, "root");
    paramRecyclerView.getLayoutParams().width = this.tHY;
    paramRecyclerView.getLayoutParams().height = -1;
    AppMethodBeat.o(229619);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZN;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$Companion;", "", "()V", "handleSelection", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "plugin-mv_release"})
  public static final class a
  {
    public static void a(i parami, com.tencent.mm.plugin.mv.model.e parame)
    {
      AppMethodBeat.i(229348);
      p.k(parami, "holder");
      p.k(parame, "item");
      View localView = parami.amk;
      p.j(localView, "holder.itemView");
      localView.setSelected(parame.xUg);
      localView = parami.RD(b.e.FXK);
      if (parame.xUg)
      {
        if (parame.type != 0)
        {
          parame = parami.amk.findViewById(b.e.FXW);
          p.j(parame, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
          parame.setVisibility(8);
          p.j(localView, "actionRoot");
          localView.setVisibility(0);
        }
        for (;;)
        {
          parami = parami.RD(b.e.FXV);
          p.j(parami, "holder.getView<View>(R.id.mvItemLyricRoot)");
          parami.setVisibility(0);
          AppMethodBeat.o(229348);
          return;
          parame = parami.amk.findViewById(b.e.FXW);
          p.j(parame, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
          parame.setVisibility(0);
          p.j(localView, "actionRoot");
          localView.setVisibility(8);
        }
      }
      ((ProgressBar)parami.amk.findViewById(b.e.FYL)).setProgress(0);
      parame = parami.amk.findViewById(b.e.FXW);
      p.j(parame, "holder.itemView.findView…Id<View>(R.id.mvItemMask)");
      parame.setVisibility(0);
      p.j(localView, "actionRoot");
      localView.setVisibility(8);
      parami = parami.RD(b.e.FXV);
      p.j(parami, "holder.getView<View>(R.id.mvItemLyricRoot)");
      parami.setVisibility(8);
      AppMethodBeat.o(229348);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, int paramInt, com.tencent.mm.plugin.mv.model.e parame, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231161);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.GfG.GfE;
      int i = this.jEN;
      localObject = this.GfH;
      View localView = this.tDl.amk;
      p.j(localView, "holder.itemView");
      paramView.a(i, (com.tencent.mm.plugin.mv.model.e)localObject, localView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231161);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama, int paramInt, com.tencent.mm.plugin.mv.model.e parame, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232912);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.GfG.GfE;
      int i = this.jEN;
      localObject = this.GfH;
      View localView = this.tDl.amk;
      p.j(localView, "holder.itemView");
      paramView.b(i, (com.tencent.mm.plugin.mv.model.e)localObject, localView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232912);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a
 * JD-Core Version:    0.7.0.1
 */