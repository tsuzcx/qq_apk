package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.c.c;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.List;
import java.util.Map;

final class b$34
  implements View.OnClickListener
{
  b$34(b paramb) {}
  
  public final void onClick(View paramView)
  {
    int i = 2;
    boolean bool2 = false;
    AppMethodBeat.i(40296);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof Long)))
    {
      AppMethodBeat.o(40296);
      return;
    }
    long l = ((Long)paramView.getTag()).longValue();
    e locale = ag.cpi().lQ(l);
    com.tencent.mm.plugin.sns.storage.n localn = locale.csn();
    k.a(k.b.ram, k.a.rak, locale.csn(), this.skd.cpt);
    locale.getSource();
    paramView = localn.csO();
    if (bo.isNullOrNil(paramView)) {
      paramView = localn.getAdLink();
    }
    for (;;)
    {
      Object localObject1;
      int j;
      Object localObject2;
      if (localn.Ex(32))
      {
        localObject1 = b.a(this.skd, localn);
        j = -1;
        localObject2 = c.abV().aqM("Sns_CanvasAd_DetailLink_JumpWay");
        if (((com.tencent.mm.storage.a)localObject2).isValid()) {
          j = bo.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);
        }
        if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).rpg == 1))
        {
          paramView = new Intent();
          paramView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject1).rpi);
          paramView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject1).rpj);
          paramView.putExtra("key_from_scene", 21);
          paramView.putExtra("key_stastic_scene", 15);
          d.b(this.skd.activity, "card", ".ui.CardDetailUI", paramView);
          j = this.skd.cpt;
          if (this.skd.cpt == 0) {
            i = 1;
          }
          paramView = new SnsAdClick(j, i, localn.field_snsId, 3, 11);
          if (this.skd.rOU == null) {}
          for (l = 0L;; l = this.skd.rOU.di(localn.csH(), 3))
          {
            paramView.fQA = l;
            com.tencent.mm.plugin.sns.data.i.a(paramView);
            AppMethodBeat.o(40296);
            return;
          }
        }
        if ((localObject1 != null) && (j == 1))
        {
          if ((localn.csb().cqk()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml)))
          {
            paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(localn);
            if (!bo.isNullOrNil(paramView)) {
              locale.field_adxml = paramView;
            }
            paramView = new Intent();
            paramView.putExtra("sns_landing_pages_share_sns_id", localn.getSnsId());
            paramView.putExtra("sns_landing_pages_rawSnsId", localn.csh().Id);
            paramView.putExtra("sns_landing_pages_ux_info", localn.csP());
            paramView.putExtra("sns_landing_pages_aid", localn.csM());
            paramView.putExtra("sns_landing_pages_traceid", localn.csN());
            localObject1 = localn.csh();
            if (localObject1 != null)
            {
              localObject1 = ((TimeLineObject)localObject1).xTS.wOa;
              if (((List)localObject1).size() > 0) {
                paramView.putExtra("sns_landing_pages_share_thumb_url", ((bcs)((List)localObject1).get(0)).xrS);
              }
            }
            paramView.setClass(this.skd.activity, SnsAdNativeLandingPagesUI.class);
            j = 9;
            if (this.skd.cpt == 2)
            {
              j = 16;
              paramView.putExtra("sns_landig_pages_from_source", j);
              paramView.putExtra("sns_landing_pages_xml", localn.csQ().field_adxml);
              paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              paramView.putExtra("sns_landing_pages_rec_src", localn.csR());
              paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
              this.skd.activity.startActivity(paramView);
              this.skd.activity.overridePendingTransition(0, 0);
              j = this.skd.cpt;
              if (this.skd.cpt == 0) {
                i = 1;
              }
              paramView = new SnsAdClick(j, i, localn.field_snsId, 3, 21);
              if (this.skd.rOU != null) {
                break label704;
              }
            }
            label704:
            for (l = 0L;; l = this.skd.rOU.di(localn.csH(), 3))
            {
              paramView.fQA = l;
              com.tencent.mm.plugin.sns.data.i.a(paramView);
              AppMethodBeat.o(40296);
              return;
              if (this.skd.cpt != 1) {
                break;
              }
              j = 10;
              break;
            }
          }
        }
        else if ((localObject1 != null) && (j == 0))
        {
          if ((!localn.csb().cqk()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml))) {
            break label1831;
          }
          localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(localn);
          if (!bo.isNullOrNil((String)localObject1)) {
            locale.field_adxml = ((String)localObject1);
          }
          localObject1 = br.F(localn.csQ().field_adxml, "adxml");
          if (localObject1 != null)
          {
            localObject1 = bo.bf((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
            if (!bo.isNullOrNil((String)localObject1)) {
              paramView = (View)localObject1;
            }
          }
        }
      }
      label1677:
      label1822:
      label1828:
      label1831:
      for (;;)
      {
        j = this.skd.cpt;
        if (this.skd.cpt == 0) {
          i = 1;
        }
        localObject2 = new SnsAdClick(j, i, localn.field_snsId, 3, 0);
        label885:
        Intent localIntent;
        boolean bool1;
        if (this.skd.rOU == null)
        {
          l = 0L;
          ((SnsAdClick)localObject2).fQA = l;
          com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
          ab.i("MicroMsg.TimelineClickListener", "adlink url " + paramView + " " + localn.csb().rpQ);
          localIntent = new Intent();
          if (localn.csb().rpQ != 0) {
            break label1822;
          }
          bool1 = true;
          label960:
          if (!ae.gkT) {
            break label1828;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          localObject1 = paramView;
          if (localn.Ex(32))
          {
            com.tencent.mm.plugin.sns.storage.a locala = b.a(this.skd, localn);
            localObject1 = paramView;
            if (locala != null)
            {
              localIntent.putExtra("KsnsViewId", locala.hpq);
              localObject1 = com.tencent.mm.plugin.sns.data.i.gg(paramView, locala.cFe);
            }
          }
          localIntent.putExtra("KRightBtn", bool1);
          paramView = new Bundle();
          paramView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
          paramView.putString("key_snsad_statextstr", locale.csh().rHA);
          localIntent.putExtra("jsapiargs", paramView);
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("srcUsername", localn.field_userName);
          localIntent.putExtra("sns_local_id", localn.csH());
          localIntent.putExtra("stastic_scene", 15);
          localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
          localIntent.putExtra("pre_username", localn.field_userName);
          localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
          localIntent.putExtra("preUsername", localn.field_userName);
          com.tencent.mm.plugin.sns.c.a.gmO.i(localIntent, this.skd.activity);
          AppMethodBeat.o(40296);
          return;
          ab.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localn.csQ().field_adxml);
          break;
          if ((localObject1 != null) && (j == -1) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).rpg == 3))
          {
            if ((!localn.csb().cqk()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml))) {
              break label1831;
            }
            paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(localn);
            if (!bo.isNullOrNil(paramView)) {
              locale.field_adxml = paramView;
            }
            paramView = new Intent();
            paramView.putExtra("sns_landing_pages_share_sns_id", localn.getSnsId());
            paramView.putExtra("sns_landing_pages_rawSnsId", localn.csh().Id);
            paramView.putExtra("sns_landing_pages_ux_info", localn.csP());
            paramView.putExtra("sns_landing_pages_aid", localn.csM());
            paramView.putExtra("sns_landing_pages_traceid", localn.csN());
            localObject1 = localn.csh();
            if (localObject1 != null)
            {
              localObject1 = ((TimeLineObject)localObject1).xTS.wOa;
              if (((List)localObject1).size() > 0) {
                paramView.putExtra("sns_landing_pages_share_thumb_url", ((bcs)((List)localObject1).get(0)).xrS);
              }
            }
            paramView.setClass(this.skd.activity, SnsAdNativeLandingPagesUI.class);
            j = 9;
            if (this.skd.cpt == 2)
            {
              j = 16;
              paramView.putExtra("sns_landig_pages_from_source", j);
              paramView.putExtra("sns_landing_pages_xml", localn.csQ().field_adxml);
              paramView.putExtra("sns_landing_pages_rec_src", localn.csR());
              paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
              this.skd.activity.startActivity(paramView);
              this.skd.activity.overridePendingTransition(0, 0);
              j = this.skd.cpt;
              if (this.skd.cpt == 0) {
                i = 1;
              }
              paramView = new SnsAdClick(j, i, localn.field_snsId, 3, 21);
              if (this.skd.rOU != null) {
                break label1677;
              }
            }
            for (l = 0L;; l = this.skd.rOU.di(localn.csH(), 3))
            {
              paramView.fQA = l;
              com.tencent.mm.plugin.sns.data.i.a(paramView);
              AppMethodBeat.o(40296);
              return;
              if (this.skd.cpt != 1) {
                break;
              }
              j = 10;
              break;
            }
          }
          if (!b.a(this.skd, (com.tencent.mm.plugin.sns.storage.a)localObject1, localn, false)) {
            break label1831;
          }
          j = this.skd.cpt;
          if (this.skd.cpt == 0) {
            i = 1;
          }
          paramView = new SnsAdClick(j, i, localn.field_snsId, 3, 31);
          if (this.skd.rOU == null) {}
          for (l = 0L;; l = this.skd.rOU.di(localn.csH(), 3))
          {
            paramView.fQA = l;
            com.tencent.mm.plugin.sns.data.i.a(paramView);
            AppMethodBeat.o(40296);
            return;
          }
          l = this.skd.rOU.di(localn.csH(), 3);
          break label885;
          bool1 = false;
          break label960;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.34
 * JD-Core Version:    0.7.0.1
 */