package com.tencent.mm.plugin.vlog.model.panel;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.loader.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-vlog_release"})
public final class g
  extends q<e>
{
  private final ImageView kc;
  
  public g(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(190797);
    this.kc = ((ImageView)paramView.findViewById(2131299894));
    AppMethodBeat.o(190797);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(190796);
    p.h(paramac, "item");
    super.a(paramac);
    paramac = (e)this.hbh;
    if (paramac != null)
    {
      Log.i(b.auD(), "onBind: " + paramac.name);
      Object localObject = com.tencent.mm.loader.e.hXU;
      paramac = com.tencent.mm.loader.e.aJs().He(paramac.GAV);
      localObject = this.kc;
      p.g(localObject, "icon");
      paramac.c((ImageView)localObject);
      AppMethodBeat.o(190796);
      return;
    }
    AppMethodBeat.o(190796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.g
 * JD-Core Version:    0.7.0.1
 */