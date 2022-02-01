package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class n
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(226041);
    if ((paramBaseViewHolder.LkR != null) && (paramBaseViewHolder.LkR.getParent() != null))
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_media_sub_item2);
      if (!paramBaseViewHolder.LlE) {
        paramBaseViewHolder.LlF = paramBaseViewHolder.LkR.inflate();
      }
    }
    for (paramBaseViewHolder.LlE = true;; paramBaseViewHolder.LlE = true)
    {
      paramBaseViewHolder.KWu = paramBaseViewHolder.LlF;
      paramBaseViewHolder.LkU = ((TagImageView)paramBaseViewHolder.KWu.findViewById(i.f.image_left));
      paramBaseViewHolder.yVe = ((ImageView)paramBaseViewHolder.KWu.findViewById(i.f.state));
      paramBaseViewHolder.LkV = ((TextView)paramBaseViewHolder.KWu.findViewById(i.f.righttext));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.KWu.findViewById(i.f.titletext));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(i.c.normal_text_color));
      t.b(paramBaseViewHolder.LkU, this.mActivity);
      AppMethodBeat.o(226041);
      return;
      paramBaseViewHolder.LlF = paramBaseViewHolder.convertView.findViewById(i.f.media_content_rl);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.LkU.setPosition(paramInt1);
    Object localObject1 = parambn.KDB;
    Object localObject3 = parambn.Jws;
    paramInt1 = 0;
    int i;
    if (parambn.KBz)
    {
      if (((SnsInfo)localObject3).getAdXml().adContentStyle == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.KWu.setTag(paramBaseViewHolder);
        paramBaseViewHolder.KWu.setOnClickListener(parambm.Kdz.LpG);
      }
      i = 0;
    }
    label139:
    label2585:
    label5031:
    for (;;)
    {
      label106:
      int j;
      if (paramInt1 != 0)
      {
        parambm.fXi().c(paramBaseViewHolder.KWu, parambm.Kdz.Lpi, parambm.Kdz.LoP);
        if (paramTimeLineObject.ContentObj.Sqq != 9) {
          break label1582;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1602;
        }
        parambn = bm.bcg(paramTimeLineObject.ContentObj.Url);
        if ((paramTimeLineObject.ContentObj.Sqq == 9) || (paramTimeLineObject.ContentObj.Sqq == 14) || (paramTimeLineObject.ContentObj.Sqq == 12) || (paramTimeLineObject.ContentObj.Sqq == 13) || (paramInt1 != 0)) {
          parambn = paramTimeLineObject.ContentObj.CMB;
        }
        if ((paramTimeLineObject.ContentObj.Squ == null) || (paramTimeLineObject.ContentObj.Squ.lls != 1)) {
          break label5090;
        }
      }
      label461:
      label4571:
      label5084:
      label5090:
      for (Object localObject2 = MMApplicationContext.getContext().getString(i.j.mp_pay_content);; localObject2 = parambn)
      {
        parambm = paramTimeLineObject.ContentObj.fwr;
        if ((parambm != null) && (parambm.length() > 40)) {
          parambm = parambm.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.yVe.setVisibility(8);
          Object localObject4;
          if (!paramTimeLineObject.ContentObj.Sqr.isEmpty())
          {
            paramBaseViewHolder.LkU.setVisibility(0);
            localObject1 = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
            if (paramTimeLineObject.ContentObj.Sqq == 5)
            {
              parambn = ((cvt)localObject1).fwr;
              paramBaseViewHolder.yVe.setImageResource(i.i.shortvideo_play_btn);
              paramBaseViewHolder.yVe.setVisibility(0);
              parambm = aj.fOF();
              localObject3 = paramBaseViewHolder.LkU;
              paramInt1 = i.i.app_attach_file_icon_video;
              j = this.mActivity.hashCode();
              localObject4 = bp.hzh();
              ((bp)localObject4).time = paramTimeLineObject.CreateTime;
              parambm.a((cvt)localObject1, (View)localObject3, paramInt1, j, (bp)localObject4);
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            if (!Util.isNullOrNil((String)localObject1))
            {
              paramBaseViewHolder.LkV.setVisibility(0);
              paramBaseViewHolder.LkV.setText((CharSequence)localObject1);
              if (Util.isNullOrNil(parambn)) {
                break label5031;
              }
              if (paramBaseViewHolder.LkV.getVisibility() != 8) {
                break label4986;
              }
              if (paramBaseViewHolder.LkW != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
              paramBaseViewHolder.LkW = 2;
              label501:
              paramBaseViewHolder.titleTv.setVisibility(0);
              if (i == 0) {
                break label5010;
              }
              paramBaseViewHolder.titleTv.setText(t.a(parambn, this.mActivity, paramBaseViewHolder.titleTv));
              AppMethodBeat.o(100090);
              return;
              if (paramTimeLineObject.ContentObj.Sqq == 9)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfm);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 10)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfo);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 17)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfp);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 22)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfq);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 23)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfr);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 14)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfn);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 12)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
                  break label5096;
                }
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfx);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 13)
              {
                if (paramTimeLineObject.ContentObj.Sqr.size() > 0)
                {
                  paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfy);
                  paramInt1 = 0;
                  i = 0;
                  break;
                }
                paramBaseViewHolder.KWu.setOnClickListener(null);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 30)
              {
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfv);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 26)
              {
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.Lfz);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if ((paramTimeLineObject.ContentObj.Sqq == 28) || (paramTimeLineObject.ContentObj.Sqq == 29) || (paramTimeLineObject.ContentObj.Sqq == 38) || (paramTimeLineObject.ContentObj.Sqq == 34) || (paramTimeLineObject.ContentObj.Sqq == 37) || (paramTimeLineObject.ContentObj.Sqq == 36) || (paramTimeLineObject.ContentObj.Sqq == 44))
              {
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.KWe);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 41)
              {
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.LfA);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 39)
              {
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.KWe);
                paramInt1 = 0;
                i = 0;
                break;
              }
              if (paramTimeLineObject.ContentObj.Sqq == 4)
              {
                paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.KWe);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.KWu.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.KWu.setOnClickListener(parambm.KPg.KWe);
              if ((paramTimeLineObject.contentattr & 0x1) <= 0) {
                break label5096;
              }
              paramInt1 = 0;
              i = 1;
              break;
              parambm.fXi().c(paramBaseViewHolder.KWu, parambm.Kdz.Lpe, parambm.Kdz.LoP);
              break label106;
              if ((ap.a.fPq() & 0x1) <= 0)
              {
                j = 1;
                break label122;
              }
              j = 0;
              break label122;
              parambn = "";
              break label139;
              if (paramTimeLineObject.ContentObj.Sqq == 18)
              {
                paramBaseViewHolder.yVe.setVisibility(0);
                paramBaseViewHolder.yVe.setImageResource(i.i.shortvideo_play_btn);
                paramBaseViewHolder.LkU.setVisibility(0);
                parambn = aj.fOF();
                localObject3 = paramBaseViewHolder.LkU;
                paramInt1 = i.i.app_attach_file_icon_video;
                j = this.mActivity.hashCode();
                localObject4 = bp.hzh();
                ((bp)localObject4).time = paramTimeLineObject.CreateTime;
                parambn.a((cvt)localObject1, (View)localObject3, paramInt1, j, (bp)localObject4);
                localObject1 = localObject2;
                parambn = parambm;
              }
              else
              {
                if ((paramTimeLineObject.weappInfo != null) && (paramTimeLineObject.weappInfo.path != null) && (paramTimeLineObject.weappInfo.subType == 1))
                {
                  paramBaseViewHolder.yVe.setImageResource(i.i.shortvideo_play_btn);
                  paramBaseViewHolder.yVe.setVisibility(0);
                }
                if ((paramTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.webSearchInfo.PyQ)))
                {
                  paramBaseViewHolder.yVe.setImageResource(i.i.shortvideo_play_btn);
                  paramBaseViewHolder.yVe.setVisibility(0);
                }
                if ((paramTimeLineObject.ContentObj.Squ != null) && (paramTimeLineObject.ContentObj.Squ.lpx == 5))
                {
                  paramBaseViewHolder.yVe.setImageResource(i.i.shortvideo_play_btn);
                  paramBaseViewHolder.yVe.setVisibility(0);
                }
                parambn = aj.fOF();
                localObject3 = paramBaseViewHolder.LkU;
                paramInt1 = this.mActivity.hashCode();
                localObject4 = bp.hzh();
                ((bp)localObject4).time = paramTimeLineObject.CreateTime;
                parambn.b((cvt)localObject1, (View)localObject3, paramInt1, (bp)localObject4);
                localObject1 = localObject2;
                parambn = parambm;
                continue;
                if (paramTimeLineObject.ContentObj.Sqq == 18)
                {
                  paramBaseViewHolder.yVe.setVisibility(0);
                  paramBaseViewHolder.yVe.setImageResource(i.i.shortvideo_play_btn);
                  paramBaseViewHolder.LkU.setVisibility(0);
                  aj.fOF().d(paramBaseViewHolder.LkU, -1, i.i.app_attach_file_icon_video, this.mActivity.hashCode());
                  localObject1 = localObject2;
                  parambn = parambm;
                }
                else if (paramTimeLineObject.ContentObj.Sqq == 26)
                {
                  paramBaseViewHolder.LkU.setVisibility(0);
                  aj.fOF().d(paramBaseViewHolder.LkU, -1, i.i.note_sns_link_default, this.mActivity.hashCode());
                  localObject1 = localObject2;
                  parambn = parambm;
                }
                else if (paramTimeLineObject.ContentObj.Sqq == 28)
                {
                  localObject1 = localObject2;
                  parambn = parambm;
                  if (paramTimeLineObject.ContentObj.fFJ != null)
                  {
                    if ((((ak)h.ag(ak.class)).showFinderEntry()) || (((b)h.ae(b.class)).a(b.a.vJz, 0) == 0))
                    {
                      if ((!Util.isNullOrNil(paramTimeLineObject.ContentObj.fFJ.nickname)) || (Util.isNullOrNil(paramTimeLineObject.ContentObj.fFJ.desc))) {
                        break label2370;
                      }
                      parambm = paramTimeLineObject.ContentObj.fFJ.desc;
                    }
                    for (;;)
                    {
                      paramBaseViewHolder.LkU.setVisibility(0);
                      localObject1 = localObject2;
                      parambn = parambm;
                      if (paramTimeLineObject.ContentObj.fFJ.mediaList.isEmpty()) {
                        break;
                      }
                      parambn = new cvt();
                      parambn.Url = ((bjc)paramTimeLineObject.ContentObj.fFJ.mediaList.get(0)).thumbUrl;
                      parambn.TDF = ((bjc)paramTimeLineObject.ContentObj.fFJ.mediaList.get(0)).thumbUrl;
                      parambn.rWu = 2;
                      parambn.TDG = 1;
                      parambn.TDH = new cvv();
                      parambn.TlV = 1;
                      parambn.TDH.TEu = ((bjc)paramTimeLineObject.ContentObj.fFJ.mediaList.get(0)).width;
                      parambn.TDH.TEv = ((bjc)paramTimeLineObject.ContentObj.fFJ.mediaList.get(0)).height;
                      parambn.Id = ((SnsInfo)localObject3).getSnsId();
                      localObject1 = aj.fOF();
                      localObject3 = paramBaseViewHolder.LkU;
                      paramInt1 = this.mActivity.hashCode();
                      localObject4 = bp.hzh();
                      ((bp)localObject4).time = paramTimeLineObject.CreateTime;
                      ((g)localObject1).b(parambn, (View)localObject3, paramInt1, (bp)localObject4);
                      localObject1 = localObject2;
                      parambn = parambm;
                      break;
                      if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.fFJ.desc)) {
                        parambm = paramTimeLineObject.ContentObj.fFJ.nickname + ": " + paramTimeLineObject.ContentObj.fFJ.desc;
                      } else {
                        parambm = this.mActivity.getString(i.j.sns_share_finder_feed_title, new Object[] { paramTimeLineObject.ContentObj.fFJ.nickname });
                      }
                    }
                  }
                }
                else if (paramTimeLineObject.ContentObj.Sqq == 36)
                {
                  localObject1 = localObject2;
                  parambn = parambm;
                  if (paramTimeLineObject.ContentObj.Sqy != null)
                  {
                    if ((((ak)h.ag(ak.class)).showFinderEntry()) || (((b)h.ae(b.class)).a(b.a.vJz, 0) == 0))
                    {
                      if ((Util.isNullOrNil(paramTimeLineObject.ContentObj.Sqy.nickname)) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Sqy.desc))) {
                        parambm = paramTimeLineObject.ContentObj.Sqy.desc;
                      }
                    }
                    else
                    {
                      paramBaseViewHolder.LkU.setVisibility(0);
                      localObject1 = localObject2;
                      parambn = parambm;
                      if (paramTimeLineObject.ContentObj.Sqy.mediaList.isEmpty()) {
                        continue;
                      }
                      localObject1 = new cvt();
                      if (TextUtils.isEmpty(((cww)paramTimeLineObject.ContentObj.Sqy.mediaList.get(0)).coverUrl)) {
                        break label2938;
                      }
                    }
                    label2938:
                    for (parambn = ((cww)paramTimeLineObject.ContentObj.Sqy.mediaList.get(0)).coverUrl;; parambn = ((cww)paramTimeLineObject.ContentObj.Sqy.mediaList.get(0)).thumbUrl)
                    {
                      ((cvt)localObject1).Url = parambn;
                      ((cvt)localObject1).TDF = parambn;
                      ((cvt)localObject1).rWu = 2;
                      ((cvt)localObject1).TDG = 1;
                      ((cvt)localObject1).TDH = new cvv();
                      ((cvt)localObject1).TlV = 1;
                      ((cvt)localObject1).TDH.TEu = ((cww)paramTimeLineObject.ContentObj.Sqy.mediaList.get(0)).width;
                      ((cvt)localObject1).TDH.TEv = ((cww)paramTimeLineObject.ContentObj.Sqy.mediaList.get(0)).height;
                      ((cvt)localObject1).Id = ((SnsInfo)localObject3).getSnsId();
                      parambn = aj.fOF();
                      localObject3 = paramBaseViewHolder.LkU;
                      paramInt1 = this.mActivity.hashCode();
                      localObject4 = bp.hzh();
                      ((bp)localObject4).time = paramTimeLineObject.CreateTime;
                      parambn.b((cvt)localObject1, (View)localObject3, paramInt1, (bp)localObject4);
                      localObject1 = localObject2;
                      parambn = parambm;
                      break;
                      if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Sqy.desc))
                      {
                        parambm = paramTimeLineObject.ContentObj.Sqy.nickname + ": " + paramTimeLineObject.ContentObj.Sqy.desc;
                        break label2585;
                      }
                      parambm = this.mActivity.getString(i.j.sns_share_finder_feed_title, new Object[] { paramTimeLineObject.ContentObj.Sqy.nickname });
                      break label2585;
                    }
                  }
                }
                else if ((paramTimeLineObject.ContentObj.Sqq == 29) || (paramTimeLineObject.ContentObj.Sqq == 37))
                {
                  localObject1 = localObject2;
                  parambn = parambm;
                  if (paramTimeLineObject.ContentObj.Sqv != null)
                  {
                    parambn = this.mActivity.getString(i.j.app_finder_topic);
                    if (paramTimeLineObject.ContentObj.Sqv != null) {
                      if (paramTimeLineObject.ContentObj.Sqv.wXA != 1) {
                        break label3258;
                      }
                    }
                    for (parambn = MMApplicationContext.getContext().getString(i.j.sns_share_finder_topic_card_prefix, new Object[] { paramTimeLineObject.ContentObj.Sqv.topic });; parambn = paramTimeLineObject.ContentObj.Sqv.topic)
                    {
                      paramBaseViewHolder.LkU.setVisibility(0);
                      if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Sqv.iconUrl))
                      {
                        parambm = new cvt();
                        parambm.Url = paramTimeLineObject.ContentObj.Sqv.iconUrl;
                        parambm.TDF = paramTimeLineObject.ContentObj.Sqv.iconUrl;
                        parambm.rWu = 2;
                        parambm.TDG = 1;
                        parambm.TDH = new cvv();
                        parambm.TlV = 1;
                        parambm.TDH.TEu = 0.0F;
                        parambm.TDH.TEv = 0.0F;
                        parambm.Id = ((SnsInfo)localObject3).getSnsId();
                        localObject1 = aj.fOF();
                        localObject2 = paramBaseViewHolder.LkU;
                        paramInt1 = this.mActivity.hashCode();
                        localObject3 = bp.hzh();
                        ((bp)localObject3).time = paramTimeLineObject.CreateTime;
                        ((g)localObject1).b(parambm, (View)localObject2, paramInt1, (bp)localObject3);
                      }
                      localObject1 = paramTimeLineObject.ContentObj.Sqv.desc;
                      break;
                    }
                  }
                }
                else if (paramTimeLineObject.ContentObj.Sqq == 38)
                {
                  localObject1 = localObject2;
                  parambn = parambm;
                  if (paramTimeLineObject.ContentObj.Sqx != null)
                  {
                    parambm = paramTimeLineObject.ContentObj.Sqx.title;
                    paramBaseViewHolder.LkU.setVisibility(0);
                    localObject1 = localObject2;
                    parambn = parambm;
                    if (paramTimeLineObject.ContentObj.Sqx.STk.size() > 0)
                    {
                      parambn = new cvt();
                      localObject1 = (String)paramTimeLineObject.ContentObj.Sqx.STk.get(0);
                      localObject4 = (String)paramTimeLineObject.ContentObj.Sqx.STl.get(0);
                      parambn.Url = ((String)localObject1 + (String)localObject4);
                      parambn.TDF = parambn.Url;
                      parambn.rWu = 2;
                      parambn.TDG = 1;
                      parambn.TDH = new cvv();
                      parambn.TlV = 1;
                      parambn.TDH.TEu = 0.0F;
                      parambn.TDH.TEv = 0.0F;
                      parambn.Id = ((SnsInfo)localObject3).getSnsId();
                      localObject1 = aj.fOF();
                      localObject3 = paramBaseViewHolder.LkU;
                      paramInt1 = this.mActivity.hashCode();
                      localObject4 = bp.hzh();
                      ((bp)localObject4).time = paramTimeLineObject.CreateTime;
                      ((g)localObject1).b(parambn, (View)localObject3, paramInt1, (bp)localObject4);
                      localObject1 = localObject2;
                      parambn = parambm;
                    }
                  }
                }
                else if (paramTimeLineObject.ContentObj.Sqq == 34)
                {
                  localObject1 = localObject2;
                  parambn = parambm;
                  if (paramTimeLineObject.ContentObj.yNL != null)
                  {
                    if ((((ak)h.ag(ak.class)).showFinderEntry()) || (((b)h.ae(b.class)).a(b.a.vJz, 0) == 0))
                    {
                      if ((!Util.isNullOrNil(paramTimeLineObject.ContentObj.yNL.nickName)) || (Util.isNullOrNil(paramTimeLineObject.ContentObj.yNL.desc))) {
                        break label3847;
                      }
                      parambm = paramTimeLineObject.ContentObj.yNL.desc;
                    }
                    for (;;)
                    {
                      paramBaseViewHolder.LkU.setVisibility(0);
                      localObject1 = localObject2;
                      parambn = parambm;
                      if (paramTimeLineObject.ContentObj.yNL.coverUrl.isEmpty()) {
                        break;
                      }
                      parambn = new cvt();
                      parambn.Url = paramTimeLineObject.ContentObj.yNL.coverUrl;
                      parambn.TDF = paramTimeLineObject.ContentObj.yNL.coverUrl;
                      parambn.rWu = 2;
                      parambn.TDG = 1;
                      parambn.TDH = new cvv();
                      parambn.TlV = 1;
                      parambn.TDH.TEu = paramTimeLineObject.ContentObj.yNL.width;
                      parambn.TDH.TEv = paramTimeLineObject.ContentObj.yNL.height;
                      parambn.Id = ((SnsInfo)localObject3).getSnsId();
                      localObject1 = aj.fOF();
                      localObject3 = paramBaseViewHolder.LkU;
                      paramInt1 = this.mActivity.hashCode();
                      localObject4 = bp.hzh();
                      ((bp)localObject4).time = paramTimeLineObject.CreateTime;
                      ((g)localObject1).b(parambn, (View)localObject3, paramInt1, (bp)localObject4);
                      localObject1 = localObject2;
                      parambn = parambm;
                      break;
                      if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.yNL.desc)) {
                        parambm = paramTimeLineObject.ContentObj.yNL.nickName + ": " + paramTimeLineObject.ContentObj.yNL.desc;
                      } else {
                        parambm = this.mActivity.getString(i.j.sns_share_finder_live_title, new Object[] { paramTimeLineObject.ContentObj.yNL.nickName });
                      }
                    }
                  }
                }
                else if (paramTimeLineObject.ContentObj.Sqq == 39)
                {
                  if (paramTimeLineObject.ContentObj.loX == 3)
                  {
                    localObject1 = localObject2;
                    parambn = parambm;
                    if (paramTimeLineObject.ContentObj.Sqz == null) {
                      continue;
                    }
                    parambn = this.mActivity.getString(i.j.app_finder_topic);
                    if ((paramTimeLineObject.ContentObj.Sqz.wXA != 7) || (paramTimeLineObject.ContentObj.Sqz.STw == null)) {
                      break label5084;
                    }
                    parambn = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { paramTimeLineObject.ContentObj.Sqz.STw.SCS, paramTimeLineObject.ContentObj.Sqz.STw.SCR });
                  }
                }
              }
            }
          }
          for (;;)
          {
            paramBaseViewHolder.LkU.setVisibility(0);
            if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Sqz.iconUrl))
            {
              parambm = new cvt();
              parambm.Url = paramTimeLineObject.ContentObj.Sqz.iconUrl;
              parambm.TDF = paramTimeLineObject.ContentObj.Sqz.iconUrl;
              parambm.rWu = 2;
              parambm.TDG = 1;
              parambm.TDH = new cvv();
              parambm.TlV = 1;
              parambm.TDH.TEu = 0.0F;
              parambm.TDH.TEv = 0.0F;
              parambm.Id = ((SnsInfo)localObject3).getSnsId();
              paramBaseViewHolder.LkU.setScaleType(QImageView.a.Ydm);
              ((ak)h.ag(ak.class)).loadImageForSns(paramTimeLineObject.ContentObj.Sqz.iconUrl, paramBaseViewHolder.LkU);
            }
            for (;;)
            {
              localObject1 = paramTimeLineObject.ContentObj.Sqz.desc;
              break;
              aj.fOF().d(paramBaseViewHolder.LkU, -1, i.i.icon_filled_activity, this.mActivity.hashCode());
            }
            localObject1 = localObject2;
            parambn = parambm;
            if (paramTimeLineObject.ContentObj.loX != 100000000) {
              break;
            }
            localObject1 = localObject2;
            parambn = parambm;
            if (paramTimeLineObject.ContentObj.Sqv == null) {
              break;
            }
            parambn = this.mActivity.getString(i.j.app_finder_topic);
            if (paramTimeLineObject.ContentObj.Sqv != null)
            {
              if (paramTimeLineObject.ContentObj.Sqv.wXA != 1) {
                break label4571;
              }
              parambn = MMApplicationContext.getContext().getString(i.j.sns_share_finder_topic_card_prefix, new Object[] { paramTimeLineObject.ContentObj.Sqv.topic });
            }
            for (;;)
            {
              paramBaseViewHolder.LkU.setVisibility(0);
              if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Sqv.iconUrl))
              {
                parambm = new cvt();
                parambm.Url = paramTimeLineObject.ContentObj.Sqv.iconUrl;
                parambm.TDF = paramTimeLineObject.ContentObj.Sqv.iconUrl;
                parambm.rWu = 2;
                parambm.TDG = 1;
                parambm.TDH = new cvv();
                parambm.TlV = 1;
                parambm.TDH.TEu = 0.0F;
                parambm.TDH.TEv = 0.0F;
                parambm.Id = ((SnsInfo)localObject3).getSnsId();
                localObject1 = aj.fOF();
                localObject2 = paramBaseViewHolder.LkU;
                paramInt1 = this.mActivity.hashCode();
                localObject3 = bp.hzh();
                ((bp)localObject3).time = paramTimeLineObject.CreateTime;
                ((g)localObject1).b(parambm, (View)localObject2, paramInt1, (bp)localObject3);
              }
              localObject1 = paramTimeLineObject.ContentObj.Sqv.desc;
              break;
              if (paramTimeLineObject.ContentObj.Sqv.wXA == 7)
              {
                if (paramTimeLineObject.ContentObj.Sqv.STw != null) {
                  parambn = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { paramTimeLineObject.ContentObj.Sqv.STw.SCS, paramTimeLineObject.ContentObj.Sqv.STw.SCR });
                } else {
                  parambn = paramTimeLineObject.ContentObj.Sqv.topic;
                }
              }
              else {
                parambn = paramTimeLineObject.ContentObj.Sqv.topic;
              }
            }
            if (paramTimeLineObject.ContentObj.Sqq == 44)
            {
              localObject1 = localObject2;
              parambn = parambm;
              if (paramTimeLineObject.ContentObj.SqA == null) {
                break;
              }
              parambn = paramTimeLineObject.ContentObj.SqA.poiName;
              paramBaseViewHolder.LkU.setVisibility(0);
              if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.SqA.QSw))
              {
                parambm = new cvt();
                parambm.Url = paramTimeLineObject.ContentObj.SqA.QSw;
                parambm.TDF = paramTimeLineObject.ContentObj.SqA.QSw;
                parambm.rWu = 2;
                parambm.TDG = 1;
                parambm.TDH = new cvv();
                parambm.TlV = 1;
                parambm.TDH.TEu = 0.0F;
                parambm.TDH.TEv = 0.0F;
                parambm.Id = ((SnsInfo)localObject3).getSnsId();
                localObject1 = aj.fOF();
                localObject2 = paramBaseViewHolder.LkU;
                paramInt1 = this.mActivity.hashCode();
                localObject3 = bp.hzh();
                ((bp)localObject3).time = paramTimeLineObject.CreateTime;
                ((g)localObject1).b(parambm, (View)localObject2, paramInt1, (bp)localObject3);
              }
              for (;;)
              {
                localObject1 = paramTimeLineObject.ContentObj.SqA.xzN;
                break;
                aj.fOF().d(paramBaseViewHolder.LkU, -1, i.i.icons_outlined_location, this.mActivity.hashCode());
              }
            }
            paramBaseViewHolder.LkU.setVisibility(0);
            aj.fOF().d(paramBaseViewHolder.LkU, -1, i.i.app_attach_file_icon_webpage, this.mActivity.hashCode());
            localObject1 = localObject2;
            parambn = parambm;
            break;
            paramBaseViewHolder.LkV.setVisibility(8);
            break label461;
            label4986:
            if (paramBaseViewHolder.LkW != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
            paramBaseViewHolder.LkW = 1;
            break label501;
            paramBaseViewHolder.titleTv.setText(l.c(this.mActivity, parambn));
            AppMethodBeat.o(100090);
            return;
            if (paramInt2 == 1)
            {
              paramBaseViewHolder.titleTv.setText(bm.bcg(paramTimeLineObject.ContentObj.Url));
              paramBaseViewHolder.titleTv.setVisibility(0);
              AppMethodBeat.o(100090);
              return;
            }
            paramBaseViewHolder.titleTv.setVisibility(8);
            AppMethodBeat.o(100090);
            return;
          }
        }
      }
      label1582:
      label1602:
      label2370:
      label5096:
      paramInt1 = 0;
      label3258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.n
 * JD-Core Version:    0.7.0.1
 */