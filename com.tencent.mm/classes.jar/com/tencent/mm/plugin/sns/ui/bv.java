package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.autogen.a.ov;
import com.tencent.mm.autogen.a.ov.b;
import com.tencent.mm.autogen.a.un;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.oc;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.bi;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.plugin.findersdk.a.bi.b;
import com.tencent.mm.plugin.findersdk.a.bi.c;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.sns.ad.g.p;
import com.tencent.mm.plugin.sns.ad.g.p.a;
import com.tencent.mm.plugin.sns.ad.g.p.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONObject;

public final class bv
{
  public View.OnClickListener RFA;
  public View.OnClickListener RFB;
  public View.OnClickListener RFC;
  public View.OnClickListener RFD;
  public View.OnClickListener RFE;
  public View.OnClickListener RFF;
  public View.OnClickListener RFG;
  public View.OnClickListener RFH;
  public View.OnClickListener RFI;
  public View.OnClickListener RFJ;
  public View.OnClickListener RFK;
  public View.OnClickListener RFL;
  public View.OnClickListener RFM;
  private a RFp;
  public View.OnClickListener RFq;
  public View.OnClickListener RFr;
  public View.OnClickListener RFs;
  public View.OnClickListener RFt;
  public View.OnClickListener RFu;
  public View.OnClickListener RFv;
  public View.OnClickListener RFw;
  public View.OnClickListener RFx;
  public View.OnClickListener RFy;
  public View.OnClickListener RFz;
  ak Rca;
  public View.OnClickListener Rwb;
  Context context;
  long lastClickTime;
  int source;
  com.tencent.mm.ui.base.w tipDialog;
  
