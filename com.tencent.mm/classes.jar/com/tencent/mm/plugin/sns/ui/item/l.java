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
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.j;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class l
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.RKJ.setPosition(paramInt1);
    Object localObject1 = parambo.Rdg;
    Object localObject4 = parambo.PJQ;
    int j = 0;
    if (parambo.Rbg)
    {
      if (((SnsInfo)localObject4).getAdXml().adContentStyle != 2) {
        break label5400;
      }
      paramInt1 = 1;
      paramBaseViewHolder.Rwr.setTag(paramBaseViewHolder);
      paramBaseViewHolder.Rwr.setOnClickListener(parambn.QBf.RQL);
    }
    for (;;)
    {
      j = paramInt1;
      paramInt1 = 0;
      for (;;)
      {
        label110:
        int i;
        if (j != 0)
        {
          parambn.hpB().c(paramBaseViewHolder.Rwr, parambn.QBf.RQn, parambn.QBf.RPU);
          if (paramTimeLineObject.ContentObj.Zpq != 9) {
            break label1796;
          }
          i = 1;
          label126:
          if (i == 0) {
            break label1816;
          }
          parambn = bn.baM(paramTimeLineObject.ContentObj.Url);
          label144:
          if ((paramTimeLineObject.ContentObj.Zpq == 9) || (paramTimeLineObject.ContentObj.Zpq == 14) || (paramTimeLineObject.ContentObj.Zpq == 12) || (paramTimeLineObject.ContentObj.Zpq == 13) || (j != 0)) {
            parambn = paramTimeLineObject.ContentObj.IGG;
          }
          if ((paramTimeLineObject.ContentObj.Zpu == null) || (paramTimeLineObject.ContentObj.Zpu.nQp != 1)) {
            break label5388;
          }
        }
        label1796:
        label5382:
        label5388:
        for (Object localObject3 = MMApplicationContext.getContext().getString(b.j.mp_pay_content);; localObject3 = parambn)
        {
          localObject1 = paramTimeLineObject.ContentObj.hAP;
          if ((localObject1 != null) && (((String)localObject1).length() > 40))
          {
            j.iVg();
            i = j.iE((String)localObject1, 40);
            localObject1 = ((String)localObject1).substring(0, i) + "...";
          }
          for (;;)
          {
            paramBaseViewHolder.DOt.setVisibility(8);
            Object localObject2;
            Object localObject5;
            if (!paramTimeLineObject.ContentObj.Zpr.isEmpty())
            {
              paramBaseViewHolder.RKJ.setVisibility(0);
              localObject2 = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
              paramBaseViewHolder.desc = (this.mActivity.getString(b.j.sns_link) + "," + (String)localObject1 + "," + ((dmz)localObject2).IGG);
              if (paramTimeLineObject.ContentObj.Zpq == 5)
              {
                parambn = ((dmz)localObject2).hAP;
                paramBaseViewHolder.DOt.setImageResource(b.i.shortvideo_play_btn);
                paramBaseViewHolder.DOt.setVisibility(0);
                localObject1 = al.hgy();
                localObject4 = paramBaseViewHolder.RKJ;
                i = b.i.app_attach_file_icon_video;
                j = this.mActivity.hashCode();
                localObject5 = br.jbh();
                ((br)localObject5).time = paramTimeLineObject.CreateTime;
                ((g)localObject1).a((dmz)localObject2, (View)localObject4, i, j, (br)localObject5);
                localObject2 = localObject3;
              }
            }
            for (;;)
            {
              if (!Util.isNullOrNil((String)localObject2))
              {
                paramBaseViewHolder.RKK.setVisibility(0);
                paramBaseViewHolder.RKK.setText((CharSequence)localObject2);
                label533:
                if (Util.isNullOrNil(parambn)) {
                  break label5287;
                }
                if (paramBaseViewHolder.RKK.getVisibility() != 8) {
                  break label5244;
                }
                if (paramBaseViewHolder.RKL != 2) {
                  paramBaseViewHolder.titleTv.setMaxLines(2);
                }
                paramBaseViewHolder.RKL = 2;
                label574:
                paramBaseViewHolder.titleTv.setVisibility(0);
                if (paramInt1 == 0) {
                  break label5268;
                }
                paramBaseViewHolder.titleTv.setText(t.a(parambn, this.mActivity, paramBaseViewHolder.titleTv));
                label606:
                paramBaseViewHolder.titleTv.setContentDescription(this.mActivity.getResources().getString(b.j.sns_link) + "," + paramBaseViewHolder.titleTv.getText());
                label654:
                a(parambo, 2);
                AppMethodBeat.o(100090);
                return;
                if (paramTimeLineObject.ContentObj.Zpq == 9)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFy);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 10)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFA);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 17)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFB);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 22)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFC);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 23)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFD);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 14)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFz);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 12)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
                    break label5395;
                  }
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFJ);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 13)
                {
                  if (paramTimeLineObject.ContentObj.Zpr.size() > 0)
                  {
                    paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                    paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFK);
                    paramInt1 = 0;
                    break;
                  }
                  paramBaseViewHolder.Rwr.setOnClickListener(null);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 30)
                {
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFH);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 26)
                {
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFL);
                  paramInt1 = 0;
                  break;
                }
                if ((paramTimeLineObject.ContentObj.Zpq == 28) || (paramTimeLineObject.ContentObj.Zpq == 29) || (paramTimeLineObject.ContentObj.Zpq == 38) || (paramTimeLineObject.ContentObj.Zpq == 34) || (paramTimeLineObject.ContentObj.Zpq == 45) || (paramTimeLineObject.ContentObj.Zpq == 37) || (paramTimeLineObject.ContentObj.Zpq == 36) || (paramTimeLineObject.ContentObj.Zpq == 44))
                {
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.Rwb);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 41)
                {
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.RFM);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 39)
                {
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.Rwb);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 4)
                {
                  paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                  paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.Rwb);
                  paramBaseViewHolder.desc = (this.mActivity.getString(b.j.sns_link) + ((dmz)paramTimeLineObject.ContentObj.Zpr.get(0)).hAP + "," + paramTimeLineObject.ContentObj.IGG);
                  paramInt1 = 0;
                  break;
                }
                if (paramTimeLineObject.ContentObj.Zpq == 3) {
                  ((m.a)paramBaseViewHolder).desc = (this.mActivity.getString(b.j.sns_link) + "，" + paramTimeLineObject.ContentObj.hAP);
                }
                paramBaseViewHolder.Rwr.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.Rwr.setOnClickListener(parambn.RoS.Rwb);
                if ((paramTimeLineObject.contentattr & 0x1) <= 0) {
                  break label5395;
                }
                paramInt1 = 1;
                break;
                parambn.hpB().c(paramBaseViewHolder.Rwr, parambn.QBf.RQj, parambn.QBf.RPU);
                break label110;
                if ((ar.a.hhj() & 0x1) <= 0)
                {
                  i = 1;
                  break label126;
                }
                i = 0;
                break label126;
                label1816:
                parambn = "";
                break label144;
                if (paramTimeLineObject.ContentObj.Zpq == 18)
                {
                  paramBaseViewHolder.DOt.setVisibility(0);
                  paramBaseViewHolder.DOt.setImageResource(b.i.shortvideo_play_btn);
                  paramBaseViewHolder.RKJ.setVisibility(0);
                  parambn = al.hgy();
                  localObject4 = paramBaseViewHolder.RKJ;
                  i = b.i.app_attach_file_icon_video;
                  j = this.mActivity.hashCode();
                  localObject5 = br.jbh();
                  ((br)localObject5).time = paramTimeLineObject.CreateTime;
                  parambn.a((dmz)localObject2, (View)localObject4, i, j, (br)localObject5);
                  localObject2 = localObject3;
                  parambn = (bn)localObject1;
                }
                else
                {
                  if ((paramTimeLineObject.weappInfo != null) && (paramTimeLineObject.weappInfo.path != null) && (paramTimeLineObject.weappInfo.subType == 1))
                  {
                    paramBaseViewHolder.DOt.setImageResource(b.i.shortvideo_play_btn);
                    paramBaseViewHolder.DOt.setVisibility(0);
                  }
                  if ((paramTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.webSearchInfo.WoZ)))
                  {
                    paramBaseViewHolder.DOt.setImageResource(b.i.shortvideo_play_btn);
                    paramBaseViewHolder.DOt.setVisibility(0);
                  }
                  if ((paramTimeLineObject.ContentObj.Zpu != null) && (paramTimeLineObject.ContentObj.Zpu.nUA == 16))
                  {
                    paramBaseViewHolder.DOt.setImageResource(b.i.shortvideo_play_btn);
                    paramBaseViewHolder.DOt.setVisibility(0);
                  }
                  parambn = al.hgy();
                  localObject4 = paramBaseViewHolder.RKJ;
                  i = this.mActivity.hashCode();
                  localObject5 = br.jbh();
                  ((br)localObject5).time = paramTimeLineObject.CreateTime;
                  parambn.b((dmz)localObject2, (View)localObject4, i, (br)localObject5);
                  localObject2 = localObject3;
                  parambn = (bn)localObject1;
                  continue;
                  if (paramTimeLineObject.ContentObj.Zpq == 18)
                  {
                    paramBaseViewHolder.DOt.setVisibility(0);
                    paramBaseViewHolder.DOt.setImageResource(b.i.shortvideo_play_btn);
                    paramBaseViewHolder.RKJ.setVisibility(0);
                    al.hgy().c(paramBaseViewHolder.RKJ, -1, b.i.app_attach_file_icon_video, this.mActivity.hashCode());
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                  }
                  else if (paramTimeLineObject.ContentObj.Zpq == 26)
                  {
                    paramBaseViewHolder.RKJ.setVisibility(0);
                    al.hgy().c(paramBaseViewHolder.RKJ, -1, b.i.note_sns_link_default, this.mActivity.hashCode());
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                  }
                  else if (paramTimeLineObject.ContentObj.Zpq == 28)
                  {
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                    if (paramTimeLineObject.ContentObj.hKU != null)
                    {
                      if ((((cn)h.az(cn.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 0))
                      {
                        if ((!Util.isNullOrNil(t.e(paramTimeLineObject.ContentObj.hKU))) || (Util.isNullOrNil(paramTimeLineObject.ContentObj.hKU.desc))) {
                          break label2614;
                        }
                        localObject1 = paramTimeLineObject.ContentObj.hKU.desc;
                      }
                      for (;;)
                      {
                        paramBaseViewHolder.RKJ.setVisibility(0);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                        if (paramTimeLineObject.ContentObj.hKU.mediaList.isEmpty()) {
                          break;
                        }
                        parambn = new dmz();
                        parambn.Url = ((bvj)paramTimeLineObject.ContentObj.hKU.mediaList.get(0)).thumbUrl;
                        parambn.aaTl = ((bvj)paramTimeLineObject.ContentObj.hKU.mediaList.get(0)).thumbUrl;
                        parambn.vhJ = 2;
                        parambn.aaTm = 1;
                        parambn.aaTn = new dnb();
                        parambn.aazR = 1;
                        parambn.aaTn.aaUb = ((bvj)paramTimeLineObject.ContentObj.hKU.mediaList.get(0)).width;
                        parambn.aaTn.aaUc = ((bvj)paramTimeLineObject.ContentObj.hKU.mediaList.get(0)).height;
                        parambn.Id = ((SnsInfo)localObject4).getSnsId();
                        localObject2 = al.hgy();
                        localObject4 = paramBaseViewHolder.RKJ;
                        i = this.mActivity.hashCode();
                        localObject5 = br.jbh();
                        ((br)localObject5).time = paramTimeLineObject.CreateTime;
                        ((g)localObject2).b(parambn, (View)localObject4, i, (br)localObject5);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                        break;
                        label2614:
                        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.hKU.desc)) {
                          localObject1 = t.e(paramTimeLineObject.ContentObj.hKU) + ": " + paramTimeLineObject.ContentObj.hKU.desc;
                        } else {
                          localObject1 = this.mActivity.getString(b.j.sns_share_finder_feed_title, new Object[] { t.e(paramTimeLineObject.ContentObj.hKU) });
                        }
                      }
                    }
                  }
                  else if (paramTimeLineObject.ContentObj.Zpq == 36)
                  {
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                    if (paramTimeLineObject.ContentObj.Zpy != null)
                    {
                      if ((((cn)h.az(cn.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 0))
                      {
                        if ((Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpy.nickname)) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpy.desc))) {
                          localObject1 = paramTimeLineObject.ContentObj.Zpy.desc;
                        }
                      }
                      else
                      {
                        label2830:
                        paramBaseViewHolder.RKJ.setVisibility(0);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                        if (paramTimeLineObject.ContentObj.Zpy.mediaList.isEmpty()) {
                          continue;
                        }
                        localObject2 = new dmz();
                        if (TextUtils.isEmpty(((dob)paramTimeLineObject.ContentObj.Zpy.mediaList.get(0)).coverUrl)) {
                          break label3192;
                        }
                      }
                      label3192:
                      for (parambn = ((dob)paramTimeLineObject.ContentObj.Zpy.mediaList.get(0)).coverUrl;; parambn = ((dob)paramTimeLineObject.ContentObj.Zpy.mediaList.get(0)).thumbUrl)
                      {
                        ((dmz)localObject2).Url = parambn;
                        ((dmz)localObject2).aaTl = parambn;
                        ((dmz)localObject2).vhJ = 2;
                        ((dmz)localObject2).aaTm = 1;
                        ((dmz)localObject2).aaTn = new dnb();
                        ((dmz)localObject2).aazR = 1;
                        ((dmz)localObject2).aaTn.aaUb = ((dob)paramTimeLineObject.ContentObj.Zpy.mediaList.get(0)).width;
                        ((dmz)localObject2).aaTn.aaUc = ((dob)paramTimeLineObject.ContentObj.Zpy.mediaList.get(0)).height;
                        ((dmz)localObject2).Id = ((SnsInfo)localObject4).getSnsId();
                        parambn = al.hgy();
                        localObject4 = paramBaseViewHolder.RKJ;
                        i = this.mActivity.hashCode();
                        localObject5 = br.jbh();
                        ((br)localObject5).time = paramTimeLineObject.CreateTime;
                        parambn.b((dmz)localObject2, (View)localObject4, i, (br)localObject5);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                        break;
                        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpy.desc))
                        {
                          localObject1 = paramTimeLineObject.ContentObj.Zpy.nickname + ": " + paramTimeLineObject.ContentObj.Zpy.desc;
                          break label2830;
                        }
                        localObject1 = this.mActivity.getString(b.j.sns_share_finder_feed_title, new Object[] { paramTimeLineObject.ContentObj.Zpy.nickname });
                        break label2830;
                      }
                    }
                  }
                  else if ((paramTimeLineObject.ContentObj.Zpq == 29) || (paramTimeLineObject.ContentObj.Zpq == 37))
                  {
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                    if (paramTimeLineObject.ContentObj.Zpv != null)
                    {
                      parambn = this.mActivity.getString(b.j.app_finder_topic);
                      if (paramTimeLineObject.ContentObj.Zpv != null) {
                        if (paramTimeLineObject.ContentObj.Zpv.Auy != 1) {
                          break label3518;
                        }
                      }
                      label3518:
                      for (parambn = MMApplicationContext.getContext().getString(b.j.sns_share_finder_topic_card_prefix, new Object[] { paramTimeLineObject.ContentObj.Zpv.topic });; parambn = paramTimeLineObject.ContentObj.Zpv.topic)
                      {
                        paramBaseViewHolder.RKJ.setVisibility(0);
                        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpv.iconUrl))
                        {
                          localObject1 = new dmz();
                          ((dmz)localObject1).Url = paramTimeLineObject.ContentObj.Zpv.iconUrl;
                          ((dmz)localObject1).aaTl = paramTimeLineObject.ContentObj.Zpv.iconUrl;
                          ((dmz)localObject1).vhJ = 2;
                          ((dmz)localObject1).aaTm = 1;
                          ((dmz)localObject1).aaTn = new dnb();
                          ((dmz)localObject1).aazR = 1;
                          ((dmz)localObject1).aaTn.aaUb = 0.0F;
                          ((dmz)localObject1).aaTn.aaUc = 0.0F;
                          ((dmz)localObject1).Id = ((SnsInfo)localObject4).getSnsId();
                          localObject2 = al.hgy();
                          localObject3 = paramBaseViewHolder.RKJ;
                          i = this.mActivity.hashCode();
                          localObject4 = br.jbh();
                          ((br)localObject4).time = paramTimeLineObject.CreateTime;
                          ((g)localObject2).b((dmz)localObject1, (View)localObject3, i, (br)localObject4);
                        }
                        localObject2 = paramTimeLineObject.ContentObj.Zpv.desc;
                        break;
                      }
                    }
                  }
                  else if (paramTimeLineObject.ContentObj.Zpq == 38)
                  {
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                    if (paramTimeLineObject.ContentObj.Zpx != null)
                    {
                      localObject1 = paramTimeLineObject.ContentObj.Zpx.title;
                      paramBaseViewHolder.RKJ.setVisibility(0);
                      localObject2 = localObject3;
                      parambn = (bn)localObject1;
                      if (paramTimeLineObject.ContentObj.Zpx.aacP.size() > 0)
                      {
                        parambn = new dmz();
                        localObject2 = (String)paramTimeLineObject.ContentObj.Zpx.aacP.get(0);
                        localObject5 = (String)paramTimeLineObject.ContentObj.Zpx.aacQ.get(0);
                        parambn.Url = ((String)localObject2 + (String)localObject5);
                        parambn.aaTl = parambn.Url;
                        parambn.vhJ = 2;
                        parambn.aaTm = 1;
                        parambn.aaTn = new dnb();
                        parambn.aazR = 1;
                        parambn.aaTn.aaUb = 0.0F;
                        parambn.aaTn.aaUc = 0.0F;
                        parambn.Id = ((SnsInfo)localObject4).getSnsId();
                        localObject2 = al.hgy();
                        localObject4 = paramBaseViewHolder.RKJ;
                        i = this.mActivity.hashCode();
                        localObject5 = br.jbh();
                        ((br)localObject5).time = paramTimeLineObject.CreateTime;
                        ((g)localObject2).b(parambn, (View)localObject4, i, (br)localObject5);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                      }
                    }
                  }
                  else if ((paramTimeLineObject.ContentObj.Zpq == 34) || (paramTimeLineObject.ContentObj.Zpq == 45))
                  {
                    localObject2 = localObject3;
                    parambn = (bn)localObject1;
                    if (paramTimeLineObject.ContentObj.DHa != null)
                    {
                      if ((((cn)h.az(cn.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yZS, 0) == 0))
                      {
                        if ((!Util.isNullOrNil(paramTimeLineObject.ContentObj.DHa.nickName)) || (Util.isNullOrNil(paramTimeLineObject.ContentObj.DHa.desc))) {
                          break label4154;
                        }
                        localObject1 = paramTimeLineObject.ContentObj.DHa.desc;
                      }
                      for (;;)
                      {
                        paramBaseViewHolder.RKJ.setVisibility(0);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                        if (paramTimeLineObject.ContentObj.DHa.coverUrl.isEmpty()) {
                          break;
                        }
                        parambn = new dmz();
                        parambn.Url = paramTimeLineObject.ContentObj.DHa.coverUrl;
                        parambn.aaTl = paramTimeLineObject.ContentObj.DHa.coverUrl;
                        parambn.vhJ = 2;
                        parambn.aaTm = 1;
                        parambn.aaTn = new dnb();
                        parambn.aazR = 1;
                        parambn.aaTn.aaUb = paramTimeLineObject.ContentObj.DHa.width;
                        parambn.aaTn.aaUc = paramTimeLineObject.ContentObj.DHa.height;
                        parambn.Id = ((SnsInfo)localObject4).getSnsId();
                        localObject2 = al.hgy();
                        localObject4 = paramBaseViewHolder.RKJ;
                        i = this.mActivity.hashCode();
                        localObject5 = br.jbh();
                        ((br)localObject5).time = paramTimeLineObject.CreateTime;
                        ((g)localObject2).b(parambn, (View)localObject4, i, (br)localObject5);
                        localObject2 = localObject3;
                        parambn = (bn)localObject1;
                        break;
                        label4154:
                        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.DHa.desc)) {
                          localObject1 = paramTimeLineObject.ContentObj.DHa.nickName + ": " + paramTimeLineObject.ContentObj.DHa.desc;
                        } else {
                          localObject1 = this.mActivity.getString(b.j.sns_share_finder_live_title, new Object[] { paramTimeLineObject.ContentObj.DHa.nickName });
                        }
                      }
                    }
                  }
                  else if (paramTimeLineObject.ContentObj.Zpq == 39)
                  {
                    if (paramTimeLineObject.ContentObj.nUa == 3)
                    {
                      localObject2 = localObject3;
                      parambn = (bn)localObject1;
                      if (paramTimeLineObject.ContentObj.Zpz == null) {
                        continue;
                      }
                      parambn = this.mActivity.getString(b.j.app_finder_topic);
                      if ((paramTimeLineObject.ContentObj.Zpz.Auy != 7) || (paramTimeLineObject.ContentObj.Zpz.aade == null)) {
                        break label5382;
                      }
                      parambn = o.a(paramTimeLineObject.ContentObj.Zpz.aade);
                    }
                  }
                }
              }
            }
            for (;;)
            {
              paramBaseViewHolder.RKJ.setVisibility(0);
              if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpz.iconUrl))
              {
                localObject1 = new dmz();
                ((dmz)localObject1).Url = paramTimeLineObject.ContentObj.Zpz.iconUrl;
                ((dmz)localObject1).aaTl = paramTimeLineObject.ContentObj.Zpz.iconUrl;
                ((dmz)localObject1).vhJ = 2;
                ((dmz)localObject1).aaTm = 1;
                ((dmz)localObject1).aaTn = new dnb();
                ((dmz)localObject1).aazR = 1;
                ((dmz)localObject1).aaTn.aaUb = 0.0F;
                ((dmz)localObject1).aaTn.aaUc = 0.0F;
                ((dmz)localObject1).Id = ((SnsInfo)localObject4).getSnsId();
                paramBaseViewHolder.RKJ.setScaleType(QImageView.a.afVc);
                ((cn)h.az(cn.class)).loadImageForSns(paramTimeLineObject.ContentObj.Zpz.iconUrl, paramBaseViewHolder.RKJ);
              }
              for (;;)
              {
                localObject2 = paramTimeLineObject.ContentObj.Zpz.desc;
                break;
                al.hgy().c(paramBaseViewHolder.RKJ, -1, b.i.icon_filled_activity, this.mActivity.hashCode());
              }
              localObject2 = localObject3;
              parambn = (bn)localObject1;
              if (paramTimeLineObject.ContentObj.nUa != 100000000) {
                break;
              }
              localObject2 = localObject3;
              parambn = (bn)localObject1;
              if (paramTimeLineObject.ContentObj.Zpv == null) {
                break;
              }
              parambn = this.mActivity.getString(b.j.app_finder_topic);
              if (paramTimeLineObject.ContentObj.Zpv != null)
              {
                if (paramTimeLineObject.ContentObj.Zpv.Auy != 1) {
                  break label4854;
                }
                parambn = MMApplicationContext.getContext().getString(b.j.sns_share_finder_topic_card_prefix, new Object[] { paramTimeLineObject.ContentObj.Zpv.topic });
              }
              for (;;)
              {
                paramBaseViewHolder.RKJ.setVisibility(0);
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpv.iconUrl))
                {
                  localObject1 = new dmz();
                  ((dmz)localObject1).Url = paramTimeLineObject.ContentObj.Zpv.iconUrl;
                  ((dmz)localObject1).aaTl = paramTimeLineObject.ContentObj.Zpv.iconUrl;
                  ((dmz)localObject1).vhJ = 2;
                  ((dmz)localObject1).aaTm = 1;
                  ((dmz)localObject1).aaTn = new dnb();
                  ((dmz)localObject1).aazR = 1;
                  ((dmz)localObject1).aaTn.aaUb = 0.0F;
                  ((dmz)localObject1).aaTn.aaUc = 0.0F;
                  ((dmz)localObject1).Id = ((SnsInfo)localObject4).getSnsId();
                  localObject2 = al.hgy();
                  localObject3 = paramBaseViewHolder.RKJ;
                  i = this.mActivity.hashCode();
                  localObject4 = br.jbh();
                  ((br)localObject4).time = paramTimeLineObject.CreateTime;
                  ((g)localObject2).b((dmz)localObject1, (View)localObject3, i, (br)localObject4);
                }
                localObject2 = paramTimeLineObject.ContentObj.Zpv.desc;
                break;
                label4854:
                if (paramTimeLineObject.ContentObj.Zpv.Auy == 7)
                {
                  if (paramTimeLineObject.ContentObj.Zpv.aade != null) {
                    parambn = o.a(paramTimeLineObject.ContentObj.Zpz.aade);
                  } else {
                    parambn = paramTimeLineObject.ContentObj.Zpv.topic;
                  }
                }
                else {
                  parambn = paramTimeLineObject.ContentObj.Zpv.topic;
                }
              }
              if (paramTimeLineObject.ContentObj.Zpq == 44)
              {
                localObject2 = localObject3;
                parambn = (bn)localObject1;
                if (paramTimeLineObject.ContentObj.ZpA == null) {
                  break;
                }
                parambn = paramTimeLineObject.ContentObj.ZpA.poiName;
                paramBaseViewHolder.RKJ.setVisibility(0);
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.ZpA.XOv))
                {
                  localObject1 = new dmz();
                  ((dmz)localObject1).Url = paramTimeLineObject.ContentObj.ZpA.XOv;
                  ((dmz)localObject1).aaTl = paramTimeLineObject.ContentObj.ZpA.XOv;
                  ((dmz)localObject1).vhJ = 2;
                  ((dmz)localObject1).aaTm = 1;
                  ((dmz)localObject1).aaTn = new dnb();
                  ((dmz)localObject1).aazR = 1;
                  ((dmz)localObject1).aaTn.aaUb = 0.0F;
                  ((dmz)localObject1).aaTn.aaUc = 0.0F;
                  ((dmz)localObject1).Id = ((SnsInfo)localObject4).getSnsId();
                  localObject2 = al.hgy();
                  localObject3 = paramBaseViewHolder.RKJ;
                  i = this.mActivity.hashCode();
                  localObject4 = br.jbh();
                  ((br)localObject4).time = paramTimeLineObject.CreateTime;
                  ((g)localObject2).b((dmz)localObject1, (View)localObject3, i, (br)localObject4);
                }
                for (;;)
                {
                  localObject2 = paramTimeLineObject.ContentObj.ZpA.AXm;
                  break;
                  al.hgy().c(paramBaseViewHolder.RKJ, -1, b.i.icons_outlined_location, this.mActivity.hashCode());
                }
              }
              paramBaseViewHolder.RKJ.setVisibility(0);
              al.hgy().c(paramBaseViewHolder.RKJ, -1, b.i.app_attach_file_icon_webpage, this.mActivity.hashCode());
              localObject2 = localObject3;
              parambn = (bn)localObject1;
              break;
              paramBaseViewHolder.RKK.setVisibility(8);
              break label533;
              label5244:
              if (paramBaseViewHolder.RKL != 1) {
                paramBaseViewHolder.titleTv.setMaxLines(1);
              }
              paramBaseViewHolder.RKL = 1;
              break label574;
              label5268:
              paramBaseViewHolder.titleTv.setText(p.b(this.mActivity, parambn));
              break label606;
              label5287:
              if (paramInt2 == 1)
              {
                paramBaseViewHolder.titleTv.setText(bn.baM(paramTimeLineObject.ContentObj.Url));
                paramBaseViewHolder.titleTv.setVisibility(0);
                paramBaseViewHolder.titleTv.setContentDescription(this.mActivity.getResources().getString(b.j.sns_link) + "," + paramBaseViewHolder.titleTv.getText());
                break label654;
              }
              paramBaseViewHolder.titleTv.setVisibility(8);
              break label654;
            }
          }
        }
        label5395:
        paramInt1 = 0;
      }
      label5400:
      paramInt1 = 0;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100089);
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null))
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_media_sub_item2);
      if (!paramBaseViewHolder.RLs) {
        paramBaseViewHolder.RLt = paramBaseViewHolder.RKG.inflate();
      }
    }
    for (paramBaseViewHolder.RLs = true;; paramBaseViewHolder.RLs = true)
    {
      paramBaseViewHolder.Rwr = paramBaseViewHolder.RLt;
      paramBaseViewHolder.RKJ = ((TagImageView)paramBaseViewHolder.Rwr.findViewById(b.f.image_left));
      paramBaseViewHolder.DOt = ((ImageView)paramBaseViewHolder.Rwr.findViewById(b.f.state));
      paramBaseViewHolder.RKK = ((TextView)paramBaseViewHolder.Rwr.findViewById(b.f.righttext));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.Rwr.findViewById(b.f.titletext));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(b.c.normal_text_color));
      t.c(paramBaseViewHolder.RKJ, this.mActivity);
      AppMethodBeat.o(100089);
      return;
      paramBaseViewHolder.RLt = paramBaseViewHolder.convertView.findViewById(b.f.media_content_rl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.l
 * JD-Core Version:    0.7.0.1
 */