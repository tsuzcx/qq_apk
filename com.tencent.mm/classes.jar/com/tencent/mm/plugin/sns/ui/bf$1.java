package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

final class bf$1
  implements View.OnClickListener
{
  bf$1(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.pkg.kAE < 500L) {}
    Object localObject2;
    Object localObject4;
    n localn;
    label1527:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.pkg.kAE = l;
          } while (!(paramView.getTag() instanceof q));
          localObject2 = (q)paramView.getTag();
          localObject4 = ((q)localObject2).oOz;
          localn = af.bDF().OB(((q)localObject2).bJQ);
          if (this.pkg.oOe != null) {
            this.pkg.oOe.bDk().y(localn);
          }
          if (((bxk)localObject4).tNr.sPI == 18)
          {
            paramView = this.pkg;
            localObject1 = this.pkg.context;
            localObject3 = ((q)localObject2).oOz;
            localObject2 = ((q)localObject2).bJQ;
            localObject2 = af.bDF().OB((String)localObject2);
            j.a(j.b.olZ, j.a.olR, (n)localObject2, paramView.source);
            localObject2 = new Intent();
            paramView = null;
            if (((bxk)localObject3).tNr.sPJ.size() > 0) {
              paramView = (awd)((bxk)localObject3).tNr.sPJ.get(0);
            }
            ((Intent)localObject2).putExtra("IsAd", false);
            ((Intent)localObject2).putExtra("KStremVideoUrl", ((bxk)localObject3).tNr.kSC);
            ((Intent)localObject2).putExtra("KSta_SourceType", 2);
            ((Intent)localObject2).putExtra("KSta_Scene", j.b.olZ.value);
            ((Intent)localObject2).putExtra("KSta_FromUserName", ((bxk)localObject3).hPY);
            ((Intent)localObject2).putExtra("KSta_SnSId", ((bxk)localObject3).lsK);
            if (paramView == null)
            {
              localObject4 = new StringBuilder("fakeid_");
              if (paramView == null)
              {
                paramView = ((bxk)localObject3).lsK;
                ((Intent)localObject2).putExtra("KMediaId", paramView);
              }
            }
            for (;;)
            {
              paramView = ((bxk)localObject3).tNw;
              if (paramView != null)
              {
                ((Intent)localObject2).putExtra("KMediaVideoTime", paramView.dSQ);
                ((Intent)localObject2).putExtra("StreamWording", paramView.dSS);
                ((Intent)localObject2).putExtra("StremWebUrl", paramView.dST);
                ((Intent)localObject2).putExtra("KMediaTitle", paramView.dSR);
                ((Intent)localObject2).putExtra("KStremVideoUrl", paramView.dSP);
                ((Intent)localObject2).putExtra("KThumUrl", paramView.dSU);
                ((Intent)localObject2).putExtra("KSta_StremVideoAduxInfo", paramView.dSV);
                ((Intent)localObject2).putExtra("KSta_StremVideoPublishId", paramView.dSW);
              }
              ((Intent)localObject2).putExtra("KSta_SnsStatExtStr", ((bxk)localObject3).oPO);
              d.b((Context)localObject1, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject2);
              return;
              paramView = paramView.lsK;
              break;
              ((Intent)localObject2).putExtra("KMediaId", paramView.lsK);
            }
          }
          if ((((bxk)localObject4).ouE == null) || (bk.bl(((bxk)localObject4).ouE.qTY))) {
            break;
          }
          localObject1 = this.pkg;
          paramView = ((bxk)localObject4).ouE;
        } while ((paramView == null) || (bk.bl(paramView.qTY)));
        localObject2 = com.tencent.mm.plugin.topstory.a.g.a(paramView, 31, ac.Ru("discoverRecommendEntry").optString("wording"));
        aa.a(((bf)localObject1).context, (byf)localObject2);
        localObject1 = ((bxk)localObject4).hPY;
        localObject3 = ((bxk)localObject4).lsK;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("isShareClick=1");
        ((StringBuffer)localObject2).append("&relevant_vid=");
        ((StringBuffer)localObject2).append(paramView.qTY);
        ((StringBuffer)localObject2).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject2).append(paramView.qUa);
        ((StringBuffer)localObject2).append("&relevant_shared_openid=");
        ((StringBuffer)localObject2).append(paramView.qUb);
        ((StringBuffer)localObject2).append("&rec_category=");
        if (paramView.qUk > 0L) {
          ((StringBuffer)localObject2).append(paramView.qUk);
        }
        for (;;)
        {
          ((StringBuffer)localObject2).append("&source=");
          ((StringBuffer)localObject2).append(paramView.aWf);
          ((StringBuffer)localObject2).append("&fromUser=");
          ((StringBuffer)localObject2).append((String)localObject1);
          ((StringBuffer)localObject2).append("&fromScene=");
          ((StringBuffer)localObject2).append(3);
          ((StringBuffer)localObject2).append("&targetInfo=");
          ((StringBuffer)localObject2).append((String)localObject3);
          y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject2).toString() });
          paramView = new blf();
          paramView.tEQ = ((StringBuffer)localObject2).toString();
          paramView = new w(paramView);
          com.tencent.mm.kernel.g.Dk().a(paramView, 0);
          return;
          ((StringBuffer)localObject2).append(paramView.qUc);
        }
        localObject1 = ((bxk)localObject4).tNr.kSC;
        localObject3 = ((bxk)localObject4).tNq.lsK;
        y.d("MicroMsg.TimeLineClickEvent", "url:" + (String)localObject1);
        localObject3 = com.tencent.mm.plugin.sns.c.a.eUS.u((String)localObject1, "timeline");
      } while ((localObject3 == null) || (((String)localObject3).length() == 0));
      Intent localIntent = new Intent();
      localObject1 = null;
      if (localObject4 != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("KSnsStrId", ((bxk)localObject4).lsK);
        ((Bundle)localObject1).putString("KSnsLocalId", ((q)localObject2).bJQ);
        ((Bundle)localObject1).putBoolean("KFromTimeline", true);
        if ((((bxk)localObject4).tNr != null) && (((bxk)localObject4).tNr.sPJ.size() > 0))
        {
          ((Bundle)localObject1).putString("K_sns_thumb_url", ((awd)((bxk)localObject4).tNr.sPJ.get(0)).trP);
          ((Bundle)localObject1).putString("K_sns_raw_url", ((bxk)localObject4).tNr.kSC);
          y.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[] { ((awd)((bxk)localObject4).tNr.sPJ.get(0)).trP, ((bxk)localObject4).tNr.kSC });
        }
      }
      ((Bundle)localObject1).putString("key_snsad_statextstr", ((bxk)localObject4).oPO);
      localIntent.putExtra("rawUrl", (String)localObject3);
      localIntent.putExtra("shortUrl", (String)localObject3);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("type", -255);
      if (((bxk)localObject4).tNs != null)
      {
        localIntent.putExtra("srcUsername", ((bxk)localObject4).tNs);
        localIntent.putExtra("srcDisplayname", ((bxk)localObject4).sbL);
        y.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + ((bxk)localObject4).sbL + " tlObj.publicUserName: " + ((bxk)localObject4).tNs);
      }
      localIntent.putExtra("sns_local_id", ((q)localObject2).bJQ);
      if (localn != null)
      {
        localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId));
        localIntent.putExtra("pre_username", localn.field_userName);
        localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId));
        localIntent.putExtra("preUsername", localn.field_userName);
        localIntent.putExtra("share_report_pre_msg_url", (String)localObject3);
        localIntent.putExtra("share_report_pre_msg_title", ((bxk)localObject4).tNr.bGw);
        localIntent.putExtra("share_report_pre_msg_desc", ((bxk)localObject4).tNr.kRN);
        if ((((bxk)localObject4).tNr.sPJ != null) && (((bxk)localObject4).tNr.sPJ.size() > 0)) {
          localIntent.putExtra("share_report_pre_msg_icon_url", ((awd)((bxk)localObject4).tNr.sPJ.get(0)).trP);
        }
        localIntent.putExtra("share_report_pre_msg_appid", "");
        localIntent.putExtra("share_report_from_scene", 1);
      }
      if ((localObject4 != null) && (((bxk)localObject4).tNq != null)) {
        localIntent.putExtra("KAppId", ((bxk)localObject4).tNq.lsK);
      }
      if ((localn != null) && (localn.yr(32)))
      {
        if (this.pkg.source != 2) {
          break label2068;
        }
        localObject2 = localn.bGc();
        if (localObject2 != null) {
          localIntent.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject2).fVM);
        }
      }
      if ((localn != null) && (localObject4 != null))
      {
        if (this.pkg.source != 0) {
          break label2078;
        }
        localObject2 = com.tencent.mm.modelsns.b.jd(718);
        com.tencent.mm.modelsns.b localb = ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(((bxk)localObject4).tNs);
        if (((bxk)localObject4).tNq != null) {
          break label2089;
        }
        localObject3 = "";
        localb.ni((String)localObject3).ni(((bxk)localObject4).tNr.kSC);
        ((com.tencent.mm.modelsns.b)localObject2).QX();
        if (this.pkg.source != 0) {
          break label2102;
        }
        localObject2 = com.tencent.mm.modelsns.b.jd(743);
        localb = ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(((bxk)localObject4).tNs);
        if (((bxk)localObject4).tNq != null) {
          break label2113;
        }
        localObject3 = "";
        localb.ni((String)localObject3).ni(((bxk)localObject4).tNr.kSC);
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.modelsns.b)localObject2).KV();
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
      if ((!bk.bl(((bxk)localObject4).pjl)) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(((bxk)localObject4).pjl)))
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
          localObject1 = ((bxk)localObject4).tNr.sPJ;
          if (((List)localObject1).size() > 0) {
            paramView.putExtra("sns_landing_pages_share_thumb_url", ((awd)((List)localObject1).get(0)).trP);
          }
        }
        paramView.putExtra("sns_landing_pages_share_sns_id", localn.bGk());
        paramView.putExtra("sns_landing_pages_rawSnsId", localn.bGe().lsK);
        paramView.putExtra("sns_landing_pages_aid", localn.bGJ());
        paramView.putExtra("sns_landing_pages_traceid", localn.bGK());
        paramView.putExtra("sns_landing_pages_ux_info", localn.bGM());
        if (this.pkg.source == 0) {}
        for (i = 3;; i = 4)
        {
          paramView.putExtra("sns_landig_pages_from_source", i);
          paramView.setClass(this.pkg.context, SnsAdNativeLandingPagesUI.class);
          paramView.putExtra("sns_landing_pages_xml", ((bxk)localObject4).pjl);
          paramView.putExtra("sns_landing_pages_rec_src", localn.bGO());
          paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(paramView, this.pkg.context);
          return;
          localObject2 = localn.bGb();
          break;
          localObject2 = com.tencent.mm.modelsns.b.je(718);
          break label1527;
          localObject3 = ((bxk)localObject4).tNq.lsK;
          break label1586;
          localObject2 = com.tencent.mm.modelsns.b.je(743);
          break label1629;
          localObject3 = ((bxk)localObject4).tNq.lsK;
          break label1688;
        }
      }
      localIntent.addFlags(536870912);
      com.tencent.mm.plugin.sns.c.a.eUR.j(localIntent, this.pkg.context);
      localObject1 = null;
      int j = 0;
      int i = j;
      paramView = (View)localObject1;
      if (localObject4 != null)
      {
        i = j;
        paramView = (View)localObject1;
        if (((bxk)localObject4).tNq != null)
        {
          paramView = ((bxk)localObject4).tNq.lsK;
          i = bk.getInt(((bxk)localObject4).tNq.hQE, 0);
        }
      }
      Object localObject3 = com.tencent.mm.plugin.sns.c.a.eUS.q(paramView, i);
      if ((!bk.bl((String)localObject3)) && (com.tencent.mm.plugin.sns.c.a.eUS.cu(paramView)))
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if (((bxk)localObject4).ouC != null)
          {
            localObject1 = localObject2;
            if (((bxk)localObject4).ouC.sug != null) {
              localObject1 = ((bxk)localObject4).ouC.sug.sua;
            }
          }
        }
        if (localObject4 != null) {
          break;
        }
        localObject2 = null;
        com.tencent.mm.plugin.sns.c.a.eUS.a(this.pkg.context, paramView, (String)localObject3, (String)localObject2, 5, 4, 1, (String)localObject1, ((bxk)localObject4).lsK);
      }
      h.nFQ.f(11105, new Object[] { ((bxk)localObject4).hPY, ((bxk)localObject4).tNr.kSC });
    } while ((localn == null) || (localn.field_type != 4));
    label1586:
    label1629:
    paramView = (awd)((bxk)localObject4).tNr.sPJ.get(0);
    label1688:
    label2078:
    label2089:
    label2102:
    label2113:
    Object localObject1 = h.nFQ;
    label2068:
    if (paramView == null) {}
    for (paramView = "";; paramView = paramView.kRN)
    {
      ((h)localObject1).f(13043, new Object[] { Integer.valueOf(1), paramView, ((bxk)localObject4).tNq.lsK });
      return;
      localObject2 = ((bxk)localObject4).hPY;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.1
 * JD-Core Version:    0.7.0.1
 */