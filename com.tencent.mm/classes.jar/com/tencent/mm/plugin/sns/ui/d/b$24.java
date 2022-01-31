package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(40279);
    ab.i("MicroMsg.TimelineClickListener", "onsight click");
    Object localObject1;
    if ((paramView.getTag() instanceof aj)) {
      localObject1 = (aj)paramView.getTag();
    }
    for (;;)
    {
      n localn = ag.cpf().abv(((aj)localObject1).crk);
      if (localn == null)
      {
        ab.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((aj)localObject1).crk });
        AppMethodBeat.o(40279);
        return;
        if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramView.getTag()).sfG;
          continue;
        }
        if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
          localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag()).sfG;
        }
      }
      else
      {
        if (this.skd.rFN != null) {
          this.skd.rFN.coJ().x(localn);
        }
        boolean bool = localn.Ex(32);
        if ((bool) && (localn.csb() != null) && ((localn.csb().cqp()) || (localn.csb().cqq())))
        {
          this.skd.sjX.onClick(paramView);
          AppMethodBeat.o(40279);
          return;
        }
        TimeLineObject localTimeLineObject = ((aj)localObject1).rLC;
        if ((localTimeLineObject.xTS.wOa == null) || (localTimeLineObject.xTS.wOa.size() == 0))
        {
          ab.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
          AppMethodBeat.o(40279);
          return;
        }
        bcs localbcs = (bcs)localTimeLineObject.xTS.wOa.get(0);
        if (bool)
        {
          ag.cpc();
          if (!com.tencent.mm.plugin.sns.model.g.t(localbcs))
          {
            ((aj)localObject1).rwJ.setVisibility(8);
            ((aj)localObject1).rLF.setVisibility(0);
            ((aj)localObject1).rLF.dOF();
            ag.cpc().z(localbcs);
            paramView = ag.cpa();
            localObject1 = az.dxG();
            ((az)localObject1).oLs = localTimeLineObject.CreateTime;
            paramView.a(localbcs, 4, null, (az)localObject1);
            if (bool) {
              k.a(k.b.ram, k.a.rad, localn, this.skd.cpt);
            }
            AppMethodBeat.o(40279);
            return;
          }
        }
        if ((localn.Ex(32)) && (localn.csb().cqk()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml))) {}
        Object localObject2;
        int j;
        for (int i = 1; (i == 0) && (bool) && (ag.cpc().u(localbcs)); i = 0)
        {
          ag.cpc().z(localbcs);
          ((aj)localObject1).rwJ.setVisibility(8);
          ((aj)localObject1).rLF.setVisibility(8);
          paramView = ag.cpc();
          localObject2 = ((aj)localObject1).qVe;
          i = this.skd.activity.hashCode();
          j = ((aj)localObject1).position;
          localObject1 = az.dxG();
          ((az)localObject1).oLs = localTimeLineObject.CreateTime;
          paramView.a(localn, localbcs, (com.tencent.mm.plugin.sight.decode.a.a)localObject2, i, j, (az)localObject1, bool);
          if (bool) {
            k.a(k.b.ram, k.a.rad, localn, this.skd.cpt);
          }
          AppMethodBeat.o(40279);
          return;
        }
        com.tencent.mm.modelsns.b localb;
        label653:
        int m;
        label708:
        label729:
        int k;
        if (this.skd.cpt == 0)
        {
          localObject2 = com.tencent.mm.modelsns.b.lV(717);
          ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(localbcs.Id);
          ((com.tencent.mm.modelsns.b)localObject2).ake();
          if (this.skd.cpt != 0) {
            break label1370;
          }
          localb = com.tencent.mm.modelsns.b.lV(745);
          localb.uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32));
          if (bool)
          {
            m = this.skd.cpt;
            if (this.skd.cpt != 0) {
              break label1381;
            }
            i = 1;
            l = localn.field_snsId;
            if (!localn.csb().cqk()) {
              break label1386;
            }
            j = 21;
            if (!localn.csb().cqk()) {
              break label1392;
            }
            k = 21;
            label744:
            localObject2 = new SnsAdClick(m, i, l, j, k);
            if (!localn.csb().cqk()) {
              break label1420;
            }
            if (this.skd.rOU != null) {
              break label1398;
            }
          }
        }
        Object localObject3;
        String str1;
        label1370:
        label1381:
        label1386:
        label1392:
        label1398:
        for (long l = 0L;; l = this.skd.rOU.di(localn.csH(), 21))
        {
          ((SnsAdClick)localObject2).fQA = l;
          com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
          if ((!localn.csb().cqk()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml))) {
            k.a(k.b.ram, k.a.rae, localn, this.skd.cpt);
          }
          localObject2 = "";
          localObject3 = ao.gl(ag.getAccSnsPath(), localbcs.Id);
          str1 = "";
          String str2 = com.tencent.mm.plugin.sns.data.i.j(localbcs);
          if (com.tencent.mm.vfs.e.cN((String)localObject3 + str2))
          {
            localObject2 = (String)localObject3 + str2;
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.e(localbcs);
          }
          if (com.tencent.mm.vfs.e.cN((String)localObject3 + com.tencent.mm.plugin.sns.data.i.p(localbcs)))
          {
            localObject2 = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.p(localbcs);
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.n(localbcs);
          }
          localObject3 = new int[2];
          paramView.getLocationInWindow((int[])localObject3);
          i = paramView.getWidth();
          j = paramView.getHeight();
          h.qsU.e(11444, new Object[] { Integer.valueOf(3) });
          if (bool) {
            break label1465;
          }
          ab.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
          paramView = new Intent();
          paramView.setClass(this.skd.activity, SnsOnlineVideoActivity.class);
          paramView.putExtra("intent_videopath", (String)localObject2);
          paramView.putExtra("intent_thumbpath", str1);
          paramView.putExtra("intent_localid", ((aj)localObject1).crk);
          paramView.putExtra("intent_isad", bool);
          paramView.putExtra("intent_from_scene", this.skd.cpt);
          paramView.putExtra("sns_video_scene", ((aj)localObject1).rLH);
          localObject2 = c.cxv().acu(localTimeLineObject.Id);
          if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
          {
            paramView.putExtra("intent_fromplayingvideo", true);
            paramView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
            paramView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
            paramView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
            if (((aj)localObject1).rLD != null) {
              ((aj)localObject1).rLD.findViewById(2131828026).setVisibility(0);
            }
          }
          paramView.putExtra("img_gallery_left", localObject3[0]);
          paramView.putExtra("img_gallery_top", localObject3[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          localb.b(paramView, "intent_key_StatisticsOplog");
          this.skd.activity.startActivity(paramView);
          this.skd.activity.overridePendingTransition(0, 0);
          b.a(this.skd, localn.csh());
          AppMethodBeat.o(40279);
          return;
          localObject2 = com.tencent.mm.modelsns.b.lW(717);
          break;
          localb = com.tencent.mm.modelsns.b.lW(745);
          break label653;
          i = 2;
          break label708;
          j = 17;
          break label729;
          k = 0;
          break label744;
        }
        label1420:
        if (this.skd.rOU == null) {}
        for (l = 0L;; l = this.skd.rOU.di(localn.csH(), 17))
        {
          ((SnsAdClick)localObject2).fQA = l;
          break;
        }
        label1465:
        if ((localn.Ex(32)) && (localn.csb().cqk()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml)))
        {
          paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(localn);
          if (!bo.isNullOrNil(paramView)) {
            localn.csQ().field_adxml = paramView;
          }
          paramView = new Intent();
          paramView.putExtra("img_gallery_left", localObject3[0]);
          paramView.putExtra("img_gallery_top", localObject3[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          paramView.putExtra("sns_landing_pages_share_sns_id", localn.getSnsId());
          paramView.putExtra("sns_landing_pages_rawSnsId", localn.csh().Id);
          paramView.putExtra("sns_landing_pages_ux_info", localn.csP());
          localObject1 = localn.csh();
          if (localObject1 != null)
          {
            localObject1 = ((TimeLineObject)localObject1).xTS.wOa;
            if (((List)localObject1).size() > 0) {
              paramView.putExtra("sns_landing_pages_share_thumb_url", ((bcs)((List)localObject1).get(0)).xrS);
            }
          }
          paramView.setClass(this.skd.activity, SnsAdNativeLandingPagesUI.class);
          i = 1;
          if (this.skd.cpt == 2) {
            i = 16;
          }
          for (;;)
          {
            paramView.putExtra("sns_landig_pages_from_source", i);
            paramView.putExtra("sns_landing_pages_xml", localn.csQ().field_adxml);
            paramView.putExtra("sns_landing_pages_rec_src", localn.csR());
            paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
            paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            paramView.putExtra("sns_landing_is_native_sight_ad", true);
            this.skd.activity.startActivity(paramView);
            this.skd.activity.overridePendingTransition(0, 0);
            AppMethodBeat.o(40279);
            return;
            if (this.skd.cpt == 1) {
              i = 2;
            }
          }
        }
        paramView = new Intent();
        paramView.setClass(this.skd.activity, SnsSightPlayerUI.class);
        paramView.putExtra("intent_videopath", (String)localObject2);
        paramView.putExtra("intent_thumbpath", str1);
        paramView.putExtra("intent_localid", ((aj)localObject1).crk);
        paramView.putExtra("intent_isad", bool);
        paramView.putExtra("intent_from_scene", this.skd.cpt);
        paramView.putExtra("img_gallery_left", localObject3[0]);
        paramView.putExtra("img_gallery_top", localObject3[1]);
        paramView.putExtra("img_gallery_width", i);
        paramView.putExtra("img_gallery_height", j);
        localb.b(paramView, "intent_key_StatisticsOplog");
        this.skd.activity.startActivity(paramView);
        this.skd.activity.overridePendingTransition(0, 0);
        new ak().postDelayed(new b.24.1(this, localbcs, (aj)localObject1, localn, localTimeLineObject, bool), 500L);
        paramView = new int[3];
        if ((!bool) && (ag.cpc().a(localn, paramView) > 5))
        {
          ag.cpc().y(localbcs);
          i = 1;
        }
        label2637:
        for (;;)
        {
          int n = paramView[0];
          int i1 = paramView[1];
          if (i == 2) {}
          for (m = 1;; m = 0)
          {
            int i2 = paramView[2];
            paramView = localn.csh();
            localObject1 = new d();
            ((d)localObject1).k("20FeedId", paramView.Id + ",");
            ((d)localObject1).k("21AdUxInfo", localn.csP() + ",");
            for (;;)
            {
              try
              {
                paramView = (SnsObject)new SnsObject().parseFrom(localn.field_attrBuf);
                if (paramView.ObjectOperations == null) {
                  continue;
                }
                paramView = (cel)new cel().parseFrom(paramView.ObjectOperations.getBufferToBytes());
                if (paramView.xOP == null) {
                  continue;
                }
                k = paramView.xOP.wPd;
              }
              catch (Exception paramView)
              {
                k = 0;
                ab.printErrStackTrace("MicroMsg.TimelineClickListener", paramView, "", new Object[0]);
                j = 0;
                continue;
                if (at.is2G(ah.getContext()))
                {
                  i = 2;
                  continue;
                }
                if (at.is3G(ah.getContext()))
                {
                  i = 3;
                  continue;
                }
                if (!at.is4G(ah.getContext())) {
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
                j = paramView.xOP.wPe;
                ((d)localObject1).k("22LayerId", k + ",");
                ((d)localObject1).k("23ExpId", j + ",");
                ((d)localObject1).k("24ClickState", i + ",");
                ((d)localObject1).k("25ClickTime", bo.aox() + ",");
                i = 0;
                if (!at.isWifi(ah.getContext())) {
                  continue;
                }
                i = 1;
                ((d)localObject1).k("26NetworkType", i + ",");
                ((d)localObject1).k("27IsFlowControl", n + ",");
                ((d)localObject1).k("28AutoDownloadSetting", i1 + ",");
                ((d)localObject1).k("29IsAutoPlay", m + ",");
                ((d)localObject1).k("30IsFlowControlDatePeriod", i2 + ",");
                ab.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((d)localObject1).Fg());
                h.qsU.e(13323, new Object[] { localObject1 });
                AppMethodBeat.o(40279);
                return;
              }
              catch (Exception paramView) {}
            }
            if ((!bool) || (ag.cpc().b(localn, paramView) <= 5)) {
              break label2637;
            }
            ag.cpc().y(localbcs);
            i = 1;
            break;
          }
        }
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.24
 * JD-Core Version:    0.7.0.1
 */