package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.nn.b;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.b.a.lc;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.plugin.findersdk.a.y.b;
import com.tencent.mm.plugin.findersdk.a.y.c;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.sns.ad.f.p;
import com.tencent.mm.plugin.sns.ad.f.p.a;
import com.tencent.mm.plugin.sns.ad.f.p.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public final class bu
{
  com.tencent.mm.plugin.sns.model.ai KCs;
  public View.OnClickListener KWe;
  public View.OnClickListener LfA;
  private a Lfd;
  public View.OnClickListener Lfe;
  public View.OnClickListener Lff;
  public View.OnClickListener Lfg;
  public View.OnClickListener Lfh;
  public View.OnClickListener Lfi;
  public View.OnClickListener Lfj;
  public View.OnClickListener Lfk;
  public View.OnClickListener Lfl;
  public View.OnClickListener Lfm;
  public View.OnClickListener Lfn;
  public View.OnClickListener Lfo;
  public View.OnClickListener Lfp;
  public View.OnClickListener Lfq;
  public View.OnClickListener Lfr;
  public View.OnClickListener Lfs;
  public View.OnClickListener Lft;
  public View.OnClickListener Lfu;
  public View.OnClickListener Lfv;
  public View.OnClickListener Lfw;
  public View.OnClickListener Lfx;
  public View.OnClickListener Lfy;
  public View.OnClickListener Lfz;
  Context context;
  long lastClickTime;
  int source;
  com.tencent.mm.ui.base.s tipDialog;
  
  public bu(Context paramContext, a parama, int paramInt, com.tencent.mm.plugin.sns.model.ai paramai)
  {
    AppMethodBeat.i(99741);
    this.source = 0;
    this.lastClickTime = 0L;
    this.KWe = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        long l1 = System.currentTimeMillis();
        if (l1 - bu.this.lastClickTime < 500L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
        }
        bu.this.lastClickTime = l1;
        Object localObject6;
        Object localObject5;
        final TimeLineObject localTimeLineObject;
        SnsInfo localSnsInfo;
        Object localObject7;
        label378:
        int i;
        label584:
        Object localObject2;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          localObject6 = (s)paramAnonymousView.getTag();
          localObject5 = null;
          localTimeLineObject = ((s)localObject6).KCX;
          localSnsInfo = aj.fOI().bbl(((s)localObject6).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N(localSnsInfo);
          }
          if (localTimeLineObject.ContentObj.Sqq == 18)
          {
            paramAnonymousView = bu.this;
            localObject1 = bu.this.context;
            localObject5 = ((s)localObject6).KCX;
            localObject6 = ((s)localObject6).fAg;
            localObject6 = aj.fOI().bbl((String)localObject6);
            p.a(p.b.JGe, p.a.JFW, (SnsInfo)localObject6, paramAnonymousView.source);
            localObject6 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject5).ContentObj.Sqr.size() > 0) {
              paramAnonymousView = (cvt)((TimeLineObject)localObject5).ContentObj.Sqr.get(0);
            }
            ((Intent)localObject6).putExtra("KFromTimeLine", false);
            ((Intent)localObject6).putExtra("KStremVideoUrl", ((TimeLineObject)localObject5).ContentObj.Url);
            ((Intent)localObject6).putExtra("KSta_SourceType", 2);
            ((Intent)localObject6).putExtra("KSta_Scene", p.b.JGe.value);
            ((Intent)localObject6).putExtra("KSta_FromUserName", ((TimeLineObject)localObject5).UserName);
            ((Intent)localObject6).putExtra("KSta_SnSId", ((TimeLineObject)localObject5).Id);
            if (paramAnonymousView == null)
            {
              localObject7 = new StringBuilder("fakeid_");
              if (paramAnonymousView == null)
              {
                paramAnonymousView = ((TimeLineObject)localObject5).Id;
                ((Intent)localObject6).putExtra("KMediaId", paramAnonymousView);
                paramAnonymousView = ((TimeLineObject)localObject5).streamvideo;
                if (paramAnonymousView != null)
                {
                  ((Intent)localObject6).putExtra("KMediaVideoTime", paramAnonymousView.los);
                  ((Intent)localObject6).putExtra("StreamWording", paramAnonymousView.lou);
                  ((Intent)localObject6).putExtra("StremWebUrl", paramAnonymousView.lov);
                  ((Intent)localObject6).putExtra("KMediaTitle", paramAnonymousView.lot);
                  ((Intent)localObject6).putExtra("KStremVideoUrl", paramAnonymousView.lor);
                  ((Intent)localObject6).putExtra("KThumUrl", paramAnonymousView.low);
                  ((Intent)localObject6).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.lox);
                  ((Intent)localObject6).putExtra("KSta_StremVideoPublishId", paramAnonymousView.loy);
                }
                ((Intent)localObject6).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject5).statExtStr);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuU, 0) <= 0) {
                  break label584;
                }
                com.tencent.mm.by.c.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject6);
                Log.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              paramAnonymousView = paramAnonymousView.Id;
              break;
              ((Intent)localObject6).putExtra("KMediaId", paramAnonymousView.Id);
              break label378;
              com.tencent.mm.by.c.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject6);
            }
          }
          if ((localTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(localTimeLineObject.webSearchInfo.PyQ)))
          {
            localObject1 = bu.this;
            paramAnonymousView = localTimeLineObject.webSearchInfo;
            if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.PyQ)))
            {
              localObject5 = com.tencent.mm.plugin.topstory.a.h.a(paramAnonymousView, 31, com.tencent.mm.plugin.websearch.api.ak.biP("discoverRecommendEntry").optString("wording"));
              com.tencent.mm.plugin.websearch.api.ai.a(((bu)localObject1).context, (esv)localObject5);
              localObject1 = localTimeLineObject.UserName;
              localObject6 = localTimeLineObject.Id;
              localObject5 = new StringBuffer();
              ((StringBuffer)localObject5).append("isShareClick=1");
              ((StringBuffer)localObject5).append("&relevant_vid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.PyQ);
              ((StringBuffer)localObject5).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.PyS);
              ((StringBuffer)localObject5).append("&relevant_shared_openid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.PyT);
              ((StringBuffer)localObject5).append("&rec_category=");
              if (paramAnonymousView.Pzc <= 0L) {
                break label957;
              }
              ((StringBuffer)localObject5).append(paramAnonymousView.Pzc);
            }
            for (;;)
            {
              ((StringBuffer)localObject5).append("&source=");
              ((StringBuffer)localObject5).append(paramAnonymousView.source);
              ((StringBuffer)localObject5).append("&fromUser=");
              ((StringBuffer)localObject5).append((String)localObject1);
              ((StringBuffer)localObject5).append("&fromScene=");
              ((StringBuffer)localObject5).append(3);
              ((StringBuffer)localObject5).append("&targetInfo=");
              ((StringBuffer)localObject5).append((String)localObject6);
              ((StringBuffer)localObject5).append("&expand=");
              ((StringBuffer)localObject5).append(paramAnonymousView.PyR);
              Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject5).toString() });
              paramAnonymousView = new dxu();
              paramAnonymousView.Udk = ((StringBuffer)localObject5).toString();
              paramAnonymousView = new ad(paramAnonymousView);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousView, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              label957:
              ((StringBuffer)localObject5).append(paramAnonymousView.PyU);
            }
          }
          long l2;
          if (localTimeLineObject.ContentObj.Sqq == 28)
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aZs(localTimeLineObject.ContentObj.fFJ.objectId);
            l2 = localTimeLineObject.ContentObj.fFJ.localId;
            if ((l1 != 0L) || (l2 != 0L))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("feed_object_id", l1);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.ContentObj.fFJ.objectNonceId);
              paramAnonymousView.putExtra("business_type", 0);
              paramAnonymousView.putExtra("finder_user_name", localTimeLineObject.ContentObj.fFJ.username);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("tab_type", 5);
              paramAnonymousView.putExtra("feed_local_id", l2);
              paramAnonymousView.putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", localTimeLineObject.ContentObj.fFJ.nickname);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", localTimeLineObject.ContentObj.fFJ.username);
              if ((l1 == 0L) && (l2 != 0L)) {
                paramAnonymousView.putExtra("key_posting_scene", true);
              }
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 25, paramAnonymousView);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(bu.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
            }
          }
          else if (localTimeLineObject.ContentObj.Sqq == 36)
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aZs(localTimeLineObject.ContentObj.Sqy.objectId);
            if (l1 != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("feed_object_id", l1);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.ContentObj.Sqy.objectNonceId);
              paramAnonymousView.putExtra("business_type", 1);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("tab_type", 5);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 53, paramAnonymousView);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(bu.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
          }
          if ((localTimeLineObject.ContentObj.Sqq == 34) || (localTimeLineObject.ContentObj.Sqq == 43))
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aZs(localTimeLineObject.ContentObj.yNL.kwM);
            l2 = com.tencent.mm.plugin.sns.data.t.aZs(localTimeLineObject.ContentObj.yNL.feedId);
            if ((l1 != 0L) && (l2 != 0L))
            {
              if (Util.isEqual(z.bdh(), localTimeLineObject.ContentObj.yNL.username))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", localTimeLineObject.ContentObj.yNL.sourceType);
                ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, bu.this.context, l2, Long.valueOf(l1), localTimeLineObject.ContentObj.yNL.objectNonceId, localTimeLineObject.ContentObj.yNL.desc, "", "", "");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("key_enter_live_param_visitor_enter_scene", 2);
                ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveVisitorUI(paramAnonymousView, bu.this.context, l2, Long.valueOf(l1), localTimeLineObject.ContentObj.yNL.username, localTimeLineObject.ContentObj.yNL.objectNonceId, localTimeLineObject.ContentObj.yNL.desc, "", "", "", 0, "", 1, ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
              }
            }
          }
          if ((localTimeLineObject.ContentObj.Sqq == 29) && (localTimeLineObject.ContentObj.Sqv != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Sqv.topic);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Sqv.wXA);
            localObject1 = new bdm();
            ((bdm)localObject1).SOz = localTimeLineObject.ContentObj.Sqv.STu.SOz;
            ((bdm)localObject1).longitude = localTimeLineObject.ContentObj.Sqv.STu.longitude;
            ((bdm)localObject1).latitude = localTimeLineObject.ContentObj.Sqv.STu.latitude;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((bdm)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
              if (localTimeLineObject.ContentObj.Sqv.wXA == 1)
              {
                i = 22;
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderTopicUI(bu.this.context, paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
              }
            }
            catch (IOException localIOException1)
            {
              for (;;)
              {
                Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                continue;
                i = 26;
              }
            }
          }
          if ((localTimeLineObject.ContentObj.Sqq == 37) && (localTimeLineObject.ContentObj.Sqv != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Sqv.topic);
            paramAnonymousView.putExtra("KEY_FOLLOW_ID", localTimeLineObject.ContentObj.Sqv.STv);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Sqv.wXA);
            bdm localbdm = new bdm();
            localbdm.SOz = localTimeLineObject.ContentObj.Sqv.STu.SOz;
            localbdm.longitude = localTimeLineObject.ContentObj.Sqv.STu.longitude;
            localbdm.latitude = localTimeLineObject.ContentObj.Sqv.STu.latitude;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", localbdm.toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              switch (localTimeLineObject.ContentObj.Sqv.wXA)
              {
              case 3: 
              default: 
                i = 22;
                paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
                paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
                paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderTopicUI(bu.this.context, paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
              }
            }
            catch (IOException localIOException2)
            {
              for (;;)
              {
                Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                continue;
                i = 22;
                continue;
                i = 26;
                continue;
                i = 49;
              }
            }
          }
          if ((localTimeLineObject.ContentObj.Sqq == 38) && (localTimeLineObject.ContentObj.Sqx != null))
          {
            paramAnonymousView = localTimeLineObject.ContentObj.Sqx;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("TITLE_WORDING", paramAnonymousView.title);
            ((Intent)localObject2).putExtra("AUTO_REFRESH", true);
          }
        }
        try
        {
          ((Intent)localObject2).putExtra("FINDER_SHARE_ALBUM", paramAnonymousView.toByteArray());
          ((Intent)localObject2).putExtra("STREAM_CARD_BUFFER", paramAnonymousView.xGO.toByteArray());
          ((Intent)localObject2).putExtra("GET_REL_SCENE", 14);
          ((Intent)localObject2).putExtra("COMMENT_SCENE", 51);
          ((Intent)localObject2).putExtra("CARD_ID", com.tencent.mm.plugin.sns.data.t.aZs(paramAnonymousView.cardId));
          ((Intent)localObject2).putExtra("SHARED_USERNAME", localTimeLineObject.UserName);
          ((Intent)localObject2).putExtra("FROM_SHARE_SCENE", 3);
          ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterAlbumRelatedTimelineUI(bu.this.context, (Intent)localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
          if (localTimeLineObject.ContentObj.Sqq == 39) {}
          switch (localTimeLineObject.ContentObj.loX)
          {
          default: 
            if ((localTimeLineObject.ContentObj.Sqq != 44) || (localTimeLineObject.ContentObj.SqA == null)) {
              break label3627;
            }
            paramAnonymousView = new Intent();
            localObject2 = new eka();
            ((eka)localObject2).SOz = localTimeLineObject.ContentObj.SqA.SOz;
            ((eka)localObject2).ScO = Util.safeParseFloat(localTimeLineObject.ContentObj.SqA.STs);
            ((eka)localObject2).ScP = Util.safeParseFloat(localTimeLineObject.ContentObj.SqA.STr);
            ((eka)localObject2).poiName = localTimeLineObject.ContentObj.SqA.poiName;
            ((eka)localObject2).TAy = localTimeLineObject.ContentObj.SqA.QSw;
            ((eka)localObject2).KFu = localTimeLineObject.ContentObj.SqA.lLg;
            ((eka)localObject2).TAz = Util.safeParseInt(localTimeLineObject.ContentObj.SqA.STt);
            ((eka)localObject2).KFw = Util.safeParseInt(localTimeLineObject.ContentObj.SqA.xzN);
            localObject5 = com.tencent.mm.plugin.report.service.h.IzE;
            com.tencent.mm.kernel.h.ae(y.class);
            ((com.tencent.mm.plugin.report.service.h)localObject5).p(1663L, 1L, 1L);
            ((y)com.tencent.mm.kernel.h.ae(y.class)).a((eka)localObject2, y.a.Bvj, localTimeLineObject.Id, new y.c()
            {
              public final void a(y.b paramAnonymous2b)
              {
                AppMethodBeat.i(265356);
                int i;
                if (paramAnonymous2b == y.b.Bvm) {
                  if (!Util.isNullOrNil(this.LfC.SOz)) {
                    i = 1;
                  }
                }
                for (;;)
                {
                  if (i == 0)
                  {
                    paramAnonymousView.putExtra("map_view_type", 7);
                    paramAnonymousView.putExtra("kwebmap_slat", this.LfC.ScP);
                    paramAnonymousView.putExtra("kwebmap_lng", this.LfC.ScO);
                    paramAnonymousView.putExtra("kPoiName", this.LfC.poiName);
                    paramAnonymousView.putExtra("Kwebmap_locaion", this.LfC.KFu);
                    com.tencent.mm.by.c.b(bu.this.context, "location", ".ui.RedirectUI", paramAnonymousView);
                    AppMethodBeat.o(265356);
                    return;
                    i = 0;
                    continue;
                    if (paramAnonymous2b == y.b.Bvq) {
                      i = 0;
                    }
                  }
                  else
                  {
                    if (Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsPOICommentFeedNewUrlSwitch"), 0) == 0) {}
                    for (paramAnonymous2b = String.format(com.tencent.mm.protocal.d.RAM, new Object[] { this.LfC.SOz });; paramAnonymous2b = String.format(com.tencent.mm.protocal.d.RAN, new Object[] { this.LfC.SOz, localTimeLineObject.Id }))
                    {
                      paramAnonymousView.putExtra("rawUrl", paramAnonymous2b);
                      com.tencent.mm.plugin.sns.c.a.mIG.h(paramAnonymousView, bu.this.context);
                      AppMethodBeat.o(265356);
                      return;
                    }
                  }
                  i = 1;
                }
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
          case 100000000: 
            if (localTimeLineObject.ContentObj.Sqv != null)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Sqv.topic);
              paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Sqv.wXA);
              localObject2 = new bdm();
              ((bdm)localObject2).SOz = localTimeLineObject.ContentObj.Sqv.STu.SOz;
              ((bdm)localObject2).longitude = localTimeLineObject.ContentObj.Sqv.STu.longitude;
              ((bdm)localObject2).latitude = localTimeLineObject.ContentObj.Sqv.STu.latitude;
              try
              {
                paramAnonymousView.putExtra("key_topic_poi_location", ((bdm)localObject2).toByteArray());
                paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
                paramAnonymousView.putExtra("key_report_scene", 3);
                paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
                UUID.randomUUID();
                paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
                paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
                paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
                if (localTimeLineObject.ContentObj.Sqv.wXA == 1)
                {
                  i = 22;
                  ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                  ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderTopicUI(bu.this.context, paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(99724);
                  return;
                }
              }
              catch (IOException localIOException3)
              {
                for (;;)
                {
                  Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                  continue;
                  i = 26;
                }
              }
            }
            break;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Sqz.topic);
          paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Sqz.wXA);
          Object localObject3 = new bdm();
          ((bdm)localObject3).SOz = localTimeLineObject.ContentObj.Sqz.STu.SOz;
          ((bdm)localObject3).longitude = localTimeLineObject.ContentObj.Sqz.STu.longitude;
          ((bdm)localObject3).latitude = localTimeLineObject.ContentObj.Sqz.STu.latitude;
          try
          {
            paramAnonymousView.putExtra("key_topic_poi_location", ((bdm)localObject3).toByteArray());
            paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
            paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
            paramAnonymousView.putExtra("key_report_scene", 3);
            paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
            UUID.randomUUID();
            localObject3 = localTimeLineObject.ContentObj.Sqz.STw;
            paramAnonymousView.putExtra("key_activity_id", com.tencent.mm.ae.d.Nb(((apn)localObject3).SCQ));
            paramAnonymousView.putExtra("key_activity_name", ((apn)localObject3).SCR);
            paramAnonymousView.putExtra("key_nick_name", ((apn)localObject3).SCS);
            paramAnonymousView.putExtra("key_cover_url", localTimeLineObject.ContentObj.Sqz.iconUrl);
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 59, paramAnonymousView);
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderActivityProfileUI(bu.this.context, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
            }
          }
          label3627:
          Object localObject4 = localObject5;
          if (!TextUtils.isEmpty(localTimeLineObject.canvasInfo))
          {
            localObject4 = localObject5;
            if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localTimeLineObject.canvasInfo))
            {
              localObject7 = bu.aO(localTimeLineObject.canvasInfo, "adxml", ".adxml.adActionLink");
              localObject4 = localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                localObject4 = bu.bch((String)localObject7);
              }
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject4 = bu.bch(localTimeLineObject.ContentObj.Url);
            if ((localObject4 == null) || (((String)localObject4).length() == 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
            int j = bu.this.KCs.getScene();
            localObject5 = localObject4;
            if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb((String)localObject4))
            {
              i = (int)(System.currentTimeMillis() / 1000L);
              localObject5 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e((String)localObject4, 2, j, i);
            }
            Intent localIntent = new Intent();
            localObject4 = null;
            if (localTimeLineObject != null)
            {
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("KSnsStrId", localTimeLineObject.Id);
              ((Bundle)localObject4).putString("KSnsLocalId", ((s)localObject6).fAg);
              ((Bundle)localObject4).putBoolean("KFromTimeline", true);
              if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Sqr.size() > 0))
              {
                ((Bundle)localObject4).putString("K_sns_thumb_url", ((cvt)localTimeLineObject.ContentObj.Sqr.get(0)).TDF);
                ((Bundle)localObject4).putString("K_sns_raw_url", localTimeLineObject.ContentObj.Url);
                Log.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((cvt)localTimeLineObject.ContentObj.Sqr.get(0)).TDF, localTimeLineObject.ContentObj.Url });
              }
            }
            ((Bundle)localObject4).putString("key_snsad_statextstr", localTimeLineObject.statExtStr);
            localIntent.putExtra("rawUrl", (String)localObject5);
            localIntent.putExtra("shortUrl", (String)localObject5);
            localIntent.putExtra("useJs", true);
            localIntent.putExtra("type", -255);
            if (localTimeLineObject.publicUserName != null)
            {
              localIntent.putExtra("srcUsername", localTimeLineObject.publicUserName);
              localIntent.putExtra("srcDisplayname", localTimeLineObject.sourceNickName);
              Log.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + localTimeLineObject.sourceNickName + " tlObj.publicUserName: " + localTimeLineObject.publicUserName);
            }
            localIntent.putExtra("sns_local_id", ((s)localObject6).fAg);
            if (localSnsInfo != null)
            {
              localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
              localIntent.putExtra("pre_username", localSnsInfo.field_userName);
              localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
              localIntent.putExtra("preUsername", localSnsInfo.field_userName);
              localIntent.putExtra("share_report_pre_msg_url", (String)localObject5);
              localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.ContentObj.fwr);
              localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.ContentObj.CMB);
              if ((localTimeLineObject.ContentObj.Sqr != null) && (localTimeLineObject.ContentObj.Sqr.size() > 0)) {
                localIntent.putExtra("share_report_pre_msg_icon_url", ((cvt)localTimeLineObject.ContentObj.Sqr.get(0)).TDF);
              }
              localIntent.putExtra("share_report_pre_msg_appid", "");
              localIntent.putExtra("share_report_from_scene", 1);
            }
            if ((localTimeLineObject != null) && (localTimeLineObject.AppInfo != null)) {
              localIntent.putExtra("KAppId", localTimeLineObject.AppInfo.Id);
            }
            if ((localSnsInfo != null) && (localSnsInfo.isAd()))
            {
              if (bu.this.source != 2) {
                break label5070;
              }
              localObject6 = localSnsInfo.getAtAdInfo();
              if (localObject6 != null) {
                localIntent.putExtra("KsnsViewId", ((ADInfo)localObject6).viewId);
              }
            }
            if ((localSnsInfo != null) && (localTimeLineObject != null))
            {
              if (bu.this.source != 0) {
                break label5080;
              }
              localObject6 = com.tencent.mm.modelsns.l.wO(718);
              label4454:
              com.tencent.mm.modelsns.l locall = ((com.tencent.mm.modelsns.l)localObject6).Xf(com.tencent.mm.plugin.sns.data.t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd()).Xf(localSnsInfo.getUxinfo()).Xf(localTimeLineObject.publicUserName);
              if (localTimeLineObject.AppInfo != null) {
                break label5091;
              }
              localObject7 = "";
              label4511:
              locall.Xf((String)localObject7).Xf(localTimeLineObject.ContentObj.Url);
              ((com.tencent.mm.modelsns.l)localObject6).bpa();
              if (bu.this.source != 0) {
                break label5104;
              }
              localObject6 = com.tencent.mm.modelsns.l.wO(743);
              label4554:
              locall = ((com.tencent.mm.modelsns.l)localObject6).Xf(com.tencent.mm.plugin.sns.data.t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd()).Xf(localSnsInfo.getUxinfo()).Xf(localTimeLineObject.publicUserName);
              if (localTimeLineObject.AppInfo != null) {
                break label5115;
              }
              localObject7 = "";
              label4611:
              locall.Xf((String)localObject7).Xf(localTimeLineObject.ContentObj.Url);
              if (localObject4 != null)
              {
                localObject6 = ((com.tencent.mm.modelsns.l)localObject6).biB();
                if (localObject6 != null) {
                  ((Bundle)localObject4).putByteArray("intent_key_StatisticsOplog", (byte[])localObject6);
                }
              }
            }
            if (localObject4 != null) {
              localIntent.putExtra("jsapiargs", (Bundle)localObject4);
            }
            localIntent.putExtra("geta8key_scene", 2);
            localIntent.putExtra("from_scence", 3);
            if ((localTimeLineObject.ContentObj.Squ != null) && (localTimeLineObject.ContentObj.Squ.lpx != -1)) {
              localIntent.putExtra(f.r.VSO, localTimeLineObject.ContentObj.Squ.lpx);
            }
            if ((!Util.isNullOrNil(localTimeLineObject.canvasInfo)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localTimeLineObject.canvasInfo)) && (localSnsInfo != null))
            {
              localObject4 = new int[2];
              if (paramAnonymousView != null) {
                paramAnonymousView.getLocationInWindow((int[])localObject4);
              }
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              if (localTimeLineObject != null)
              {
                localObject4 = localTimeLineObject.ContentObj.Sqr;
                if (((List)localObject4).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cvt)((List)localObject4).get(0)).TDF);
                }
              }
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
              paramAnonymousView.putExtra("sns_landing_pages_aid", localSnsInfo.getAid());
              paramAnonymousView.putExtra("sns_landing_pages_traceid", localSnsInfo.getTraceid());
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
              if (bu.this.source == 0) {}
              for (i = 3;; i = 4)
              {
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.setClass(bu.this.context, SnsAdNativeLandingPagesUI.class);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.canvasInfo);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.x(paramAnonymousView, bu.this.context);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
                label5070:
                localObject6 = localSnsInfo.getAdInfo();
                break;
                label5080:
                localObject6 = com.tencent.mm.modelsns.l.wP(718);
                break label4454;
                label5091:
                localObject7 = localTimeLineObject.AppInfo.Id;
                break label4511;
                label5104:
                localObject6 = com.tencent.mm.modelsns.l.wP(743);
                break label4554;
                label5115:
                localObject7 = localTimeLineObject.AppInfo.Id;
                break label4611;
              }
            }
            localIntent.putExtra("key_enable_teen_mode_check", true);
            localIntent.putExtra("msgUsername", localTimeLineObject.UserName);
            localIntent.putExtra("serverMsgID", localTimeLineObject.Id);
            localIntent.addFlags(536870912);
            if (localTimeLineObject.ContentObj.Squ != null)
            {
              i = localTimeLineObject.ContentObj.Squ.lpx;
              if ((!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(4)) || (!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(bu.this.context, (String)localObject5, i, 2, j, localIntent))) {
                break label5576;
              }
              Log.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
              label5261:
              localObject4 = null;
              j = 0;
              i = j;
              paramAnonymousView = (View)localObject4;
              if (localTimeLineObject != null)
              {
                i = j;
                paramAnonymousView = (View)localObject4;
                if (localTimeLineObject.AppInfo != null)
                {
                  paramAnonymousView = localTimeLineObject.AppInfo.Id;
                  i = Util.getInt(localTimeLineObject.AppInfo.Version, 0);
                }
              }
              localObject6 = com.tencent.mm.plugin.sns.c.a.mIH.O(paramAnonymousView, i);
              if (!Util.isNullOrNil((String)localObject6))
              {
                localObject5 = null;
                localObject4 = localObject5;
                if (localTimeLineObject != null)
                {
                  localObject4 = localObject5;
                  if (localTimeLineObject.actionInfo != null)
                  {
                    localObject4 = localObject5;
                    if (localTimeLineObject.actionInfo.RFO != null) {
                      localObject4 = localTimeLineObject.actionInfo.RFO.RFI;
                    }
                  }
                }
                if (localTimeLineObject != null) {
                  break label5596;
                }
                localObject5 = null;
                label5391:
                com.tencent.mm.plugin.sns.c.a.mIH.a(bu.this.context, paramAnonymousView, (String)localObject6, (String)localObject5, 5, 4, 1, (String)localObject4, localTimeLineObject.Id);
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(11105, new Object[] { localTimeLineObject.UserName, localTimeLineObject.ContentObj.Url });
              if ((localSnsInfo != null) && ((localSnsInfo.field_type == 4) || (localSnsInfo.field_type == 42)))
              {
                paramAnonymousView = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
                localObject4 = com.tencent.mm.plugin.report.service.h.IzE;
                if (paramAnonymousView != null) {
                  break label5606;
                }
              }
            }
            label5576:
            label5596:
            label5606:
            for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.CMB)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject4).a(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.AppInfo.Id });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              i = -1;
              break;
              com.tencent.mm.plugin.sns.c.a.mIG.h(localIntent, bu.this.context);
              break label5261;
              localObject5 = localTimeLineObject.UserName;
              break label5391;
            }
          }
        }
        catch (IOException localIOException5)
        {
          for (;;) {}
        }
      }
    };
    this.Lfe = new bu.12(this);
    this.Lff = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99734);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        long l1;
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99734);
            return;
          }
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if ((paramAnonymousView.ContentObj == null) || (paramAnonymousView.ContentObj.fFJ == null)) {
            break label427;
          }
          l1 = com.tencent.mm.plugin.sns.data.t.aZs(paramAnonymousView.ContentObj.fFJ.objectId);
          long l2 = paramAnonymousView.ContentObj.fFJ.localId;
          if ((l1 != 0L) || (l2 != 0L))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("report_scene", 3);
            ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("feed_object_id", l1);
            ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.fFJ.objectNonceId);
            ((Intent)localObject).putExtra("business_type", 0);
            ((Intent)localObject).putExtra("finder_user_name", paramAnonymousView.ContentObj.fFJ.username);
            ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("tab_type", 5);
            ((Intent)localObject).putExtra("key_comment_scene", 38);
            ((Intent)localObject).putExtra("feed_local_id", l2);
            ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
            ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramAnonymousView.ContentObj.fFJ.nickname);
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.fFJ.username);
            if ((l1 == 0L) && (l2 != 0L)) {
              ((Intent)localObject).putExtra("key_posting_scene", true);
            }
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(bu.this.context, (Intent)localObject);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99734);
          return;
          label427:
          if ((paramAnonymousView.ContentObj != null) && (paramAnonymousView.ContentObj.Sqy != null))
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aZs(paramAnonymousView.ContentObj.Sqy.objectId);
            if (l1 != 0L)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("report_scene", 3);
              ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("feed_object_id", l1);
              ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.Sqy.objectNonceId);
              ((Intent)localObject).putExtra("business_type", 1);
              ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("tab_type", 5);
              ((Intent)localObject).putExtra("key_comment_scene", 53);
              ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
              ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramAnonymousView.ContentObj.Sqy.nickname);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.Sqy.username);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(bu.this.context, (Intent)localObject);
            }
          }
        }
      }
    };
    this.Lfg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99735);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          localObject1 = (TimeLineObject)paramAnonymousView.getTag();
          long l1 = com.tencent.mm.plugin.sns.data.t.aZs(((TimeLineObject)localObject1).ContentObj.yNL.kwM);
          long l2 = com.tencent.mm.plugin.sns.data.t.aZs(((TimeLineObject)localObject1).ContentObj.yNL.feedId);
          if ((l1 != 0L) && (l2 != 0L))
          {
            if (Util.isEqual(z.bdh(), ((TimeLineObject)localObject1).ContentObj.yNL.username))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", ((TimeLineObject)localObject1).ContentObj.yNL.sourceType);
              ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, bu.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject1).ContentObj.yNL.objectNonceId, ((TimeLineObject)localObject1).ContentObj.yNL.desc, "", "", "");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99735);
              return;
            }
            label237:
            Object localObject2;
            if (((TimeLineObject)localObject1).UserName == null)
            {
              paramAnonymousView = "";
              com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramAnonymousView;
              com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = ((TimeLineObject)localObject1).Id;
              com.tencent.mm.plugin.expt.hellhound.a.aww("temp_6");
              paramAnonymousView = (com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
              localObject2 = ((TimeLineObject)localObject1).ContentObj.yNL.username;
              if (((TimeLineObject)localObject1).ContentObj.yNL.liveStatus != 1) {
                break label481;
              }
            }
            label481:
            for (int i = 1;; i = 2)
            {
              paramAnonymousView.report21053OnClick(l2, l1, (String)localObject2, -1, -1, 7L, "temp_6", i, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.deb(), com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm, System.currentTimeMillis(), 1);
              paramAnonymousView = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).genContextId(2, 4, 65);
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("key_enter_live_param_share_username", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl);
              ((Intent)localObject2).putExtra("key_enter_live_param_from_share_scene", 0);
              ((Intent)localObject2).putExtra("key_enter_live_param_visitor_enter_scene", 2);
              ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveVisitorUI((Intent)localObject2, bu.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject1).ContentObj.yNL.username, ((TimeLineObject)localObject1).ContentObj.yNL.objectNonceId, ((TimeLineObject)localObject1).ContentObj.yNL.desc, paramAnonymousView, "", "", 0, "", 1, ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
              break;
              paramAnonymousView = ((TimeLineObject)localObject1).UserName;
              break label237;
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99735);
      }
    };
    this.Lfh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99736);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof s)))
        {
          if (!((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).canEnterMvAndShowToast())
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99736);
            return;
          }
          localObject1 = ((s)paramAnonymousView.getTag()).KCX;
          int i = ((s)paramAnonymousView.getTag()).lnm;
          boolean bool1;
          if (((TimeLineObject)localObject1).ContentObj.Sqq == 42) {
            bool1 = true;
          }
          for (;;)
          {
            boolean bool2 = bool1;
            if (!bool1)
            {
              bool2 = bool1;
              if (((TimeLineObject)localObject1).AppInfo != null)
              {
                if (((TimeLineObject)localObject1).ContentObj.Sqq != 4) {
                  break label696;
                }
                paramAnonymousView = com.tencent.mm.plugin.comm.a.ubo;
                if (!com.tencent.mm.plugin.comm.a.asG(((TimeLineObject)localObject1).AppInfo.Id)) {
                  break label696;
                }
                bool2 = true;
              }
            }
            label181:
            int j = ((TimeLineObject)localObject1).ContentObj.Sqq;
            if (((TimeLineObject)localObject1).AppInfo == null)
            {
              paramAnonymousView = "";
              label201:
              Log.i("MicroMsg.TimeLineClickEvent", "canEnterMv:%b, type:%d, appId:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(j), paramAnonymousView });
              if (!bool2) {
                break label748;
              }
              if (!bu.aXq(((TimeLineObject)localObject1).Id))
              {
                if (((TimeLineObject)localObject1).ContentObj == null) {
                  break label714;
                }
                paramAnonymousView = ((TimeLineObject)localObject1).ContentObj.lVY;
                if (paramAnonymousView == null) {}
              }
            }
            try
            {
              Object localObject2 = new dbr();
              ((dbr)localObject2).parseFrom(paramAnonymousView.toByteArray());
              com.tencent.mm.bb.a.c(com.tencent.mm.bb.i.a(aj.getAccPath(), (TimeLineObject)localObject1, 1, com.tencent.mm.bb.h.a(((TimeLineObject)localObject1).Id, (dbr)localObject2)));
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_scene", 7);
              if (!((TimeLineObject)localObject1).ContentObj.Sqr.isEmpty())
              {
                localObject2 = (cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0);
                if (localObject2 != null)
                {
                  paramAnonymousView.putExtra("key_mv_song_name", ((cvt)localObject2).fwr);
                  paramAnonymousView.putExtra("key_mv_song_lyric", ((cvt)localObject2).songLyric);
                  paramAnonymousView.putExtra("key_mv_album_cover_url", ((cvt)localObject2).songAlbumUrl);
                }
              }
              if (((TimeLineObject)localObject1).ContentObj.lVY != null)
              {
                localObject2 = ((TimeLineObject)localObject1).ContentObj.lVY;
                paramAnonymousView.putExtra("key_mv_feed_id", ((dbr)localObject2).Ruu);
                paramAnonymousView.putExtra("key_mv_nonce_id", ((dbr)localObject2).Ruv);
                paramAnonymousView.putExtra("key_mv_cover_url", ((dbr)localObject2).Ruw);
                paramAnonymousView.putExtra("key_mv_poster", ((dbr)localObject2).Rux);
                paramAnonymousView.putExtra("key_mv_singer_name", ((dbr)localObject2).singerName);
                paramAnonymousView.putExtra("key_mv_album_name", ((dbr)localObject2).albumName);
                paramAnonymousView.putExtra("key_mv_music_genre", ((dbr)localObject2).musicGenre);
                paramAnonymousView.putExtra("key_mv_issue_date", String.valueOf(((dbr)localObject2).issueDate));
                paramAnonymousView.putExtra("key_mv_identification", ((dbr)localObject2).identification);
                paramAnonymousView.putExtra("key_mv_extra_info", ((dbr)localObject2).extraInfo);
                paramAnonymousView.putExtra("key_mv_music_duration", ((dbr)localObject2).FSG);
                paramAnonymousView.putExtra("key_mv_thumb_path", ((dbr)localObject2).lVZ);
              }
              paramAnonymousView.setFlags(268435456);
              localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
              localObject2 = (dbs)a.a.a(bu.this.context, "MusicMvMainUI", 7, dbs.class);
              ((dbs)localObject2).scene = 1;
              if (i == 2) {
                ((dbs)localObject2).scene = 17;
              }
              com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.ubo;
              ((dbs)localObject2).wmL = com.tencent.mm.plugin.comm.a.cPn();
              ((dbs)localObject2).TIZ = 85;
              ((dbs)localObject2).TJa = ((TimeLineObject)localObject1).Id;
              com.tencent.mm.by.c.b(bu.this.context, "mv", ".ui.MusicMvMainUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99736);
              return;
              bool1 = false;
              continue;
              label696:
              bool2 = false;
              break label181;
              paramAnonymousView = ((TimeLineObject)localObject1).AppInfo.Id;
              break label201;
              label714:
              paramAnonymousView = null;
            }
            catch (IOException paramAnonymousView)
            {
              for (;;)
              {
                Log.e("MicroMsg.TimeLineClickEvent", "playMvMusic fail: " + paramAnonymousView.getLocalizedMessage());
              }
            }
          }
        }
        label748:
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99736);
      }
    };
    this.Lfi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99737);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof by)))
        {
          paramAnonymousView = (by)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            localObject1 = new Intent(bu.this.context, SnsWsFoldDetailUI.class);
            ((Intent)localObject1).putExtra("key_ws_group_id", paramAnonymousView.LeD);
            ((Intent)localObject1).putExtra("key_ws_detail_max_id", paramAnonymousView.JVf);
            ((Intent)localObject1).putExtra("key_ws_detail_min_id", paramAnonymousView.JVg);
            ((Intent)localObject1).putExtra("key_ws_detail_username", paramAnonymousView.username);
            Object localObject2 = new ArrayList();
            Iterator localIterator = paramAnonymousView.idList.iterator();
            while (localIterator.hasNext()) {
              ((ArrayList)localObject2).add(com.tencent.mm.plugin.sns.data.t.Qv(((Long)localIterator.next()).longValue()));
            }
            ((Intent)localObject1).putStringArrayListExtra("key_ws_str_sns_id_list", (ArrayList)localObject2);
            localObject2 = bu.this.context;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.k.g.Kia.a(paramAnonymousView.idList, paramAnonymousView.LeD, paramAnonymousView.username);
            localObject1 = com.tencent.mm.plugin.sns.k.g.Kia;
            long l = paramAnonymousView.LeD;
            paramAnonymousView = (lc)((com.tencent.mm.plugin.sns.k.g)localObject1).KiR.get(Long.valueOf(l));
            if (paramAnonymousView != null) {
              paramAnonymousView.gQd = 1;
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
      }
    };
    this.Lfj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99738);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        long l1;
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99738);
            return;
          }
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if ((paramAnonymousView.ContentObj == null) || (paramAnonymousView.ContentObj.fFJ == null)) {
            break label417;
          }
          l1 = com.tencent.mm.plugin.sns.data.t.aZs(paramAnonymousView.ContentObj.fFJ.objectId);
          long l2 = paramAnonymousView.ContentObj.fFJ.localId;
          if ((l1 != 0L) || (l2 != 0L))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("report_scene", 3);
            ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("feed_object_id", l1);
            ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.fFJ.objectNonceId);
            ((Intent)localObject).putExtra("business_type", 0);
            ((Intent)localObject).putExtra("finder_user_name", paramAnonymousView.ContentObj.fFJ.username);
            ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("tab_type", 5);
            ((Intent)localObject).putExtra("feed_local_id", l2);
            ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
            ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramAnonymousView.ContentObj.fFJ.nickname);
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.fFJ.username);
            if ((l1 == 0L) && (l2 != 0L)) {
              ((Intent)localObject).putExtra("key_posting_scene", true);
            }
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
            ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(bu.this.context, (Intent)localObject);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99738);
          return;
          label417:
          if ((paramAnonymousView.ContentObj != null) && (paramAnonymousView.ContentObj.Sqy != null))
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aZs(paramAnonymousView.ContentObj.Sqy.objectId);
            if (l1 != 0L)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("report_scene", 3);
              ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("feed_object_id", l1);
              ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.Sqy.objectNonceId);
              ((Intent)localObject).putExtra("business_type", 1);
              ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("tab_type", 5);
              ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
              ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramAnonymousView.ContentObj.Sqy.nickname);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.Sqy.username);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 53, (Intent)localObject);
              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(bu.this.context, (Intent)localObject);
            }
          }
        }
      }
    };
    this.Lfk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99739);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = bu.this;
        int i;
        if ((paramAnonymousView == null) || (!(paramAnonymousView.getTag() instanceof TimeLineObject))) {
          i = 1;
        }
        while (i == 0)
        {
          Object localObject2;
          if ((paramAnonymousView == null) || (!(paramAnonymousView.getTag() instanceof TimeLineObject)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
            return;
            localObject2 = ((TimeLineObject)paramAnonymousView.getTag()).AppInfo.Id;
            if ("wx485a97c844086dc9".equals(localObject2))
            {
              com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
              i = 1;
            }
            else
            {
              if ("wx7fa037cc7dfabad5".equals(localObject2))
              {
                com.tencent.mm.plugin.sport.a.d.rE(34);
                com.tencent.mm.kernel.h.aHH();
                if (com.tencent.mm.contact.d.rk(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG("gh_43f2581f6fd6").field_type))
                {
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("Chat_User", "gh_43f2581f6fd6");
                  ((Intent)localObject2).putExtra("finish_direct", true);
                  com.tencent.mm.by.c.f(((bu)localObject1).context, ".ui.chatting.ChattingUI", (Intent)localObject2);
                }
                for (;;)
                {
                  i = 1;
                  break;
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("Contact_User", "gh_43f2581f6fd6");
                  com.tencent.mm.by.c.b(((bu)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
                }
              }
              if (("wx9181ed3f223e6d76".equals(localObject2)) || ("wx2fe12a395c426fcf".equals(localObject2)))
              {
                Log.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("shake_tv", true);
                com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
                i = 1;
              }
              else if ("wxfbc915ff7c30e335".equals(localObject2))
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 1);
                if ((!com.tencent.mm.q.a.p(((bu)localObject1).context, true)) && (!com.tencent.mm.q.a.cw(((bu)localObject1).context)) && (!com.tencent.mm.q.a.cB(((bu)localObject1).context))) {
                  com.tencent.mm.by.c.b(((bu)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
                }
                i = 1;
              }
              else if ("wxaf060266bfa9a35c".equals(localObject2))
              {
                if (!e.bnF())
                {
                  i = 1;
                }
                else
                {
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("shake_tv", true);
                  com.tencent.mm.by.c.b(((bu)localObject1).context, "shake", ".ui.ShakeReportUI", (Intent)localObject2);
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
            if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
            }
            Object localObject3 = (TimeLineObject)paramAnonymousView.getTag();
            if ((localObject3 == null) || (((TimeLineObject)localObject3).AppInfo == null))
            {
              Log.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
            }
            if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Sqq == 28) && (((TimeLineObject)localObject3).ContentObj.fFJ != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
              ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
              ((Intent)localObject1).putExtra("key_comment_scene", 37);
              if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.fFJ.username))
              {
                ((Intent)localObject1).putExtra("finder_username", "");
                ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.fFJ.objectId);
                ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.fFJ.objectNonceId);
              }
              for (;;)
              {
                ((Intent)localObject1).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
                ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
                ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.fFJ.nickname);
                ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.fFJ.username);
                localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr());
                str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
                str2 = ((TimeLineObject)localObject3).ContentObj.fFJ.objectId;
                localObject3 = ((TimeLineObject)localObject3).Id;
                localObject2 = (String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3;
                Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject2)));
                com.tencent.mm.plugin.report.service.h.IzE.kvStat(20587, (String)localObject2);
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject1);
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99739);
                return;
                ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.fFJ.username);
              }
            }
            if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Sqq == 36) && (((TimeLineObject)localObject3).ContentObj.Sqy != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
              ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
              ((Intent)localObject1).putExtra("key_comment_scene", 37);
              if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Sqy.username))
              {
                ((Intent)localObject1).putExtra("finder_username", "");
                ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.Sqy.objectId);
                ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.Sqy.objectNonceId);
              }
              for (;;)
              {
                ((Intent)localObject1).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
                ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
                ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.Sqy.nickname);
                ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.Sqy.username);
                localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr());
                str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
                str2 = ((TimeLineObject)localObject3).ContentObj.Sqy.objectId;
                localObject3 = ((TimeLineObject)localObject3).Id;
                localObject2 = (String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3;
                Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject2)));
                com.tencent.mm.plugin.report.service.h.IzE.kvStat(20587, (String)localObject2);
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject1);
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99739);
                return;
                ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.Sqy.username);
              }
            }
            if ((((TimeLineObject)localObject3).ContentObj != null) && ((((TimeLineObject)localObject3).ContentObj.Sqq == 34) || (((TimeLineObject)localObject3).ContentObj.Sqq == 43)) && (((TimeLineObject)localObject3).ContentObj.yNL != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
              ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
              if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.yNL.username))
              {
                ((Intent)localObject1).putExtra("finder_username", "");
                ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.yNL.feedId);
                ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.yNL.objectNonceId);
              }
              for (;;)
              {
                if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.yNL.nickName)) {
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.yNL.nickName);
                }
                ((Intent)localObject1).putExtra("key_finder_teen_mode_check", ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
                ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
                localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr());
                str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
                str2 = ((TimeLineObject)localObject3).ContentObj.yNL.feedId;
                localObject3 = ((TimeLineObject)localObject3).Id;
                Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf((String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3)));
                ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99739);
                return;
                ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.yNL.username);
                ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.yNL.username);
              }
            }
            if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Sqq == 1) && (((TimeLineObject)localObject3).ContentObj.yNL != null))
            {
              long l1 = com.tencent.mm.plugin.sns.data.t.aZs(((TimeLineObject)localObject3).ContentObj.yNL.kwM);
              long l2 = com.tencent.mm.plugin.sns.data.t.aZs(((TimeLineObject)localObject3).ContentObj.yNL.feedId);
              if ((l1 != 0L) && (l2 != 0L))
              {
                if (Util.isEqual(z.bdh(), ((TimeLineObject)localObject3).ContentObj.yNL.username))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", ((TimeLineObject)localObject3).ContentObj.yNL.sourceType);
                  ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, bu.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject3).ContentObj.yNL.objectNonceId, ((TimeLineObject)localObject3).ContentObj.yNL.desc, "", "", "");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(99739);
                  return;
                }
                if (((TimeLineObject)localObject3).UserName == null)
                {
                  paramAnonymousView = "";
                  label2033:
                  com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramAnonymousView;
                  com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = ((TimeLineObject)localObject3).Id;
                  com.tencent.mm.plugin.expt.hellhound.a.aww("temp_6");
                  paramAnonymousView = (com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
                  localObject1 = ((TimeLineObject)localObject3).ContentObj.yNL.username;
                  if (((TimeLineObject)localObject3).ContentObj.yNL.liveStatus != 1) {
                    break label2247;
                  }
                }
                label2247:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView.report21053OnClick(l2, l1, (String)localObject1, -1, -1, 7L, "temp_6", i, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.deb(), com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm, System.currentTimeMillis(), 1);
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("key_enter_live_param_visitor_enter_scene", 2);
                  ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveVisitorUI(paramAnonymousView, bu.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject3).ContentObj.yNL.username, ((TimeLineObject)localObject3).ContentObj.yNL.objectNonceId, ((TimeLineObject)localObject3).ContentObj.yNL.desc, "", "", "", 4, "", 1, ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
                  break;
                  paramAnonymousView = ((TimeLineObject)localObject3).UserName;
                  break label2033;
                }
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
            }
            String str1 = ((TimeLineObject)localObject3).AppInfo.Id;
            String str2 = com.tencent.mm.plugin.sns.c.a.mIH.gY(str1);
            if (!Util.isNullOrNil(str2))
            {
              if (localObject3 == null)
              {
                paramAnonymousView = null;
                i = 2;
                if (((TimeLineObject)localObject3).ContentObj.Sqq != 1) {
                  break label2579;
                }
                i = 2;
              }
              for (;;)
              {
                localObject2 = null;
                localObject1 = localObject2;
                if (((TimeLineObject)localObject3).actionInfo != null)
                {
                  localObject1 = localObject2;
                  if (((TimeLineObject)localObject3).actionInfo.RFO != null) {
                    localObject1 = ((TimeLineObject)localObject3).actionInfo.RFO.RFI;
                  }
                }
                localObject2 = new sy();
                ((sy)localObject2).fSn.context = bu.this.context;
                ((sy)localObject2).fSn.scene = 4;
                ((sy)localObject2).fSn.appid = str1;
                ((sy)localObject2).fSn.packageName = str2;
                ((sy)localObject2).fSn.msgType = i;
                ((sy)localObject2).fSn.fLi = paramAnonymousView;
                ((sy)localObject2).fSn.mediaTagName = ((String)localObject1);
                ((sy)localObject2).fSn.fSo = 5;
                ((sy)localObject2).fSn.fNu = 0L;
                ((sy)localObject2).fSn.fSp = ((TimeLineObject)localObject3).Id;
                EventCenter.instance.publish((IEvent)localObject2);
                paramAnonymousView = new ji();
                paramAnonymousView.fGD.actionCode = 2;
                paramAnonymousView.fGD.scene = 3;
                paramAnonymousView.fGD.extMsg = "timeline_src=3";
                paramAnonymousView.fGD.appId = str1;
                paramAnonymousView.fGD.context = bu.this.context;
                EventCenter.instance.publish(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99739);
                return;
                paramAnonymousView = ((TimeLineObject)localObject3).UserName;
                break;
                label2579:
                if (((TimeLineObject)localObject3).ContentObj.Sqq == 3) {
                  i = 5;
                }
              }
            }
            paramAnonymousView = bu.this;
            paramAnonymousView = com.tencent.mm.plugin.sns.c.a.mIH.e(paramAnonymousView.context, str1, "timeline");
            if ((paramAnonymousView == null) || (paramAnonymousView.length() == 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("shortUrl", paramAnonymousView);
            ((Intent)localObject1).putExtra("useJs", true);
            ((Intent)localObject1).putExtra("type", -255);
            ((Intent)localObject1).putExtra("geta8key_scene", 2);
            com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject1, bu.this.context);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99739);
      }
    };
    this.Lfl = new bu.24(this);
    this.Lfm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99725);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99725);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        if (((TimeLineObject)localObject1).ContentObj.Sqr.size() > 0)
        {
          localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          localObject1 = ((cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0)).KCT;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_Product_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99725);
      }
    };
    this.Lfn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        Log.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        if (((TimeLineObject)localObject1).ContentObj.Sqr.size() > 0)
        {
          localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          localObject1 = ((cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0)).KCT;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_TV_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99726);
      }
    };
    this.Lfo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        if (((TimeLineObject)localObject1).ContentObj.Sqr.size() > 0)
        {
          localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          localObject1 = ((cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0)).KCT;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("preceding_scence", 10);
          ((Intent)localObject2).putExtra("download_entrance_scene", 13);
          com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99727);
      }
    };
    this.Lfp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99728);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99728);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        if (((TimeLineObject)localObject1).ContentObj.Sqr.size() > 0)
        {
          localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          localObject1 = ((cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0)).KCT;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99728);
      }
    };
    this.Lfq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        if (((TimeLineObject)localObject1).ContentObj.Sqr.size() > 0)
        {
          localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          localObject1 = ((cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0)).KCT;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99729);
      }
    };
    this.Lfr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        if (((TimeLineObject)localObject1).ContentObj.Sqr.size() > 0)
        {
          localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          localObject1 = ((cvt)((TimeLineObject)localObject1).ContentObj.Sqr.get(0)).KCT;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99730);
      }
    };
    this.Lfs = new bu.8(this);
    this.Lft = new bu.9(this);
    this.Lfu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202923);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(202923);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).KCX;
        localObject = aj.fOI().bbl(((s)localObject).fAg);
        if (bu.this.KCs != null) {
          bu.this.KCs.fOn().N((SnsInfo)localObject);
        }
        if (paramAnonymousView.weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(202923);
          return;
        }
        String str1 = paramAnonymousView.weappInfo.username;
        String str2 = paramAnonymousView.weappInfo.path;
        Log.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        xw localxw = new xw();
        localxw.fWN.userName = str1;
        localxw.fWN.fWP = str2;
        localxw.fWN.scene = 1009;
        localxw.fWN.fvd = (paramAnonymousView.Id + ":" + paramAnonymousView.UserName);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((SnsInfo)localObject).getUserName());
        paramAnonymousView.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject).field_snsId));
        EventCenter.instance.publish(localxw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202923);
      }
    };
    this.Lfv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199807);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199807);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).KCX;
        localObject2 = aj.fOI().bbl(((s)localObject2).fAg);
        if (bu.this.KCs != null) {
          bu.this.KCs.fOn().N((SnsInfo)localObject2);
        }
        if (((TimeLineObject)localObject1).weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199807);
          return;
        }
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.nYB = 6;
        localAppBrandLaunchReferrer.fXg = ((TimeLineObject)localObject1).weappInfo.fXg;
        Log.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { localAppBrandLaunchReferrer.nYC });
        localObject2 = new com.tencent.mm.plugin.appbrand.api.g();
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).username = ((TimeLineObject)localObject1).weappInfo.username;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).nBq = ((TimeLineObject)localObject1).weappInfo.path;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).cBU = ((TimeLineObject)localObject1).weappInfo.qbu;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).version = ((TimeLineObject)localObject1).weappInfo.version;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).nBA = ((TimeLineObject)localObject1).ContentObj.fwr;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).launchMode = 1;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).scene = 1154;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).fvd = ((TimeLineObject)localObject1).weappInfo.fvj;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).nBz = localAppBrandLaunchReferrer;
        if (((TimeLineObject)localObject1).weappInfo.UIw != null) {
          try
          {
            localObject1 = new com.tencent.mm.ad.f(((TimeLineObject)localObject1).weappInfo.UIw);
            ((com.tencent.mm.plugin.appbrand.api.g)localObject2).nBD = new ArrayList();
            int i = 0;
            while (i < ((com.tencent.mm.ad.f)localObject1).length())
            {
              ((com.tencent.mm.plugin.appbrand.api.g)localObject2).nBD.add(((com.tencent.mm.ad.f)localObject1).getString(i));
              i += 1;
            }
            ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramAnonymousView.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject2);
          }
          catch (com.tencent.mm.ad.g localg) {}
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199807);
      }
    };
    this.Lfw = new bu.13(this);
    this.Lfx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209878);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(209878);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).KCX;
        if (paramAnonymousView.ContentObj.Sqr.size() > 0)
        {
          localObject = aj.fOI().bbl(((s)localObject).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject);
          }
          paramAnonymousView = ((cvt)paramAnonymousView.ContentObj.Sqr.get(0)).KCT;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_scene", 2);
          ((Intent)localObject).putExtra("key_product_info", paramAnonymousView);
          com.tencent.mm.by.c.b(bu.this.context, "product", ".ui.MallProductUI", (Intent)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209878);
      }
    };
    this.Lfy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200236);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200236);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).KCX;
        String[] arrayOfString;
        if (paramAnonymousView.ContentObj.Sqr.size() > 0)
        {
          localObject = aj.fOI().bbl(((s)localObject).fAg);
          if (bu.this.KCs != null) {
            bu.this.KCs.fOn().N((SnsInfo)localObject);
          }
          paramAnonymousView = ((cvt)paramAnonymousView.ContentObj.Sqr.get(0)).KCT;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_from_scene", 12);
          if (TextUtils.isEmpty(paramAnonymousView)) {
            break label351;
          }
          arrayOfString = paramAnonymousView.split("#");
          if (arrayOfString.length < 2) {
            break label263;
          }
          Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
          ((Intent)localObject).putExtra("key_card_ext", arrayOfString[1]);
          com.tencent.mm.by.c.b(bu.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200236);
          return;
          label263:
          if (arrayOfString.length == 1)
          {
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramAnonymousView)));
            ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
            ((Intent)localObject).putExtra("key_card_ext", "");
            com.tencent.mm.by.c.b(bu.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
          }
          else
          {
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(paramAnonymousView)));
            continue;
            label351:
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
          }
        }
      }
    };
    this.Lfz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198964);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        hi localhi;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          if (locals.KCX.ContentObj.Sqq == 26)
          {
            if (Util.isNullOrNil(locals.KCX.ContentObj.Sqt))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198964);
              return;
            }
            localhi = new hi();
            localhi.fEb.type = 37;
            localhi.fEb.desc = locals.KCX.ContentObj.Sqt;
            localObject = "";
            paramAnonymousView = (View)localObject;
            if (locals.KCX.ContentObj.Sqr != null)
            {
              paramAnonymousView = (View)localObject;
              if (locals.KCX.ContentObj.Sqr.size() > 0)
              {
                paramAnonymousView = aq.kD(aj.getAccSnsPath(), ((cvt)locals.KCX.ContentObj.Sqr.get(0)).Id);
                localObject = com.tencent.mm.plugin.sns.data.t.d((cvt)locals.KCX.ContentObj.Sqr.get(0));
                if (!u.agG(paramAnonymousView + (String)localObject)) {
                  break label335;
                }
              }
            }
          }
        }
        label335:
        for (paramAnonymousView = paramAnonymousView + (String)localObject;; paramAnonymousView = "")
        {
          localhi.fEb.path = paramAnonymousView;
          localhi.fEb.title = locals.fAg;
          localhi.fEb.context = bu.this.context;
          EventCenter.instance.publish(localhi);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198964);
          return;
        }
      }
    };
    this.LfA = new bu.17(this);
    this.context = paramContext;
    this.Lfd = parama;
    this.source = paramInt;
    this.KCs = paramai;
    AppMethodBeat.o(99741);
  }
  
  public static String aO(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(99744);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(99744);
      return "";
    }
    try
    {
      paramString1 = (String)XmlParser.parseXml(paramString1, paramString2, null).get(paramString3);
      AppMethodBeat.o(99744);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.TimeLineClickEvent", "getXmlValueByTag exp=" + paramString1.toString());
      AppMethodBeat.o(99744);
    }
    return "";
  }
  
  protected static boolean aXq(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new nn();
    ((nn)localObject).fLT.action = -2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((nn)localObject).fLU.fLV;
    if ((localObject != null) && (com.tencent.mm.bb.a.e((com.tencent.mm.bb.f)localObject)) && (paramString.equals(((com.tencent.mm.bb.f)localObject).lVt)) && (com.tencent.mm.bb.a.bnx()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  protected static String bch(String paramString)
  {
    AppMethodBeat.i(99743);
    Log.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.mIH.V(paramString, "timeline");
    AppMethodBeat.o(99743);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void ezQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu
 * JD-Core Version:    0.7.0.1
 */