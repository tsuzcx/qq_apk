package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.a.c;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class b$9
  implements View.OnClickListener
{
  b$9(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40255);
    Object localObject1 = null;
    if ((paramView.getTag() instanceof ao)) {
      localObject1 = ((ao)paramView.getTag()).ctV;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = h.abv((String)localObject1);
      if (localObject2 != null) {
        break;
      }
      ab.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(40255);
      return;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
        localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramView.getTag()).crk;
      } else if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
        localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag()).rMD.csH();
      }
    }
    if ((((n)localObject2).Ex(32)) && (((n)localObject2).csb() != null) && ((((n)localObject2).csb().cqp()) || (((n)localObject2).csb().cqq())))
    {
      this.skd.sjX.onClick(paramView);
      AppMethodBeat.o(40255);
      return;
    }
    if (((n)localObject2).csh().xTS.wNZ == 21)
    {
      if (r.Zn().equals(((n)localObject2).field_userName))
      {
        ((n)localObject2).csh();
        com.tencent.mm.plugin.sns.lucky.a.m.m((n)localObject2);
        com.tencent.mm.plugin.sns.lucky.a.m.l((n)localObject2);
        System.currentTimeMillis();
        com.tencent.mm.plugin.sns.lucky.a.b.kS(25);
      }
      if (!r.Zn().equals(((n)localObject2).field_userName))
      {
        com.tencent.mm.plugin.sns.lucky.b.a.a(2, (n)localObject2);
        com.tencent.mm.plugin.sns.lucky.a.b.kS(30);
      }
    }
    int i;
    long l;
    if (((n)localObject2).Ex(32))
    {
      b.a(this.skd, (n)localObject2);
      if ((((n)localObject2).csb().cqk()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.abq(((n)localObject2).csQ().field_adxml)))
      {
        localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y((n)localObject2);
        if (!bo.isNullOrNil((String)localObject1)) {
          ((n)localObject2).csQ().field_adxml = ((String)localObject1);
        }
        int j = this.skd.cpt;
        if (this.skd.cpt == 0)
        {
          i = 1;
          localObject1 = new SnsAdClick(j, i, ((n)localObject2).field_snsId, 21, 21);
          if (this.skd.rOU != null) {
            break label889;
          }
          l = 0L;
          label380:
          ((SnsAdClick)localObject1).fQA = l;
          com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject1);
          Object localObject3 = new int[2];
          if (paramView != null) {
            paramView.getLocationInWindow((int[])localObject3);
          }
          i = paramView.getWidth();
          j = paramView.getHeight();
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("img_gallery_left", localObject3[0]);
          ((Intent)localObject1).putExtra("img_gallery_top", localObject3[1]);
          ((Intent)localObject1).putExtra("img_gallery_width", i);
          ((Intent)localObject1).putExtra("img_gallery_height", j);
          ((Intent)localObject1).putExtra("sns_landing_pages_share_sns_id", ((n)localObject2).getSnsId());
          ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((n)localObject2).csh().Id);
          ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((n)localObject2).csP());
          ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((n)localObject2).csM());
          ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((n)localObject2).csN());
          localObject3 = ((n)localObject2).csh();
          if (localObject3 != null)
          {
            localObject3 = ((TimeLineObject)localObject3).xTS.wOa;
            if (((List)localObject3).size() > 0)
            {
              ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((bcs)((List)localObject3).get(0)).xrS);
              ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((ao)paramView.getTag()).index);
            }
          }
          ((Intent)localObject1).setClass(this.skd.activity, SnsAdNativeLandingPagesUI.class);
          if (this.skd.cpt != 2) {
            break label911;
          }
          i = 16;
        }
      }
    }
    for (;;)
    {
      label643:
      ((Intent)localObject1).putExtra("sns_landig_pages_from_source", i);
      ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((n)localObject2).csQ().field_adxml);
      ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((n)localObject2).csR());
      ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
      ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      this.skd.activity.startActivity((Intent)localObject1);
      this.skd.activity.overridePendingTransition(0, 0);
      if (this.skd.rFN != null) {
        this.skd.rFN.coJ().x((n)localObject2);
      }
      label757:
      paramView = (ao)paramView.getTag();
      if ((paramView.rNW) && (localObject2 != null))
      {
        c.b((n)localObject2, paramView.index);
        c.c((n)localObject2, paramView.index);
        aw.aaJ(((n)localObject2).csH());
      }
      if (localObject2 != null)
      {
        localObject1 = ((n)localObject2).csh();
        if (localObject1 != null) {
          if (((TimeLineObject)localObject1).xTR != null) {
            break label949;
          }
        }
      }
      label911:
      label949:
      for (paramView = null;; paramView = ((TimeLineObject)localObject1).xTR.Id)
      {
        if (!bo.isNullOrNil(paramView))
        {
          localObject2 = com.tencent.mm.plugin.sns.c.a.gmP.dE(paramView);
          com.tencent.mm.plugin.sns.c.a.gmP.a(null, paramView, (String)localObject2, ((TimeLineObject)localObject1).jJA, 2, 4, 4, ((TimeLineObject)localObject1).xTW, ((TimeLineObject)localObject1).Id);
        }
        AppMethodBeat.o(40255);
        return;
        i = 2;
        break;
        label889:
        l = this.skd.rOU.di(((n)localObject2).csH(), 21);
        break label380;
        if (this.skd.cpt != 1) {
          break label961;
        }
        i = 2;
        break label643;
        this.skd.ci(paramView);
        break label757;
        this.skd.ci(paramView);
        break label757;
      }
      label961:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.9
 * JD-Core Version:    0.7.0.1
 */