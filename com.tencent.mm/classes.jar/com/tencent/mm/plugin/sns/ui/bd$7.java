package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class bd$7
  implements View.OnClickListener
{
  bd$7(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39868);
    ab.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
    q localq;
    gi localgi;
    String str;
    if ((paramView.getTag() instanceof q))
    {
      localq = (q)paramView.getTag();
      if (localq.rGk.xTS.wNZ == 26)
      {
        if (bo.isNullOrNil(localq.rGk.xTS.wOc))
        {
          AppMethodBeat.o(39868);
          return;
        }
        localgi = new gi();
        localgi.cuX.type = 37;
        localgi.cuX.desc = localq.rGk.xTS.wOc;
        str = "";
        paramView = str;
        if (localq.rGk.xTS.wOa != null)
        {
          paramView = str;
          if (localq.rGk.xTS.wOa.size() > 0)
          {
            paramView = ao.gl(ag.getAccSnsPath(), ((bcs)localq.rGk.xTS.wOa.get(0)).Id);
            str = i.e((bcs)localq.rGk.xTS.wOa.get(0));
            if (!e.cN(paramView + str)) {
              break label282;
            }
          }
        }
      }
    }
    label282:
    for (paramView = paramView + str;; paramView = "")
    {
      localgi.cuX.path = paramView;
      localgi.cuX.title = localq.crk;
      localgi.cuX.context = this.scK.context;
      a.ymk.l(localgi);
      AppMethodBeat.o(39868);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.7
 * JD-Core Version:    0.7.0.1
 */