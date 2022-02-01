package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;

final class bl$9
  implements View.OnClickListener
{
  bl$9(bl parambl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99731);
    Object localObject1 = this.xLM;
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
          AppMethodBeat.o(99731);
          return;
          localObject2 = ((TimeLineObject)paramView.getTag()).Etl.Id;
          if ("wx485a97c844086dc9".equals(localObject2))
          {
            d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
            i = 1;
          }
          else
          {
            if ("wx7fa037cc7dfabad5".equals(localObject2))
            {
              c.lI(34);
              g.afC();
              if (com.tencent.mm.n.b.ls(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY("gh_43f2581f6fd6").field_type))
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Chat_User", "gh_43f2581f6fd6");
                ((Intent)localObject2).putExtra("finish_direct", true);
                d.e(((bl)localObject1).context, ".ui.chatting.ChattingUI", (Intent)localObject2);
              }
              for (;;)
              {
                i = 1;
                break;
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Contact_User", "gh_43f2581f6fd6");
                d.b(((bl)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
              }
            }
            if (("wx9181ed3f223e6d76".equals(localObject2)) || ("wx2fe12a395c426fcf".equals(localObject2)))
            {
              ad.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("shake_tv", true);
              d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
              i = 1;
            }
            else if ("wxfbc915ff7c30e335".equals(localObject2))
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 1);
              if ((!com.tencent.mm.r.a.cd(((bl)localObject1).context)) && (!com.tencent.mm.r.a.cc(((bl)localObject1).context))) {
                d.b(((bl)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
              }
              i = 1;
            }
            else if ("wxaf060266bfa9a35c".equals(localObject2))
            {
              if (!e.azN())
              {
                i = 1;
              }
              else
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("shake_tv", true);
                d.b(((bl)localObject1).context, "shake", ".ui.ShakeReportUI", (Intent)localObject2);
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
          if ((localTimeLineObject == null) || (localTimeLineObject.Etl == null))
          {
            ad.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
            AppMethodBeat.o(99731);
            return;
          }
          str1 = localTimeLineObject.Etl.Id;
          str2 = com.tencent.mm.plugin.sns.d.a.hYu.eL(str1);
          if (!bt.isNullOrNil(str2)) {
            if (localTimeLineObject == null)
            {
              paramView = null;
              if (localTimeLineObject.Etm.DaB != 1) {
                break label745;
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
      if (localTimeLineObject.wLl != null)
      {
        localObject1 = localObject2;
        if (localTimeLineObject.wLl.CuY != null) {
          localObject1 = localTimeLineObject.wLl.CuY.CuS;
        }
      }
      localObject2 = new qj();
      ((qj)localObject2).dvV.context = this.xLM.context;
      ((qj)localObject2).dvV.scene = 4;
      ((qj)localObject2).dvV.dlB = str1;
      ((qj)localObject2).dvV.packageName = str2;
      ((qj)localObject2).dvV.msgType = i;
      ((qj)localObject2).dvV.dpv = paramView;
      ((qj)localObject2).dvV.mediaTagName = ((String)localObject1);
      ((qj)localObject2).dvV.dvW = 5;
      ((qj)localObject2).dvV.drA = 0L;
      ((qj)localObject2).dvV.dvX = localTimeLineObject.Id;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      paramView = new ho();
      paramView.dlk.actionCode = 2;
      paramView.dlk.scene = 3;
      paramView.dlk.extMsg = "timeline_src=3";
      paramView.dlk.appId = str1;
      paramView.dlk.context = this.xLM.context;
      com.tencent.mm.sdk.b.a.ESL.l(paramView);
      AppMethodBeat.o(99731);
      return;
      paramView = localTimeLineObject.mAQ;
      break;
      label745:
      if (localTimeLineObject.Etm.DaB == 3)
      {
        i = 5;
        continue;
        paramView = this.xLM;
        paramView = com.tencent.mm.plugin.sns.d.a.hYu.e(paramView.context, str1, "timeline");
        if ((paramView == null) || (paramView.length() == 0))
        {
          AppMethodBeat.o(99731);
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("type", -255);
        ((Intent)localObject1).putExtra("geta8key_scene", 2);
        com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject1, this.xLM.context);
        AppMethodBeat.o(99731);
      }
      else
      {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl.9
 * JD-Core Version:    0.7.0.1
 */