package com.tencent.mm.plugin.vlog.model.panel;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.loader.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-vlog_release"})
public final class g
  extends q<e>
{
  private final ImageView ka;
  
  public g(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(191337);
    this.ka = ((ImageView)paramView.findViewById(2131308288));
    AppMethodBeat.o(191337);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(191336);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (e)this.gqo;
    if (paramac != null)
    {
      ae.i(b.aeP(), "onBind: " + paramac.name);
      Object localObject = com.tencent.mm.loader.e.hfa;
      paramac = com.tencent.mm.loader.e.aqU().yF(paramac.BZi);
      localObject = this.ka;
      p.g(localObject, "icon");
      paramac.c((ImageView)localObject);
      AppMethodBeat.o(191336);
      return;
    }
    AppMethodBeat.o(191336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.g
 * JD-Core Version:    0.7.0.1
 */