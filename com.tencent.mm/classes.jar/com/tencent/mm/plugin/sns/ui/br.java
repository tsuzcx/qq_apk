package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ag.x;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.mw.b;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.ad.g.o.a;
import com.tencent.mm.plugin.sns.ad.g.o.b;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.e.p;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public final class br
{
  public View.OnClickListener EIc;
  private a ERb;
  public View.OnClickListener ERc;
  public View.OnClickListener ERd;
  public View.OnClickListener ERe;
  public View.OnClickListener ERf;
  public View.OnClickListener ERg;
  public View.OnClickListener ERh;
  public View.OnClickListener ERi;
  public View.OnClickListener ERj;
  public View.OnClickListener ERk;
  public View.OnClickListener ERl;
  public View.OnClickListener ERm;
  public View.OnClickListener ERn;
  public View.OnClickListener ERo;
  public View.OnClickListener ERp;
  public View.OnClickListener ERq;
  public View.OnClickListener ERr;
  public View.OnClickListener ERs;
  public View.OnClickListener ERt;
  public View.OnClickListener ERu;
  public View.OnClickListener ERv;
  public View.OnClickListener ERw;
  public View.OnClickListener ERx;
  public View.OnClickListener ERy;
  com.tencent.mm.plugin.sns.model.ai Epj;
  Context context;
  long lastClickTime;
  int source;
  q tipDialog;
  
  public br(Context paramContext, a parama, int paramInt, com.tencent.mm.plugin.sns.model.ai paramai)
  {
    AppMethodBeat.i(99741);
    this.source = 0;
    this.lastClickTime = 0L;
    this.EIc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99724);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        long l1 = System.currentTimeMillis();
        if (l1 - br.this.lastClickTime < 500L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
        }
        br.this.lastClickTime = l1;
        Object localObject6;
        Object localObject5;
        TimeLineObject localTimeLineObject;
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
          localTimeLineObject = ((s)localObject6).EpO;
          localSnsInfo = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject6).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M(localSnsInfo);
          }
          if (localTimeLineObject.ContentObj.LoU == 18)
          {
            paramAnonymousView = br.this;
            localObject1 = br.this.context;
            localObject5 = ((s)localObject6).EpO;
            localObject6 = ((s)localObject6).dHp;
            localObject6 = com.tencent.mm.plugin.sns.model.aj.faO().aQm((String)localObject6);
            o.a(o.b.DwC, o.a.Dwu, (SnsInfo)localObject6, paramAnonymousView.source);
            localObject6 = new Intent();
            paramAnonymousView = null;
            if (((TimeLineObject)localObject5).ContentObj.LoV.size() > 0) {
              paramAnonymousView = (cnb)((TimeLineObject)localObject5).ContentObj.LoV.get(0);
            }
            ((Intent)localObject6).putExtra("KFromTimeLine", false);
            ((Intent)localObject6).putExtra("KStremVideoUrl", ((TimeLineObject)localObject5).ContentObj.Url);
            ((Intent)localObject6).putExtra("KSta_SourceType", 2);
            ((Intent)localObject6).putExtra("KSta_Scene", o.b.DwC.value);
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
                  ((Intent)localObject6).putExtra("KMediaVideoTime", paramAnonymousView.iza);
                  ((Intent)localObject6).putExtra("StreamWording", paramAnonymousView.izc);
                  ((Intent)localObject6).putExtra("StremWebUrl", paramAnonymousView.izd);
                  ((Intent)localObject6).putExtra("KMediaTitle", paramAnonymousView.izb);
                  ((Intent)localObject6).putExtra("KStremVideoUrl", paramAnonymousView.iyZ);
                  ((Intent)localObject6).putExtra("KThumUrl", paramAnonymousView.ize);
                  ((Intent)localObject6).putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.izf);
                  ((Intent)localObject6).putExtra("KSta_StremVideoPublishId", paramAnonymousView.izg);
                }
                ((Intent)localObject6).putExtra("KSta_SnsStatExtStr", ((TimeLineObject)localObject5).statExtStr);
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOS, 0) <= 0) {
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
          if ((localTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(localTimeLineObject.webSearchInfo.IEy)))
          {
            localObject1 = br.this;
            paramAnonymousView = localTimeLineObject.webSearchInfo;
            if ((paramAnonymousView != null) && (!Util.isNullOrNil(paramAnonymousView.IEy)))
            {
              localObject5 = com.tencent.mm.plugin.topstory.a.h.a(paramAnonymousView, 31, ak.aXe("discoverRecommendEntry").optString("wording"));
              com.tencent.mm.plugin.websearch.api.ai.a(((br)localObject1).context, (eit)localObject5);
              localObject1 = localTimeLineObject.UserName;
              localObject6 = localTimeLineObject.Id;
              localObject5 = new StringBuffer();
              ((StringBuffer)localObject5).append("isShareClick=1");
              ((StringBuffer)localObject5).append("&relevant_vid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.IEy);
              ((StringBuffer)localObject5).append("&relevant_pre_searchid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.IEA);
              ((StringBuffer)localObject5).append("&relevant_shared_openid=");
              ((StringBuffer)localObject5).append(paramAnonymousView.IEB);
              ((StringBuffer)localObject5).append("&rec_category=");
              if (paramAnonymousView.IEK <= 0L) {
                break label957;
              }
              ((StringBuffer)localObject5).append(paramAnonymousView.IEK);
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
              ((StringBuffer)localObject5).append(paramAnonymousView.IEz);
              Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject5).toString() });
              paramAnonymousView = new doc();
              paramAnonymousView.MRe = ((StringBuffer)localObject5).toString();
              paramAnonymousView = new ad(paramAnonymousView);
              com.tencent.mm.kernel.g.azz().a(paramAnonymousView, 0);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              label957:
              ((StringBuffer)localObject5).append(paramAnonymousView.IEC);
            }
          }
          long l2;
          if (localTimeLineObject.ContentObj.LoU == 28)
          {
            l1 = com.tencent.mm.plugin.sns.data.r.aOw(localTimeLineObject.ContentObj.dME.objectId);
            l2 = localTimeLineObject.ContentObj.dME.localId;
            if ((l1 != 0L) || (l2 != 0L))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("feed_object_id", l1);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.ContentObj.dME.objectNonceId);
              paramAnonymousView.putExtra("business_type", 0);
              paramAnonymousView.putExtra("finder_user_name", localTimeLineObject.ContentObj.dME.username);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("tab_type", 5);
              paramAnonymousView.putExtra("feed_local_id", l2);
              paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", localTimeLineObject.ContentObj.dME.nickname);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", localTimeLineObject.ContentObj.dME.username);
              if ((l1 == 0L) && (l2 != 0L)) {
                paramAnonymousView.putExtra("key_posting_scene", true);
              }
              ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 25, paramAnonymousView);
              ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
            }
          }
          else if (localTimeLineObject.ContentObj.LoU == 36)
          {
            l1 = com.tencent.mm.plugin.sns.data.r.aOw(localTimeLineObject.ContentObj.Lpd.objectId);
            if (l1 != 0L)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("report_scene", 3);
              paramAnonymousView.putExtra("from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("feed_object_id", l1);
              paramAnonymousView.putExtra("feed_object_nonceId", localTimeLineObject.ContentObj.Lpd.objectNonceId);
              paramAnonymousView.putExtra("business_type", 1);
              paramAnonymousView.putExtra("key_from_user_name", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("tab_type", 5);
              ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 53, paramAnonymousView);
              ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
            }
          }
          if (localTimeLineObject.ContentObj.LoU == 34)
          {
            l1 = com.tencent.mm.plugin.sns.data.r.aOw(localTimeLineObject.ContentObj.Lpc.hJs);
            l2 = com.tencent.mm.plugin.sns.data.r.aOw(localTimeLineObject.ContentObj.Lpc.feedId);
            if ((l1 != 0L) && (l2 != 0L))
            {
              if (Util.isEqual(z.aUg(), localTimeLineObject.ContentObj.Lpc.username)) {
                ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveAnchorUI(br.this.context, l2, Long.valueOf(l1), localTimeLineObject.ContentObj.Lpc.objectNonceId, localTimeLineObject.ContentObj.Lpc.desc, "", "");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
                ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveVisitorUI(br.this.context, l2, Long.valueOf(l1), localTimeLineObject.ContentObj.Lpc.username, localTimeLineObject.ContentObj.Lpc.objectNonceId, localTimeLineObject.ContentObj.Lpc.desc, "", "");
              }
            }
          }
          if ((localTimeLineObject.ContentObj.LoU == 29) && (localTimeLineObject.ContentObj.LoZ != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.LoZ.dST);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.LoZ.tvC);
            localObject1 = new axt();
            ((axt)localObject1).LIb = localTimeLineObject.ContentObj.LoZ.LLB.LIb;
            ((axt)localObject1).dTj = localTimeLineObject.ContentObj.LoZ.LLB.dTj;
            ((axt)localObject1).latitude = localTimeLineObject.ContentObj.LoZ.LLB.latitude;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", ((axt)localObject1).toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
              if (localTimeLineObject.ContentObj.LoZ.tvC == 1)
              {
                i = 22;
                ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTopicUI(br.this.context, paramAnonymousView);
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
          if ((localTimeLineObject.ContentObj.LoU == 37) && (localTimeLineObject.ContentObj.LoZ != null))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.LoZ.dST);
            paramAnonymousView.putExtra("KEY_FOLLOW_ID", localTimeLineObject.ContentObj.LoZ.LLC);
            paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.LoZ.tvC);
            axt localaxt = new axt();
            localaxt.LIb = localTimeLineObject.ContentObj.LoZ.LLB.LIb;
            localaxt.dTj = localTimeLineObject.ContentObj.LoZ.LLB.dTj;
            localaxt.latitude = localTimeLineObject.ContentObj.LoZ.LLB.latitude;
            try
            {
              paramAnonymousView.putExtra("key_topic_poi_location", localaxt.toByteArray());
              paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
              paramAnonymousView.putExtra("key_report_scene", 3);
              paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
              UUID.randomUUID();
              switch (localTimeLineObject.ContentObj.LoZ.tvC)
              {
              case 3: 
              default: 
                i = 22;
                paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
                paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
                paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
                ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTopicUI(br.this.context, paramAnonymousView);
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
          if ((localTimeLineObject.ContentObj.LoU == 38) && (localTimeLineObject.ContentObj.Lpb != null))
          {
            paramAnonymousView = localTimeLineObject.ContentObj.Lpb;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("TITLE_WORDING", paramAnonymousView.title);
            ((Intent)localObject2).putExtra("AUTO_REFRESH", true);
          }
        }
        try
        {
          ((Intent)localObject2).putExtra("FINDER_SHARE_ALBUM", paramAnonymousView.toByteArray());
          ((Intent)localObject2).putExtra("STREAM_CARD_BUFFER", paramAnonymousView.tVe.toByteArray());
          ((Intent)localObject2).putExtra("GET_REL_SCENE", 14);
          ((Intent)localObject2).putExtra("COMMENT_SCENE", 51);
          ((Intent)localObject2).putExtra("CARD_ID", com.tencent.mm.plugin.sns.data.r.aOw(paramAnonymousView.cardId));
          ((Intent)localObject2).putExtra("SHARED_USERNAME", localTimeLineObject.UserName);
          ((Intent)localObject2).putExtra("FROM_SHARE_SCENE", 3);
          ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterAlbumRelatedTimelineUI(br.this.context, (Intent)localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99724);
          return;
          if (localTimeLineObject.ContentObj.LoU == 39) {}
          switch (localTimeLineObject.ContentObj.izD)
          {
          default: 
            localObject2 = localObject5;
            if (!TextUtils.isEmpty(localTimeLineObject.canvasInfo))
            {
              localObject2 = localObject5;
              if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localTimeLineObject.canvasInfo))
              {
                localObject7 = br.aU(localTimeLineObject.canvasInfo, "adxml", ".adxml.adActionLink");
                localObject2 = localObject5;
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  localObject2 = br.aRg((String)localObject7);
                }
              }
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label5655;
            }
            localObject2 = br.aRg(localTimeLineObject.ContentObj.Url);
            if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
              break label3354;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
          case 100000000: 
            if (localTimeLineObject.ContentObj.LoZ != null)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.LoZ.dST);
              paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.LoZ.tvC);
              localObject2 = new axt();
              ((axt)localObject2).LIb = localTimeLineObject.ContentObj.LoZ.LLB.LIb;
              ((axt)localObject2).dTj = localTimeLineObject.ContentObj.LoZ.LLB.dTj;
              ((axt)localObject2).latitude = localTimeLineObject.ContentObj.LoZ.LLB.latitude;
              try
              {
                paramAnonymousView.putExtra("key_topic_poi_location", ((axt)localObject2).toByteArray());
                paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
                paramAnonymousView.putExtra("key_report_scene", 3);
                paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
                UUID.randomUUID();
                paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                paramAnonymousView.putExtra("key_finder_teen_mode_scene", 3);
                paramAnonymousView.putExtra("key_finder_teen_mode_user_name", "");
                paramAnonymousView.putExtra("key_finder_teen_mode_user_id", "");
                if (localTimeLineObject.ContentObj.LoZ.tvC == 1)
                {
                  i = 22;
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, i, paramAnonymousView);
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTopicUI(br.this.context, paramAnonymousView);
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
          paramAnonymousView.putExtra("key_topic_title", localTimeLineObject.ContentObj.Lpe.dST);
          paramAnonymousView.putExtra("key_topic_type", localTimeLineObject.ContentObj.Lpe.tvC);
          Object localObject3 = new axt();
          ((axt)localObject3).LIb = localTimeLineObject.ContentObj.Lpe.LLB.LIb;
          ((axt)localObject3).dTj = localTimeLineObject.ContentObj.Lpe.LLB.dTj;
          ((axt)localObject3).latitude = localTimeLineObject.ContentObj.Lpe.LLB.latitude;
          try
          {
            paramAnonymousView.putExtra("key_topic_poi_location", ((axt)localObject3).toByteArray());
            paramAnonymousView.putExtra("key_from_user", localTimeLineObject.UserName);
            paramAnonymousView.putExtra("key_report_scene", 3);
            paramAnonymousView.putExtra("KEY_TAB_TYPE", 5);
            UUID.randomUUID();
            localObject3 = localTimeLineObject.ContentObj.Lpe.LLD;
            paramAnonymousView.putExtra("key_activity_id", d.Ga(((aoi)localObject3).LAp));
            paramAnonymousView.putExtra("key_activity_name", ((aoi)localObject3).LAq);
            paramAnonymousView.putExtra("key_nick_name", ((aoi)localObject3).LAr);
            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 59, paramAnonymousView);
            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderActivityProfileUI(br.this.context, paramAnonymousView);
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
          label3354:
          int j = br.this.Epj.getScene();
          localObject5 = localIOException4;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(localIOException4))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject5 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(localIOException4, 2, j, i);
          }
          Intent localIntent = new Intent();
          Object localObject4 = null;
          if (localTimeLineObject != null)
          {
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("KSnsStrId", localTimeLineObject.Id);
            ((Bundle)localObject4).putString("KSnsLocalId", ((s)localObject6).dHp);
            ((Bundle)localObject4).putBoolean("KFromTimeline", true);
            if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.LoV.size() > 0))
            {
              ((Bundle)localObject4).putString("K_sns_thumb_url", ((cnb)localTimeLineObject.ContentObj.LoV.get(0)).Msz);
              ((Bundle)localObject4).putString("K_sns_raw_url", localTimeLineObject.ContentObj.Url);
              Log.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((cnb)localTimeLineObject.ContentObj.LoV.get(0)).Msz, localTimeLineObject.ContentObj.Url });
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
          localIntent.putExtra("sns_local_id", ((s)localObject6).dHp);
          if (localSnsInfo != null)
          {
            localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId));
            localIntent.putExtra("pre_username", localSnsInfo.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId));
            localIntent.putExtra("preUsername", localSnsInfo.field_userName);
            localIntent.putExtra("share_report_pre_msg_url", (String)localObject5);
            localIntent.putExtra("share_report_pre_msg_title", localTimeLineObject.ContentObj.Title);
            localIntent.putExtra("share_report_pre_msg_desc", localTimeLineObject.ContentObj.Desc);
            if ((localTimeLineObject.ContentObj.LoV != null) && (localTimeLineObject.ContentObj.LoV.size() > 0)) {
              localIntent.putExtra("share_report_pre_msg_icon_url", ((cnb)localTimeLineObject.ContentObj.LoV.get(0)).Msz);
            }
            localIntent.putExtra("share_report_pre_msg_appid", "");
            localIntent.putExtra("share_report_from_scene", 1);
          }
          if ((localTimeLineObject != null) && (localTimeLineObject.AppInfo != null)) {
            localIntent.putExtra("KAppId", localTimeLineObject.AppInfo.Id);
          }
          if ((localSnsInfo != null) && (localSnsInfo.isAd()))
          {
            if (br.this.source != 2) {
              break label4669;
            }
            localObject6 = localSnsInfo.getAtAdInfo();
            if (localObject6 != null) {
              localIntent.putExtra("KsnsViewId", ((ADInfo)localObject6).viewId);
            }
          }
          if ((localSnsInfo != null) && (localTimeLineObject != null))
          {
            if (br.this.source != 0) {
              break label4679;
            }
            localObject6 = k.tO(718);
            label4064:
            k localk = ((k)localObject6).PH(com.tencent.mm.plugin.sns.data.r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd()).PH(localSnsInfo.getUxinfo()).PH(localTimeLineObject.publicUserName);
            if (localTimeLineObject.AppInfo != null) {
              break label4690;
            }
            localObject7 = "";
            label4121:
            localk.PH((String)localObject7).PH(localTimeLineObject.ContentObj.Url);
            ((k)localObject6).bfK();
            if (br.this.source != 0) {
              break label4703;
            }
            localObject6 = k.tO(743);
            label4164:
            localk = ((k)localObject6).PH(com.tencent.mm.plugin.sns.data.r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd()).PH(localSnsInfo.getUxinfo()).PH(localTimeLineObject.publicUserName);
            if (localTimeLineObject.AppInfo != null) {
              break label4714;
            }
            localObject7 = "";
            label4221:
            localk.PH((String)localObject7).PH(localTimeLineObject.ContentObj.Url);
            if (localObject4 != null)
            {
              localObject6 = ((k)localObject6).aZm();
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
          if ((localTimeLineObject.ContentObj.LoY != null) && (localTimeLineObject.ContentObj.LoY.iAb != -1)) {
            localIntent.putExtra(e.p.OzA, localTimeLineObject.ContentObj.LoY.iAb);
          }
          if ((!Util.isNullOrNil(localTimeLineObject.canvasInfo)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localTimeLineObject.canvasInfo)) && (localSnsInfo != null))
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
              localObject4 = localTimeLineObject.ContentObj.LoV;
              if (((List)localObject4).size() > 0) {
                paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cnb)((List)localObject4).get(0)).Msz);
              }
            }
            paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
            paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
            paramAnonymousView.putExtra("sns_landing_pages_aid", localSnsInfo.getAid());
            paramAnonymousView.putExtra("sns_landing_pages_traceid", localSnsInfo.getTraceid());
            paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
            if (br.this.source == 0) {}
            for (i = 3;; i = 4)
            {
              paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
              paramAnonymousView.setClass(br.this.context, SnsAdNativeLandingPagesUI.class);
              paramAnonymousView.putExtra("sns_landing_pages_xml", localTimeLineObject.canvasInfo);
              paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
              paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(paramAnonymousView, br.this.context);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99724);
              return;
              label4669:
              localObject6 = localSnsInfo.getAdInfo();
              break;
              label4679:
              localObject6 = k.tP(718);
              break label4064;
              label4690:
              localObject7 = localTimeLineObject.AppInfo.Id;
              break label4121;
              label4703:
              localObject6 = k.tP(743);
              break label4164;
              label4714:
              localObject7 = localTimeLineObject.AppInfo.Id;
              break label4221;
            }
          }
          localIntent.putExtra("key_enable_teen_mode_check", true);
          localIntent.putExtra("msgUsername", localTimeLineObject.UserName);
          localIntent.putExtra("serverMsgID", localTimeLineObject.Id);
          localIntent.addFlags(536870912);
          if (localTimeLineObject.ContentObj.LoY != null)
          {
            i = localTimeLineObject.ContentObj.LoY.iAb;
            if ((localTimeLineObject.ContentObj.LoY != null) && (i == 5) && (localTimeLineObject.ContentObj.LoY.iwe == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
            {
              localObject4 = new x();
              ((x)localObject4).iAh = localIntent.getStringExtra("KPublisherId");
              ((x)localObject4).dHp = localIntent.getStringExtra("sns_local_id");
              ((x)localObject4).dHc = localIntent.getStringExtra("srcUsername");
              ((x)localObject4).iAg = localIntent.getStringExtra("srcDisplayname");
              ((x)localObject4).iAi.url = localIntent.getStringExtra("rawUrl");
              ((x)localObject4).iAi.title = localTimeLineObject.ContentObj.Title;
              ((x)localObject4).iAi.iAq = localTimeLineObject.ContentObj.LoY.desc;
              if (Util.isNullOrNil(localTimeLineObject.ContentObj.LoY.coverUrl)) {
                break label5593;
              }
              ((x)localObject4).iAi.iAo = localTimeLineObject.ContentObj.LoY.coverUrl;
              label4998:
              ((x)localObject4).iAi.type = i;
              ((x)localObject4).iAi.time = localTimeLineObject.ContentObj.LoY.iwd;
              ((x)localObject4).iAi.iAs = localTimeLineObject.ContentObj.LoY.duration;
              ((x)localObject4).iAi.videoWidth = localTimeLineObject.ContentObj.LoY.videoWidth;
              ((x)localObject4).iAi.videoHeight = localTimeLineObject.ContentObj.LoY.videoHeight;
              ((x)localObject4).iAi.vid = localTimeLineObject.ContentObj.LoY.vid;
              ((x)localObject4).iwg = localTimeLineObject.ContentObj.LoY.iwg;
              ((x)localObject4).t(localIntent);
              localIntent.putExtra(e.b.OyQ, 2);
              localIntent.putExtra(e.b.OyR, j);
              localObject4 = new int[2];
              paramAnonymousView = paramAnonymousView.findViewById(2131302578);
              if (paramAnonymousView != null)
              {
                int k = paramAnonymousView.getWidth();
                int m = paramAnonymousView.getHeight();
                paramAnonymousView.getLocationInWindow((int[])localObject4);
                localIntent.putExtra("img_gallery_width", k).putExtra("img_gallery_height", m).putExtra("img_gallery_left", localObject4[0]).putExtra("img_gallery_top", localObject4[1]);
              }
            }
            if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(4)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(br.this.context, (String)localObject5, i, 2, j, localIntent))) {
              break label5612;
            }
            Log.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
            label5278:
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
            localObject6 = com.tencent.mm.plugin.sns.c.a.jRu.w(paramAnonymousView, i);
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
                  if (localTimeLineObject.actionInfo.KEw != null) {
                    localObject4 = localTimeLineObject.actionInfo.KEw.KEq;
                  }
                }
              }
              if (localTimeLineObject != null) {
                break label5632;
              }
              localObject5 = null;
              label5408:
              com.tencent.mm.plugin.sns.c.a.jRu.a(br.this.context, paramAnonymousView, (String)localObject6, (String)localObject5, 5, 4, 1, (String)localObject4, localTimeLineObject.Id);
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(11105, new Object[] { localTimeLineObject.UserName, localTimeLineObject.ContentObj.Url });
            if ((localSnsInfo != null) && ((localSnsInfo.field_type == 4) || (localSnsInfo.field_type == 42)))
            {
              paramAnonymousView = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
              localObject4 = com.tencent.mm.plugin.report.service.h.CyF;
              if (paramAnonymousView != null) {
                break label5642;
              }
            }
          }
          label5632:
          label5642:
          for (paramAnonymousView = "";; paramAnonymousView = paramAnonymousView.Desc)
          {
            ((com.tencent.mm.plugin.report.service.h)localObject4).a(13043, new Object[] { Integer.valueOf(1), paramAnonymousView, localTimeLineObject.AppInfo.Id });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
            return;
            i = -1;
            break;
            label5593:
            ((x)localObject4).iAi.iAo = localIntent.getStringExtra("share_report_pre_msg_icon_url");
            break label4998;
            label5612:
            com.tencent.mm.plugin.sns.c.a.jRt.i(localIntent, br.this.context);
            break label5278;
            localObject5 = localTimeLineObject.UserName;
            break label5408;
          }
        }
        catch (IOException localIOException5)
        {
          label5655:
          for (;;) {}
        }
      }
    };
    this.ERc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99731);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView != null) && (paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof ai)))
        {
          localObject1 = ((ai)paramAnonymousView.getTag()).EpO;
          Object localObject2 = ((ai)paramAnonymousView.getTag()).EsG;
          if ((localObject1 != null) && (((TimeLineObject)localObject1).ContentObj != null) && (((TimeLineObject)localObject1).ContentObj.Lpa != null) && (localObject2 != null) && (((WeakReference)localObject2).get() != null))
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
            com.tencent.mm.modelsns.h.a(paramAnonymousView.getContext(), ((TimeLineObject)localObject1).ContentObj.Lpa, localRect);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99731);
      }
    };
    this.ERd = new br.18(this);
    this.ERe = new br.19(this);
    this.ERf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99736);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof s)))
        {
          if (!((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).canEnterMvAndShowToast())
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99736);
            return;
          }
          localObject1 = ((s)paramAnonymousView.getTag()).EpO;
          boolean bool1;
          if (((TimeLineObject)localObject1).ContentObj.LoU == 42) {
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
                if (((TimeLineObject)localObject1).ContentObj.LoU != 4) {
                  break label668;
                }
                paramAnonymousView = com.tencent.mm.plugin.comm.a.qCo;
                if (!com.tencent.mm.plugin.comm.a.akQ(((TimeLineObject)localObject1).AppInfo.Id)) {
                  break label668;
                }
                bool2 = true;
              }
            }
            label166:
            int i = ((TimeLineObject)localObject1).ContentObj.LoU;
            if (((TimeLineObject)localObject1).AppInfo == null)
            {
              paramAnonymousView = "";
              label186:
              Log.i("MicroMsg.TimeLineClickEvent", "canEnterMv:%b, type:%d, appId:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), paramAnonymousView });
              if (!bool2) {
                break label720;
              }
              if (!br.aMJ(((TimeLineObject)localObject1).Id))
              {
                if (((TimeLineObject)localObject1).ContentObj == null) {
                  break label686;
                }
                paramAnonymousView = ((TimeLineObject)localObject1).ContentObj.jfy;
                if (paramAnonymousView == null) {}
              }
            }
            try
            {
              Object localObject2 = new css();
              ((css)localObject2).parseFrom(paramAnonymousView.toByteArray());
              com.tencent.mm.ay.a.c(com.tencent.mm.ay.i.a(com.tencent.mm.plugin.sns.model.aj.getAccPath(), (TimeLineObject)localObject1, 1, com.tencent.mm.ay.h.a(((TimeLineObject)localObject1).Id, (css)localObject2)));
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_scene", 7);
              if (!((TimeLineObject)localObject1).ContentObj.LoV.isEmpty())
              {
                localObject2 = (cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0);
                if (localObject2 != null)
                {
                  paramAnonymousView.putExtra("key_mv_song_name", ((cnb)localObject2).Title);
                  paramAnonymousView.putExtra("key_mv_song_lyric", ((cnb)localObject2).songLyric);
                  paramAnonymousView.putExtra("key_mv_album_cover_url", ((cnb)localObject2).songAlbumUrl);
                }
              }
              if (((TimeLineObject)localObject1).ContentObj.jfy != null)
              {
                localObject2 = ((TimeLineObject)localObject1).ContentObj.jfy;
                paramAnonymousView.putExtra("key_mv_feed_id", ((css)localObject2).Ktn);
                paramAnonymousView.putExtra("key_mv_nonce_id", ((css)localObject2).Kto);
                paramAnonymousView.putExtra("key_mv_cover_url", ((css)localObject2).Ktp);
                paramAnonymousView.putExtra("key_mv_poster", ((css)localObject2).Ktq);
                paramAnonymousView.putExtra("key_mv_singer_name", ((css)localObject2).singerName);
                paramAnonymousView.putExtra("key_mv_album_name", ((css)localObject2).albumName);
                paramAnonymousView.putExtra("key_mv_music_genre", ((css)localObject2).musicGenre);
                paramAnonymousView.putExtra("key_mv_issue_date", String.valueOf(((css)localObject2).issueDate));
                paramAnonymousView.putExtra("key_mv_identification", ((css)localObject2).identification);
                paramAnonymousView.putExtra("key_mv_extra_info", ((css)localObject2).extraInfo);
                paramAnonymousView.putExtra("key_mv_music_duration", ((css)localObject2).Alz);
                paramAnonymousView.putExtra("key_mv_thumb_path", ((css)localObject2).jfz);
              }
              paramAnonymousView.setFlags(268435456);
              localObject2 = SecDataUIC.CWq;
              localObject2 = (cst)SecDataUIC.a.a(br.this.context, "MusicMvMainUI", 7, cst.class);
              ((cst)localObject2).scene = 1;
              com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.qCo;
              ((cst)localObject2).sGQ = com.tencent.mm.plugin.comm.a.cAK();
              ((cst)localObject2).MxI = 85;
              ((cst)localObject2).MxJ = ((TimeLineObject)localObject1).Id;
              com.tencent.mm.br.c.b(br.this.context, "mv", ".ui.MusicMvMainUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99736);
              return;
              bool1 = false;
              continue;
              label668:
              bool2 = false;
              break label166;
              paramAnonymousView = ((TimeLineObject)localObject1).AppInfo.Id;
              break label186;
              label686:
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
        label720:
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99736);
      }
    };
    this.ERg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99737);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof bv)))
        {
          paramAnonymousView = (bv)paramAnonymousView.getTag();
          if (paramAnonymousView != null)
          {
            localObject1 = new Intent(br.this.context, SnsWsFoldDetailUI.class);
            ((Intent)localObject1).putExtra("key_ws_group_id", paramAnonymousView.EQE);
            ((Intent)localObject1).putExtra("key_ws_detail_max_id", paramAnonymousView.DIf);
            ((Intent)localObject1).putExtra("key_ws_detail_min_id", paramAnonymousView.DIg);
            ((Intent)localObject1).putExtra("key_ws_detail_username", paramAnonymousView.username);
            Object localObject2 = new ArrayList();
            Iterator localIterator = paramAnonymousView.idList.iterator();
            while (localIterator.hasNext()) {
              ((ArrayList)localObject2).add(com.tencent.mm.plugin.sns.data.r.Jc(((Long)localIterator.next()).longValue()));
            }
            ((Intent)localObject1).putStringArrayListExtra("key_ws_str_sns_id_list", (ArrayList)localObject2);
            localObject2 = br.this.context;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.sns.k.e.DUQ.a(paramAnonymousView.idList, paramAnonymousView.EQE, paramAnonymousView.username);
            localObject1 = com.tencent.mm.plugin.sns.k.e.DUQ;
            long l = paramAnonymousView.EQE;
            paramAnonymousView = (it)((com.tencent.mm.plugin.sns.k.e)localObject1).DVH.get(Long.valueOf(l));
            if (paramAnonymousView != null) {
              paramAnonymousView.ePH = 1;
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
      }
    };
    this.ERh = new br.22(this);
    this.ERi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99739);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = br.this;
        int i;
        if ((paramAnonymousView == null) || (!(paramAnonymousView.getTag() instanceof TimeLineObject))) {
          i = 1;
        }
        Object localObject2;
        Object localObject3;
        String str1;
        String str2;
        for (;;)
        {
          if (i == 0) {
            if ((paramAnonymousView == null) || (!(paramAnonymousView.getTag() instanceof TimeLineObject)))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99739);
              return;
              localObject2 = ((TimeLineObject)paramAnonymousView.getTag()).AppInfo.Id;
              if ("wx485a97c844086dc9".equals(localObject2))
              {
                com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                i = 1;
              }
              else
              {
                if ("wx7fa037cc7dfabad5".equals(localObject2))
                {
                  com.tencent.mm.plugin.sport.a.c.pl(34);
                  com.tencent.mm.kernel.g.aAi();
                  if (com.tencent.mm.contact.c.oR(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn("gh_43f2581f6fd6").field_type))
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("Chat_User", "gh_43f2581f6fd6");
                    ((Intent)localObject2).putExtra("finish_direct", true);
                    com.tencent.mm.br.c.f(((br)localObject1).context, ".ui.chatting.ChattingUI", (Intent)localObject2);
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("Contact_User", "gh_43f2581f6fd6");
                    com.tencent.mm.br.c.b(((br)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
                  }
                }
                if (("wx9181ed3f223e6d76".equals(localObject2)) || ("wx2fe12a395c426fcf".equals(localObject2)))
                {
                  Log.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("shake_tv", true);
                  com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
                  i = 1;
                }
                else if ("wxfbc915ff7c30e335".equals(localObject2))
                {
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 1);
                  if ((!com.tencent.mm.q.a.o(((br)localObject1).context, true)) && (!com.tencent.mm.q.a.cA(((br)localObject1).context)) && (!com.tencent.mm.q.a.cE(((br)localObject1).context))) {
                    com.tencent.mm.br.c.b(((br)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
                  }
                  i = 1;
                }
                else if ("wxaf060266bfa9a35c".equals(localObject2))
                {
                  if (!com.tencent.mm.ay.e.bek())
                  {
                    i = 1;
                  }
                  else
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("shake_tv", true);
                    com.tencent.mm.br.c.b(((br)localObject1).context, "shake", ".ui.ShakeReportUI", (Intent)localObject2);
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
              localObject3 = (TimeLineObject)paramAnonymousView.getTag();
              if ((localObject3 == null) || (((TimeLineObject)localObject3).AppInfo == null))
              {
                Log.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99739);
                return;
              }
              if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.LoU == 28) && (((TimeLineObject)localObject3).ContentObj.dME != null))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
                ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
                ((Intent)localObject1).putExtra("key_comment_scene", 37);
                if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.dME.username))
                {
                  ((Intent)localObject1).putExtra("finder_username", "");
                  ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.dME.objectId);
                  ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.dME.objectNonceId);
                }
                for (;;)
                {
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_check", true);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.dME.nickname);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.dME.username);
                  localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD());
                  str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
                  str2 = ((TimeLineObject)localObject3).ContentObj.dME.objectId;
                  localObject3 = ((TimeLineObject)localObject3).Id;
                  localObject2 = (String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3;
                  Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject2)));
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(20587, (String)localObject2);
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject1);
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(99739);
                  return;
                  ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.dME.username);
                }
              }
              if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.LoU == 36) && (((TimeLineObject)localObject3).ContentObj.Lpd != null))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
                ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
                ((Intent)localObject1).putExtra("key_comment_scene", 37);
                if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpd.username))
                {
                  ((Intent)localObject1).putExtra("finder_username", "");
                  ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.Lpd.objectId);
                  ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.Lpd.objectNonceId);
                }
                for (;;)
                {
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_check", true);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.Lpd.nickname);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.Lpd.username);
                  localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD());
                  str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
                  str2 = ((TimeLineObject)localObject3).ContentObj.Lpd.objectId;
                  localObject3 = ((TimeLineObject)localObject3).Id;
                  localObject2 = (String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3;
                  Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(localObject2)));
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(20587, (String)localObject2);
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 32, (Intent)localObject1);
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(99739);
                  return;
                  ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.Lpd.username);
                }
              }
              if ((((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.LoU == 34) && (((TimeLineObject)localObject3).ContentObj.Lpc != null))
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("key_from_profile_share_scene", 3);
                ((Intent)localObject1).putExtra("key_enter_profile_type", 8);
                if (Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpc.username))
                {
                  ((Intent)localObject1).putExtra("finder_username", "");
                  ((Intent)localObject1).putExtra("key_finder_object_Id", ((TimeLineObject)localObject3).ContentObj.Lpc.feedId);
                  ((Intent)localObject1).putExtra("key_finder_object_nonce_id_key", ((TimeLineObject)localObject3).ContentObj.Lpc.objectNonceId);
                }
                for (;;)
                {
                  if (!Util.isNullOrNil(((TimeLineObject)localObject3).ContentObj.Lpc.nickName)) {
                    ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((TimeLineObject)localObject3).ContentObj.Lpc.nickName);
                  }
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_check", true);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 3);
                  localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD());
                  str1 = Util.nullAsNil(((TimeLineObject)localObject3).UserName);
                  str2 = ((TimeLineObject)localObject3).ContentObj.Lpc.feedId;
                  localObject3 = ((TimeLineObject)localObject3).Id;
                  Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf((String)localObject2 + "," + str1 + "," + str2 + "," + (String)localObject3)));
                  ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderProfileUI(paramAnonymousView.getContext(), (Intent)localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(99739);
                  return;
                  ((Intent)localObject1).putExtra("finder_username", ((TimeLineObject)localObject3).ContentObj.Lpc.username);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((TimeLineObject)localObject3).ContentObj.Lpc.username);
                }
              }
              str1 = ((TimeLineObject)localObject3).AppInfo.Id;
              str2 = com.tencent.mm.plugin.sns.c.a.jRu.go(str1);
              if (!Util.isNullOrNil(str2)) {
                if (localObject3 == null)
                {
                  paramAnonymousView = null;
                  if (((TimeLineObject)localObject3).ContentObj.LoU != 1) {
                    break label2004;
                  }
                  i = 2;
                }
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = null;
          localObject1 = localObject2;
          if (((TimeLineObject)localObject3).actionInfo != null)
          {
            localObject1 = localObject2;
            if (((TimeLineObject)localObject3).actionInfo.KEw != null) {
              localObject1 = ((TimeLineObject)localObject3).actionInfo.KEw.KEq;
            }
          }
          localObject2 = new ry();
          ((ry)localObject2).dYw.context = br.this.context;
          ((ry)localObject2).dYw.scene = 4;
          ((ry)localObject2).dYw.dNI = str1;
          ((ry)localObject2).dYw.packageName = str2;
          ((ry)localObject2).dYw.msgType = i;
          ((ry)localObject2).dYw.dRL = paramAnonymousView;
          ((ry)localObject2).dYw.mediaTagName = ((String)localObject1);
          ((ry)localObject2).dYw.dYx = 5;
          ((ry)localObject2).dYw.dTS = 0L;
          ((ry)localObject2).dYw.dYy = ((TimeLineObject)localObject3).Id;
          EventCenter.instance.publish((IEvent)localObject2);
          paramAnonymousView = new is();
          paramAnonymousView.dNr.actionCode = 2;
          paramAnonymousView.dNr.scene = 3;
          paramAnonymousView.dNr.extMsg = "timeline_src=3";
          paramAnonymousView.dNr.appId = str1;
          paramAnonymousView.dNr.context = br.this.context;
          EventCenter.instance.publish(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99739);
          return;
          paramAnonymousView = ((TimeLineObject)localObject3).UserName;
          break;
          label2004:
          if (((TimeLineObject)localObject3).ContentObj.LoU == 3)
          {
            i = 5;
            continue;
            paramAnonymousView = br.this;
            paramAnonymousView = com.tencent.mm.plugin.sns.c.a.jRu.e(paramAnonymousView.context, str1, "timeline");
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
            com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject1, br.this.context);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
          }
          else
          {
            i = 2;
          }
        }
      }
    };
    this.ERj = new br.24(this);
    this.ERk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99725);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99725);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        if (((TimeLineObject)localObject1).ContentObj.LoV.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject2);
          }
          localObject1 = ((cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0)).EpK;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_Product_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_ProductUI_getProductInfoScene", 2);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99725);
      }
    };
    this.ERl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99726);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Log.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99726);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        if (((TimeLineObject)localObject1).ContentObj.LoV.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject2);
          }
          localObject1 = ((cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0)).EpK;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_TV_xml", (String)localObject1);
          ((Intent)localObject2).putExtra("key_TV_getProductInfoScene", 2);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99726);
      }
    };
    this.ERm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99727);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99727);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        if (((TimeLineObject)localObject1).ContentObj.LoV.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject2);
          }
          localObject1 = ((cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0)).EpK;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("preceding_scence", 10);
          ((Intent)localObject2).putExtra("download_entrance_scene", 13);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99727);
      }
    };
    this.ERn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99728);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99728);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        if (((TimeLineObject)localObject1).ContentObj.LoV.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject2);
          }
          localObject1 = ((cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0)).EpK;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99728);
      }
    };
    this.ERo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99729);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99729);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        if (((TimeLineObject)localObject1).ContentObj.LoV.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject2);
          }
          localObject1 = ((cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0)).EpK;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_scence", 13);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99729);
      }
    };
    this.ERp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99730);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99730);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        if (((TimeLineObject)localObject1).ContentObj.LoV.size() > 0)
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject2);
          }
          localObject1 = ((cnb)((TimeLineObject)localObject1).ContentObj.LoV.get(0)).EpK;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_object_data", (String)localObject1);
          com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99730);
      }
    };
    this.ERq = new br.8(this);
    this.ERr = new br.9(this);
    this.ERs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203834);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203834);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).EpO;
        localObject = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject).dHp);
        if (br.this.Epj != null) {
          br.this.Epj.fat().M((SnsInfo)localObject);
        }
        if (paramAnonymousView.weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203834);
          return;
        }
        String str1 = paramAnonymousView.weappInfo.username;
        String str2 = paramAnonymousView.weappInfo.path;
        Log.i("MicroMsg.TimeLineClickEvent", "username: " + str1 + "pagepath: " + str2);
        wq localwq = new wq();
        localwq.ecI.userName = str1;
        localwq.ecI.ecK = str2;
        localwq.ecI.scene = 1009;
        localwq.ecI.dCw = (paramAnonymousView.Id + ":" + paramAnonymousView.UserName);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("stat_send_msg_user", ((SnsInfo)localObject).getUserName());
        paramAnonymousView.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.r.Jb(((SnsInfo)localObject).field_snsId));
        EventCenter.instance.publish(localwq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203834);
      }
    };
    this.ERt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203835);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203835);
          return;
        }
        Object localObject2 = (s)paramAnonymousView.getTag();
        localObject1 = ((s)localObject2).EpO;
        localObject2 = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject2).dHp);
        if (br.this.Epj != null) {
          br.this.Epj.fat().M((SnsInfo)localObject2);
        }
        if (((TimeLineObject)localObject1).weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203835);
          return;
        }
        AppBrandLaunchReferrer localAppBrandLaunchReferrer = new AppBrandLaunchReferrer();
        localAppBrandLaunchReferrer.leo = 6;
        localAppBrandLaunchReferrer.eda = ((TimeLineObject)localObject1).weappInfo.eda;
        Log.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", new Object[] { localAppBrandLaunchReferrer.lep });
        localObject2 = new com.tencent.mm.plugin.appbrand.api.g();
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).username = ((TimeLineObject)localObject1).weappInfo.username;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHw = ((TimeLineObject)localObject1).weappInfo.path;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).iOo = ((TimeLineObject)localObject1).weappInfo.nbf;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).version = ((TimeLineObject)localObject1).weappInfo.version;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHH = ((TimeLineObject)localObject1).ContentObj.Title;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).launchMode = 1;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).scene = 1154;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).dCw = ((TimeLineObject)localObject1).weappInfo.dCC;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHF = localAppBrandLaunchReferrer;
        if (((TimeLineObject)localObject1).weappInfo.Nvm != null) {
          try
          {
            localObject1 = new com.tencent.mm.ab.f(((TimeLineObject)localObject1).weappInfo.Nvm);
            ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHK = new ArrayList();
            int i = 0;
            while (i < ((com.tencent.mm.ab.f)localObject1).length())
            {
              ((com.tencent.mm.plugin.appbrand.api.g)localObject2).kHK.add(((com.tencent.mm.ab.f)localObject1).getString(i));
              i += 1;
            }
            ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(paramAnonymousView.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject2);
          }
          catch (com.tencent.mm.ab.g localg) {}
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203835);
      }
    };
    this.ERu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203836);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203836);
          return;
        }
        paramAnonymousView = (TimeLineObject)paramAnonymousView.getTag();
        if (paramAnonymousView.weappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203836);
          return;
        }
        localObject = paramAnonymousView.weappInfo.username;
        wq localwq = new wq();
        Log.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(localObject)));
        localwq.ecI.userName = ((String)localObject);
        localwq.ecI.scene = 1009;
        localwq.ecI.dCw = (paramAnonymousView.Id + ":" + paramAnonymousView.UserName);
        EventCenter.instance.publish(localwq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203836);
      }
    };
    this.ERv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203837);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203837);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).EpO;
        if (paramAnonymousView.ContentObj.LoV.size() > 0)
        {
          localObject = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject);
          }
          paramAnonymousView = ((cnb)paramAnonymousView.ContentObj.LoV.get(0)).EpK;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_product_scene", 2);
          ((Intent)localObject).putExtra("key_product_info", paramAnonymousView);
          com.tencent.mm.br.c.b(br.this.context, "product", ".ui.MallProductUI", (Intent)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203837);
      }
    };
    this.ERw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203838);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203838);
          return;
        }
        localObject = (s)paramAnonymousView.getTag();
        paramAnonymousView = ((s)localObject).EpO;
        String[] arrayOfString;
        if (paramAnonymousView.ContentObj.LoV.size() > 0)
        {
          localObject = com.tencent.mm.plugin.sns.model.aj.faO().aQm(((s)localObject).dHp);
          if (br.this.Epj != null) {
            br.this.Epj.fat().M((SnsInfo)localObject);
          }
          paramAnonymousView = ((cnb)paramAnonymousView.ContentObj.LoV.get(0)).EpK;
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
          com.tencent.mm.br.c.b(br.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203838);
          return;
          label263:
          if (arrayOfString.length == 1)
          {
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(paramAnonymousView)));
            ((Intent)localObject).putExtra("key_card_id", arrayOfString[0]);
            ((Intent)localObject).putExtra("key_card_ext", "");
            com.tencent.mm.br.c.b(br.this.context, "card", ".ui.CardDetailUI", (Intent)localObject);
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
    this.ERx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203839);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        s locals;
        hb localhb;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          if (locals.EpO.ContentObj.LoU == 26)
          {
            if (Util.isNullOrNil(locals.EpO.ContentObj.LoX))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203839);
              return;
            }
            localhb = new hb();
            localhb.dLm.type = 37;
            localhb.dLm.desc = locals.EpO.ContentObj.LoX;
            localObject = "";
            paramAnonymousView = (View)localObject;
            if (locals.EpO.ContentObj.LoV != null)
            {
              paramAnonymousView = (View)localObject;
              if (locals.EpO.ContentObj.LoV.size() > 0)
              {
                paramAnonymousView = ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), ((cnb)locals.EpO.ContentObj.LoV.get(0)).Id);
                localObject = com.tencent.mm.plugin.sns.data.r.e((cnb)locals.EpO.ContentObj.LoV.get(0));
                if (!com.tencent.mm.vfs.s.YS(paramAnonymousView + (String)localObject)) {
                  break label335;
                }
              }
            }
          }
        }
        label335:
        for (paramAnonymousView = paramAnonymousView + (String)localObject;; paramAnonymousView = "")
        {
          localhb.dLm.path = paramAnonymousView;
          localhb.dLm.title = locals.dHp;
          localhb.dLm.context = br.this.context;
          EventCenter.instance.publish(localhb);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203839);
          return;
        }
      }
    };
    this.ERy = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(203842);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Log.i("MicroMsg.TimeLineClickEvent", "LiteApp Click");
        if (!(paramAnonymousView.getTag() instanceof s))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203842);
          return;
        }
        Object localObject2 = ((s)paramAnonymousView.getTag()).EpO;
        if (((TimeLineObject)localObject2).liteappInfo == null)
        {
          Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203842);
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("appId", ((TimeLineObject)localObject2).liteappInfo.appId);
        if (!Util.isNullOrNil(((TimeLineObject)localObject2).liteappInfo.path)) {
          ((Bundle)localObject1).putString("path", ((TimeLineObject)localObject2).liteappInfo.path);
        }
        if (!Util.isNullOrNil(((TimeLineObject)localObject2).liteappInfo.query)) {
          ((Bundle)localObject1).putString("query", ((TimeLineObject)localObject2).liteappInfo.query);
        }
        localObject2 = paramAnonymousView.getContext();
        paramAnonymousView.getContext().getString(2131755998);
        localObject2 = com.tencent.mm.ui.base.h.a((Context)localObject2, paramAnonymousView.getContext().getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
        });
        ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).a(paramAnonymousView.getContext(), (Bundle)localObject1, false, new a.a()
        {
          public final void dTt()
          {
            AppMethodBeat.i(203840);
            com.tencent.mm.plugin.report.service.h.CyF.n(1293L, 32L, 1L);
            this.qDi.cancel();
            AppMethodBeat.o(203840);
          }
          
          public final void dTu()
          {
            AppMethodBeat.i(203841);
            u.makeText(paramAnonymousView.getContext(), 2131762444, 0).show();
            this.qDi.cancel();
            AppMethodBeat.o(203841);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203842);
      }
    };
    this.context = paramContext;
    this.ERb = parama;
    this.source = paramInt;
    this.Epj = paramai;
    AppMethodBeat.o(99741);
  }
  
  protected static boolean aMJ(String paramString)
  {
    AppMethodBeat.i(99742);
    Object localObject = new mw();
    ((mw)localObject).dSw.action = -2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((mw)localObject).dSx.dSy;
    if ((localObject != null) && (com.tencent.mm.ay.a.e((com.tencent.mm.ay.f)localObject)) && (paramString.equals(((com.tencent.mm.ay.f)localObject).jeV)) && (com.tencent.mm.ay.a.bec()))
    {
      AppMethodBeat.o(99742);
      return true;
    }
    AppMethodBeat.o(99742);
    return false;
  }
  
  protected static String aRg(String paramString)
  {
    AppMethodBeat.i(99743);
    Log.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.jRu.R(paramString, "timeline");
    AppMethodBeat.o(99743);
    return paramString;
  }
  
  public static String aU(String paramString1, String paramString2, String paramString3)
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
    public abstract void dWI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br
 * JD-Core Version:    0.7.0.1
 */