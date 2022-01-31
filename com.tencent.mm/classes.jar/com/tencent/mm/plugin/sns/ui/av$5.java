package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;

final class av$5
  implements View.OnClickListener
{
  av$5(av paramav) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39407);
    ab.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
    this.rXd.rWP.rFn = false;
    com.tencent.mm.plugin.sns.abtest.a.cnw();
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      ab.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
      AppMethodBeat.o(39407);
      return;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    if ((localBaseViewHolder.timeLineObject != null) && (localBaseViewHolder.timeLineObject.xTS.wNZ == 21))
    {
      bct localbct = localBaseViewHolder.rDg;
      if ((!r.Zn().equals(localBaseViewHolder.timeLineObject.jJA)) && ((localbct == null) || (localbct.cMQ == 0)))
      {
        com.tencent.mm.plugin.sns.lucky.ui.a.f(this.rXd.cmc, localBaseViewHolder.shk.EJ(0));
        AppMethodBeat.o(39407);
        return;
      }
    }
    if ((this.rXd.cmc instanceof t)) {
      ((t)this.rXd.cmc).dP(paramView);
    }
    AppMethodBeat.o(39407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.5
 * JD-Core Version:    0.7.0.1
 */