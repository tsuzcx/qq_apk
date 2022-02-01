package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;

final class bo$15
  implements View.OnClickListener
{
  bo$15(bo parambo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99736);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    localObject1 = this.Aqp;
    int i;
    if ((paramView == null) || (!(paramView.getTag() instanceof TimeLineObject))) {
      i = 1;
    }
    Object localObject2;
    Object localObject3;
    String str1;
    String str2;
    for (;;)
    {
      if (i == 0) {
        if ((paramView == null) || (!(paramView.getTag() instanceof TimeLineObject)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99736);
          return;
          localObject2 = ((TimeLineObject)paramView.getTag()).HAS.Id;
          if ("wx485a97c844086dc9".equals(localObject2))
          {
            d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
            i = 1;
          }
          else
          {
            if ("wx7fa037cc7dfabad5".equals(localObject2))
            {
              com.tencent.mm.plugin.sport.a.c.ma(34);
              com.tencent.mm.kernel.g.ajD();
              if (com.tencent.mm.o.b.lM(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf("gh_43f2581f6fd6").field_type))
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Chat_User", "gh_43f2581f6fd6");
                ((Intent)localObject2).putExtra("finish_direct", true);
                d.f(((bo)localObject1).context, ".ui.chatting.ChattingUI", (Intent)localObject2);
              }
              for (;;)
              {
                i = 1;
                break;
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Contact_User", "gh_43f2581f6fd6");
                d.b(((bo)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
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
              if ((!com.tencent.mm.s.a.n(((bo)localObject1).context, true)) && (!com.tencent.mm.s.a.cd(((bo)localObject1).context)) && (!com.tencent.mm.s.a.ch(((bo)localObject1).context))) {
                d.b(((bo)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
              }
              i = 1;
            }
            else if ("wxaf060266bfa9a35c".equals(localObject2))
            {
              if (!e.aJO())
              {
                i = 1;
              }
              else
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("shake_tv", true);
                d.b(((bo)localObject1).context, "shake", ".ui.ShakeReportUI", (Intent)localObject2);
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
          localObject3 = (TimeLineObject)paramView.getTag();
          if ((localObject3 == null) || (((TimeLineObject)localObject3).HAS == null))
          {
            ad.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99736);
            return;
          }
          if ((((TimeLineObject)localObject3).HAT != null) && (((TimeLineObject)localObject3).HAT.GaP == 28) && (((TimeLineObject)localObject3).HAT.GaU != null))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
            ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
            if (bt.isNullOrNil(((TimeLineObject)localObject3).HAT.GaU.username))
            {
              ((Intent)localObject1).putExtra("finder_username", "");
              ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).HAT.GaU.objectId);
              ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).HAT.GaU.objectNonceId);
            }
            for (;;)
            {
              localObject2 = bt.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc());
              str1 = bt.nullAsNil(((TimeLineObject)localObject3).nDo);
              str2 = ((TimeLineObject)localObject3).HAT.GaU.objectId;
              localObject3 = ((TimeLineObject)localObject3).Id;
              localObject2 = (String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3;
              ad.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject2)));
              com.tencent.mm.plugin.report.service.g.yhR.kvStat(20587, (String)localObject2);
              ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject1);
              ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderProfileUI(paramView.getContext(), (Intent)localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99736);
              return;
              ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).HAT.GaU.username);
            }
          }
          str1 = ((TimeLineObject)localObject3).HAS.Id;
          str2 = com.tencent.mm.plugin.sns.c.a.iRH.fw(str1);
          if (!bt.isNullOrNil(str2)) {
            if (localObject3 == null)
            {
              paramView = null;
              if (((TimeLineObject)localObject3).HAT.GaP != 1) {
                break label1146;
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
      if (((TimeLineObject)localObject3).znQ != null)
      {
        localObject1 = localObject2;
        if (((TimeLineObject)localObject3).znQ.Fsy != null) {
          localObject1 = ((TimeLineObject)localObject3).znQ.Fsy.Fss;
        }
      }
      localObject2 = new rd();
      ((rd)localObject2).dFI.context = this.Aqp.context;
      ((rd)localObject2).dFI.scene = 4;
      ((rd)localObject2).dFI.duW = str1;
      ((rd)localObject2).dFI.packageName = str2;
      ((rd)localObject2).dFI.msgType = i;
      ((rd)localObject2).dFI.dyU = paramView;
      ((rd)localObject2).dFI.mediaTagName = ((String)localObject1);
      ((rd)localObject2).dFI.dFJ = 5;
      ((rd)localObject2).dFI.dAY = 0L;
      ((rd)localObject2).dFI.dFK = ((TimeLineObject)localObject3).Id;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      paramView = new ic();
      paramView.duF.actionCode = 2;
      paramView.duF.scene = 3;
      paramView.duF.extMsg = "timeline_src=3";
      paramView.duF.appId = str1;
      paramView.duF.context = this.Aqp.context;
      com.tencent.mm.sdk.b.a.IbL.l(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(99736);
      return;
      paramView = ((TimeLineObject)localObject3).nDo;
      break;
      label1146:
      if (((TimeLineObject)localObject3).HAT.GaP == 3)
      {
        i = 5;
        continue;
        paramView = this.Aqp;
        paramView = com.tencent.mm.plugin.sns.c.a.iRH.e(paramView.context, str1, "timeline");
        if ((paramView == null) || (paramView.length() == 0))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99736);
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("type", -255);
        ((Intent)localObject1).putExtra("geta8key_scene", 2);
        com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject1, this.Aqp.context);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99736);
      }
      else
      {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo.15
 * JD-Core Version:    0.7.0.1
 */