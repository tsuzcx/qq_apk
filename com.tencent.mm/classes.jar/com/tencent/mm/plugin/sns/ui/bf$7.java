package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class bf$7
  implements View.OnClickListener
{
  bf$7(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
    q localq;
    if ((paramView.getTag() instanceof q))
    {
      localq = (q)paramView.getTag();
      if ((localq.oOz.tNr.sPI == 26) && (!bk.bl(localq.oOz.tNr.sPL))) {}
    }
    else
    {
      return;
    }
    gf localgf = new gf();
    localgf.bNF.type = 37;
    localgf.bNF.desc = localq.oOz.tNr.sPL;
    String str = "";
    paramView = str;
    if (localq.oOz.tNr.sPJ != null)
    {
      paramView = str;
      if (localq.oOz.tNr.sPJ.size() > 0)
      {
        paramView = an.eJ(af.getAccSnsPath(), ((awd)localq.oOz.tNr.sPJ.get(0)).lsK);
        str = i.e((awd)localq.oOz.tNr.sPJ.get(0));
        if (!e.bK(paramView + str)) {
          break label267;
        }
      }
    }
    label267:
    for (paramView = paramView + str;; paramView = "")
    {
      localgf.bNF.path = paramView;
      localgf.bNF.title = localq.bJQ;
      localgf.bNF.context = this.pkg.context;
      a.udP.m(localgf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.7
 * JD-Core Version:    0.7.0.1
 */