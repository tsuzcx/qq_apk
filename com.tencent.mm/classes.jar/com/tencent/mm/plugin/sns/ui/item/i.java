package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class i
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.Avf.setPosition(paramInt1);
    Object localObject1 = parambi.zQD;
    Object localObject3 = parambi.yVM;
    paramInt1 = 0;
    int i;
    if (parambi.zOM)
    {
      if (((p)localObject3).dRL().zwi == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.AhO.setTag(paramBaseViewHolder);
        paramBaseViewHolder.AhO.setOnClickListener(parambh.zpd.Azh);
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
        parambh.ecN().c(paramBaseViewHolder.AhO, parambh.zpd.AyJ, parambh.zpd.Ayq);
        if (paramTimeLineObject.HAT.GaP != 9) {
          break label1344;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1364;
        }
        parambi = bh.aAS(paramTimeLineObject.HAT.Url);
        label139:
        if ((paramTimeLineObject.HAT.GaP == 9) || (paramTimeLineObject.HAT.GaP == 14) || (paramTimeLineObject.HAT.GaP == 12) || (paramTimeLineObject.HAT.GaP == 13) || (paramInt1 != 0)) {
          parambi = paramTimeLineObject.HAT.Desc;
        }
        if ((paramTimeLineObject.HAT.GaT == null) || (paramTimeLineObject.HAT.GaT.hzk != 1)) {
          break label2685;
        }
      }
      label422:
      label447:
      label1344:
      label1364:
      label2135:
      label2685:
      for (localObject1 = aj.getContext().getString(2131761345);; localObject1 = parambi)
      {
        parambi = paramTimeLineObject.HAT.Title;
        if ((parambi != null) && (parambi.length() > 40)) {
          parambi = parambi.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.zOS.setVisibility(8);
          Object localObject2;
          bj localbj;
          if (!paramTimeLineObject.HAT.GaQ.isEmpty())
          {
            paramBaseViewHolder.Avf.setVisibility(0);
            localObject2 = (byn)paramTimeLineObject.HAT.GaQ.get(0);
            if (paramTimeLineObject.HAT.GaP == 5)
            {
              parambh = ((byn)localObject2).Title;
              paramBaseViewHolder.zOS.setImageResource(2131691166);
              paramBaseViewHolder.zOS.setVisibility(0);
              parambi = ag.dUb();
              localObject3 = paramBaseViewHolder.Avf;
              paramInt1 = this.mActivity.hashCode();
              localbj = bj.frn();
              localbj.hbR = paramTimeLineObject.CreateTime;
              parambi.a((byn)localObject2, (View)localObject3, 2131689581, paramInt1, localbj);
              localObject2 = localObject1;
              if (bt.isNullOrNil((String)localObject2)) {
                break label2571;
              }
              paramBaseViewHolder.Avg.setVisibility(0);
              paramBaseViewHolder.Avg.setText((CharSequence)localObject2);
              if (bt.isNullOrNil(parambh)) {
                break label2629;
              }
              if (paramBaseViewHolder.Avg.getVisibility() != 8) {
                break label2583;
              }
              if (paramBaseViewHolder.Avh != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
            }
          }
          for (paramBaseViewHolder.Avh = 2;; paramBaseViewHolder.Avh = 1)
          {
            paramBaseViewHolder.titleTv.setVisibility(0);
            if (i == 0) {
              break label2607;
            }
            paramBaseViewHolder.titleTv.setText(q.a(parambh, this.mActivity, paramBaseViewHolder.titleTv));
            AppMethodBeat.o(100090);
            return;
            if (paramTimeLineObject.HAT.GaP == 9)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqc);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 10)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqe);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 17)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqf);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 22)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqg);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 23)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqh);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 14)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqd);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 12)
            {
              if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqm);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 13)
            {
              if (paramTimeLineObject.HAT.GaQ.size() > 0)
              {
                paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqn);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.AhO.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 30)
            {
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqk);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.HAT.GaP == 26)
            {
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Aqo);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if ((paramTimeLineObject.HAT.GaP == 28) || (paramTimeLineObject.HAT.GaP == 29))
            {
              paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Ahy);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramBaseViewHolder.AhO.setTag(new s(paramTimeLineObject, (String)localObject1));
            paramBaseViewHolder.AhO.setOnClickListener(parambh.AaW.Ahy);
            if ((paramTimeLineObject.hzT & 0x1) <= 0) {
              break label2691;
            }
            paramInt1 = 0;
            i = 1;
            break;
            parambh.ecN().c(paramBaseViewHolder.AhO, parambh.zpd.AyF, parambh.zpd.Ayq);
            break label106;
            if ((an.a.dUJ() & 0x1) <= 0)
            {
              j = 1;
              break label122;
            }
            j = 0;
            break label122;
            parambi = "";
            break label139;
            if (paramTimeLineObject.HAT.GaP == 18)
            {
              paramBaseViewHolder.zOS.setVisibility(0);
              paramBaseViewHolder.zOS.setImageResource(2131691166);
              paramBaseViewHolder.Avf.setVisibility(0);
              parambh = ag.dUb();
              localObject3 = paramBaseViewHolder.Avf;
              paramInt1 = this.mActivity.hashCode();
              localbj = bj.frn();
              localbj.hbR = paramTimeLineObject.CreateTime;
              parambh.a((byn)localObject2, (View)localObject3, 2131689581, paramInt1, localbj);
              localObject2 = localObject1;
              parambh = parambi;
              break label422;
            }
            if ((paramTimeLineObject.HAZ != null) && (paramTimeLineObject.HAZ.path != null) && (paramTimeLineObject.HAZ.subType == 1))
            {
              paramBaseViewHolder.zOS.setImageResource(2131691166);
              paramBaseViewHolder.zOS.setVisibility(0);
            }
            if ((paramTimeLineObject.znS != null) && (!bt.isNullOrNil(paramTimeLineObject.znS.DBG)))
            {
              paramBaseViewHolder.zOS.setImageResource(2131691166);
              paramBaseViewHolder.zOS.setVisibility(0);
            }
            if ((paramTimeLineObject.HAT.GaT != null) && (paramTimeLineObject.HAT.GaT.hCZ == 5))
            {
              paramBaseViewHolder.zOS.setImageResource(2131691166);
              paramBaseViewHolder.zOS.setVisibility(0);
            }
            parambh = ag.dUb();
            localObject3 = paramBaseViewHolder.Avf;
            paramInt1 = this.mActivity.hashCode();
            localbj = bj.frn();
            localbj.hbR = paramTimeLineObject.CreateTime;
            parambh.b((byn)localObject2, (View)localObject3, paramInt1, localbj);
            localObject2 = localObject1;
            parambh = parambi;
            break label422;
            if (paramTimeLineObject.HAT.GaP == 18)
            {
              paramBaseViewHolder.zOS.setVisibility(0);
              paramBaseViewHolder.zOS.setImageResource(2131691166);
              paramBaseViewHolder.Avf.setVisibility(0);
              ag.dUb().d(paramBaseViewHolder.Avf, -1, 2131689581, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambh = parambi;
              break label422;
            }
            if (paramTimeLineObject.HAT.GaP == 26)
            {
              paramBaseViewHolder.Avf.setVisibility(0);
              ag.dUb().d(paramBaseViewHolder.Avf, -1, 2131690949, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambh = parambi;
              break label422;
            }
            if (paramTimeLineObject.HAT.GaP == 28)
            {
              localObject2 = localObject1;
              parambh = parambi;
              if (paramTimeLineObject.HAT.GaU == null) {
                break label422;
              }
              if ((((t)g.ad(t.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAv, 0) == 0))
              {
                if ((!bt.isNullOrNil(paramTimeLineObject.HAT.GaU.nickname)) || (bt.isNullOrNil(paramTimeLineObject.HAT.GaU.desc))) {
                  break label2135;
                }
                parambi = paramTimeLineObject.HAT.GaU.desc;
              }
              for (;;)
              {
                paramBaseViewHolder.Avf.setVisibility(0);
                localObject2 = localObject1;
                parambh = parambi;
                if (paramTimeLineObject.HAT.GaU.mediaList.isEmpty()) {
                  break;
                }
                parambh = new byn();
                parambh.Url = ((ari)paramTimeLineObject.HAT.GaU.mediaList.get(0)).thumbUrl;
                parambh.GSI = ((ari)paramTimeLineObject.HAT.GaU.mediaList.get(0)).thumbUrl;
                parambh.nEf = 2;
                parambh.GSJ = 1;
                parambh.GSL = new byp();
                parambh.GEe = 1;
                parambh.GSL.GTz = ((ari)paramTimeLineObject.HAT.GaU.mediaList.get(0)).width;
                parambh.GSL.GTA = ((ari)paramTimeLineObject.HAT.GaU.mediaList.get(0)).height;
                parambh.Id = ((p)localObject3).getSnsId();
                localObject2 = ag.dUb();
                localObject3 = paramBaseViewHolder.Avf;
                paramInt1 = this.mActivity.hashCode();
                localbj = bj.frn();
                localbj.hbR = paramTimeLineObject.CreateTime;
                ((f)localObject2).b(parambh, (View)localObject3, paramInt1, localbj);
                localObject2 = localObject1;
                parambh = parambi;
                break;
                if (!bt.isNullOrNil(paramTimeLineObject.HAT.GaU.desc)) {
                  parambi = paramTimeLineObject.HAT.GaU.nickname + ": " + paramTimeLineObject.HAT.GaU.desc;
                } else {
                  parambi = this.mActivity.getString(2131763973, new Object[] { paramTimeLineObject.HAT.GaU.nickname });
                }
              }
            }
            if (paramTimeLineObject.HAT.GaP == 29)
            {
              localObject2 = localObject1;
              parambh = parambi;
              if (paramTimeLineObject.HAT.GaV == null) {
                break label422;
              }
              parambi = this.mActivity.getString(2131755778);
              if (paramTimeLineObject.HAT.GaV != null) {
                if (paramTimeLineObject.HAT.GaV.sMj != 1) {
                  break label2517;
                }
              }
              for (parambi = aj.getContext().getString(2131763974, new Object[] { paramTimeLineObject.HAT.GaV.dzZ });; parambi = paramTimeLineObject.HAT.GaV.dzZ)
              {
                paramBaseViewHolder.Avf.setVisibility(0);
                if (!bt.isNullOrNil(paramTimeLineObject.HAT.GaV.iconUrl))
                {
                  parambh = new byn();
                  parambh.Url = paramTimeLineObject.HAT.GaV.iconUrl;
                  parambh.GSI = paramTimeLineObject.HAT.GaV.iconUrl;
                  parambh.nEf = 2;
                  parambh.GSJ = 1;
                  parambh.GSL = new byp();
                  parambh.GEe = 1;
                  parambh.GSL.GTz = 0.0F;
                  parambh.GSL.GTA = 0.0F;
                  parambh.Id = ((p)localObject3).getSnsId();
                  localObject1 = ag.dUb();
                  localObject2 = paramBaseViewHolder.Avf;
                  paramInt1 = this.mActivity.hashCode();
                  localObject3 = bj.frn();
                  ((bj)localObject3).hbR = paramTimeLineObject.CreateTime;
                  ((f)localObject1).b(parambh, (View)localObject2, paramInt1, (bj)localObject3);
                }
                localObject2 = paramTimeLineObject.HAT.GaV.desc;
                parambh = parambi;
                break;
              }
            }
            paramBaseViewHolder.Avf.setVisibility(0);
            ag.dUb().d(paramBaseViewHolder.Avf, -1, 2131689584, this.mActivity.hashCode());
            localObject2 = localObject1;
            parambh = parambi;
            break label422;
            paramBaseViewHolder.Avg.setVisibility(8);
            break label447;
            if (paramBaseViewHolder.Avh != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
          }
          paramBaseViewHolder.titleTv.setText(k.c(this.mActivity, parambh));
          AppMethodBeat.o(100090);
          return;
          if (paramInt2 == 1)
          {
            paramBaseViewHolder.titleTv.setText(bh.aAS(paramTimeLineObject.HAT.Url));
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
    if ((paramBaseViewHolder.Avc != null) && (paramBaseViewHolder.Avc.getParent() != null))
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495568);
      if (!paramBaseViewHolder.AvP) {
        paramBaseViewHolder.AvQ = paramBaseViewHolder.Avc.inflate();
      }
    }
    for (paramBaseViewHolder.AvP = true;; paramBaseViewHolder.AvP = true)
    {
      paramBaseViewHolder.AhO = paramBaseViewHolder.AvQ;
      paramBaseViewHolder.Avf = ((TagImageView)paramBaseViewHolder.AhO.findViewById(2131300948));
      paramBaseViewHolder.zOS = ((ImageView)paramBaseViewHolder.AhO.findViewById(2131305185));
      paramBaseViewHolder.Avg = ((TextView)paramBaseViewHolder.AhO.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.AhO.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100711));
      q.b(paramBaseViewHolder.Avf, this.mActivity);
      AppMethodBeat.o(100089);
      return;
      paramBaseViewHolder.AvQ = paramBaseViewHolder.tPw.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.i
 * JD-Core Version:    0.7.0.1
 */