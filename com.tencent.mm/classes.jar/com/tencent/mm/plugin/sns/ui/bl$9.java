package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;

final class bl$9
  implements View.OnClickListener
{
  bl$9(bl parambl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99731);
    Object localObject1 = this.yYB;
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
          localObject2 = ((TimeLineObject)paramView.getTag()).FQn.Id;
          if ("wx485a97c844086dc9".equals(localObject2))
          {
            d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
            i = 1;
          }
          else
          {
            if ("wx7fa037cc7dfabad5".equals(localObject2))
            {
              c.lA(34);
              g.agS();
              if (com.tencent.mm.n.b.ln(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt("gh_43f2581f6fd6").field_type))
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
              ac.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("shake_tv", true);
              d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
              i = 1;
            }
            else if ("wxfbc915ff7c30e335".equals(localObject2))
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 1);
              if ((!com.tencent.mm.r.a.cg(((bl)localObject1).context)) && (!com.tencent.mm.r.a.cf(((bl)localObject1).context)) && (!com.tencent.mm.r.a.ck(((bl)localObject1).context))) {
                d.b(((bl)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
              }
              i = 1;
            }
            else if ("wxaf060266bfa9a35c".equals(localObject2))
            {
              if (!e.aGD())
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
          if ((localTimeLineObject == null) || (localTimeLineObject.FQn == null))
          {
            ac.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
            AppMethodBeat.o(99731);
            return;
          }
          str1 = localTimeLineObject.FQn.Id;
          str2 = com.tencent.mm.plugin.sns.c.a.iyy.eB(str1);
          if (!bs.isNullOrNil(str2)) {
            if (localTimeLineObject == null)
            {
              paramView = null;
              if (localTimeLineObject.FQo.Ety != 1) {
                break label755;
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
      if (localTimeLineObject.xXR != null)
      {
        localObject1 = localObject2;
        if (localTimeLineObject.xXR.DNt != null) {
          localObject1 = localTimeLineObject.xXR.DNt.DNn;
        }
      }
      localObject2 = new qs();
      ((qs)localObject2).dtI.context = this.yYB.context;
      ((qs)localObject2).dtI.scene = 4;
      ((qs)localObject2).dtI.djj = str1;
      ((qs)localObject2).dtI.packageName = str2;
      ((qs)localObject2).dtI.msgType = i;
      ((qs)localObject2).dtI.dng = paramView;
      ((qs)localObject2).dtI.mediaTagName = ((String)localObject1);
      ((qs)localObject2).dtI.dtJ = 5;
      ((qs)localObject2).dtI.dpl = 0L;
      ((qs)localObject2).dtI.dtK = localTimeLineObject.Id;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      paramView = new hv();
      paramView.diT.actionCode = 2;
      paramView.diT.scene = 3;
      paramView.diT.extMsg = "timeline_src=3";
      paramView.diT.appId = str1;
      paramView.diT.context = this.yYB.context;
      com.tencent.mm.sdk.b.a.GpY.l(paramView);
      AppMethodBeat.o(99731);
      return;
      paramView = localTimeLineObject.ncR;
      break;
      label755:
      if (localTimeLineObject.FQo.Ety == 3)
      {
        i = 5;
        continue;
        paramView = this.yYB;
        paramView = com.tencent.mm.plugin.sns.c.a.iyy.e(paramView.context, str1, "timeline");
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
        com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject1, this.yYB.context);
        AppMethodBeat.o(99731);
      }
      else
      {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl.9
 * JD-Core Version:    0.7.0.1
 */