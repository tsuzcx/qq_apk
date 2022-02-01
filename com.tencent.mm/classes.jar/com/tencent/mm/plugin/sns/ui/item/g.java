package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class g
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.xQz.setPosition(paramInt1);
    Object localObject1 = parambf.xmu;
    Object localObject3 = parambf.wvM;
    paramInt1 = 0;
    int i;
    if (parambf.xkI)
    {
      if (((p)localObject3).dxs().wTw == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.xDE.setTag(paramBaseViewHolder);
        paramBaseViewHolder.xDE.setOnClickListener(parambe.wMy.xUi);
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
        parambe.dCa().c(paramBaseViewHolder.xDE, parambe.wMy.xTM, parambe.wMy.xTt);
        if (paramTimeLineObject.Etm.DaB != 9) {
          break label1344;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1364;
        }
        parambf = be.aqC(paramTimeLineObject.Etm.Url);
        label139:
        if ((paramTimeLineObject.Etm.DaB == 9) || (paramTimeLineObject.Etm.DaB == 14) || (paramTimeLineObject.Etm.DaB == 12) || (paramTimeLineObject.Etm.DaB == 13) || (paramInt1 != 0)) {
          parambf = paramTimeLineObject.Etm.Desc;
        }
        if ((paramTimeLineObject.Etm.DaF == null) || (paramTimeLineObject.Etm.DaF.gGA != 1)) {
          break label2685;
        }
      }
      label422:
      label447:
      label1344:
      label1364:
      label2135:
      label2685:
      for (localObject1 = aj.getContext().getString(2131761345);; localObject1 = parambf)
      {
        parambf = paramTimeLineObject.Etm.Title;
        if ((parambf != null) && (parambf.length() > 40)) {
          parambf = parambf.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.xkO.setVisibility(8);
          Object localObject2;
          bc localbc;
          if (!paramTimeLineObject.Etm.DaC.isEmpty())
          {
            paramBaseViewHolder.xQz.setVisibility(0);
            localObject2 = (bpi)paramTimeLineObject.Etm.DaC.get(0);
            if (paramTimeLineObject.Etm.DaB == 5)
            {
              parambe = ((bpi)localObject2).Title;
              paramBaseViewHolder.xkO.setImageResource(2131234474);
              paramBaseViewHolder.xkO.setVisibility(0);
              parambf = af.dtr();
              localObject3 = paramBaseViewHolder.xQz;
              paramInt1 = this.mActivity.hashCode();
              localbc = bc.eLG();
              localbc.tGD = paramTimeLineObject.CreateTime;
              parambf.a((bpi)localObject2, (View)localObject3, 2131689581, paramInt1, localbc);
              localObject2 = localObject1;
              if (bt.isNullOrNil((String)localObject2)) {
                break label2571;
              }
              paramBaseViewHolder.xQA.setVisibility(0);
              paramBaseViewHolder.xQA.setText((CharSequence)localObject2);
              if (bt.isNullOrNil(parambe)) {
                break label2629;
              }
              if (paramBaseViewHolder.xQA.getVisibility() != 8) {
                break label2583;
              }
              if (paramBaseViewHolder.xQB != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
            }
          }
          for (paramBaseViewHolder.xQB = 2;; paramBaseViewHolder.xQB = 1)
          {
            paramBaseViewHolder.titleTv.setVisibility(0);
            if (i == 0) {
              break label2607;
            }
            paramBaseViewHolder.titleTv.setText(q.a(parambe, this.mActivity, paramBaseViewHolder.titleTv));
            AppMethodBeat.o(100090);
            return;
            if (paramTimeLineObject.Etm.DaB == 9)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLz);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 10)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLB);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 17)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLC);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 22)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLD);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 23)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLE);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 14)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLA);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 12)
            {
              if (paramTimeLineObject.Etm.DaC.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLJ);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 13)
            {
              if (paramTimeLineObject.Etm.DaC.size() > 0)
              {
                paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLK);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.xDE.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 30)
            {
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLH);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.Etm.DaB == 26)
            {
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xLL);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if ((paramTimeLineObject.Etm.DaB == 28) || (paramTimeLineObject.Etm.DaB == 29))
            {
              paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xDo);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramBaseViewHolder.xDE.setTag(new s(paramTimeLineObject, (String)localObject1));
            paramBaseViewHolder.xDE.setOnClickListener(parambe.xwM.xDo);
            if ((paramTimeLineObject.gHj & 0x1) <= 0) {
              break label2691;
            }
            paramInt1 = 0;
            i = 1;
            break;
            parambe.dCa().c(paramBaseViewHolder.xDE, parambe.wMy.xTI, parambe.wMy.xTt);
            break label106;
            if ((am.a.dtY() & 0x1) <= 0)
            {
              j = 1;
              break label122;
            }
            j = 0;
            break label122;
            parambf = "";
            break label139;
            if (paramTimeLineObject.Etm.DaB == 18)
            {
              paramBaseViewHolder.xkO.setVisibility(0);
              paramBaseViewHolder.xkO.setImageResource(2131234474);
              paramBaseViewHolder.xQz.setVisibility(0);
              parambe = af.dtr();
              localObject3 = paramBaseViewHolder.xQz;
              paramInt1 = this.mActivity.hashCode();
              localbc = bc.eLG();
              localbc.tGD = paramTimeLineObject.CreateTime;
              parambe.a((bpi)localObject2, (View)localObject3, 2131689581, paramInt1, localbc);
              localObject2 = localObject1;
              parambe = parambf;
              break label422;
            }
            if ((paramTimeLineObject.Ets != null) && (paramTimeLineObject.Ets.path != null) && (paramTimeLineObject.Ets.subType == 1))
            {
              paramBaseViewHolder.xkO.setImageResource(2131234474);
              paramBaseViewHolder.xkO.setVisibility(0);
            }
            if ((paramTimeLineObject.wLn != null) && (!bt.isNullOrNil(paramTimeLineObject.wLn.AGs)))
            {
              paramBaseViewHolder.xkO.setImageResource(2131234474);
              paramBaseViewHolder.xkO.setVisibility(0);
            }
            if ((paramTimeLineObject.Etm.DaF != null) && (paramTimeLineObject.Etm.DaF.gKq == 5))
            {
              paramBaseViewHolder.xkO.setImageResource(2131234474);
              paramBaseViewHolder.xkO.setVisibility(0);
            }
            parambe = af.dtr();
            localObject3 = paramBaseViewHolder.xQz;
            paramInt1 = this.mActivity.hashCode();
            localbc = bc.eLG();
            localbc.tGD = paramTimeLineObject.CreateTime;
            parambe.b((bpi)localObject2, (View)localObject3, paramInt1, localbc);
            localObject2 = localObject1;
            parambe = parambf;
            break label422;
            if (paramTimeLineObject.Etm.DaB == 18)
            {
              paramBaseViewHolder.xkO.setVisibility(0);
              paramBaseViewHolder.xkO.setImageResource(2131234474);
              paramBaseViewHolder.xQz.setVisibility(0);
              af.dtr().c(paramBaseViewHolder.xQz, -1, 2131689581, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambe = parambf;
              break label422;
            }
            if (paramTimeLineObject.Etm.DaB == 26)
            {
              paramBaseViewHolder.xQz.setVisibility(0);
              af.dtr().c(paramBaseViewHolder.xQz, -1, 2131690949, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambe = parambf;
              break label422;
            }
            if (paramTimeLineObject.Etm.DaB == 28)
            {
              localObject2 = localObject1;
              parambe = parambf;
              if (paramTimeLineObject.Etm.DaG == null) {
                break label422;
              }
              if ((((j)com.tencent.mm.kernel.g.ad(j.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.prM, 0) == 0))
              {
                if ((!bt.isNullOrNil(paramTimeLineObject.Etm.DaG.nickname)) || (bt.isNullOrNil(paramTimeLineObject.Etm.DaG.desc))) {
                  break label2135;
                }
                parambf = paramTimeLineObject.Etm.DaG.desc;
              }
              for (;;)
              {
                paramBaseViewHolder.xQz.setVisibility(0);
                localObject2 = localObject1;
                parambe = parambf;
                if (paramTimeLineObject.Etm.DaG.mediaList.isEmpty()) {
                  break;
                }
                parambe = new bpi();
                parambe.Url = ((alc)paramTimeLineObject.Etm.DaG.mediaList.get(0)).thumbUrl;
                parambe.DMQ = ((alc)paramTimeLineObject.Etm.DaG.mediaList.get(0)).thumbUrl;
                parambe.mBH = 2;
                parambe.DMR = 1;
                parambe.DMT = new bpk();
                parambe.Dzl = 1;
                parambe.DMT.DNH = ((alc)paramTimeLineObject.Etm.DaG.mediaList.get(0)).width;
                parambe.DMT.DNI = ((alc)paramTimeLineObject.Etm.DaG.mediaList.get(0)).height;
                parambe.Id = ((p)localObject3).getSnsId();
                localObject2 = af.dtr();
                localObject3 = paramBaseViewHolder.xQz;
                paramInt1 = this.mActivity.hashCode();
                localbc = bc.eLG();
                localbc.tGD = paramTimeLineObject.CreateTime;
                ((f)localObject2).b(parambe, (View)localObject3, paramInt1, localbc);
                localObject2 = localObject1;
                parambe = parambf;
                break;
                if (!bt.isNullOrNil(paramTimeLineObject.Etm.DaG.desc)) {
                  parambf = paramTimeLineObject.Etm.DaG.nickname + ": " + paramTimeLineObject.Etm.DaG.desc;
                } else {
                  parambf = this.mActivity.getString(2131763973, new Object[] { paramTimeLineObject.Etm.DaG.nickname });
                }
              }
            }
            if (paramTimeLineObject.Etm.DaB == 29)
            {
              localObject2 = localObject1;
              parambe = parambf;
              if (paramTimeLineObject.Etm.DaH == null) {
                break label422;
              }
              parambf = this.mActivity.getString(2131755778);
              if (paramTimeLineObject.Etm.DaH != null) {
                if (paramTimeLineObject.Etm.DaH.qSS != 1) {
                  break label2517;
                }
              }
              for (parambf = aj.getContext().getString(2131763974, new Object[] { paramTimeLineObject.Etm.DaH.dqA });; parambf = paramTimeLineObject.Etm.DaH.dqA)
              {
                paramBaseViewHolder.xQz.setVisibility(0);
                if (!bt.isNullOrNil(paramTimeLineObject.Etm.DaH.iconUrl))
                {
                  parambe = new bpi();
                  parambe.Url = paramTimeLineObject.Etm.DaH.iconUrl;
                  parambe.DMQ = paramTimeLineObject.Etm.DaH.iconUrl;
                  parambe.mBH = 2;
                  parambe.DMR = 1;
                  parambe.DMT = new bpk();
                  parambe.Dzl = 1;
                  parambe.DMT.DNH = 0.0F;
                  parambe.DMT.DNI = 0.0F;
                  parambe.Id = ((p)localObject3).getSnsId();
                  localObject1 = af.dtr();
                  localObject2 = paramBaseViewHolder.xQz;
                  paramInt1 = this.mActivity.hashCode();
                  localObject3 = bc.eLG();
                  ((bc)localObject3).tGD = paramTimeLineObject.CreateTime;
                  ((f)localObject1).b(parambe, (View)localObject2, paramInt1, (bc)localObject3);
                }
                localObject2 = paramTimeLineObject.Etm.DaH.desc;
                parambe = parambf;
                break;
              }
            }
            paramBaseViewHolder.xQz.setVisibility(0);
            af.dtr().c(paramBaseViewHolder.xQz, -1, 2131689584, this.mActivity.hashCode());
            localObject2 = localObject1;
            parambe = parambf;
            break label422;
            paramBaseViewHolder.xQA.setVisibility(8);
            break label447;
            if (paramBaseViewHolder.xQB != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
          }
          paramBaseViewHolder.titleTv.setText(k.c(this.mActivity, parambe));
          AppMethodBeat.o(100090);
          return;
          if (paramInt2 == 1)
          {
            paramBaseViewHolder.titleTv.setText(be.aqC(paramTimeLineObject.Etm.Url));
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
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100089);
    if ((paramBaseViewHolder.xQw != null) && (paramBaseViewHolder.xQw.getParent() != null))
    {
      paramBaseViewHolder.xQw.setLayoutResource(2131495568);
      if (!paramBaseViewHolder.xRj) {
        paramBaseViewHolder.xRk = paramBaseViewHolder.xQw.inflate();
      }
    }
    for (paramBaseViewHolder.xRj = true;; paramBaseViewHolder.xRj = true)
    {
      paramBaseViewHolder.xDE = paramBaseViewHolder.xRk;
      paramBaseViewHolder.xQz = ((TagImageView)paramBaseViewHolder.xDE.findViewById(2131300948));
      paramBaseViewHolder.xkO = ((ImageView)paramBaseViewHolder.xDE.findViewById(2131305185));
      paramBaseViewHolder.xQA = ((TextView)paramBaseViewHolder.xDE.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.xDE.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100711));
      q.b(paramBaseViewHolder.xQz, this.mActivity);
      AppMethodBeat.o(100089);
      return;
      paramBaseViewHolder.xRk = paramBaseViewHolder.rLd.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */