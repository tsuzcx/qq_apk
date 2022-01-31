package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.e.l;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

final class bd$1
  implements View.OnClickListener
{
  bd$1(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39862);
    long l = System.currentTimeMillis();
    if (l - this.scK.jfp < 500L)
    {
      AppMethodBeat.o(39862);
      return;
    }
    this.scK.jfp = l;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    label521:
    label885:
    Intent localIntent;
    label1605:
    label1766:
    int i;
    if ((paramView.getTag() instanceof q))
    {
      Object localObject3 = (q)paramView.getTag();
      localObject4 = ((q)localObject3).rGk;
      com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(((q)localObject3).crk);
      if (this.scK.rFN != null) {
        this.scK.rFN.coJ().x(localn);
      }
      if (((TimeLineObject)localObject4).xTS.wNZ == 18)
      {
        paramView = this.scK;
        localObject1 = this.scK.context;
        localObject2 = ((q)localObject3).rGk;
        localObject3 = ((q)localObject3).crk;
        localObject3 = ag.cpf().abv((String)localObject3);
        k.a(k.b.ran, k.a.raf, (com.tencent.mm.plugin.sns.storage.n)localObject3, paramView.cpt);
        localObject3 = new Intent();
        paramView = null;
        if (((TimeLineObject)localObject2).xTS.wOa.size() > 0) {
          paramView = (bcs)((TimeLineObject)localObject2).xTS.wOa.get(0);
        }
        ((Intent)localObject3).putExtra("KFromTimeLine", false);
        ((Intent)localObject3).putExtra("KStremVideoUrl", ((TimeLineObject)localObject2).xTS.Url);
        ((Intent)localObject3).putExtra("KSta_SourceType", 2);
        ((Intent)localObject3).putExtra("KSta_Scene", k.b.ran.value);
        ((Intent)localObject3).putExtra("KSta_FromUserName", ((TimeLineObject)localObject2).jJA);
        ((Intent)localObject3).putExtra("KSta_SnSId", ((TimeLineObject)localObject2).Id);
        if (paramView == null)
        {
          localObject4 = new StringBuilder("fakeid_");
          if (paramView == null)
          {
            paramView = ((TimeLineObject)localObject2).Id;
            ((Intent)localObject3).putExtra("KMediaId", paramView);
          }
        }
        for (;;)
        {
          paramView = ((TimeLineObject)localObject2).xTX;
          if (paramView != null)
          {
            ((Intent)localObject3).putExtra("KMediaVideoTime", paramView.fiP);
            ((Intent)localObject3).putExtra("StreamWording", paramView.fiR);
            ((Intent)localObject3).putExtra("StremWebUrl", paramView.fiS);
            ((Intent)localObject3).putExtra("KMediaTitle", paramView.fiQ);
            ((Intent)localObject3).putExtra("KStremVideoUrl", paramView.fiO);
            ((Intent)localObject3).putExtra("KThumUrl", paramView.fiT);
            ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramView.fiU);
            ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramView.fiV);
          }
          ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject2).rHA);
          if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRW, 0) <= 0) {
            break label521;
          }
          d.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
          ab.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
          AppMethodBeat.o(39862);
          return;
          paramView = paramView.Id;
          break;
          ((Intent)localObject3).putExtra("KMediaId", paramView.Id);
        }
        d.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
        AppMethodBeat.o(39862);
        return;
      }
      if ((((TimeLineObject)localObject4).rjx != null) && (!bo.isNullOrNil(((TimeLineObject)localObject4).rjx.uJi)))
      {
        localObject1 = this.scK;
        paramView = ((TimeLineObject)localObject4).rjx;
        if ((paramView != null) && (!bo.isNullOrNil(paramView.uJi)))
        {
          localObject2 = com.tencent.mm.plugin.topstory.a.g.a(paramView, 31, ac.agv("discoverRecommendEntry").optString("wording"));
          aa.a(((bd)localObject1).context, (ckw)localObject2);
          localObject1 = ((TimeLineObject)localObject4).jJA;
          localObject3 = ((TimeLineObject)localObject4).Id;
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append("isShareClick=1");
          ((StringBuffer)localObject2).append("&relevant_vid=");
          ((StringBuffer)localObject2).append(paramView.uJi);
          ((StringBuffer)localObject2).append("&relevant_pre_searchid=");
          ((StringBuffer)localObject2).append(paramView.uJk);
          ((StringBuffer)localObject2).append("&relevant_shared_openid=");
          ((StringBuffer)localObject2).append(paramView.uJl);
          ((StringBuffer)localObject2).append("&rec_category=");
          if (paramView.uJu <= 0L) {
            break label885;
          }
          ((StringBuffer)localObject2).append(paramView.uJu);
        }
        for (;;)
        {
          ((StringBuffer)localObject2).append("&source=");
          ((StringBuffer)localObject2).append(paramView.source);
          ((StringBuffer)localObject2).append("&fromUser=");
          ((StringBuffer)localObject2).append((String)localObject1);
          ((StringBuffer)localObject2).append("&fromScene=");
          ((StringBuffer)localObject2).append(3);
          ((StringBuffer)localObject2).append("&targetInfo=");
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("&expand=");
          ((StringBuffer)localObject2).append(paramView.uJj);
          ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject2).toString() });
          paramView = new buo();
          paramView.xHP = ((StringBuffer)localObject2).toString();
          paramView = new w(paramView);
          com.tencent.mm.kernel.g.Rc().a(paramView, 0);
          AppMethodBeat.o(39862);
          return;
          ((StringBuffer)localObject2).append(paramView.uJm);
        }
      }
      localObject1 = ((TimeLineObject)localObject4).xTS.Url;
      ab.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(localObject1)));
      String str = com.tencent.mm.plugin.sns.c.a.gmP.H((String)localObject1, "timeline");
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(39862);
        return;
      }
      localIntent = new Intent();
      localObject1 = null;
      if (localObject4 != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("KSnsStrId", ((TimeLineObject)localObject4).Id);
        ((Bundle)localObject1).putString("KSnsLocalId", ((q)localObject3).crk);
        ((Bundle)localObject1).putBoolean("KFromTimeline", true);
        if ((((TimeLineObject)localObject4).xTS != null) && (((TimeLineObject)localObject4).xTS.wOa.size() > 0))
        {
          ((Bundle)localObject1).putString("K_sns_thumb_url", ((bcs)((TimeLineObject)localObject4).xTS.wOa.get(0)).xrS);
          ((Bundle)localObject1).putString("K_sns_raw_url", ((TimeLineObject)localObject4).xTS.Url);
          ab.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((bcs)((TimeLineObject)localObject4).xTS.wOa.get(0)).xrS, ((TimeLineObject)localObject4).xTS.Url });
        }
      }
      ((Bundle)localObject1).putString("key_snsad_statextstr", ((TimeLineObject)localObject4).rHA);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("shortUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("type", -255);
      if (((TimeLineObject)localObject4).xTT != null)
      {
        localIntent.putExtra("srcUsername", ((TimeLineObject)localObject4).xTT);
        localIntent.putExtra("srcDisplayname", ((TimeLineObject)localObject4).vSR);
        ab.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + ((TimeLineObject)localObject4).vSR + " tlObj.publicUserName: " + ((TimeLineObject)localObject4).xTT);
      }
      localIntent.putExtra("sns_local_id", ((q)localObject3).crk);
      if (localn != null)
      {
        localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
        localIntent.putExtra("pre_username", localn.field_userName);
        localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
        localIntent.putExtra("preUsername", localn.field_userName);
        localIntent.putExtra("share_report_pre_msg_url", str);
        localIntent.putExtra("share_report_pre_msg_title", ((TimeLineObject)localObject4).xTS.Title);
        localIntent.putExtra("share_report_pre_msg_desc", ((TimeLineObject)localObject4).xTS.Desc);
        if ((((TimeLineObject)localObject4).xTS.wOa != null) && (((TimeLineObject)localObject4).xTS.wOa.size() > 0)) {
          localIntent.putExtra("share_report_pre_msg_icon_url", ((bcs)((TimeLineObject)localObject4).xTS.wOa.get(0)).xrS);
        }
        localIntent.putExtra("share_report_pre_msg_appid", "");
        localIntent.putExtra("share_report_from_scene", 1);
      }
      if ((localObject4 != null) && (((TimeLineObject)localObject4).xTR != null)) {
        localIntent.putExtra("KAppId", ((TimeLineObject)localObject4).xTR.Id);
      }
      if ((localn != null) && (localn.Ex(32)))
      {
        if (this.scK.cpt != 2) {
          break label2202;
        }
        localObject2 = localn.cse();
        if (localObject2 != null) {
          localIntent.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject2).hpq);
        }
      }
      if ((localn != null) && (localObject4 != null))
      {
        if (this.scK.cpt != 0) {
          break label2212;
        }
        localObject2 = com.tencent.mm.modelsns.b.lV(718);
        com.tencent.mm.modelsns.b localb = ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(((TimeLineObject)localObject4).xTT);
        if (((TimeLineObject)localObject4).xTR != null) {
          break label2223;
        }
        localObject3 = "";
        label1664:
        localb.uv((String)localObject3).uv(((TimeLineObject)localObject4).xTS.Url);
        ((com.tencent.mm.modelsns.b)localObject2).ake();
        if (this.scK.cpt != 0) {
          break label2236;
        }
        localObject2 = com.tencent.mm.modelsns.b.lV(743);
        label1707:
        localb = ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(((TimeLineObject)localObject4).xTT);
        if (((TimeLineObject)localObject4).xTR != null) {
          break label2247;
        }
        localObject3 = "";
        localb.uv((String)localObject3).uv(((TimeLineObject)localObject4).xTS.Url);
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.modelsns.b)localObject2).adM();
          if (localObject2 != null) {
            ((Bundle)localObject1).putByteArray("intent_key_StatisticsOplog", (byte[])localObject2);
          }
        }
      }
      if (localObject1 != null) {
        localIntent.putExtra("jsapiargs", (Bundle)localObject1);
      }
      localIntent.putExtra("geta8key_scene", 2);
      localIntent.putExtra("from_scence", 3);
      if ((((TimeLineObject)localObject4).xTS.wOd != null) && (((TimeLineObject)localObject4).xTS.wOd.wqp != -1)) {
        localIntent.putExtra(e.l.yVt, ((TimeLineObject)localObject4).xTS.wOd.wqp);
      }
      if ((!bo.isNullOrNil(((TimeLineObject)localObject4).sbN)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(((TimeLineObject)localObject4).sbN)) && (localn != null))
      {
        localObject1 = new int[2];
        if (paramView != null) {
          paramView.getLocationInWindow((int[])localObject1);
        }
        i = paramView.getWidth();
        j = paramView.getHeight();
        paramView = new Intent();
        paramView.putExtra("img_gallery_left", localObject1[0]);
        paramView.putExtra("img_gallery_top", localObject1[1]);
        paramView.putExtra("img_gallery_width", i);
        paramView.putExtra("img_gallery_height", j);
        if (localObject4 != null)
        {
          localObject1 = ((TimeLineObject)localObject4).xTS.wOa;
          if (((List)localObject1).size() > 0) {
            paramView.putExtra("sns_landing_pages_share_thumb_url", ((bcs)((List)localObject1).get(0)).xrS);
          }
        }
        paramView.putExtra("sns_landing_pages_share_sns_id", localn.getSnsId());
        paramView.putExtra("sns_landing_pages_rawSnsId", localn.csh().Id);
        paramView.putExtra("sns_landing_pages_aid", localn.csM());
        paramView.putExtra("sns_landing_pages_traceid", localn.csN());
        paramView.putExtra("sns_landing_pages_ux_info", localn.csP());
        if (this.scK.cpt == 0) {}
        for (i = 3;; i = 4)
        {
          paramView.putExtra("sns_landig_pages_from_source", i);
          paramView.setClass(this.scK.context, SnsAdNativeLandingPagesUI.class);
          paramView.putExtra("sns_landing_pages_xml", ((TimeLineObject)localObject4).sbN);
          paramView.putExtra("sns_landing_pages_rec_src", localn.csR());
          paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(paramView, this.scK.context);
          AppMethodBeat.o(39862);
          return;
          label2202:
          localObject2 = localn.csd();
          break;
          label2212:
          localObject2 = com.tencent.mm.modelsns.b.lW(718);
          break label1605;
          label2223:
          localObject3 = ((TimeLineObject)localObject4).xTR.Id;
          break label1664;
          label2236:
          localObject2 = com.tencent.mm.modelsns.b.lW(743);
          break label1707;
          label2247:
          localObject3 = ((TimeLineObject)localObject4).xTR.Id;
          break label1766;
        }
      }
      localIntent.addFlags(536870912);
      if (((TimeLineObject)localObject4).xTS.wOd == null) {
        break label3098;
      }
      i = ((TimeLineObject)localObject4).xTS.wOd.wqp;
      int j = this.scK.rFN.getScene();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (((TimeLineObject)localObject4).xTS.wOd != null)
      {
        bool1 = bool2;
        if (i == 5)
        {
          bool1 = bool2;
          if (((TimeLineObject)localObject4).xTS.wOd.fgj == 1)
          {
            bool1 = bool2;
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm())
            {
              localObject1 = new s();
              ((s)localObject1).fjC = localIntent.getStringExtra("KPublisherId");
              ((s)localObject1).crk = localIntent.getStringExtra("sns_local_id");
              ((s)localObject1).cqX = localIntent.getStringExtra("srcUsername");
              ((s)localObject1).fjB = localIntent.getStringExtra("srcDisplayname");
              ((s)localObject1).fjD.url = localIntent.getStringExtra("rawUrl");
              ((s)localObject1).fjD.title = ((TimeLineObject)localObject4).xTS.Title;
              ((s)localObject1).fjD.fjL = ((TimeLineObject)localObject4).xTS.wOd.desc;
              if (bo.isNullOrNil(((TimeLineObject)localObject4).xTS.wOd.lHo)) {
                break label3103;
              }
              ((s)localObject1).fjD.fjJ = ((TimeLineObject)localObject4).xTS.wOd.lHo;
              label2525:
              ((s)localObject1).fjD.type = i;
              ((s)localObject1).fjD.time = ((TimeLineObject)localObject4).xTS.wOd.fgi;
              ((s)localObject1).fjD.fjN = ((TimeLineObject)localObject4).xTS.wOd.duration;
              ((s)localObject1).fjD.videoWidth = ((TimeLineObject)localObject4).xTS.wOd.videoWidth;
              ((s)localObject1).fjD.videoHeight = ((TimeLineObject)localObject4).xTS.wOd.videoHeight;
              ((s)localObject1).fjD.fgl = ((TimeLineObject)localObject4).xTS.wOd.fgl;
              ((s)localObject1).fgk = ((TimeLineObject)localObject4).xTS.wOd.fgk;
              ((s)localObject1).t(localIntent);
              localIntent.putExtra("biz_video_scene", 2);
              localIntent.putExtra("biz_video_subscene", j);
              localObject1 = new int[2];
              paramView = paramView.findViewById(2131825855);
              if (paramView != null)
              {
                int k = paramView.getWidth();
                int m = paramView.getHeight();
                paramView.getLocationInWindow((int[])localObject1);
                localIntent.putExtra("img_gallery_width", k).putExtra("img_gallery_height", m).putExtra("img_gallery_left", localObject1[0]).putExtra("img_gallery_top", localObject1[1]);
              }
              bool1 = true;
            }
          }
        }
      }
      if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(4)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.scK.context, str, i, bool1, 2, j, localIntent))) {
        break label3122;
      }
      ab.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
      label2810:
      localObject1 = null;
      j = 0;
      i = j;
      paramView = (View)localObject1;
      if (localObject4 != null)
      {
        i = j;
        paramView = (View)localObject1;
        if (((TimeLineObject)localObject4).xTR != null)
        {
          paramView = ((TimeLineObject)localObject4).xTR.Id;
          i = bo.getInt(((TimeLineObject)localObject4).xTR.jKg, 0);
        }
      }
      localObject3 = com.tencent.mm.plugin.sns.c.a.gmP.t(paramView, i);
      if (!bo.isNullOrNil((String)localObject3))
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if (((TimeLineObject)localObject4).rjv != null)
          {
            localObject1 = localObject2;
            if (((TimeLineObject)localObject4).rjv.wmJ != null) {
              localObject1 = ((TimeLineObject)localObject4).rjv.wmJ.wmD;
            }
          }
        }
        if (localObject4 != null) {
          break label3142;
        }
        localObject2 = null;
        label2940:
        com.tencent.mm.plugin.sns.c.a.gmP.a(this.scK.context, paramView, (String)localObject3, (String)localObject2, 5, 4, 1, (String)localObject1, ((TimeLineObject)localObject4).Id);
      }
      h.qsU.e(11105, new Object[] { ((TimeLineObject)localObject4).jJA, ((TimeLineObject)localObject4).xTS.Url });
      if ((localn != null) && (localn.field_type == 4))
      {
        paramView = (bcs)((TimeLineObject)localObject4).xTS.wOa.get(0);
        localObject1 = h.qsU;
        if (paramView != null) {
          break label3152;
        }
      }
    }
    label3098:
    label3103:
    label3122:
    label3142:
    label3152:
    for (paramView = "";; paramView = paramView.Desc)
    {
      ((h)localObject1).e(13043, new Object[] { Integer.valueOf(1), paramView, ((TimeLineObject)localObject4).xTR.Id });
      AppMethodBeat.o(39862);
      return;
      i = -1;
      break;
      ((s)localObject1).fjD.fjJ = localIntent.getStringExtra("share_report_pre_msg_icon_url");
      break label2525;
      com.tencent.mm.plugin.sns.c.a.gmO.i(localIntent, this.scK.context);
      break label2810;
      localObject2 = ((TimeLineObject)localObject4).jJA;
      break label2940;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.1
 * JD-Core Version:    0.7.0.1
 */