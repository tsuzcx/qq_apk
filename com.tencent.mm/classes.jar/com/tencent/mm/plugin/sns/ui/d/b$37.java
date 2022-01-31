package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ab;

final class b$37
  implements View.OnClickListener
{
  b$37(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40299);
    Object localObject;
    int i;
    SnsAdClick localSnsAdClick;
    if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      localObject = ((BaseTimeLineItem.BaseViewHolder)paramView.getTag()).crk;
      localObject = ag.cpf().abv((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(40299);
        return;
      }
      if (((n)localObject).Ex(32))
      {
        ab.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
        int j = this.skd.cpt;
        if (this.skd.cpt != 0) {
          break label143;
        }
        i = 1;
        localSnsAdClick = new SnsAdClick(j, i, ((n)localObject).field_snsId, 24, 0);
        if (this.skd.rOU != null) {
          break label148;
        }
      }
    }
    label143:
    label148:
    for (long l = 0L;; l = this.skd.rOU.di(((n)localObject).csH(), 24))
    {
      localSnsAdClick.fQA = l;
      i.a(localSnsAdClick);
      this.skd.dK(paramView);
      AppMethodBeat.o(40299);
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.37
 * JD-Core Version:    0.7.0.1
 */