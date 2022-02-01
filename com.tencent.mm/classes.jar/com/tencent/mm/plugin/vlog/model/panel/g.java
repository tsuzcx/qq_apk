package com.tencent.mm.plugin.vlog.model.panel;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.loader.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-vlog_release"})
public final class g
  extends q<e>
{
  private final ImageView ka;
  
  public g(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(195878);
    this.ka = ((ImageView)paramView.findViewById(2131308288));
    AppMethodBeat.o(195878);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(195877);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (e)this.gnS;
    if (paramac != null)
    {
      ad.i(b.aeD(), "onBind: " + paramac.name);
      Object localObject = com.tencent.mm.loader.e.hcm;
      paramac = com.tencent.mm.loader.e.aqF().xV(paramac.BHJ);
      localObject = this.ka;
      p.g(localObject, "icon");
      paramac.c((ImageView)localObject);
      AppMethodBeat.o(195877);
      return;
    }
    AppMethodBeat.o(195877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.g
 * JD-Core Version:    0.7.0.1
 */