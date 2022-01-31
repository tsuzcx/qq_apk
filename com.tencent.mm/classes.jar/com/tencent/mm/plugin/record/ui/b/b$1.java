package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.af.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.a;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24350);
    Object localObject4 = (com.tencent.mm.plugin.record.ui.a.b)paramView.getTag();
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject5;
    Object localObject6;
    switch (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.dataType)
    {
    case 9: 
    case 12: 
    case 13: 
    case 18: 
    default: 
      AppMethodBeat.o(24350);
      return;
    case 5: 
      localObject2 = paramView.findViewById(2131820929);
      localObject3 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw;
      if ((localObject2 == null) || (((acb)localObject3).uVl == null) || (((acb)localObject3).uVl.fgh < 0)) {}
      for (;;)
      {
        localObject2 = paramView.getContext();
        if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw != null) {
          break;
        }
        ab.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
        com.tencent.mm.ui.base.h.bO((Context)localObject2, ((Context)localObject2).getString(2131299803));
        AppMethodBeat.o(24350);
        return;
        localObject1 = new int[2];
        if (localObject2 != null)
        {
          i = ((View)localObject2).getWidth();
          int j = ((View)localObject2).getHeight();
          ((View)localObject2).getLocationInWindow((int[])localObject1);
          localObject2 = ((acb)localObject3).uVl;
          ((aci)localObject2).wUS = new acj();
          ((aci)localObject2).wUS.left = localObject1[0];
          ((aci)localObject2).wUS.top = localObject1[1];
          ((aci)localObject2).wUS.width = i;
          ((aci)localObject2).wUS.height = j;
        }
      }
      paramView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL;
      if (paramView != null) {
        if (paramView.wTH) {
          paramView = paramView.canvasPageXml;
        }
      }
      while (!bo.isNullOrNil(paramView))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("sns_landing_pages_xml", paramView);
        ((Intent)localObject1).putExtra("sns_landig_pages_from_source", 5);
        ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.fgM);
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("msg_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO);
        com.tencent.mm.bq.d.b((Context)localObject2, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject1, 1);
        AppMethodBeat.o(24350);
        return;
        if ((paramView.wTw != null) && (paramView.wTw.wUf != null) && (paramView.wTw.wUf.wTH)) {
          paramView = paramView.wTw.wUf.canvasPageXml;
        } else {
          paramView = null;
        }
      }
      localObject5 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUb;
      localObject1 = "";
      if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUf != null) {
        localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUf.wVF;
      }
      paramView = (View)localObject1;
      if (localObject5 != null)
      {
        paramView = (View)localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          paramView = ((acc)localObject5).link;
        }
      }
      localObject1 = paramView;
      if (bo.isNullOrNil(paramView)) {
        localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSJ;
      }
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
        com.tencent.mm.ui.base.h.bO((Context)localObject2, ((Context)localObject2).getString(2131299803));
        AppMethodBeat.o(24350);
        return;
      }
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("rawUrl", (String)localObject1);
      if ((localObject5 != null) && (!bo.isNullOrNil(((acc)localObject5).cmx))) {
        ((Intent)localObject3).putExtra("srcDisplayname", com.tencent.mm.model.s.nE(((acc)localObject5).cmx));
      }
      ((Intent)localObject3).putExtra("mode", 1);
      b.y((Context)localObject2, (Intent)localObject3);
      if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
      {
        ((Intent)localObject3).putExtra("is_favorite_item", true);
        ((Intent)localObject3).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
        ((Intent)localObject3).putExtra("key_detail_can_delete", false);
        ((Intent)localObject3).putExtra("geta8key_scene", 14);
        ((Intent)localObject3).putExtra("from_scence", 4);
        paramView = com.tencent.mm.modelstat.a.c.uJ(com.tencent.mm.pluginsdk.model.d.class.getName());
        paramView.putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_id);
        ((Intent)localObject3).putExtra("mm_report_bundle", paramView);
      }
      paramView = new Bundle();
      paramView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.cGU);
      ((Intent)localObject3).putExtra("jsapiargs", paramView);
      if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.uVl != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.uVl.fgj == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rT(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.uVl.fgh)))
      {
        localObject5 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw;
        ((Intent)localObject3).putExtra("biz_video_scene", 0);
        ((Intent)localObject3).putExtra("biz_video_subscene", 10000);
        ((Intent)localObject3).putExtra("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
        localObject1 = ((acb)localObject5).uVl;
        localObject4 = new com.tencent.mm.af.s();
        ((com.tencent.mm.af.s)localObject4).cqX = ((aci)localObject1).cqX;
        ((com.tencent.mm.af.s)localObject4).fjB = ((aci)localObject1).fjB;
        ((com.tencent.mm.af.s)localObject4).fjD.url = ((Intent)localObject3).getStringExtra("rawUrl");
        localObject6 = ((com.tencent.mm.af.s)localObject4).fjD;
        if (((acb)localObject5).wUf != null)
        {
          paramView = ((acb)localObject5).wUf.title;
          ((q)localObject6).title = paramView;
          localObject6 = ((com.tencent.mm.af.s)localObject4).fjD;
          if (((acb)localObject5).wUf == null) {
            break label1287;
          }
        }
        for (paramView = ((acb)localObject5).wUf.desc;; paramView = "")
        {
          ((q)localObject6).fjL = paramView;
          ((com.tencent.mm.af.s)localObject4).fjD.fjJ = ((aci)localObject1).fjJ;
          ((com.tencent.mm.af.s)localObject4).fjD.title = bo.nullAsNil(((com.tencent.mm.af.s)localObject4).fjD.title);
          ((com.tencent.mm.af.s)localObject4).fjD.type = ((aci)localObject1).fgh;
          ((com.tencent.mm.af.s)localObject4).fjD.time = ((aci)localObject1).fgi;
          ((com.tencent.mm.af.s)localObject4).fjD.fjN = ((aci)localObject1).duration;
          ((com.tencent.mm.af.s)localObject4).fjD.videoWidth = ((aci)localObject1).videoWidth;
          ((com.tencent.mm.af.s)localObject4).fjD.videoHeight = ((aci)localObject1).videoHeight;
          ((com.tencent.mm.af.s)localObject4).fjD.fgl = ((aci)localObject1).fgl;
          ((com.tencent.mm.af.s)localObject4).t((Intent)localObject3);
          ab.i("MicroMsg.OtherViewWrapper", "jump to native video");
          if (((aci)localObject1).wUS != null) {
            ((Intent)localObject3).putExtra("img_gallery_width", ((aci)localObject1).wUS.width).putExtra("img_gallery_height", ((aci)localObject1).wUS.height).putExtra("img_gallery_left", ((aci)localObject1).wUS.left).putExtra("img_gallery_top", ((aci)localObject1).wUS.top);
          }
          ((Intent)localObject3).addFlags(268435456);
          if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a((Context)localObject2, ((com.tencent.mm.af.s)localObject4).fjD.url, ((com.tencent.mm.af.s)localObject4).fjD.type, true, 0, 10000, (Intent)localObject3)) {
            com.tencent.mm.bq.d.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
          }
          AppMethodBeat.o(24350);
          return;
          paramView = "";
          break;
        }
      }
      com.tencent.mm.bq.d.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", (Intent)localObject3, 1);
      AppMethodBeat.o(24350);
      return;
    case 4: 
    case 15: 
      localObject5 = paramView.getContext();
      if (((bo.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSC)) && (bo.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTU))) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSX <= 0L))
      {
        ab.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wST, Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSX) });
        localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSJ;
        paramView = (View)localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          paramView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSN;
        }
        if (bo.isNullOrNil(paramView))
        {
          ab.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_itemStatus != 10) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTK == 0))
          {
            paramView = new Intent();
            paramView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
            paramView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq);
            if (com.tencent.mm.plugin.record.b.g.c((com.tencent.mm.plugin.record.ui.a.b)localObject4))
            {
              b.a(paramView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4), com.tencent.mm.plugin.record.b.g.b((com.tencent.mm.plugin.record.ui.a.b)localObject4));
              AppMethodBeat.o(24350);
              return;
            }
            com.tencent.mm.plugin.fav.a.b.a((Context)localObject5, ".ui.detail.FavoriteFileDetailUI", paramView, 1);
            AppMethodBeat.o(24350);
            return;
          }
          localObject6 = new Intent();
          localObject1 = "";
          paramView = "";
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
          {
            localObject2 = n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO);
            if ((bo.isNullOrNil((String)localObject2)) || (!e.cN((String)localObject2)))
            {
              com.tencent.mm.ui.base.h.bO((Context)localObject5, ((Context)localObject5).getString(2131299804));
              AppMethodBeat.o(24350);
              return;
            }
            localObject3 = n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO);
            if (!bo.isNullOrNil((String)localObject3))
            {
              paramView = (View)localObject2;
              localObject1 = localObject3;
              if (e.cN((String)localObject3)) {}
            }
            else
            {
              ((Intent)localObject6).putExtra("key_detail_data_valid", false);
              localObject1 = localObject3;
              paramView = (View)localObject2;
            }
          }
          for (;;)
          {
            b.a((Intent)localObject6, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, (String)localObject1, paramView);
            AppMethodBeat.o(24350);
            return;
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
            {
              localObject2 = com.tencent.mm.plugin.record.b.g.b((com.tencent.mm.plugin.record.ui.a.b)localObject4);
              if ((bo.isNullOrNil((String)localObject2)) || (!e.cN((String)localObject2)))
              {
                com.tencent.mm.ui.base.h.bO((Context)localObject5, ((Context)localObject5).getString(2131299804));
                AppMethodBeat.o(24350);
                return;
              }
              localObject3 = com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4);
              if (!bo.isNullOrNil((String)localObject3))
              {
                paramView = (View)localObject2;
                localObject1 = localObject3;
                if (e.cN((String)localObject3)) {}
              }
              else
              {
                ((Intent)localObject6).putExtra("key_detail_data_valid", false);
                paramView = (View)localObject2;
                localObject1 = localObject3;
              }
            }
          }
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
        {
          ((Intent)localObject1).putExtra("is_favorite_item", true);
          ((Intent)localObject1).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
          ((Intent)localObject1).putExtra("key_detail_can_delete", false);
          ((Intent)localObject1).putExtra("geta8key_scene", 14);
          paramView = com.tencent.mm.modelstat.a.c.uJ(com.tencent.mm.pluginsdk.model.d.class.getName());
          paramView.putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_id);
          ((Intent)localObject1).putExtra("mm_report_bundle", paramView);
          ab.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_id), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
        }
        com.tencent.mm.bq.d.b((Context)localObject5, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
        AppMethodBeat.o(24350);
        return;
      }
      if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
      {
        paramView = new Intent();
        paramView.putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO);
        paramView.putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cEB);
        paramView.putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq);
        paramView.putExtra("key_detail_fav_video_scene_from", 1);
        if (n.d(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO))
        {
          b.a(paramView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO), n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO));
          AppMethodBeat.o(24350);
          return;
        }
        ab.i("MicroMsg.OtherViewWrapper", "RecordData.RECORD_TYPE: data not exist, go and download ");
        b.a(paramView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO), n.f(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO), false);
        AppMethodBeat.o(24350);
        return;
      }
      if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
      {
        paramView = new Intent();
        paramView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
        paramView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq);
        if (com.tencent.mm.plugin.record.b.g.c((com.tencent.mm.plugin.record.ui.a.b)localObject4))
        {
          b.a(paramView, (com.tencent.mm.plugin.record.ui.a.b)localObject4, (Context)localObject5, com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4), com.tencent.mm.plugin.record.b.g.b((com.tencent.mm.plugin.record.ui.a.b)localObject4));
          AppMethodBeat.o(24350);
          return;
        }
        com.tencent.mm.plugin.fav.a.b.a((Context)localObject5, ".ui.detail.FavoriteFileDetailUI", paramView, 1);
      }
      AppMethodBeat.o(24350);
      return;
    case 6: 
      label1287:
      localObject5 = paramView.getContext();
      if (localObject5 != null)
      {
        if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw == null) {
          break label4579;
        }
        localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUd;
        localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUb;
      }
      break;
    }
    for (;;)
    {
      if (localObject2 != null) {
        if (!bo.isNullOrNil(((acc)localObject2).wUA)) {
          paramView = com.tencent.mm.model.s.nE(((acc)localObject2).wUA);
        }
      }
      for (;;)
      {
        localObject3 = paramView;
        if (localObject2 == null)
        {
          localObject3 = paramView;
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) {
            localObject3 = com.tencent.mm.model.s.nE(((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_fromUser);
          }
        }
        if (localObject1 == null)
        {
          ab.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
          com.tencent.mm.ui.base.h.bO((Context)localObject5, ((Context)localObject5).getString(2131299795));
          AppMethodBeat.o(24350);
          return;
          paramView = com.tencent.mm.model.s.nE(((acc)localObject2).czp);
        }
        else
        {
          paramView = new Intent();
          paramView.putExtra("kwebmap_slat", ((ach)localObject1).lat);
          paramView.putExtra("kwebmap_lng", ((ach)localObject1).lng);
          paramView.putExtra("kPoiName", ((ach)localObject1).cDl);
          paramView.putExtra("Kwebmap_locaion", ((ach)localObject1).label);
          if (((ach)localObject1).cyX >= 0) {
            paramView.putExtra("kwebmap_scale", ((ach)localObject1).cyX);
          }
          paramView.putExtra("kisUsername", (String)localObject3);
          paramView.putExtra("kwebmap_from_to", true);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            paramView.putExtra("KFavLocSigleView", true);
            paramView.putExtra("map_view_type", 2);
            paramView.putExtra("kFavInfoLocalId", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
            paramView.putExtra("kFavCanDel", false);
            paramView.putExtra("kFavCanRemark", false);
            com.tencent.mm.bq.d.b((Context)localObject5, "location", ".ui.RedirectUI", paramView, 1);
            AppMethodBeat.o(24350);
            return;
          }
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
          {
            paramView.putExtra("map_view_type", 1);
            com.tencent.mm.bq.d.b((Context)localObject5, "location", ".ui.RedirectUI", paramView, 1002);
          }
          AppMethodBeat.o(24350);
          return;
          paramView = paramView.getContext();
          localObject1 = new Intent();
          if (bo.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSJ))
          {
            ab.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            ((Intent)localObject1).putExtra("rawUrl", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSL);
          }
          for (;;)
          {
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
            {
              ((Intent)localObject1).putExtra("is_favorite_item", true);
              ((Intent)localObject1).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
              ((Intent)localObject1).putExtra("key_detail_can_delete", false);
              localObject2 = com.tencent.mm.modelstat.a.c.uJ(com.tencent.mm.pluginsdk.model.d.class.getName());
              ((Bundle)localObject2).putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_id);
              ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
              ab.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_id), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            }
            com.tencent.mm.bq.d.b(paramView, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
            AppMethodBeat.o(24350);
            return;
            ((Intent)localObject1).putExtra("rawUrl", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSJ);
          }
          paramView = paramView.getContext();
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
          {
            if ((!n.d(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO)) || (com.tencent.mm.pluginsdk.ui.tools.a.R(n.c(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSR, 2))) {
              break label3092;
            }
            i = 0;
          }
          while (i != 0) {
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0)
            {
              localObject1 = new Intent(paramView, RecordMsgFileUI.class);
              ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO);
              ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cEB);
              ((Intent)localObject1).putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq);
              paramView.startActivity((Intent)localObject1);
              AppMethodBeat.o(24350);
              return;
              if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) && (com.tencent.mm.plugin.record.b.g.c((com.tencent.mm.plugin.record.ui.a.b)localObject4)) && (!com.tencent.mm.pluginsdk.ui.tools.a.R(com.tencent.mm.plugin.record.b.g.a((com.tencent.mm.plugin.record.ui.a.b)localObject4), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wSR, 2))) {
                i = 0;
              } else {
                label3092:
                i = 1;
              }
            }
            else if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
            {
              if (n.h(((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
                com.tencent.mm.plugin.fav.a.b.a(paramView, ".ui.detail.FavoriteImgDetailUI", (Intent)localObject1, 1);
                AppMethodBeat.o(24350);
                return;
              }
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
              ((Intent)localObject1).putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq);
              ((Intent)localObject1).putExtra("key_detail_can_delete", false);
              com.tencent.mm.plugin.fav.a.b.a(paramView, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject1, 1);
            }
          }
          AppMethodBeat.o(24350);
          return;
          paramView = paramView.getContext();
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUh == null))
          {
            ab.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            com.tencent.mm.ui.base.h.bO(paramView, paramView.getString(2131299794));
            AppMethodBeat.o(24350);
            return;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_Product_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUh.info);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            ((Intent)localObject1).putExtra("key_is_favorite_item", true);
            ((Intent)localObject1).putExtra("key_favorite_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
            ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
            ((Intent)localObject1).putExtra("key_ProductUI_getProductInfoScene", 3);
          }
          com.tencent.mm.bq.d.b(paramView, "scanner", ".ui.ProductUI", (Intent)localObject1, 1);
          AppMethodBeat.o(24350);
          return;
          paramView = paramView.getContext();
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUh == null))
          {
            ab.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            com.tencent.mm.ui.base.h.bO(paramView, paramView.getString(2131299794));
            AppMethodBeat.o(24350);
            return;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_product_info", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUh.info);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1) {
            ((Intent)localObject1).putExtra("key_product_scene", 4);
          }
          com.tencent.mm.bq.d.b(paramView, "product", ".ui.MallProductUI", (Intent)localObject1, 1);
          AppMethodBeat.o(24350);
          return;
          paramView = paramView.getContext();
          if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUj == null))
          {
            ab.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            com.tencent.mm.ui.base.h.bO(paramView, paramView.getString(2131299794));
            AppMethodBeat.o(24350);
            return;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_TV_getProductInfoScene", 3);
          ((Intent)localObject1).putExtra("key_TV_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw.wUj.info);
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
          {
            ((Intent)localObject1).putExtra("key_is_favorite_item", true);
            ((Intent)localObject1).putExtra("key_favorite_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).mCk.field_localId);
            ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
          }
          com.tencent.mm.bq.d.b(paramView, "shake", ".ui.TVInfoUI", (Intent)localObject1, 1);
          AppMethodBeat.o(24350);
          return;
          paramView = paramView.getContext();
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw == null)
          {
            ab.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            com.tencent.mm.ui.base.h.bO(paramView, paramView.getString(2131299794));
            AppMethodBeat.o(24350);
            return;
          }
          localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.desc;
          aw.aaz();
          localObject1 = com.tencent.mm.model.c.YC().Ty((String)localObject2);
          if (localObject1 == null)
          {
            ab.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[] { localObject2, ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.mBq });
            com.tencent.mm.ui.base.h.bO(paramView, paramView.getString(2131299794));
            AppMethodBeat.o(24350);
            return;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", ((bi.a)localObject1).tac);
          ((Intent)localObject2).putExtra("Contact_Alias", ((bi.a)localObject1).dCJ);
          ((Intent)localObject2).putExtra("Contact_Nick", ((bi.a)localObject1).nickname);
          ((Intent)localObject2).putExtra("Contact_QuanPin", ((bi.a)localObject1).gyI);
          ((Intent)localObject2).putExtra("Contact_PyInitial", ((bi.a)localObject1).gyH);
          ((Intent)localObject2).putExtra("Contact_Uin", ((bi.a)localObject1).pAI);
          ((Intent)localObject2).putExtra("Contact_Mobile_MD5", ((bi.a)localObject1).yOi);
          ((Intent)localObject2).putExtra("Contact_full_Mobile_MD5", ((bi.a)localObject1).yOj);
          ((Intent)localObject2).putExtra("Contact_QQNick", ((bi.a)localObject1).dyu());
          ((Intent)localObject2).putExtra("User_From_Fmessage", false);
          ((Intent)localObject2).putExtra("Contact_Scene", ((bi.a)localObject1).scene);
          ((Intent)localObject2).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject2).putExtra("Contact_RemarkName", ((bi.a)localObject1).gyM);
          ((Intent)localObject2).putExtra("Contact_VUser_Info_Flag", ((bi.a)localObject1).uOT);
          ((Intent)localObject2).putExtra("Contact_VUser_Info", ((bi.a)localObject1).dqP);
          ((Intent)localObject2).putExtra("Contact_BrandIconURL", ((bi.a)localObject1).pyu);
          ((Intent)localObject2).putExtra("Contact_Province", ((bi.a)localObject1).getProvince());
          ((Intent)localObject2).putExtra("Contact_City", ((bi.a)localObject1).getCity());
          ((Intent)localObject2).putExtra("Contact_Sex", ((bi.a)localObject1).dqC);
          ((Intent)localObject2).putExtra("Contact_Signature", ((bi.a)localObject1).signature);
          ((Intent)localObject2).putExtra("Contact_ShowUserName", false);
          ((Intent)localObject2).putExtra("Contact_KSnsIFlag", 0);
          b.y(paramView, (Intent)localObject2);
          com.tencent.mm.bq.d.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 1);
          com.tencent.mm.br.a.My(((bi.a)localObject1).scene);
          AppMethodBeat.o(24350);
          return;
          paramView = paramView.getContext();
          if (paramView != null)
          {
            if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 0) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTM != null))
            {
              localObject1 = new Intent(paramView, RecordMsgDetailUI.class);
              ((Intent)localObject1).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cpO);
              ((Intent)localObject1).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTM);
              ((Intent)localObject1).putExtra("record_nest", true);
              b.y(paramView, (Intent)localObject1);
              paramView.startActivity((Intent)localObject1);
            }
            AppMethodBeat.o(24350);
            return;
            localObject2 = paramView.getContext();
            if (localObject2 != null)
            {
              paramView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).cuL.wTw;
              if (paramView != null)
              {
                localObject3 = paramView.wUs;
                if (localObject3 != null)
                {
                  localObject4 = new AppBrandStatObject();
                  ((AppBrandStatObject)localObject4).scene = 1096;
                  if (paramView.wUb != null) {
                    ((AppBrandStatObject)localObject4).cmF = paramView.wUb.czp;
                  }
                  if (!(localObject2 instanceof Activity)) {
                    break label4564;
                  }
                  paramView = ((Activity)localObject2).getIntent();
                  if (paramView == null) {
                    break label4564;
                  }
                  i = paramView.getIntExtra("preChatTYPE", 2);
                  localObject1 = paramView.getStringExtra("preUsername");
                  paramView = paramView.getStringExtra("preChatName");
                }
              }
            }
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              i = 0;
            }
            for (;;)
            {
              ((AppBrandStatObject)localObject4).cJb = i;
              ((AppBrandStatObject)localObject4).cJc = String.format("%s:%s", new Object[] { localObject1, paramView });
              ((j)com.tencent.mm.kernel.g.E(j.class)).a((Context)localObject2, ((aby)localObject3).username, ((aby)localObject3).appId, ((aby)localObject3).cvs, -1, ((aby)localObject3).cmG, (AppBrandStatObject)localObject4);
              AppMethodBeat.o(24350);
              return;
              i = 2;
              continue;
              i = 1;
              continue;
              i = 5;
            }
            AppMethodBeat.o(24350);
            return;
            label4564:
            paramView = null;
            i = -1;
            localObject1 = null;
          }
          paramView = null;
        }
      }
      label4579:
      localObject2 = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.b.1
 * JD-Core Version:    0.7.0.1
 */