package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

final class at$6
  implements View.OnClickListener
{
  at$6(at paramat) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39206);
    if ((paramView.getTag() instanceof TimeLineObject))
    {
      paramView = (TimeLineObject)paramView.getTag();
      if (at.aci(paramView.Id)) {
        break label108;
      }
      h.qsU.kvStat(10090, "1,0");
      if ((!com.tencent.mm.r.a.bO(at.a(this.rUG))) && (!com.tencent.mm.r.a.bM(at.a(this.rUG))))
      {
        paramView = g.a(ag.getAccPath(), paramView, 8);
        paramView.fKB = at.b(this.rUG);
        com.tencent.mm.aw.a.b(paramView);
      }
    }
    for (;;)
    {
      this.rUG.notifyDataSetChanged();
      AppMethodBeat.o(39206);
      return;
      label108:
      h.qsU.kvStat(10231, "1");
      com.tencent.mm.aw.a.aiu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.6
 * JD-Core Version:    0.7.0.1
 */