  public bv(Context paramContext, a parama, int paramInt, ak paramak)
  {
    AppMethodBeat.i(99741);
    this.source = 0;
    this.lastClickTime = 0L;
    this.Rwb = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        long l1 = System.currentTimeMillis();
        if (l1 - bv.this.lastClickTime < 500L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
        }
        bv.this.lastClickTime = l1;
        s locals;
        Object localObject5;
        final TimeLineObject localTimeLineObject;
        SnsInfo localSnsInfo;
        Object localObject6;
        Object localObject7;
        label378:
        int i;
        label584:
        Object localObject2;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          localObject5 = null;
          localTimeLineObject = locals.RcF;
          localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(locals.hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P(localSnsInfo);
          }
          if (localTimeLineObject.ContentObj.Zpq == 18)
          {
            paramAnonymousView = bv.this;
            localObject1 = bv.this.context;
            localObject5 = locals.RcF;
            localObject6 = locals.hES;
            localObject6 = com.tencent.mm.plugin.sns.model.al.hgB().aZL((String)localObject6);
            p.a(p.b.PXe, p.a.PWW, (SnsInfo)localObject6, paramAnonymousView.source);
            localObject6 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject5).ContentObj.Zpr.size() > 0) {
              paramAnonymousView = (dmz)((TimeLineObject)localObject5).ContentObj.Zpr.get(0);
            }
            ((Intent)localObject6).putExtra("KFromTimeLine", false);
            ((Intent)localObject6).putExtra("KStremVideoUrl", ((TimeLineObject)localObject5).ContentObj.Url);
            ((Intent)localObject6).putExtra("KSta_SourceType", 2);
            ((Intent)localObject6).putExtra("KSta_Scene", p.b.PXe.value);
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
                  ((Intent)localObject6).putExtra("KMediaVideoTime", paramAnonymousView.nTv);
                  ((Intent)localObject6).putExtra("StreamWording", paramAnonymousView.nTx);
                  ((Intent)localObject6).putExtra("StremWebUrl", paramAnonymousView.nTy);
                  ((Intent)localObject6).putExtra("KMediaTitle", paramAnonymousView.nTw);
                  ((Intent)localObject6).putExtra("KStremVideoUrl", paramAnonymousView.nTu);
                  ((Intent)localObject6).putExtra("KThumUrl", paramAnonymousView.nTz);
                  ((Intent)localObject6).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.nTA);
                  ((Intent)localObject6).putExtra("KSta_StremVideoPublishId", paramAnonymousView.nTB);
                }
                ((Intent)localObject6).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject5).statExtStr);
                if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHP, 0) <= 0) {
                  break label584;
                }
                com.tencent.mm.br.c.b((Context)localObject1, "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject6);
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
              com.tencent.mm.br.c.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject6);
            }
          }
          if ((localTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(localTimeLineObject.webSearchInfo.WoZ)))
          {
            localObject1 = bv.this;
            paramAnonymousView = localTimeLineObject.webSearchInfo;
            if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.WoZ)))
            {
              localObject5 = com.tencent.mm.plugin.topstory.a.g.a(paramAnonymousView, 31, com.tencent.mm.plugin.websearch.api.al.bix("discoverRecommendEntry").optString("wording"));
              aj.a(((bv)localObject1).context, (foe)localObject5);
              localObject1 = localTimeLineObject.UserName;
              localObject6 = localTimeLineObject.Id;
              localObject5 = new StringBuffer();
              ((StringBuffer)localObject5).append("isShareClick=1");
              ((StringBuffer)localObject5).append("&relevant_vid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.WoZ);
              ((StringBuffer)localObject5).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.Wpb);
              ((StringBuffer)localObject5).append("&relevant_shared_openid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.Wpc);
              ((StringBuffer)localObject5).append("&rec_category=");
              if (paramAnonymousView.Wpl <= 0L) {
                break label957;
              }
              ((StringBuffer)localObject5).append(paramAnonymousView.Wpl);
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
              ((StringBuffer)localObject5).append(paramAnonymousView.Wpa);
              Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject5).toString() });
              paramAnonymousView = new eqy();
              paramAnonymousView.abuE = ((StringBuffer)localObject5).toString();
              paramAnonymousView = new ae(paramAnonymousView);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              label957:
              ((StringBuffer)localObject5).append(paramAnonymousView.Wpd);
            }
          }
          long l2;
          if (localTimeLineObject.ContentObj.Zpq == 28)
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aXD(localTimeLineObject.ContentObj.hKU.objectId);
            l2 = localTimeLineObject.ContentObj.hKU.localId;
            if ((l1 != 0L) || (l2 != 0L))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("feed_object_id", l1);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.ContentObj.hKU.objectNonceId);
              paramAnonymousView.putExtra("business_type", 0);
              paramAnonymousView.putExtra("finder_user_name", localTimeLineObject.ContentObj.hKU.username);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("tab_type", 5);
              paramAnonymousView.putExtra("feed_local_id", l2);
              paramAnonymousView.putExtra("KEY_AUTHORIZATION_CONTENT", k.b.a(bv.f(localTimeLineObject.ContentObj.hKU), null, null));
              paramAnonymousView.putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", com.tencent.mm.plugin.sns.data.t.e(localTimeLineObject.ContentObj.hKU));
              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", localTimeLineObject.ContentObj.hKU.username);
              if ((l1 == 0L) && (l2 != 0L)) {
                paramAnonymousView.putExtra("key_posting_scene", true);
              }
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 25, paramAnonymousView);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(bv.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
            }
          }
          else if (localTimeLineObject.ContentObj.Zpq == 36)
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aXD(localTimeLineObject.ContentObj.Zpy.objectId);
            if (l1 != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("feed_object_id", l1);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.ContentObj.Zpy.objectNonceId);
              paramAnonymousView.putExtra("business_type", 1);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("tab_type", 5);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 53, paramAnonymousView);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(bv.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
          }
          if ((localTimeLineObject.ContentObj.Zpq == 34) || (localTimeLineObject.ContentObj.Zpq == 45) || (localTimeLineObject.ContentObj.Zpq == 43))
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aXD(localTimeLineObject.ContentObj.DHa.liveId);
            l2 = com.tencent.mm.plugin.sns.data.t.aXD(localTimeLineObject.ContentObj.DHa.feedId);
            if ((l1 != 0L) && (l2 != 0L))
            {
              if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramAnonymousView.findViewById(b.f.finder_live_icon), paramAnonymousView.findViewById(b.f.finder_live_end_tag), l1))
              {
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveReplayUI(null, bv.this.context, l2, l1, localTimeLineObject.ContentObj.DHa.username, localTimeLineObject.ContentObj.DHa.objectNonceId, localTimeLineObject.ContentObj.DHa.desc, "", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).reportFinderLiveReplay(l2, "share");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
                if (!Util.isEqual(z.bAW(), localTimeLineObject.ContentObj.DHa.username)) {
                  break;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", localTimeLineObject.ContentObj.DHa.sourceType);
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, bv.this.context, l2, Long.valueOf(l1), localTimeLineObject.ContentObj.DHa.objectNonceId, localTimeLineObject.ContentObj.DHa.desc, "", "", "");
              }
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("key_enter_live_param_visitor_enter_scene", 2);
              if (localTimeLineObject.ContentObj.DHa.ecSource == null) {}
              for (paramAnonymousView = "";; paramAnonymousView = localTimeLineObject.ContentObj.DHa.ecSource)
              {
                ((Intent)localObject1).putExtra("key_enter_live_param_ecsource", paramAnonymousView);
                paramAnonymousView = b.k.ahpq;
                ((Intent)localObject1).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWn());
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveVisitorUI((Intent)localObject1, bv.this.context, l2, Long.valueOf(l1), localTimeLineObject.ContentObj.DHa.username, localTimeLineObject.ContentObj.DHa.objectNonceId, localTimeLineObject.ContentObj.DHa.desc, "", "", "", 0, "", 1, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
                break;
              }
            }
          }
          if ((localTimeLineObject.ContentObj.Zpq == 29) && (localTimeLineObject.ContentObj.Zpv != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Zpv.topic);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Zpv.Auy);
            localObject1 = new boi();
            ((boi)localObject1).ZWG = localTimeLineObject.ContentObj.Zpv.aadc.ZWG;
            ((boi)localObject1).longitude = localTimeLineObject.ContentObj.Zpv.aadc.longitude;
            ((boi)localObject1).latitude = localTimeLineObject.ContentObj.Zpv.aadc.latitude;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((boi)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
              paramAnonymousView.putExtra("key_entrance_type", 0);
              if (localTimeLineObject.ContentObj.Zpv.Auy == 1)
              {
                i = 22;
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderTopicUI(bv.this.context, paramAnonymousView);
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
          if ((localTimeLineObject.ContentObj.Zpq == 37) && (localTimeLineObject.ContentObj.Zpv != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Zpv.topic);
            paramAnonymousView.putExtra("KEY_FOLLOW_ID", localTimeLineObject.ContentObj.Zpv.aadd);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Zpv.Auy);
            boi localboi = new boi();
            localboi.ZWG = localTimeLineObject.ContentObj.Zpv.aadc.ZWG;
            localboi.longitude = localTimeLineObject.ContentObj.Zpv.aadc.longitude;
            localboi.latitude = localTimeLineObject.ContentObj.Zpv.aadc.latitude;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", localboi.toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              switch (localTimeLineObject.ContentObj.Zpv.Auy)
              {
              case 3: 
              default: 
                i = 22;
                paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
                paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
                paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderTopicUI(bv.this.context, paramAnonymousView);
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
          if ((localTimeLineObject.ContentObj.Zpq == 38) && (localTimeLineObject.ContentObj.Zpx != null))
          {
            paramAnonymousView = localTimeLineObject.ContentObj.Zpx;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("TITLE_WORDING", paramAnonymousView.title);
            ((Intent)localObject2).putExtra("AUTO_REFRESH", true);
          }
        }
        try
        {
          ((Intent)localObject2).putExtra("FINDER_SHARE_ALBUM", paramAnonymousView.toByteArray());
          ((Intent)localObject2).putExtra("STREAM_CARD_BUFFER", paramAnonymousView.AEA.toByteArray());
          ((Intent)localObject2).putExtra("GET_REL_SCENE", 14);
          ((Intent)localObject2).putExtra("COMMENT_SCENE", 51);
          ((Intent)localObject2).putExtra("CARD_ID", com.tencent.mm.plugin.sns.data.t.aXD(paramAnonymousView.cardId));
          ((Intent)localObject2).putExtra("SHARED_USERNAME", localTimeLineObject.UserName);
          ((Intent)localObject2).putExtra("FROM_SHARE_SCENE", 3);
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterAlbumRelatedTimelineUI(bv.this.context, (Intent)localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
          if (localTimeLineObject.ContentObj.Zpq == 39) {}
          switch (localTimeLineObject.ContentObj.nUa)
          {
          default: 
            if ((localTimeLineObject.ContentObj.Zpq != 44) || (localTimeLineObject.ContentObj.ZpA == null)) {
              break label3911;
            }
            paramAnonymousView = new Intent();
            localObject2 = new fei();
            ((fei)localObject2).ZWG = localTimeLineObject.ContentObj.ZpA.ZWG;
            ((fei)localObject2).ZaG = Util.safeParseFloat(localTimeLineObject.ContentObj.ZpA.aada);
            ((fei)localObject2).ZaH = Util.safeParseFloat(localTimeLineObject.ContentObj.ZpA.aacZ);
            ((fei)localObject2).poiName = localTimeLineObject.ContentObj.ZpA.poiName;
            ((fei)localObject2).aaPM = localTimeLineObject.ContentObj.ZpA.XOv;
            ((fei)localObject2).ReU = localTimeLineObject.ContentObj.ZpA.oDI;
            ((fei)localObject2).aaPN = Util.safeParseInt(localTimeLineObject.ContentObj.ZpA.aadb);
            ((fei)localObject2).ReW = Util.safeParseInt(localTimeLineObject.ContentObj.ZpA.AXm);
            com.tencent.mm.plugin.report.service.h.OAn.p(((bi)com.tencent.mm.kernel.h.ax(bi.class)).ePz(), 1L, 1L);
            ((bi)com.tencent.mm.kernel.h.ax(bi.class)).a(bv.this.context, (fei)localObject2, bi.a.Hco, localTimeLineObject.Id, new bi.c()
            {
              public final void a(bi.b paramAnonymous2b)
              {
                AppMethodBeat.i(308516);
                int i;
                if (paramAnonymous2b == bi.b.Hcr) {
                  if (!Util.isNullOrNil(this.RFO.ZWG)) {
                    i = 1;
                  }
                }
                for (;;)
                {
                  if (i == 0)
                  {
                    paramAnonymousView.putExtra("map_view_type", 7);
                    paramAnonymousView.putExtra("kwebmap_slat", this.RFO.ZaH);
                    paramAnonymousView.putExtra("kwebmap_lng", this.RFO.ZaG);
                    paramAnonymousView.putExtra("kPoiName", this.RFO.poiName);
                    paramAnonymousView.putExtra("Kwebmap_locaion", this.RFO.ReU);
                    com.tencent.mm.br.c.b(bv.this.context, "location", ".ui.RedirectUI", paramAnonymousView);
                    AppMethodBeat.o(308516);
                    return;
                    i = 0;
                    continue;
                    if (paramAnonymous2b == bi.b.Hcv) {
                      i = 0;
                    }
                  }
                  else
                  {
                    if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("SnsPOICommentFeedNewUrlSwitch"), 0) == 0) {}
                    for (paramAnonymous2b = String.format(com.tencent.mm.protocal.d.Yxq, new Object[] { this.RFO.ZWG });; paramAnonymous2b = String.format(com.tencent.mm.protocal.d.Yxr, new Object[] { this.RFO.ZWG, localTimeLineObject.Id }))
                    {
                      paramAnonymousView.putExtra("rawUrl", paramAnonymous2b);
                      com.tencent.mm.plugin.sns.d.a.pFn.h(paramAnonymousView, bv.this.context);
                      AppMethodBeat.o(308516);
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
            if (localTimeLineObject.ContentObj.Zpv != null)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Zpv.topic);
              paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Zpv.Auy);
              localObject2 = new boi();
              ((boi)localObject2).ZWG = localTimeLineObject.ContentObj.Zpv.aadc.ZWG;
              ((boi)localObject2).longitude = localTimeLineObject.ContentObj.Zpv.aadc.longitude;
              ((boi)localObject2).latitude = localTimeLineObject.ContentObj.Zpv.aadc.latitude;
              try
              {
                paramAnonymousView.putExtra("key_topic_poi_location", ((boi)localObject2).toByteArray());
                paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
                paramAnonymousView.putExtra("key_report_scene", 3);
                paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
                UUID.randomUUID();
                paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
                paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
                paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
                if (localTimeLineObject.ContentObj.Zpv.Auy == 1)
                {
                  i = 22;
                  ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                  ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderTopicUI(bv.this.context, paramAnonymousView);
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
          paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Zpz.topic);
          paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Zpz.Auy);
          Object localObject3 = new boi();
          ((boi)localObject3).ZWG = localTimeLineObject.ContentObj.Zpz.aadc.ZWG;
          ((boi)localObject3).longitude = localTimeLineObject.ContentObj.Zpz.aadc.longitude;
          ((boi)localObject3).latitude = localTimeLineObject.ContentObj.Zpz.aadc.latitude;
          try
          {
            paramAnonymousView.putExtra("key_topic_poi_location", ((boi)localObject3).toByteArray());
            paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
            paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
            paramAnonymousView.putExtra("key_report_scene", 3);
            paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
            UUID.randomUUID();
            localObject3 = localTimeLineObject.ContentObj.Zpz.aade;
            paramAnonymousView.putExtra("key_activity_id", com.tencent.mm.ae.d.FK(((atg)localObject3).ZDJ));
            paramAnonymousView.putExtra("key_activity_name", ((atg)localObject3).ZDK);
            paramAnonymousView.putExtra("key_nick_name", ((atg)localObject3).ZDL);
            paramAnonymousView.putExtra("key_display_mask", ((atg)localObject3).FOi);
            paramAnonymousView.putExtra("key_cover_url", localTimeLineObject.ContentObj.Zpz.iconUrl);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 59, paramAnonymousView);
            paramAnonymousView.putExtra("key_activity_profile_src_type", "3");
            paramAnonymousView.putExtra("key_entrance_type", 0);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderActivityProfileUI(bv.this.context, paramAnonymousView);
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
          label3911:
          localObject4 = localObject5;
          if (!TextUtils.isEmpty(localTimeLineObject.canvasInfo))
          {
            localObject4 = localObject5;
            if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localTimeLineObject.canvasInfo))
            {
              localObject6 = bv.bg(localTimeLineObject.canvasInfo, "adxml", ".adxml.adActionLink");
              localObject4 = localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                localObject4 = bv.baN((String)localObject6);
              }
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject4 = bv.baN(localTimeLineObject.ContentObj.Url);
            if ((localObject4 == null) || (((String)localObject4).length() == 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
            int j = bv.this.Rca.getScene();
            localObject5 = localObject4;
            if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy((String)localObject4))
            {
              i = (int)(System.currentTimeMillis() / 1000L);
              localObject5 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject4, 2, j, i);
            }
            Intent localIntent = new Intent();
            if (localTimeLineObject != null)
            {
              localObject6 = new Bundle();
              ((Bundle)localObject6).putString("KSnsStrId", localTimeLineObject.Id);
              ((Bundle)localObject6).putString("KSnsLocalId", locals.hES);
              ((Bundle)localObject6).putBoolean("KFromTimeline", true);
              localObject4 = localObject6;
              if (localTimeLineObject.ContentObj != null)
              {
                localObject4 = localObject6;
                if (localTimeLineObject.ContentObj.Zpr.size() > 0)
                {
                  ((Bundle)localObject6).putString("K_sns_thumb_url", ((dmz)localTimeLineObject.ContentObj.Zpr.get(0)).aaTl);
                  ((Bundle)localObject6).putString("K_sns_raw_url", localTimeLineObject.ContentObj.Url);
                  Log.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((dmz)localTimeLineObject.ContentObj.Zpr.get(0)).aaTl, localTimeLineObject.ContentObj.Url });
                  localObject4 = localObject6;
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
              localIntent.putExtra("sns_local_id", locals.hES);
              if (localSnsInfo != null)
              {
                localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.uA(localSnsInfo.field_snsId));
                localIntent.putExtra("pre_username", localSnsInfo.field_userName);
                localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.uA(localSnsInfo.field_snsId));
                localIntent.putExtra("preUsername", localSnsInfo.field_userName);
                localIntent.putExtra("share_report_pre_msg_url", (String)localObject5);
                localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.ContentObj.hAP);
                localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.ContentObj.IGG);
                if ((localTimeLineObject.ContentObj.Zpr != null) && (localTimeLineObject.ContentObj.Zpr.size() > 0))
                {
                  localObject6 = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
                  localIntent.putExtra("share_report_pre_msg_icon_url", ((dmz)localObject6).aaTl);
                  localIntent.putExtra("thumbUrl", ((dmz)localObject6).aaTl);
                }
                localIntent.putExtra("share_report_pre_msg_appid", "");
                localIntent.putExtra("share_report_from_scene", 1);
              }
              if ((localTimeLineObject != null) && (localTimeLineObject.AppInfo != null)) {
                localIntent.putExtra("KAppId", localTimeLineObject.AppInfo.Id);
              }
              if ((localSnsInfo != null) && (localSnsInfo.isAd()))
              {
                if (bv.this.source != 2) {
                  break label5391;
                }
                localObject6 = localSnsInfo.getAtAdInfo();
                if (localObject6 != null) {
                  localIntent.putExtra("KsnsViewId", ((ADInfo)localObject6).viewId);
                }
              }
              if ((localSnsInfo != null) && (localTimeLineObject != null))
              {
                if (bv.this.source != 0) {
                  break label5401;
                }
                localObject6 = com.tencent.mm.modelsns.l.wO(718);
                label4765:
                com.tencent.mm.modelsns.l locall = ((com.tencent.mm.modelsns.l)localObject6).Ph(com.tencent.mm.plugin.sns.data.t.x(localSnsInfo)).wR(localSnsInfo.field_type).hm(localSnsInfo.isAd()).Ph(localSnsInfo.getUxinfo()).Ph(localTimeLineObject.publicUserName);
                if (localTimeLineObject.AppInfo != null) {
                  break label5412;
                }
                localObject7 = "";
                label4822:
                locall.Ph((String)localObject7).Ph(localTimeLineObject.ContentObj.Url);
                ((com.tencent.mm.modelsns.l)localObject6).bMH();
                if (bv.this.source != 0) {
                  break label5425;
                }
                localObject6 = com.tencent.mm.modelsns.l.wO(743);
                label4865:
                locall = ((com.tencent.mm.modelsns.l)localObject6).Ph(com.tencent.mm.plugin.sns.data.t.x(localSnsInfo)).wR(localSnsInfo.field_type).hm(localSnsInfo.isAd()).Ph(localSnsInfo.getUxinfo()).Ph(localTimeLineObject.publicUserName);
                if (localTimeLineObject.AppInfo != null) {
                  break label5436;
                }
                localObject7 = "";
                label4922:
                locall.Ph((String)localObject7).Ph(localTimeLineObject.ContentObj.Url);
                if (localObject4 != null)
                {
                  localObject6 = ((com.tencent.mm.modelsns.l)localObject6).bGl();
                  if (localObject6 != null) {
                    ((Bundle)localObject4).putByteArray("intent_key_StatisticsOplog", (byte[])localObject6);
                  }
                }
              }
              if (localObject4 != null) {
                localIntent.putExtra("jsapiargs", (Bundle)localObject4);
              }
              localIntent.putExtra("geta8key_scene", 2);
              localIntent.putExtra("KMsgType", 2);
              localIntent.putExtra("from_scence", 3);
              if ((localTimeLineObject.ContentObj.Zpu != null) && (localTimeLineObject.ContentObj.Zpu.nUA != -1)) {
                localIntent.putExtra(f.s.adwW, localTimeLineObject.ContentObj.Zpu.nUA);
              }
              if ((!Util.isNullOrNil(localTimeLineObject.canvasInfo)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localTimeLineObject.canvasInfo)) && (localSnsInfo != null))
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
                  localObject4 = localTimeLineObject.ContentObj.Zpr;
                  if (((List)localObject4).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((dmz)((List)localObject4).get(0)).aaTl);
                  }
                }
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
                paramAnonymousView.putExtra("sns_landing_pages_aid", localSnsInfo.getAid());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localSnsInfo.getTraceid());
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
                if (bv.this.source == 0) {}
                for (i = 3;; i = 4)
                {
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.setClass(bv.this.context, SnsAdNativeLandingPagesUI.class);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.canvasInfo);
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.x(paramAnonymousView, bv.this.context);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(99724);
                  return;
                  label5391:
                  localObject6 = localSnsInfo.getAdInfo();
                  break;
                  label5401:
                  localObject6 = com.tencent.mm.modelsns.l.wP(718);
                  break label4765;
                  label5412:
                  localObject7 = localTimeLineObject.AppInfo.Id;
                  break label4822;
                  label5425:
                  localObject6 = com.tencent.mm.modelsns.l.wP(743);
                  break label4865;
                  label5436:
                  localObject7 = localTimeLineObject.AppInfo.Id;
                  break label4922;
                }
              }
              localIntent.putExtra("webpageTitle", localTimeLineObject.ContentObj.hAP);
              localIntent.putExtra("key_enable_teen_mode_check", true);
              localIntent.putExtra("msgUsername", localTimeLineObject.UserName);
              localIntent.putExtra("serverMsgID", localTimeLineObject.Id);
              localIntent.addFlags(536870912);
              if (localTimeLineObject.ContentObj.Zpu != null)
              {
                i = localTimeLineObject.ContentObj.Zpu.nUA;
                if ((!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(4)) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(bv.this.context, (String)localObject5, i, 2, j, localIntent))) {
                  break label5924;
                }
                Log.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
                label5599:
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
                localObject6 = com.tencent.mm.plugin.sns.d.a.pFo.X(paramAnonymousView, i);
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
                      if (localTimeLineObject.actionInfo.YCC != null) {
                        localObject4 = localTimeLineObject.actionInfo.YCC.YCm;
                      }
                    }
                  }
                  if (localTimeLineObject != null) {
                    break label5944;
                  }
                  localObject5 = null;
                  label5729:
                  com.tencent.mm.plugin.sns.d.a.pFo.a(bv.this.context, paramAnonymousView, (String)localObject6, (String)localObject5, 5, 4, 1, (String)localObject4, localTimeLineObject.Id);
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(11105, new Object[] { localTimeLineObject.UserName, localTimeLineObject.ContentObj.Url });
                if ((localSnsInfo != null) && ((localSnsInfo.field_type == 4) || (localSnsInfo.field_type == 42)))
                {
                  paramAnonymousView = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
                  localObject4 = com.tencent.mm.plugin.report.service.h.OAn;
                  if (paramAnonymousView != null) {
                    break label5954;
                  }
                }
              }
              label5924:
              label5944:
              label5954:
              for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.IGG)
              {
                ((com.tencent.mm.plugin.report.service.h)localObject4).b(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.AppInfo.Id });
                bv.a(localTimeLineObject, locals.hES);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
                i = -1;
                break;
                com.tencent.mm.plugin.sns.d.a.pFn.h(localIntent, bv.this.context);
                break label5599;
                localObject5 = localTimeLineObject.UserName;
                break label5729;
              }
            }
          }
        }
        catch (IOException localIOException5)
        {
          for (;;)
          {
            continue;
            Object localObject4 = null;
          }
        }
      }
    };
    this.RFq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99731);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof al)))
        {
          localObject1 = ((al)paramAnonymousView.getTag()).RcF;
          Object localObject2 = ((al)paramAnonymousView.getTag()).RfD;
          if ((localObject1 != null) && (((TimeLineObject)localObject1).ContentObj != null) && (((TimeLineObject)localObject1).ContentObj.Zpw != null) && (localObject2 != null) && (((WeakReference)localObject2).get() != null))
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
            com.tencent.mm.modelsns.i.a(paramAnonymousView.getContext(), ((TimeLineObject)localObject1).ContentObj.Zpw, localRect);
          }
          bv.a((TimeLineObject)localObject1, ((al)paramAnonymousView.getTag()).hES);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99731);
      }
    };
    this.RFr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99734);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          if ((paramAnonymousView.ContentObj == null) || (paramAnonymousView.ContentObj.hKU == null)) {
            break label583;
          }
          l1 = com.tencent.mm.plugin.sns.data.t.aXD(paramAnonymousView.ContentObj.hKU.objectId);
          long l2 = paramAnonymousView.ContentObj.hKU.localId;
          if ((l1 != 0L) || (l2 != 0L))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("report_scene", 3);
            ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("feed_object_id", l1);
            ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.hKU.objectNonceId);
            ((Intent)localObject).putExtra("business_type", 0);
            ((Intent)localObject).putExtra("finder_user_name", paramAnonymousView.ContentObj.hKU.username);
            ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("tab_type", 5);
            ((Intent)localObject).putExtra("key_comment_scene", 38);
            ((Intent)localObject).putExtra("feed_local_id", l2);
            ((Intent)localObject).putExtra("KEY_AUTHORIZATION_CONTENT", k.b.a(bv.f(paramAnonymousView.ContentObj.hKU), null, null));
            ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
            ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", com.tencent.mm.plugin.sns.data.t.e(paramAnonymousView.ContentObj.hKU));
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.hKU.username);
            if ((l1 == 0L) && (l2 != 0L)) {
              ((Intent)localObject).putExtra("key_posting_scene", true);
            }
            bq localbq = (bq)com.tencent.mm.kernel.h.ax(bq.class);
            if ((!localbq.ecY()) || (!localbq.bZX())) {
              break label538;
            }
            ((Intent)localObject).putExtra("KEY_OBJECT_ID", com.tencent.mm.ae.d.FK(paramAnonymousView.ContentObj.hKU.objectId));
            ((Intent)localObject).putExtra("KEY_OBJECT_NONCE_ID", paramAnonymousView.ContentObj.hKU.objectNonceId);
            ((Intent)localObject).putExtra("FROM_SCENE_KEY", 6);
            ((Intent)localObject).putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 20, (Intent)localObject);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderTimelineUI(bv.this.context, (Intent)localObject);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99734);
          return;
          label538:
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(bv.this.context, (Intent)localObject);
          continue;
          label583:
          if ((paramAnonymousView.ContentObj != null) && (paramAnonymousView.ContentObj.Zpy != null))
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aXD(paramAnonymousView.ContentObj.Zpy.objectId);
            if (l1 != 0L)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("report_scene", 3);
              ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("feed_object_id", l1);
              ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.Zpy.objectNonceId);
              ((Intent)localObject).putExtra("business_type", 1);
              ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("tab_type", 5);
              ((Intent)localObject).putExtra("key_comment_scene", 53);
              ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramAnonymousView.ContentObj.Zpy.nickname);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.Zpy.username);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(bv.this.context, (Intent)localObject);
            }
          }
        }
      }
    };
    this.RFs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99735);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        long l1;
        long l2;
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          localObject = (TimeLineObject)paramAnonymousView.getTag();
          l1 = com.tencent.mm.plugin.sns.data.t.aXD(((TimeLineObject)localObject).ContentObj.DHa.liveId);
          l2 = com.tencent.mm.plugin.sns.data.t.aXD(((TimeLineObject)localObject).ContentObj.DHa.feedId);
          if ((l1 != 0L) && (l2 != 0L)) {
            if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramAnonymousView.findViewById(b.f.finder_live_icon), paramAnonymousView.findViewById(b.f.finder_live_end_tag), l1))
            {
              ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveReplayUI(null, bv.this.context, l2, l1, ((TimeLineObject)localObject).ContentObj.DHa.username, ((TimeLineObject)localObject).ContentObj.DHa.objectNonceId, ((TimeLineObject)localObject).ContentObj.DHa.desc, "", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).reportFinderLiveReplay(l2, "share");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99735);
          return;
          if (Util.isEqual(z.bAW(), ((TimeLineObject)localObject).ContentObj.DHa.username))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", ((TimeLineObject)localObject).ContentObj.DHa.sourceType);
            ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, bv.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject).ContentObj.DHa.objectNonceId, ((TimeLineObject)localObject).ContentObj.DHa.desc, "", "", "");
            continue;
          }
          label370:
          String str;
          int i;
          label426:
          Intent localIntent;
          if (((TimeLineObject)localObject).UserName == null)
          {
            paramAnonymousView = "";
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramAnonymousView;
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = ((TimeLineObject)localObject).Id;
            com.tencent.mm.plugin.expt.hellhound.a.aqz("temp_6");
            paramAnonymousView = (cn)com.tencent.mm.kernel.h.az(cn.class);
            str = ((TimeLineObject)localObject).ContentObj.DHa.username;
            if (((TimeLineObject)localObject).ContentObj.DHa.liveStatus != 1) {
              break label878;
            }
            i = 1;
            paramAnonymousView.report21053OnClick(l2, l1, str, -1, -1, 7L, "temp_6", i, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKk(), com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr, System.currentTimeMillis(), 1);
            str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(4, 2, 65);
            localIntent = new Intent();
            localIntent.putExtra("key_enter_live_param_share_username", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq);
            localIntent.putExtra("key_enter_live_param_from_share_scene", 0);
            localIntent.putExtra("key_enter_live_param_visitor_enter_scene", 2);
            if (((TimeLineObject)localObject).ContentObj.DHa.ecSource != null) {
              break label883;
            }
            paramAnonymousView = "";
            label533:
            localIntent.putExtra("key_enter_live_param_ecsource", paramAnonymousView);
            int j = 0;
            i = j;
            if (((TimeLineObject)localObject).ContentObj.DHa.ZVq != null)
            {
              i = j;
              if (!((TimeLineObject)localObject).ContentObj.DHa.ZVq.isEmpty())
              {
                i = j;
                if (Objects.equals(((TimeLineObject)localObject).ContentObj.DHa.eventId, "1"))
                {
                  paramAnonymousView = new brs();
                  paramAnonymousView.ZVq = ((TimeLineObject)localObject).ContentObj.DHa.ZVq;
                  paramAnonymousView.ZVp = ((TimeLineObject)localObject).ContentObj.DHa.ZVp;
                  paramAnonymousView.ZVs = ((TimeLineObject)localObject).ContentObj.DHa.ZVs;
                  paramAnonymousView.ZVr = ((TimeLineObject)localObject).ContentObj.DHa.ZVr;
                  i = 1;
                }
              }
            }
          }
          try
          {
            localIntent.putExtra("KEY_ENTER_LIVE_PARAM_OLYMPIC_FIRE_AUTHOR_INFO", paramAnonymousView.toByteArray());
            label684:
            paramAnonymousView = b.k.ahpq;
            localIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWn());
            dwa localdwa;
            if (!Util.isNullOrNil(((TimeLineObject)localObject).ContentObj.DHa.eventId))
            {
              localdwa = new dwa();
              paramAnonymousView = b.e.ahon;
              localdwa.abbK = b.e.a.jWc();
              if (((TimeLineObject)localObject).UserName != null) {
                break label898;
              }
            }
            label898:
            for (paramAnonymousView = "";; paramAnonymousView = ((TimeLineObject)localObject).UserName)
            {
              localdwa.hLv = paramAnonymousView;
              localdwa.abbL = i;
              ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).initOlympicsReport(localdwa);
              ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveVisitorUI(localIntent, bv.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject).ContentObj.DHa.username, ((TimeLineObject)localObject).ContentObj.DHa.objectNonceId, ((TimeLineObject)localObject).ContentObj.DHa.desc, str, "", "", 0, "", 1, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              break;
              paramAnonymousView = ((TimeLineObject)localObject).UserName;
              break label370;
              label878:
              i = 2;
              break label426;
              label883:
              paramAnonymousView = ((TimeLineObject)localObject).ContentObj.DHa.ecSource;
              break label533;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99735);
            return;
          }
          catch (IOException paramAnonymousView)
          {
            break label684;
          }
        }
      }
    };
    this.RFt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99736);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof s)))
        {
          if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).canEnterMvAndShowToast())
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99736);
            return;
          }
          TimeLineObject localTimeLineObject = ((s)paramAnonymousView.getTag()).RcF;
          int i = ((s)paramAnonymousView.getTag()).nSq;
          boolean bool1;
          if (localTimeLineObject.ContentObj.Zpq == 42) {
            bool1 = true;
          }
          for (;;)
          {
            boolean bool2 = bool1;
            if (!bool1)
            {
              bool2 = bool1;
              if (localTimeLineObject.AppInfo != null)
              {
                if (localTimeLineObject.ContentObj.Zpq != 4) {
                  break label725;
                }
                localObject = com.tencent.mm.plugin.comm.a.xeG;
                if (!com.tencent.mm.plugin.comm.a.aml(localTimeLineObject.AppInfo.Id)) {
                  break label725;
                }
                bool2 = true;
              }
            }
            label182:
            int j = localTimeLineObject.ContentObj.Zpq;
            if (localTimeLineObject.AppInfo == null)
            {
              localObject = "";
              label203:
              Log.i("MicroMsg.TimeLineClickEvent", "canEnterMv:%b, type:%d, appId:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(j), localObject });
              if (!bool2) {
                break label778;
              }
              if (!bv.aUY(localTimeLineObject.Id))
              {
                if (localTimeLineObject.ContentObj == null) {
                  break label744;
                }
                paramAnonymousView = localTimeLineObject.ContentObj.oPb;
                if (paramAnonymousView == null) {}
              }
            }
            try
            {
              localObject = new dtj();
              ((dtj)localObject).parseFrom(paramAnonymousView.toByteArray());
              com.tencent.mm.aw.a.c(com.tencent.mm.aw.i.a(com.tencent.mm.plugin.sns.model.al.getAccPath(), localTimeLineObject, 1, com.tencent.mm.aw.h.a(localTimeLineObject.Id, (dtj)localObject)));
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_scene", 7);
              if (!localTimeLineObject.ContentObj.Zpr.isEmpty())
              {
                localObject = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
                if (localObject != null)
                {
                  paramAnonymousView.putExtra("key_mv_song_name", ((dmz)localObject).hAP);
                  paramAnonymousView.putExtra("key_mv_song_lyric", ((dmz)localObject).songLyric);
                  paramAnonymousView.putExtra("key_mv_album_cover_url", ((dmz)localObject).songAlbumUrl);
                }
              }
              if (localTimeLineObject.ContentObj.oPb != null)
              {
                localObject = localTimeLineObject.ContentObj.oPb;
                paramAnonymousView.putExtra("key_mv_feed_id", ((dtj)localObject).YqN);
                paramAnonymousView.putExtra("key_mv_nonce_id", ((dtj)localObject).YqO);
                paramAnonymousView.putExtra("key_mv_cover_url", ((dtj)localObject).YqP);
                paramAnonymousView.putExtra("key_mv_poster", ((dtj)localObject).YqQ);
                paramAnonymousView.putExtra("key_mv_singer_name", ((dtj)localObject).singerName);
                paramAnonymousView.putExtra("key_mv_album_name", ((dtj)localObject).albumName);
                paramAnonymousView.putExtra("key_mv_music_genre", ((dtj)localObject).musicGenre);
                paramAnonymousView.putExtra("key_mv_issue_date", String.valueOf(((dtj)localObject).issueDate));
                paramAnonymousView.putExtra("key_mv_identification", ((dtj)localObject).identification);
                paramAnonymousView.putExtra("key_mv_extra_info", ((dtj)localObject).extraInfo);
                paramAnonymousView.putExtra("key_mv_music_duration", ((dtj)localObject).LNC);
                paramAnonymousView.putExtra("key_mv_thumb_path", ((dtj)localObject).oPc);
                paramAnonymousView.putExtra("key_mv_music_operation_url", ((dtj)localObject).musicOperationUrl);
                paramAnonymousView.putExtra("key_mv_song_mid", ((dtj)localObject).oOZ);
              }
              paramAnonymousView.setFlags(268435456);
              localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
              localObject = (dtk)a.a.a(bv.this.context, "MusicMvMainUI", 7, dtk.class);
              ((dtk)localObject).scene = 1;
              if (i == 2) {
                ((dtk)localObject).scene = 17;
              }
              com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.xeG;
              ((dtk)localObject).zIO = com.tencent.mm.plugin.comm.a.dsT();
              ((dtk)localObject).aaYP = 85;
              ((dtk)localObject).aaYQ = localTimeLineObject.Id;
              com.tencent.mm.br.c.b(bv.this.context, "mv", ".ui.MusicMvMainUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99736);
              return;
              bool1 = false;
              continue;
              label725:
              bool2 = false;
              break label182;
              localObject = localTimeLineObject.AppInfo.Id;
              break label203;
              label744:
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
          label778:
          bv.a(localTimeLineObject, ((s)paramAnonymousView.getTag()).hES);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99736);
      }
    };
    this.RFu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99737);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof bz)))
        {
          paramAnonymousView = (bz)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            localObject1 = new Intent(bv.this.context, SnsWsFoldDetailUI.class);
            ((Intent)localObject1).putExtra("key_ws_group_id", paramAnonymousView.REO);
            ((Intent)localObject1).putExtra("key_ws_detail_max_id", paramAnonymousView.maxId);
            ((Intent)localObject1).putExtra("key_ws_detail_min_id", paramAnonymousView.Qsh);
            ((Intent)localObject1).putExtra("key_ws_detail_username", paramAnonymousView.username);
            Object localObject2 = new ArrayList();
            Iterator localIterator = paramAnonymousView.idList.iterator();
            while (localIterator.hasNext()) {
              ((ArrayList)localObject2).add(com.tencent.mm.plugin.sns.data.t.uB(((Long)localIterator.next()).longValue()));
            }
            ((Intent)localObject1).putStringArrayListExtra("key_ws_str_sns_id_list", (ArrayList)localObject2);
            localObject2 = bv.this.context;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            j.QFS.a(paramAnonymousView.idList, paramAnonymousView.REO, paramAnonymousView.username);
            localObject1 = j.QFS;
            long l = paramAnonymousView.REO;
            paramAnonymousView = (oc)((j)localObject1).QGO.get(Long.valueOf(l));
            if (paramAnonymousView != null) {
              paramAnonymousView.jir = 1;
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
      }
    };
    this.RFv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99738);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        long l1;
        bq localbq;
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99738);
            return;
          }
          paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
          if ((paramAnonymousView.ContentObj == null) || (paramAnonymousView.ContentObj.hKU == null)) {
            break label573;
          }
          l1 = com.tencent.mm.plugin.sns.data.t.aXD(paramAnonymousView.ContentObj.hKU.objectId);
          long l2 = paramAnonymousView.ContentObj.hKU.localId;
          if ((l1 != 0L) || (l2 != 0L))
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("report_scene", 3);
            ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("feed_object_id", l1);
            ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.hKU.objectNonceId);
            ((Intent)localObject).putExtra("business_type", 0);
            ((Intent)localObject).putExtra("finder_user_name", paramAnonymousView.ContentObj.hKU.username);
            ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
            ((Intent)localObject).putExtra("tab_type", 5);
            ((Intent)localObject).putExtra("feed_local_id", l2);
            ((Intent)localObject).putExtra("KEY_AUTHORIZATION_CONTENT", k.b.a(bv.f(paramAnonymousView.ContentObj.hKU), null, null));
            ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
            ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", com.tencent.mm.plugin.sns.data.t.e(paramAnonymousView.ContentObj.hKU));
            ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.hKU.username);
            if ((l1 == 0L) && (l2 != 0L)) {
              ((Intent)localObject).putExtra("key_posting_scene", true);
            }
            localbq = (bq)com.tencent.mm.kernel.h.ax(bq.class);
            if ((!localbq.ecY()) || (!localbq.bZX())) {
              break label528;
            }
            ((Intent)localObject).putExtra("KEY_OBJECT_ID", com.tencent.mm.ae.d.FK(paramAnonymousView.ContentObj.hKU.objectId));
            ((Intent)localObject).putExtra("KEY_OBJECT_NONCE_ID", paramAnonymousView.ContentObj.hKU.objectNonceId);
            ((Intent)localObject).putExtra("FROM_SCENE_KEY", 6);
            ((Intent)localObject).putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 20, (Intent)localObject);
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderTimelineUI(bv.this.context, (Intent)localObject);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99738);
          return;
          label528:
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 38, (Intent)localObject);
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(bv.this.context, (Intent)localObject);
          continue;
          label573:
          if ((paramAnonymousView.ContentObj != null) && (paramAnonymousView.ContentObj.Zpy != null))
          {
            l1 = com.tencent.mm.plugin.sns.data.t.aXD(paramAnonymousView.ContentObj.Zpy.objectId);
            if (l1 != 0L)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("report_scene", 3);
              ((Intent)localObject).putExtra("from_user", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("feed_object_id", l1);
              ((Intent)localObject).putExtra("feed_object_nonceId", paramAnonymousView.ContentObj.Zpy.objectNonceId);
              ((Intent)localObject).putExtra("business_type", 1);
              ((Intent)localObject).putExtra("key_from_user_name", paramAnonymousView.UserName);
              ((Intent)localObject).putExtra("tab_type", 5);
              ((Intent)localObject).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              ((Intent)localObject).putExtra("key_finder_teen_mode_scene", 3);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_name", paramAnonymousView.ContentObj.Zpy.nickname);
              ((Intent)localObject).putExtra("key_finder_teen_mode_user_id", paramAnonymousView.ContentObj.Zpy.username);
              localbq = (bq)com.tencent.mm.kernel.h.ax(bq.class);
              if ((localbq.ecY()) && (localbq.bZX()))
              {
                ((Intent)localObject).putExtra("KEY_OBJECT_ID", com.tencent.mm.ae.d.FK(paramAnonymousView.ContentObj.hKU.objectId));
                ((Intent)localObject).putExtra("KEY_OBJECT_NONCE_ID", paramAnonymousView.ContentObj.hKU.objectNonceId);
                ((Intent)localObject).putExtra("FROM_SCENE_KEY", 6);
                ((Intent)localObject).putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 20, (Intent)localObject);
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderTimelineUI(bv.this.context, (Intent)localObject);
              }
              else
              {
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 53, (Intent)localObject);
                ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(bv.this.context, (Intent)localObject);
              }
            }
          }
        }
      }
    };
    this.RFw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99739);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Object localObject2 = bv.this;
        int i;
        Object localObject3;
        if ((paramAnonymousView == null) || (!(paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          i = 1;
          if (i != 0) {
            break label3160;
          }
          if ((paramAnonymousView == null) || (!(paramAnonymousView.getTag() instanceof TimeLineObject)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
          }
        }
        else
        {
          localObject1 = (TimeLineObject)paramAnonymousView.getTag();
          localObject3 = ((TimeLineObject)localObject1).AppInfo.Id;
          if ((localObject1 == null) || (((TimeLineObject)localObject1).ContentObj == null) || (((TimeLineObject)localObject1).ContentObj.oPb == null)) {
            break label3178;
          }
        }
        label2469:
        label3013:
        label3160:
        label3178:
        for (localObject1 = ((TimeLineObject)localObject1).ContentObj.oPb.YqY;; localObject1 = "")
        {
          if (("wx485a97c844086dc9".equals(localObject3)) || ("wx485a97c844086dc9".equals(localObject1)))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("shake_music", true);
            ((Intent)localObject1).putExtra("enter_from_scene", 2);
            com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
            i = 1;
            break;
          }
          if ("wx7fa037cc7dfabad5".equals(localObject3))
          {
            com.tencent.mm.plugin.sport.a.d.rG(34);
            com.tencent.mm.kernel.h.baF();
            if (com.tencent.mm.contact.d.rs(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_43f2581f6fd6").field_type))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Chat_User", "gh_43f2581f6fd6");
              ((Intent)localObject1).putExtra("finish_direct", true);
              com.tencent.mm.br.c.g(((bv)localObject2).context, ".ui.chatting.ChattingUI", (Intent)localObject1);
            }
            for (;;)
            {
              i = 1;
              break;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Contact_User", "gh_43f2581f6fd6");
              com.tencent.mm.br.c.b(((bv)localObject2).context, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
            }
          }
          if (("wx9181ed3f223e6d76".equals(localObject3)) || ("wx2fe12a395c426fcf".equals(localObject3)))
          {
            Log.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("shake_tv", true);
            ((Intent)localObject1).putExtra("enter_from_scene", 2);
            com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
            i = 1;
            break;
          }
          if ("wxfbc915ff7c30e335".equals(localObject3))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("BaseScanUI_select_scan_mode", 1);
            if ((!com.tencent.mm.n.a.p(((bv)localObject2).context, true)) && (!com.tencent.mm.n.a.dl(((bv)localObject2).context)) && (!com.tencent.mm.n.a.dp(((bv)localObject2).context))) {
              com.tencent.mm.br.c.b(((bv)localObject2).context, "scanner", ".ui.BaseScanUI", (Intent)localObject1);
            }
            i = 1;
            break;
          }
          if ("wxaf060266bfa9a35c".equals(localObject3))
          {
            if (!com.tencent.mm.aw.e.bLs())
            {
              i = 1;
              break;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("shake_tv", true);
            ((Intent)localObject1).putExtra("enter_from_scene", 2);
            com.tencent.mm.br.c.b(((bv)localObject2).context, "shake", ".ui.ShakeReportUI", (Intent)localObject1);
            i = 1;
            break;
          }
          i = 0;
          break;
          if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
            return;
          }
          localObject3 = (TimeLineObject)paramAnonymousView.getTag();
          if (Tiger2022Helper.a(paramAnonymousView.getContext(), (TimeLineObject)localObject3))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
            return;
          }
          if ((localObject3 == null) || (((TimeLineObject)localObject3).AppInfo == null))
          {
            Log.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
            return;
          }
          if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Zpq == 28) && (((TimeLineObject)localObject3).ContentObj.hKU != null))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("key_from_profile_share_scene", 3);
            ((Intent)localObject2).putExtra("key_enter_profile_type", 8);
            ((Intent)localObject2).putExtra("key_from_comment_scene", 37);
            if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.hKU.username))
            {
              ((Intent)localObject2).putExtra("finder_username", "");
              ((Intent)localObject2).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.hKU.objectId);
              ((Intent)localObject2).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.hKU.objectNonceId);
            }
            for (;;)
            {
              ((Intent)localObject2).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 3);
              ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", com.tencent.mm.plugin.sns.data.t.e(((TimeLineObject)localObject3).ContentObj.hKU));
              ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.hKU.username);
              localObject1 = ((TimeLineObject)localObject3).ContentObj.hKU.hUQ;
              if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.hKU.aacW)) {
                localObject1 = ((TimeLineObject)localObject3).ContentObj.hKU.aacW;
              }
              ((Intent)localObject2).putExtra("key_biz_username", (String)localObject1);
              localObject1 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN());
              str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
              str2 = ((TimeLineObject)localObject3).ContentObj.hKU.objectId;
              localObject3 = ((TimeLineObject)localObject3).Id;
              localObject1 = (String)localObject1 + "," + str1 + "," + str2 + "," + (String)localObject3;
              Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject1)));
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(20587, (String)localObject1);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject2);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
              ((Intent)localObject2).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.hKU.username);
            }
          }
          if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Zpq == 36) && (((TimeLineObject)localObject3).ContentObj.Zpy != null))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("key_from_profile_share_scene", 3);
            ((Intent)localObject2).putExtra("key_enter_profile_type", 8);
            ((Intent)localObject2).putExtra("key_from_comment_scene", 37);
            if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Zpy.username))
            {
              ((Intent)localObject2).putExtra("finder_username", "");
              ((Intent)localObject2).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.Zpy.objectId);
              ((Intent)localObject2).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.Zpy.objectNonceId);
            }
            for (;;)
            {
              ((Intent)localObject2).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 3);
              ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.Zpy.nickname);
              ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.Zpy.username);
              localObject1 = ((TimeLineObject)localObject3).ContentObj.hKU.hUQ;
              if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.hKU.aacW)) {
                localObject1 = ((TimeLineObject)localObject3).ContentObj.hKU.aacW;
              }
              ((Intent)localObject2).putExtra("key_biz_username", (String)localObject1);
              localObject1 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN());
              str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
              str2 = ((TimeLineObject)localObject3).ContentObj.Zpy.objectId;
              localObject3 = ((TimeLineObject)localObject3).Id;
              localObject1 = (String)localObject1 + "," + str1 + "," + str2 + "," + (String)localObject3;
              Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject1)));
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(20587, (String)localObject1);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject2);
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
              ((Intent)localObject2).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.Zpy.username);
            }
          }
          if ((((TimeLineObject)localObject3).ContentObj != null) && ((((TimeLineObject)localObject3).ContentObj.Zpq == 34) || (((TimeLineObject)localObject3).ContentObj.Zpq == 45) || (((TimeLineObject)localObject3).ContentObj.Zpq == 43)) && (((TimeLineObject)localObject3).ContentObj.DHa != null))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
            ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
            if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.DHa.username))
            {
              ((Intent)localObject1).putExtra("finder_username", "");
              ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.DHa.feedId);
              ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.DHa.objectNonceId);
            }
            for (;;)
            {
              if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.DHa.nickName)) {
                ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.DHa.nickName);
              }
              ((Intent)localObject1).putExtra("key_finder_teen_mode_check", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
              ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
              localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN());
              str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
              str2 = ((TimeLineObject)localObject3).ContentObj.DHa.feedId;
              localObject3 = ((TimeLineObject)localObject3).Id;
              Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf((String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3)));
              ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
              ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.DHa.username);
              ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.DHa.username);
            }
          }
          if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.Zpq == 1) && (((TimeLineObject)localObject3).ContentObj.DHa != null))
          {
            long l1 = com.tencent.mm.plugin.sns.data.t.aXD(((TimeLineObject)localObject3).ContentObj.DHa.liveId);
            long l2 = com.tencent.mm.plugin.sns.data.t.aXD(((TimeLineObject)localObject3).ContentObj.DHa.feedId);
            if ((l1 != 0L) && (l2 != 0L))
            {
              if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramAnonymousView.findViewById(b.f.finder_live_icon), paramAnonymousView.findViewById(b.f.finder_live_end_tag), l1))
              {
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveReplayUI(null, bv.this.context, l2, l1, ((TimeLineObject)localObject3).ContentObj.DHa.username, ((TimeLineObject)localObject3).ContentObj.DHa.objectNonceId, ((TimeLineObject)localObject3).ContentObj.DHa.desc, "", ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).reportFinderLiveReplay(l2, "share");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99739);
                return;
                if (!Util.isEqual(z.bAW(), ((TimeLineObject)localObject3).ContentObj.DHa.username)) {
                  break;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", ((TimeLineObject)localObject3).ContentObj.DHa.sourceType);
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, bv.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject3).ContentObj.DHa.objectNonceId, ((TimeLineObject)localObject3).ContentObj.DHa.desc, "", "", "");
              }
              if (((TimeLineObject)localObject3).UserName == null)
              {
                paramAnonymousView = "";
                label2411:
                com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramAnonymousView;
                com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = ((TimeLineObject)localObject3).Id;
                com.tencent.mm.plugin.expt.hellhound.a.aqz("temp_6");
                paramAnonymousView = (cn)com.tencent.mm.kernel.h.az(cn.class);
                localObject1 = ((TimeLineObject)localObject3).ContentObj.DHa.username;
                if (((TimeLineObject)localObject3).ContentObj.DHa.liveStatus != 1) {
                  break label2672;
                }
                i = 1;
                paramAnonymousView.report21053OnClick(l2, l1, (String)localObject1, -1, -1, 7L, "temp_6", i, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKk(), com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr, System.currentTimeMillis(), 1);
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("key_enter_live_param_visitor_enter_scene", 2);
                if (((TimeLineObject)localObject3).ContentObj.DHa.ecSource != null) {
                  break label2677;
                }
              }
              label2672:
              label2677:
              for (paramAnonymousView = "";; paramAnonymousView = ((TimeLineObject)localObject3).ContentObj.DHa.ecSource)
              {
                ((Intent)localObject1).putExtra("key_enter_live_param_ecsource", paramAnonymousView);
                paramAnonymousView = b.k.ahpq;
                ((Intent)localObject1).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWn());
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveVisitorUI((Intent)localObject1, bv.this.context, l2, Long.valueOf(l1), ((TimeLineObject)localObject3).ContentObj.DHa.username, ((TimeLineObject)localObject3).ContentObj.DHa.objectNonceId, ((TimeLineObject)localObject3).ContentObj.DHa.desc, "", "", "", 4, "", 1, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
                break;
                paramAnonymousView = ((TimeLineObject)localObject3).UserName;
                break label2411;
                i = 2;
                break label2469;
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
            return;
          }
          String str1 = ((TimeLineObject)localObject3).AppInfo.Id;
          String str2 = com.tencent.mm.plugin.sns.d.a.pFo.iz(str1);
          if (!Util.isNullOrNil(str2))
          {
            if (localObject3 == null)
            {
              paramAnonymousView = null;
              i = 2;
              if (((TimeLineObject)localObject3).ContentObj.Zpq != 1) {
                break label3013;
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
                if (((TimeLineObject)localObject3).actionInfo.YCC != null) {
                  localObject1 = ((TimeLineObject)localObject3).actionInfo.YCC.YCm;
                }
              }
              localObject2 = new un();
              ((un)localObject2).hYk.context = bv.this.context;
              ((un)localObject2).hYk.scene = 4;
              ((un)localObject2).hYk.appid = str1;
              ((un)localObject2).hYk.packageName = str2;
              ((un)localObject2).hYk.msgType = i;
              ((un)localObject2).hYk.hQQ = paramAnonymousView;
              ((un)localObject2).hYk.mediaTagName = ((String)localObject1);
              ((un)localObject2).hYk.hYl = 5;
              ((un)localObject2).hYk.hTh = 0L;
              ((un)localObject2).hYk.hYm = ((TimeLineObject)localObject3).Id;
              ((un)localObject2).publish();
              paramAnonymousView = new kj();
              paramAnonymousView.hLZ.actionCode = 2;
              paramAnonymousView.hLZ.scene = 3;
              paramAnonymousView.hLZ.extMsg = "timeline_src=3";
              paramAnonymousView.hLZ.appId = str1;
              paramAnonymousView.hLZ.context = bv.this.context;
              paramAnonymousView.publish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
              paramAnonymousView = ((TimeLineObject)localObject3).UserName;
              break;
              if (((TimeLineObject)localObject3).ContentObj.Zpq == 3) {
                i = 5;
              }
            }
          }
          paramAnonymousView = bv.this;
          paramAnonymousView = com.tencent.mm.plugin.sns.d.a.pFo.i(paramAnonymousView.context, str1, "timeline");
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
          com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject1, bv.this.context);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99739);
          return;
        }
      }
    };
    this.RFx = new bv.24(this);
    this.RFy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99725);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99725);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("key_Product_xml", (String)localObject2);
          localIntent.putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99725);
      }
    };
    this.RFz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Log.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("key_TV_xml", (String)localObject2);
          localIntent.putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99726);
      }
    };
    this.RFA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_object_data", (String)localObject2);
          localIntent.putExtra("preceding_scence", 10);
          localIntent.putExtra("download_entrance_scene", 13);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99727);
      }
    };
    this.RFB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99728);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99728);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_object_data", (String)localObject2);
          localIntent.putExtra("extra_scence", 13);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99728);
      }
    };
    this.RFC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_object_data", (String)localObject2);
          localIntent.putExtra("extra_scence", 13);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99729);
      }
    };
    this.RFD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("sns_object_data", (String)localObject2);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99730);
      }
    };
    this.RFE = new bv.8(this);
    this.RFF = new bv.9(this);
    this.RFG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308309);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308309);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).RcF;
        localObject = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject).hES);
        if (bv.this.Rca != null) {
          bv.this.Rca.hgf().P((SnsInfo)localObject);
        }
        if (paramAnonymousView.weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308309);
          return;
        }
        String str1 = paramAnonymousView.weappInfo.username;
        String str2 = paramAnonymousView.weappInfo.path;
        Log.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        zp localzp = new zp();
        localzp.icM.userName = str1;
        localzp.icM.icO = str2;
        localzp.icM.scene = 1009;
        localzp.icM.hzx = (paramAnonymousView.Id + ":" + paramAnonymousView.UserName);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((SnsInfo)localObject).getUserName());
        paramAnonymousView.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.t.uA(((SnsInfo)localObject).field_snsId));
        localzp.publish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308309);
      }
    };
    this.RFH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308253);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308253);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
        if (bv.this.Rca != null) {
          bv.this.Rca.hgf().P((SnsInfo)localObject2);
        }
        if (((TimeLineObject)localObject1).weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308253);
          return;
        }
        Object localObject3 = new AppBrandLaunchReferrer();
        ((AppBrandLaunchReferrer)localObject3).qYE = 6;
        ((AppBrandLaunchReferrer)localObject3).idf = ((TimeLineObject)localObject1).weappInfo.idf;
        Log.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { ((AppBrandLaunchReferrer)localObject3).qYF });
        localObject2 = new com.tencent.mm.plugin.appbrand.api.g();
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).username = ((TimeLineObject)localObject1).weappInfo.username;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).qAF = ((TimeLineObject)localObject1).weappInfo.path;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).euz = ((TimeLineObject)localObject1).weappInfo.tgv;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).version = ((TimeLineObject)localObject1).weappInfo.version;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).qAP = ((TimeLineObject)localObject1).ContentObj.hAP;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).launchMode = 1;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).scene = 1154;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).hzx = ((TimeLineObject)localObject1).weappInfo.hzD;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).qAO = ((AppBrandLaunchReferrer)localObject3);
        if (((TimeLineObject)localObject1).weappInfo.accF != null) {
          try
          {
            localObject3 = new com.tencent.mm.ad.f(((TimeLineObject)localObject1).weappInfo.accF);
            ((com.tencent.mm.plugin.appbrand.api.g)localObject2).qAS = new ArrayList();
            int i = 0;
            while (i < ((com.tencent.mm.ad.f)localObject3).length())
            {
              ((com.tencent.mm.plugin.appbrand.api.g)localObject2).qAS.add(((com.tencent.mm.ad.f)localObject3).getString(i));
              i += 1;
            }
            ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(paramAnonymousView.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject2);
          }
          catch (com.tencent.mm.ad.g localg) {}
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308253);
      }
    };
    this.RFI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308234);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308234);
          return;
        }
        paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
        if (paramAnonymousView.weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308234);
          return;
        }
        localObject = paramAnonymousView.weappInfo.username;
        zp localzp = new zp();
        Log.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(localObject)));
        localzp.icM.userName = ((String)localObject);
        localzp.icM.scene = 1009;
        localzp.icM.hzx = (paramAnonymousView.Id + ":" + paramAnonymousView.UserName);
        localzp.publish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308234);
      }
    };
    this.RFJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308235);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Log.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308235);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).RcF;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((s)localObject2).hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          Intent localIntent = new Intent();
          localIntent.putExtra("key_product_scene", 2);
          localIntent.putExtra("key_product_info", (String)localObject2);
          com.tencent.mm.br.c.b(bv.this.context, "product", ".ui.MallProductUI", localIntent);
        }
        bv.a((TimeLineObject)localObject1, ((s)paramAnonymousView.getTag()).hES);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308235);
      }
    };
    this.RFK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308271);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308271);
          return;
        }
        paramAnonymousView = (s)paramAnonymousView.getTag();
        localObject1 = paramAnonymousView.RcF;
        Object localObject2;
        Intent localIntent;
        String[] arrayOfString;
        if (((TimeLineObject)localObject1).ContentObj.Zpr.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousView.hES);
          if (bv.this.Rca != null) {
            bv.this.Rca.hgf().P((SnsInfo)localObject2);
          }
          localObject2 = ((dmz)((TimeLineObject)localObject1).ContentObj.Zpr.get(0)).RcB;
          localIntent = new Intent();
          localIntent.putExtra("key_from_scene", 12);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label374;
          }
          arrayOfString = ((String)localObject2).split("#");
          if (arrayOfString.length < 2) {
            break label281;
          }
          Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + arrayOfString[0]);
          localIntent.putExtra("key_card_id", arrayOfString[0]);
          localIntent.putExtra("key_card_ext", arrayOfString[1]);
          com.tencent.mm.br.c.b(bv.this.context, "card", ".ui.CardDetailUI", localIntent);
        }
        for (;;)
        {
          bv.a((TimeLineObject)localObject1, paramAnonymousView.hES);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308271);
          return;
          label281:
          if (arrayOfString.length == 1)
          {
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(localObject2)));
            localIntent.putExtra("key_card_id", arrayOfString[0]);
            localIntent.putExtra("key_card_ext", "");
            com.tencent.mm.br.c.b(bv.this.context, "card", ".ui.CardDetailUI", localIntent);
          }
          else
          {
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(localObject2)));
            continue;
            label374:
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
          }
        }
      }
    };
    this.RFL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308279);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        TimeLineObject localTimeLineObject;
        ht localht;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          localTimeLineObject = locals.RcF;
          if (localTimeLineObject.ContentObj.Zpq == 26)
          {
            if (Util.isNullOrNil(locals.RcF.ContentObj.Zpt))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308279);
              return;
            }
            localht = new ht();
            localht.hIR.type = 37;
            localht.hIR.desc = locals.RcF.ContentObj.Zpt;
            localObject = "";
            paramAnonymousView = (View)localObject;
            if (locals.RcF.ContentObj.Zpr != null)
            {
              paramAnonymousView = (View)localObject;
              if (locals.RcF.ContentObj.Zpr.size() > 0)
              {
                paramAnonymousView = as.mg(com.tencent.mm.plugin.sns.model.al.getAccSnsPath(), ((dmz)locals.RcF.ContentObj.Zpr.get(0)).Id);
                localObject = com.tencent.mm.plugin.sns.data.t.d((dmz)locals.RcF.ContentObj.Zpr.get(0));
                if (!y.ZC(paramAnonymousView + (String)localObject)) {
                  break label345;
                }
              }
            }
          }
        }
        label345:
        for (paramAnonymousView = paramAnonymousView + (String)localObject;; paramAnonymousView = "")
        {
          localht.hIR.path = paramAnonymousView;
          localht.hIR.title = locals.hES;
          localht.hIR.context = bv.this.context;
          localht.publish();
          bv.a(localTimeLineObject, locals.hES);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308279);
          return;
        }
      }
    };
    this.RFM = new bv.17(this);
    this.context = paramContext;
    this.RFp = parama;
    this.source = paramInt;
    this.Rca = paramak;
    AppMethodBeat.o(99741);
  }
  
  protected static boolean aUY(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new ov();
    ((ov)localObject).hRE.action = -2;
    ((ov)localObject).publish();
    localObject = ((ov)localObject).hRF.hRG;
    if ((localObject != null) && (com.tencent.mm.aw.a.e((com.tencent.mm.aw.f)localObject)) && (paramString.equals(((com.tencent.mm.aw.f)localObject).oOv)) && (com.tencent.mm.aw.a.bLk()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  protected static String baN(String paramString)
  {
    AppMethodBeat.i(99743);
    Log.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.d.a.pFo.ab(paramString, "timeline");
    AppMethodBeat.o(99743);
    return paramString;
  }
  
  public static String bg(String paramString1, String paramString2, String paramString3)
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
  
  public static abstract interface a
  {
    public abstract void fHR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bv
 * JD-Core Version:    0.7.0.1
 */