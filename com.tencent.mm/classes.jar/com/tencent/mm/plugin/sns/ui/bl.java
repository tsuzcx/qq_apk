package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.lm.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.sns.a.b.m;
import com.tencent.mm.plugin.sns.a.b.m.a;
import com.tencent.mm.plugin.sns.a.b.m.b;
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.m;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class bl
{
  Context context;
  int dep;
  long lVv;
  com.tencent.mm.ui.base.p tipDialog;
  public View.OnClickListener xDo;
  public View.OnClickListener xLA;
  public View.OnClickListener xLB;
  public View.OnClickListener xLC;
  public View.OnClickListener xLD;
  public View.OnClickListener xLE;
  public View.OnClickListener xLF;
  public View.OnClickListener xLG;
  public View.OnClickListener xLH;
  public View.OnClickListener xLI;
  public View.OnClickListener xLJ;
  public View.OnClickListener xLK;
  public View.OnClickListener xLL;
  private a xLw;
  public View.OnClickListener xLx;
  public View.OnClickListener xLy;
  public View.OnClickListener xLz;
  ae xlD;
  
  public bl(Context paramContext, a parama, int paramInt, ae paramae)
  {
    AppMethodBeat.i(99741);
    this.dep = 0;
    this.lVv = 0L;
    this.xDo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        long l = System.currentTimeMillis();
        if (l - bl.this.lVv < 500L)
        {
          AppMethodBeat.o(99724);
          return;
        }
        bl.this.lVv = l;
        Object localObject4;
        Object localObject3;
        TimeLineObject localTimeLineObject;
        com.tencent.mm.plugin.sns.storage.p localp;
        Object localObject5;
        label524:
        label888:
        Object localObject2;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          localObject4 = (s)paramAnonymousView.getTag();
          localObject3 = null;
          localTimeLineObject = ((s)localObject4).xmh;
          localp = af.dtu().apK(((s)localObject4).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C(localp);
          }
          Object localObject1;
          if (localTimeLineObject.Etm.DaB == 18)
          {
            paramAnonymousView = bl.this;
            localObject1 = bl.this.context;
            localObject3 = ((s)localObject4).xmh;
            localObject4 = ((s)localObject4).dgg;
            localObject4 = af.dtu().apK((String)localObject4);
            m.a(m.b.wzc, m.a.wyU, (com.tencent.mm.plugin.sns.storage.p)localObject4, paramAnonymousView.dep);
            localObject4 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject3).Etm.DaC.size() > 0) {
              paramAnonymousView = (bpi)((TimeLineObject)localObject3).Etm.DaC.get(0);
            }
            ((Intent)localObject4).putExtra("KFromTimeLine", false);
            ((Intent)localObject4).putExtra("KStremVideoUrl", ((TimeLineObject)localObject3).Etm.Url);
            ((Intent)localObject4).putExtra("KSta_SourceType", 2);
            ((Intent)localObject4).putExtra("KSta_Scene", m.b.wzc.value);
            ((Intent)localObject4).putExtra("KSta_FromUserName", ((TimeLineObject)localObject3).mAQ);
            ((Intent)localObject4).putExtra("KSta_SnSId", ((TimeLineObject)localObject3).Id);
            if (paramAnonymousView == null)
            {
              localObject5 = new StringBuilder("fakeid_");
              if (paramAnonymousView == null)
              {
                paramAnonymousView = ((TimeLineObject)localObject3).Id;
                ((Intent)localObject4).putExtra("KMediaId", paramAnonymousView);
              }
            }
            for (;;)
            {
              paramAnonymousView = ((TimeLineObject)localObject3).Etr;
              if (paramAnonymousView != null)
              {
                ((Intent)localObject4).putExtra("KMediaVideoTime", paramAnonymousView.gJw);
                ((Intent)localObject4).putExtra("StreamWording", paramAnonymousView.gJy);
                ((Intent)localObject4).putExtra("StremWebUrl", paramAnonymousView.gJz);
                ((Intent)localObject4).putExtra("KMediaTitle", paramAnonymousView.gJx);
                ((Intent)localObject4).putExtra("KStremVideoUrl", paramAnonymousView.gJv);
                ((Intent)localObject4).putExtra("KThumUrl", paramAnonymousView.gJA);
                ((Intent)localObject4).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.gJB);
                ((Intent)localObject4).putExtra("KSta_StremVideoPublishId", paramAnonymousView.gJC);
              }
              ((Intent)localObject4).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject3).xns);
              if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjp, 0) <= 0) {
                break label524;
              }
              com.tencent.mm.bs.d.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject4);
              ad.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
              AppMethodBeat.o(99724);
              return;
              paramAnonymousView = paramAnonymousView.Id;
              break;
              ((Intent)localObject4).putExtra("KMediaId", paramAnonymousView.Id);
            }
            com.tencent.mm.bs.d.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject4);
            AppMethodBeat.o(99724);
            return;
          }
          if ((localTimeLineObject.wLn != null) && (!bt.isNullOrNil(localTimeLineObject.wLn.AGs)))
          {
            localObject1 = bl.this;
            paramAnonymousView = localTimeLineObject.wLn;
            if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.AGs)))
            {
              localObject3 = com.tencent.mm.plugin.topstory.a.h.a(paramAnonymousView, 31, ac.ave("discoverRecommendEntry").optString("wording"));
              aa.a(((bl)localObject1).context, (dcy)localObject3);
              localObject1 = localTimeLineObject.mAQ;
              localObject4 = localTimeLineObject.Id;
              localObject3 = new StringBuffer();
              ((StringBuffer)localObject3).append("isShareClick=1");
              ((StringBuffer)localObject3).append("&relevant_vid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.AGs);
              ((StringBuffer)localObject3).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.AGu);
              ((StringBuffer)localObject3).append("&relevant_shared_openid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.AGv);
              ((StringBuffer)localObject3).append("&rec_category=");
              if (paramAnonymousView.AGE <= 0L) {
                break label888;
              }
              ((StringBuffer)localObject3).append(paramAnonymousView.AGE);
            }
            for (;;)
            {
              ((StringBuffer)localObject3).append("&source=");
              ((StringBuffer)localObject3).append(paramAnonymousView.source);
              ((StringBuffer)localObject3).append("&fromUser=");
              ((StringBuffer)localObject3).append((String)localObject1);
              ((StringBuffer)localObject3).append("&fromScene=");
              ((StringBuffer)localObject3).append(3);
              ((StringBuffer)localObject3).append("&targetInfo=");
              ((StringBuffer)localObject3).append((String)localObject4);
              ((StringBuffer)localObject3).append("&expand=");
              ((StringBuffer)localObject3).append(paramAnonymousView.AGt);
              ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject3).toString() });
              paramAnonymousView = new ckd();
              paramAnonymousView.Eff = ((StringBuffer)localObject3).toString();
              paramAnonymousView = new w(paramAnonymousView);
              g.aeS().a(paramAnonymousView, 0);
              AppMethodBeat.o(99724);
              return;
              ((StringBuffer)localObject3).append(paramAnonymousView.AGw);
            }
          }
          if (localTimeLineObject.Etm.DaB == 28)
          {
            l = com.tencent.mm.plugin.sns.data.q.anR(localTimeLineObject.Etm.DaG.objectId);
            if (l != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.mAQ);
              paramAnonymousView.putExtra("feed_object_id", l);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.Etm.DaG.objectNonceId);
              paramAnonymousView.putExtra("tab_type", 5);
              ((j)g.ad(j.class)).enterFinderShareFeedUI(bl.this.context, paramAnonymousView);
              AppMethodBeat.o(99724);
              return;
            }
          }
          if ((localTimeLineObject.Etm.DaB == 29) && (localTimeLineObject.Etm.DaH != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.Etm.DaH.dqA);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.Etm.DaH.qSS);
            localObject1 = new ajq();
            ((ajq)localObject1).DlE = localTimeLineObject.Etm.DaH.Dmy.DlE;
            ((ajq)localObject1).dqQ = localTimeLineObject.Etm.DaH.Dmy.dqQ;
            ((ajq)localObject1).dpb = localTimeLineObject.Etm.DaH.Dmy.dpb;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((ajq)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.mAQ);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              ((j)g.ad(j.class)).enterFinderTopicUI(bl.this.context, paramAnonymousView);
              AppMethodBeat.o(99724);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ad.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
              }
            }
          }
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localTimeLineObject.xpl))
          {
            localObject2 = localObject3;
            if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localTimeLineObject.xpl))
            {
              localObject5 = bl.aA(localTimeLineObject.xpl, "adxml", ".adxml.adActionLink");
              localObject2 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject2 = bl.aqD((String)localObject5);
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label3590;
          }
          localObject2 = bl.aqD(localTimeLineObject.Etm.Url);
        }
        label2690:
        label3590:
        for (;;)
        {
          if ((localObject2 == null) || (((String)localObject2).length() == 0))
          {
            AppMethodBeat.o(99724);
            return;
          }
          int j = bl.this.xlD.getScene();
          localObject3 = localObject2;
          int i;
          if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject3 = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 2, j, i);
          }
          Intent localIntent = new Intent();
          localObject2 = null;
          if (localTimeLineObject != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("KSnsStrId", localTimeLineObject.Id);
            ((Bundle)localObject2).putString("KSnsLocalId", ((s)localObject4).dgg);
            ((Bundle)localObject2).putBoolean("KFromTimeline", true);
            if ((localTimeLineObject.Etm != null) && (localTimeLineObject.Etm.DaC.size() > 0))
            {
              ((Bundle)localObject2).putString("K_sns_thumb_url", ((bpi)localTimeLineObject.Etm.DaC.get(0)).DMQ);
              ((Bundle)localObject2).putString("K_sns_raw_url", localTimeLineObject.Etm.Url);
              ad.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((bpi)localTimeLineObject.Etm.DaC.get(0)).DMQ, localTimeLineObject.Etm.Url });
            }
          }
          ((Bundle)localObject2).putString("key_snsad_statextstr", localTimeLineObject.xns);
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("shortUrl", (String)localObject3);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          if (localTimeLineObject.Etn != null)
          {
            localIntent.putExtra("srcUsername", localTimeLineObject.Etn);
            localIntent.putExtra("srcDisplayname", localTimeLineObject.BXw);
            ad.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + localTimeLineObject.BXw + " tlObj.publicUserName: " + localTimeLineObject.Etn);
          }
          localIntent.putExtra("sns_local_id", ((s)localObject4).dgg);
          if (localp != null)
          {
            localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
            localIntent.putExtra("pre_username", localp.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
            localIntent.putExtra("preUsername", localp.field_userName);
            localIntent.putExtra("share_report_pre_msg_url", (String)localObject3);
            localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.Etm.Title);
            localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.Etm.Desc);
            if ((localTimeLineObject.Etm.DaC != null) && (localTimeLineObject.Etm.DaC.size() > 0)) {
              localIntent.putExtra("share_report_pre_msg_icon_url", ((bpi)localTimeLineObject.Etm.DaC.get(0)).DMQ);
            }
            localIntent.putExtra("share_report_pre_msg_appid", "");
            localIntent.putExtra("share_report_from_scene", 1);
          }
          if ((localTimeLineObject != null) && (localTimeLineObject.Etl != null)) {
            localIntent.putExtra("KAppId", localTimeLineObject.Etl.Id);
          }
          if ((localp != null) && (localp.Nb(32)))
          {
            if (bl.this.dep != 2) {
              break label2669;
            }
            localObject4 = localp.dxv();
            if (localObject4 != null) {
              localIntent.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject4).dAM);
            }
          }
          if ((localp != null) && (localTimeLineObject != null))
          {
            if (bl.this.dep != 0) {
              break label2679;
            }
            localObject4 = com.tencent.mm.modelsns.d.oE(718);
            label2072:
            com.tencent.mm.modelsns.d locald = ((com.tencent.mm.modelsns.d)localObject4).zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg()).zi(localTimeLineObject.Etn);
            if (localTimeLineObject.Etl != null) {
              break label2690;
            }
            localObject5 = "";
            label2131:
            locald.zi((String)localObject5).zi(localTimeLineObject.Etm.Url);
            ((com.tencent.mm.modelsns.d)localObject4).aBj();
            if (bl.this.dep != 0) {
              break label2703;
            }
            localObject4 = com.tencent.mm.modelsns.d.oE(743);
            label2174:
            locald = ((com.tencent.mm.modelsns.d)localObject4).zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg()).zi(localTimeLineObject.Etn);
            if (localTimeLineObject.Etl != null) {
              break label2714;
            }
            localObject5 = "";
            label2233:
            locald.zi((String)localObject5).zi(localTimeLineObject.Etm.Url);
            if (localObject2 != null)
            {
              localObject4 = ((com.tencent.mm.modelsns.d)localObject4).avk();
              if (localObject4 != null) {
                ((Bundle)localObject2).putByteArray("intent_key_StatisticsOplog", (byte[])localObject4);
              }
            }
          }
          if (localObject2 != null) {
            localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          }
          localIntent.putExtra("geta8key_scene", 2);
          localIntent.putExtra("from_scence", 3);
          if ((localTimeLineObject.Etm.DaF != null) && (localTimeLineObject.Etm.DaF.gKq != -1)) {
            localIntent.putExtra(e.m.FIt, localTimeLineObject.Etm.DaF.gKq);
          }
          if ((!bt.isNullOrNil(localTimeLineObject.xpl)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localTimeLineObject.xpl)) && (localp != null))
          {
            localObject2 = new int[2];
            if (paramAnonymousView != null) {
              paramAnonymousView.getLocationInWindow((int[])localObject2);
            }
            i = paramAnonymousView.getWidth();
            j = paramAnonymousView.getHeight();
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
            paramAnonymousView.putExtra("img_gallery_width", i);
            paramAnonymousView.putExtra("img_gallery_height", j);
            if (localTimeLineObject != null)
            {
              localObject2 = localTimeLineObject.Etm.DaC;
              if (((List)localObject2).size() > 0) {
                paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bpi)((List)localObject2).get(0)).DMQ);
              }
            }
            paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
            paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dxy().Id);
            paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dyc());
            paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dyd());
            paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dyg());
            if (bl.this.dep == 0) {}
            for (i = 3;; i = 4)
            {
              paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
              paramAnonymousView.setClass(bl.this.context, SnsAdNativeLandingPagesUI.class);
              paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.xpl);
              paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dyi());
              paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(paramAnonymousView, bl.this.context);
              AppMethodBeat.o(99724);
              return;
              label2669:
              localObject4 = localp.dxu();
              break;
              label2679:
              localObject4 = com.tencent.mm.modelsns.d.oF(718);
              break label2072;
              localObject5 = localTimeLineObject.Etl.Id;
              break label2131;
              label2703:
              localObject4 = com.tencent.mm.modelsns.d.oF(743);
              break label2174;
              label2714:
              localObject5 = localTimeLineObject.Etl.Id;
              break label2233;
            }
          }
          localIntent.addFlags(536870912);
          if (localTimeLineObject.Etm.DaF != null)
          {
            i = localTimeLineObject.Etm.DaF.gKq;
            if ((localTimeLineObject.Etm.DaF != null) && (i == 5) && (localTimeLineObject.Etm.DaF.gGz == 1) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR()))
            {
              localObject2 = new x();
              ((x)localObject2).gKw = localIntent.getStringExtra("KPublisherId");
              ((x)localObject2).dgg = localIntent.getStringExtra("sns_local_id");
              ((x)localObject2).dfT = localIntent.getStringExtra("srcUsername");
              ((x)localObject2).gKv = localIntent.getStringExtra("srcDisplayname");
              ((x)localObject2).gKx.url = localIntent.getStringExtra("rawUrl");
              ((x)localObject2).gKx.title = localTimeLineObject.Etm.Title;
              ((x)localObject2).gKx.gKF = localTimeLineObject.Etm.DaF.desc;
              if (bt.isNullOrNil(localTimeLineObject.Etm.DaF.coverUrl)) {
                break label3533;
              }
              ((x)localObject2).gKx.gKD = localTimeLineObject.Etm.DaF.coverUrl;
              label2960:
              ((x)localObject2).gKx.type = i;
              ((x)localObject2).gKx.time = localTimeLineObject.Etm.DaF.gGy;
              ((x)localObject2).gKx.gKH = localTimeLineObject.Etm.DaF.duration;
              ((x)localObject2).gKx.videoWidth = localTimeLineObject.Etm.DaF.videoWidth;
              ((x)localObject2).gKx.videoHeight = localTimeLineObject.Etm.DaF.videoHeight;
              ((x)localObject2).gKx.gGC = localTimeLineObject.Etm.DaF.gGC;
              ((x)localObject2).gGB = localTimeLineObject.Etm.DaF.gGB;
              ((x)localObject2).t(localIntent);
              localIntent.putExtra(e.b.FHP, 2);
              localIntent.putExtra(e.b.FHQ, j);
              localObject2 = new int[2];
              paramAnonymousView = paramAnonymousView.findViewById(2131300948);
              if (paramAnonymousView != null)
              {
                int k = paramAnonymousView.getWidth();
                int m = paramAnonymousView.getHeight();
                paramAnonymousView.getLocationInWindow((int[])localObject2);
                localIntent.putExtra("img_gallery_width", k).putExtra("img_gallery_height", m).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
              }
            }
            if ((!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(4)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(bl.this.context, (String)localObject3, i, 2, j, localIntent))) {
              break label3552;
            }
            ad.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
            label3240:
            localObject2 = null;
            j = 0;
            i = j;
            paramAnonymousView = (View)localObject2;
            if (localTimeLineObject != null)
            {
              i = j;
              paramAnonymousView = (View)localObject2;
              if (localTimeLineObject.Etl != null)
              {
                paramAnonymousView = localTimeLineObject.Etl.Id;
                i = bt.getInt(localTimeLineObject.Etl.Version, 0);
              }
            }
            localObject4 = com.tencent.mm.plugin.sns.d.a.hYu.s(paramAnonymousView, i);
            if (!bt.isNullOrNil((String)localObject4))
            {
              localObject3 = null;
              localObject2 = localObject3;
              if (localTimeLineObject != null)
              {
                localObject2 = localObject3;
                if (localTimeLineObject.wLl != null)
                {
                  localObject2 = localObject3;
                  if (localTimeLineObject.wLl.CuY != null) {
                    localObject2 = localTimeLineObject.wLl.CuY.CuS;
                  }
                }
              }
              if (localTimeLineObject != null) {
                break label3572;
              }
              localObject3 = null;
              label3370:
              com.tencent.mm.plugin.sns.d.a.hYu.a(bl.this.context, paramAnonymousView, (String)localObject4, (String)localObject3, 5, 4, 1, (String)localObject2, localTimeLineObject.Id);
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(11105, new Object[] { localTimeLineObject.mAQ, localTimeLineObject.Etm.Url });
            if ((localp != null) && (localp.field_type == 4))
            {
              paramAnonymousView = (bpi)localTimeLineObject.Etm.DaC.get(0);
              localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
              if (paramAnonymousView != null) {
                break label3582;
              }
            }
          }
          label3533:
          label3552:
          label3572:
          label3582:
          for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.Desc)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject2).f(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.Etl.Id });
            AppMethodBeat.o(99724);
            return;
            i = -1;
            break;
            ((x)localObject2).gKx.gKD = localIntent.getStringExtra("share_report_pre_msg_icon_url");
            break label2960;
            com.tencent.mm.plugin.sns.d.a.hYt.i(localIntent, bl.this.context);
            break label3240;
            localObject3 = localTimeLineObject.mAQ;
            break label3370;
          }
        }
      }
    };
    this.xLx = new bl.9(this);
    this.xLy = new bl.10(this);
    this.xLz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99735);
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99735);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).xmh;
        if (((TimeLineObject)localObject1).Etm.DaC.size() > 0)
        {
          localObject2 = af.dtu().apK(((s)localObject2).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bpi)((TimeLineObject)localObject1).Etm.DaC.get(0)).xmd;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_Product_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99735);
      }
    };
    this.xLA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99736);
        ad.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99736);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).xmh;
        if (((TimeLineObject)localObject1).Etm.DaC.size() > 0)
        {
          localObject2 = af.dtu().apK(((s)localObject2).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bpi)((TimeLineObject)localObject1).Etm.DaC.get(0)).xmd;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_TV_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99736);
      }
    };
    this.xLB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99737);
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99737);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).xmh;
        if (((TimeLineObject)localObject1).Etm.DaC.size() > 0)
        {
          localObject2 = af.dtu().apK(((s)localObject2).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bpi)((TimeLineObject)localObject1).Etm.DaC.get(0)).xmd;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("preceding_scence", 10);
          ((Intent)localObject2).putExtra("download_entrance_scene", 13);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99737);
      }
    };
    this.xLC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99738);
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99738);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).xmh;
        if (((TimeLineObject)localObject1).Etm.DaC.size() > 0)
        {
          localObject2 = af.dtu().apK(((s)localObject2).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bpi)((TimeLineObject)localObject1).Etm.DaC.get(0)).xmd;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99738);
      }
    };
    this.xLD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99739);
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99739);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).xmh;
        if (((TimeLineObject)localObject1).Etm.DaC.size() > 0)
        {
          localObject2 = af.dtu().apK(((s)localObject2).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bpi)((TimeLineObject)localObject1).Etm.DaC.get(0)).xmd;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99739);
      }
    };
    this.xLE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99740);
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99740);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).xmh;
        if (((TimeLineObject)localObject1).Etm.DaC.size() > 0)
        {
          localObject2 = af.dtu().apK(((s)localObject2).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bpi)((TimeLineObject)localObject1).Etm.DaC.get(0)).xmd;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99740);
      }
    };
    this.xLF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99725);
        boolean bool = paramAnonymousView.getTag() instanceof s;
        ad.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(bool)));
        if (!bool)
        {
          AppMethodBeat.o(99725);
          return;
        }
        paramAnonymousView = (s)paramAnonymousView.getTag();
        bl.a(bl.this, paramAnonymousView);
        AppMethodBeat.o(99725);
      }
    };
    this.xLG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        ad.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).xmh;
        localObject = af.dtu().apK(((s)localObject).dgg);
        if (bl.this.xlD != null) {
          bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        if (paramAnonymousView.Ets == null)
        {
          ad.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          AppMethodBeat.o(99726);
          return;
        }
        String str1 = paramAnonymousView.Ets.username;
        String str2 = paramAnonymousView.Ets.path;
        ad.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        uj localuj = new uj();
        localuj.dzH.userName = str1;
        localuj.dzH.dzJ = str2;
        localuj.dzH.scene = 1009;
        localuj.dzH.dbt = (paramAnonymousView.Id + ":" + paramAnonymousView.mAQ);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject).field_userName);
        paramAnonymousView.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
        com.tencent.mm.sdk.b.a.ESL.l(localuj);
        AppMethodBeat.o(99726);
      }
    };
    this.xLH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        ad.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        TimeLineObject localTimeLineObject = ((s)localObject).xmh;
        localObject = af.dtu().apK(((s)localObject).dgg);
        if (bl.this.xlD != null) {
          bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        if (localTimeLineObject.Ets == null)
        {
          ad.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          AppMethodBeat.o(99727);
          return;
        }
        localObject = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject).jdC = 6;
        ((AppBrandLaunchReferrer)localObject).dzY = localTimeLineObject.Ets.dzY;
        ad.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { ((AppBrandLaunchReferrer)localObject).jdD });
        com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
        localf.username = localTimeLineObject.Ets.username;
        localf.iJb = localTimeLineObject.Ets.path;
        localf.gXn = localTimeLineObject.Ets.AHI;
        localf.version = localTimeLineObject.Ets.version;
        localf.iJm = localTimeLineObject.Etm.Title;
        localf.launchMode = 1;
        localf.scene = 1154;
        localf.dbt = localTimeLineObject.Ets.EGj;
        localf.iJk = ((AppBrandLaunchReferrer)localObject);
        ((n)g.ab(n.class)).a(paramAnonymousView.getContext(), localf);
        AppMethodBeat.o(99727);
      }
    };
    this.xLI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99728);
        ad.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          AppMethodBeat.o(99728);
          return;
        }
        paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
        if (paramAnonymousView.Ets == null)
        {
          ad.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          AppMethodBeat.o(99728);
          return;
        }
        String str = paramAnonymousView.Ets.username;
        uj localuj = new uj();
        ad.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(str)));
        localuj.dzH.userName = str;
        localuj.dzH.scene = 1009;
        localuj.dzH.dbt = (paramAnonymousView.Id + ":" + paramAnonymousView.mAQ);
        com.tencent.mm.sdk.b.a.ESL.l(localuj);
        AppMethodBeat.o(99728);
      }
    };
    this.xLJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        ad.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99729);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).xmh;
        if (paramAnonymousView.Etm.DaC.size() > 0)
        {
          localObject = af.dtu().apK(((s)localObject).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((bpi)paramAnonymousView.Etm.DaC.get(0)).xmd;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_scene", 2);
          ((Intent)localObject).putExtra("key_product_info", paramAnonymousView);
          com.tencent.mm.bs.d.b(bl.this.context, "product", ".ui.MallProductUI", (Intent)localObject);
        }
        AppMethodBeat.o(99729);
      }
    };
    this.xLK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).xmh;
        if (paramAnonymousView.Etm.DaC.size() > 0)
        {
          localObject = af.dtu().apK(((s)localObject).dgg);
          if (bl.this.xlD != null) {
            bl.this.xlD.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((bpi)paramAnonymousView.Etm.DaC.get(0)).xmd;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_from_scene", 12);
          if (!TextUtils.isEmpty(paramAnonymousView))
          {
            String[] arrayOfString = paramAnonymousView.split("#");
            if (arrayOfString.length >= 2)
            {
              ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
              ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
              ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
              com.tencent.mm.bs.d.b(bl.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
              AppMethodBeat.o(99730);
              return;
            }
            if (arrayOfString.length == 1)
            {
              ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
              ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramAnonymousView)));
              ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
              ((Intent)localObject).putExtra("key_card_ext", "");
              com.tencent.mm.bs.d.b(bl.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
              AppMethodBeat.o(99730);
              return;
            }
            ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
            ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(paramAnonymousView)));
            AppMethodBeat.o(99730);
            return;
          }
          ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
        }
        AppMethodBeat.o(99730);
      }
    };
    this.xLL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179318);
        ad.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        gs localgs;
        String str;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          if (locals.xmh.Etm.DaB == 26)
          {
            if (bt.isNullOrNil(locals.xmh.Etm.DaE))
            {
              AppMethodBeat.o(179318);
              return;
            }
            localgs = new gs();
            localgs.dkc.type = 37;
            localgs.dkc.desc = locals.xmh.Etm.DaE;
            str = "";
            paramAnonymousView = str;
            if (locals.xmh.Etm.DaC != null)
            {
              paramAnonymousView = str;
              if (locals.xmh.Etm.DaC.size() > 0)
              {
                paramAnonymousView = an.iF(af.getAccSnsPath(), ((bpi)locals.xmh.Etm.DaC.get(0)).Id);
                str = com.tencent.mm.plugin.sns.data.q.d((bpi)locals.xmh.Etm.DaC.get(0));
                if (!com.tencent.mm.vfs.i.eK(paramAnonymousView + str)) {
                  break label282;
                }
              }
            }
          }
        }
        label282:
        for (paramAnonymousView = paramAnonymousView + str;; paramAnonymousView = "")
        {
          localgs.dkc.path = paramAnonymousView;
          localgs.dkc.title = locals.dgg;
          localgs.dkc.context = bl.this.context;
          com.tencent.mm.sdk.b.a.ESL.l(localgs);
          AppMethodBeat.o(179318);
          return;
        }
      }
    };
    this.context = paramContext;
    this.xLw = parama;
    this.dep = paramInt;
    this.xlD = paramae;
    AppMethodBeat.o(99741);
  }
  
  public static String aA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(99744);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(99744);
      return "";
    }
    try
    {
      paramString1 = (String)bw.K(paramString1, paramString2).get(paramString3);
      AppMethodBeat.o(99744);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.TimeLineClickEvent", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(99744);
    }
    return "";
  }
  
  protected static boolean amF(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new lm();
    ((lm)localObject).dqd.action = -2;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((lm)localObject).dqe.dqf;
    if ((localObject != null) && (com.tencent.mm.az.a.e((com.tencent.mm.az.f)localObject)) && (paramString.equals(((com.tencent.mm.az.f)localObject).hnp)) && (com.tencent.mm.az.a.azF()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  protected static String aqD(String paramString)
  {
    AppMethodBeat.i(99743);
    ad.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.d.a.hYu.O(paramString, "timeline");
    AppMethodBeat.o(99743);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void cEs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl
 * JD-Core Version:    0.7.0.1
 */