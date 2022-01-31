package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi.a;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    com.tencent.mm.plugin.record.ui.a.b localb = (com.tencent.mm.plugin.record.ui.a.b)paramView.getTag();
    Object localObject2;
    label260:
    Context localContext;
    switch (localb.bNt.aYU)
    {
    case 9: 
    case 12: 
    case 13: 
    case 18: 
    default: 
    case 5: 
    case 4: 
    case 15: 
    case 6: 
      do
      {
        do
        {
          return;
          localObject2 = paramView.getContext();
          if (localb.bNt.sVA == null)
          {
            y.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[] { localb.bNt.kgC });
            com.tencent.mm.ui.base.h.bC((Context)localObject2, ((Context)localObject2).getString(R.l.favorite_record_url_error));
            return;
          }
          localObject3 = localb.bNt;
          paramView = (View)localObject1;
          if (localObject3 != null)
          {
            if (!((xv)localObject3).sVL) {
              break label260;
            }
            paramView = ((xv)localObject3).canvasPageXml;
          }
          while (!bk.bl(paramView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("sns_landing_pages_xml", paramView);
            ((Intent)localObject1).putExtra("sns_landig_pages_from_source", 5);
            ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", localb.bNt.dQL);
            ((Intent)localObject1).addFlags(268435456);
            ((Intent)localObject1).putExtra("msg_id", localb.bIt);
            com.tencent.mm.br.d.b((Context)localObject2, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject1, 1);
            return;
            paramView = (View)localObject1;
            if (((xv)localObject3).sVA != null)
            {
              paramView = (View)localObject1;
              if (((xv)localObject3).sVA.sWh != null)
              {
                paramView = (View)localObject1;
                if (((xv)localObject3).sVA.sWh.sVL) {
                  paramView = ((xv)localObject3).sVA.sWh.canvasPageXml;
                }
              }
            }
          }
          localObject3 = localb.bNt.sVA.sWd;
          localObject1 = "";
          if (localb.bNt.sVA.sWh != null) {
            localObject1 = localb.bNt.sVA.sWh.sXG;
          }
          paramView = (View)localObject1;
          if (localObject3 != null)
          {
            paramView = (View)localObject1;
            if (bk.bl((String)localObject1)) {
              paramView = ((xx)localObject3).eAl;
            }
          }
          localObject1 = paramView;
          if (bk.bl(paramView)) {
            localObject1 = localb.bNt.sUN;
          }
          if (bk.bl((String)localObject1))
          {
            y.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[] { localb.bNt.kgC });
            com.tencent.mm.ui.base.h.bC((Context)localObject2, ((Context)localObject2).getString(R.l.favorite_record_url_error));
            return;
          }
          paramView = new Intent();
          paramView.putExtra("rawUrl", (String)localObject1);
          if ((localObject3 != null) && (!bk.bl(((xx)localObject3).bFn))) {
            paramView.putExtra("srcDisplayname", r.gV(((xx)localObject3).bFn));
          }
          paramView.putExtra("mode", 1);
          if (localb.aYU == 1)
          {
            paramView.putExtra("is_favorite_item", true);
            paramView.putExtra("fav_local_id", localb.khA.field_localId);
            paramView.putExtra("key_detail_can_delete", false);
            paramView.putExtra("geta8key_scene", 14);
            paramView.putExtra("from_scence", 4);
            localObject1 = com.tencent.mm.modelstat.a.b.nv(com.tencent.mm.pluginsdk.model.d.class.getName());
            ((Bundle)localObject1).putInt("mm_rpt_fav_id", localb.khA.field_id);
            paramView.putExtra("mm_report_bundle", (Bundle)localObject1);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("key_snsad_statextstr", localb.bNt.bYN);
          paramView.putExtra("jsapiargs", (Bundle)localObject1);
          com.tencent.mm.br.d.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", paramView, 1);
          return;
          localContext = paramView.getContext();
          if (((bk.bl(localb.bNt.sUG)) && (bk.bl(localb.bNt.sVY))) || (localb.bNt.sVb <= 0L))
          {
            y.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[] { localb.bNt.sUX, Long.valueOf(localb.bNt.sVb) });
            localObject1 = localb.bNt.sUN;
            paramView = (View)localObject1;
            if (bk.bl((String)localObject1)) {
              paramView = localb.bNt.sUR;
            }
            if (bk.bl(paramView))
            {
              y.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[] { localb.bNt.kgC });
              if ((localb.aYU == 1) && (localb.khA.field_itemStatus != 10) && (localb.bNt.sVO == 0))
              {
                paramView = new Intent();
                paramView.putExtra("key_detail_info_id", localb.khA.field_localId);
                paramView.putExtra("key_detail_data_id", localb.bNt.kgC);
                if (com.tencent.mm.plugin.record.b.b.c(localb))
                {
                  b.a(paramView, localb, localContext, com.tencent.mm.plugin.record.b.b.a(localb), com.tencent.mm.plugin.record.b.b.b(localb));
                  return;
                }
                com.tencent.mm.plugin.fav.a.b.b(localContext, ".ui.detail.FavoriteFileDetailUI", paramView, 1);
                return;
              }
              Intent localIntent = new Intent();
              localObject1 = "";
              paramView = "";
              if (localb.aYU == 0)
              {
                localObject2 = com.tencent.mm.plugin.record.b.h.f(localb.bNt, localb.bIt);
                if ((bk.bl((String)localObject2)) || (!e.bK((String)localObject2)))
                {
                  com.tencent.mm.ui.base.h.bC(localContext, localContext.getString(R.l.favorite_record_video_error));
                  return;
                }
                localObject3 = com.tencent.mm.plugin.record.b.h.c(localb.bNt, localb.bIt);
                if (!bk.bl((String)localObject3))
                {
                  paramView = (View)localObject2;
                  localObject1 = localObject3;
                  if (e.bK((String)localObject3)) {}
                }
                else
                {
                  localIntent.putExtra("key_detail_data_valid", false);
                  localObject1 = localObject3;
                  paramView = (View)localObject2;
                }
              }
              for (;;)
              {
                b.a(localIntent, localb, localContext, (String)localObject1, paramView);
                return;
                if (localb.aYU == 1)
                {
                  localObject2 = com.tencent.mm.plugin.record.b.b.b(localb);
                  if ((bk.bl((String)localObject2)) || (!e.bK((String)localObject2)))
                  {
                    com.tencent.mm.ui.base.h.bC(localContext, localContext.getString(R.l.favorite_record_video_error));
                    return;
                  }
                  localObject3 = com.tencent.mm.plugin.record.b.b.a(localb);
                  if (!bk.bl((String)localObject3))
                  {
                    paramView = (View)localObject2;
                    localObject1 = localObject3;
                    if (e.bK((String)localObject3)) {}
                  }
                  else
                  {
                    localIntent.putExtra("key_detail_data_valid", false);
                    paramView = (View)localObject2;
                    localObject1 = localObject3;
                  }
                }
              }
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramView);
            if (localb.aYU == 1)
            {
              ((Intent)localObject1).putExtra("is_favorite_item", true);
              ((Intent)localObject1).putExtra("fav_local_id", localb.khA.field_localId);
              ((Intent)localObject1).putExtra("key_detail_can_delete", false);
              ((Intent)localObject1).putExtra("geta8key_scene", 14);
              paramView = com.tencent.mm.modelstat.a.b.nv(com.tencent.mm.pluginsdk.model.d.class.getName());
              paramView.putInt("mm_rpt_fav_id", localb.khA.field_id);
              ((Intent)localObject1).putExtra("mm_report_bundle", paramView);
              y.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(localb.khA.field_id), Long.valueOf(localb.khA.field_localId), localb.bNt.kgC });
            }
            com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
            return;
          }
          if (localb.aYU == 0)
          {
            paramView = new Intent();
            paramView.putExtra("message_id", localb.bIt);
            paramView.putExtra("record_xml", localb.bWL);
            paramView.putExtra("record_data_id", localb.bNt.kgC);
            paramView.putExtra("key_detail_fav_video_scene_from", 1);
            if (com.tencent.mm.plugin.record.b.h.d(localb.bNt, localb.bIt))
            {
              b.a(paramView, localb, localContext, com.tencent.mm.plugin.record.b.h.c(localb.bNt, localb.bIt), com.tencent.mm.plugin.record.b.h.f(localb.bNt, localb.bIt));
              return;
            }
            com.tencent.mm.br.d.b(localContext, "record", ".ui.RecordMsgFileUI", paramView, 1);
            return;
          }
        } while (localb.aYU != 1);
        paramView = new Intent();
        paramView.putExtra("key_detail_info_id", localb.khA.field_localId);
        paramView.putExtra("key_detail_data_id", localb.bNt.kgC);
        if (com.tencent.mm.plugin.record.b.b.c(localb))
        {
          b.a(paramView, localb, localContext, com.tencent.mm.plugin.record.b.b.a(localb), com.tencent.mm.plugin.record.b.b.b(localb));
          return;
        }
        com.tencent.mm.plugin.fav.a.b.b(localContext, ".ui.detail.FavoriteFileDetailUI", paramView, 1);
        return;
        localContext = paramView.getContext();
      } while (localContext == null);
      if (localb.bNt.sVA != null)
      {
        localObject1 = localb.bNt.sVA.sWf;
        localObject2 = localb.bNt.sVA.sWd;
      }
      break;
    }
    for (;;)
    {
      paramView = (View)localObject3;
      if (localObject2 != null) {
        if (bk.bl(((xx)localObject2).sWB)) {
          break label1637;
        }
      }
      label1637:
      for (paramView = r.gV(((xx)localObject2).sWB);; paramView = r.gV(((xx)localObject2).bRO))
      {
        localObject3 = paramView;
        if (localObject2 == null)
        {
          localObject3 = paramView;
          if (localb.aYU == 1) {
            localObject3 = r.gV(localb.khA.field_fromUser);
          }
        }
        if (localObject1 != null) {
          break;
        }
        y.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[] { localb.bNt.kgC });
        com.tencent.mm.ui.base.h.bC(localContext, localContext.getString(R.l.favorite_record_loc_error));
        return;
      }
      paramView = new Intent();
      paramView.putExtra("kwebmap_slat", ((yc)localObject1).lat);
      paramView.putExtra("kwebmap_lng", ((yc)localObject1).lng);
      paramView.putExtra("kPoiName", ((yc)localObject1).bVA);
      paramView.putExtra("Kwebmap_locaion", ((yc)localObject1).label);
      if (((yc)localObject1).bRv >= 0) {
        paramView.putExtra("kwebmap_scale", ((yc)localObject1).bRv);
      }
      paramView.putExtra("kisUsername", (String)localObject3);
      paramView.putExtra("kwebmap_from_to", true);
      if (localb.aYU == 1)
      {
        paramView.putExtra("KFavLocSigleView", true);
        paramView.putExtra("map_view_type", 2);
        paramView.putExtra("kFavInfoLocalId", localb.khA.field_localId);
        paramView.putExtra("kFavCanDel", false);
        paramView.putExtra("kFavCanRemark", false);
        com.tencent.mm.br.d.b(localContext, "location", ".ui.RedirectUI", paramView, 1);
        return;
      }
      if (localb.aYU != 0) {
        break;
      }
      paramView.putExtra("map_view_type", 1);
      com.tencent.mm.br.d.b(localContext, "location", ".ui.RedirectUI", paramView, 1002);
      return;
      paramView = paramView.getContext();
      localObject1 = new Intent();
      if (bk.bl(localb.bNt.sUN))
      {
        y.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[] { localb.bNt.kgC });
        ((Intent)localObject1).putExtra("rawUrl", localb.bNt.sUP);
      }
      for (;;)
      {
        if (localb.aYU == 1)
        {
          ((Intent)localObject1).putExtra("is_favorite_item", true);
          ((Intent)localObject1).putExtra("fav_local_id", localb.khA.field_localId);
          ((Intent)localObject1).putExtra("key_detail_can_delete", false);
          localObject2 = com.tencent.mm.modelstat.a.b.nv(com.tencent.mm.pluginsdk.model.d.class.getName());
          ((Bundle)localObject2).putInt("mm_rpt_fav_id", localb.khA.field_id);
          ((Intent)localObject1).putExtra("mm_report_bundle", (Bundle)localObject2);
          y.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(localb.khA.field_id), Long.valueOf(localb.khA.field_localId), localb.bNt.kgC });
        }
        com.tencent.mm.br.d.b(paramView, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
        return;
        ((Intent)localObject1).putExtra("rawUrl", localb.bNt.sUN);
      }
      paramView = paramView.getContext();
      int i;
      if (localb.aYU == 0)
      {
        if ((!com.tencent.mm.plugin.record.b.h.d(localb.bNt, localb.bIt)) || (com.tencent.mm.pluginsdk.ui.tools.a.a((Activity)paramView, com.tencent.mm.plugin.record.b.h.c(localb.bNt, localb.bIt), localb.bNt.sUV, 2))) {
          break label2251;
        }
        i = 0;
      }
      while (i != 0)
      {
        if (localb.aYU != 0) {
          break label2256;
        }
        localObject1 = new Intent(paramView, RecordMsgFileUI.class);
        ((Intent)localObject1).putExtra("message_id", localb.bIt);
        ((Intent)localObject1).putExtra("record_xml", localb.bWL);
        ((Intent)localObject1).putExtra("record_data_id", localb.bNt.kgC);
        paramView.startActivity((Intent)localObject1);
        return;
        if ((localb.aYU == 1) && (com.tencent.mm.plugin.record.b.b.c(localb)) && (!com.tencent.mm.pluginsdk.ui.tools.a.a((Activity)paramView, com.tencent.mm.plugin.record.b.b.a(localb), localb.bNt.sUV, 2))) {
          i = 0;
        } else {
          label2251:
          i = 1;
        }
      }
      label2256:
      if (localb.aYU != 1) {
        break;
      }
      if (com.tencent.mm.plugin.record.b.h.h(localb.bNt, localb.bIt))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_detail_info_id", localb.khA.field_localId);
        com.tencent.mm.plugin.fav.a.b.b(paramView, ".ui.detail.FavoriteImgDetailUI", (Intent)localObject1, 1);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_detail_info_id", localb.khA.field_localId);
      ((Intent)localObject1).putExtra("key_detail_data_id", localb.bNt.kgC);
      ((Intent)localObject1).putExtra("key_detail_can_delete", false);
      com.tencent.mm.plugin.fav.a.b.b(paramView, ".ui.detail.FavoriteFileDetailUI", (Intent)localObject1, 1);
      return;
      paramView = paramView.getContext();
      if ((localb.bNt.sVA == null) || (localb.bNt.sVA.sWj == null))
      {
        y.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[] { localb.bNt.kgC });
        com.tencent.mm.ui.base.h.bC(paramView, paramView.getString(R.l.favorite_record_info_error));
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_Product_xml", localb.bNt.sVA.sWj.info);
      if (localb.aYU == 1)
      {
        ((Intent)localObject1).putExtra("key_is_favorite_item", true);
        ((Intent)localObject1).putExtra("key_favorite_local_id", localb.khA.field_localId);
        ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
        ((Intent)localObject1).putExtra("key_ProductUI_getProductInfoScene", 3);
      }
      com.tencent.mm.br.d.b(paramView, "scanner", ".ui.ProductUI", (Intent)localObject1, 1);
      return;
      paramView = paramView.getContext();
      if ((localb.bNt.sVA == null) || (localb.bNt.sVA.sWj == null))
      {
        y.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[] { localb.bNt.kgC });
        com.tencent.mm.ui.base.h.bC(paramView, paramView.getString(R.l.favorite_record_info_error));
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_product_info", localb.bNt.sVA.sWj.info);
      if (localb.aYU == 1) {
        ((Intent)localObject1).putExtra("key_product_scene", 4);
      }
      com.tencent.mm.br.d.b(paramView, "product", ".ui.MallProductUI", (Intent)localObject1, 1);
      return;
      paramView = paramView.getContext();
      if ((localb.bNt.sVA == null) || (localb.bNt.sVA.sWl == null))
      {
        y.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[] { localb.bNt.kgC });
        com.tencent.mm.ui.base.h.bC(paramView, paramView.getString(R.l.favorite_record_info_error));
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_TV_getProductInfoScene", 3);
      ((Intent)localObject1).putExtra("key_TV_xml", localb.bNt.sVA.sWl.info);
      if (localb.aYU == 1)
      {
        ((Intent)localObject1).putExtra("key_is_favorite_item", true);
        ((Intent)localObject1).putExtra("key_favorite_local_id", localb.khA.field_localId);
        ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
      }
      com.tencent.mm.br.d.b(paramView, "shake", ".ui.TVInfoUI", (Intent)localObject1, 1);
      return;
      paramView = paramView.getContext();
      if (localb.bNt.sVA == null)
      {
        y.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[] { localb.bNt.kgC });
        com.tencent.mm.ui.base.h.bC(paramView, paramView.getString(R.l.favorite_record_info_error));
        return;
      }
      localObject2 = localb.bNt.desc;
      au.Hx();
      localObject1 = c.Fy().HN((String)localObject2);
      if (localObject1 == null)
      {
        y.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[] { localObject2, localb.bNt.kgC });
        com.tencent.mm.ui.base.h.bC(paramView, paramView.getString(R.l.favorite_record_info_error));
        return;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", ((bi.a)localObject1).pyp);
      ((Intent)localObject2).putExtra("Contact_Alias", ((bi.a)localObject1).cMT);
      ((Intent)localObject2).putExtra("Contact_Nick", ((bi.a)localObject1).nickname);
      ((Intent)localObject2).putExtra("Contact_QuanPin", ((bi.a)localObject1).fha);
      ((Intent)localObject2).putExtra("Contact_PyInitial", ((bi.a)localObject1).fgZ);
      ((Intent)localObject2).putExtra("Contact_Uin", ((bi.a)localObject1).mXV);
      ((Intent)localObject2).putExtra("Contact_Mobile_MD5", ((bi.a)localObject1).uBW);
      ((Intent)localObject2).putExtra("Contact_full_Mobile_MD5", ((bi.a)localObject1).uBX);
      ((Intent)localObject2).putExtra("Contact_QQNick", ((bi.a)localObject1).cvM());
      ((Intent)localObject2).putExtra("User_From_Fmessage", false);
      ((Intent)localObject2).putExtra("Contact_Scene", ((bi.a)localObject1).scene);
      ((Intent)localObject2).putExtra("Contact_FMessageCard", true);
      ((Intent)localObject2).putExtra("Contact_RemarkName", ((bi.a)localObject1).fhe);
      ((Intent)localObject2).putExtra("Contact_VUser_Info_Flag", ((bi.a)localObject1).qZn);
      ((Intent)localObject2).putExtra("Contact_VUser_Info", ((bi.a)localObject1).cCF);
      ((Intent)localObject2).putExtra("Contact_BrandIconURL", ((bi.a)localObject1).mVN);
      ((Intent)localObject2).putExtra("Contact_Province", ((bi.a)localObject1).getProvince());
      ((Intent)localObject2).putExtra("Contact_City", ((bi.a)localObject1).getCity());
      ((Intent)localObject2).putExtra("Contact_Sex", ((bi.a)localObject1).sex);
      ((Intent)localObject2).putExtra("Contact_Signature", ((bi.a)localObject1).signature);
      ((Intent)localObject2).putExtra("Contact_ShowUserName", false);
      ((Intent)localObject2).putExtra("Contact_KSnsIFlag", 0);
      com.tencent.mm.br.d.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 1);
      com.tencent.mm.bs.a.EA(((bi.a)localObject1).scene);
      return;
      paramView = paramView.getContext();
      if ((paramView == null) || (localb.aYU != 0) || (localb.bNt.sVQ == null)) {
        break;
      }
      localObject1 = new Intent(paramView, RecordMsgDetailUI.class);
      ((Intent)localObject1).putExtra("message_id", localb.bIt);
      ((Intent)localObject1).putExtra("record_xml", localb.bNt.sVQ);
      paramView.startActivity((Intent)localObject1);
      return;
      paramView = paramView.getContext();
      if ((paramView == null) || (localb.bNt.sVA == null)) {
        break;
      }
      localObject1 = localb.bNt.sVA.sWu;
      if (localObject1 == null) {
        break;
      }
      localObject2 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject2).scene = 1096;
      ((com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramView, ((xt)localObject1).username, ((xt)localObject1).appId, ((xt)localObject1).bOa, -1, ((xt)localObject1).bFw, (AppBrandStatObject)localObject2);
      return;
      localObject2 = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.b.1
 * JD-Core Version:    0.7.0.1
 */