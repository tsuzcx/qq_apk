package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.LinkedList;
import java.util.List;

final class b$24
  implements View.OnClickListener
{
  b$24(b paramb) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TimelineClickListener", "onsight click");
    Object localObject1;
    if ((paramView.getTag() instanceof aj)) {
      localObject1 = (aj)paramView.getTag();
    }
    for (;;)
    {
      n localn = af.bDF().OB(((aj)localObject1).bJQ);
      if (localn == null) {}
      boolean bool;
      bxk localbxk;
      awd localawd;
      do
      {
        return;
        if ((paramView.getTag() instanceof a.c))
        {
          localObject1 = ((a.c)paramView.getTag()).plQ;
          break;
        }
        if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
          break label2369;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.ui.b.a.a)paramView.getTag()).plQ;
        break;
        if (this.ppl.oOe != null) {
          this.ppl.oOe.bDk().y(localn);
        }
        bool = localn.yr(32);
        if ((bool) && (localn.bFZ() != null) && ((localn.bFZ().bEJ()) || (localn.bFZ().bEK())))
        {
          this.ppl.ppf.onClick(paramView);
          return;
        }
        localbxk = ((aj)localObject1).oTF;
        if ((localbxk.tNr.sPJ == null) || (localbxk.tNr.sPJ.size() == 0))
        {
          y.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
          return;
        }
        localawd = (awd)localbxk.tNr.sPJ.get(0);
        if (!bool) {
          break label343;
        }
        af.bDC();
        if (g.t(localawd)) {
          break label343;
        }
        ((aj)localObject1).oGT.setVisibility(8);
        ((aj)localObject1).oTI.setVisibility(0);
        ((aj)localObject1).oTI.cJO();
        af.bDC().z(localawd);
        paramView = af.bDA();
        localObject1 = az.cvd();
        ((az)localObject1).time = localbxk.mPL;
        paramView.a(localawd, 4, null, (az)localObject1);
      } while (!bool);
      j.a(j.b.olY, j.a.olP, localn, this.ppl.source);
      return;
      label343:
      if ((localn.yr(32)) && (localn.bFZ().bEE()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(localn.bGN().field_adxml))) {}
      Object localObject2;
      int j;
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (!bool) || (!af.bDC().u(localawd))) {
          break label517;
        }
        af.bDC().z(localawd);
        ((aj)localObject1).oGT.setVisibility(8);
        ((aj)localObject1).oTI.setVisibility(8);
        paramView = af.bDC();
        localObject2 = ((aj)localObject1).ogP;
        i = this.ppl.activity.hashCode();
        j = ((aj)localObject1).position;
        localObject1 = az.cvd();
        ((az)localObject1).time = localbxk.mPL;
        paramView.a(localn, localawd, (com.tencent.mm.plugin.sight.decode.a.a)localObject2, i, j, (az)localObject1, bool);
        if (!bool) {
          break;
        }
        j.a(j.b.olY, j.a.olP, localn, this.ppl.source);
        return;
      }
      label517:
      com.tencent.mm.modelsns.b localb;
      label604:
      int m;
      label659:
      long l;
      if (this.ppl.source == 0)
      {
        localObject2 = com.tencent.mm.modelsns.b.jd(717);
        ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(localawd.lsK);
        ((com.tencent.mm.modelsns.b)localObject2).QX();
        if (this.ppl.source != 0) {
          break label1170;
        }
        localb = com.tencent.mm.modelsns.b.jd(745);
        localb.ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32));
        if (bool)
        {
          m = this.ppl.source;
          if (this.ppl.source != 0) {
            break label1181;
          }
          i = 1;
          l = localn.field_snsId;
          if (!localn.bFZ().bEE()) {
            break label1186;
          }
          j = 21;
          label680:
          if (!localn.bFZ().bEE()) {
            break label1192;
          }
        }
      }
      Object localObject3;
      String str1;
      label1170:
      label1181:
      label1186:
      label1192:
      for (int k = 0;; k = 21)
      {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, l, j, k));
        if ((!localn.bFZ().bEE()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(localn.bGN().field_adxml))) {
          j.a(j.b.olY, j.a.olQ, localn, this.ppl.source);
        }
        localObject2 = "";
        localObject3 = an.eJ(af.getAccSnsPath(), localawd.lsK);
        str1 = "";
        String str2 = com.tencent.mm.plugin.sns.data.i.j(localawd);
        if (com.tencent.mm.vfs.e.bK((String)localObject3 + str2))
        {
          localObject2 = (String)localObject3 + str2;
          str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.e(localawd);
        }
        if (com.tencent.mm.vfs.e.bK((String)localObject3 + com.tencent.mm.plugin.sns.data.i.p(localawd)))
        {
          localObject2 = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.p(localawd);
          str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.n(localawd);
        }
        localObject3 = new int[2];
        paramView.getLocationInWindow((int[])localObject3);
        i = paramView.getWidth();
        j = paramView.getHeight();
        h.nFQ.f(11444, new Object[] { Integer.valueOf(3) });
        if (bool) {
          break label1199;
        }
        y.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
        paramView = new Intent();
        paramView.setClass(this.ppl.activity, SnsOnlineVideoActivity.class);
        paramView.putExtra("intent_videopath", (String)localObject2);
        paramView.putExtra("intent_thumbpath", str1);
        paramView.putExtra("intent_localid", ((aj)localObject1).bJQ);
        paramView.putExtra("intent_isad", bool);
        paramView.putExtra("intent_from_scene", this.ppl.source);
        paramView.putExtra("img_gallery_left", localObject3[0]);
        paramView.putExtra("img_gallery_top", localObject3[1]);
        paramView.putExtra("img_gallery_width", i);
        paramView.putExtra("img_gallery_height", j);
        localb.b(paramView, "intent_key_StatisticsOplog");
        this.ppl.activity.startActivity(paramView);
        this.ppl.activity.overridePendingTransition(0, 0);
        b.a(this.ppl, localn.bGe());
        return;
        localObject2 = com.tencent.mm.modelsns.b.je(717);
        break;
        localb = com.tencent.mm.modelsns.b.je(745);
        break label604;
        i = 2;
        break label659;
        j = 17;
        break label680;
      }
      label1199:
      if ((localn.yr(32)) && (localn.bFZ().bEE()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(localn.bGN().field_adxml)))
      {
        paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(localn);
        if (!bk.bl(paramView)) {
          localn.bGN().field_adxml = paramView;
        }
        paramView = new Intent();
        paramView.putExtra("img_gallery_left", localObject3[0]);
        paramView.putExtra("img_gallery_top", localObject3[1]);
        paramView.putExtra("img_gallery_width", i);
        paramView.putExtra("img_gallery_height", j);
        paramView.putExtra("sns_landing_pages_share_sns_id", localn.bGk());
        paramView.putExtra("sns_landing_pages_rawSnsId", localn.bGe().lsK);
        paramView.putExtra("sns_landing_pages_ux_info", localn.bGM());
        localObject1 = localn.bGe();
        if (localObject1 != null)
        {
          localObject1 = ((bxk)localObject1).tNr.sPJ;
          if (((List)localObject1).size() > 0) {
            paramView.putExtra("sns_landing_pages_share_thumb_url", ((awd)((List)localObject1).get(0)).trP);
          }
        }
        paramView.setClass(this.ppl.activity, SnsAdNativeLandingPagesUI.class);
        i = 1;
        if (this.ppl.source == 2) {
          i = 16;
        }
        for (;;)
        {
          paramView.putExtra("sns_landig_pages_from_source", i);
          paramView.putExtra("sns_landing_pages_xml", localn.bGN().field_adxml);
          paramView.putExtra("sns_landing_pages_rec_src", localn.bGO());
          paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
          paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
          paramView.putExtra("sns_landing_is_native_sight_ad", true);
          this.ppl.activity.startActivity(paramView);
          this.ppl.activity.overridePendingTransition(0, 0);
          return;
          if (this.ppl.source == 1) {
            i = 2;
          }
        }
      }
      paramView = new Intent();
      paramView.setClass(this.ppl.activity, SnsSightPlayerUI.class);
      paramView.putExtra("intent_videopath", (String)localObject2);
      paramView.putExtra("intent_thumbpath", str1);
      paramView.putExtra("intent_localid", ((aj)localObject1).bJQ);
      paramView.putExtra("intent_isad", bool);
      paramView.putExtra("intent_from_scene", this.ppl.source);
      paramView.putExtra("img_gallery_left", localObject3[0]);
      paramView.putExtra("img_gallery_top", localObject3[1]);
      paramView.putExtra("img_gallery_width", i);
      paramView.putExtra("img_gallery_height", j);
      localb.b(paramView, "intent_key_StatisticsOplog");
      this.ppl.activity.startActivity(paramView);
      this.ppl.activity.overridePendingTransition(0, 0);
      new ah().postDelayed(new b.24.1(this, localawd, (aj)localObject1, localn, localbxk, bool), 500L);
      paramView = new int[3];
      if ((!bool) && (af.bDC().a(localn, paramView) > 5))
      {
        af.bDC().y(localawd);
        i = 1;
      }
      label2364:
      for (;;)
      {
        int n = paramView[0];
        int i1 = paramView[1];
        if (i == 2) {}
        for (m = 1;; m = 0)
        {
          int i2 = paramView[2];
          paramView = localn.bGe();
          localObject1 = new d();
          ((d)localObject1).j("20FeedId", paramView.lsK + ",");
          ((d)localObject1).j("21AdUxInfo", localn.bGM() + ",");
          for (;;)
          {
            try
            {
              paramView = (bto)new bto().aH(localn.field_attrBuf);
              if (paramView.tKl == null) {
                continue;
              }
              paramView = (btw)new btw().aH(paramView.tKl.tFM.oY);
              if (paramView.tKA == null) {
                continue;
              }
              k = paramView.tKA.sQC;
            }
            catch (Exception paramView)
            {
              k = 0;
              y.printErrStackTrace("MicroMsg.TimelineClickListener", paramView, "", new Object[0]);
              j = 0;
              continue;
              if (aq.is2G(com.tencent.mm.sdk.platformtools.ae.getContext()))
              {
                i = 2;
                continue;
              }
              if (aq.is3G(com.tencent.mm.sdk.platformtools.ae.getContext()))
              {
                i = 3;
                continue;
              }
              if (!aq.is4G(com.tencent.mm.sdk.platformtools.ae.getContext())) {
                continue;
              }
              i = 4;
              continue;
              j = 0;
              k = 0;
              continue;
              i = 2;
            }
            try
            {
              j = paramView.tKA.sQD;
              ((d)localObject1).j("22LayerId", k + ",");
              ((d)localObject1).j("23ExpId", j + ",");
              ((d)localObject1).j("24ClickState", i + ",");
              ((d)localObject1).j("25ClickTime", bk.UX() + ",");
              i = 0;
              if (!aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext())) {
                continue;
              }
              i = 1;
              ((d)localObject1).j("26NetworkType", i + ",");
              ((d)localObject1).j("27IsFlowControl", n + ",");
              ((d)localObject1).j("28AutoDownloadSetting", i1 + ",");
              ((d)localObject1).j("29IsAutoPlay", m + ",");
              ((d)localObject1).j("30IsFlowControlDatePeriod", i2 + ",");
              y.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((d)localObject1).uJ());
              h.nFQ.f(13323, new Object[] { localObject1 });
              return;
            }
            catch (Exception paramView) {}
          }
          if ((!bool) || (af.bDC().b(localn, paramView) <= 5)) {
            break label2364;
          }
          af.bDC().y(localawd);
          i = 1;
          break;
        }
      }
      label2369:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.24
 * JD-Core Version:    0.7.0.1
 */