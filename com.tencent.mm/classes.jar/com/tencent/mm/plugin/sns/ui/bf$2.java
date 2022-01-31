package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class bf$2
  implements View.OnClickListener
{
  bf$2(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = paramView.getTag() instanceof q;
    y.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click " + bool);
    if (!bool) {}
    label176:
    label305:
    for (;;)
    {
      return;
      q localq = (q)paramView.getTag();
      bxk localbxk = localq.oOz;
      String str;
      if (!bf.Ma(localbxk.lsK)) {
        if ((!com.tencent.mm.r.a.bk(this.pkg.context)) && (!com.tencent.mm.r.a.bi(this.pkg.context)))
        {
          h.nFQ.aC(10090, "1,0");
          if (localbxk.tNr.sPJ.size() > 0)
          {
            awd localawd = (awd)localbxk.tNr.sPJ.get(0);
            if (this.pkg.source != 0) {
              break label253;
            }
            paramView = b.jd(738);
            b localb = paramView.ni(localbxk.lsK).ni(localbxk.hPY);
            if (localbxk.tNq != null) {
              break label263;
            }
            str = "";
            localb.ni(str).ni(localawd.bGw).ni(localawd.kRN).ni("");
            paramView.QX();
          }
          if (!localq.oOA) {
            break label275;
          }
          com.tencent.mm.av.a.a(g.a(af.FU(), localbxk, 9));
        }
      }
      for (;;)
      {
        if (this.pkg.pjR == null) {
          break label305;
        }
        this.pkg.pjR.bIF();
        return;
        label253:
        paramView = b.je(738);
        break;
        str = localbxk.tNq.lsK;
        break label176;
        com.tencent.mm.av.a.b(g.a(af.FU(), localbxk, 1));
        continue;
        h.nFQ.aC(10231, "1");
        com.tencent.mm.av.a.Ps();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.2
 * JD-Core Version:    0.7.0.1
 */