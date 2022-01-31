package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.j.a;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.LinkedList;
import java.util.List;

final class b$29
  implements View.OnClickListener
{
  b$29(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40285);
    if ((paramView.getTag() == null) || ((!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramView.getTag() instanceof ao)) && (!(paramView.getTag() instanceof aj)) && (!(paramView.getTag() instanceof MaskImageView)) && (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))))
    {
      AppMethodBeat.o(40285);
      return;
    }
    Object localObject1 = null;
    int m = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    int i = 0;
    Object localObject3;
    if ((paramView.getTag() instanceof ao))
    {
      localObject3 = com.tencent.mm.plugin.sns.storage.h.abv(((ao)paramView.getTag()).ctV);
      if ((paramView instanceof LinearLayout))
      {
        i = 0;
        if (!((ao)paramView.getTag()).rLI) {
          break label4470;
        }
        k = ((ao)paramView.getTag()).index;
        if (k <= 0) {
          break label184;
        }
        j = 2;
      }
    }
    for (;;)
    {
      m = i;
      i = j;
      j = m;
      if ((localObject3 == null) || (!((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)))
      {
        AppMethodBeat.o(40285);
        return;
        i = 1;
        break;
        label184:
        j = 1;
        continue;
        if ((paramView.getTag() instanceof MaskImageView))
        {
          localObject3 = (MaskImageView)paramView.getTag();
          if (!(((MaskImageView)localObject3).getTag() instanceof ao)) {
            break label4465;
          }
          localObject3 = com.tencent.mm.plugin.sns.storage.h.abv(((ao)((MaskImageView)localObject3).getTag()).ctV);
          localObject1 = localObject3;
          j = n;
          if ((paramView instanceof LinearLayout)) {
            break label404;
          }
          i = 1;
          localObject1 = localObject3;
        }
      }
      for (;;)
      {
        m = 0;
        k = 0;
        localObject3 = localObject1;
        j = i;
        i = m;
        break;
        if ((paramView.getTag() instanceof aj))
        {
          localObject1 = (aj)paramView.getTag();
          localObject3 = ag.cpf().abv(((aj)localObject1).crk);
          if ((paramView instanceof LinearLayout))
          {
            j = 0;
            label314:
            if (!((aj)localObject1).rLI) {
              break label4456;
            }
            k = ((aj)localObject1).rLJ;
            if (k <= 0) {
              break label344;
            }
            i = 2;
          }
        }
        for (;;)
        {
          break;
          j = 1;
          break label314;
          label344:
          i = 1;
          continue;
          if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
          {
            localObject3 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
            localObject1 = com.tencent.mm.plugin.sns.storage.h.abu(((BaseTimeLineItem.BaseViewHolder)localObject3).czw);
            if (!(localObject3 instanceof j.b)) {
              break label4451;
            }
            j = ((j.b)localObject3).siO.index;
            if (j > 0) {
              i = 2;
            }
          }
          for (;;)
          {
            label404:
            k = j;
            j = 0;
            localObject3 = localObject1;
            break;
            i = 1;
            continue;
            if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))
            {
              localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag()).rMD;
              localObject1 = localObject3;
              j = n;
              if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
              {
                j = ((com.tencent.mm.plugin.sns.ui.c.a.e)paramView.getTag()).currentIndex;
                if (j > 0) {}
                for (i = 2;; i = 1)
                {
                  localObject1 = localObject3;
                  break;
                }
                for (;;)
                {
                  try
                  {
                    localObject1 = b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject3);
                    if (localObject1 != null) {
                      continue;
                    }
                    localObject1 = "";
                    localObject4 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().Id;
                    if (!((com.tencent.mm.plugin.sns.storage.n)localObject3).cqx())
                    {
                      localObject5 = com.tencent.mm.plugin.report.service.h.qsU;
                      if (this.skd.cpt != 0) {
                        continue;
                      }
                      m = 1;
                      if (j == 0) {
                        continue;
                      }
                      j = 1;
                      ((com.tencent.mm.plugin.report.service.h)localObject5).e(14066, new Object[] { Integer.valueOf(m), Integer.valueOf(j), localObject4, localObject1 });
                    }
                  }
                  catch (Exception localException)
                  {
                    ab.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                    continue;
                    localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).sfG;
                    continue;
                    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                      continue;
                    }
                    localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag()).sfG;
                    continue;
                    if (this.skd.rFN == null) {
                      continue;
                    }
                    this.skd.rFN.coJ().x((com.tencent.mm.plugin.sns.storage.n)localObject3);
                    boolean bool = ((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32);
                    if ((((TimeLineObject)localObject6).xTS.wOa != null) && (((TimeLineObject)localObject6).xTS.wOa.size() != 0)) {
                      continue;
                    }
                    ab.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                    AppMethodBeat.o(40285);
                    return;
                    bcs localbcs = (bcs)((TimeLineObject)localObject6).xTS.wOa.get(k);
                    if (!bool) {
                      continue;
                    }
                    ag.cpc();
                    if ((com.tencent.mm.plugin.sns.model.g.t(localbcs)) || (localObject2 == null)) {
                      continue;
                    }
                    ((aj)localObject2).rwJ.setVisibility(8);
                    ((aj)localObject2).rLF.setVisibility(0);
                    ((aj)localObject2).rLF.dOF();
                    ag.cpc().z(localbcs);
                    paramView = ag.cpa();
                    localObject2 = az.dxG();
                    ((az)localObject2).oLs = ((TimeLineObject)localObject6).CreateTime;
                    paramView.a(localbcs, 4, null, (az)localObject2);
                    if (!bool) {
                      continue;
                    }
                    k.a(k.b.ram, k.a.rad, (com.tencent.mm.plugin.sns.storage.n)localObject3, this.skd.cpt);
                    AppMethodBeat.o(40285);
                    return;
                    if ((!((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)) || (!((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().cqk())) {
                      continue;
                    }
                    String str = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csQ().field_adxml;
                    if (k <= 0) {
                      continue;
                    }
                    Object localObject5 = "adTurnCanvasInfo";
                    if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gD(str, (String)localObject5)) {
                      continue;
                    }
                    m = 1;
                    if ((m != 0) || (!bool) || (!ag.cpc().u(localbcs)) || (localObject2 == null)) {
                      continue;
                    }
                    ag.cpc().z(localbcs);
                    ((aj)localObject2).rwJ.setVisibility(8);
                    ((aj)localObject2).rLF.setVisibility(8);
                    paramView = ag.cpc();
                    Object localObject4 = ((aj)localObject2).qVe;
                    i = this.skd.activity.hashCode();
                    j = ((aj)localObject2).position;
                    localObject2 = az.dxG();
                    ((az)localObject2).oLs = ((TimeLineObject)localObject6).CreateTime;
                    paramView.a((com.tencent.mm.plugin.sns.storage.n)localObject3, localbcs, (com.tencent.mm.plugin.sight.decode.a.a)localObject4, i, j, (az)localObject2, bool);
                    if (!bool) {
                      continue;
                    }
                    k.a(k.b.ram, k.a.rad, (com.tencent.mm.plugin.sns.storage.n)localObject3, this.skd.cpt);
                    AppMethodBeat.o(40285);
                    return;
                    localObject5 = "adCanvasInfo";
                    continue;
                    m = 0;
                    continue;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    localObject2 = com.tencent.mm.modelsns.b.lV(717);
                    ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject3)).lY(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_type).de(((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)).uv(((com.tencent.mm.plugin.sns.storage.n)localObject3).csP()).uv(localbcs.Id);
                    ((com.tencent.mm.modelsns.b)localObject2).ake();
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    localObject2 = com.tencent.mm.modelsns.b.lV(745);
                    ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject3)).lY(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_type).de(((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32));
                    localObject2 = new int[2];
                    if (localObject4 == null) {
                      continue;
                    }
                    if (((BaseTimeLineItem.BaseViewHolder)localObject4).sfG.rLE == null) {
                      continue;
                    }
                    ((BaseTimeLineItem.BaseViewHolder)localObject4).sfG.rLE.getLocationInWindow((int[])localObject2);
                    j = ((BaseTimeLineItem.BaseViewHolder)localObject4).sfG.rLE.getWidth();
                    i = ((BaseTimeLineItem.BaseViewHolder)localObject4).sfG.rLE.getHeight();
                    com.tencent.mm.plugin.report.service.h.qsU.e(11444, new Object[] { Integer.valueOf(3) });
                    if (m == 0) {
                      continue;
                    }
                    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                      continue;
                    }
                    this.skd.i((BaseTimeLineItem.BaseViewHolder)paramView.getTag());
                    n = this.skd.cpt;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    m = 1;
                    paramView = new SnsAdClick(n, m, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 22, 21);
                    if (this.skd.rOU != null) {
                      continue;
                    }
                    long l = 0L;
                    paramView.fQA = l;
                    com.tencent.mm.plugin.sns.data.i.a(paramView);
                    localObject4 = new Intent();
                    ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                    ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                    ((Intent)localObject4).putExtra("img_gallery_width", j);
                    ((Intent)localObject4).putExtra("img_gallery_height", i);
                    ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.n)localObject3).getSnsId());
                    ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().Id);
                    ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csP());
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh();
                    if (paramView == null) {
                      continue;
                    }
                    paramView = paramView.xTS.wOa;
                    if (paramView.size() <= k) {
                      continue;
                    }
                    ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((bcs)paramView.get(k)).xrS);
                    ((Intent)localObject4).setClass(this.skd.activity, SnsAdNativeLandingPagesUI.class);
                    i = 1;
                    if (this.skd.cpt != 2) {
                      continue;
                    }
                    i = 16;
                    ((Intent)localObject4).putExtra("sns_landig_pages_from_source", i);
                    if (k <= 0) {
                      continue;
                    }
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().cqv();
                    ((Intent)localObject4).putExtra("sns_landing_pages_xml", paramView);
                    ((Intent)localObject4).putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csR());
                    ((Intent)localObject4).putExtra("sns_landing_pages_xml_prefix", "adxml");
                    ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                    this.skd.activity.startActivity((Intent)localObject4);
                    this.skd.activity.overridePendingTransition(0, 0);
                    AppMethodBeat.o(40285);
                    return;
                    localObject2 = com.tencent.mm.modelsns.b.lW(717);
                    continue;
                    localObject2 = com.tencent.mm.modelsns.b.lW(745);
                    continue;
                    if (((TimeLineObject)localObject6).xTS.wNZ != 27) {
                      continue;
                    }
                    ((j.b)localObject4).siM.getLocationInWindow((int[])localObject2);
                    j = ((j.b)localObject4).siM.getWidth();
                    i = ((j.b)localObject4).siM.getHeight();
                    continue;
                    if (!(paramView.getTag() instanceof aj)) {
                      continue;
                    }
                    localObject4 = (aj)paramView.getTag();
                    if (localObject4 == null) {
                      continue;
                    }
                    ((aj)localObject4).rLE.getLocationInWindow((int[])localObject2);
                    j = ((aj)localObject4).rLE.getWidth();
                    i = ((aj)localObject4).rLE.getHeight();
                    continue;
                    if (paramView == null) {
                      continue;
                    }
                    paramView.getLocationInWindow((int[])localObject2);
                    j = paramView.getWidth();
                    i = paramView.getHeight();
                    continue;
                    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                      continue;
                    }
                    this.skd.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag());
                    continue;
                    m = 2;
                    continue;
                    l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 22);
                    continue;
                    if (this.skd.cpt != 1) {
                      continue;
                    }
                    i = 2;
                    continue;
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csQ().field_adxml;
                    continue;
                    paramView = this.skd;
                    localObject2 = b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject3);
                    if (k <= 0) {
                      continue;
                    }
                    bool = true;
                    if (!b.a(paramView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (com.tencent.mm.plugin.sns.storage.n)localObject3, bool)) {
                      continue;
                    }
                    j = this.skd.cpt;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    i = 1;
                    paramView = new SnsAdClick(j, i, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 22, 31);
                    if (this.skd.rOU != null) {
                      continue;
                    }
                    l = 0L;
                    paramView.fQA = l;
                    com.tencent.mm.plugin.sns.data.i.a(paramView);
                    AppMethodBeat.o(40285);
                    return;
                    bool = false;
                    continue;
                    i = 2;
                    continue;
                    l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 22);
                    continue;
                    j = this.skd.cpt;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    i = 1;
                    localObject4 = new SnsAdClick(j, i, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 22, 0);
                    if (this.skd.rOU != null) {
                      continue;
                    }
                    l = 0L;
                    ((SnsAdClick)localObject4).fQA = l;
                    com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject4);
                    if (k <= 0) {
                      continue;
                    }
                    localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().rqH.rpk;
                    paramView = (View)localObject2;
                    if (!bo.isNullOrNil((String)localObject2)) {
                      continue;
                    }
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).getAdLink();
                    if (!bo.isNullOrNil(paramView)) {
                      continue;
                    }
                    AppMethodBeat.o(40285);
                    return;
                    i = 2;
                    continue;
                    l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 22);
                    continue;
                    localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csO();
                    continue;
                    ab.i("MicroMsg.TimelineClickListener", "adlink url " + paramView + " " + ((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().rpQ);
                    localObject5 = new Intent();
                    if (((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().rpQ != 0) {
                      continue;
                    }
                    bool = true;
                    if (!ae.gkT) {
                      continue;
                    }
                    bool = false;
                    localObject2 = paramView;
                    if (localObject3 == null) {
                      continue;
                    }
                    localObject2 = paramView;
                    if (!((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)) {
                      continue;
                    }
                    Object localObject6 = b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject3);
                    localObject2 = paramView;
                    if (localObject6 == null) {
                      continue;
                    }
                    ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).hpq);
                    localObject2 = com.tencent.mm.plugin.sns.data.i.gg(paramView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).cFe);
                    ((Intent)localObject5).putExtra("KRightBtn", bool);
                    paramView = new Bundle();
                    paramView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                    paramView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().rHA);
                    ((Intent)localObject5).putExtra("jsapiargs", paramView);
                    ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                    ((Intent)localObject5).putExtra("useJs", true);
                    ((Intent)localObject5).putExtra("srcUsername", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                    ((Intent)localObject5).putExtra("stastic_scene", 15);
                    ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId));
                    ((Intent)localObject5).putExtra("pre_username", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                    ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId));
                    ((Intent)localObject5).putExtra("preUsername", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                    com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject5, this.skd.activity);
                    AppMethodBeat.o(40285);
                    return;
                    bool = false;
                    continue;
                    if (((((TimeLineObject)localObject6).xTS.wNZ != 1) || (((TimeLineObject)localObject6).xTS.wOa.size() != 1)) && (((TimeLineObject)localObject6).xTS.wNZ != 7) && ((((TimeLineObject)localObject6).xTS.wNZ != 27) || (((TimeLineObject)localObject6).xTS.wOa.size() <= k) || (((bcs)((TimeLineObject)localObject6).xTS.wOa.get(k)).jKs != 2))) {
                      continue;
                    }
                    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                      continue;
                    }
                    localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
                    if (!(paramView.getTag() instanceof a.a)) {
                      continue;
                    }
                    localObject2 = ((a.a)paramView.getTag()).sga;
                    if (!((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().cqk()) {
                      continue;
                    }
                    localObject5 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csQ().field_adxml;
                    if (k <= 0) {
                      continue;
                    }
                    localObject4 = "adTurnCanvasInfo";
                    if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gD((String)localObject5, (String)localObject4)) {
                      continue;
                    }
                    m = this.skd.cpt;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    j = 1;
                    localObject4 = new SnsAdClick(m, j, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 21, i, (byte)0);
                    if (this.skd.rOU != null) {
                      continue;
                    }
                    l = 0L;
                    ((SnsAdClick)localObject4).fQA = l;
                    com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject4);
                    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                      continue;
                    }
                    this.skd.i((BaseTimeLineItem.BaseViewHolder)paramView.getTag());
                    paramView = new int[2];
                    ((View)localObject2).getLocationInWindow(paramView);
                    i = ((View)localObject2).getWidth();
                    j = ((View)localObject2).getHeight();
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("img_gallery_left", paramView[0]);
                    ((Intent)localObject2).putExtra("img_gallery_top", paramView[1]);
                    ((Intent)localObject2).putExtra("img_gallery_width", i);
                    ((Intent)localObject2).putExtra("img_gallery_height", j);
                    ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.n)localObject3).getSnsId());
                    ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().Id);
                    ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csP());
                    ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csM());
                    ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csN());
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh();
                    if (paramView == null) {
                      continue;
                    }
                    paramView = paramView.xTS.wOa;
                    if (paramView.size() <= k) {
                      continue;
                    }
                    ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((bcs)paramView.get(k)).xrS);
                    ((Intent)localObject2).setClass(this.skd.activity, SnsAdNativeLandingPagesUI.class);
                    i = 1;
                    if (this.skd.cpt != 2) {
                      continue;
                    }
                    i = 16;
                    ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                    if (k <= 0) {
                      continue;
                    }
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().cqv();
                    ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramView);
                    ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csR());
                    ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                    ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    this.skd.activity.startActivity((Intent)localObject2);
                    this.skd.activity.overridePendingTransition(0, 0);
                    if (this.skd.rFN == null) {
                      continue;
                    }
                    this.skd.rFN.coJ().x((com.tencent.mm.plugin.sns.storage.n)localObject3);
                    AppMethodBeat.o(40285);
                    return;
                    if (!(paramView.getTag() instanceof c.a)) {
                      continue;
                    }
                    localObject2 = ((c.a)paramView.getTag()).sga;
                    continue;
                    if (!(localObject2 instanceof j.b)) {
                      continue;
                    }
                    localObject2 = (TagImageView)((j.b)localObject2).siO.view;
                    continue;
                    if (!(paramView.getTag() instanceof h.a)) {
                      continue;
                    }
                    localObject2 = ((h.a)paramView.getTag()).siz;
                    continue;
                    localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).shk.EJ(0);
                    continue;
                    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                      continue;
                    }
                    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                      continue;
                    }
                    localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramView.getTag()).sfN;
                    continue;
                    if (!(paramView.getTag() instanceof c)) {
                      continue;
                    }
                    localObject2 = ((c)paramView.getTag()).sga;
                    continue;
                    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.e)) {
                      continue;
                    }
                    localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.e)paramView.getTag()).contentView;
                    continue;
                    if (!(paramView.getTag() instanceof d)) {
                      continue;
                    }
                    localObject2 = ((d)paramView.getTag()).contentView;
                    continue;
                    if (!(paramView.getTag() instanceof MaskImageView)) {
                      continue;
                    }
                    localObject2 = (MaskImageView)paramView.getTag();
                    continue;
                    if (!(paramView.getTag() instanceof TagImageView)) {
                      continue;
                    }
                    localObject2 = (TagImageView)paramView;
                    continue;
                    localObject4 = "adCanvasInfo";
                    continue;
                    j = 2;
                    continue;
                    l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 22);
                    continue;
                    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                      continue;
                    }
                    this.skd.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag());
                    continue;
                    if (paramView.size() <= 0) {
                      continue;
                    }
                    ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((bcs)paramView.get(0)).xrS);
                    continue;
                    if (this.skd.cpt != 1) {
                      continue;
                    }
                    i = 2;
                    continue;
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csQ().field_adxml;
                    continue;
                    paramView = this.skd;
                    localObject2 = b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject3);
                    if (k <= 0) {
                      continue;
                    }
                    bool = true;
                    if (!b.a(paramView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (com.tencent.mm.plugin.sns.storage.n)localObject3, bool)) {
                      continue;
                    }
                    k = this.skd.cpt;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    j = 1;
                    paramView = new SnsAdClick(k, j, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 31, i, (byte)0);
                    if (this.skd.rOU != null) {
                      continue;
                    }
                    l = 0L;
                    paramView.fQA = l;
                    com.tencent.mm.plugin.sns.data.i.a(paramView);
                    AppMethodBeat.o(40285);
                    return;
                    bool = false;
                    continue;
                    j = 2;
                    continue;
                    l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 22);
                    continue;
                    if (k <= 0) {
                      continue;
                    }
                    localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().rqH.rpk;
                    paramView = (View)localObject2;
                    if (!bo.isNullOrNil((String)localObject2)) {
                      continue;
                    }
                    paramView = ((com.tencent.mm.plugin.sns.storage.n)localObject3).getAdLink();
                    if (!bo.isNullOrNil(paramView)) {
                      continue;
                    }
                    AppMethodBeat.o(40285);
                    return;
                    localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csO();
                    continue;
                    k = this.skd.cpt;
                    if (this.skd.cpt != 0) {
                      continue;
                    }
                    j = 1;
                    localObject4 = new SnsAdClick(k, j, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 0, i, (byte)0);
                    if (this.skd.rOU != null) {
                      continue;
                    }
                    l = 0L;
                    ((SnsAdClick)localObject4).fQA = l;
                    com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject4);
                    ab.i("MicroMsg.TimelineClickListener", "adlink url " + paramView + " " + ((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().rpQ);
                    localObject5 = new Intent();
                    if (((com.tencent.mm.plugin.sns.storage.n)localObject3).csb().rpQ != 0) {
                      continue;
                    }
                    bool = true;
                    if (!ae.gkT) {
                      continue;
                    }
                    bool = false;
                    localObject2 = paramView;
                    if (localObject3 == null) {
                      continue;
                    }
                    localObject2 = paramView;
                    if (!((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)) {
                      continue;
                    }
                    localObject6 = b.a(this.skd, (com.tencent.mm.plugin.sns.storage.n)localObject3);
                    localObject2 = paramView;
                    if (localObject6 == null) {
                      continue;
                    }
                    ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).hpq);
                    localObject2 = com.tencent.mm.plugin.sns.data.i.gg(paramView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).cFe);
                    ((Intent)localObject5).putExtra("KRightBtn", bool);
                    paramView = new Bundle();
                    paramView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                    paramView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().rHA);
                    ((Intent)localObject5).putExtra("jsapiargs", paramView);
                    ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                    ((Intent)localObject5).putExtra("useJs", true);
                    ((Intent)localObject5).putExtra("srcUsername", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                    ((Intent)localObject5).putExtra("stastic_scene", 15);
                    ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId));
                    ((Intent)localObject5).putExtra("pre_username", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                    ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId));
                    ((Intent)localObject5).putExtra("preUsername", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                    com.tencent.mm.plugin.sns.c.a.gmO.i((Intent)localObject5, this.skd.activity);
                    AppMethodBeat.o(40285);
                    return;
                    j = 2;
                    continue;
                    l = this.skd.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 22);
                    continue;
                    bool = false;
                    continue;
                    localObject2 = null;
                    continue;
                    i = 0;
                    j = 0;
                    continue;
                    continue;
                  }
                  if (((com.tencent.mm.plugin.sns.storage.n)localObject3).csQ().csb().cqs())
                  {
                    localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csQ().csb().cqn();
                    localObject4 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csP();
                    com.tencent.mm.kernel.g.RJ();
                    localObject5 = com.tencent.mm.kernel.a.QC();
                    v.h((String)localObject1, (String)localObject4, (String)localObject5, v.ao((String)localObject1, (String)localObject4, (String)localObject5), 0);
                  }
                  localObject6 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh();
                  if (((((TimeLineObject)localObject6).xTS.wNZ != 15) || (((TimeLineObject)localObject6).xTZ == 1)) && ((((TimeLineObject)localObject6).xTS.wNZ != 27) || (((TimeLineObject)localObject6).xTS.wOa.size() <= k) || (((bcs)((TimeLineObject)localObject6).xTS.wOa.get(k)).jKs != 6))) {
                    continue;
                  }
                  ab.i("MicroMsg.TimelineClickListener", "onsight click");
                  localObject1 = null;
                  localObject4 = null;
                  if ((paramView.getTag() instanceof aj)) {
                    localObject1 = (aj)paramView.getTag();
                  }
                  if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                    continue;
                  }
                  localObject4 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
                  if (((TimeLineObject)localObject6).xTS.wNZ != 27) {
                    continue;
                  }
                  localObject1 = ((j.b)localObject4).siP;
                  if (localObject3 != null) {
                    continue;
                  }
                  AppMethodBeat.o(40285);
                  return;
                  localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).hpq;
                  continue;
                  m = 2;
                  continue;
                  j = 2;
                }
              }
            }
            else
            {
              Object localObject2 = null;
              j = n;
              continue;
              label4451:
              i = 0;
            }
          }
          label4456:
          i = 0;
          k = m;
        }
        label4465:
        i = 0;
      }
      label4470:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.29
 * JD-Core Version:    0.7.0.1
 */