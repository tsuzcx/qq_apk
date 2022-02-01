package com.tencent.mm.plugin.vlog.model.panel;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.loader.a;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends q<e>
{
  private final ImageView dpM;
  
  public g(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(283655);
    this.dpM = ((ImageView)paramView.findViewById(a.f.editor_pag_item_icon));
    AppMethodBeat.o(283655);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(283665);
    s.u(paramae, "item");
    super.a(paramae);
    paramae = (e)aVT();
    if (paramae != null)
    {
      Log.i(b.aUw(), s.X("onBind: ", paramae.name));
      Object localObject = com.tencent.mm.loader.e.noo;
      paramae = com.tencent.mm.loader.e.blh().GD(paramae.Ucg);
      localObject = this.dpM;
      s.s(localObject, "icon");
      paramae.d((ImageView)localObject);
    }
    AppMethodBeat.o(283665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.g
 * JD-Core Version:    0.7.0.1
 */