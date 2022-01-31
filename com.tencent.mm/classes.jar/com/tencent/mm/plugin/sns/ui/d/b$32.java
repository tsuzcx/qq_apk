package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMImageView;
import java.util.List;

final class b$32
  implements View.OnClickListener
{
  b$32(b paramb) {}
  
  public final void onClick(View paramView)
  {
    int i = 2;
    boolean bool2 = false;
    Object localObject1 = paramView.getTag();
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof a.c))
    {
      localObject2 = (a.c)paramView.getTag();
      localObject1 = h.OA(((a.c)localObject2).bRV);
      localObject3 = ((a.c)localObject2).pmL;
      localObject2 = null;
    }
    for (;;)
    {
      Object localObject4;
      int m;
      Object localObject5;
      int j;
      int k;
      if (localObject1 != null)
      {
        localObject4 = ((n)localObject1).bGN();
        m = ((e)localObject4).getSource();
        if ((localObject1 == null) || (!((n)localObject1).yr(32))) {
          break label695;
        }
        localObject5 = b.a(this.ppl, (n)localObject1);
        if ((!((n)localObject1).bFZ().bEE()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(((n)localObject1).bGN().field_adxml))) {
          break label538;
        }
        localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z((n)localObject1);
        if (!bk.bl((String)localObject5)) {
          ((e)localObject4).field_adxml = ((String)localObject5);
        }
        localObject4 = new int[2];
        paramView.getLocationInWindow((int[])localObject4);
        j = paramView.getWidth();
        k = paramView.getHeight();
        if (localObject3 == null) {
          break label498;
        }
        ((TagImageView)localObject3).getLocationInWindow((int[])localObject4);
        j = ((TagImageView)localObject3).getWidth();
        k = ((TagImageView)localObject3).getHeight();
        label187:
        paramView = new Intent();
        paramView.putExtra("img_gallery_left", localObject4[0]);
        paramView.putExtra("img_gallery_top", localObject4[1]);
        paramView.putExtra("img_gallery_width", j);
        paramView.putExtra("img_gallery_height", k);
        paramView.putExtra("sns_landing_pages_share_sns_id", ((n)localObject1).bGk());
        paramView.putExtra("sns_landing_pages_rawSnsId", ((n)localObject1).bGe().lsK);
        paramView.putExtra("sns_landing_pages_ux_info", ((n)localObject1).bGM());
        localObject2 = ((n)localObject1).bGe();
        if (localObject2 != null)
        {
          localObject2 = ((bxk)localObject2).tNr.sPJ;
          if (((List)localObject2).size() > 0) {
            paramView.putExtra("sns_landing_pages_share_thumb_url", ((awd)((List)localObject2).get(0)).trP);
          }
        }
        paramView.setClass(this.ppl.activity, SnsAdNativeLandingPagesUI.class);
        j = 9;
        if (m != 2) {
          break label526;
        }
        j = 16;
      }
      for (;;)
      {
        paramView.putExtra("sns_landig_pages_from_source", j);
        paramView.putExtra("sns_landing_pages_xml", ((n)localObject1).bGN().field_adxml);
        paramView.putExtra("sns_landing_pages_rec_src", ((n)localObject1).bGO());
        paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
        paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        paramView.putExtra("sns_landing_is_native_sight_ad", true);
        this.ppl.activity.startActivity(paramView);
        this.ppl.activity.overridePendingTransition(0, 0);
        if (m == 0) {
          i = 1;
        }
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, ((n)localObject1).field_snsId, 23, 21));
        return;
        if (!(localObject1 instanceof n)) {
          break label1092;
        }
        localObject1 = (n)localObject1;
        localObject2 = (MMImageView)paramView.getTag(i.f.link_ad_left_iv);
        localObject3 = null;
        break;
        label498:
        if (localObject2 == null) {
          break label187;
        }
        ((MMImageView)localObject2).getLocationInWindow((int[])localObject4);
        j = ((MMImageView)localObject2).getWidth();
        k = ((MMImageView)localObject2).getHeight();
        break label187;
        label526:
        if (m == 1) {
          j = 10;
        }
      }
      label538:
      if ((localObject5 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject5).ozW == 1))
      {
        paramView = new Intent();
        paramView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject5).ozY);
        paramView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject5).ozZ);
        paramView.putExtra("key_from_scene", 21);
        paramView.putExtra("key_stastic_scene", 15);
        d.b(this.ppl.activity, "card", ".ui.CardDetailUI", paramView);
        if (m == 0) {
          i = 1;
        }
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, ((n)localObject1).field_snsId, 23, 11));
        return;
      }
      if (b.a(this.ppl, (com.tencent.mm.plugin.sns.storage.a)localObject5, (n)localObject1, false))
      {
        if (m == 0) {
          i = 1;
        }
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, ((n)localObject1).field_snsId, 23, 31));
        return;
      }
      label695:
      if (m == 0) {
        i = 1;
      }
      localObject3 = new SnsAdClick(m, i, ((n)localObject1).field_snsId, 23, 0);
      com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject3);
      localObject2 = ((n)localObject1).bGL();
      paramView = (View)localObject2;
      if (bk.bl((String)localObject2)) {
        paramView = ((n)localObject1).getAdLink();
      }
      y.i("MicroMsg.TimelineClickListener", "adlink url " + paramView + " " + ((n)localObject1).bFZ().oAG);
      localObject2 = new Intent();
      boolean bool1;
      if (((n)localObject1).bFZ().oAG == 0)
      {
        bool1 = true;
        if (!ae.eSY) {
          break label1089;
        }
        bool1 = bool2;
      }
      label1089:
      for (;;)
      {
        if ((localObject1 != null) && (((n)localObject1).yr(32)))
        {
          localObject5 = b.a(this.ppl, (n)localObject1);
          if (localObject5 != null) {
            ((Intent)localObject2).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject5).fVM);
          }
        }
        ((Intent)localObject2).putExtra("KRightBtn", bool1);
        localObject5 = new Bundle();
        ((Bundle)localObject5).putParcelable("KSnsAdTag", (Parcelable)localObject3);
        ((Bundle)localObject5).putString("key_snsad_statextstr", ((e)localObject4).bGe().oPO);
        ((Intent)localObject2).putExtra("jsapiargs", (Bundle)localObject5);
        ((Intent)localObject2).putExtra("rawUrl", paramView);
        ((Intent)localObject2).putExtra("useJs", true);
        ((Intent)localObject2).putExtra("srcUsername", ((n)localObject1).field_userName);
        ((Intent)localObject2).putExtra("stastic_scene", 15);
        ((Intent)localObject2).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject1).field_snsId));
        ((Intent)localObject2).putExtra("pre_username", ((n)localObject1).field_userName);
        ((Intent)localObject2).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject1).field_snsId));
        ((Intent)localObject2).putExtra("preUsername", ((n)localObject1).field_userName);
        com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject2, this.ppl.activity);
        return;
        bool1 = false;
        break;
      }
      label1092:
      localObject2 = null;
      localObject3 = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.32
 * JD-Core Version:    0.7.0.1
 */