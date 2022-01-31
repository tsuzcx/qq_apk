package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class bd$8
  implements View.OnClickListener
{
  bd$8(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39869);
    Object localObject1 = this.scK;
    int i;
    if ((paramView == null) || (!(paramView.getTag() instanceof TimeLineObject))) {
      i = 1;
    }
    Object localObject2;
    TimeLineObject localTimeLineObject;
    String str1;
    String str2;
    for (;;)
    {
      if (i == 0) {
        if ((paramView == null) || (!(paramView.getTag() instanceof TimeLineObject)))
        {
          AppMethodBeat.o(39869);
          return;
          localObject2 = ((TimeLineObject)paramView.getTag()).xTR.Id;
          if ("wx485a97c844086dc9".equals(localObject2))
          {
            com.tencent.mm.bq.d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
            i = 1;
          }
          else
          {
            if ("wx7fa037cc7dfabad5".equals(localObject2))
            {
              com.tencent.mm.plugin.sport.a.d.kS(34);
              g.RM();
              if (com.tencent.mm.n.a.je(((j)g.E(j.class)).YA().arw("gh_43f2581f6fd6").field_type))
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Chat_User", "gh_43f2581f6fd6");
                ((Intent)localObject2).putExtra("finish_direct", true);
                com.tencent.mm.bq.d.f(((bd)localObject1).context, ".ui.chatting.ChattingUI", (Intent)localObject2);
              }
              for (;;)
              {
                i = 1;
                break;
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Contact_User", "gh_43f2581f6fd6");
                com.tencent.mm.bq.d.b(((bd)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
              }
            }
            if (("wx9181ed3f223e6d76".equals(localObject2)) || ("wx2fe12a395c426fcf".equals(localObject2)))
            {
              ab.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("shake_tv", true);
              com.tencent.mm.bq.d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
              i = 1;
            }
            else if ("wx751a1acca5688ba3".equals(localObject2))
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 5);
              if ((!com.tencent.mm.r.a.bN(((bd)localObject1).context)) && (!com.tencent.mm.r.a.bM(((bd)localObject1).context))) {
                com.tencent.mm.bq.d.b(((bd)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
              }
              i = 1;
            }
            else if ("wxfbc915ff7c30e335".equals(localObject2))
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 1);
              if ((!com.tencent.mm.r.a.bN(((bd)localObject1).context)) && (!com.tencent.mm.r.a.bM(((bd)localObject1).context))) {
                com.tencent.mm.bq.d.b(((bd)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
              }
              i = 1;
            }
            else if ("wx482a4001c37e2b74".equals(localObject2))
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 2);
              if ((!com.tencent.mm.r.a.bN(((bd)localObject1).context)) && (!com.tencent.mm.r.a.bM(((bd)localObject1).context))) {
                com.tencent.mm.bq.d.b(((bd)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
              }
              i = 1;
            }
            else if ("wxaf060266bfa9a35c".equals(localObject2))
            {
              if (!com.tencent.mm.aw.d.aiE())
              {
                i = 1;
              }
              else
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("shake_tv", true);
                com.tencent.mm.bq.d.b(((bd)localObject1).context, "shake", ".ui.ShakeReportUI", (Intent)localObject2);
                i = 1;
              }
            }
            else
            {
              i = 0;
            }
          }
        }
        else
        {
          localTimeLineObject = (TimeLineObject)paramView.getTag();
          if ((localTimeLineObject == null) || (localTimeLineObject.xTR == null))
          {
            ab.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
            AppMethodBeat.o(39869);
            return;
          }
          str1 = localTimeLineObject.xTR.Id;
          str2 = com.tencent.mm.plugin.sns.c.a.gmP.dE(str1);
          if (!bo.isNullOrNil(str2)) {
            if (localTimeLineObject == null)
            {
              paramView = null;
              if (localTimeLineObject.xTS.wNZ != 1) {
                break label877;
              }
              i = 2;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (localTimeLineObject.rjv != null)
      {
        localObject1 = localObject2;
        if (localTimeLineObject.rjv.wmJ != null) {
          localObject1 = localTimeLineObject.rjv.wmJ.wmD;
        }
      }
      localObject2 = new or();
      ((or)localObject2).cFl.context = this.scK.context;
      ((or)localObject2).cFl.scene = 4;
      ((or)localObject2).cFl.cwc = str1;
      ((or)localObject2).cFl.packageName = str2;
      ((or)localObject2).cFl.msgType = i;
      ((or)localObject2).cFl.czp = paramView;
      ((or)localObject2).cFl.mediaTagName = ((String)localObject1);
      ((or)localObject2).cFl.cFm = 5;
      ((or)localObject2).cFl.cFn = 0L;
      ((or)localObject2).cFl.cFo = localTimeLineObject.Id;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
      paramView = new gu();
      paramView.cvL.actionCode = 2;
      paramView.cvL.scene = 3;
      paramView.cvL.extMsg = "timeline_src=3";
      paramView.cvL.appId = str1;
      paramView.cvL.context = this.scK.context;
      com.tencent.mm.sdk.b.a.ymk.l(paramView);
      AppMethodBeat.o(39869);
      return;
      paramView = localTimeLineObject.jJA;
      break;
      label877:
      if (localTimeLineObject.xTS.wNZ == 3)
      {
        i = 5;
        continue;
        paramView = this.scK;
        paramView = com.tencent.mm.plugin.sns.c.a.gmP.f(paramView.context, str1, "timeline");
        if ((paramView == null) || (paramView.length() == 0))
        {
          AppMethodBeat.o(39869);
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("type", -255);
        ((Intent)localObject1).putExtra("geta8key_scene", 2);
        com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject1, this.scK.context);
        AppMethodBeat.o(39869);
      }
      else
      {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.8
 * JD-Core Version:    0.7.0.1
 */