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
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class l
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.EWG.setPosition(paramInt1);
    Object localObject1 = parambl.Eql;
    Object localObject3 = parambl.DqO;
    paramInt1 = 0;
    int i;
    if (parambl.Eoq)
    {
      if (((SnsInfo)localObject3).getAdXml().adContentStyle == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.EIs.setTag(paramBaseViewHolder);
        paramBaseViewHolder.EIs.setOnClickListener(parambk.DQs.Fbi);
      }
      i = 0;
    }
    label4746:
    for (;;)
    {
      label106:
      int j;
      if (paramInt1 != 0)
      {
        parambk.fiV().c(paramBaseViewHolder.EIs, parambk.DQs.FaK, parambk.DQs.Far);
        if (paramTimeLineObject.ContentObj.LoU != 9) {
          break label1561;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1581;
        }
        parambl = bk.aRf(paramTimeLineObject.ContentObj.Url);
        label139:
        if ((paramTimeLineObject.ContentObj.LoU == 9) || (paramTimeLineObject.ContentObj.LoU == 14) || (paramTimeLineObject.ContentObj.LoU == 12) || (paramTimeLineObject.ContentObj.LoU == 13) || (paramInt1 != 0)) {
          parambl = paramTimeLineObject.ContentObj.Desc;
        }
        if ((paramTimeLineObject.ContentObj.LoY == null) || (paramTimeLineObject.ContentObj.LoY.iwf != 1)) {
          break label4802;
        }
      }
      label428:
      label1581:
      label4539:
      label4802:
      for (Object localObject2 = MMApplicationContext.getContext().getString(2131763172);; localObject2 = parambl)
      {
        parambk = paramTimeLineObject.ContentObj.Title;
        if ((parambk != null) && (parambk.length() > 40)) {
          parambk = parambk.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.uzC.setVisibility(8);
          Object localObject4;
          if (!paramTimeLineObject.ContentObj.LoV.isEmpty())
          {
            paramBaseViewHolder.EWG.setVisibility(0);
            localObject1 = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
            if (paramTimeLineObject.ContentObj.LoU == 5)
            {
              parambl = ((cnb)localObject1).Title;
              paramBaseViewHolder.uzC.setImageResource(2131691480);
              paramBaseViewHolder.uzC.setVisibility(0);
              parambk = com.tencent.mm.plugin.sns.model.aj.faL();
              localObject3 = paramBaseViewHolder.EWG;
              paramInt1 = this.mActivity.hashCode();
              localObject4 = bp.gCU();
              ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
              parambk.a((cnb)localObject1, (View)localObject3, 2131689584, paramInt1, (bp)localObject4);
              localObject1 = localObject2;
              if (Util.isNullOrNil((String)localObject1)) {
                break label4689;
              }
              paramBaseViewHolder.EWH.setVisibility(0);
              paramBaseViewHolder.EWH.setText((CharSequence)localObject1);
              label453:
              if (Util.isNullOrNil(parambl)) {
                break label4746;
              }
              if (paramBaseViewHolder.EWH.getVisibility() != 8) {
                break label4701;
              }
              if (paramBaseViewHolder.EWI != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
            }
          }
          for (paramBaseViewHolder.EWI = 2;; paramBaseViewHolder.EWI = 1)
          {
            paramBaseViewHolder.titleTv.setVisibility(0);
            if (i == 0) {
              break label4725;
            }
            paramBaseViewHolder.titleTv.setText(r.a(parambl, this.mActivity, paramBaseViewHolder.titleTv));
            AppMethodBeat.o(100090);
            return;
            if (paramTimeLineObject.ContentObj.LoU == 9)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERk);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 10)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERm);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 17)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERn);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 22)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERo);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 23)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERp);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 14)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERl);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 12)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
                break label4808;
              }
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERv);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 13)
            {
              if (paramTimeLineObject.ContentObj.LoV.size() > 0)
              {
                paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERw);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.EIs.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 30)
            {
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERt);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 26)
            {
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERx);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if ((paramTimeLineObject.ContentObj.LoU == 28) || (paramTimeLineObject.ContentObj.LoU == 29) || (paramTimeLineObject.ContentObj.LoU == 38) || (paramTimeLineObject.ContentObj.LoU == 34) || (paramTimeLineObject.ContentObj.LoU == 37) || (paramTimeLineObject.ContentObj.LoU == 36))
            {
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.EIc);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 41)
            {
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.ERy);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 39)
            {
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.EIc);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.ContentObj.LoU == 4)
            {
              paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.EIc);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, (String)localObject1));
            paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.EIc);
            if ((paramTimeLineObject.contentattr & 0x1) <= 0) {
              break label4808;
            }
            paramInt1 = 0;
            i = 1;
            break;
            parambk.fiV().c(paramBaseViewHolder.EIs, parambk.DQs.FaG, parambk.DQs.Far);
            break label106;
            if ((aq.a.fbx() & 0x1) <= 0)
            {
              j = 1;
              break label122;
            }
            j = 0;
            break label122;
            parambl = "";
            break label139;
            if (paramTimeLineObject.ContentObj.LoU == 18)
            {
              paramBaseViewHolder.uzC.setVisibility(0);
              paramBaseViewHolder.uzC.setImageResource(2131691480);
              paramBaseViewHolder.EWG.setVisibility(0);
              parambl = com.tencent.mm.plugin.sns.model.aj.faL();
              localObject3 = paramBaseViewHolder.EWG;
              paramInt1 = this.mActivity.hashCode();
              localObject4 = bp.gCU();
              ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
              parambl.a((cnb)localObject1, (View)localObject3, 2131689584, paramInt1, (bp)localObject4);
              localObject1 = localObject2;
              parambl = parambk;
              break label428;
            }
            if ((paramTimeLineObject.weappInfo != null) && (paramTimeLineObject.weappInfo.path != null) && (paramTimeLineObject.weappInfo.subType == 1))
            {
              paramBaseViewHolder.uzC.setImageResource(2131691480);
              paramBaseViewHolder.uzC.setVisibility(0);
            }
            if ((paramTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.webSearchInfo.IEy)))
            {
              paramBaseViewHolder.uzC.setImageResource(2131691480);
              paramBaseViewHolder.uzC.setVisibility(0);
            }
            if ((paramTimeLineObject.ContentObj.LoY != null) && (paramTimeLineObject.ContentObj.LoY.iAb == 5))
            {
              paramBaseViewHolder.uzC.setImageResource(2131691480);
              paramBaseViewHolder.uzC.setVisibility(0);
            }
            parambl = com.tencent.mm.plugin.sns.model.aj.faL();
            localObject3 = paramBaseViewHolder.EWG;
            paramInt1 = this.mActivity.hashCode();
            localObject4 = bp.gCU();
            ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
            parambl.b((cnb)localObject1, (View)localObject3, paramInt1, (bp)localObject4);
            localObject1 = localObject2;
            parambl = parambk;
            break label428;
            if (paramTimeLineObject.ContentObj.LoU == 18)
            {
              paramBaseViewHolder.uzC.setVisibility(0);
              paramBaseViewHolder.uzC.setImageResource(2131691480);
              paramBaseViewHolder.EWG.setVisibility(0);
              com.tencent.mm.plugin.sns.model.aj.faL().d(paramBaseViewHolder.EWG, -1, 2131689584, this.mActivity.hashCode());
              localObject1 = localObject2;
              parambl = parambk;
              break label428;
            }
            if (paramTimeLineObject.ContentObj.LoU == 26)
            {
              paramBaseViewHolder.EWG.setVisibility(0);
              com.tencent.mm.plugin.sns.model.aj.faL().d(paramBaseViewHolder.EWG, -1, 2131691246, this.mActivity.hashCode());
              localObject1 = localObject2;
              parambl = parambk;
              break label428;
            }
            if (paramTimeLineObject.ContentObj.LoU == 28)
            {
              localObject1 = localObject2;
              parambl = parambk;
              if (paramTimeLineObject.ContentObj.dME == null) {
                break label428;
              }
              if ((((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry()) || (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sbx, 0) == 0))
              {
                if ((!Util.isNullOrNil(paramTimeLineObject.ContentObj.dME.nickname)) || (Util.isNullOrNil(paramTimeLineObject.ContentObj.dME.desc))) {
                  break label2338;
                }
                parambk = paramTimeLineObject.ContentObj.dME.desc;
              }
              for (;;)
              {
                paramBaseViewHolder.EWG.setVisibility(0);
                localObject1 = localObject2;
                parambl = parambk;
                if (paramTimeLineObject.ContentObj.dME.mediaList.isEmpty()) {
                  break;
                }
                parambl = new cnb();
                parambl.Url = ((bch)paramTimeLineObject.ContentObj.dME.mediaList.get(0)).thumbUrl;
                parambl.Msz = ((bch)paramTimeLineObject.ContentObj.dME.mediaList.get(0)).thumbUrl;
                parambl.oUv = 2;
                parambl.MsA = 1;
                parambl.MsB = new cnd();
                parambl.Mcw = 1;
                parambl.MsB.Mto = ((bch)paramTimeLineObject.ContentObj.dME.mediaList.get(0)).width;
                parambl.MsB.Mtp = ((bch)paramTimeLineObject.ContentObj.dME.mediaList.get(0)).height;
                parambl.Id = ((SnsInfo)localObject3).getSnsId();
                localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
                localObject3 = paramBaseViewHolder.EWG;
                paramInt1 = this.mActivity.hashCode();
                localObject4 = bp.gCU();
                ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
                ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambl, (View)localObject3, paramInt1, (bp)localObject4);
                localObject1 = localObject2;
                parambl = parambk;
                break;
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.dME.desc)) {
                  parambk = paramTimeLineObject.ContentObj.dME.nickname + ": " + paramTimeLineObject.ContentObj.dME.desc;
                } else {
                  parambk = this.mActivity.getString(2131766209, new Object[] { paramTimeLineObject.ContentObj.dME.nickname });
                }
              }
            }
            if (paramTimeLineObject.ContentObj.LoU == 36)
            {
              localObject1 = localObject2;
              parambl = parambk;
              if (paramTimeLineObject.ContentObj.Lpd == null) {
                break label428;
              }
              if ((((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry()) || (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sbx, 0) == 0))
              {
                if ((Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpd.nickname)) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpd.desc))) {
                  parambk = paramTimeLineObject.ContentObj.Lpd.desc;
                }
              }
              else
              {
                label2553:
                paramBaseViewHolder.EWG.setVisibility(0);
                localObject1 = localObject2;
                parambl = parambk;
                if (paramTimeLineObject.ContentObj.Lpd.mediaList.isEmpty()) {
                  break label428;
                }
                localObject1 = new cnb();
                if (TextUtils.isEmpty(((cok)paramTimeLineObject.ContentObj.Lpd.mediaList.get(0)).coverUrl)) {
                  break label2906;
                }
              }
              label2906:
              for (parambl = ((cok)paramTimeLineObject.ContentObj.Lpd.mediaList.get(0)).coverUrl;; parambl = ((cok)paramTimeLineObject.ContentObj.Lpd.mediaList.get(0)).thumbUrl)
              {
                ((cnb)localObject1).Url = parambl;
                ((cnb)localObject1).Msz = parambl;
                ((cnb)localObject1).oUv = 2;
                ((cnb)localObject1).MsA = 1;
                ((cnb)localObject1).MsB = new cnd();
                ((cnb)localObject1).Mcw = 1;
                ((cnb)localObject1).MsB.Mto = ((cok)paramTimeLineObject.ContentObj.Lpd.mediaList.get(0)).width;
                ((cnb)localObject1).MsB.Mtp = ((cok)paramTimeLineObject.ContentObj.Lpd.mediaList.get(0)).height;
                ((cnb)localObject1).Id = ((SnsInfo)localObject3).getSnsId();
                parambl = com.tencent.mm.plugin.sns.model.aj.faL();
                localObject3 = paramBaseViewHolder.EWG;
                paramInt1 = this.mActivity.hashCode();
                localObject4 = bp.gCU();
                ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
                parambl.b((cnb)localObject1, (View)localObject3, paramInt1, (bp)localObject4);
                localObject1 = localObject2;
                parambl = parambk;
                break;
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpd.desc))
                {
                  parambk = paramTimeLineObject.ContentObj.Lpd.nickname + ": " + paramTimeLineObject.ContentObj.Lpd.desc;
                  break label2553;
                }
                parambk = this.mActivity.getString(2131766209, new Object[] { paramTimeLineObject.ContentObj.Lpd.nickname });
                break label2553;
              }
            }
            if ((paramTimeLineObject.ContentObj.LoU == 29) || (paramTimeLineObject.ContentObj.LoU == 37))
            {
              localObject1 = localObject2;
              parambl = parambk;
              if (paramTimeLineObject.ContentObj.LoZ == null) {
                break label428;
              }
              parambl = this.mActivity.getString(2131755857);
              if (paramTimeLineObject.ContentObj.LoZ != null) {
                if (paramTimeLineObject.ContentObj.LoZ.tvC != 1) {
                  break label3226;
                }
              }
              for (parambl = MMApplicationContext.getContext().getString(2131766212, new Object[] { paramTimeLineObject.ContentObj.LoZ.dST });; parambl = paramTimeLineObject.ContentObj.LoZ.dST)
              {
                paramBaseViewHolder.EWG.setVisibility(0);
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.LoZ.iconUrl))
                {
                  parambk = new cnb();
                  parambk.Url = paramTimeLineObject.ContentObj.LoZ.iconUrl;
                  parambk.Msz = paramTimeLineObject.ContentObj.LoZ.iconUrl;
                  parambk.oUv = 2;
                  parambk.MsA = 1;
                  parambk.MsB = new cnd();
                  parambk.Mcw = 1;
                  parambk.MsB.Mto = 0.0F;
                  parambk.MsB.Mtp = 0.0F;
                  parambk.Id = ((SnsInfo)localObject3).getSnsId();
                  localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
                  localObject2 = paramBaseViewHolder.EWG;
                  paramInt1 = this.mActivity.hashCode();
                  localObject3 = bp.gCU();
                  ((bp)localObject3).hXs = paramTimeLineObject.CreateTime;
                  ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambk, (View)localObject2, paramInt1, (bp)localObject3);
                }
                localObject1 = paramTimeLineObject.ContentObj.LoZ.desc;
                break;
              }
            }
            if (paramTimeLineObject.ContentObj.LoU == 38)
            {
              localObject1 = localObject2;
              parambl = parambk;
              if (paramTimeLineObject.ContentObj.Lpb == null) {
                break label428;
              }
              parambk = paramTimeLineObject.ContentObj.Lpb.title;
              paramBaseViewHolder.EWG.setVisibility(0);
              localObject1 = localObject2;
              parambl = parambk;
              if (paramTimeLineObject.ContentObj.Lpb.LLt.size() <= 0) {
                break label428;
              }
              parambl = new cnb();
              localObject1 = (String)paramTimeLineObject.ContentObj.Lpb.LLt.get(0);
              localObject4 = (String)paramTimeLineObject.ContentObj.Lpb.LLu.get(0);
              parambl.Url = ((String)localObject1 + (String)localObject4);
              parambl.Msz = parambl.Url;
              parambl.oUv = 2;
              parambl.MsA = 1;
              parambl.MsB = new cnd();
              parambl.Mcw = 1;
              parambl.MsB.Mto = 0.0F;
              parambl.MsB.Mtp = 0.0F;
              parambl.Id = ((SnsInfo)localObject3).getSnsId();
              localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
              localObject3 = paramBaseViewHolder.EWG;
              paramInt1 = this.mActivity.hashCode();
              localObject4 = bp.gCU();
              ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
              ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambl, (View)localObject3, paramInt1, (bp)localObject4);
              localObject1 = localObject2;
              parambl = parambk;
              break label428;
            }
            if (paramTimeLineObject.ContentObj.LoU == 34)
            {
              localObject1 = localObject2;
              parambl = parambk;
              if (paramTimeLineObject.ContentObj.Lpc == null) {
                break label428;
              }
              if ((((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry()) || (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sbx, 0) == 0))
              {
                if ((!Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpc.nickName)) || (Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpc.desc))) {
                  break label3815;
                }
                parambk = paramTimeLineObject.ContentObj.Lpc.desc;
              }
              for (;;)
              {
                paramBaseViewHolder.EWG.setVisibility(0);
                localObject1 = localObject2;
                parambl = parambk;
                if (paramTimeLineObject.ContentObj.Lpc.coverUrl.isEmpty()) {
                  break;
                }
                parambl = new cnb();
                parambl.Url = paramTimeLineObject.ContentObj.Lpc.coverUrl;
                parambl.Msz = paramTimeLineObject.ContentObj.Lpc.coverUrl;
                parambl.oUv = 2;
                parambl.MsA = 1;
                parambl.MsB = new cnd();
                parambl.Mcw = 1;
                parambl.MsB.Mto = paramTimeLineObject.ContentObj.Lpc.width;
                parambl.MsB.Mtp = paramTimeLineObject.ContentObj.Lpc.height;
                parambl.Id = ((SnsInfo)localObject3).getSnsId();
                localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
                localObject3 = paramBaseViewHolder.EWG;
                paramInt1 = this.mActivity.hashCode();
                localObject4 = bp.gCU();
                ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
                ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambl, (View)localObject3, paramInt1, (bp)localObject4);
                localObject1 = localObject2;
                parambl = parambk;
                break;
                label3815:
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpc.desc)) {
                  parambk = paramTimeLineObject.ContentObj.Lpc.nickName + ": " + paramTimeLineObject.ContentObj.Lpc.desc;
                } else {
                  parambk = this.mActivity.getString(2131766211, new Object[] { paramTimeLineObject.ContentObj.Lpc.nickName });
                }
              }
            }
            if (paramTimeLineObject.ContentObj.LoU == 39) {
              switch (paramTimeLineObject.ContentObj.izD)
              {
              default: 
                localObject1 = localObject2;
                parambl = parambk;
                break;
              case 1: 
                localObject1 = localObject2;
                parambl = parambk;
                if (paramTimeLineObject.ContentObj.Lpe == null) {
                  break;
                }
                parambk = this.mActivity.getString(2131755857);
                parambl = parambk;
                if (paramTimeLineObject.ContentObj.Lpe.tvC == 7)
                {
                  parambl = parambk;
                  if (paramTimeLineObject.ContentObj.Lpe.LLD != null) {
                    parambl = MMApplicationContext.getContext().getString(2131766207, new Object[] { paramTimeLineObject.ContentObj.Lpe.LLD.LAr, paramTimeLineObject.ContentObj.Lpe.LLD.LAq });
                  }
                }
                paramBaseViewHolder.EWG.setVisibility(0);
                if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Lpe.iconUrl))
                {
                  parambk = new cnb();
                  parambk.Url = paramTimeLineObject.ContentObj.Lpe.iconUrl;
                  parambk.Msz = paramTimeLineObject.ContentObj.Lpe.iconUrl;
                  parambk.oUv = 2;
                  parambk.MsA = 1;
                  parambk.MsB = new cnd();
                  parambk.Mcw = 1;
                  parambk.MsB.Mto = 0.0F;
                  parambk.MsB.Mtp = 0.0F;
                  parambk.Id = ((SnsInfo)localObject3).getSnsId();
                  localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
                  localObject2 = paramBaseViewHolder.EWG;
                  paramInt1 = this.mActivity.hashCode();
                  localObject3 = bp.gCU();
                  ((bp)localObject3).hXs = paramTimeLineObject.CreateTime;
                  ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambk, (View)localObject2, paramInt1, (bp)localObject3);
                }
                localObject1 = paramTimeLineObject.ContentObj.Lpe.desc;
                break;
              case 100000000: 
                localObject1 = localObject2;
                parambl = parambk;
                if (paramTimeLineObject.ContentObj.LoZ == null) {
                  break;
                }
                parambl = this.mActivity.getString(2131755857);
                if (paramTimeLineObject.ContentObj.LoZ != null)
                {
                  if (paramTimeLineObject.ContentObj.LoZ.tvC != 1) {
                    break label4539;
                  }
                  parambl = MMApplicationContext.getContext().getString(2131766212, new Object[] { paramTimeLineObject.ContentObj.LoZ.dST });
                }
                for (;;)
                {
                  paramBaseViewHolder.EWG.setVisibility(0);
                  if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.LoZ.iconUrl))
                  {
                    parambk = new cnb();
                    parambk.Url = paramTimeLineObject.ContentObj.LoZ.iconUrl;
                    parambk.Msz = paramTimeLineObject.ContentObj.LoZ.iconUrl;
                    parambk.oUv = 2;
                    parambk.MsA = 1;
                    parambk.MsB = new cnd();
                    parambk.Mcw = 1;
                    parambk.MsB.Mto = 0.0F;
                    parambk.MsB.Mtp = 0.0F;
                    parambk.Id = ((SnsInfo)localObject3).getSnsId();
                    localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
                    localObject2 = paramBaseViewHolder.EWG;
                    paramInt1 = this.mActivity.hashCode();
                    localObject3 = bp.gCU();
                    ((bp)localObject3).hXs = paramTimeLineObject.CreateTime;
                    ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambk, (View)localObject2, paramInt1, (bp)localObject3);
                  }
                  localObject1 = paramTimeLineObject.ContentObj.LoZ.desc;
                  break;
                  if (paramTimeLineObject.ContentObj.LoZ.tvC == 7)
                  {
                    if (paramTimeLineObject.ContentObj.LoZ.LLD != null) {
                      parambl = MMApplicationContext.getContext().getString(2131766207, new Object[] { paramTimeLineObject.ContentObj.LoZ.LLD.LAr, paramTimeLineObject.ContentObj.LoZ.LLD.LAq });
                    } else {
                      parambl = paramTimeLineObject.ContentObj.LoZ.dST;
                    }
                  }
                  else {
                    parambl = paramTimeLineObject.ContentObj.LoZ.dST;
                  }
                }
              }
            }
            paramBaseViewHolder.EWG.setVisibility(0);
            com.tencent.mm.plugin.sns.model.aj.faL().d(paramBaseViewHolder.EWG, -1, 2131689587, this.mActivity.hashCode());
            localObject1 = localObject2;
            parambl = parambk;
            break label428;
            label4689:
            paramBaseViewHolder.EWH.setVisibility(8);
            break label453;
            label4701:
            if (paramBaseViewHolder.EWI != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
          }
          label4725:
          paramBaseViewHolder.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.mActivity, parambl));
          AppMethodBeat.o(100090);
          return;
          if (paramInt2 == 1)
          {
            paramBaseViewHolder.titleTv.setText(bk.aRf(paramTimeLineObject.ContentObj.Url));
            paramBaseViewHolder.titleTv.setVisibility(0);
            AppMethodBeat.o(100090);
            return;
          }
          paramBaseViewHolder.titleTv.setVisibility(8);
          AppMethodBeat.o(100090);
          return;
        }
      }
      label1561:
      label2338:
      label4808:
      paramInt1 = 0;
      label3226:
      i = 0;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100089);
    if ((paramBaseViewHolder.EWD != null) && (paramBaseViewHolder.EWD.getParent() != null))
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496461);
      if (!paramBaseViewHolder.EXq) {
        paramBaseViewHolder.EXr = paramBaseViewHolder.EWD.inflate();
      }
    }
    for (paramBaseViewHolder.EXq = true;; paramBaseViewHolder.EXq = true)
    {
      paramBaseViewHolder.EIs = paramBaseViewHolder.EXr;
      paramBaseViewHolder.EWG = ((TagImageView)paramBaseViewHolder.EIs.findViewById(2131302578));
      paramBaseViewHolder.uzC = ((ImageView)paramBaseViewHolder.EIs.findViewById(2131308376));
      paramBaseViewHolder.EWH = ((TextView)paramBaseViewHolder.EIs.findViewById(2131307116));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.EIs.findViewById(2131309253));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100904));
      r.b(paramBaseViewHolder.EWG, this.mActivity);
      AppMethodBeat.o(100089);
      return;
      paramBaseViewHolder.EXr = paramBaseViewHolder.convertView.findViewById(2131304553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.l
 * JD-Core Version:    0.7.0.1
 */