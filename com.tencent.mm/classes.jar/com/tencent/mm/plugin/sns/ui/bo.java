package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.me.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.b;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.m;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public final class bo
{
  public View.OnClickListener Ahy;
  private a ApW;
  public View.OnClickListener ApX;
  public View.OnClickListener ApY;
  public View.OnClickListener ApZ;
  public View.OnClickListener Aqa;
  public View.OnClickListener Aqb;
  public View.OnClickListener Aqc;
  public View.OnClickListener Aqd;
  public View.OnClickListener Aqe;
  public View.OnClickListener Aqf;
  public View.OnClickListener Aqg;
  public View.OnClickListener Aqh;
  public View.OnClickListener Aqi;
  public View.OnClickListener Aqj;
  public View.OnClickListener Aqk;
  public View.OnClickListener Aql;
  public View.OnClickListener Aqm;
  public View.OnClickListener Aqn;
  public View.OnClickListener Aqo;
  Context context;
  int dnh;
  long mYb;
  com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.plugin.sns.model.af zPG;
  
  public bo(Context paramContext, a parama, int paramInt, com.tencent.mm.plugin.sns.model.af paramaf)
  {
    AppMethodBeat.i(99741);
    this.dnh = 0;
    this.mYb = 0L;
    this.Ahy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        long l = System.currentTimeMillis();
        if (l - bo.this.mYb < 500L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
        }
        bo.this.mYb = l;
        Object localObject4;
        Object localObject3;
        TimeLineObject localTimeLineObject;
        com.tencent.mm.plugin.sns.storage.p localp;
        Object localObject5;
        label378:
        int i;
        label584:
        Object localObject2;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          localObject4 = (s)paramAnonymousView.getTag();
          localObject3 = null;
          localTimeLineObject = ((s)localObject4).zQl;
          localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject4).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F(localp);
          }
          if (localTimeLineObject.HAT.GaP == 18)
          {
            paramAnonymousView = bo.this;
            localObject1 = bo.this.context;
            localObject3 = ((s)localObject4).zQl;
            localObject4 = ((s)localObject4).doX;
            localObject4 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa((String)localObject4);
            com.tencent.mm.plugin.sns.ad.d.m.a(m.b.yZS, m.a.yZK, (com.tencent.mm.plugin.sns.storage.p)localObject4, paramAnonymousView.dnh);
            localObject4 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject3).HAT.GaQ.size() > 0) {
              paramAnonymousView = (byn)((TimeLineObject)localObject3).HAT.GaQ.get(0);
            }
            ((Intent)localObject4).putExtra("KFromTimeLine", false);
            ((Intent)localObject4).putExtra("KStremVideoUrl", ((TimeLineObject)localObject3).HAT.Url);
            ((Intent)localObject4).putExtra("KSta_SourceType", 2);
            ((Intent)localObject4).putExtra("KSta_Scene", m.b.yZS.value);
            ((Intent)localObject4).putExtra("KSta_FromUserName", ((TimeLineObject)localObject3).nDo);
            ((Intent)localObject4).putExtra("KSta_SnSId", ((TimeLineObject)localObject3).Id);
            if (paramAnonymousView == null)
            {
              localObject5 = new StringBuilder("fakeid_");
              if (paramAnonymousView == null)
              {
                paramAnonymousView = ((TimeLineObject)localObject3).Id;
                ((Intent)localObject4).putExtra("KMediaId", paramAnonymousView);
                paramAnonymousView = ((TimeLineObject)localObject3).HAY;
                if (paramAnonymousView != null)
                {
                  ((Intent)localObject4).putExtra("KMediaVideoTime", paramAnonymousView.hCf);
                  ((Intent)localObject4).putExtra("StreamWording", paramAnonymousView.hCh);
                  ((Intent)localObject4).putExtra("StremWebUrl", paramAnonymousView.hCi);
                  ((Intent)localObject4).putExtra("KMediaTitle", paramAnonymousView.hCg);
                  ((Intent)localObject4).putExtra("KStremVideoUrl", paramAnonymousView.hCe);
                  ((Intent)localObject4).putExtra("KThumUrl", paramAnonymousView.hCj);
                  ((Intent)localObject4).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.hCk);
                  ((Intent)localObject4).putExtra("KSta_StremVideoPublishId", paramAnonymousView.hCl);
                }
                ((Intent)localObject4).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject3).zRz);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqx, 0) <= 0) {
                  break label584;
                }
                com.tencent.mm.bs.d.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject4);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              paramAnonymousView = paramAnonymousView.Id;
              break;
              ((Intent)localObject4).putExtra("KMediaId", paramAnonymousView.Id);
              break label378;
              com.tencent.mm.bs.d.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject4);
            }
          }
          if ((localTimeLineObject.znS != null) && (!bt.isNullOrNil(localTimeLineObject.znS.DBG)))
          {
            localObject1 = bo.this;
            paramAnonymousView = localTimeLineObject.znS;
            if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.DBG)))
            {
              localObject3 = h.a(paramAnonymousView, 31, com.tencent.mm.plugin.websearch.api.af.aFP("discoverRecommendEntry").optString("wording"));
              com.tencent.mm.plugin.websearch.api.ad.a(((bo)localObject1).context, (doa)localObject3);
              localObject1 = localTimeLineObject.nDo;
              localObject4 = localTimeLineObject.Id;
              localObject3 = new StringBuffer();
              ((StringBuffer)localObject3).append("isShareClick=1");
              ((StringBuffer)localObject3).append("&relevant_vid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.DBG);
              ((StringBuffer)localObject3).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.DBI);
              ((StringBuffer)localObject3).append("&relevant_shared_openid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.DBJ);
              ((StringBuffer)localObject3).append("&rec_category=");
              if (paramAnonymousView.DBS <= 0L) {
                break label957;
              }
              ((StringBuffer)localObject3).append(paramAnonymousView.DBS);
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
              ((StringBuffer)localObject3).append(paramAnonymousView.DBH);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject3).toString() });
              paramAnonymousView = new cup();
              paramAnonymousView.Hmu = ((StringBuffer)localObject3).toString();
              paramAnonymousView = new z(paramAnonymousView);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousView, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              label957:
              ((StringBuffer)localObject3).append(paramAnonymousView.DBK);
            }
          }
          if (localTimeLineObject.HAT.GaP == 28)
          {
            l = com.tencent.mm.plugin.sns.data.q.ayi(localTimeLineObject.HAT.GaU.objectId);
            if (l != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.nDo);
              paramAnonymousView.putExtra("feed_object_id", l);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.HAT.GaU.objectNonceId);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.nDo);
              paramAnonymousView.putExtra("tab_type", 5);
              ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(4, 2, 25, paramAnonymousView);
              ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderShareFeedUI(bo.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
          }
          if ((localTimeLineObject.HAT.GaP == 29) && (localTimeLineObject.HAT.GaV != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.HAT.GaV.dzZ);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.HAT.GaV.sMj);
            localObject1 = new aoy();
            ((aoy)localObject1).Gnu = localTimeLineObject.HAT.GaV.Gpj.Gnu;
            ((aoy)localObject1).dAp = localTimeLineObject.HAT.GaV.Gpj.dAp;
            ((aoy)localObject1).dyz = localTimeLineObject.HAT.GaV.Gpj.dyz;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((aoy)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.nDo);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              if (localTimeLineObject.HAT.GaV.sMj == 1)
              {
                i = 22;
                ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderTopicUI(bo.this.context, paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
              }
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                continue;
                i = 26;
              }
            }
          }
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localTimeLineObject.zTv))
          {
            localObject2 = localObject3;
            if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localTimeLineObject.zTv))
            {
              localObject5 = bo.aJ(localTimeLineObject.zTv, "adxml", ".adxml.adActionLink");
              localObject2 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject2 = bo.aAT((String)localObject5);
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label3799;
          }
          localObject2 = bo.aAT(localTimeLineObject.HAT.Url);
        }
        label2257:
        label2900:
        label3157:
        label3799:
        for (;;)
        {
          if ((localObject2 == null) || (((String)localObject2).length() == 0))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
          }
          int j = bo.this.zPG.getScene();
          localObject3 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject3 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 2, j, i);
          }
          Intent localIntent = new Intent();
          localObject2 = null;
          if (localTimeLineObject != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("KSnsStrId", localTimeLineObject.Id);
            ((Bundle)localObject2).putString("KSnsLocalId", ((s)localObject4).doX);
            ((Bundle)localObject2).putBoolean("KFromTimeline", true);
            if ((localTimeLineObject.HAT != null) && (localTimeLineObject.HAT.GaQ.size() > 0))
            {
              ((Bundle)localObject2).putString("K_sns_thumb_url", ((byn)localTimeLineObject.HAT.GaQ.get(0)).GSI);
              ((Bundle)localObject2).putString("K_sns_raw_url", localTimeLineObject.HAT.Url);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((byn)localTimeLineObject.HAT.GaQ.get(0)).GSI, localTimeLineObject.HAT.Url });
            }
          }
          ((Bundle)localObject2).putString("key_snsad_statextstr", localTimeLineObject.zRz);
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("shortUrl", (String)localObject3);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          if (localTimeLineObject.HAU != null)
          {
            localIntent.putExtra("srcUsername", localTimeLineObject.HAU);
            localIntent.putExtra("srcDisplayname", localTimeLineObject.EUR);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + localTimeLineObject.EUR + " tlObj.publicUserName: " + localTimeLineObject.HAU);
          }
          localIntent.putExtra("sns_local_id", ((s)localObject4).doX);
          if (localp != null)
          {
            localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
            localIntent.putExtra("pre_username", localp.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
            localIntent.putExtra("preUsername", localp.field_userName);
            localIntent.putExtra("share_report_pre_msg_url", (String)localObject3);
            localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.HAT.Title);
            localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.HAT.Desc);
            if ((localTimeLineObject.HAT.GaQ != null) && (localTimeLineObject.HAT.GaQ.size() > 0)) {
              localIntent.putExtra("share_report_pre_msg_icon_url", ((byn)localTimeLineObject.HAT.GaQ.get(0)).GSI);
            }
            localIntent.putExtra("share_report_pre_msg_appid", "");
            localIntent.putExtra("share_report_from_scene", 1);
          }
          if ((localTimeLineObject != null) && (localTimeLineObject.HAS != null)) {
            localIntent.putExtra("KAppId", localTimeLineObject.HAS.Id);
          }
          if ((localp != null) && (localp.QM(32)))
          {
            if (bo.this.dnh != 2) {
              break label2866;
            }
            localObject4 = localp.dYi();
            if (localObject4 != null) {
              localIntent.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject4).aQj);
            }
          }
          if ((localp != null) && (localTimeLineObject != null))
          {
            if (bo.this.dnh != 0) {
              break label2876;
            }
            localObject4 = e.pV(718);
            e locale = ((e)localObject4).Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type).eS(localp.QM(32)).Gs(localp.dYT()).Gs(localTimeLineObject.HAU);
            if (localTimeLineObject.HAS != null) {
              break label2887;
            }
            localObject5 = "";
            locale.Gs((String)localObject5).Gs(localTimeLineObject.HAT.Url);
            ((e)localObject4).aLk();
            if (bo.this.dnh != 0) {
              break label2900;
            }
            localObject4 = e.pV(743);
            locale = ((e)localObject4).Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type).eS(localp.QM(32)).Gs(localp.dYT()).Gs(localTimeLineObject.HAU);
            if (localTimeLineObject.HAS != null) {
              break label2911;
            }
            localObject5 = "";
            label2418:
            locale.Gs((String)localObject5).Gs(localTimeLineObject.HAT.Url);
            if (localObject2 != null)
            {
              localObject4 = ((e)localObject4).aFg();
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
          if ((localTimeLineObject.HAT.GaT != null) && (localTimeLineObject.HAT.GaT.hCZ != -1)) {
            localIntent.putExtra(e.m.IUR, localTimeLineObject.HAT.GaT.hCZ);
          }
          if ((!bt.isNullOrNil(localTimeLineObject.zTv)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localTimeLineObject.zTv)) && (localp != null))
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
              localObject2 = localTimeLineObject.HAT.GaQ;
              if (((List)localObject2).size() > 0) {
                paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((byn)((List)localObject2).get(0)).GSI);
              }
            }
            paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
            paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dYl().Id);
            paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dYP());
            paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dYQ());
            paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dYT());
            if (bo.this.dnh == 0) {}
            for (i = 3;; i = 4)
            {
              paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
              paramAnonymousView.setClass(bo.this.context, SnsAdNativeLandingPagesUI.class);
              paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.zTv);
              paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dYV());
              paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(paramAnonymousView, bo.this.context);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              localObject4 = localp.dRK();
              break;
              localObject4 = e.pW(718);
              break label2257;
              localObject5 = localTimeLineObject.HAS.Id;
              break label2316;
              localObject4 = e.pW(743);
              break label2359;
              label2911:
              localObject5 = localTimeLineObject.HAS.Id;
              break label2418;
            }
          }
          localIntent.addFlags(536870912);
          if (localTimeLineObject.HAT.GaT != null)
          {
            i = localTimeLineObject.HAT.GaT.hCZ;
            if ((localTimeLineObject.HAT.GaT != null) && (i == 5) && (localTimeLineObject.HAT.GaT.hzj == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg()))
            {
              localObject2 = new x();
              ((x)localObject2).hDf = localIntent.getStringExtra("KPublisherId");
              ((x)localObject2).doX = localIntent.getStringExtra("sns_local_id");
              ((x)localObject2).doK = localIntent.getStringExtra("srcUsername");
              ((x)localObject2).hDe = localIntent.getStringExtra("srcDisplayname");
              ((x)localObject2).hDg.url = localIntent.getStringExtra("rawUrl");
              ((x)localObject2).hDg.title = localTimeLineObject.HAT.Title;
              ((x)localObject2).hDg.hDo = localTimeLineObject.HAT.GaT.desc;
              if (bt.isNullOrNil(localTimeLineObject.HAT.GaT.coverUrl)) {
                break label3742;
              }
              ((x)localObject2).hDg.hDm = localTimeLineObject.HAT.GaT.coverUrl;
              ((x)localObject2).hDg.type = i;
              ((x)localObject2).hDg.time = localTimeLineObject.HAT.GaT.hzi;
              ((x)localObject2).hDg.hDq = localTimeLineObject.HAT.GaT.duration;
              ((x)localObject2).hDg.videoWidth = localTimeLineObject.HAT.GaT.videoWidth;
              ((x)localObject2).hDg.videoHeight = localTimeLineObject.HAT.GaT.videoHeight;
              ((x)localObject2).hDg.hzm = localTimeLineObject.HAT.GaT.hzm;
              ((x)localObject2).hzl = localTimeLineObject.HAT.GaT.hzl;
              ((x)localObject2).t(localIntent);
              localIntent.putExtra(e.b.IUn, 2);
              localIntent.putExtra(e.b.IUo, j);
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
            if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(4)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(bo.this.context, (String)localObject3, i, 2, j, localIntent))) {
              break label3761;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
            label3437:
            localObject2 = null;
            j = 0;
            i = j;
            paramAnonymousView = (View)localObject2;
            if (localTimeLineObject != null)
            {
              i = j;
              paramAnonymousView = (View)localObject2;
              if (localTimeLineObject.HAS != null)
              {
                paramAnonymousView = localTimeLineObject.HAS.Id;
                i = bt.getInt(localTimeLineObject.HAS.Version, 0);
              }
            }
            localObject4 = com.tencent.mm.plugin.sns.c.a.iRH.u(paramAnonymousView, i);
            if (!bt.isNullOrNil((String)localObject4))
            {
              localObject3 = null;
              localObject2 = localObject3;
              if (localTimeLineObject != null)
              {
                localObject2 = localObject3;
                if (localTimeLineObject.znQ != null)
                {
                  localObject2 = localObject3;
                  if (localTimeLineObject.znQ.Fsy != null) {
                    localObject2 = localTimeLineObject.znQ.Fsy.Fss;
                  }
                }
              }
              if (localTimeLineObject != null) {
                break label3781;
              }
              localObject3 = null;
              label3567:
              com.tencent.mm.plugin.sns.c.a.iRH.a(bo.this.context, paramAnonymousView, (String)localObject4, (String)localObject3, 5, 4, 1, (String)localObject2, localTimeLineObject.Id);
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(11105, new Object[] { localTimeLineObject.nDo, localTimeLineObject.HAT.Url });
            if ((localp != null) && (localp.field_type == 4))
            {
              paramAnonymousView = (byn)localTimeLineObject.HAT.GaQ.get(0);
              localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
              if (paramAnonymousView != null) {
                break label3791;
              }
            }
          }
          for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.Desc)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject2).f(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.HAS.Id });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
            i = -1;
            break;
            ((x)localObject2).hDg.hDm = localIntent.getStringExtra("share_report_pre_msg_icon_url");
            break label3157;
            com.tencent.mm.plugin.sns.c.a.iRG.i(localIntent, bo.this.context);
            break label3437;
            localObject3 = localTimeLineObject.nDo;
            break label3567;
          }
        }
      }
    };
    this.ApX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99731);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof ag)))
        {
          localObject1 = ((ag)paramAnonymousView.getTag()).zQl;
          Object localObject2 = ((ag)paramAnonymousView.getTag()).zSQ;
          if ((localObject1 != null) && (((TimeLineObject)localObject1).HAT != null) && (((TimeLineObject)localObject1).HAT.GaW != null) && (localObject2 != null) && (((WeakReference)localObject2).get() != null))
          {
            localObject2 = (View)((WeakReference)localObject2).get();
            Rect localRect = new Rect();
            int[] arrayOfInt = new int[2];
            ((View)localObject2).getLocationOnScreen(arrayOfInt);
            int i = arrayOfInt[0];
            int j = arrayOfInt[1];
            int k = arrayOfInt[0];
            int m = ((View)localObject2).getMeasuredWidth();
            int n = arrayOfInt[1];
            localRect.set(i, j, k + m, ((View)localObject2).getMeasuredHeight() + n);
            com.tencent.mm.modelsns.d.a(paramAnonymousView.getContext(), ((TimeLineObject)localObject1).HAT.GaW, localRect);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99731);
      }
    };
    this.ApY = new bo.13(this);
    this.ApZ = new bo.14(this);
    this.Aqa = new bo.15(this);
    this.Aqb = new bo.16(this);
    this.Aqc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99738);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99738);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        if (((TimeLineObject)localObject1).HAT.GaQ.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((byn)((TimeLineObject)localObject1).HAT.GaQ.get(0)).zQh;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_Product_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99738);
      }
    };
    this.Aqd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99739);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99739);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        if (((TimeLineObject)localObject1).HAT.GaQ.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((byn)((TimeLineObject)localObject1).HAT.GaQ.get(0)).zQh;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_TV_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99739);
      }
    };
    this.Aqe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99740);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99740);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        if (((TimeLineObject)localObject1).HAT.GaQ.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((byn)((TimeLineObject)localObject1).HAT.GaQ.get(0)).zQh;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("preceding_scence", 10);
          ((Intent)localObject2).putExtra("download_entrance_scene", 13);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
      }
    };
    this.Aqf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99725);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99725);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        if (((TimeLineObject)localObject1).HAT.GaQ.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((byn)((TimeLineObject)localObject1).HAT.GaQ.get(0)).zQh;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99725);
      }
    };
    this.Aqg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        if (((TimeLineObject)localObject1).HAT.GaQ.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((byn)((TimeLineObject)localObject1).HAT.GaQ.get(0)).zQh;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99726);
      }
    };
    this.Aqh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        if (((TimeLineObject)localObject1).HAT.GaQ.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((byn)((TimeLineObject)localObject1).HAT.GaQ.get(0)).zQh;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99727);
      }
    };
    this.Aqi = new bo.5(this);
    this.Aqj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).zQl;
        localObject = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject).doX);
        if (bo.this.zPG != null) {
          bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        if (paramAnonymousView.HAZ == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        String str1 = paramAnonymousView.HAZ.username;
        String str2 = paramAnonymousView.HAZ.path;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        vm localvm = new vm();
        localvm.dJF.userName = str1;
        localvm.dJF.dJH = str2;
        localvm.dJF.scene = 1009;
        localvm.dJF.dkh = (paramAnonymousView.Id + ":" + paramAnonymousView.nDo);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject).field_userName);
        paramAnonymousView.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
        com.tencent.mm.sdk.b.a.IbL.l(localvm);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99729);
      }
    };
    this.Aqk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).zQl;
        localObject2 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject2).doX);
        if (bo.this.zPG != null) {
          bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
        }
        if (((TimeLineObject)localObject1).HAZ == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).jXR = 6;
        ((AppBrandLaunchReferrer)localObject2).dJW = ((TimeLineObject)localObject1).HAZ.dJW;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { ((AppBrandLaunchReferrer)localObject2).jXS });
        com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
        localf.username = ((TimeLineObject)localObject1).HAZ.username;
        localf.jCN = ((TimeLineObject)localObject1).HAZ.path;
        localf.hQh = ((TimeLineObject)localObject1).HAZ.DCU;
        localf.version = ((TimeLineObject)localObject1).HAZ.version;
        localf.jCY = ((TimeLineObject)localObject1).HAT.Title;
        localf.launchMode = 1;
        localf.scene = 1154;
        localf.dkh = ((TimeLineObject)localObject1).HAZ.HOB;
        localf.jCW = ((AppBrandLaunchReferrer)localObject2);
        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(paramAnonymousView.getContext(), localf);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99730);
      }
    };
    this.Aql = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179318);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179318);
          return;
        }
        paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
        if (paramAnonymousView.HAZ == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179318);
          return;
        }
        localObject = paramAnonymousView.HAZ.username;
        vm localvm = new vm();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(localObject)));
        localvm.dJF.userName = ((String)localObject);
        localvm.dJF.scene = 1009;
        localvm.dJF.dkh = (paramAnonymousView.Id + ":" + paramAnonymousView.nDo);
        com.tencent.mm.sdk.b.a.IbL.l(localvm);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179318);
      }
    };
    this.Aqm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198511);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198511);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).zQl;
        if (paramAnonymousView.HAT.GaQ.size() > 0)
        {
          localObject = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((byn)paramAnonymousView.HAT.GaQ.get(0)).zQh;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_scene", 2);
          ((Intent)localObject).putExtra("key_product_info", paramAnonymousView);
          com.tencent.mm.bs.d.b(bo.this.context, "product", ".ui.MallProductUI", (Intent)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198511);
      }
    };
    this.Aqn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198512);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198512);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).zQl;
        String[] arrayOfString;
        if (paramAnonymousView.HAT.GaQ.size() > 0)
        {
          localObject = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((s)localObject).doX);
          if (bo.this.zPG != null) {
            bo.this.zPG.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((byn)paramAnonymousView.HAT.GaQ.get(0)).zQh;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_from_scene", 12);
          if (TextUtils.isEmpty(paramAnonymousView)) {
            break label351;
          }
          arrayOfString = paramAnonymousView.split("#");
          if (arrayOfString.length < 2) {
            break label263;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
          com.tencent.mm.bs.d.b(bo.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198512);
          return;
          label263:
          if (arrayOfString.length == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramAnonymousView)));
            ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
            ((Intent)localObject).putExtra("key_card_ext", "");
            com.tencent.mm.bs.d.b(bo.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(paramAnonymousView)));
            continue;
            label351:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
          }
        }
      }
    };
    this.Aqo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198513);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        gw localgw;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          if (locals.zQl.HAT.GaP == 26)
          {
            if (bt.isNullOrNil(locals.zQl.HAT.GaS))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198513);
              return;
            }
            localgw = new gw();
            localgw.dsV.type = 37;
            localgw.dsV.desc = locals.zQl.HAT.GaS;
            localObject = "";
            paramAnonymousView = (View)localObject;
            if (locals.zQl.HAT.GaQ != null)
            {
              paramAnonymousView = (View)localObject;
              if (locals.zQl.HAT.GaQ.size() > 0)
              {
                paramAnonymousView = ao.jo(com.tencent.mm.plugin.sns.model.ag.getAccSnsPath(), ((byn)locals.zQl.HAT.GaQ.get(0)).Id);
                localObject = com.tencent.mm.plugin.sns.data.q.d((byn)locals.zQl.HAT.GaQ.get(0));
                if (!com.tencent.mm.vfs.i.fv(paramAnonymousView + (String)localObject)) {
                  break label335;
                }
              }
            }
          }
        }
        label335:
        for (paramAnonymousView = paramAnonymousView + (String)localObject;; paramAnonymousView = "")
        {
          localgw.dsV.path = paramAnonymousView;
          localgw.dsV.title = locals.doX;
          localgw.dsV.context = bo.this.context;
          com.tencent.mm.sdk.b.a.IbL.l(localgw);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198513);
          return;
        }
      }
    };
    this.context = paramContext;
    this.ApW = parama;
    this.dnh = paramInt;
    this.zPG = paramaf;
    AppMethodBeat.o(99741);
  }
  
  protected static String aAT(String paramString)
  {
    AppMethodBeat.i(99743);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.iRH.Q(paramString, "timeline");
    AppMethodBeat.o(99743);
    return paramString;
  }
  
  public static String aJ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(99744);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(99744);
      return "";
    }
    try
    {
      paramString1 = (String)bw.M(paramString1, paramString2).get(paramString3);
      AppMethodBeat.o(99744);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimeLineClickEvent", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(99744);
    }
    return "";
  }
  
  protected static boolean awP(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new me();
    ((me)localObject).dzC.action = -2;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((me)localObject).dzD.dzE;
    if ((localObject != null) && (com.tencent.mm.az.a.e((com.tencent.mm.az.f)localObject)) && (paramString.equals(((com.tencent.mm.az.f)localObject).ihg)) && (com.tencent.mm.az.a.aJG()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void dam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo
 * JD-Core Version:    0.7.0.1
 */