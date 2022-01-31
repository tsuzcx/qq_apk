package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class b$37
  implements View.OnClickListener
{
  b$37(b paramb) {}
  
  public final void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof a.c))
    {
      localObject = ((a.c)paramView.getTag()).bJQ;
      localObject = af.bDF().OB((String)localObject);
      if (localObject != null) {
        break label38;
      }
    }
    label38:
    while (!((n)localObject).yr(32)) {
      return;
    }
    y.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
    int j = this.ppl.source;
    if (this.ppl.source == 0) {}
    for (int i = 1;; i = 2)
    {
      i.a(new SnsAdClick(j, i, ((n)localObject).field_snsId, 24, 0));
      this.ppl.cU(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.37
 * JD-Core Version:    0.7.0.1
 */