package com.tencent.mm.plugin.record.ui.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.ag.a;
import com.tencent.mm.model.ag.b;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.LinkedList;

public final class b
  implements h.b
{
  ao handler;
  View.OnClickListener iu;
  private com.tencent.mm.sdk.b.c kce;
  private int qTc;
  private View.OnClickListener qTs;
  private h.a wkd;
  boolean wlf;
  private e.a wlg;
  
  public b(h.a parama, ao paramao)
  {
    AppMethodBeat.i(28018);
    this.qTc = 0;
    this.wlf = false;
    this.wlg = new e.a();
    this.iu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28015);
        Object localObject4 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        Object localObject1;
        Object localObject5;
        Object localObject3;
        Object localObject6;
        int i;
        switch (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dataType)
        {
        case 9: 
        case 12: 
        case 13: 
        case 18: 
        case 20: 
        case 21: 
        default: 
          AppMethodBeat.o(28015);
          return;
        case 5: 
          b.a(paramAnonymousView.findViewById(2131300874), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ);
          localObject2 = paramAnonymousView.getContext();
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ == null)
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg((Context)localObject2, ((Context)localObject2).getString(2131758977));
            AppMethodBeat.o(28015);
            return;
          }
          paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe;
          if (paramAnonymousView != null) {
            if (paramAnonymousView.EAk) {
              paramAnonymousView = paramAnonymousView.canvasPageXml;
            }
          }
          while (!bs.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("sns_landing_pages_xml", paramAnonymousView);
            ((Intent)localObject1).putExtra("sns_landig_pages_from_source", 5);
            ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.hhV);
            ((Intent)localObject1).addFlags(268435456);
            ((Intent)localObject1).putExtra("msg_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
            d.b((Context)localObject2, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject1, 1);
            AppMethodBeat.o(28015);
            return;
            if ((paramAnonymousView.EzZ != null) && (paramAnonymousView.EzZ.EAK != null) && (paramAnonymousView.EzZ.EAK.EAk)) {
              paramAnonymousView = paramAnonymousView.EzZ.EAK.canvasPageXml;
            } else {
              paramAnonymousView = null;
            }
          }
          localObject5 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAG;
          localObject1 = "";
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAK != null) {
            localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAK.ECl;
          }
          paramAnonymousView = (View)localObject1;
          if (localObject5 != null)
          {
            paramAnonymousView = (View)localObject1;
            if (bs.isNullOrNil((String)localObject1)) {
              paramAnonymousView = ((agz)localObject5).link;
            }
          }
          localObject1 = paramAnonymousView;
          if (bs.isNullOrNil(paramAnonymousView)) {
            localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezm;
          }
          if (bs.isNullOrNil((String)localObject1))
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg((Context)localObject2, ((Context)localObject2).getString(2131758977));
            AppMethodBeat.o(28015);
            return;
          }
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("rawUrl", (String)localObject1);
          if ((localObject5 != null) && (!bs.isNullOrNil(((agz)localObject5).cYF))) {
            ((Intent)localObject3).putExtra("srcDisplayname", com.tencent.mm.model.v.wk(((agz)localObject5).cYF));
          }
          ((Intent)localObject3).putExtra("mode", 1);
          b.Y((Context)localObject2, (Intent)localObject3);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            ((Intent)localObject3).putExtra("is_favorite_item", true);
            ((Intent)localObject3).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
            ((Intent)localObject3).putExtra("key_detail_can_delete", false);
            ((Intent)localObject3).putExtra("geta8key_scene", 14);
            ((Intent)localObject3).putExtra("from_scence", 4);
            paramAnonymousView = com.tencent.mm.modelstat.a.c.DB(com.tencent.mm.pluginsdk.model.f.class.getName());
            paramAnonymousView.putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_id);
            ((Intent)localObject3).putExtra("mm_report_bundle", paramAnonymousView);
          }
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dvs);
          ((Intent)localObject3).putExtra("jsapiargs", paramAnonymousView);
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.CoY != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.CoY.hha == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yr(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.CoY.hgY)))
          {
            localObject5 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ;
            ((Intent)localObject3).putExtra(e.b.HgX, 24);
            ((Intent)localObject3).putExtra(e.b.HgY, 10000);
            ((Intent)localObject3).putExtra("biz_video_session_id", com.tencent.mm.storage.v.getSessionId());
            localObject4 = ((agy)localObject5).CoY;
            localObject1 = new x();
            ((x)localObject1).ddo = ((ahf)localObject4).ddo;
            ((x)localObject1).hkV = ((ahf)localObject4).hkV;
            ((x)localObject1).hkX.url = ((Intent)localObject3).getStringExtra("rawUrl");
            localObject6 = ((x)localObject1).hkX;
            if (((agy)localObject5).EAK != null)
            {
              paramAnonymousView = ((agy)localObject5).EAK.title;
              ((com.tencent.mm.ah.v)localObject6).title = paramAnonymousView;
              localObject6 = ((x)localObject1).hkX;
              if (((agy)localObject5).EAK == null) {
                break label1223;
              }
            }
            for (paramAnonymousView = ((agy)localObject5).EAK.desc;; paramAnonymousView = "")
            {
              ((com.tencent.mm.ah.v)localObject6).hlf = paramAnonymousView;
              ((x)localObject1).hkX.hld = ((ahf)localObject4).hld;
              ((x)localObject1).hkX.title = bs.nullAsNil(((x)localObject1).hkX.title);
              ((x)localObject1).hkX.type = ((ahf)localObject4).hgY;
              ((x)localObject1).hkX.hhb = ((ahf)localObject4).hhb;
              ((x)localObject1).hkX.time = ((ahf)localObject4).hgZ;
              ((x)localObject1).hkX.hlh = ((ahf)localObject4).duration;
              ((x)localObject1).hkX.videoWidth = ((ahf)localObject4).videoWidth;
              ((x)localObject1).hkX.videoHeight = ((ahf)localObject4).videoHeight;
              ((x)localObject1).hkX.hhd = ((ahf)localObject4).hhd;
              ((x)localObject1).t((Intent)localObject3);
              ac.i("MicroMsg.OtherViewWrapper", "jump to native video");
              if (((ahf)localObject4).EBB != null) {
                ((Intent)localObject3).putExtra("img_gallery_width", ((ahf)localObject4).EBB.width).putExtra("img_gallery_height", ((ahf)localObject4).EBB.height).putExtra("img_gallery_left", ((ahf)localObject4).EBB.left).putExtra("img_gallery_top", ((ahf)localObject4).EBB.top);
              }
              ((Intent)localObject3).addFlags(268435456);
              i = (int)(System.currentTimeMillis() / 1000L);
              paramAnonymousView = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d(((x)localObject1).hkX.url, 24, 10000, i);
              if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((Context)localObject2, paramAnonymousView, ((x)localObject1).hkX.type, 24, 10000, (Intent)localObject3)) {
                d.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
              }
              AppMethodBeat.o(28015);
              return;
              paramAnonymousView = "";
              break;
            }
          }
          d.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", (Intent)localObject3, 1);
          AppMethodBeat.o(28015);
          return;
        case 22: 
          if ((!com.tencent.mm.plugin.fav.a.b.cph()) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EBc != null))
          {
            localObject1 = new Intent();
            localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EBc;
            if (!bs.isNullOrNil(((anx)localObject2).objectId))
            {
              ((Intent)localObject1).putExtra("feed_object_id", com.tencent.mm.ac.c.ur(((anx)localObject2).objectId));
              ((Intent)localObject1).putExtra("feed_object_nonceId", ((anx)localObject2).objectNonceId);
              localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
              if (!w.sQ(((dy)localObject2).field_talker)) {
                break label1433;
              }
              ((Intent)localObject1).putExtra("report_scene", 2);
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("from_user", ((dy)localObject2).field_talker);
              ((l)com.tencent.mm.kernel.g.ad(l.class)).enterFinderShareFeedUI(paramAnonymousView.getContext(), (Intent)localObject1);
              AppMethodBeat.o(28015);
              return;
              ((Intent)localObject1).putExtra("report_scene", 1);
            }
          }
          break;
        case 4: 
        case 15: 
          b.a(paramAnonymousView.findViewById(2131300874), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ);
          localObject5 = paramAnonymousView.getContext();
          paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe;
          boolean bool;
          if ((paramAnonymousView == null) || (paramAnonymousView.EzZ == null) || (paramAnonymousView.EzZ.EBa == null))
          {
            ac.w("MicroMsg.OtherViewWrapper", "handleMpVideoItem favMpMsgItem is null");
            bool = false;
          }
          while (!bool) {
            if (((bs.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezf)) && (bs.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EAx))) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzA <= 0L))
            {
              ac.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezw, Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzA) });
              localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezm;
              paramAnonymousView = (View)localObject1;
              if (bs.isNullOrNil((String)localObject1)) {
                paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezq;
              }
              if (bs.isNullOrNil(paramAnonymousView))
              {
                ac.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
                if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_itemStatus != 10) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EAn == 0))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
                  paramAnonymousView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw);
                  if (com.tencent.mm.plugin.record.b.g.c((com.tencent.mm.plugin.record.ui.a.b)localObject4))
                  {
                    b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4), com.tencent.mm.plugin.record.b.g.b((com.tencent.mm.plugin.record.ui.a.b)localObject4));
                    AppMethodBeat.o(28015);
                    return;
                    bool = r.a((Context)localObject5, paramAnonymousView.EzZ.EBa, paramAnonymousView);
                  }
                  else
                  {
                    com.tencent.mm.plugin.fav.a.b.a((Context)localObject5, ".ui.detail.FavoriteFileDetailUI", paramAnonymousView, 1);
                    AppMethodBeat.o(28015);
                  }
                }
                else
                {
                  localObject6 = new Intent();
                  localObject1 = "";
                  paramAnonymousView = "";
                  if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
                  {
                    localObject2 = com.tencent.mm.plugin.record.b.n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
                    if ((bs.isNullOrNil((String)localObject2)) || (!i.eA((String)localObject2)))
                    {
                      com.tencent.mm.ui.base.h.cg((Context)localObject5, ((Context)localObject5).getString(2131758978));
                      AppMethodBeat.o(28015);
                      return;
                    }
                    localObject3 = com.tencent.mm.plugin.record.b.n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
                    if (!bs.isNullOrNil((String)localObject3))
                    {
                      paramAnonymousView = (View)localObject2;
                      localObject1 = localObject3;
                      if (i.eA((String)localObject3)) {}
                    }
                    else
                    {
                      ((Intent)localObject6).putExtra("key_detail_data_valid", false);
                      localObject1 = localObject3;
                      paramAnonymousView = (View)localObject2;
                    }
                  }
                  for (;;)
                  {
                    b.a((Intent)localObject6, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, (String)localObject1, paramAnonymousView);
                    AppMethodBeat.o(28015);
                    return;
                    if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
                    {
                      localObject2 = com.tencent.mm.plugin.record.b.g.b((com.tencent.mm.plugin.record.ui.a.b)localObject4);
                      if ((bs.isNullOrNil((String)localObject2)) || (!i.eA((String)localObject2)))
                      {
                        com.tencent.mm.ui.base.h.cg((Context)localObject5, ((Context)localObject5).getString(2131758978));
                        AppMethodBeat.o(28015);
                        return;
                      }
                      localObject3 = com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4);
                      if (!bs.isNullOrNil((String)localObject3))
                      {
                        paramAnonymousView = (View)localObject2;
                        localObject1 = localObject3;
                        if (i.eA((String)localObject3)) {}
                      }
                      else
                      {
                        ((Intent)localObject6).putExtra("key_detail_data_valid", false);
                        paramAnonymousView = (View)localObject2;
                        localObject1 = localObject3;
                      }
                    }
                  }
                }
              }
              else
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
                if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
                {
                  ((Intent)localObject1).putExtra("is_favorite_item", true);
                  ((Intent)localObject1).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
                  ((Intent)localObject1).putExtra("key_detail_can_delete", false);
                  ((Intent)localObject1).putExtra("geta8key_scene", 14);
                  paramAnonymousView = com.tencent.mm.modelstat.a.c.DB(com.tencent.mm.pluginsdk.model.f.class.getName());
                  paramAnonymousView.putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_id);
                  ((Intent)localObject1).putExtra("mm_report_bundle", paramAnonymousView);
                  ac.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_id), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
                }
                d.b((Context)localObject5, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
                AppMethodBeat.o(28015);
              }
            }
            else
            {
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
                paramAnonymousView.putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dsP);
                paramAnonymousView.putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw);
                paramAnonymousView.putExtra("key_detail_fav_video_scene_from", 1);
                if (com.tencent.mm.plugin.record.b.n.d(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId))
                {
                  b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, com.tencent.mm.plugin.record.b.n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId), com.tencent.mm.plugin.record.b.n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId));
                  AppMethodBeat.o(28015);
                  return;
                }
                ac.i("MicroMsg.OtherViewWrapper", "RecordData.RECORD_TYPE: data not exist, go and download ");
                b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, com.tencent.mm.plugin.record.b.n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId), com.tencent.mm.plugin.record.b.n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId), false);
                AppMethodBeat.o(28015);
                return;
              }
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
                paramAnonymousView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw);
                if (com.tencent.mm.plugin.record.b.g.c((com.tencent.mm.plugin.record.ui.a.b)localObject4))
                {
                  b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4), com.tencent.mm.plugin.record.b.g.b((com.tencent.mm.plugin.record.ui.a.b)localObject4));
                  AppMethodBeat.o(28015);
                  return;
                }
                com.tencent.mm.plugin.fav.a.b.a((Context)localObject5, ".ui.detail.FavoriteFileDetailUI", paramAnonymousView, 1);
              }
            }
          }
          AppMethodBeat.o(28015);
          return;
        case 6: 
          label1223:
          localObject5 = paramAnonymousView.getContext();
          label1433:
          if (localObject5 != null)
          {
            localObject1 = null;
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ == null) {
              break label5272;
            }
            localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAI;
          }
          break;
        }
        label5272:
        for (Object localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAG;; localObject2 = null)
        {
          paramAnonymousView = null;
          if (localObject2 != null) {
            if (bs.isNullOrNil(((agz)localObject2).EBj)) {
              break label2652;
            }
          }
          label2652:
          for (paramAnonymousView = com.tencent.mm.model.v.wk(((agz)localObject2).EBj);; paramAnonymousView = com.tencent.mm.model.v.wk(((agz)localObject2).dng))
          {
            localObject3 = paramAnonymousView;
            if (localObject2 == null)
            {
              localObject3 = paramAnonymousView;
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) {
                localObject3 = com.tencent.mm.model.v.wk(((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_fromUser);
              }
            }
            if (localObject1 != null) {
              break;
            }
            ac.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg((Context)localObject5, ((Context)localObject5).getString(2131758969));
            AppMethodBeat.o(28015);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("kwebmap_slat", ((ahe)localObject1).lat);
          paramAnonymousView.putExtra("kwebmap_lng", ((ahe)localObject1).lng);
          paramAnonymousView.putExtra("kPoiName", ((ahe)localObject1).dry);
          paramAnonymousView.putExtra("Kwebmap_locaion", ((ahe)localObject1).label);
          if (((ahe)localObject1).dmN >= 0) {
            paramAnonymousView.putExtra("kwebmap_scale", ((ahe)localObject1).dmN);
          }
          paramAnonymousView.putExtra("kisUsername", (String)localObject3);
          paramAnonymousView.putExtra("kwebmap_from_to", true);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            paramAnonymousView.putExtra("KFavLocSigleView", true);
            paramAnonymousView.putExtra("map_view_type", 2);
            paramAnonymousView.putExtra("kFavInfoLocalId", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
            paramAnonymousView.putExtra("kFavCanDel", false);
            paramAnonymousView.putExtra("kFavCanRemark", false);
            d.b((Context)localObject5, "location", ".ui.RedirectUI", paramAnonymousView, 1);
            AppMethodBeat.o(28015);
            return;
          }
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
          {
            paramAnonymousView.putExtra("map_view_type", 1);
            d.b((Context)localObject5, "location", ".ui.RedirectUI", paramAnonymousView, 1002);
          }
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = paramAnonymousView.getContext();
          localObject1 = new Intent();
          if (bs.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezm))
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            ((Intent)localObject1).putExtra("rawUrl", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezo);
          }
          for (;;)
          {
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
            {
              ((Intent)localObject1).putExtra("is_favorite_item", true);
              ((Intent)localObject1).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
              ((Intent)localObject1).putExtra("key_detail_can_delete", false);
              localObject2 = com.tencent.mm.modelstat.a.c.DB(com.tencent.mm.pluginsdk.model.f.class.getName());
              ((Bundle)localObject2).putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_id);
              ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
              ac.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_id), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            }
            d.b(paramAnonymousView, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
            AppMethodBeat.o(28015);
            return;
            ((Intent)localObject1).putExtra("rawUrl", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezm);
          }
          paramAnonymousView = paramAnonymousView.getContext();
          long l = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId;
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().vP(l);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(HandOffFile.a(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo, (bo)localObject1));
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
          {
            if ((!com.tencent.mm.plugin.record.b.n.d(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId)) || (com.tencent.mm.pluginsdk.ui.tools.a.ae(com.tencent.mm.plugin.record.b.n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezu, 2))) {
              break label3487;
            }
            i = 0;
            if (i != 0) {
              break label3497;
            }
            az.ayM();
            paramAnonymousView = com.tencent.mm.model.c.awD().vP(((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzA <= 26214400L) {
              break label3492;
            }
          }
          label3487:
          label3492:
          for (i = 7;; i = 5)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1203L, 0L, 1L, false);
            paramAnonymousView = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezf, Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzA), Integer.valueOf(4), Long.valueOf((ce.azI() - paramAnonymousView.field_createTime) / 1000L), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezu, paramAnonymousView.field_talker, Integer.valueOf(2), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw, Long.valueOf(paramAnonymousView.field_msgSvrId), Long.valueOf(paramAnonymousView.field_createTime) });
            ac.i("MicroMsg.OtherViewWrapper", "reportKVStat 14665 %s", new Object[] { paramAnonymousView });
            com.tencent.mm.plugin.report.service.h.wUl.kvStat(14665, paramAnonymousView);
            AppMethodBeat.o(28015);
            return;
            if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) && (com.tencent.mm.plugin.record.b.g.c((com.tencent.mm.plugin.record.ui.a.b)localObject4)) && (!com.tencent.mm.pluginsdk.ui.tools.a.ae(com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.Ezu, 2)))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
          }
          label3497:
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
          {
            localObject1 = new Intent(paramAnonymousView, RecordMsgFileUI.class);
            ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
            ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dsP);
            ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToFile", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToFile", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(28015);
            return;
          }
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            if (com.tencent.mm.plugin.record.b.n.h(((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
              com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView, ".ui.detail.FavoriteImgDetailUI", (Intent)localObject1, 1);
              AppMethodBeat.o(28015);
              return;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
            ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw);
            ((Intent)localObject1).putExtra("key_detail_can_delete", false);
            com.tencent.mm.plugin.fav.a.b.a(paramAnonymousView, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject1, 1);
          }
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = paramAnonymousView.getContext();
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAM == null))
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg(paramAnonymousView, paramAnonymousView.getString(2131758968));
            AppMethodBeat.o(28015);
            return;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_Product_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAM.info);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            ((Intent)localObject1).putExtra("key_is_favorite_item", true);
            ((Intent)localObject1).putExtra("key_favorite_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
            ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
            ((Intent)localObject1).putExtra("key_ProductUI_getProductInfoScene", 3);
          }
          d.b(paramAnonymousView, "scanner", ".ui.ProductUI", (Intent)localObject1, 1);
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = paramAnonymousView.getContext();
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAM == null))
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg(paramAnonymousView, paramAnonymousView.getString(2131758968));
            AppMethodBeat.o(28015);
            return;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_product_info", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAM.info);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) {
            ((Intent)localObject1).putExtra("key_product_scene", 4);
          }
          d.b(paramAnonymousView, "product", ".ui.MallProductUI", (Intent)localObject1, 1);
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = paramAnonymousView.getContext();
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAO == null))
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg(paramAnonymousView, paramAnonymousView.getString(2131758968));
            AppMethodBeat.o(28015);
            return;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_TV_getProductInfoScene", 3);
          ((Intent)localObject1).putExtra("key_TV_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ.EAO.info);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            ((Intent)localObject1).putExtra("key_is_favorite_item", true);
            ((Intent)localObject1).putExtra("key_favorite_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).oOo.field_localId);
            ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
          }
          d.b(paramAnonymousView, "shake", ".ui.TVInfoUI", (Intent)localObject1, 1);
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = paramAnonymousView.getContext();
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ == null)
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg(paramAnonymousView, paramAnonymousView.getString(2131758968));
            AppMethodBeat.o(28015);
            return;
          }
          localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.desc;
          az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().alw((String)localObject2);
          if (localObject1 == null)
          {
            ac.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[] { localObject2, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.dhw });
            com.tencent.mm.ui.base.h.cg(paramAnonymousView, paramAnonymousView.getString(2131758968));
            AppMethodBeat.o(28015);
            return;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", ((bo.a)localObject1).zTO);
          ((Intent)localObject2).putExtra("Contact_Alias", ((bo.a)localObject1).eNf);
          ((Intent)localObject2).putExtra("Contact_Nick", ((bo.a)localObject1).nickname);
          ((Intent)localObject2).putExtra("Contact_QuanPin", ((bo.a)localObject1).iLM);
          ((Intent)localObject2).putExtra("Contact_PyInitial", ((bo.a)localObject1).iLL);
          ((Intent)localObject2).putExtra("Contact_Uin", ((bo.a)localObject1).vLk);
          ((Intent)localObject2).putExtra("Contact_Mobile_MD5", ((bo.a)localObject1).GYX);
          ((Intent)localObject2).putExtra("Contact_full_Mobile_MD5", ((bo.a)localObject1).GYY);
          ((Intent)localObject2).putExtra("Contact_QQNick", ((bo.a)localObject1).fcl());
          ((Intent)localObject2).putExtra("User_From_Fmessage", false);
          ((Intent)localObject2).putExtra("Contact_Scene", ((bo.a)localObject1).scene);
          ((Intent)localObject2).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject2).putExtra("Contact_RemarkName", ((bo.a)localObject1).iLQ);
          ((Intent)localObject2).putExtra("Contact_VUser_Info_Flag", ((bo.a)localObject1).Chb);
          ((Intent)localObject2).putExtra("Contact_VUser_Info", ((bo.a)localObject1).eya);
          ((Intent)localObject2).putExtra("Contact_BrandIconURL", ((bo.a)localObject1).vIX);
          ((Intent)localObject2).putExtra("Contact_Province", ((bo.a)localObject1).getProvince());
          ((Intent)localObject2).putExtra("Contact_City", ((bo.a)localObject1).getCity());
          ((Intent)localObject2).putExtra("Contact_Sex", ((bo.a)localObject1).exL);
          ((Intent)localObject2).putExtra("Contact_Signature", ((bo.a)localObject1).signature);
          ((Intent)localObject2).putExtra("Contact_ShowUserName", false);
          ((Intent)localObject2).putExtra("Contact_KSnsIFlag", 0);
          b.Y(paramAnonymousView, (Intent)localObject2);
          d.b(paramAnonymousView, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 1);
          com.tencent.mm.bs.a.XC(((bo.a)localObject1).scene);
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = paramAnonymousView.getContext();
          if (paramAnonymousView != null)
          {
            if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EAp != null))
            {
              localObject1 = new Intent(paramAnonymousView, RecordMsgDetailUI.class);
              ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
              ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EAp);
              ((Intent)localObject1).putExtra("record_nest", true);
              b.Y(paramAnonymousView, (Intent)localObject1);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToRecord", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToRecord", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(28015);
            return;
            localObject5 = paramAnonymousView.getContext();
            if (localObject5 != null)
            {
              paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).dhe.EzZ;
              if (paramAnonymousView != null)
              {
                localObject4 = paramAnonymousView.EAX;
                if (localObject4 != null)
                {
                  localObject6 = new com.tencent.mm.plugin.appbrand.a.f();
                  ((com.tencent.mm.plugin.appbrand.a.f)localObject6).scene = 1096;
                  if (paramAnonymousView.EAG != null) {
                    ((com.tencent.mm.plugin.appbrand.a.f)localObject6).cYP = paramAnonymousView.EAG.dng;
                  }
                  ((com.tencent.mm.plugin.appbrand.a.f)localObject6).username = ((agv)localObject4).username;
                  ((com.tencent.mm.plugin.appbrand.a.f)localObject6).jjf = ((agv)localObject4).cYQ;
                  ((com.tencent.mm.plugin.appbrand.a.f)localObject6).hxM = ((agv)localObject4).dib;
                  ((com.tencent.mm.plugin.appbrand.a.f)localObject6).version = -1;
                  ((com.tencent.mm.plugin.appbrand.a.f)localObject6).appId = ((agv)localObject4).appId;
                  int j = -1;
                  localObject2 = null;
                  localObject3 = null;
                  localObject1 = localObject3;
                  paramAnonymousView = (View)localObject2;
                  i = j;
                  if ((localObject5 instanceof Activity))
                  {
                    Intent localIntent = ((Activity)localObject5).getIntent();
                    localObject1 = localObject3;
                    paramAnonymousView = (View)localObject2;
                    i = j;
                    if (localIntent != null)
                    {
                      i = localIntent.getIntExtra("preChatTYPE", 2);
                      paramAnonymousView = localIntent.getStringExtra("preUsername");
                      localObject1 = localIntent.getStringExtra("preChatName");
                    }
                  }
                  switch (i)
                  {
                  default: 
                    i = 0;
                  }
                }
              }
              for (;;)
              {
                localObject2 = new AppBrandLaunchReferrer();
                ((AppBrandLaunchReferrer)localObject2).jDQ = 6;
                ((AppBrandLaunchReferrer)localObject2).dxK = ((agv)localObject4).dxK;
                ((com.tencent.mm.plugin.appbrand.a.f)localObject6).jji = i;
                ((com.tencent.mm.plugin.appbrand.a.f)localObject6).jjj = String.format("%s:%s", new Object[] { paramAnonymousView, localObject1 });
                ((com.tencent.mm.plugin.appbrand.a.f)localObject6).jjo = ((AppBrandLaunchReferrer)localObject2);
                ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a((Context)localObject5, (com.tencent.mm.plugin.appbrand.a.f)localObject6);
                AppMethodBeat.o(28015);
                return;
                i = 2;
                continue;
                i = 1;
                continue;
                i = 5;
              }
            }
          }
          AppMethodBeat.o(28015);
          return;
        }
      }
    };
    this.qTs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28016);
        if (!com.tencent.mm.compatible.util.e.YD())
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(28016);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        agz localagz;
        if (b.f(((com.tencent.mm.plugin.record.ui.a.b)localObject).dhe))
        {
          ac.i("MicroMsg.OtherViewWrapper", "same song, do release");
          com.tencent.mm.ay.a.aGt();
          if (!b.this.wlf)
          {
            b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
            AppMethodBeat.o(28016);
          }
        }
        else
        {
          b.this.wlf = true;
          localagz = ((com.tencent.mm.plugin.record.ui.a.b)localObject).dhe.EzZ.EAG;
          paramAnonymousView = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.record.b.n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject).dhe, ((com.tencent.mm.plugin.record.ui.a.b)localObject).msgId));
          if (paramAnonymousView.exists()) {
            break label358;
          }
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject).dhe.dbZ != null) {
            break label283;
          }
          paramAnonymousView = "";
        }
        for (;;)
        {
          localObject = ((com.tencent.mm.plugin.record.ui.a.b)localObject).dhe;
          String str1 = ((agx)localObject).title;
          String str2 = ((agx)localObject).desc;
          String str3 = ((agx)localObject).Ezm;
          String str4 = ((agx)localObject).Ezq;
          String str5 = ((agx)localObject).Ezo;
          String str6 = ((agx)localObject).dhw;
          StringBuilder localStringBuilder = new StringBuilder();
          az.ayM();
          paramAnonymousView = com.tencent.mm.ay.g.a(6, null, str1, str2, str3, str4, str5, str6, com.tencent.mm.model.c.awV() + "web/", paramAnonymousView, "", localagz.appId);
          paramAnonymousView.hOj = ((agx)localObject).songAlbumUrl;
          paramAnonymousView.hOb = ((agx)localObject).songLyric;
          paramAnonymousView.hOt = ((agx)localObject).dhw;
          com.tencent.mm.ay.a.c(paramAnonymousView);
          AppMethodBeat.o(28016);
          return;
          label283:
          paramAnonymousView = new StringBuilder();
          az.ayM();
          paramAnonymousView = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.awV() + "web/" + com.tencent.mm.b.g.getMessageDigest(((com.tencent.mm.plugin.record.ui.a.b)localObject).dhe.dbZ.getBytes()));
          if (paramAnonymousView.exists()) {}
          for (paramAnonymousView = q.B(paramAnonymousView.fxV());; paramAnonymousView = "") {
            break;
          }
          label358:
          paramAnonymousView = q.B(paramAnonymousView.fxV());
        }
      }
    };
    this.kce = new b.3(this);
    this.wkd = parama;
    this.handler = paramao;
    AppMethodBeat.o(28018);
  }
  
  static void Y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(28026);
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getIntent();
      if (paramContext != null)
      {
        paramIntent.putExtra("prePublishId", paramContext.getStringExtra("prePublishId"));
        paramIntent.putExtra("preUsername", paramContext.getStringExtra("preUsername"));
        paramIntent.putExtra("preChatName", paramContext.getStringExtra("preChatName"));
        paramIntent.putExtra("preChatTYPE", paramContext.getIntExtra("preChatTYPE", 0));
      }
    }
    AppMethodBeat.o(28026);
  }
  
  static void a(Intent paramIntent, com.tencent.mm.plugin.record.ui.a.b paramb, Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28024);
    a(paramIntent, paramb, paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(28024);
  }
  
  static void a(Intent paramIntent, com.tencent.mm.plugin.record.ui.a.b paramb, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(28025);
    paramIntent.putExtra("key_detail_fav_path", paramString1);
    paramIntent.putExtra("key_detail_fav_thumb_path", paramString2);
    paramIntent.putExtra("key_detail_fav_video_duration", paramb.dhe.duration);
    paramIntent.putExtra("key_detail_statExtStr", paramb.dhe.dvs);
    paramIntent.putExtra("key_detail_is_data_exist", paramBoolean);
    paramIntent.putExtra("key_detail_msg_uuid", paramb.dhe.iaU);
    com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", paramIntent, 1);
    AppMethodBeat.o(28025);
  }
  
  public static boolean f(agx paramagx)
  {
    AppMethodBeat.i(28021);
    com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
    if ((localf != null) && (localf.hNQ == 6) && (bs.bG(paramagx.dhw, "").equals(localf.hNS)) && (com.tencent.mm.ay.a.aGv()))
    {
      AppMethodBeat.o(28021);
      return true;
    }
    AppMethodBeat.o(28021);
    return false;
  }
  
  private static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(28020);
    ag.b localb = ag.a.hnu;
    if (localb != null)
    {
      paramContext = localb.s(paramContext, paramString);
      AppMethodBeat.o(28020);
      return paramContext;
    }
    AppMethodBeat.o(28020);
    return "";
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28022);
    TextView localTextView2 = (TextView)paramView.findViewById(2131305902);
    Object localObject2 = (TextView)paramView.findViewById(2131298996);
    TextView localTextView1 = (TextView)paramView.findViewById(2131305128);
    paramObject = (MMImageView)paramView.findViewById(2131300874);
    paramObject.setVisibility(0);
    ImageView localImageView = (ImageView)paramView.findViewById(2131300895);
    localImageView.setVisibility(8);
    Object localObject1 = paramView.findViewById(2131303893);
    ((View)localObject1).setVisibility(0);
    ((View)localObject1).setTag(paramb);
    ((View)localObject1).setOnClickListener(this.iu);
    paramView = paramView.findViewById(2131306197);
    paramView.setVisibility(8);
    h.a.a locala = new h.a.a();
    if (paramb.dataType == 0) {
      locala.wkf = paramb.msgId;
    }
    for (;;)
    {
      locala.dhf = paramObject;
      locala.dhe = paramb.dhe;
      locala.height = this.qTc;
      locala.width = this.qTc;
      switch (paramb.dhe.dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 20: 
      case 21: 
      default: 
        ((View)localObject1).setVisibility(8);
        paramView.setVisibility(0);
        AppMethodBeat.o(28022);
        return;
        if (paramb.dataType == 1) {
          locala.wkf = paramb.oOo.field_localId;
        }
        break;
      }
    }
    agx localagx = paramb.dhe;
    paramView = "";
    localObject1 = null;
    paramObject = localObject1;
    if (localagx != null)
    {
      paramObject = localObject1;
      if (localagx.EzZ != null) {
        paramObject = localagx.EzZ.EAK;
      }
    }
    if (paramObject != null) {
      paramView = paramObject.title;
    }
    localObject1 = paramView;
    if (bs.isNullOrNil(paramView))
    {
      localObject1 = paramView;
      if (localagx != null) {
        localObject1 = localagx.title;
      }
    }
    if (bs.isNullOrNil((String)localObject1))
    {
      localTextView2.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      paramView = "";
      if (paramObject != null) {
        paramView = bs.TE(paramObject.ECl);
      }
      paramObject = null;
      localObject2 = paramObject;
      if (localagx != null)
      {
        localObject2 = paramObject;
        if (localagx.EzZ != null) {
          localObject2 = localagx.EzZ.EAG;
        }
      }
      localObject1 = paramView;
      if (localObject2 != null)
      {
        if (bs.isNullOrNil(((agz)localObject2).appId)) {
          break label669;
        }
        paramObject = bs.bG(getAppName(localTextView1.getContext(), ((agz)localObject2).appId), "");
        label509:
        if (!bs.isNullOrNil(paramObject))
        {
          localObject1 = paramObject;
          if (!paramObject.equals(((agz)localObject2).cYF)) {}
        }
        else
        {
          localObject1 = bs.TE(((agz)localObject2).link);
        }
      }
      if (!bs.isNullOrNil((String)localObject1)) {
        break label755;
      }
      localTextView1.setVisibility(8);
      label559:
      locala.dhg = 2131230944;
      this.wkd.a(locala);
      if ((paramb.dhe != null) && (paramb.dhe.EzZ != null) && (paramb.dhe.EzZ.CoY != null) && (paramb.dhe.EzZ.CoY.hgY == 5))
      {
        localImageView.setVisibility(0);
        localImageView.setImageResource(2131234474);
      }
    }
    for (;;)
    {
      localTextView1.setVisibility(8);
      AppMethodBeat.o(28022);
      return;
      localTextView2.setText((CharSequence)localObject1);
      localTextView2.setVisibility(0);
      break;
      label669:
      paramObject = paramView;
      if (bs.isNullOrNil(((agz)localObject2).cYF)) {
        break label509;
      }
      az.ayM();
      paramObject = com.tencent.mm.model.c.awB().aNt(((agz)localObject2).cYF);
      if ((paramObject == null) || (!paramObject.field_username.equals(((agz)localObject2).cYF)))
      {
        ar.a.hnw.a(((agz)localObject2).cYF, "", null);
        paramObject = paramView;
        break label509;
      }
      paramObject = paramObject.aaS();
      break label509;
      label755:
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setVisibility(0);
      break label559;
      if (com.tencent.mm.plugin.fav.a.b.cph())
      {
        ((View)localObject1).setVisibility(8);
        paramView.setVisibility(0);
      }
      else
      {
        paramView = paramb.dhe;
        if ((paramView.EzZ != null) && (paramView.EzZ.EBc != null))
        {
          paramView = paramView.EzZ.EBc;
          localTextView2.setText(bs.nullAsNil(paramView.nickname + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759007)));
          localTextView2.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          if (!bs.gY(paramView.mediaList))
          {
            paramb = com.tencent.mm.loader.e.gIC;
            paramb = com.tencent.mm.loader.e.anT();
            paramView = ((anw)paramView.mediaList.get(0)).thumbUrl;
            localObject1 = this.wlg;
            ((e.a)localObject1).gKq = true;
            ((e.a)localObject1).gKp = true;
            paramb.a(paramView, paramObject, ((e.a)localObject1).aot());
          }
        }
        localImageView.setVisibility(8);
        continue;
        paramb = paramb.dhe;
        if (bs.isNullOrNil(paramb.title))
        {
          localTextView2.setText(2131759030);
          label968:
          if (paramb.duration > 0) {
            break label1064;
          }
          ((TextView)localObject2).setVisibility(8);
          if (paramb.EzZ != null) {
            break label1185;
          }
          ac.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", new Object[] { paramb.dhw });
          localTextView1.setVisibility(8);
        }
        for (;;)
        {
          localImageView.setVisibility(0);
          localImageView.setImageResource(2131234474);
          locala.dhg = 2131689581;
          this.wkd.a(locala);
          break;
          localTextView2.setText(paramb.title);
          break label968;
          label1064:
          ((TextView)localObject2).setVisibility(0);
          paramView = ((TextView)localObject2).getContext();
          int i = paramb.duration;
          if (i <= 0) {
            paramView = paramView.getString(2131759032, new Object[] { Integer.valueOf(0) });
          }
          for (;;)
          {
            ((TextView)localObject2).setText(paramView);
            break;
            paramInt = i / 60;
            i %= 60;
            if (paramInt == 0) {
              paramView = paramView.getString(2131759032, new Object[] { Integer.valueOf(i) });
            } else {
              paramView = paramView.getString(2131759031, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            }
          }
          label1185:
          paramView = paramb.EzZ.EAG;
          if (!bs.isNullOrNil(paramView.appId))
          {
            paramView = getAppName(localTextView1.getContext(), paramView.appId);
            if (bs.isNullOrNil(paramView))
            {
              localTextView1.setVisibility(8);
            }
            else
            {
              localTextView1.setVisibility(0);
              localTextView1.setText(paramView);
            }
          }
        }
        paramView = paramb.dhe;
        if (paramView.EzZ == null)
        {
          ac.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", new Object[] { paramView.dhw });
          localTextView2.setText(2131758924);
          ((TextView)localObject2).setText("");
          localTextView1.setText("");
        }
        for (;;)
        {
          paramObject.setImageResource(2131689562);
          break;
          paramView = paramView.EzZ.EAI;
          if (bs.isNullOrNil(paramView.dry))
          {
            localTextView2.setText(paramView.label);
            ((TextView)localObject2).setText(2131758924);
            localTextView1.setText("");
          }
          else
          {
            localTextView2.setText(paramView.dry);
            ((TextView)localObject2).setText(paramView.label);
            localTextView1.setText(2131758924);
          }
        }
        localTextView2.setText(paramb.dhe.title);
        ((TextView)localObject2).setText(paramb.dhe.desc);
        localImageView.setTag(paramb);
        localImageView.setOnClickListener(this.qTs);
        localImageView.setImageResource(2131233395);
        localImageView.setVisibility(0);
        if (f(paramb.dhe)) {
          localImageView.setImageResource(2131233393);
        }
        localTextView1.setVisibility(8);
        locala.dhg = 2131689564;
        this.wkd.a(locala);
        continue;
        paramView = paramb.dhe;
        localTextView2.setText(paramView.title);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(bs.aX((float)paramView.EzA));
        localTextView1.setVisibility(8);
        if (paramView.EAn == 2) {
          ((TextView)localObject2).setText(">" + ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(false) + "MB");
        }
        paramObject.setImageResource(com.tencent.mm.pluginsdk.e.aFI(paramb.dhe.Ezu));
        continue;
        paramView = paramb.dhe;
        if (paramView.EzZ == null)
        {
          ac.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", new Object[] { paramView.dhw });
          localTextView2.setText("");
          ((TextView)localObject2).setText("");
          localTextView1.setText("");
        }
        for (;;)
        {
          locala.dhg = 2131689577;
          this.wkd.a(locala);
          break;
          paramb = paramView.EzZ.EAM;
          localTextView2.setText(paramb.title);
          ((TextView)localObject2).setText(paramb.desc);
          paramView = paramView.EzZ.EAG;
          localTextView1.setText(bs.bG(getAppName(localTextView1.getContext(), paramView.appId), localTextView1.getContext().getString(2131758954)));
        }
        paramView = paramb.dhe;
        if (paramView.EzZ == null)
        {
          ac.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", new Object[] { paramView.dhw });
          localTextView2.setText("");
          ((TextView)localObject2).setText("");
          localTextView1.setText("");
        }
        for (;;)
        {
          locala.dhg = 2131689577;
          locala.dhe = null;
          this.wkd.a(locala);
          break;
          paramView = paramView.EzZ.EAM;
          localTextView2.setText(paramView.title);
          ((TextView)localObject2).setText(paramView.desc);
          localTextView2.setSingleLine(false);
          localTextView2.setMaxLines(2);
          localTextView1.setVisibility(8);
        }
        paramView = paramb.dhe;
        if ((paramView.EzZ == null) || (paramView.EzZ.EAO == null))
        {
          ac.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", new Object[] { paramView.dhw });
          localTextView2.setText("");
          ((TextView)localObject2).setText("");
          localTextView1.setText("");
        }
        for (;;)
        {
          locala.dhg = 2131689577;
          locala.dhe = null;
          this.wkd.a(locala);
          break;
          paramb = paramView.EzZ.EAO;
          localTextView2.setText(paramb.title);
          ((TextView)localObject2).setText(paramb.desc);
          paramView = paramView.EzZ.EAG;
          localTextView1.setText(bs.bG(getAppName(localTextView1.getContext(), paramView.appId), localTextView1.getContext().getString(2131759026)));
        }
        paramView = paramb.dhe;
        az.ayM();
        paramb = com.tencent.mm.model.c.awD().alw(paramView.desc);
        if (paramb == null) {
          ac.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
        }
        localObject1 = localTextView2.getContext();
        if (paramb != null) {}
        for (paramView = paramb.nickname;; paramView = "")
        {
          localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject1, paramView, localTextView2.getTextSize()));
          ((TextView)localObject2).setVisibility(8);
          localTextView1.setText(2131758907);
          localTextView1.setVisibility(0);
          paramView = paramb.zTO;
          if (!bs.isNullOrNil(paramView)) {
            break label2143;
          }
          paramObject.setImageResource(2131231875);
          break;
        }
        label2143:
        a.b.c(paramObject, paramView);
        continue;
        paramView = paramb.dhe;
        localTextView2.setText(paramView.title);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramView.desc);
        paramObject.setVisibility(8);
        continue;
        localObject1 = paramb.dhe;
        paramInt = paramb.dhe.dataType;
        paramView = "";
        if (localObject1 != null) {
          paramView = ((agx)localObject1).title;
        }
        if (bs.isNullOrNil(paramView))
        {
          localTextView2.setVisibility(8);
          label2233:
          paramView = "";
          if (19 == paramInt) {
            paramView = ((TextView)localObject2).getContext().getString(2131755401);
          }
          if (!bs.isNullOrNil(paramView)) {
            break label2346;
          }
          ((TextView)localObject2).setVisibility(8);
          label2268:
          paramView = new h.a.c();
          paramView.dhe = paramb.dhe;
          if (paramb.dataType != 0) {
            break label2361;
          }
          paramView.wkf = paramb.msgId;
        }
        for (;;)
        {
          locala.dhg = 2131230944;
          paramView = this.wkd.a(paramView);
          if (paramView == null) {
            break label2383;
          }
          paramObject.setImageBitmap(paramView);
          break;
          localTextView2.setText(paramView);
          localTextView2.setVisibility(0);
          break label2233;
          label2346:
          ((TextView)localObject2).setText(paramView);
          ((TextView)localObject2).setVisibility(0);
          break label2268;
          label2361:
          if (paramb.dataType == 1) {
            paramView.wkf = paramb.oOo.field_localId;
          }
        }
        label2383:
        this.wkd.a(locala);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28019);
    View localView = View.inflate(paramContext, 2131495216, null);
    this.qTc = com.tencent.mm.cc.a.fromDPToPix(paramContext, 75);
    com.tencent.mm.sdk.b.a.GpY.c(this.kce);
    AppMethodBeat.o(28019);
    return localView;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28023);
    ac.d("MicroMsg.OtherViewWrapper", "do destroy");
    this.wkd = null;
    this.handler = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    this.wlf = false;
    AppMethodBeat.o(28023);
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.b
 * JD-Core Version:    0.7.0.1
 */