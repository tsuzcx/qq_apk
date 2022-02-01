package com.tencent.mm.plugin.vlog.model.panel;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.loader.a;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-vlog_release"})
public final class g
  extends s<e>
{
  private final ImageView bwJ;
  
  public g(View paramView, com.tencent.mm.emoji.panel.a.p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(244279);
    this.bwJ = ((ImageView)paramView.findViewById(a.f.editor_pag_item_icon));
    AppMethodBeat.o(244279);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(244278);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    paramae = (e)this.jMr;
    if (paramae != null)
    {
      Log.i(b.aBy(), "onBind: " + paramae.name);
      Object localObject = com.tencent.mm.loader.e.kMy;
      paramae = com.tencent.mm.loader.e.aRs().Op(paramae.NoE);
      localObject = this.bwJ;
      kotlin.g.b.p.j(localObject, "icon");
      paramae.c((ImageView)localObject);
      AppMethodBeat.o(244278);
      return;
    }
    AppMethodBeat.o(244278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.g
 * JD-Core Version:    0.7.0.1
 */