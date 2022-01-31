package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;

final class b$26
  implements View.OnClickListener
{
  b$26(b paramb) {}
  
  public final void onClick(View paramView)
  {
    this.ppl.cX(paramView);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b))) {}
    n localn;
    do
    {
      return;
      paramView = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      localn = af.bDF().OB(paramView.bJQ);
    } while ((localn == null) || (!localn.yr(32)));
    paramView.omN = System.currentTimeMillis();
    int j = this.ppl.source;
    if (this.ppl.source == 0) {}
    for (int i = 1;; i = 2)
    {
      i.a(new SnsAdClick(j, i, localn.field_snsId, 20, 0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.26
 * JD-Core Version:    0.7.0.1
 */