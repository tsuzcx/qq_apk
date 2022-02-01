package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bmr;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "()V", "onClickListener", "Landroid/view/View$OnClickListener;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "getOnClickListener", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "updateLiveStatus", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  private final View.OnClickListener dpY = c..ExternalSyntheticLambda0.INSTANCE;
  
  private static final void jO(View paramView)
  {
    AppMethodBeat.i(309022);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    ((com.tencent.mm.plugin.festival.a.a)h.ax(com.tencent.mm.plugin.festival.a.a.class)).gn(paramView.getContext());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/item/Festival2021TimeLineItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(309022);
  }
  
  protected final void a(d.a parama, TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309031);
    s.u(parama, "holder");
    s.u(paramTimeLineObject, "tlObj");
    AppMethodBeat.o(309031);
  }
  
  protected final View.OnClickListener c(bn parambn)
  {
    AppMethodBeat.i(309036);
    s.u(parambn, "adapter");
    parambn = this.dpY;
    AppMethodBeat.o(309036);
    return parambn;
  }
  
  protected final void e(bmr parambmr)
  {
    AppMethodBeat.i(309028);
    s.u(parambmr, "finderShareObject");
    if (((com.tencent.mm.plugin.festival.a.a)h.ax(com.tencent.mm.plugin.festival.a.a.class)).dTk() == true) {}
    for (int i = 1;; i = 2)
    {
      parambmr.liveStatus = i;
      AppMethodBeat.o(309028);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */