package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(40289);
    Object localObject1 = paramView.getTag();
    com.tencent.mm.plugin.sns.storage.n localn = null;
    Object localObject2;
    if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
    {
      localObject1 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
      localn = h.abu(((BaseTimeLineItem.BaseViewHolder)localObject1).czw);
      localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject1).sgW;
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      label195:
      boolean bool1;
      if (localn != null)
      {
        localObject3 = localn.csQ();
        int m = ((e)localObject3).getSource();
        if ((localn != null) && (localn.Ex(32)))
        {
          localObject4 = b.a(this.skd, localn);
          if ((localn.csb().cqk()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(localn.csQ().field_adxml)))
          {
            localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y(localn);
            if (!bo.isNullOrNil((String)localObject4)) {
              ((e)localObject3).field_adxml = ((String)localObject4);
            }
            localObject3 = new int[2];
            paramView.getLocationInWindow((int[])localObject3);
            int j = paramView.getWidth();
            int k = paramView.getHeight();
            if (localObject2 != null)
            {
              ((TagImageView)localObject2).getLocationInWindow((int[])localObject3);
              j = ((TagImageView)localObject2).getWidth();
              k = ((TagImageView)localObject2).getHeight();
              paramView = new Intent();
              paramView.putExtra("img_gallery_left", localObject3[0]);
              paramView.putExtra("img_gallery_top", localObject3[1]);
              paramView.putExtra("img_gallery_width", j);
              paramView.putExtra("img_gallery_height", k);
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
              j = 9;
              if (m != 2) {
                break label538;
              }
              j = 16;
            }
            for (;;)
            {
              paramView.putExtra("sns_landig_pages_from_source", j);
              paramView.putExtra("sns_landing_pages_xml", localn.csQ().field_adxml);
              paramView.putExtra("sns_landing_pages_rec_src", localn.csR());
              paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
              paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
              paramView.putExtra("sns_landing_is_native_sight_ad", true);
              this.skd.activity.startActivity(paramView);
              this.skd.activity.overridePendingTransition(0, 0);
              if (m == 0) {
                i = 1;
              }
              com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, localn.field_snsId, 23, 21));
              AppMethodBeat.o(40289);
              return;
              if (!(localObject1 instanceof com.tencent.mm.plugin.sns.storage.n)) {
                break label1138;
              }
              localn = (com.tencent.mm.plugin.sns.storage.n)localObject1;
              localObject1 = (MMImageView)paramView.getTag(2131820637);
              localObject2 = null;
              break;
              if (localObject1 == null) {
                break label195;
              }
              ((MMImageView)localObject1).getLocationInWindow((int[])localObject3);
              j = ((MMImageView)localObject1).getWidth();
              k = ((MMImageView)localObject1).getHeight();
              break label195;
              label538:
              if (m == 1) {
                j = 10;
              }
            }
          }
          if ((localObject4 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject4).rpg == 1))
          {
            paramView = new Intent();
            paramView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject4).rpi);
            paramView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject4).rpj);
            paramView.putExtra("key_from_scene", 21);
            paramView.putExtra("key_stastic_scene", 15);
            d.b(this.skd.activity, "card", ".ui.CardDetailUI", paramView);
            if (m == 0) {
              i = 1;
            }
            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, localn.field_snsId, 23, 11));
            AppMethodBeat.o(40289);
            return;
          }
          if (b.a(this.skd, (com.tencent.mm.plugin.sns.storage.a)localObject4, localn, false))
          {
            if (m == 0) {
              i = 1;
            }
            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, i, localn.field_snsId, 23, 31));
            AppMethodBeat.o(40289);
            return;
          }
        }
        if (m == 0) {
          i = 1;
        }
        localObject2 = new SnsAdClick(m, i, localn.field_snsId, 23, 0);
        com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
        localObject1 = localn.csO();
        paramView = (View)localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          paramView = localn.getAdLink();
        }
        ab.i("MicroMsg.TimelineClickListener", "adlink url " + paramView + " " + localn.csb().rpQ);
        localObject4 = new Intent();
        if (localn.csb().rpQ != 0) {
          break label1129;
        }
        bool1 = true;
        if (!ae.gkT) {
          break label1135;
        }
        bool1 = bool2;
      }
      label1129:
      label1135:
      for (;;)
      {
        localObject1 = paramView;
        if (localn != null)
        {
          localObject1 = paramView;
          if (localn.Ex(32))
          {
            com.tencent.mm.plugin.sns.storage.a locala = b.a(this.skd, localn);
            localObject1 = paramView;
            if (locala != null)
            {
              ((Intent)localObject4).putExtra("KsnsViewId", locala.hpq);
              localObject1 = com.tencent.mm.plugin.sns.data.i.gg(paramView, locala.cFe);
            }
          }
        }
        ((Intent)localObject4).putExtra("KRightBtn", bool1);
        paramView = new Bundle();
        paramView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
        paramView.putString("key_snsad_statextstr", ((e)localObject3).csh().rHA);
        ((Intent)localObject4).putExtra("jsapiargs", paramView);
        ((Intent)localObject4).putExtra("rawUrl", (String)localObject1);
        ((Intent)localObject4).putExtra("useJs", true);
        ((Intent)localObject4).putExtra("srcUsername", localn.field_userName);
        ((Intent)localObject4).putExtra("stastic_scene", 15);
        ((Intent)localObject4).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
        ((Intent)localObject4).putExtra("pre_username", localn.field_userName);
        ((Intent)localObject4).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId));
        ((Intent)localObject4).putExtra("preUsername", localn.field_userName);
        com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject4, this.skd.activity);
        AppMethodBeat.o(40289);
        return;
        bool1 = false;
        break;
      }
      label1138:
      localObject1 = null;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.32
 * JD-Core Version:    0.7.0.1
 */