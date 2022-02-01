package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.ad.d.m;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.b;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  int dbL;
  long mxx;
  com.tencent.mm.ui.base.p tipDialog;
  public View.OnClickListener yQc;
  public View.OnClickListener yYA;
  private a yYl;
  public View.OnClickListener yYm;
  public View.OnClickListener yYn;
  public View.OnClickListener yYo;
  public View.OnClickListener yYp;
  public View.OnClickListener yYq;
  public View.OnClickListener yYr;
  public View.OnClickListener yYs;
  public View.OnClickListener yYt;
  public View.OnClickListener yYu;
  public View.OnClickListener yYv;
  public View.OnClickListener yYw;
  public View.OnClickListener yYx;
  public View.OnClickListener yYy;
  public View.OnClickListener yYz;
  ae yyv;
  
  public bl(Context paramContext, a parama, int paramInt, ae paramae)
  {
    AppMethodBeat.i(99741);
    this.dbL = 0;
    this.mxx = 0L;
    this.yQc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        long l = System.currentTimeMillis();
        if (l - bl.this.mxx < 500L)
        {
          AppMethodBeat.o(99724);
          return;
        }
        bl.this.mxx = l;
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
          localTimeLineObject = ((s)localObject4).yyZ;
          localp = af.dHR().auT(((s)localObject4).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D(localp);
          }
          Object localObject1;
          if (localTimeLineObject.FQo.Ety == 18)
          {
            paramAnonymousView = bl.this;
            localObject1 = bl.this.context;
            localObject3 = ((s)localObject4).yyZ;
            localObject4 = ((s)localObject4).ddB;
            localObject4 = af.dHR().auT((String)localObject4);
            m.a(m.b.xKD, m.a.xKv, (com.tencent.mm.plugin.sns.storage.p)localObject4, paramAnonymousView.dbL);
            localObject4 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject3).FQo.Etz.size() > 0) {
              paramAnonymousView = (btz)((TimeLineObject)localObject3).FQo.Etz.get(0);
            }
            ((Intent)localObject4).putExtra("KFromTimeLine", false);
            ((Intent)localObject4).putExtra("KStremVideoUrl", ((TimeLineObject)localObject3).FQo.Url);
            ((Intent)localObject4).putExtra("KSta_SourceType", 2);
            ((Intent)localObject4).putExtra("KSta_Scene", m.b.xKD.value);
            ((Intent)localObject4).putExtra("KSta_FromUserName", ((TimeLineObject)localObject3).ncR);
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
              paramAnonymousView = ((TimeLineObject)localObject3).FQt;
              if (paramAnonymousView != null)
              {
                ((Intent)localObject4).putExtra("KMediaVideoTime", paramAnonymousView.hjW);
                ((Intent)localObject4).putExtra("StreamWording", paramAnonymousView.hjY);
                ((Intent)localObject4).putExtra("StremWebUrl", paramAnonymousView.hjZ);
                ((Intent)localObject4).putExtra("KMediaTitle", paramAnonymousView.hjX);
                ((Intent)localObject4).putExtra("KStremVideoUrl", paramAnonymousView.hjV);
                ((Intent)localObject4).putExtra("KThumUrl", paramAnonymousView.hka);
                ((Intent)localObject4).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.hkb);
                ((Intent)localObject4).putExtra("KSta_StremVideoPublishId", paramAnonymousView.hkc);
              }
              ((Intent)localObject4).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject3).yAj);
              if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMG, 0) <= 0) {
                break label524;
              }
              com.tencent.mm.br.d.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject4);
              ac.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
              AppMethodBeat.o(99724);
              return;
              paramAnonymousView = paramAnonymousView.Id;
              break;
              ((Intent)localObject4).putExtra("KMediaId", paramAnonymousView.Id);
            }
            com.tencent.mm.br.d.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject4);
            AppMethodBeat.o(99724);
            return;
          }
          if ((localTimeLineObject.xXT != null) && (!bs.isNullOrNil(localTimeLineObject.xXT.BYK)))
          {
            localObject1 = bl.this;
            paramAnonymousView = localTimeLineObject.xXT;
            if ((paramAnonymousView != null) && (!bs.isNullOrNil(paramAnonymousView.BYK)))
            {
              localObject3 = com.tencent.mm.plugin.topstory.a.h.a(paramAnonymousView, 31, ab.aAv("discoverRecommendEntry").optString("wording"));
              z.a(((bl)localObject1).context, (dil)localObject3);
              localObject1 = localTimeLineObject.ncR;
              localObject4 = localTimeLineObject.Id;
              localObject3 = new StringBuffer();
              ((StringBuffer)localObject3).append("isShareClick=1");
              ((StringBuffer)localObject3).append("&relevant_vid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.BYK);
              ((StringBuffer)localObject3).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.BYM);
              ((StringBuffer)localObject3).append("&relevant_shared_openid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.BYN);
              ((StringBuffer)localObject3).append("&rec_category=");
              if (paramAnonymousView.BYW <= 0L) {
                break label888;
              }
              ((StringBuffer)localObject3).append(paramAnonymousView.BYW);
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
              ((StringBuffer)localObject3).append(paramAnonymousView.BYL);
              ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject3).toString() });
              paramAnonymousView = new cpk();
              paramAnonymousView.FCf = ((StringBuffer)localObject3).toString();
              paramAnonymousView = new v(paramAnonymousView);
              g.agi().a(paramAnonymousView, 0);
              AppMethodBeat.o(99724);
              return;
              ((StringBuffer)localObject3).append(paramAnonymousView.BYO);
            }
          }
          if (localTimeLineObject.FQo.Ety == 28)
          {
            l = com.tencent.mm.plugin.sns.data.q.atd(localTimeLineObject.FQo.EtD.objectId);
            if (l != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.ncR);
              paramAnonymousView.putExtra("feed_object_id", l);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.FQo.EtD.objectNonceId);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.ncR);
              paramAnonymousView.putExtra("tab_type", 5);
              ((com.tencent.mm.plugin.i.a.l)g.ad(com.tencent.mm.plugin.i.a.l.class)).enterFinderShareFeedUI(bl.this.context, paramAnonymousView);
              AppMethodBeat.o(99724);
              return;
            }
          }
          if ((localTimeLineObject.FQo.Ety == 29) && (localTimeLineObject.FQo.EtE != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.FQo.EtE.dol);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.FQo.EtE.rPI);
            localObject1 = new alt();
            ((alt)localObject1).EFm = localTimeLineObject.FQo.EtE.EGK.EFm;
            ((alt)localObject1).doB = localTimeLineObject.FQo.EtE.EGK.doB;
            ((alt)localObject1).dmL = localTimeLineObject.FQo.EtE.EGK.dmL;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((alt)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.ncR);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              ((com.tencent.mm.plugin.i.a.l)g.ad(com.tencent.mm.plugin.i.a.l.class)).enterFinderTopicUI(bl.this.context, paramAnonymousView);
              AppMethodBeat.o(99724);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ac.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
              }
            }
          }
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localTimeLineObject.yCb))
          {
            localObject2 = localObject3;
            if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localTimeLineObject.yCb))
            {
              localObject5 = bl.aC(localTimeLineObject.yCb, "adxml", ".adxml.adActionLink");
              localObject2 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject2 = bl.avM((String)localObject5);
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label3603;
          }
          localObject2 = bl.avM(localTimeLineObject.FQo.Url);
        }
        label2187:
        label2703:
        label3603:
        for (;;)
        {
          if ((localObject2 == null) || (((String)localObject2).length() == 0))
          {
            AppMethodBeat.o(99724);
            return;
          }
          int j = bl.this.yyv.getScene();
          localObject3 = localObject2;
          int i;
          if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tg((String)localObject2))
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
            ((Bundle)localObject2).putString("KSnsLocalId", ((s)localObject4).ddB);
            ((Bundle)localObject2).putBoolean("KFromTimeline", true);
            if ((localTimeLineObject.FQo != null) && (localTimeLineObject.FQo.Etz.size() > 0))
            {
              ((Bundle)localObject2).putString("K_sns_thumb_url", ((btz)localTimeLineObject.FQo.Etz.get(0)).Fjh);
              ((Bundle)localObject2).putString("K_sns_raw_url", localTimeLineObject.FQo.Url);
              ac.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((btz)localTimeLineObject.FQo.Etz.get(0)).Fjh, localTimeLineObject.FQo.Url });
            }
          }
          ((Bundle)localObject2).putString("key_snsad_statextstr", localTimeLineObject.yAj);
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("shortUrl", (String)localObject3);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          if (localTimeLineObject.FQp != null)
          {
            localIntent.putExtra("srcUsername", localTimeLineObject.FQp);
            localIntent.putExtra("srcDisplayname", localTimeLineObject.DpN);
            ac.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + localTimeLineObject.DpN + " tlObj.publicUserName: " + localTimeLineObject.FQp);
          }
          localIntent.putExtra("sns_local_id", ((s)localObject4).ddB);
          if (localp != null)
          {
            localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
            localIntent.putExtra("pre_username", localp.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
            localIntent.putExtra("preUsername", localp.field_userName);
            localIntent.putExtra("share_report_pre_msg_url", (String)localObject3);
            localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.FQo.Title);
            localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.FQo.Desc);
            if ((localTimeLineObject.FQo.Etz != null) && (localTimeLineObject.FQo.Etz.size() > 0)) {
              localIntent.putExtra("share_report_pre_msg_icon_url", ((btz)localTimeLineObject.FQo.Etz.get(0)).Fjh);
            }
            localIntent.putExtra("share_report_pre_msg_appid", "");
            localIntent.putExtra("share_report_from_scene", 1);
          }
          if ((localTimeLineObject != null) && (localTimeLineObject.FQn != null)) {
            localIntent.putExtra("KAppId", localTimeLineObject.FQn.Id);
          }
          if ((localp != null) && (localp.Pe(32)))
          {
            if (bl.this.dbL != 2) {
              break label2682;
            }
            localObject4 = localp.dLS();
            if (localObject4 != null) {
              localIntent.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject4).dyy);
            }
          }
          if ((localp != null) && (localTimeLineObject != null))
          {
            if (bl.this.dbL != 0) {
              break label2692;
            }
            localObject4 = com.tencent.mm.modelsns.d.ps(718);
            label2085:
            com.tencent.mm.modelsns.d locald = ((com.tencent.mm.modelsns.d)localObject4).Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn(localTimeLineObject.FQp);
            if (localTimeLineObject.FQn != null) {
              break label2703;
            }
            localObject5 = "";
            label2144:
            locald.Dn((String)localObject5).Dn(localTimeLineObject.FQo.Url);
            ((com.tencent.mm.modelsns.d)localObject4).aHZ();
            if (bl.this.dbL != 0) {
              break label2716;
            }
            localObject4 = com.tencent.mm.modelsns.d.ps(743);
            locald = ((com.tencent.mm.modelsns.d)localObject4).Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn(localTimeLineObject.FQp);
            if (localTimeLineObject.FQn != null) {
              break label2727;
            }
            localObject5 = "";
            label2246:
            locald.Dn((String)localObject5).Dn(localTimeLineObject.FQo.Url);
            if (localObject2 != null)
            {
              localObject4 = ((com.tencent.mm.modelsns.d)localObject4).aCd();
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
          if ((localTimeLineObject.FQo.EtC != null) && (localTimeLineObject.FQo.EtC.hkQ != -1)) {
            localIntent.putExtra(e.m.HhB, localTimeLineObject.FQo.EtC.hkQ);
          }
          if ((!bs.isNullOrNil(localTimeLineObject.yCb)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localTimeLineObject.yCb)) && (localp != null))
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
              localObject2 = localTimeLineObject.FQo.Etz;
              if (((List)localObject2).size() > 0) {
                paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((btz)((List)localObject2).get(0)).Fjh);
              }
            }
            paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
            paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dLV().Id);
            paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dMz());
            paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dMA());
            paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dMD());
            if (bl.this.dbL == 0) {}
            for (i = 3;; i = 4)
            {
              paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
              paramAnonymousView.setClass(bl.this.context, SnsAdNativeLandingPagesUI.class);
              paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.yCb);
              paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dMF());
              paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(paramAnonymousView, bl.this.context);
              AppMethodBeat.o(99724);
              return;
              label2682:
              localObject4 = localp.dFQ();
              break;
              localObject4 = com.tencent.mm.modelsns.d.pt(718);
              break label2085;
              localObject5 = localTimeLineObject.FQn.Id;
              break label2144;
              label2716:
              localObject4 = com.tencent.mm.modelsns.d.pt(743);
              break label2187;
              label2727:
              localObject5 = localTimeLineObject.FQn.Id;
              break label2246;
            }
          }
          localIntent.addFlags(536870912);
          if (localTimeLineObject.FQo.EtC != null)
          {
            i = localTimeLineObject.FQo.EtC.hkQ;
            if ((localTimeLineObject.FQo.EtC != null) && (i == 5) && (localTimeLineObject.FQo.EtC.hha == 1) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()))
            {
              localObject2 = new x();
              ((x)localObject2).hkW = localIntent.getStringExtra("KPublisherId");
              ((x)localObject2).ddB = localIntent.getStringExtra("sns_local_id");
              ((x)localObject2).ddo = localIntent.getStringExtra("srcUsername");
              ((x)localObject2).hkV = localIntent.getStringExtra("srcDisplayname");
              ((x)localObject2).hkX.url = localIntent.getStringExtra("rawUrl");
              ((x)localObject2).hkX.title = localTimeLineObject.FQo.Title;
              ((x)localObject2).hkX.hlf = localTimeLineObject.FQo.EtC.desc;
              if (bs.isNullOrNil(localTimeLineObject.FQo.EtC.coverUrl)) {
                break label3546;
              }
              ((x)localObject2).hkX.hld = localTimeLineObject.FQo.EtC.coverUrl;
              label2973:
              ((x)localObject2).hkX.type = i;
              ((x)localObject2).hkX.time = localTimeLineObject.FQo.EtC.hgZ;
              ((x)localObject2).hkX.hlh = localTimeLineObject.FQo.EtC.duration;
              ((x)localObject2).hkX.videoWidth = localTimeLineObject.FQo.EtC.videoWidth;
              ((x)localObject2).hkX.videoHeight = localTimeLineObject.FQo.EtC.videoHeight;
              ((x)localObject2).hkX.hhd = localTimeLineObject.FQo.EtC.hhd;
              ((x)localObject2).hhc = localTimeLineObject.FQo.EtC.hhc;
              ((x)localObject2).t(localIntent);
              localIntent.putExtra(e.b.HgX, 2);
              localIntent.putExtra(e.b.HgY, j);
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
            if ((!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(4)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(bl.this.context, (String)localObject3, i, 2, j, localIntent))) {
              break label3565;
            }
            ac.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
            label3253:
            localObject2 = null;
            j = 0;
            i = j;
            paramAnonymousView = (View)localObject2;
            if (localTimeLineObject != null)
            {
              i = j;
              paramAnonymousView = (View)localObject2;
              if (localTimeLineObject.FQn != null)
              {
                paramAnonymousView = localTimeLineObject.FQn.Id;
                i = bs.getInt(localTimeLineObject.FQn.Version, 0);
              }
            }
            localObject4 = com.tencent.mm.plugin.sns.c.a.iyy.s(paramAnonymousView, i);
            if (!bs.isNullOrNil((String)localObject4))
            {
              localObject3 = null;
              localObject2 = localObject3;
              if (localTimeLineObject != null)
              {
                localObject2 = localObject3;
                if (localTimeLineObject.xXR != null)
                {
                  localObject2 = localObject3;
                  if (localTimeLineObject.xXR.DNt != null) {
                    localObject2 = localTimeLineObject.xXR.DNt.DNn;
                  }
                }
              }
              if (localTimeLineObject != null) {
                break label3585;
              }
              localObject3 = null;
              label3383:
              com.tencent.mm.plugin.sns.c.a.iyy.a(bl.this.context, paramAnonymousView, (String)localObject4, (String)localObject3, 5, 4, 1, (String)localObject2, localTimeLineObject.Id);
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(11105, new Object[] { localTimeLineObject.ncR, localTimeLineObject.FQo.Url });
            if ((localp != null) && (localp.field_type == 4))
            {
              paramAnonymousView = (btz)localTimeLineObject.FQo.Etz.get(0);
              localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
              if (paramAnonymousView != null) {
                break label3595;
              }
            }
          }
          for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.Desc)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject2).f(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.FQn.Id });
            AppMethodBeat.o(99724);
            return;
            i = -1;
            break;
            label3546:
            ((x)localObject2).hkX.hld = localIntent.getStringExtra("share_report_pre_msg_icon_url");
            break label2973;
            label3565:
            com.tencent.mm.plugin.sns.c.a.iyx.i(localIntent, bl.this.context);
            break label3253;
            localObject3 = localTimeLineObject.ncR;
            break label3383;
          }
        }
      }
    };
    this.yYm = new bl.9(this);
    this.yYn = new bl.10(this);
    this.yYo = new View.OnClickListener()
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
        Object localObject1 = ((s)localObject2).yyZ;
        if (((TimeLineObject)localObject1).FQo.Etz.size() > 0)
        {
          localObject2 = af.dHR().auT(((s)localObject2).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((btz)((TimeLineObject)localObject1).FQo.Etz.get(0)).yyV;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_Product_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99735);
      }
    };
    this.yYp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99736);
        ac.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99736);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        Object localObject1 = ((s)localObject2).yyZ;
        if (((TimeLineObject)localObject1).FQo.Etz.size() > 0)
        {
          localObject2 = af.dHR().auT(((s)localObject2).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((btz)((TimeLineObject)localObject1).FQo.Etz.get(0)).yyV;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_TV_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99736);
      }
    };
    this.yYq = new View.OnClickListener()
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
        Object localObject1 = ((s)localObject2).yyZ;
        if (((TimeLineObject)localObject1).FQo.Etz.size() > 0)
        {
          localObject2 = af.dHR().auT(((s)localObject2).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((btz)((TimeLineObject)localObject1).FQo.Etz.get(0)).yyV;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("preceding_scence", 10);
          ((Intent)localObject2).putExtra("download_entrance_scene", 13);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99737);
      }
    };
    this.yYr = new View.OnClickListener()
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
        Object localObject1 = ((s)localObject2).yyZ;
        if (((TimeLineObject)localObject1).FQo.Etz.size() > 0)
        {
          localObject2 = af.dHR().auT(((s)localObject2).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((btz)((TimeLineObject)localObject1).FQo.Etz.get(0)).yyV;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99738);
      }
    };
    this.yYs = new View.OnClickListener()
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
        Object localObject1 = ((s)localObject2).yyZ;
        if (((TimeLineObject)localObject1).FQo.Etz.size() > 0)
        {
          localObject2 = af.dHR().auT(((s)localObject2).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((btz)((TimeLineObject)localObject1).FQo.Etz.get(0)).yyV;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99739);
      }
    };
    this.yYt = new View.OnClickListener()
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
        Object localObject1 = ((s)localObject2).yyZ;
        if (((TimeLineObject)localObject1).FQo.Etz.size() > 0)
        {
          localObject2 = af.dHR().auT(((s)localObject2).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((btz)((TimeLineObject)localObject1).FQo.Etz.get(0)).yyV;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
        }
        AppMethodBeat.o(99740);
      }
    };
    this.yYu = new bl.2(this);
    this.yYv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        ac.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).yyZ;
        localObject = af.dHR().auT(((s)localObject).ddB);
        if (bl.this.yyv != null) {
          bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        if (paramAnonymousView.FQu == null)
        {
          ac.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          AppMethodBeat.o(99726);
          return;
        }
        String str1 = paramAnonymousView.FQu.username;
        String str2 = paramAnonymousView.FQu.path;
        ac.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        ut localut = new ut();
        localut.dxt.userName = str1;
        localut.dxt.dxv = str2;
        localut.dxt.scene = 1009;
        localut.dxt.cYP = (paramAnonymousView.Id + ":" + paramAnonymousView.ncR);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject).field_userName);
        paramAnonymousView.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
        com.tencent.mm.sdk.b.a.GpY.l(localut);
        AppMethodBeat.o(99726);
      }
    };
    this.yYw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        ac.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        TimeLineObject localTimeLineObject = ((s)localObject).yyZ;
        localObject = af.dHR().auT(((s)localObject).ddB);
        if (bl.this.yyv != null) {
          bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        if (localTimeLineObject.FQu == null)
        {
          ac.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          AppMethodBeat.o(99727);
          return;
        }
        localObject = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject).jDQ = 6;
        ((AppBrandLaunchReferrer)localObject).dxK = localTimeLineObject.FQu.dxK;
        ac.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { ((AppBrandLaunchReferrer)localObject).jDR });
        com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
        localf.username = localTimeLineObject.FQu.username;
        localf.jjf = localTimeLineObject.FQu.path;
        localf.hxM = localTimeLineObject.FQu.BZZ;
        localf.version = localTimeLineObject.FQu.version;
        localf.jjq = localTimeLineObject.FQo.Title;
        localf.launchMode = 1;
        localf.scene = 1154;
        localf.cYP = localTimeLineObject.FQu.Gdv;
        localf.jjo = ((AppBrandLaunchReferrer)localObject);
        ((n)g.ab(n.class)).a(paramAnonymousView.getContext(), localf);
        AppMethodBeat.o(99727);
      }
    };
    this.yYx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99728);
        ac.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          AppMethodBeat.o(99728);
          return;
        }
        paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
        if (paramAnonymousView.FQu == null)
        {
          ac.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          AppMethodBeat.o(99728);
          return;
        }
        String str = paramAnonymousView.FQu.username;
        ut localut = new ut();
        ac.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(str)));
        localut.dxt.userName = str;
        localut.dxt.scene = 1009;
        localut.dxt.cYP = (paramAnonymousView.Id + ":" + paramAnonymousView.ncR);
        com.tencent.mm.sdk.b.a.GpY.l(localut);
        AppMethodBeat.o(99728);
      }
    };
    this.yYy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        ac.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99729);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).yyZ;
        if (paramAnonymousView.FQo.Etz.size() > 0)
        {
          localObject = af.dHR().auT(((s)localObject).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((btz)paramAnonymousView.FQo.Etz.get(0)).yyV;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_scene", 2);
          ((Intent)localObject).putExtra("key_product_info", paramAnonymousView);
          com.tencent.mm.br.d.b(bl.this.context, "product", ".ui.MallProductUI", (Intent)localObject);
        }
        AppMethodBeat.o(99729);
      }
    };
    this.yYz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).yyZ;
        if (paramAnonymousView.FQo.Etz.size() > 0)
        {
          localObject = af.dHR().auT(((s)localObject).ddB);
          if (bl.this.yyv != null) {
            bl.this.yyv.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((btz)paramAnonymousView.FQo.Etz.get(0)).yyV;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_from_scene", 12);
          if (!TextUtils.isEmpty(paramAnonymousView))
          {
            String[] arrayOfString = paramAnonymousView.split("#");
            if (arrayOfString.length >= 2)
            {
              ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
              ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
              ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
              com.tencent.mm.br.d.b(bl.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
              AppMethodBeat.o(99730);
              return;
            }
            if (arrayOfString.length == 1)
            {
              ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
              ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramAnonymousView)));
              ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
              ((Intent)localObject).putExtra("key_card_ext", "");
              com.tencent.mm.br.d.b(bl.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
              AppMethodBeat.o(99730);
              return;
            }
            ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
            ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(paramAnonymousView)));
            AppMethodBeat.o(99730);
            return;
          }
          ac.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
        }
        AppMethodBeat.o(99730);
      }
    };
    this.yYA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179318);
        ac.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        gt localgt;
        String str;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          if (locals.yyZ.FQo.Ety == 26)
          {
            if (bs.isNullOrNil(locals.yyZ.FQo.EtB))
            {
              AppMethodBeat.o(179318);
              return;
            }
            localgt = new gt();
            localgt.dhx.type = 37;
            localgt.dhx.desc = locals.yyZ.FQo.EtB;
            str = "";
            paramAnonymousView = str;
            if (locals.yyZ.FQo.Etz != null)
            {
              paramAnonymousView = str;
              if (locals.yyZ.FQo.Etz.size() > 0)
              {
                paramAnonymousView = an.jc(af.getAccSnsPath(), ((btz)locals.yyZ.FQo.Etz.get(0)).Id);
                str = com.tencent.mm.plugin.sns.data.q.d((btz)locals.yyZ.FQo.Etz.get(0));
                if (!com.tencent.mm.vfs.i.eA(paramAnonymousView + str)) {
                  break label282;
                }
              }
            }
          }
        }
        label282:
        for (paramAnonymousView = paramAnonymousView + str;; paramAnonymousView = "")
        {
          localgt.dhx.path = paramAnonymousView;
          localgt.dhx.title = locals.ddB;
          localgt.dhx.context = bl.this.context;
          com.tencent.mm.sdk.b.a.GpY.l(localgt);
          AppMethodBeat.o(179318);
          return;
        }
      }
    };
    this.context = paramContext;
    this.yYl = parama;
    this.dbL = paramInt;
    this.yyv = paramae;
    AppMethodBeat.o(99741);
  }
  
  public static String aC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(99744);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(99744);
      return "";
    }
    try
    {
      paramString1 = (String)bv.L(paramString1, paramString2).get(paramString3);
      AppMethodBeat.o(99744);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.TimeLineClickEvent", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(99744);
    }
    return "";
  }
  
  protected static boolean arO(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new lv();
    ((lv)localObject).dnO.action = -2;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((lv)localObject).dnP.dnQ;
    if ((localObject != null) && (com.tencent.mm.ay.a.e((com.tencent.mm.ay.f)localObject)) && (paramString.equals(((com.tencent.mm.ay.f)localObject).hNS)) && (com.tencent.mm.ay.a.aGv()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  protected static String avM(String paramString)
  {
    AppMethodBeat.i(99743);
    ac.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.iyy.P(paramString, "timeline");
    AppMethodBeat.o(99743);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void cRC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl
 * JD-Core Version:    0.7.0.1
 */