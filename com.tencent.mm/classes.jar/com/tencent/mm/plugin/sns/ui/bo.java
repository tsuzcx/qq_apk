package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.ad.e.n;
import com.tencent.mm.plugin.sns.ad.e.n.a;
import com.tencent.mm.plugin.sns.ad.e.n.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public final class bo
{
  public View.OnClickListener AHA;
  public View.OnClickListener AHB;
  public View.OnClickListener AHC;
  private a AHk;
  public View.OnClickListener AHl;
  public View.OnClickListener AHm;
  public View.OnClickListener AHn;
  public View.OnClickListener AHo;
  public View.OnClickListener AHp;
  public View.OnClickListener AHq;
  public View.OnClickListener AHr;
  public View.OnClickListener AHs;
  public View.OnClickListener AHt;
  public View.OnClickListener AHu;
  public View.OnClickListener AHv;
  public View.OnClickListener AHw;
  public View.OnClickListener AHx;
  public View.OnClickListener AHy;
  public View.OnClickListener AHz;
  com.tencent.mm.plugin.sns.model.ag AgN;
  public View.OnClickListener AyK;
  Context context;
  int doj;
  long ndi;
  com.tencent.mm.ui.base.p tipDialog;
  
  public bo(Context paramContext, a parama, int paramInt, com.tencent.mm.plugin.sns.model.ag paramag)
  {
    AppMethodBeat.i(99741);
    this.doj = 0;
    this.ndi = 0L;
    this.AyK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        long l = System.currentTimeMillis();
        if (l - bo.this.ndi < 500L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
        }
        bo.this.ndi = l;
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
          localTimeLineObject = ((s)localObject4).Ahs;
          localp = ah.dXE().aBr(((s)localObject4).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F(localp);
          }
          if (localTimeLineObject.HUG.Gtw == 18)
          {
            paramAnonymousView = bo.this;
            localObject1 = bo.this.context;
            localObject3 = ((s)localObject4).Ahs;
            localObject4 = ((s)localObject4).dqc;
            localObject4 = ah.dXE().aBr((String)localObject4);
            n.a(n.b.zqt, n.a.zql, (com.tencent.mm.plugin.sns.storage.p)localObject4, paramAnonymousView.doj);
            localObject4 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject3).HUG.Gtx.size() > 0) {
              paramAnonymousView = (bzh)((TimeLineObject)localObject3).HUG.Gtx.get(0);
            }
            ((Intent)localObject4).putExtra("KFromTimeLine", false);
            ((Intent)localObject4).putExtra("KStremVideoUrl", ((TimeLineObject)localObject3).HUG.Url);
            ((Intent)localObject4).putExtra("KSta_SourceType", 2);
            ((Intent)localObject4).putExtra("KSta_Scene", n.b.zqt.value);
            ((Intent)localObject4).putExtra("KSta_FromUserName", ((TimeLineObject)localObject3).nIJ);
            ((Intent)localObject4).putExtra("KSta_SnSId", ((TimeLineObject)localObject3).Id);
            if (paramAnonymousView == null)
            {
              localObject5 = new StringBuilder("fakeid_");
              if (paramAnonymousView == null)
              {
                paramAnonymousView = ((TimeLineObject)localObject3).Id;
                ((Intent)localObject4).putExtra("KMediaId", paramAnonymousView);
                paramAnonymousView = ((TimeLineObject)localObject3).HUL;
                if (paramAnonymousView != null)
                {
                  ((Intent)localObject4).putExtra("KMediaVideoTime", paramAnonymousView.hEU);
                  ((Intent)localObject4).putExtra("StreamWording", paramAnonymousView.hEW);
                  ((Intent)localObject4).putExtra("StremWebUrl", paramAnonymousView.hEX);
                  ((Intent)localObject4).putExtra("KMediaTitle", paramAnonymousView.hEV);
                  ((Intent)localObject4).putExtra("KStremVideoUrl", paramAnonymousView.hET);
                  ((Intent)localObject4).putExtra("KThumUrl", paramAnonymousView.hEY);
                  ((Intent)localObject4).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.hEZ);
                  ((Intent)localObject4).putExtra("KSta_StremVideoPublishId", paramAnonymousView.hFa);
                }
                ((Intent)localObject4).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject3).AiG);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxf, 0) <= 0) {
                  break label584;
                }
                com.tencent.mm.br.d.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject4);
                ae.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
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
              com.tencent.mm.br.d.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject4);
            }
          }
          if ((localTimeLineObject.zFh != null) && (!bu.isNullOrNil(localTimeLineObject.zFh.DTD)))
          {
            localObject1 = bo.this;
            paramAnonymousView = localTimeLineObject.zFh;
            if ((paramAnonymousView != null) && (!bu.isNullOrNil(paramAnonymousView.DTD)))
            {
              localObject3 = h.a(paramAnonymousView, 31, af.aHj("discoverRecommendEntry").optString("wording"));
              ad.a(((bo)localObject1).context, (dox)localObject3);
              localObject1 = localTimeLineObject.nIJ;
              localObject4 = localTimeLineObject.Id;
              localObject3 = new StringBuffer();
              ((StringBuffer)localObject3).append("isShareClick=1");
              ((StringBuffer)localObject3).append("&relevant_vid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.DTD);
              ((StringBuffer)localObject3).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.DTF);
              ((StringBuffer)localObject3).append("&relevant_shared_openid=");
              ((StringBuffer)localObject3).append(paramAnonymousView.DTG);
              ((StringBuffer)localObject3).append("&rec_category=");
              if (paramAnonymousView.DTP <= 0L) {
                break label957;
              }
              ((StringBuffer)localObject3).append(paramAnonymousView.DTP);
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
              ((StringBuffer)localObject3).append(paramAnonymousView.DTE);
              ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject3).toString() });
              paramAnonymousView = new cvj();
              paramAnonymousView.HFU = ((StringBuffer)localObject3).toString();
              paramAnonymousView = new z(paramAnonymousView);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousView, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              label957:
              ((StringBuffer)localObject3).append(paramAnonymousView.DTH);
            }
          }
          if (localTimeLineObject.HUG.Gtw == 28)
          {
            l = r.azz(localTimeLineObject.HUG.GtB.objectId);
            if (l != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.nIJ);
              paramAnonymousView.putExtra("feed_object_id", l);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.HUG.GtB.objectNonceId);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.nIJ);
              paramAnonymousView.putExtra("tab_type", 5);
              ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(4, 2, 25, paramAnonymousView);
              ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderShareFeedUI(bo.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
          }
          if ((localTimeLineObject.HUG.Gtw == 29) && (localTimeLineObject.HUG.GtC != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.HUG.GtC.dBe);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.HUG.GtC.sXu);
            localObject1 = new apl();
            ((apl)localObject1).GGA = localTimeLineObject.HUG.GtC.GIz.GGA;
            ((apl)localObject1).dBu = localTimeLineObject.HUG.GtC.GIz.dBu;
            ((apl)localObject1).dzE = localTimeLineObject.HUG.GtC.GIz.dzE;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((apl)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.nIJ);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              if (localTimeLineObject.HUG.GtC.sXu == 1)
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
                ae.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                continue;
                i = 26;
              }
            }
          }
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localTimeLineObject.AkC))
          {
            localObject2 = localObject3;
            if (!i.aBm(localTimeLineObject.AkC))
            {
              localObject5 = bo.aJ(localTimeLineObject.AkC, "adxml", ".adxml.adActionLink");
              localObject2 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject2 = bo.aCk((String)localObject5);
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label3799;
          }
          localObject2 = bo.aCk(localTimeLineObject.HUG.Url);
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
          int j = bo.this.AgN.getScene();
          localObject3 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy((String)localObject2))
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
            ((Bundle)localObject2).putString("KSnsLocalId", ((s)localObject4).dqc);
            ((Bundle)localObject2).putBoolean("KFromTimeline", true);
            if ((localTimeLineObject.HUG != null) && (localTimeLineObject.HUG.Gtx.size() > 0))
            {
              ((Bundle)localObject2).putString("K_sns_thumb_url", ((bzh)localTimeLineObject.HUG.Gtx.get(0)).Hmj);
              ((Bundle)localObject2).putString("K_sns_raw_url", localTimeLineObject.HUG.Url);
              ae.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((bzh)localTimeLineObject.HUG.Gtx.get(0)).Hmj, localTimeLineObject.HUG.Url });
            }
          }
          ((Bundle)localObject2).putString("key_snsad_statextstr", localTimeLineObject.AiG);
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("shortUrl", (String)localObject3);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("type", -255);
          if (localTimeLineObject.HUH != null)
          {
            localIntent.putExtra("srcUsername", localTimeLineObject.HUH);
            localIntent.putExtra("srcDisplayname", localTimeLineObject.Fnm);
            ae.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + localTimeLineObject.Fnm + " tlObj.publicUserName: " + localTimeLineObject.HUH);
          }
          localIntent.putExtra("sns_local_id", ((s)localObject4).dqc);
          if (localp != null)
          {
            localIntent.putExtra("KPublisherId", "sns_" + r.zV(localp.field_snsId));
            localIntent.putExtra("pre_username", localp.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + r.zV(localp.field_snsId));
            localIntent.putExtra("preUsername", localp.field_userName);
            localIntent.putExtra("share_report_pre_msg_url", (String)localObject3);
            localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.HUG.Title);
            localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.HUG.Desc);
            if ((localTimeLineObject.HUG.Gtx != null) && (localTimeLineObject.HUG.Gtx.size() > 0)) {
              localIntent.putExtra("share_report_pre_msg_icon_url", ((bzh)localTimeLineObject.HUG.Gtx.get(0)).Hmj);
            }
            localIntent.putExtra("share_report_pre_msg_appid", "");
            localIntent.putExtra("share_report_from_scene", 1);
          }
          if ((localTimeLineObject != null) && (localTimeLineObject.HUF != null)) {
            localIntent.putExtra("KAppId", localTimeLineObject.HUF.Id);
          }
          if ((localp != null) && (localp.Rt(32)))
          {
            if (bo.this.doj != 2) {
              break label2866;
            }
            localObject4 = localp.ebM();
            if (localObject4 != null) {
              localIntent.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject4).aQj);
            }
          }
          if ((localp != null) && (localTimeLineObject != null))
          {
            if (bo.this.doj != 0) {
              break label2876;
            }
            localObject4 = e.pY(718);
            e locale = ((e)localObject4).GU(r.o(localp)).qb(localp.field_type).eV(localp.Rt(32)).GU(localp.ecx()).GU(localTimeLineObject.HUH);
            if (localTimeLineObject.HUF != null) {
              break label2887;
            }
            localObject5 = "";
            locale.GU((String)localObject5).GU(localTimeLineObject.HUG.Url);
            ((e)localObject4).aLH();
            if (bo.this.doj != 0) {
              break label2900;
            }
            localObject4 = e.pY(743);
            locale = ((e)localObject4).GU(r.o(localp)).qb(localp.field_type).eV(localp.Rt(32)).GU(localp.ecx()).GU(localTimeLineObject.HUH);
            if (localTimeLineObject.HUF != null) {
              break label2911;
            }
            localObject5 = "";
            label2418:
            locale.GU((String)localObject5).GU(localTimeLineObject.HUG.Url);
            if (localObject2 != null)
            {
              localObject4 = ((e)localObject4).aFw();
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
          if ((localTimeLineObject.HUG.GtA != null) && (localTimeLineObject.HUG.GtA.hFR != -1)) {
            localIntent.putExtra(e.m.Jpz, localTimeLineObject.HUG.GtA.hFR);
          }
          if ((!bu.isNullOrNil(localTimeLineObject.AkC)) && (i.aBm(localTimeLineObject.AkC)) && (localp != null))
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
              localObject2 = localTimeLineObject.HUG.Gtx;
              if (((List)localObject2).size() > 0) {
                paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bzh)((List)localObject2).get(0)).Hmj);
              }
            }
            paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
            paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.ebP().Id);
            paramAnonymousView.putExtra("sns_landing_pages_aid", localp.ect());
            paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.ecu());
            paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.ecx());
            if (bo.this.doj == 0) {}
            for (i = 3;; i = 4)
            {
              paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
              paramAnonymousView.setClass(bo.this.context, SnsAdNativeLandingPagesUI.class);
              paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.AkC);
              paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.ecz());
              paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              i.z(paramAnonymousView, bo.this.context);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              localObject4 = localp.dVi();
              break;
              localObject4 = e.pZ(718);
              break label2257;
              localObject5 = localTimeLineObject.HUF.Id;
              break label2316;
              localObject4 = e.pZ(743);
              break label2359;
              label2911:
              localObject5 = localTimeLineObject.HUF.Id;
              break label2418;
            }
          }
          localIntent.addFlags(536870912);
          if (localTimeLineObject.HUG.GtA != null)
          {
            i = localTimeLineObject.HUG.GtA.hFR;
            if ((localTimeLineObject.HUG.GtA != null) && (i == 5) && (localTimeLineObject.HUG.GtA.hBX == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()))
            {
              localObject2 = new x();
              ((x)localObject2).hFX = localIntent.getStringExtra("KPublisherId");
              ((x)localObject2).dqc = localIntent.getStringExtra("sns_local_id");
              ((x)localObject2).dpP = localIntent.getStringExtra("srcUsername");
              ((x)localObject2).hFW = localIntent.getStringExtra("srcDisplayname");
              ((x)localObject2).hFY.url = localIntent.getStringExtra("rawUrl");
              ((x)localObject2).hFY.title = localTimeLineObject.HUG.Title;
              ((x)localObject2).hFY.hGg = localTimeLineObject.HUG.GtA.desc;
              if (bu.isNullOrNil(localTimeLineObject.HUG.GtA.coverUrl)) {
                break label3742;
              }
              ((x)localObject2).hFY.hGe = localTimeLineObject.HUG.GtA.coverUrl;
              ((x)localObject2).hFY.type = i;
              ((x)localObject2).hFY.time = localTimeLineObject.HUG.GtA.hBW;
              ((x)localObject2).hFY.hGi = localTimeLineObject.HUG.GtA.duration;
              ((x)localObject2).hFY.videoWidth = localTimeLineObject.HUG.GtA.videoWidth;
              ((x)localObject2).hFY.videoHeight = localTimeLineObject.HUG.GtA.videoHeight;
              ((x)localObject2).hFY.hCa = localTimeLineObject.HUG.GtA.hCa;
              ((x)localObject2).hBZ = localTimeLineObject.HUG.GtA.hBZ;
              ((x)localObject2).t(localIntent);
              localIntent.putExtra(e.b.JoV, 2);
              localIntent.putExtra(e.b.JoW, j);
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
            if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(4)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(bo.this.context, (String)localObject3, i, 2, j, localIntent))) {
              break label3761;
            }
            ae.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
            label3437:
            localObject2 = null;
            j = 0;
            i = j;
            paramAnonymousView = (View)localObject2;
            if (localTimeLineObject != null)
            {
              i = j;
              paramAnonymousView = (View)localObject2;
              if (localTimeLineObject.HUF != null)
              {
                paramAnonymousView = localTimeLineObject.HUF.Id;
                i = bu.getInt(localTimeLineObject.HUF.Version, 0);
              }
            }
            localObject4 = com.tencent.mm.plugin.sns.c.a.iUA.v(paramAnonymousView, i);
            if (!bu.isNullOrNil((String)localObject4))
            {
              localObject3 = null;
              localObject2 = localObject3;
              if (localTimeLineObject != null)
              {
                localObject2 = localObject3;
                if (localTimeLineObject.zFf != null)
                {
                  localObject2 = localObject3;
                  if (localTimeLineObject.zFf.FKW != null) {
                    localObject2 = localTimeLineObject.zFf.FKW.FKQ;
                  }
                }
              }
              if (localTimeLineObject != null) {
                break label3781;
              }
              localObject3 = null;
              label3567:
              com.tencent.mm.plugin.sns.c.a.iUA.a(bo.this.context, paramAnonymousView, (String)localObject4, (String)localObject3, 5, 4, 1, (String)localObject2, localTimeLineObject.Id);
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(11105, new Object[] { localTimeLineObject.nIJ, localTimeLineObject.HUG.Url });
            if ((localp != null) && (localp.field_type == 4))
            {
              paramAnonymousView = (bzh)localTimeLineObject.HUG.Gtx.get(0);
              localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
              if (paramAnonymousView != null) {
                break label3791;
              }
            }
          }
          for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.Desc)
          {
            ((com.tencent.mm.plugin.report.service.g)localObject2).f(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.HUF.Id });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
            i = -1;
            break;
            ((x)localObject2).hFY.hGe = localIntent.getStringExtra("share_report_pre_msg_icon_url");
            break label3157;
            com.tencent.mm.plugin.sns.c.a.iUz.i(localIntent, bo.this.context);
            break label3437;
            localObject3 = localTimeLineObject.nIJ;
            break label3567;
          }
        }
      }
    };
    this.AHl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99731);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof ag)))
        {
          localObject1 = ((ag)paramAnonymousView.getTag()).Ahs;
          Object localObject2 = ((ag)paramAnonymousView.getTag()).AjX;
          if ((localObject1 != null) && (((TimeLineObject)localObject1).HUG != null) && (((TimeLineObject)localObject1).HUG.GtD != null) && (localObject2 != null) && (((WeakReference)localObject2).get() != null))
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
            com.tencent.mm.modelsns.d.a(paramAnonymousView.getContext(), ((TimeLineObject)localObject1).HUG.GtD, localRect);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99731);
      }
    };
    this.AHm = new bo.13(this);
    this.AHn = new bo.14(this);
    this.AHo = new bo.15(this);
    this.AHp = new bo.16(this);
    this.AHq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99738);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99738);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        if (((TimeLineObject)localObject1).HUG.Gtx.size() > 0)
        {
          localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bzh)((TimeLineObject)localObject1).HUG.Gtx.get(0)).Aho;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_Product_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99738);
      }
    };
    this.AHr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99739);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        ae.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99739);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        if (((TimeLineObject)localObject1).HUG.Gtx.size() > 0)
        {
          localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bzh)((TimeLineObject)localObject1).HUG.Gtx.get(0)).Aho;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_TV_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99739);
      }
    };
    this.AHs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99740);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99740);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        if (((TimeLineObject)localObject1).HUG.Gtx.size() > 0)
        {
          localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bzh)((TimeLineObject)localObject1).HUG.Gtx.get(0)).Aho;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("preceding_scence", 10);
          ((Intent)localObject2).putExtra("download_entrance_scene", 13);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
      }
    };
    this.AHt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99725);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99725);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        if (((TimeLineObject)localObject1).HUG.Gtx.size() > 0)
        {
          localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bzh)((TimeLineObject)localObject1).HUG.Gtx.get(0)).Aho;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99725);
      }
    };
    this.AHu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        if (((TimeLineObject)localObject1).HUG.Gtx.size() > 0)
        {
          localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bzh)((TimeLineObject)localObject1).HUG.Gtx.get(0)).Aho;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99726);
      }
    };
    this.AHv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        if (((TimeLineObject)localObject1).HUG.Gtx.size() > 0)
        {
          localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
          }
          localObject1 = ((bzh)((TimeLineObject)localObject1).HUG.Gtx.get(0)).Aho;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99727);
      }
    };
    this.AHw = new bo.5(this);
    this.AHx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).Ahs;
        localObject = ah.dXE().aBr(((s)localObject).dqc);
        if (bo.this.AgN != null) {
          bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject);
        }
        if (paramAnonymousView.HUM == null)
        {
          ae.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        String str1 = paramAnonymousView.HUM.username;
        String str2 = paramAnonymousView.HUM.path;
        ae.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        vq localvq = new vq();
        localvq.dKT.userName = str1;
        localvq.dKT.dKV = str2;
        localvq.dKT.scene = 1009;
        localvq.dKT.dlj = (paramAnonymousView.Id + ":" + paramAnonymousView.nIJ);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject).field_userName);
        paramAnonymousView.putString("stat_msg_id", "sns_" + r.zV(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
        com.tencent.mm.sdk.b.a.IvT.l(localvq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99729);
      }
    };
    this.AHy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        ae.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).Ahs;
        localObject2 = ah.dXE().aBr(((s)localObject2).dqc);
        if (bo.this.AgN != null) {
          bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject2);
        }
        if (((TimeLineObject)localObject1).HUM == null)
        {
          ae.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        localObject2 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject2).kbg = 6;
        ((AppBrandLaunchReferrer)localObject2).dLl = ((TimeLineObject)localObject1).HUM.dLl;
        ae.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { ((AppBrandLaunchReferrer)localObject2).kbh });
        com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
        localf.username = ((TimeLineObject)localObject1).HUM.username;
        localf.jFL = ((TimeLineObject)localObject1).HUM.path;
        localf.hSZ = ((TimeLineObject)localObject1).HUM.DUS;
        localf.version = ((TimeLineObject)localObject1).HUM.version;
        localf.jFW = ((TimeLineObject)localObject1).HUG.Title;
        localf.launchMode = 1;
        localf.scene = 1154;
        localf.dlj = ((TimeLineObject)localObject1).HUM.IiI;
        localf.jFU = ((AppBrandLaunchReferrer)localObject2);
        ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(paramAnonymousView.getContext(), localf);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99730);
      }
    };
    this.AHz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179318);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179318);
          return;
        }
        paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
        if (paramAnonymousView.HUM == null)
        {
          ae.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179318);
          return;
        }
        localObject = paramAnonymousView.HUM.username;
        vq localvq = new vq();
        ae.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(localObject)));
        localvq.dKT.userName = ((String)localObject);
        localvq.dKT.scene = 1009;
        localvq.dKT.dlj = (paramAnonymousView.Id + ":" + paramAnonymousView.nIJ);
        com.tencent.mm.sdk.b.a.IvT.l(localvq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179318);
      }
    };
    this.AHA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220053);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220053);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).Ahs;
        if (paramAnonymousView.HUG.Gtx.size() > 0)
        {
          localObject = ah.dXE().aBr(((s)localObject).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((bzh)paramAnonymousView.HUG.Gtx.get(0)).Aho;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_scene", 2);
          ((Intent)localObject).putExtra("key_product_info", paramAnonymousView);
          com.tencent.mm.br.d.b(bo.this.context, "product", ".ui.MallProductUI", (Intent)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220053);
      }
    };
    this.AHB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220054);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220054);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).Ahs;
        String[] arrayOfString;
        if (paramAnonymousView.HUG.Gtx.size() > 0)
        {
          localObject = ah.dXE().aBr(((s)localObject).dqc);
          if (bo.this.AgN != null) {
            bo.this.AgN.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject);
          }
          paramAnonymousView = ((bzh)paramAnonymousView.HUG.Gtx.get(0)).Aho;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_from_scene", 12);
          if (TextUtils.isEmpty(paramAnonymousView)) {
            break label351;
          }
          arrayOfString = paramAnonymousView.split("#");
          if (arrayOfString.length < 2) {
            break label263;
          }
          ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
          com.tencent.mm.br.d.b(bo.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220054);
          return;
          label263:
          if (arrayOfString.length == 1)
          {
            ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
            ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramAnonymousView)));
            ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
            ((Intent)localObject).putExtra("key_card_ext", "");
            com.tencent.mm.br.d.b(bo.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
          }
          else
          {
            ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
            ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(paramAnonymousView)));
            continue;
            label351:
            ae.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
          }
        }
      }
    };
    this.AHC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220055);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        gx localgx;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          if (locals.Ahs.HUG.Gtw == 26)
          {
            if (bu.isNullOrNil(locals.Ahs.HUG.Gtz))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(220055);
              return;
            }
            localgx = new gx();
            localgx.dub.type = 37;
            localgx.dub.desc = locals.Ahs.HUG.Gtz;
            localObject = "";
            paramAnonymousView = (View)localObject;
            if (locals.Ahs.HUG.Gtx != null)
            {
              paramAnonymousView = (View)localObject;
              if (locals.Ahs.HUG.Gtx.size() > 0)
              {
                paramAnonymousView = ap.jv(ah.getAccSnsPath(), ((bzh)locals.Ahs.HUG.Gtx.get(0)).Id);
                localObject = r.d((bzh)locals.Ahs.HUG.Gtx.get(0));
                if (!o.fB(paramAnonymousView + (String)localObject)) {
                  break label335;
                }
              }
            }
          }
        }
        label335:
        for (paramAnonymousView = paramAnonymousView + (String)localObject;; paramAnonymousView = "")
        {
          localgx.dub.path = paramAnonymousView;
          localgx.dub.title = locals.dqc;
          localgx.dub.context = bo.this.context;
          com.tencent.mm.sdk.b.a.IvT.l(localgx);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220055);
          return;
        }
      }
    };
    this.context = paramContext;
    this.AHk = parama;
    this.doj = paramInt;
    this.AgN = paramag;
    AppMethodBeat.o(99741);
  }
  
  protected static String aCk(String paramString)
  {
    AppMethodBeat.i(99743);
    ae.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.iUA.Q(paramString, "timeline");
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
      paramString1 = (String)bx.M(paramString1, paramString2).get(paramString3);
      AppMethodBeat.o(99744);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.TimeLineClickEvent", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(99744);
    }
    return "";
  }
  
  protected static boolean aye(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new mf();
    ((mf)localObject).dAH.action = -2;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((mf)localObject).dAI.dAJ;
    if ((localObject != null) && (com.tencent.mm.ay.a.e((com.tencent.mm.ay.f)localObject)) && (paramString.equals(((com.tencent.mm.ay.f)localObject).ijZ)) && (com.tencent.mm.ay.a.aJZ()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void dcY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo
 * JD-Core Version:    0.7.0.1
 */