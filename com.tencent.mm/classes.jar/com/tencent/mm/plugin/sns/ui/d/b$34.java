package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.c.c;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof Long))) {
      return;
    }
    long l = ((Long)paramView.getTag()).longValue();
    e locale = af.bDI().gk(l);
    n localn = locale.bGl();
    j.a(j.b.olY, j.a.olW, locale.bGl(), this.ppl.source);
    locale.getSource();
    paramView = localn.bGL();
    if (bk.bl(paramView)) {
      paramView = localn.getAdLink();
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if (localn.yr(32))
      {
        localObject1 = b.a(this.ppl, localn);
        localObject2 = c.IY().aaB("Sns_CanvasAd_DetailLink_JumpWay");
        if (!((com.tencent.mm.storage.a)localObject2).isValid()) {
          break label1570;
        }
      }
      label1564:
      label1567:
      label1570:
      for (int j = bk.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);; j = -1)
      {
        if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).ozW == 1))
        {
          paramView = new Intent();
          paramView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject1).ozY);
          paramView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject1).ozZ);
          paramView.putExtra("key_from_scene", 21);
          paramView.putExtra("key_stastic_scene", 15);
          d.b(this.ppl.activity, "card", ".ui.CardDetailUI", paramView);
          j = this.ppl.source;
          if (this.ppl.source == 0) {
            i = 1;
          }
          com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(j, i, localn.field_snsId, 3, 11));
          return;
        }
        if ((localObject1 != null) && (j == 1))
        {
          if ((localn.bFZ().bEE()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(localn.bGN().field_adxml)))
          {
            paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(localn);
            if (!bk.bl(paramView)) {
              locale.field_adxml = paramView;
            }
            paramView = new Intent();
            paramView.putExtra("sns_landing_pages_share_sns_id", localn.bGk());
            paramView.putExtra("sns_landing_pages_rawSnsId", localn.bGe().lsK);
            paramView.putExtra("sns_landing_pages_ux_info", localn.bGM());
            paramView.putExtra("sns_landing_pages_aid", localn.bGJ());
            paramView.putExtra("sns_landing_pages_traceid", localn.bGK());
            localObject1 = localn.bGe();
            if (localObject1 != null)
            {
              localObject1 = ((bxk)localObject1).tNr.sPJ;
              if (((List)localObject1).size() > 0) {
                paramView.putExtra("sns_landing_pages_share_thumb_url", ((awd)((List)localObject1).get(0)).trP);
              }
            }
            paramView.setClass(this.ppl.activity, SnsAdNativeLandingPagesUI.class);
            j = 9;
            if (this.ppl.source == 2) {
              j = 16;
            }
            for (;;)
            {
              paramView.putExtra("sns_landig_pages_from_source", j);
              paramView.putExtra("sns_landing_pages_xml", localn.bGN().field_adxml);
              paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              paramView.putExtra("sns_landing_pages_rec_src", localn.bGO());
              paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
              this.ppl.activity.startActivity(paramView);
              this.ppl.activity.overridePendingTransition(0, 0);
              j = this.ppl.source;
              if (this.ppl.source == 0) {
                i = 1;
              }
              com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(j, i, localn.field_snsId, 3, 21));
              return;
              if (this.ppl.source == 1) {
                j = 10;
              }
            }
          }
        }
        else if ((localObject1 != null) && (j == 0))
        {
          if ((!localn.bFZ().bEE()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(localn.bGN().field_adxml))) {
            break label1567;
          }
          localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(localn);
          if (!bk.bl((String)localObject1)) {
            locale.field_adxml = ((String)localObject1);
          }
          localObject1 = bn.s(localn.bGN().field_adxml, "adxml");
          if (localObject1 != null)
          {
            localObject1 = bk.aM((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
            if (!bk.bl((String)localObject1)) {
              paramView = (View)localObject1;
            }
          }
        }
        for (;;)
        {
          j = this.ppl.source;
          if (this.ppl.source == 0) {
            i = 1;
          }
          localObject1 = new SnsAdClick(j, i, localn.field_snsId, 3, 0);
          com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject1);
          y.i("MicroMsg.TimelineClickListener", "adlink url " + paramView + " " + localn.bFZ().oAG);
          localObject2 = new Intent();
          boolean bool1;
          if (localn.bFZ().oAG == 0)
          {
            bool1 = true;
            label832:
            if (!ae.eSY) {
              break label1564;
            }
            bool1 = bool2;
          }
          for (;;)
          {
            if (localn.yr(32))
            {
              localObject3 = b.a(this.ppl, localn);
              if (localObject3 != null) {
                ((Intent)localObject2).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject3).fVM);
              }
            }
            ((Intent)localObject2).putExtra("KRightBtn", bool1);
            Object localObject3 = new Bundle();
            ((Bundle)localObject3).putParcelable("KSnsAdTag", (Parcelable)localObject1);
            ((Bundle)localObject3).putString("key_snsad_statextstr", locale.bGe().oPO);
            ((Intent)localObject2).putExtra("jsapiargs", (Bundle)localObject3);
            ((Intent)localObject2).putExtra("rawUrl", paramView);
            ((Intent)localObject2).putExtra("useJs", true);
            ((Intent)localObject2).putExtra("srcUsername", localn.field_userName);
            ((Intent)localObject2).putExtra("sns_local_id", localn.bGE());
            ((Intent)localObject2).putExtra("stastic_scene", 15);
            ((Intent)localObject2).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId));
            ((Intent)localObject2).putExtra("pre_username", localn.field_userName);
            ((Intent)localObject2).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId));
            ((Intent)localObject2).putExtra("preUsername", localn.field_userName);
            com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject2, this.ppl.activity);
            return;
            y.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localn.bGN().field_adxml);
            break;
            if ((localObject1 != null) && (j == -1) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).ozW == 3))
            {
              if ((!localn.bFZ().bEE()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(localn.bGN().field_adxml))) {
                break label1567;
              }
              paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z(localn);
              if (!bk.bl(paramView)) {
                locale.field_adxml = paramView;
              }
              paramView = new Intent();
              paramView.putExtra("sns_landing_pages_share_sns_id", localn.bGk());
              paramView.putExtra("sns_landing_pages_rawSnsId", localn.bGe().lsK);
              paramView.putExtra("sns_landing_pages_ux_info", localn.bGM());
              paramView.putExtra("sns_landing_pages_aid", localn.bGJ());
              paramView.putExtra("sns_landing_pages_traceid", localn.bGK());
              localObject1 = localn.bGe();
              if (localObject1 != null)
              {
                localObject1 = ((bxk)localObject1).tNr.sPJ;
                if (((List)localObject1).size() > 0) {
                  paramView.putExtra("sns_landing_pages_share_thumb_url", ((awd)((List)localObject1).get(0)).trP);
                }
              }
              paramView.setClass(this.ppl.activity, SnsAdNativeLandingPagesUI.class);
              j = 9;
              if (this.ppl.source == 2) {
                j = 16;
              }
              for (;;)
              {
                paramView.putExtra("sns_landig_pages_from_source", j);
                paramView.putExtra("sns_landing_pages_xml", localn.bGN().field_adxml);
                paramView.putExtra("sns_landing_pages_rec_src", localn.bGO());
                paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                this.ppl.activity.startActivity(paramView);
                this.ppl.activity.overridePendingTransition(0, 0);
                j = this.ppl.source;
                if (this.ppl.source == 0) {
                  i = 1;
                }
                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(j, i, localn.field_snsId, 3, 21));
                return;
                if (this.ppl.source == 1) {
                  j = 10;
                }
              }
            }
            if (!b.a(this.ppl, (com.tencent.mm.plugin.sns.storage.a)localObject1, localn, false)) {
              break label1567;
            }
            j = this.ppl.source;
            if (this.ppl.source == 0) {
              i = 1;
            }
            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(j, i, localn.field_snsId, 3, 31));
            return;
            bool1 = false;
            break label832;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.34
 * JD-Core Version:    0.7.0.1
 */