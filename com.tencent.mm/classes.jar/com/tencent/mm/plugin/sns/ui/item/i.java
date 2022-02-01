package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class i
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.AMv.setPosition(paramInt1);
    Object localObject1 = parambi.AhK;
    Object localObject3 = parambi.zlW;
    paramInt1 = 0;
    int i;
    if (parambi.AfT)
    {
      if (((p)localObject3).dVj().zND == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.Aza.setTag(paramBaseViewHolder);
        paramBaseViewHolder.Aza.setOnClickListener(parambh.zGs.AQD);
      }
      i = 0;
    }
    label2691:
    for (;;)
    {
      label106:
      int j;
      if (paramInt1 != 0)
      {
        parambh.egu().c(paramBaseViewHolder.Aza, parambh.zGs.AQf, parambh.zGs.APL);
        if (paramTimeLineObject.HUG.Gtw != 9) {
          break label1344;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1364;
        }
        parambi = bh.aCj(paramTimeLineObject.HUG.Url);
        label139:
        if ((paramTimeLineObject.HUG.Gtw == 9) || (paramTimeLineObject.HUG.Gtw == 14) || (paramTimeLineObject.HUG.Gtw == 12) || (paramTimeLineObject.HUG.Gtw == 13) || (paramInt1 != 0)) {
          parambi = paramTimeLineObject.HUG.Desc;
        }
        if ((paramTimeLineObject.HUG.GtA == null) || (paramTimeLineObject.HUG.GtA.hBY != 1)) {
          break label2685;
        }
      }
      label422:
      label447:
      label1344:
      label1364:
      label2135:
      label2685:
      for (localObject1 = ak.getContext().getString(2131761345);; localObject1 = parambi)
      {
        parambi = paramTimeLineObject.HUG.Title;
        if ((parambi != null) && (parambi.length() > 40)) {
          parambi = parambi.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.AfZ.setVisibility(8);
          Object localObject2;
          bk localbk;
          if (!paramTimeLineObject.HUG.Gtx.isEmpty())
          {
            paramBaseViewHolder.AMv.setVisibility(0);
            localObject2 = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
            if (paramTimeLineObject.HUG.Gtw == 5)
            {
              parambh = ((bzh)localObject2).Title;
              paramBaseViewHolder.AfZ.setImageResource(2131691166);
              paramBaseViewHolder.AfZ.setVisibility(0);
              parambi = ah.dXB();
              localObject3 = paramBaseViewHolder.AMv;
              paramInt1 = this.mActivity.hashCode();
              localbk = bk.fvn();
              localbk.heF = paramTimeLineObject.CreateTime;
              parambi.a((bzh)localObject2, (View)localObject3, 2131689581, paramInt1, localbk);
              localObject2 = localObject1;
              if (bu.isNullOrNil((String)localObject2)) {
                break label2571;
              }
              paramBaseViewHolder.AMw.setVisibility(0);
              paramBaseViewHolder.AMw.setText((CharSequence)localObject2);
              if (bu.isNullOrNil(parambh)) {
                break label2629;
              }
              if (paramBaseViewHolder.AMw.getVisibility() != 8) {
                break label2583;
              }
              if (paramBaseViewHolder.AMx != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
            }
          }
          for (paramBaseViewHolder.AMx = 2;; paramBaseViewHolder.AMx = 1)
          {
            paramBaseViewHolder.titleTv.setVisibility(0);
            if (i == 0) {
              break label2607;
            }
            paramBaseViewHolder.titleTv.setText(r.a(parambh, this.mActivity, paramBaseViewHolder.titleTv));
            AppMethodBeat.o(100090);
            return;
            if (paramTimeLineObject.HUG.Gtw == 9)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHq);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 10)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHs);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 17)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHt);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 22)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHu);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 23)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHv);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 14)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHr);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 12)
            {
              if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHA);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 13)
            {
              if (paramTimeLineObject.HUG.Gtx.size() > 0)
              {
                paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHB);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.Aza.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 30)
            {
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHy);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HUG.Gtw == 26)
            {
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AHC);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if ((paramTimeLineObject.HUG.Gtw == 28) || (paramTimeLineObject.HUG.Gtw == 29))
            {
              paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AyK);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramBaseViewHolder.Aza.setTag(new s(paramTimeLineObject, (String)localObject1));
            paramBaseViewHolder.Aza.setOnClickListener(parambh.Asj.AyK);
            if ((paramTimeLineObject.hCH & 0x1) <= 0) {
              break label2691;
            }
            paramInt1 = 0;
            i = 1;
            break;
            parambh.egu().c(paramBaseViewHolder.Aza, parambh.zGs.AQb, parambh.zGs.APL);
            break label106;
            if ((ao.a.dYj() & 0x1) <= 0)
            {
              j = 1;
              break label122;
            }
            j = 0;
            break label122;
            parambi = "";
            break label139;
            if (paramTimeLineObject.HUG.Gtw == 18)
            {
              paramBaseViewHolder.AfZ.setVisibility(0);
              paramBaseViewHolder.AfZ.setImageResource(2131691166);
              paramBaseViewHolder.AMv.setVisibility(0);
              parambh = ah.dXB();
              localObject3 = paramBaseViewHolder.AMv;
              paramInt1 = this.mActivity.hashCode();
              localbk = bk.fvn();
              localbk.heF = paramTimeLineObject.CreateTime;
              parambh.a((bzh)localObject2, (View)localObject3, 2131689581, paramInt1, localbk);
              localObject2 = localObject1;
              parambh = parambi;
              break label422;
            }
            if ((paramTimeLineObject.HUM != null) && (paramTimeLineObject.HUM.path != null) && (paramTimeLineObject.HUM.subType == 1))
            {
              paramBaseViewHolder.AfZ.setImageResource(2131691166);
              paramBaseViewHolder.AfZ.setVisibility(0);
            }
            if ((paramTimeLineObject.zFh != null) && (!bu.isNullOrNil(paramTimeLineObject.zFh.DTD)))
            {
              paramBaseViewHolder.AfZ.setImageResource(2131691166);
              paramBaseViewHolder.AfZ.setVisibility(0);
            }
            if ((paramTimeLineObject.HUG.GtA != null) && (paramTimeLineObject.HUG.GtA.hFR == 5))
            {
              paramBaseViewHolder.AfZ.setImageResource(2131691166);
              paramBaseViewHolder.AfZ.setVisibility(0);
            }
            parambh = ah.dXB();
            localObject3 = paramBaseViewHolder.AMv;
            paramInt1 = this.mActivity.hashCode();
            localbk = bk.fvn();
            localbk.heF = paramTimeLineObject.CreateTime;
            parambh.b((bzh)localObject2, (View)localObject3, paramInt1, localbk);
            localObject2 = localObject1;
            parambh = parambi;
            break label422;
            if (paramTimeLineObject.HUG.Gtw == 18)
            {
              paramBaseViewHolder.AfZ.setVisibility(0);
              paramBaseViewHolder.AfZ.setImageResource(2131691166);
              paramBaseViewHolder.AMv.setVisibility(0);
              ah.dXB().d(paramBaseViewHolder.AMv, -1, 2131689581, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambh = parambi;
              break label422;
            }
            if (paramTimeLineObject.HUG.Gtw == 26)
            {
              paramBaseViewHolder.AMv.setVisibility(0);
              ah.dXB().d(paramBaseViewHolder.AMv, -1, 2131690949, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambh = parambi;
              break label422;
            }
            if (paramTimeLineObject.HUG.Gtw == 28)
            {
              localObject2 = localObject1;
              parambh = parambi;
              if (paramTimeLineObject.HUG.GtB == null) {
                break label422;
              }
              if ((((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 0) == 0))
              {
                if ((!bu.isNullOrNil(paramTimeLineObject.HUG.GtB.nickname)) || (bu.isNullOrNil(paramTimeLineObject.HUG.GtB.desc))) {
                  break label2135;
                }
                parambi = paramTimeLineObject.HUG.GtB.desc;
              }
              for (;;)
              {
                paramBaseViewHolder.AMv.setVisibility(0);
                localObject2 = localObject1;
                parambh = parambi;
                if (paramTimeLineObject.HUG.GtB.mediaList.isEmpty()) {
                  break;
                }
                parambh = new bzh();
                parambh.Url = ((arx)paramTimeLineObject.HUG.GtB.mediaList.get(0)).thumbUrl;
                parambh.Hmj = ((arx)paramTimeLineObject.HUG.GtB.mediaList.get(0)).thumbUrl;
                parambh.nJA = 2;
                parambh.Hmk = 1;
                parambh.Hmm = new bzj();
                parambh.GXH = 1;
                parambh.Hmm.Hna = ((arx)paramTimeLineObject.HUG.GtB.mediaList.get(0)).width;
                parambh.Hmm.Hnb = ((arx)paramTimeLineObject.HUG.GtB.mediaList.get(0)).height;
                parambh.Id = ((p)localObject3).getSnsId();
                localObject2 = ah.dXB();
                localObject3 = paramBaseViewHolder.AMv;
                paramInt1 = this.mActivity.hashCode();
                localbk = bk.fvn();
                localbk.heF = paramTimeLineObject.CreateTime;
                ((com.tencent.mm.plugin.sns.model.g)localObject2).b(parambh, (View)localObject3, paramInt1, localbk);
                localObject2 = localObject1;
                parambh = parambi;
                break;
                if (!bu.isNullOrNil(paramTimeLineObject.HUG.GtB.desc)) {
                  parambi = paramTimeLineObject.HUG.GtB.nickname + ": " + paramTimeLineObject.HUG.GtB.desc;
                } else {
                  parambi = this.mActivity.getString(2131763973, new Object[] { paramTimeLineObject.HUG.GtB.nickname });
                }
              }
            }
            if (paramTimeLineObject.HUG.Gtw == 29)
            {
              localObject2 = localObject1;
              parambh = parambi;
              if (paramTimeLineObject.HUG.GtC == null) {
                break label422;
              }
              parambi = this.mActivity.getString(2131755778);
              if (paramTimeLineObject.HUG.GtC != null) {
                if (paramTimeLineObject.HUG.GtC.sXu != 1) {
                  break label2517;
                }
              }
              for (parambi = ak.getContext().getString(2131763974, new Object[] { paramTimeLineObject.HUG.GtC.dBe });; parambi = paramTimeLineObject.HUG.GtC.dBe)
              {
                paramBaseViewHolder.AMv.setVisibility(0);
                if (!bu.isNullOrNil(paramTimeLineObject.HUG.GtC.iconUrl))
                {
                  parambh = new bzh();
                  parambh.Url = paramTimeLineObject.HUG.GtC.iconUrl;
                  parambh.Hmj = paramTimeLineObject.HUG.GtC.iconUrl;
                  parambh.nJA = 2;
                  parambh.Hmk = 1;
                  parambh.Hmm = new bzj();
                  parambh.GXH = 1;
                  parambh.Hmm.Hna = 0.0F;
                  parambh.Hmm.Hnb = 0.0F;
                  parambh.Id = ((p)localObject3).getSnsId();
                  localObject1 = ah.dXB();
                  localObject2 = paramBaseViewHolder.AMv;
                  paramInt1 = this.mActivity.hashCode();
                  localObject3 = bk.fvn();
                  ((bk)localObject3).heF = paramTimeLineObject.CreateTime;
                  ((com.tencent.mm.plugin.sns.model.g)localObject1).b(parambh, (View)localObject2, paramInt1, (bk)localObject3);
                }
                localObject2 = paramTimeLineObject.HUG.GtC.desc;
                parambh = parambi;
                break;
              }
            }
            paramBaseViewHolder.AMv.setVisibility(0);
            ah.dXB().d(paramBaseViewHolder.AMv, -1, 2131689584, this.mActivity.hashCode());
            localObject2 = localObject1;
            parambh = parambi;
            break label422;
            paramBaseViewHolder.AMw.setVisibility(8);
            break label447;
            if (paramBaseViewHolder.AMx != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
          }
          paramBaseViewHolder.titleTv.setText(k.c(this.mActivity, parambh));
          AppMethodBeat.o(100090);
          return;
          if (paramInt2 == 1)
          {
            paramBaseViewHolder.titleTv.setText(bh.aCj(paramTimeLineObject.HUG.Url));
            paramBaseViewHolder.titleTv.setVisibility(0);
            AppMethodBeat.o(100090);
            return;
          }
          paramBaseViewHolder.titleTv.setVisibility(8);
          AppMethodBeat.o(100090);
          return;
        }
      }
      label2517:
      paramInt1 = 0;
      label2571:
      label2583:
      label2607:
      label2629:
      i = 0;
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100089);
    if ((paramBaseViewHolder.AMs != null) && (paramBaseViewHolder.AMs.getParent() != null))
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495568);
      if (!paramBaseViewHolder.ANg) {
        paramBaseViewHolder.ANh = paramBaseViewHolder.AMs.inflate();
      }
    }
    for (paramBaseViewHolder.ANg = true;; paramBaseViewHolder.ANg = true)
    {
      paramBaseViewHolder.Aza = paramBaseViewHolder.ANh;
      paramBaseViewHolder.AMv = ((TagImageView)paramBaseViewHolder.Aza.findViewById(2131300948));
      paramBaseViewHolder.AfZ = ((ImageView)paramBaseViewHolder.Aza.findViewById(2131305185));
      paramBaseViewHolder.AMw = ((TextView)paramBaseViewHolder.Aza.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.Aza.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100711));
      r.b(paramBaseViewHolder.AMv, this.mActivity);
      AppMethodBeat.o(100089);
      return;
      paramBaseViewHolder.ANh = paramBaseViewHolder.uan.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */