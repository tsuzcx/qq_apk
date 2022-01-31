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

final class b$26
  implements View.OnClickListener
{
  b$26(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40282);
    this.skd.dN(paramView);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(40282);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    paramView = ag.cpf().abv(((com.tencent.mm.plugin.sns.data.b)localObject).crk);
    if (paramView == null)
    {
      AppMethodBeat.o(40282);
      return;
    }
    int i;
    if (paramView.Ex(32))
    {
      ((com.tencent.mm.plugin.sns.data.b)localObject).rbb = System.currentTimeMillis();
      int j = this.skd.cpt;
      if (this.skd.cpt != 0) {
        break label153;
      }
      i = 1;
      localObject = new SnsAdClick(j, i, paramView.field_snsId, 20, 0);
      if (this.skd.rOU != null) {
        break label158;
      }
    }
    label153:
    label158:
    for (long l = 0L;; l = this.skd.rOU.di(paramView.csH(), 20))
    {
      ((SnsAdClick)localObject).fQA = l;
      i.a((SnsAdClick)localObject);
      AppMethodBeat.o(40282);
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.26
 * JD-Core Version:    0.7.0.1
 */