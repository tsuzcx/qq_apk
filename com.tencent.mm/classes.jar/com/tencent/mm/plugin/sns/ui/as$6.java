package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.bxk;

final class as$6
  implements View.OnClickListener
{
  as$6(as paramas) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bxk))
    {
      paramView = (bxk)paramView.getTag();
      if (as.Pp(paramView.lsK)) {
        break label98;
      }
      h.nFQ.aC(10090, "1,0");
      if ((!com.tencent.mm.r.a.bk(as.a(this.pbW))) && (!com.tencent.mm.r.a.bi(as.a(this.pbW))))
      {
        paramView = g.a(af.FU(), paramView, 8);
        paramView.euP = as.b(this.pbW);
        com.tencent.mm.av.a.b(paramView);
      }
    }
    for (;;)
    {
      this.pbW.notifyDataSetChanged();
      return;
      label98:
      h.nFQ.aC(10231, "1");
      com.tencent.mm.av.a.Ps();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.6
 * JD-Core Version:    0.7.0.1
 */