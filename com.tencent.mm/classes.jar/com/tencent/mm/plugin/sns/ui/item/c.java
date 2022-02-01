package com.tencent.mm.plugin.sns.ui.item;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcp;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "()V", "onClickListener", "Landroid/view/View$OnClickListener;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "getOnClickListener", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "updateLiveStatus", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "plugin-sns_release"})
public final class c
  extends d
{
  private final View.OnClickListener bwV;
  
  public c()
  {
    AppMethodBeat.i(262088);
    this.bwV = ((View.OnClickListener)c.a.Lmx);
    AppMethodBeat.o(262088);
  }
  
  protected final void a(d.a parama, TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(262086);
    p.k(parama, "holder");
    p.k(paramTimeLineObject, "tlObj");
    AppMethodBeat.o(262086);
  }
  
  protected final View.OnClickListener c(bm parambm)
  {
    AppMethodBeat.i(262087);
    p.k(parambm, "adapter");
    parambm = this.bwV;
    AppMethodBeat.o(262087);
    return parambm;
  }
  
  protected final void e(bcp parambcp)
  {
    AppMethodBeat.i(262085);
    p.k(parambcp, "finderShareObject");
    p.j(h.ae(a.class), "MMKernel.service(IFestiv…xportService::class.java)");
    parambcp.liveStatus = 2;
    AppMethodBeat.o(262085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */